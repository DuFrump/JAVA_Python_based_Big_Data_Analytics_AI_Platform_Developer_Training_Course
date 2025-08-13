package com.example.newboard.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * 안녕하세요, 예비 개발자 두프룸프님! 이 클래스는 우리 게시판의 핵심 데이터 모델인 '게시글(Article)'을 정의하는 곳입니다.
 * 마치 게시글이라는 실체를 만들기 위한 '설계도'와 같다고 생각하시면 됩니다.
 * 데이터베이스에 있는 'article' 테이블과 직접적으로 연결되며, 이 클래스의 구조가 곧 테이블의 구조가 됩니다.
 *
 * @Entity 어노테이션은 "이 클래스는 데이터베이스 테이블과 매핑되는 클래스야!"라고 JPA에게 알려주는 이정표입니다.
 * JPA(Java Persistence API)는 자바 코드로 데이터베이스를 다룰 수 있게 해주는 기술 표준입니다.
 *
 * @Getter 어노테이션은 Lombok 라이브러리의 기능으로, 이 클래스의 모든 필드에 대한 'getter' 메소드를 자동으로 만들어줍니다.
 * 예를 들어, getTitle(), getContent() 같은 메소드들이 자동으로 생성되어 필드 값을 외부에서 읽을 수 있게 됩니다.
 *
 * @Setter 어노테이션 또한 Lombok의 기능으로, 모든 필드에 대한 'setter' 메소드를 자동으로 만들어줍니다.
 * setTitle(), setContent() 등이 생성되어 외부에서 필드 값을 변경할 수 있게 됩니다.
 * (참고: 실무에서는 엔티티의 안정성을 위해 @Setter를 무분별하게 사용하기보다는,
 * update() 메소드처럼 명확한 의도를 가진 메소드만 열어두는 것을 선호하기도 합니다.)
 *
 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
 * JPA는 내부적으로 엔티티 객체를 생성할 때 기본 생성자(파라미터가 없는 생성자)를 필요로 합니다.
 * 이 어노테이션이 바로 그 기본 생성자를 자동으로 만들어줍니다.
 * access = AccessLevel.PROTECTED 옵션은 "이 생성자는 JPA 같은 내부 기술을 위해 존재하니,
 * 우리 코드 안에서 함부로 new Article() 같이 직접 호출하지 말아줘!" 라는 의미의 안전장치입니다.
 *
 * @AllArgsConstructor(access = AccessLevel.PRIVATE)
 * 이 어노테이션은 모든 필드를 파라미터로 받는 생성자를 만들어줍니다.
 * 하지만 접근 수준을 PRIVATE으로 설정하여 외부에서 직접 이 생성자를 호출하는 것을 막고,
 * 오직 빌더 패턴(@Builder)을 통해서만 객체를 생성하도록 유도합니다.
 *
 * @Builder
 * '빌더 패턴'을 사용할 수 있게 해주는 Lombok 어노테이션입니다.
 * new Article(id, title, content) 처럼 생성자를 직접 호출하는 대신,
 * Article.builder().title("제목").content("내용").build() 와 같이
 * 보다 명확하고 유연하게 객체를 생성할 수 있게 도와줍니다.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Article {

    /**
     * @Id 어노테이션은 이 필드가 데이터베이스 테이블의 '기본 키(Primary Key, PK)'임을 나타냅니다.
     * 기본 키는 각 데이터를 유일하게 식별할 수 있는 고유한 값입니다. (예: 학번, 주민등록번호)
     */
    @Id
    /**
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * 이 어노테이션은 기본 키(PK)의 값을 데이터베이스가 자동으로 생성(Auto-increment)하도록 설정합니다.
     * strategy = GenerationType.IDENTITY 옵션은 MySQL, H2 등과 같은 데이터베이스에서 사용하는
     * 'AUTO_INCREMENT' 기능을 통해, 새 데이터가 추가될 때마다 ID 값이 1씩 자동으로 증가하게 만듭니다.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글의 고유 ID

    /**
     * @Column 어노테이션은 이 필드가 테이블의 '컬럼(column)'에 해당함을 나타냅니다.
     * 사실 모든 필드는 자동으로 컬럼이 되지만, 세부 설정을 위해 이 어노테이션을 사용합니다.
     * nullable = false : 이 컬럼은 null 값을 허용하지 않는다는 의미입니다. 즉, 제목은 반드시 있어야 합니다.
     * length = 200 : 이 컬럼의 최대 길이를 200자로 제한합니다. (VARCHAR(200))
     */
    @Column(nullable = false, length = 200)
    private String title; // 게시글 제목

    /**
     * @Lob 어노테이션은 'Large Object'의 약자로, 이 필드가 매우 큰 데이터를 담을 수 있는 타입임을 나타냅니다.
     * 일반적인 문자열보다 훨씬 긴 텍스트(예: 게시글 본문)를 저장하기 위해 사용하며,
     * 데이터베이스의 TEXT, CLOB 같은 타입으로 매핑됩니다.
     */
    @Lob
    @Column(nullable = false)
    private String content; // 게시글 내용

    /**
     * 기존 게시글의 제목과 내용을 수정하는 메소드입니다.
     * 서비스(Service) 계층에서 이 메소드를 호출하여 'Dirty Checking(변경 감지)' 기능을 통해
     * 데이터베이스에 업데이트 쿼리를 보낼 수 있습니다.
     * @Setter를 통해 각 필드를 따로 수정하는 것보다, 이렇게 명확한 의도를 가진 업데이트 전용 메소드를 만드는 것이
     * 객체의 일관성을 유지하는 데 더 좋은 설계 방식입니다.
     *
     * @param title 수정할 새로운 제목
     * @param content 수정할 새로운 내용
     */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
