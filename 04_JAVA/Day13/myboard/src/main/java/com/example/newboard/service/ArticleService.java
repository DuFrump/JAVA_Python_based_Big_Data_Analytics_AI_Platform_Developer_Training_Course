package com.example.newboard.service;

import com.example.newboard.domain.Article;
import com.example.newboard.repository.ArticleRepository;
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 안녕하세요, 두프룸프님! 드디어 애플리케이션의 '두뇌'에 해당하는 서비스 계층입니다.
 * 서비스(Service) 클래스는 애플리케이션의 핵심 비즈니스 로직을 처리하는 곳입니다.
 * '비즈니스 로직'이란, '게시글을 생성한다', '게시글을 수정한다'와 같이
 * 이 애플리케이션이 실제로 수행해야 하는 구체적인 작업들을 의미합니다.
 * 컨트롤러(Controller)로부터 요청을 받고, 리포지토리(Repository)를 통해 데이터를 처리하여
 * 실제 기능을 완성시키는 중요한 역할을 합니다.
 *
 * @Service 어노테이션은 "이 클래스는 비즈니스 로직을 담당하는 서비스 클래스야!"라고
 * 스프링에게 알려주는 역할을 합니다. 스프링은 이 클래스를 찾아서 '스프링 빈(Bean)'으로 등록하고 관리합니다.
 *
 * @RequiredArgsConstructor 어노테이션은 Lombok의 기능으로,
 * final 키워드가 붙은 필드(여기서는 articleRepository)를 위한 생성자를 자동으로 만들어줍니다.
 * 이를 통해 '생성자 주입' 방식으로 ArticleRepository의 구현체를 주입받게 됩니다.
 * 테스트가 용이하고, 순환 참조를 방지하는 등 여러 장점이 있어 가장 권장되는 의존성 주입 방식입니다.
 */
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    /**
     * 모든 게시글을 조회하여 반환합니다.
     * 특별한 비즈니스 로직 없이, 리포토리의 기능을 그대로 호출하는 간단한 예시입니다.
     * @return Article 엔티티의 리스트
     */
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 새로운 게시글을 생성합니다.
     *
     * @Transactional 어노테이션은 이 메소드가 하나의 '트랜잭션(Transaction)' 안에서 동작해야 함을 나타냅니다.
     * 트랜잭션은 '모두 성공하거나, 하나라도 실패하면 모두 실패해야 하는' 작업의 묶음 단위입니다.
     * 이 어노테이션 덕분에, 데이터를 저장하는 도중 오류가 발생하면 모든 작업이 없었던 일처럼 원상복구(rollback)되어
     * 데이터의 일관성과 안정성을 보장할 수 있습니다.
     *
     * @param req 컨트롤러로부터 전달받은 게시글 생성용 DTO
     */
    @Transactional
    public void create(ArticleCreateRequest req) {
        // 1. 전달받은 DTO(req)와 Article의 빌더 패턴을 사용하여 새로운 Article 엔티티를 생성합니다.
        // 2. articleRepository.save() 메소드를 호출하여 엔티티를 데이터베이스에 저장합니다.
        articleRepository.save(
                Article.builder()
                        .title(req.getTitle())
                        .content(req.getContent())
                        .build()
        );
    }

    /**
     * 특정 ID에 해당하는 게시글 하나를 조회합니다.
     * @param id 조회할 게시글의 ID
     * @return 조회된 Article 엔티티
     * @throws IllegalArgumentException 해당 ID의 게시글이 존재하지 않을 경우 예외를 발생시킵니다.
     */
    public Article findById(Long id) {
        // articleRepository.findById(id)는 Optional<Article>을 반환합니다.
        // Optional은 'null일 수도 있는 객체'를 감싸는 포장지 클래스입니다.
        // .orElseThrow() 메소드는 이 포장지를 열어보고,
        // - 내용물(Article 객체)이 있으면 그대로 반환하고,
        // - 내용물이 없으면(null이면) 괄호 안에 지정된 예외(여기서는 IllegalArgumentException)를 던집니다.
        // 이를 통해 'NPE(NullPointerException)'를 방지하는 안전한 코드를 작성할 수 있습니다.
        return articleRepository.findById(id)
                .orElseThrow((() -> new IllegalArgumentException("Article not found :" + id)));
    }

    /**
     * 특정 ID의 게시글을 수정합니다.
     *
     * @Transactional 어노테이션의 가장 큰 장점 중 하나인 'Dirty Checking(변경 감지)' 기능이 여기서 빛을 발합니다.
     * 1. 트랜잭션 안에서 findById(id)를 통해 데이터베이스로부터 Article 엔티티를 가져옵니다.
     *    이때 가져온 article 객체는 JPA가 계속 주시하고 있는 '영속성 컨텍스트' 안에 존재하게 됩니다.
     * 2. article.update(...) 메소드를 호출하여 article 객체의 내용을 변경합니다.
     * 3. 메소드가 종료되면, @Transactional 어но테이션이 트랜잭션을 커밋(commit)합니다.
     * 4. 이때 JPA는 "어? 내가 처음에 가져왔던 article 객체랑 지금 상태가 다르네?" 라는 것을 감지하고(Dirty Checking),
     *    자동으로 데이터베이스에 UPDATE 쿼리를 날려 변경된 내용을 반영해줍니다.
     *
     * 결론: articleRepository.save()를 다시 호출하지 않아도, JPA가 알아서 변경을 감지하고 업데이트해줍니다. 매우 편리하죠!
     *
     * @param id 수정할 게시글의 ID
     * @param req 컨트롤러로부터 전달받은 게시글 수정용 DTO
     */
    @Transactional
    public void update(Long id, ArticleUpdateRequest req) {
        var article = findById(id);
        article.update(req.getTitle(), req.getContent());
    }

    /**
     * 특정 ID의 게시글을 삭제합니다.
     * @param id 삭제할 게시글의 ID
     */
    @Transactional
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
