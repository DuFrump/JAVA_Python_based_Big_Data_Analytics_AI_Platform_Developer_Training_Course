package com.example.newboard.service;

import com.example.newboard.domain.Article;
import com.example.newboard.repository.ArticleRepository;
import com.example.newboard.repository.UserRepository;
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 게시글(Article) 관련 비즈니스 로직을 처리하는 '서비스(Service)' 계층입니다.
 * 사용자 인증 정보(로그인한 사용자)를 활용하여, 게시글의 생성, 수정, 삭제 시 소유권을 확인하는 중요한 로직들이 추가되었습니다.
 */
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository; // 사용자 정보를 조회하기 위해 UserRepository를 주입받습니다.

    /**
     * 모든 게시글을 조회하는 메소드입니다.
     * @return 데이터베이스에 저장된 모든 Article의 리스트
     */
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 새로운 게시글을 생성하는 메소드입니다.
     * @Transactional: 이 메소드는 하나의 트랜잭션으로 묶입니다.
     *
     * @param req 게시글 생성에 필요한 정보 (제목, 내용)를 담은 DTO
     * @param email 현재 로그인한 사용자의 이메일 (작성자 정보)
     * @return 생성된 게시글의 ID
     */
    @Transactional
    public Long create(ArticleCreateRequest req, String email) {
        // 1. 전달받은 이메일로 작성자(User) 정보를 조회합니다.
        var author = userRepository.findByEmail(email)
                // 2. 만약 해당 이메일의 사용자가 존재하지 않으면, 예외를 발생시켜 작업을 중단합니다.
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));

        // 3. Article 엔티티를 생성하고, 조회된 작성자 정보를 설정하여 저장합니다.
        return articleRepository.save(
                Article.builder()
                        .title(req.getTitle())
                        .content(req.getContent())
                        .author(author) // 게시글의 작성자(author) 필드에 조회한 User 엔티티를 설정합니다.
                        .build()
        ).getId();
    }


    /**
     * ID로 특정 게시글 하나를 조회하는 메소드입니다.
     * @param id 조회할 게시글의 ID
     * @return ID에 해당하는 Article 객체
     */
    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found: " + id));
    }

    /**
     * 게시글을 수정하는 메소드입니다.
     * @Transactional: 이 메소드는 하나의 트랜잭션으로 묶입니다.
     *
     * @param id 수정할 게시글의 ID
     * @param email 현재 로그인한 사용자의 이메일
     * @param req 수정할 내용 (제목, 내용)을 담은 DTO
     */
    @Transactional
    public void update(Long id, String email, ArticleUpdateRequest req) {
        // 1. 게시글 ID와 사용자 이메일을 함께 사용하여, "본인이 작성한 특정 게시글"을 조회합니다.
        // 이 과정을 통해 다른 사람의 글을 수정하려는 시도를 원천적으로 차단할 수 있습니다.
        var article = articleRepository.findByIdAndAuthor_Email(id, email)
                // 2. 만약 조회된 게시글이 없다면(본인 글이 아니거나, 글이 없거나),
                // AccessDeniedException 예외를 발생시켜 권한 없음을 알립니다.
                .orElseThrow(() -> new AccessDeniedException("본인 글이 아닙니다."));

        // 3. JPA의 'Dirty Checking(변경 감지)' 기능을 활용하여 게시글을 수정합니다.
        // 트랜잭션 안에서 엔티티의 상태를 변경하면, 트랜잭션이 끝날 때 JPA가 변경 사항을 감지하여
        // 자동으로 UPDATE 쿼리를 실행해줍니다.
        article.update(req.getTitle(), req.getContent());
    }


    /**
     * 게시글을 삭제하는 메소드입니다.
     * @Transactional: 이 메소드는 하나의 트랜잭션으로 묶입니다.
     *
     * @param id 삭제할 게시글의 ID
     * @param email 현재 로그인한 사용자의 이메일
     */
    @Transactional
    public void delete(Long id, String email) {
        // 1. 게시글 ID와 사용자 이메일을 함께 사용하여, "본인이 작성한 특정 게시글"을 삭제합니다.
        // 이 메소드는 삭제된 행의 개수를 반환합니다.
        if (articleRepository.deleteByIdAndAuthor_Email(id, email) == 0) {
            // 2. 만약 삭제된 행이 0개라면 (본인 글이 아니거나, 글이 없거나),
            // AccessDeniedException 예외를 발생시켜 권한 없음을 알립니다.
            throw new AccessDeniedException("본인 글이 아닙니다.");
        }
    }
}
