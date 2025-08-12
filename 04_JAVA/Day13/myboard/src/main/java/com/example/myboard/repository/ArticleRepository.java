package com.example.myboard.repository;

import com.example.myboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * '리포지토리(Repository)'는 데이터베이스에 접근하는 객체를 의미합니다.
 * 데이터베이스의 테이블에 CRUD(Create, Read, Update, Delete) 작업을 수행하는 역할을 하죠.
 *
 * 이 인터페이스는 Spring Data JPA가 제공하는 JpaRepository를 상속받고 있습니다.
 * JpaRepository<T, ID>는 두 개의 제네릭 타입을 받습니다.
 * 1. T: 어떤 엔티티(Entity)를 위한 리포지토리인가? -> 우리는 Article 엔티티를 다룰 것이므로 Article.class
 * 2. ID: 해당 엔티티의 기본 키(PK)의 타입은 무엇인가? -> Article 클래스에서 id 필드의 타입이 Long이므로 Long.class
 *
 * 정말 놀라운 점은, 이렇게 인터페이스를 선언하기만 하면 Spring Data JPA가
 * 자동으로 이 인터페이스의 구현체(실제 동작하는 코드)를 만들어서 스프링 빈(Bean)으로 등록해준다는 것입니다.
 *
 * 우리는 이 리포지토리를 다른 곳(예: ArticleService)에 주입받아서 바로 사용할 수 있습니다.
 *
 * JpaRepository를 상속받았기 때문에, 우리는 아래와 같은 기본적인 CRUD 메소드를 직접 작성하지 않아도
 * 바로 사용할 수 있습니다.
 * - save(): 레코드를 저장 (Create, Update)
 * - findById(): 기본 키(PK)로 레코드 한 건을 조회 (Read)
 * - findAll(): 모든 레코드를 조회 (Read)
 * - count(): 레코드의 개수를 조회
 * - delete(): 레코드를 삭제 (Delete)
 *
 * 만약 더 복잡한 쿼리가 필요하다면, 정해진 규칙에 따라 메소드를 추가로 선언할 수도 있습니다.
 * 예: findByTitle(String title); -> 제목으로 게시글을 찾는 쿼리를 자동으로 만들어줍니다.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}