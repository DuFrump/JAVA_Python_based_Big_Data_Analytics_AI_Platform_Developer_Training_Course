package com.example.newboard.config;

import com.example.newboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 Spring Security의 핵심 인터페이스 중 하나인 UserDetailsService를 구현한 클래스입니다.
 * Spring Security가 '인증(Authentication)' 절차를 수행할 때,
 * 사용자의 정보를 데이터베이스에서 어떻게 가져올지를 정의하는 역할을 합니다.
 */
@Service // 이 클래스 또한 비즈니스 로직을 담고 있으므로 서비스 빈으로 등록합니다.
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // 사용자 정보를 조회하기 위해 UserRepository를 주입받습니다.

    /**
     * Spring Security가 로그인을 처리할 때 호출하는 메소드입니다.
     * 사용자가 로그인 폼에 입력한 'username'(여기서는 이메일)을 파라미터로 받습니다.
     *
     * @param username 사용자가 로그인 시 입력한 아이디 (우리는 이메일을 아이디로 사용)
     * @return 데이터베이스에서 조회한 사용자 정보를 바탕으로 생성된 UserDetails 객체
     * @throws UsernameNotFoundException 해당 username을 가진 사용자를 찾을 수 없을 때 발생하는 예외
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 전달받은 username(이메일)을 사용하여 데이터베이스에서 사용자 정보를 조회합니다.
        var user = userRepository.findByEmail(username)
                // 2. 만약 사용자를 찾을 수 없다면, Spring Security가 처리할 수 있도록 UsernameNotFoundException 예외를 발생시킵니다.
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 찾을 수 없습니다: " + username));

        // 3. 사용자를 찾았다면, Spring Security가 이해할 수 있는 형태의 객체인 UserDetails로 변환하여 반환합니다.
        //    org.springframework.security.core.userdetails.User 클래스는 UserDetails 인터페이스의 표준 구현체입니다.
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail()) // UserDetails의 username으로 사용할 값 (고유 식별자)
                .password(user.getPassword()) // 데이터베이스에 저장된 '암호화된' 비밀번호
                .roles(user.getRole())        // 사용자의 역할(권한) 정보 (예: "USER", "ADMIN")
                .build();
    }
    // 이 메소드가 UserDetails 객체를 성공적으로 반환하면,
    // Spring Security는 이 정보를 가지고 사용자가 입력한 비밀번호와 데이터베이스의 암호화된 비밀번호를 비교하여
    // 인증 절차를 마저 수행합니다.
    // 인증이 완료되면, 이 UserDetails 정보는 'Authentication' 객체에 담겨 SecurityContext에 저장되며,
    // 이후 애플리케이션 전반에서 @AuthenticationPrincipal 등을 통해 로그인한 사용자 정보를 쉽게 꺼내 쓸 수 있게 됩니다.
}

