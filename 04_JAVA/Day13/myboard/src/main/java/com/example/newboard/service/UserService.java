package com.example.newboard.service;

import com.example.newboard.domain.User;
import com.example.newboard.repository.UserRepository;
import com.example.newboard.web.dto.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 사용자(User) 관련 비즈니스 로직을 처리하는 '서비스(Service)' 계층입니다.
 * 컨트롤러(Controller)로부터 요청을 받아, 실제 데이터 처리는 리포지토리(Repository)에게 위임하며
 * 그 과정에서 필요한 계산, 검증, 데이터 가공 등의 작업을 수행합니다.
 */
@Service // "이 클래스는 비즈니스 로직을 담당하는 서비스 클래스입니다!" 라고 스프링 컨테이너에 빈으로 등록합니다.
@RequiredArgsConstructor // final 키워드가 붙은 필드를 인자로 받는 생성자를 자동으로 만들어줍니다. (생성자 주입 방식의 의존성 주입)
public class UserService {

    /**
     * final 키워드를 사용하여, 생성 시점에 반드시 의존성이 주입되어야 함을 명시합니다.
     * 생성자 주입 방식은 의존성을 변경할 수 없어 안전하며, 순환 참조 문제를 방지할 수 있는 장점이 있습니다.
     */
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // SecurityConfig에 빈으로 등록된 PasswordEncoder를 주입받습니다.

    /**
     * 회원가입 비즈니스 로직을 처리하는 메소드입니다.
     *
     * @Transactional 어노테이션은 이 메소드 전체가 하나의 '트랜잭션(Transaction)' 안에서 실행되도록 보장합니다.
     * 트랜잭션이란 "더 이상 쪼갤 수 없는 업무의 최소 단위"를 의미합니다.
     * 이 메소드 안의 작업들(이메일 중복 확인, 사용자 정보 저장) 중 하나라도 실패하면,
     * 모든 작업이 없었던 일처럼 원래 상태로 되돌려집니다(롤백, Rollback).
     * 이를 통해 데이터의 일관성과 안정성을 지킬 수 있습니다.
     *
     * @param req 회원가입 폼에서 사용자가 입력한 정보를 담고 있는 DTO(Data Transfer Object)
     */
    @Transactional
    public void join(JoinRequest req) {
        // 1. 이메일 중복 확인
        // userRepository에 우리가 직접 만든 existsByEmail 메소드를 호출하여,
        // 요청받은 이메일(req.getEmail())로 이미 가입된 회원이 있는지 확인합니다.
        if (userRepository.existsByEmail(req.getEmail())) {
            // 2. 만약 이미 존재하는 이메일이라면, IllegalArgumentException 예외를 발생시켜
            // 사용자에게 알리고, 메소드 실행을 중단합니다.
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 3. 사용자 정보 저장
        // DTO(req)에 담긴 정보를 바탕으로 User 엔티티를 생성하여 데이터베이스에 저장합니다.
        userRepository.save(User.builder()
                .email(req.getEmail())
                // 4. 중요! 비밀번호는 절대로 원본 그대로 저장하면 안 됩니다.
                // passwordEncoder의 encode() 메소드를 사용하여 비밀번호를 안전한 해시값으로 '암호화'하여 저장합니다.
                // 암호화된 비밀번호는 다시 원래 값으로 되돌릴 수 없습니다. (단방향 암호화)
                .password(passwordEncoder.encode(req.getPassword()))
                .name(req.getName())
                .role("USER") // 5. 신규 가입자는 기본적으로 "USER" 권한을 갖도록 설정합니다.
                .build());
    }
}

