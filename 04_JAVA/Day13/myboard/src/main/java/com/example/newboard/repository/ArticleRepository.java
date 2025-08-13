package com.example.newboard.repository;

import com.example.newboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 안녕하세요, 두프룸프님! 이 인터페이스는 '리포지토리(Repository)'라고 불리는 데이터베이스 접근 계층입니다.
 * 서비스(Service) 계층과 데이터베이스를 연결하는 '다리' 역할을 하며,
 * 데이터베이스에 데이터를 저장(Create), 조회(Read), 수정(Update), 삭제(Delete)하는
 * CRUD 작업을 담당합니다.
 *
 * 인터페이스인데 어떻게 동작하냐구요? 바로 Spring Data JPA의 마법 덕분입니다!
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    /**
     * JpaRepository<Article, Long> 를 상속받는 것만으로도, Spring Data JPA는
     * 이 인터페이스에 대한 구현 클래스를 실행 시점에 동적으로 만들어줍니다.
     * 그리고 그 구현 클래스 안에는 다음과 같은 기본적인 CRUD 메소드들이 이미 모두 구현되어 있습니다.
     *
     * - save(Article) : 게시글 저장 (Create, Update)
     * - findById(Long id) : ID로 게시글 1건 조회 (Read)
     * - findAll() : 모든 게시글 조회 (Read)
     * - deleteById(Long id) : ID로 게시글 삭제 (Delete)
     * - count() : 전체 게시글 개수 조회
     * - 등등...
     *
     * JpaRepository<T, ID>의 제네릭 타입은 다음과 같은 의미를 가집니다.
     * - T : 이 리포지토리가 어떤 엔티티(Entity)를 관리할 것인지를 지정합니다. 여기서는 'Article' 클래스입니다.
     * - ID : 관리할 엔티티의 기본 키(Primary Key)의 타입을 지정합니다. Article 클래스의 id 필드는 'Long' 타입입니다.
     *
     * 따라서 우리는 이 인터페이스를 만들기만 하면, 기본적인 데이터베이스 작업은 코딩할 필요 없이
     * '주입(Injection)'받아서 바로 사용할 수 있게 됩니다. 정말 편리하죠?
     *
     * 만약 더 복잡한 조회가 필요하다면, 정해진 규칙에 따라 메소드를 선언하기만 해도
     * Spring Data JPA가 알아서 쿼리를 만들어주기도 합니다. (예: findByTitle(String title);)
     */
}

