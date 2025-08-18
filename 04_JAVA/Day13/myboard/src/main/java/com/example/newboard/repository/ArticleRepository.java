package com.example.newboard.repository;

import com.example.newboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 안녕하세요, 두프룸프님! 이 인터페이스는 Article 엔티티를 위한 '리포지토리(Repository)'입니다.
 * JpaRepository<Article, Long>를 상속받아 기본적인 CRUD 기능을 자동으로 제공받습니다.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * 게시글 ID와 작성자의 이메일을 함께 사용하여 게시글을 조회하는 커스텀 쿼리 메소드입니다.
     * Spring Data JPA는 메소드 이름을 분석하여 "ID가 일치하고, 연관된 Author(User)의 Email이 일치하는"
     * Article을 찾아주는 SQL 쿼리를 자동으로 생성합니다. (예: SELECT a FROM Article a WHERE a.id = :id AND a.author.email = :email)
     *
     * 이 메소드는 게시글을 수정하거나 삭제하기 전에,
     * 현재 로그인한 사용자가 정말 그 게시글의 소유주(작성자)가 맞는지 확인할 때 사용됩니다.
     * 이를 통해 다른 사용자의 게시글을 함부로 수정/삭제하는 것을 방지하는 중요한 보안 로직을 구현할 수 있습니다.
     *
     * @param id 조회할 게시글의 ID
     * @param email 현재 로그인한 사용자의 이메일
     * @return 조건에 맞는 게시글이 있다면 Optional<Article>을, 없다면 비어있는 Optional을 반환합니다.
     */
    Optional<Article> findByIdAndAuthor_Email(Long id, String email);

    /**
     * 게시글 ID와 작성자의 이메일을 함께 사용하여 게시글을 삭제하는 커스텀 쿼리 메소드입니다.
     * find와 마찬가지로, delete...By... 규칙에 따라 "ID와 작성자 이메일이 모두 일치하는" 게시글을
     * 삭제하는 쿼리를 자동으로 생성합니다.
     *
     * 이 메소드 또한 다른 사람의 게시글을 삭제하지 못하도록 하는 핵심적인 보안 장치 역할을 합니다.
     * 서비스 계층에서 이 메소드를 호출하면, 단 한 번의 쿼리로 소유권 확인과 삭제가 동시에 일어나므로 매우 효율적입니다.
     *
     * @param id 삭제할 게시글의 ID
     * @param email 현재 로그인한 사용자의 이메일
     * @return 삭제된 게시글의 수를 반환합니다. (정상적으로 1건이 삭제되면 1을 반환)
     */
    long deleteByIdAndAuthor_Email(Long id, String email);
}
