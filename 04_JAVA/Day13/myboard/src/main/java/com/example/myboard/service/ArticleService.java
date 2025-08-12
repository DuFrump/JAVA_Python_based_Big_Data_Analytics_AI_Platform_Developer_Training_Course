package com.example.myboard.service;

import com.example.myboard.domain.Article;
import com.example.myboard.dto.ArticleCreateRequest;
import com.example.myboard.dto.ArticleUpdateRequest;
import com.example.myboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Service 어노테이션은 이 클래스가 '서비스(Service)' 계층의 컴포넌트임을 나타냅니다.
 * 서비스 계층은 애플리케이션의 핵심 비즈니스 로직을 처리하는 부분입니다.
 * 예를 들어 '게시글을 생성한다', '게시글 목록을 조회한다'와 같은 실제 동작들을 여기서 구현합니다.
 * Spring은 @Service 어노테이션을 보고 이 클래스를 스프링 빈(Bean)으로 등록합니다.
 */
@Service
/**
 * @RequiredArgsConstructor 어노테이션은 Lombok의 기능입니다.
 * final 키워드가 붙은 필드를 모아서, 그 필드들을 파라미터로 받는 생성자를 자동으로 만들어줍니다.
 * 아래의 'private final ArticleRepository articleRepository;' 필드를 위한 생성자가 만들어지는 것이죠.
 *
 *   // @RequiredArgsConstructor가 만들어주는 생성자 예시:
 *   public ArticleService(ArticleRepository articleRepository) {
 *       this.articleRepository = articleRepository;
 *   }
 *
 * 이렇게 생성자를 통해 의존성을 주입받는 방식을 '생성자 주입(Constructor Injection)'이라고 하며,
 * Spring에서 가장 권장하는 의존성 주입(DI, Dependency Injection) 방식입니다.
 */
@RequiredArgsConstructor
public class ArticleService {

    // 'final' 키워드는 이 필드가 한번 초기화되면 다른 값으로 변경될 수 없음을 의미합니다. (불변성)
    // ArticleService는 ArticleRepository가 꼭 필요하므로, final로 선언하여 안정성을 높입니다.
    private final ArticleRepository articleRepository;

    /**
     * 새로운 게시글을 생성하고 데이터베이스에 저장합니다.
     *
     * @param request 컨트롤러(Controller)로부터 전달받은 게시글 생성 요청 데이터 (DTO)
     * @return 데이터베이스에 저장된 Article 엔티티
     */
    public Article save(ArticleCreateRequest request) {
        // DTO(ArticleCreateRequest)를 Entity(Article)로 변환한 후,
        // 리포지토리(articleRepository)를 통해 데이터베이스에 저장(save)합니다.
        return articleRepository.save(request.toEntity());
    }

    /**
     * 데이터베이스에 저장된 모든 게시글을 조회합니다.
     *
     * @return Article 엔티티의 리스트
     */
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 특정 ID를 가진 게시글 하나를 조회합니다.
     *
     * @param id 조회할 게시글의 ID
     * @return 조회된 Article 엔티티
     * @throws IllegalArgumentException 만약 해당 ID의 게시글이 존재하지 않을 경우 예외 발생
     */
    public Article findById(long id) {
        // articleRepository.findById(id)는 Optional<Article>을 반환합니다.
        // Optional은 값이 있을 수도, 없을 수도(null) 있는 객체를 감싸는 래퍼 클래스입니다.
        // .orElseThrow() 메소드는 Optional 안의 값이 존재하면 그 값을 반환하고,
        // 값이 없으면(null이면) 괄호 안에 지정된 예외를 발생시킵니다.
        // 여기서는 해당 id의 게시글이 없으면 IllegalArgumentException을 발생시킵니다.
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    /**
     * 특정 ID를 가진 게시글을 삭제합니다.
     *
     * @param id 삭제할 게시글의 ID
     */
    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    /**
     * 특정 ID를 가진 게시글의 내용을 수정합니다.
     * @Transactional 어노테이션은 이 메소드가 하나의 '트랜잭션(Transaction)' 안에서 동작해야 함을 나타냅니다.
     * 트랜잭션은 데이터베이스 작업을 처리하는 하나의 단위입니다.
     * 이 메소드 안의 모든 작업이 성공적으로 끝나야만 실제 데이터베이스에 변경사항이 영구적으로 반영(commit)됩니다.
     * 만약 중간에 오류가 발생하면, 모든 변경사항이 원래대로 되돌려집니다(rollback).
     * 이를 통해 데이터의 일관성과 안정성을 보장할 수 있습니다.
     *
     * Spring에서는 @Transactional이 붙은 메소드가 끝나면, JPA가 변경된 엔티티를 감지하여(Dirty Checking)
     * 자동으로 UPDATE 쿼리를 날려줍니다. 그래서 .save()를 명시적으로 호출하지 않아도 됩니다.
     *
     * @param id 수정할 게시글의 ID
     * @param request 컨트롤러로부터 전달받은 게시글 수정 요청 데이터 (DTO)
     * @return 수정이 완료된 Article 엔티티
     */
    @Transactional
    public Article update(long id, ArticleUpdateRequest request) {
        // 1. 수정할 게시글을 데이터베이스에서 조회합니다.
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        // 2. 조회된 Article 엔티티의 내용을, 요청받은 DTO의 내용으로 업데이트합니다.
        article.update(request.getTitle(), request.getContent());

        // 3. 메소드가 끝나면 @Transactional에 의해 변경된 내용이 자동으로 DB에 반영됩니다.
        return article;
    }
}