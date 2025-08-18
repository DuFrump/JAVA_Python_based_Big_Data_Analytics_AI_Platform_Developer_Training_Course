package com.example.newboard.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 우리 애플리케이션의 '보안'을 총괄하는 Spring Security 설정 파일입니다.
 * 웹 애플리케이션에 들어오는 모든 요청은 이곳에 정의된 보안 규칙을 먼저 거치게 됩니다.
 *
 * @Configuration: "이 클래스는 애플리케이션의 설정을 담당하는 클래스입니다." 라고 스프링에게 알려주는 어노테이션입니다.
 *                 스프링 컨테이너는 이 클래스를 스캔하여 여기에 정의된 @Bean들을 관리하게 됩니다.
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    /**
     * @Bean: 이 메소드가 반환하는 객체를 스프링 컨테이너가 관리하는 '빈(Bean)'으로 등록하라는 의미입니다.
     * 이렇게 빈으로 등록된 객체는 다른 클래스에서 '의존성 주입(DI)'을 통해 편리하게 사용할 수 있습니다.
     *
     * PasswordEncoder는 비밀번호를 안전하게 암호화하기 위한 인터페이스입니다.
     * 여기서는 BCrypt 해시 알고리즘을 사용하는 BCryptPasswordEncoder를 빈으로 등록합니다.
     * BCrypt는 현재 가장 널리 사용되는 안전한 해시 알고리즘 중 하나입니다.
     *
     * @return BCryptPasswordEncoder 객체
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * SecurityFilterChain은 Spring Security의 핵심 설정들을 정의하는 역할을 합니다.
     * HTTP 요청에 대한 보안 규칙, 로그인/로그아웃 처리, CSRF 보호 등 대부분의 보안 설정이 이곳에서 이루어집니다.
     *
     * @param http HttpSecurity 객체. Spring Security의 설정을 구성하는 빌더 클래스입니다.
     * @return 구성이 완료된 SecurityFilterChain 객체
     * @throws Exception 설정 과정에서 발생할 수 있는 예외
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. HTTP 요청에 대한 인가(Authorization) 규칙 설정
                .authorizeHttpRequests(auth -> auth
                        // requestMatchers()에 지정된 URL 패턴에 대한 접근 권한을 설정합니다.
                        .requestMatchers("/", "/articles", "/articles/**", "/login", "/join", "/css/**", "/js/**").permitAll() // 해당 경로들은 로그인 여부와 상관없이 누구나 접근을 허용합니다.
                        .requestMatchers("/api/**").authenticated() // '/api/**'로 시작하는 모든 요청은 반드시 '인증(로그인)'된 사용자만 접근을 허용합니다. (게시글 CUD 보호)
                        .anyRequest().permitAll() // 위에서 지정한 경로 외의 모든 요청은 일단 모두에게 허용합니다. (필요에 따라 .denyAll() 등으로 변경 가능)
                )
                // 2. 폼 기반 로그인(Form Login) 설정
                .formLogin(form -> form
                        .loginPage("/login") // 사용자가 로그인해야 할 때, 보여줄 로그인 페이지의 경로를 지정합니다.
                        .loginProcessingUrl("/login") // 로그인 폼(form)이 제출(submit)될 때, Spring Security가 로그인을 처리할 경로를 지정합니다. (우리가 직접 컨트롤러에 만들 필요 없음)
                        .defaultSuccessUrl("/articles", true) // 로그인에 성공했을 때, 사용자를 이동시킬 기본 경로를 지정합니다.
                        .permitAll() // 로그인 페이지는 누구나 접근할 수 있어야 하므로, 접근을 허용합니다.
                )
                // 3. 로그아웃(Logout) 설정
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃을 처리할 경로를 지정합니다.
                        .logoutSuccessUrl("/articles") // 로그아웃에 성공했을 때, 사용자를 이동시킬 경로를 지정합니다.
                        // 로그아웃 시, 세션을 무효화하고, 인증 토큰을 삭제하는 등의 작업은 Spring Security가 자동으로 처리해줍니다.
                )
                // 4. CSRF(Cross-Site Request Forgery) 보호 설정
                .csrf(csrf -> csrf
                        // CSRF 토큰을 쿠키를 통해 관리하도록 설정합니다.
                        // withHttpOnlyFalse() 옵션은 자바스크립트(예: fetch API)에서도 CSRF 토큰을 읽을 수 있도록 허용합니다.
                        // 이를 통해 클라이언트 사이드에서 API 요청 시, 헤더에 CSRF 토큰을 담아 보낼 수 있습니다.
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                );

        return http.build(); // 구성된 HttpSecurity 설정을 바탕으로 SecurityFilterChain 객체를 생성하여 반환합니다.
    }
}

