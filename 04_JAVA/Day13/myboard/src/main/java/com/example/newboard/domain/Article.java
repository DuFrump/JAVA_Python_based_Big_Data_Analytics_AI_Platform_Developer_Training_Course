package com.example.newboard.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 게시판의 핵심인 '게시글(Article)'을 정의하는 엔티티입니다.
 * @Entity 어노테이션을 통해 이 클래스가 데이터베이스의 'article' 테이블과 연결되는 설계도임을 나타냅니다.
 */
@Entity
@Getter // Lombok: 필드의 getter 메소드를 자동 생성합니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok: JPA를 위한 기본 생성자를 생성합니다. PROTECTED로 설정하여 무분별한 객체 생성을 막습니다.
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Lombok: 빌더 패턴을 통한 객체 생성을 유도하기 위해 모든 필드를 받는 생성자는 PRIVATE으로 설정합니다.
@Builder // Lombok: 빌더 패턴을 사용하여 객체를 안전하고 유연하게 생성할 수 있게 합니다.
public class Article {

    /**
     * @Id: 테이블의 기본 키(Primary Key)입니다.
     * @GeneratedValue(strategy = GenerationType.IDENTITY): 기본 키 생성을 데이터베이스에게 위임합니다. (AUTO_INCREMENT)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @Column: 테이블의 컬럼에 매핑됩니다.
     * nullable = false: null 값을 허용하지 않습니다. (필수값)
     * length = 200: 컬럼의 최대 길이를 200자로 제한합니다.
     */
    @Column(nullable = false, length = 200)
    private String title;

    /**
     * @Lob: 'Large Object'를 의미하며, 매우 큰 데이터를 저장할 수 있는 타입입니다. (TEXT, CLOB)
     * @Column(nullable = false): 내용은 비어있을 수 없습니다.
     */
    @Lob
    @Column(nullable = false)
    private String content;

    /**
     * 게시글의 제목과 내용을 수정하는 메소드입니다.
     * @Setter를 사용하지 않고, 명확한 의도를 가진 메소드를 통해 객체의 상태를 변경하는 것이
     * 객체지향적으로 더 좋은 설계 방식입니다. (객체의 일관성 유지)
     *
     * @param title 수정할 새로운 제목
     * @param content 수정할 새로운 내용
     */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 게시글(Article)과 사용자(User) 사이의 '다대일(N:1)' 관계를 정의합니다.
     * "많은 게시글(Many)은 한 명의 사용자(One)에 의해 작성될 수 있다"
     *
     * @ManyToOne: 다대일 관계를 나타내는 어노테이션입니다.
     * fetch = FetchType.LAZY: '지연 로딩' 전략입니다. 게시글을 조회할 때 연관된 사용자 정보를 바로 가져오지 않고,
     * 실제로 그 정보가 필요한 시점(예: getAuthor() 호출)에 가져오도록 하여 성능을 최적화합니다.
     * optional = false: 이 관계는 필수적이라는 의미입니다. 모든 게시글은 반드시 작성자를 가져야 합니다.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    /**
     * @JoinColumn: 관계를 맺기 위한 외래 키(Foreign Key) 컬럼을 지정합니다.
     * name = "author_id": 'article' 테이블에 생성될 외래 키 컬럼의 이름입니다.
     * 이 컬럼에는 'users' 테이블의 id 값이 저장됩니다.
     * nullable = false: 이 외래 키 컬럼은 null일 수 없습니다.
     */
    @JoinColumn(name = "author_id", nullable = false)
    private User author;  // 게시글의 작성자. User 엔티티와 직접 연결됩니다.

}
