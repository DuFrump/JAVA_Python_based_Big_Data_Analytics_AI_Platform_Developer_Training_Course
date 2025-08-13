package com.example.newboard.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * '게시글 수정' 요청 시 클라이언트가 보낸 데이터를 담는 DTO 입니다.
 * 생성(Create)과 수정(Update)은 필요한 데이터가 비슷해서 합칠 수도 있지만,
 * 나중에 각 요청의 요구사항이 달라질 수 있으므로 (예: 수정 시에는 제목만 바꿀 수 있게 한다거나)
 * 명확한 역할 구분을 위해 별도의 DTO로 만드는 것이 좋은 설계입니다.
 */
@Setter
@Getter
@NoArgsConstructor
public class ArticleUpdateRequest {
    /**
     * @NotBlank 어노테이션을 통해 수정 시에도 제목은 비어있을 수 없도록 강제합니다.
     */
    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    /**
     * @NotBlank 어노테이션을 통해 수정 시에도 내용은 비어있을 수 없도록 강제합니다.
     */
    @NotBlank(message = "내용은 필수입니다.")
    private String content;


}
