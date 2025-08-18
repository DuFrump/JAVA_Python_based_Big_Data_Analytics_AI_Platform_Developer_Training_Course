package com.example.newboard.web.api;


import com.example.newboard.domain.Article;
import com.example.newboard.service.ArticleService;
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 게시글(Article)과 관련된 RESTful API를 제공하는 'API 컨트롤러'입니다.
 * @RestController 어노테이션을 통해 이 컨트롤러의 모든 메소드는 View 페이지가 아닌,
 * JSON과 같은 데이터 자체를 반환하게 됩니다. 클라이언트(브라우저의 자바스크립트, 모바일 앱 등)와
 * 데이터를 주고받는 역할을 담당합니다.
 *
 * @RequestMapping("/api/articles"): 이 컨트롤러의 모든 메소드는 "/api/articles" 라는 기본 URL 경로를 갖게 됩니다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleApiController {

    private final ArticleService articleService;

    /**
     * POST /api/articles
     * 새로운 게시글을 생성하는 API입니다.
     *
     * @param req @RequestBody를 통해 HTTP 요청의 본문(body)에 담긴 JSON 데이터를 ArticleCreateRequest DTO로 변환합니다.
     *            @Valid 어노테이션으로 DTO에 정의된 유효성 검사를 수행합니다.
     * @param auth Spring Security를 통해 현재 인증된(로그인한) 사용자의 정보를 담고 있는 Authentication 객체입니다.
     *             컨트롤러 메소드의 파라미터로 선언하면 Spring Security가 자동으로 주입해줍니다.
     * @return 생성된 게시글의 URI를 담아 '201 Created' 상태 코드로 응답합니다.
     */
    @PostMapping
    public ResponseEntity<Article> create(@Valid @RequestBody ArticleCreateRequest req, Authentication auth) {
        // auth.getName()을 통해 현재 로그인한 사용자의 이메일(username)을 가져와 서비스 계층에 전달합니다.
        Long id = articleService.create(req, auth.getName());
        // 성공적으로 생성되었음을 알리는 HTTP 상태 코드 201(Created)와 함께,
        // 생성된 리소스(게시글)를 찾아갈 수 있는 URI를 Location 헤더에 담아 응답합니다.
        return ResponseEntity.created(URI.create("/articles/" + id)).build();
    }

    /**
     * PUT /api/articles/{id}
     * 특정 ID의 게시글을 수정하는 API입니다.
     *
     * @param id @PathVariable을 통해 URL 경로에서 수정할 게시글의 ID를 추출합니다.
     * @param req @RequestBody를 통해 요청 본문의 JSON 데이터를 ArticleUpdateRequest DTO로 변환합니다.
     * @param auth 현재 로그인한 사용자의 인증 정보
     * @return 내용 없이 '204 No Content' 상태 코드로 응답하여 성공적으로 처리되었음을 알립니다.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @Valid @RequestBody ArticleUpdateRequest req,
                                       Authentication auth) {
        // 서비스 계층에 게시글 ID, 사용자 이메일, 수정할 데이터를 전달하여 수정을 위임합니다.
        // 서비스 계층 내부에서 해당 사용자가 게시글의 소유주인지 검증하는 로직이 수행됩니다.
        articleService.update(id, auth.getName(), req);
        return ResponseEntity.noContent().build();
    }


    /**
     * DELETE /api/articles/{id}
     * 특정 ID의 게시글을 삭제하는 API입니다.
     *
     * @param id @PathVariable을 통해 URL 경로에서 삭제할 게시글의 ID를 추출합니다.
     * @param auth 현재 로그인한 사용자의 인증 정보
     * @return 내용 없이 '204 No Content' 상태 코드로 응답하여 성공적으로 처리되었음을 알립니다.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Authentication auth) {
        // 서비스 계층에 게시글 ID와 사용자 이메일을 전달하여 삭제를 위임합니다.
        // 서비스 계층 내부에서 소유권 검증과 삭제가 함께 이루어집니다.
        articleService.delete(id, auth.getName());
        return ResponseEntity.noContent().build();
    }


}

