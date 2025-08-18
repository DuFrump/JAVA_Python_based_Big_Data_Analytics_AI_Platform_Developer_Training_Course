package com.example.newboard.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 기존 게시글 수정을 요청할 때
 * 클라이언트(브라우저)에서 서버로 전달되는 데이터를 담는 DTO(Data Transfer Object)입니다.
 */
@Setter
@Getter
@NoArgsConstructor
public class ArticleUpdateRequest {

    /**
     * @NotBlank: 수정할 제목이 null이거나 공백일 수 없음을 검증합니다.
     */
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    /**
     * @NotBlank: 수정할 내용이 null이거나 공백일 수 없음을 검증합니다.
     */
    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}

