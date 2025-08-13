package com.example.newboard.web.api;

import com.example.newboard.service.ArticleService;
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 이 컨트롤러는 '클라이언트 사이드 렌더링(CSR)'을 위한 REST API 요청을 처리합니다.
 * 자바스크립트(AJAX), 모바일 앱 등 클라이언트 측의 요청을 받고, HTML 페이지가 아닌
 * 데이터(주로 JSON 형식)를 반환하는 역할을 합니다.
 *
 * @RestController 어노테이션은 @Controller와 @ResponseBody를 합친 것입니다.
 * 이 어노테이션을 붙이면, 이 클래스의 모든 메소드는 뷰(HTML)를 찾는 대신,
 * 반환하는 객체나 데이터를 HTTP 응답 본문(Response Body)에 직접 써서 보냅니다.
 *
 * @RequestMapping("/api/articles")
 * 이 클래스에 있는 모든 메소드의 공통 URL 경로를 지정합니다.
 * 예를 들어 @PostMapping이 붙은 create 메소드는 "/api/articles" 라는 경로로 POST 요청을 받게 됩니다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleAPIController {

    private final ArticleService articleService;

    /**
     * 게시글 생성을 위한 API 메소드입니다.
     * @PostMapping 어노테이션은 HTTP POST 요청을 처리합니다.
     *
     * @param req @RequestBody 어노테이션은 HTTP 요청의 본문(body)에 담겨있는 JSON 데이터를
     *            ArticleCreateRequest DTO 객체로 변환(Deserialize)해줍니다.
     *            자바스크립트에서 fetch를 통해 보낸 JSON 데이터가 이 객체로 쏙 들어오는 것이죠.
     * @param req @Valid 어노테이션은 ArticleCreateRequest DTO에 정의된 유효성 검증(@NotBlank 등)을
     *            자동으로 수행하도록 합니다. 만약 검증에 실패하면 400 Bad Request 에러를 반환합니다.
     * @return ResponseEntity<Void>
     *         ResponseEntity는 HTTP 응답의 상태 코드, 헤더, 본문을 모두 세밀하게 제어할 수 있는 객체입니다.
     *         여기서는 "게시글이 성공적으로 생성되었다"는 의미의 HTTP 상태 코드 '201 Created'를 반환합니다.
     *         본문(body)에는 특별히 전달할 데이터가 없으므로 <Void> 타입을 사용하고, .build()로 마무리합니다.
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ArticleCreateRequest req) {
        articleService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 특정 게시글 수정을 위한 API 메소드입니다.
     * @PutMapping 어노테이션은 HTTP PUT 요청을 처리합니다.
     * PUT은 주로 리소스 전체를 교체(수정)하는 의미로 사용됩니다.
     *
     * @param id @PathVariable을 통해 URL 경로에서 수정할 게시글의 ID를 받아옵니다.
     * @param req @RequestBody를 통해 수정할 내용이 담긴 JSON 데이터를 DTO로 받아옵니다.
     * @return 수정이 성공했다는 의미의 '200 OK' 상태 코드를 반환합니다.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody ArticleUpdateRequest req) {
        articleService.update(id, req);
        return ResponseEntity.ok().build();
    }

    /**
     * 특정 게시글 삭제를 위한 API 메소드입니다.
     * @DeleteMapping 어노테이션은 HTTP DELETE 요청을 처리합니다.
     *
     * @param id 삭제할 게시글의 ID
     * @return 삭제가 성공적으로 수행되었고, 응답 본문에 별도의 내용이 없다는 의미의
     *         '204 No Content' 상태 코드를 반환합니다. 이는 REST API에서 삭제 요청에 대한 표준적인 응답 방식입니다.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
