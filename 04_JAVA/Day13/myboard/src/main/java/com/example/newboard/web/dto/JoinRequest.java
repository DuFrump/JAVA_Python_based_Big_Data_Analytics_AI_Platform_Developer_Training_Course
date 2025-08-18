package com.example.newboard.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 DTO(Data Transfer Object)입니다.
 * DTO는 계층(Layer) 간에 데이터를 전달하는 '데이터 전송용 바구니'입니다.
 *
 * 이 JoinRequest DTO는 사용자가 회원가입 시, View(화면)에서 입력한
 * 이메일, 비밀번호, 이름 데이터를 Controller로 안전하게 전달하는 역할을 합니다.
 *
 * 엔티티(Entity)를 직접 요청/응답에 사용하지 않고 DTO를 쓰는 이유는,
 * 엔티티는 DB와 직접 연결된 핵심 클래스이므로, 화면에 불필요한 데이터를 노출하지 않고
 * 각 계층의 역할을 명확하게 분리하여 안정적인 설계를 하기 위함입니다.
 */
@Getter
@Setter
public class JoinRequest {

    /**
     * @NotBlank: 이 필드의 값이 null이거나, 공백(whitespace)만으로 이루어진 문자열일 수 없음을 검증합니다. (필수 입력)
     * @Email: 이 필드의 값이 유효한 이메일 형식(예: user@example.com)이어야 함을 검증합니다.
     *
     * 이처럼 Validation 어노테이션을 사용하면, 데이터가 서비스 로직으로 넘어오기 전에
     * 컨트롤러 계층에서 1차적으로 데이터의 유효성을 검사할 수 있어 편리하고 안전합니다.
     */
    @Email
    @NotBlank
    private String email;

    /**
     * @NotBlank: 비밀번호는 필수 입력값임을 명시합니다.
     */
    @NotBlank
    private String password;

    /**
     * @NotBlank: 이름은 필수 입력값임을 명시합니다.
     */
    @NotBlank
    private String name;
}

