package com.example.newboard.web.view;

import com.example.newboard.service.ArticleService;
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleListViewResponse;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 이 컨트롤러는 '서버 사이드 렌더링(SSR)' 방식으로 동작하는 전통적인 웹 페이지 요청을 처리합니다.
 * 즉, 사용자의 요청을 받아서 완전한 HTML 페이지를 만들어서 반환하는 역할을 합니다.
 *
 * @Controller 어노테이션은 이 클래스가 Spring MVC의 컨트롤러임을 나타냅니다.
 * @RestController 와의 가장 큰 차이점은, 이 컨트롤러의 메소드들은 주로 '뷰(View)의 이름'을 반환한다는 것입니다.
 */
@Controller
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleService articleService;

    /**
     * 게시글 목록 페이지를 요청하는 메소드입니다.
     * @GetMapping 어노테이션은 HTTP GET 요청을 특정 URL과 매핑합니다.
     * 여기서는 루트("/") 또는 "/articles" 경로로 오는 GET 요청을 이 메소드가 처리하게 됩니다.
     * @param model 컨트롤러에서 뷰로 데이터를 전달하는 데 사용되는 '모델' 객체입니다.
     *              마치 데이터를 담아서 뷰로 보내는 '상자'와 같습니다.
     * @return "article-list" 라는 뷰의 이름을 반환합니다.
     *         스프링 부트는 이 이름을 보고 'templates/article-list.html' 파일을 찾아서 사용자에게 보여줍니다.
     */
    @GetMapping({"/", "/articles"})
    public String list(Model model) {
        // 서비스 계층을 통해 모든 Article을 조회합니다.
        // Article 엔티티를 직접 뷰로 전달하기보다는, 화면에 필요한 데이터만 담은 DTO로 변환하는 것이 좋습니다.
        // Java Stream API를 사용하여 List<Article>을 List<ArticleListViewResponse>로 변환합니다.
        List<ArticleListViewResponse> articles = articleService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .collect(Collectors.toList());

        model.addAttribute("articles", articles); // "articles"라는 이름으로 모델에 게시글 리스트를 추가합니다.
        return "article-list"; // 보여줄 뷰의 이름을 반환합니다.
    }

    /**
     * 새 게시글 작성 페이지를 요청하는 메소드입니다.
     * @return "article-form" 뷰의 이름을 반환하여 'templates/article-form.html'을 보여줍니다.
     */
    @GetMapping("/articles/new")
    public String createForm() { return "article-form"; }

    /**
     * 게시글 생성을 처리하는 메소드입니다. (HTML Form을 통한 제출)
     * @PostMapping 어노테이션은 HTTP POST 요청을 처리합니다.
     * @param req HTML form의 input 필드들의 name 속성과 DTO의 필드 이름이 일치하면,
     *            스프링이 자동으로 데이터를 ArticleCreateRequest 객체에 담아줍니다.
     * @return "redirect:/articles"
     *         게시글 생성이 완료된 후, 브라우저에게 "/articles" 경로로 다시 접속하라고 명령합니다(리다이렉트).
     *         이를 통해 사용자는 방금 작성한 글이 포함된 목록 페이지를 보게 됩니다.
     *         새로고침 시 폼이 다시 제출되는 '중복 전송' 문제를 방지하는 효과도 있습니다.
     */
    @PostMapping("/articles")
    public String create(ArticleCreateRequest req) {
        articleService.create(req);
        return "redirect:/articles";
    }

    /**
     * 특정 게시글의 상세 페이지를 요청하는 메소드입니다.
     * @param id @PathVariable 어노테이션은 URL 경로에 포함된 변수(여기서는 {id})의 값을 파라미터로 받아옵니다.
     *           예를 들어 /articles/3 으로 요청이 오면 id 파라미터에는 3이 담깁니다.
     * @param model 뷰로 데이터를 전달할 모델 객체
     * @return "article-detail" 뷰의 이름을 반환하여 'templates/article-detail.html'을 보여줍니다.
     */
    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model) {
        var article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-detail";
    }

    /**
     * 게시글 수정 페이지를 요청하는 메소드입니다.
     * @param id 수정할 게시글의 ID
     * @param model 뷰로 데이터를 전달할 모델 객체
     * @return "article-edit" 뷰의 이름을 반환하여 'templates/article-edit.html'을 보여줍니다.
     */
    @GetMapping("/articles/{id}/edit")
    public String editForm(@PathVariable Long id, Model model){
        var article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-edit";
    }

    /**
     * 게시글 수정을 처리하는 메소드입니다. (HTML Form을 통한 제출)
     * @param id 수정할 게시글의 ID
     * @param req 수정할 내용(title, content)이 담긴 DTO
     * @return 수정이 완료된 후, 해당 게시글의 상세 페이지로 리다이렉트합니다.
     */
    @PostMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, ArticleUpdateRequest req){
        articleService.update(id, req);
        return "redirect:/articles/" + id;
    }

    /**
     * 게시글 삭제를 처리하는 메소드입니다.
     * (참고: 보통 중요한 삭제 기능은 GET이 아닌 POST나 DELETE 메소드를 사용합니다.
     *  여기서는 간단한 form 제출을 위해 POST를 사용했습니다.)
     * @param id 삭제할 게시글의 ID
     * @return 삭제 완료 후, 게시글 목록 페이지로 리다이렉트합니다.
     */
    @PostMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id) {
        articleService.delete(id);
        return "redirect:/articles";
    }
}
