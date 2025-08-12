package com.example.myboard.controller;

import com.example.myboard.domain.Article;
import com.example.myboard.dto.ArticleCreateRequest;
import com.example.myboard.dto.ArticleResponse;
import com.example.myboard.dto.ArticleUpdateRequest;
import com.example.myboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Controller 어노테이션은 이 클래스가 웹 요청을 처리하는 '컨트롤러(Controller)'임을 나타냅니다.
 * Spring MVC(Model-View-Controller) 패턴의 C에 해당하죠.
 * 사용자의 요청(Request)을 받아서, 어떤 서비스(Service)를 호출할지 결정하고,
 * 최종적으로 사용자에게 어떤 뷰(View, 보통 HTML 파일)를 보여줄지 결정합니다.
 * (@RestController와는 다르게, @Controller는 주로 HTML 페이지를 반환할 때 사용합니다.)
 */
@Controller
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 만들어주는 Lombok 어노테이션 (생성자 주입)
public class ArticleController {

    private final ArticleService articleService;

    /**
     * HTTP GET 요청이 "/articles" URL로 들어왔을 때 이 메소드가 처리합니다.
     * 게시글 전체 목록을 조회하는 역할을 합니다.
     *
     * @param model 컨트롤러에서 생성한 데이터를 뷰(HTML)로 전달하는 역할을 하는 객체입니다.
     * @return "list"라는 이름의 뷰(View)를 반환합니다. Spring Boot는 'templates/list.html' 파일을 찾아서 렌더링합니다.
     */
    @GetMapping("/articles")
    public String getArticles(Model model) {
        // 1. articleService를 통해 모든 Article을 조회합니다.
        // 2. .stream().map(ArticleResponse::new).toList() 부분은 Java Stream API를 사용한 것입니다.
        //    List<Article>을 List<ArticleResponse>로 변환하는 과정입니다.
        //    엔티티(Article)를 직접 뷰로 전달하는 대신, 필요한 데이터만 담은 DTO(ArticleResponse)로 변환하여 전달하는 것이 좋습니다.
        List<ArticleResponse> articles = articleService.findAll().stream()
                .map(ArticleResponse::new)
                .toList();

        // 3. model.addAttribute("articles", articles);
        //    조회한 게시글 리스트(articles)를 "articles"라는 이름으로 모델에 추가합니다.
        //    이렇게 추가된 데이터는 뷰(list.html)에서 사용할 수 있게 됩니다.
        model.addAttribute("articles", articles);

        // 4. 뷰의 이름을 반환합니다.
        return "list";
    }

    /**
     * HTTP GET 요청이 "/articles/new" URL로 들어왔을 때, 새 게시글 작성 폼(form) 페이지를 보여줍니다.
     *
     * @return "form"이라는 이름의 뷰(View)를 반환합니다. 'templates/form.html' 파일을 렌더링합니다.
     */
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "form";
    }

    /**
     * HTTP POST 요청이 "/articles" URL로 들어왔을 때 이 메소드가 처리합니다.
     * 새 게시글 작성 폼에서 'Submit' 버튼을 눌렀을 때, 그 데이터를 받아서 실제 게시글을 생성하는 역할을 합니다.
     *
     * @param request HTML 폼(form)에서 보낸 데이터(title, content)가 이 DTO(ArticleCreateRequest) 객체에 자동으로 매핑됩니다.
     * @return "redirect:/articles" : 게시글 생성이 완료된 후, 브라우저를 "/articles" URL로 다시 보내버립니다(리다이렉트).
     *         결과적으로 사용자는 게시글 목록 페이지로 이동하게 됩니다.
     */
    @PostMapping("/articles")
    public String createArticle(ArticleCreateRequest request) {
        articleService.save(request);
        return "redirect:/articles";
    }

    /**
     * HTTP GET 요청이 "/articles/{id}" 형태의 URL로 들어왔을 때 이 메소드가 처리합니다.
     * {id} 부분은 변하는 값이며, 특정 게시글 하나의 상세 내용을 조회하는 역할을 합니다.
     *
     * @param id @PathVariable 어노테이션은 URL 경로의 일부({id})를 파라미터로 받아올 수 있게 해줍니다.
     * @param model 뷰로 데이터를 전달할 모델 객체
     * @return "article"이라는 이름의 뷰(View)를 반환합니다. 'templates/article.html' 파일을 렌더링합니다.
     */
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable long id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", new ArticleResponse(article));
        return "article";
    }

    /**
     * HTTP GET 요청이 "/articles/{id}/edit" URL로 들어왔을 때, 기존 게시글 수정 폼 페이지를 보여줍니다.
     *
     * @param id 수정할 게시글의 ID
     * @param model 뷰로 데이터를 전달할 모델 객체
     * @return "form"이라는 이름의 뷰(View)를 반환합니다. 'templates/form.html' 파일을 재사용합니다.
     */
    @GetMapping("/articles/{id}/edit")
    public String editArticleForm(@PathVariable long id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", new ArticleResponse(article));
        return "form";
    }

    /**
     * HTTP POST 요청이 "/articles/{id}/update" URL로 들어왔을 때 이 메소드가 처리합니다.
     * 게시글 수정 폼에서 'Submit' 버튼을 눌렀을 때, 그 데이터를 받아서 실제 게시글을 수정합니다.
     *
     * @param id 수정할 게시글의 ID
     * @param request HTML 폼에서 보낸 수정 데이터(title, content)가 이 DTO(ArticleUpdateRequest) 객체에 매핑됩니다.
     * @return "redirect:/articles/{id}" : 게시글 수정이 완료된 후, 해당 게시글의 상세 보기 페이지로 리다이렉트합니다.
     */
    @PostMapping("/articles/{id}/update")
    public String updateArticle(@PathVariable long id, ArticleUpdateRequest request) {
        articleService.update(id, request);
        return "redirect:/articles/" + id;
    }

    /**
     * HTTP POST 요청이 "/articles/{id}/delete" URL로 들어왔을 때 이 메소드가 처리합니다.
     * 특정 게시글을 삭제하는 역할을 합니다.
     *
     * @param id 삭제할 게시글의 ID
     * @return "redirect:/articles" : 게시글 삭제가 완료된 후, 게시글 목록 페이지로 리다이렉트합니다.
     */
    @PostMapping("/articles/{id}/delete")
    public String deleteArticle(@PathVariable long id) {
        articleService.delete(id);
        return "redirect:/articles";
    }
}