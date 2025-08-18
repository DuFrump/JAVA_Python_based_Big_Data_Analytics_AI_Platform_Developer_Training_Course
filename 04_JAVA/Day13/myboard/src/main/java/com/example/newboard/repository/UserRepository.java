package com.example.newboard.repository;

import com.example.newboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * 안녕하세요, 두프룸프님! 이 인터페이스는 User 엔티티를 위한 '리포지토리(Repository)'입니다.
 * 리포지토리는 데이터베이스와 직접 통신하며 CRUD(Create, Read, Update, Delete) 작업을 처리하는
 * 데이터 접근 계층입니다.
 *
 * JpaRepository<User, Long>를 상속받는 것만으로, Spring Data JPA가 기본적인 데이터베이스 작업 메소드들을
 * 자동으로 생성해주어 우리는 복잡한 SQL 없이도 데이터 처리를 할 수 있습니다.
 */
public interface UserRepository extends JpaRepository<User, Long> { // <관리할 엔티티, 엔티티의 PK 타입>

    /**
     * Spring Data JPA의 '쿼리 메소드' 기능입니다.
     * 메소드 이름을 정해진 규칙에 따라 작성하면, 그에 맞는 JPQL(Java Persistence Query Language) 쿼리가 자동으로 생성됩니다.
     *
     * 'findByEmail'은 "Email 필드를 기준으로 User를 찾아라" 라는 의미의 쿼리로 변환됩니다.
     * (SELECT u FROM User u WHERE u.email = :email)
     *
     * @param email 조회할 사용자의 이메일
     * @return 조회된 사용자가 존재하면 해당 User 객체를 담은 Optional을, 존재하지 않으면 비어있는 Optional을 반환합니다.
     *         Optional을 사용함으로써 NullPointerException을 방지하고, 결과가 없을 수 있음을 명시적으로 표현할 수 있습니다.
     */
    Optional<User> findByEmail(String email);

    /**
     * 'existsByEmail' 또한 쿼리 메소드입니다.
     * "Email 필드를 기준으로 User가 존재하는지 확인하라" 라는 의미의 쿼리로 변환됩니다.
     * (SELECT count(u) > 0 FROM User u WHERE u.email = :email)
     *
     * 이메일 중복 체크 등, 실제 User 데이터 전체가 필요 없이 존재 여부만 확인하고 싶을 때 사용하면
     * findByEmail보다 더 효율적입니다.
     *
     * @param email 존재 여부를 확인할 이메일
     * @return 해당 이메일을 가진 사용자가 존재하면 true, 존재하지 않으면 false를 반환합니다.
     */
    boolean existsByEmail(String email);
}

