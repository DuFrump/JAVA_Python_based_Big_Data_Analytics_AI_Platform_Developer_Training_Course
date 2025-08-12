package com.example.myboard.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Entity 어노테이션은 이 클래스가 데이터베이스의 테이블과 직접 매핑되는 '엔티티(Entity)' 클래스임을 나타냅니다.
 * JPA(Java Persistence API)가 이 클래스를 보고 데이터베이스에 'article'이라는 이름의 테이블을 생성하거나 연결합니다.
 * (클래스 이름을 카멜케이스에서 스네이크케이스로 자동 변환해줍니다. Article -> article)
 */
@Entity
/**
 * @Getter 어노테이션은 Lombok 라이브러리의 기능입니다.
 * 이 클래스의 모든 필드(id, title, content)에 대한 getter 메소드(getId(), getTitle(), getContent())를
 * 컴파일 시점에 자동으로 생성해줍니다. 코드가 훨씬 깔끔해지죠.
 */
@Getter
/**
 * @NoArgsConstructor 어노테이션도 Lombok의 기능입니다.
 * 파라미터가 없는 기본 생성자( new Article() )를 자동으로 생성해줍니다.
 * access = AccessLevel.PROTECTED 설정은 외부에서 무분별하게 이 생성자를 사용하는 것을 막아줍니다.
 * JPA는 엔티티를 생성할 때 기본 생성자가 필요하기 때문에, 안전하게 열어두는 것입니다.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/**
 * @AllArgsConstructor 어노테이션도 Lombok의 기능입니다.
 * 이 클래스의 모든 필드를 파라미터로 받는 생성자를 자동으로 생성해줍니다.
 * ( new Article(Long id, String title, String content) )
 */
@AllArgsConstructor
public class Article {

    /**
     * @Id 어노테이션은 이 필드가 테이블의 기본 키(Primary Key, PK)임을 나타냅니다.
     * 데이터베이스에서 각 레코드(row)를 고유하게 식별하는 값입니다.
     */
    @Id
    /**
     * @GeneratedValue 어노테이션은 기본 키(PK)의 값을 자동으로 생성하는 방법을 지정합니다.
     * strategy = GenerationType.IDENTITY 설정은 데이터베이스가 PK 값을 자동으로 증가시켜주도록 위임하는 방식입니다.
     * (예: MySQL의 AUTO_INCREMENT, H2의 IDENTITY)
     * 우리가 직접 id 값을 설정하지 않아도, 데이터베이스에 새로운 Article이 저장될 때마다 id가 1, 2, 3, ... 순서로 자동 부여됩니다.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * @Column 어노테이션은 이 필드가 테이블의 컬럼(column)에 매핑됨을 나타냅니다.
     * name = "id"는 테이블의 컬럼 이름을 'id'로 지정합니다.
     * updatable = false는 이 컬럼의 값은 한번 정해지면 변경될 수 없음을 의미합니다. id는 고유 식별자이므로 바뀌면 안 되겠죠?
     */
    @Column(name = "id", updatable = false)
    private Long id;

    /**
     * name = "title"은 테이블의 컬럼 이름을 'title'로 지정합니다.
     * nullable = false는 이 컬럼에 null 값이 들어갈 수 없음을 의미합니다. 즉, 제목은 항상 값이 있어야 합니다.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * name = "content"는 테이블의 컬럼 이름을 'content'로 지정합니다.
     * nullable = false는 이 컬럼에 null 값이 들어갈 수 없음을 의미합니다. 즉, 내용도 항상 값이 있어야 합니다.
     */
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * 게시글의 제목과 내용을 수정하는 메소드입니다.
     * 서비스(Service) 계층에서 이 메소드를 호출하여 엔티티의 상태를 변경합니다.
     * 이렇게 엔티티 내부에 비즈니스 로직(상태 변경)을 포함시키는 것을 '도메인 모델 패턴'이라고도 합니다.
     *
     * @param title 수정할 새로운 제목
     * @param content 수정할 새로운 내용
     */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}