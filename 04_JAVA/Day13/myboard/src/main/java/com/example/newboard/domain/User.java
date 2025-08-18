package com.example.newboard.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 우리 애플리케이션의 '사용자'를 정의하는 User 엔티티입니다.
 * @Entity 어노테이션을 통해 이 클래스가 데이터베이스의 테이블과 직접 연결되는 설계도임을 JPA에게 알려줍니다.
 */
@Entity
/**
 * @Table 어노테이션을 사용하여 이 엔티티가 'users'라는 이름의 테이블에 매핑되도록 설정합니다.
 * uniqueConstraints 속성은 'email' 컬럼에 유니크 제약조건을 설정하여,
 * 동일한 이메일이 중복해서 저장되는 것을 데이터베이스 수준에서 방지합니다.
 */
@Table(name="users", uniqueConstraints=@UniqueConstraint(columnNames="email"))
@Getter // Lombok: 각 필드의 getter 메소드를 자동으로 생성합니다.
@NoArgsConstructor // Lombok: 파라미터가 없는 기본 생성자를 자동으로 생성합니다. JPA는 엔티티 생성 시 기본 생성자를 필요로 합니다.
@AllArgsConstructor // Lombok: 모든 필드를 인자로 받는 생성자를 자동으로 생성합니다.
@Builder // Lombok: 빌더 패턴을 사용하여 객체를 안전하고 유연하게 생성할 수 있게 합니다.
public class User {

    /**
     * @Id: 이 필드가 테이블의 기본 키(Primary Key)임을 나타냅니다.
     * @GeneratedValue(strategy=GenerationType.IDENTITY):
     * 기본 키 생성을 데이터베이스에게 위임하는 방식입니다. (예: MySQL의 AUTO_INCREMENT)
     * 데이터가 삽입될 때마다 데이터베이스가 자동으로 ID를 1씩 증가시켜 할당합니다.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     * @Column: 필드를 테이블의 컬럼에 매핑합니다.
     * nullable=false: 이 컬럼은 null 값을 허용하지 않습니다. (필수값)
     * length=100: 컬럼의 최대 길이를 100자로 제한합니다.
     */
    @Column(nullable=false, length=100)
    private String email;

    /**
     * 비밀번호 필드입니다.
     * nullable=false: 비밀번호는 필수값입니다.
     * length=60: 비밀번호는 BCrypt 해시 알고리즘을 사용하여 암호화될 예정이며,
     * 해시된 결과물은 보통 60자 정도의 길이를 가집니다.
     */
    @Column(nullable=false, length=60)
    private String password;

    /**
     * 사용자 이름 필드입니다.
     * nullable=false: 이름은 필수값입니다.
     * length=50: 최대 길이를 50자로 제한합니다.
     */
    @Column(nullable=false, length=50)
    private String name;

    /**
     * 사용자의 역할을 저장하는 필드입니다. (예: "USER", "ADMIN")
     * nullable=false: 역할은 필수값입니다.
     * length=20: 최대 길이를 20자로 제한합니다.
     */
    @Column(nullable=false, length=20)
    private String role;
}

