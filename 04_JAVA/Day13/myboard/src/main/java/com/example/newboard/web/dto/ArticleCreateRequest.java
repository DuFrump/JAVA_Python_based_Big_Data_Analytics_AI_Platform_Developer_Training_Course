package com.example.newboard.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 신규 게시글 생성을 요청할 때
 * 클라이언트(브라우저)에서 서버로 전달되는 데이터를 담는 DTO(Data Transfer Object)입니다.
 */
@Setter
@Getter
@NoArgsConstructor
public class ArticleCreateRequest {

    /**
     * @NotBlank: 이 필드가 null이거나 공백 문자열일 수 없음을 검증합니다.
     * message = "제목은 필수입니다.": 검증에 실패했을 때, 사용자에게 보여줄 에러 메시지를 지정합니다.
     */
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    /**
     * @NotBlank: 내용 또한 필수 입력값임을 검증합니다.
     */
    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}
