package com.example.newboard.web.dto;

import com.example.newboard.domain.Article;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO(Data Transfer Object)는 계층 간 데이터 전송을 위해 사용하는 객체입니다.
 * 이 클래스는 '게시글 생성' 요청 시 클라이언트(브라우저)가 보낸 데이터를 담는 역할을 합니다.
 *
 * 왜 Entity(Article)를 직접 받지 않고 DTO를 사용할까요?
 * 1. 관심사의 분리: Entity는 데이터베이스와 직접 연결된 핵심 객체입니다. 요청/응답 데이터는 변화가 잦기 때문에,
 *    Entity와 분리하여 관리하는 것이 좋습니다. Entity가 요청/응답에 종속되지 않게 하는 것이죠.
 * 2. 유효성 검증: 요청으로 들어온 데이터에 대한 유효성 검증(validation) 로직을 DTO에 추가하여,
 *    서비스 계층으로 넘어가기 전에 데이터의 정합성을 미리 확인할 수 있습니다.
 * 3. API 스펙 유지: Entity의 필드가 변경되어도, DTO를 통해 API 응답 형식을 그대로 유지할 수 있어
 *    클라이언트 측의 혼란을 막을 수 있습니다.
 */
@Getter
@Setter
@NoArgsConstructor
public class ArticleCreateRequest {

    /**
     * @NotBlank 어노테이션은 '유효성 검증(Validation)'을 위한 기능입니다.
     * 이 필드의 값이 null이거나, 비어있거나, 공백만으로 이루어져 있으면 안 된다는 규칙을 적용합니다.
     * 만약 규칙을 어기면, message에 지정된 "제목은 필수입니다." 라는 오류 메시지를 반환합니다.
     * 이 검증은 컨트롤러에서 @Valid 어노테이션을 붙였을 때 자동으로 동작합니다.
     */
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

}
