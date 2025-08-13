package com.example.newboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 이 클래스는 JPA 관련 설정을 담당합니다.
 *
 * @Configuration 어노테이션은 이 클래스가 스프링의 '설정(Configuration)' 정보를 담고 있는
 * 클래스임을 나타냅니다. 스프링 부트가 시작될 때, 이 클래스를 읽어서 설정 정보를 로드합니다.
 */
@Configuration
/**
 * @EnableJpaAuditing 어노테이션은 JPA의 'Auditing(감시)' 기능을 활성화합니다.
 * Auditing 기능이란, 엔티티(Entity)가 생성되거나 수정될 때,
 * 그 시간과 주체를 자동으로 기록해주는 기능입니다.
 *
 * 예를 들어, Article 엔티티에 @CreatedDate 어노테이션이 붙은 필드(예: private LocalDateTime createdAt;)가 있다면,
 * 새 Article이 저장될 때마다 현재 시간이 그 필드에 자동으로 기록됩니다.
 * @LastModifiedDate 어노테이션도 마찬가지로, 수정될 때마다 자동으로 시간을 기록해줍니다.
 *
 * 이 기능을 사용하려면, 보통 BaseTimeEntity 같은 별도의 추상 클래스를 만들어
 * createdAt, updatedAt 필드를 정의하고, 실제 엔티티들이 이 클래스를 상속받도록 설계합니다.
 */
@EnableJpaAuditing
public class jpaConfig {
}
