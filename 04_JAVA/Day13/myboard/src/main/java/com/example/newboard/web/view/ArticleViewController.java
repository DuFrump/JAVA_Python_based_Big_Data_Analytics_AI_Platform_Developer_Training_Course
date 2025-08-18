package com.example.newboard.web.view;

import com.example.newboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 안녕하세요, 두프룸프님! 이 클래스는 게시글(Article)과 관련된
 * 화면(View)을 보여주는 '뷰 컨트롤러(View Controller)'입니다.
 * 사용자의 요청에 따라 적절한 HTML 페이지를 반환하는 역할을 합니다.
 */
@Controller
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleService articleService;

    /**
     * 루트("/") 또는 "/articles" 경로로 GET 요청이 오면, 게시글 목록 페이지를 보여줍니다.
     * @param model View에 데이터를 전달하기 위한 Model 객체
     * @return "article-list" 뷰 이름
     */
    @GetMapping({"/", "/articles"})
    public String list(Model model) {
        // ArticleService를 통해 모든 게시글을 조회하여 모델에 담습니다.
        model.addAttribute("articles", articleService.findAll());
        // "article-list.html" 템플릿을 사용자에게 보여줍니다.
        return "article-list";
    }

    /**
     * "/articles/new" 경로로 GET 요청이 오면, 새 게시글 작성 폼 페이지를 보여줍니다.
     * @return "article-form" 뷰 이름
     */
    @GetMapping("/articles/new")
    public String createForm() {
        return "article-form";
    }

    /**
     * "/articles/{id}" 경로로 GET 요청이 오면, 특정 게시글의 상세 페이지를 보여줍니다.
     * @param id @PathVariable을 통해 URL 경로에서 게시글 ID를 추출합니다.
     * @param model View에 데이터를 전달하기 위한 Model 객체
     * @return "article-detail" 뷰 이름
     */
    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model) {
        // 서비스 계층을 통해 ID에 해당하는 게시글 정보를 조회합니다.
        var article = articleService.findById(id);
        // 조회된 게시글 정보를 모델에 담아 View로 전달합니다.
        model.addAttribute("article", article);
        return "article-detail";
    }

    /**
     * "/articles/{id}/edit" 경로로 GET 요청이 오면, 특정 게시글의 수정 폼 페이지를 보여줍니다.
     * @param id @PathVariable을 통해 URL 경로에서 게시글 ID를 추출합니다.
     * @param model View에 데이터를 전달하기 위한 Model 객체
     * @return "article-edit" 뷰 이름
     */
    @GetMapping("/articles/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        // ID에 해당하는 게시글 정보를 조회하여 모델에 담습니다.
        // 이 정보를 사용하여 수정 폼에 기존 데이터를 채워넣을 수 있습니다.
        var article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-edit";
    }

    // --- 주석 처리된 메소드들에 대한 설명 ---
    // 아래의 @PostMapping 메소드들(create, edit, delete)은 주석 처리되었습니다.
    // 기존에는 서버 사이드 렌더링(SSR) 방식으로 폼 데이터를 직접 처리했지만,
    // 업그레이드된 버전에서는 RESTful API 방식으로 변경되었기 때문입니다.
    //
    // 이제 게시글의 생성(Create), 수정(Update), 삭제(Delete)는
    // 자바스크립트(fetch API)를 사용하여 '/api/articles' 경로로 HTTP 요청을 보내는 방식으로 처리됩니다.
    // 이 API 요청들은 'ArticleApiController'에서 담당하게 됩니다.
    // 이렇게 하면 페이지 전체를 새로고침하지 않고도 동적으로 데이터를 처리할 수 있어
    // 더 나은 사용자 경험을 제공할 수 있습니다. (Single Page Application, SPA 방식)

//    @PostMapping("/articles")
//    public String create(ArticleCreateRequest req){
//        articleService.create(req);
//        return "redirect:/articles";
//    }

//    @PostMapping("/articles/{id}/edit")
//    public String edit(@PathVariable Long id, ArticleUpdateRequest req){
//        articleService.update(id, req);
//        return "redirect:/articles/" + id; // 수정 후 상세로 이동
//    }

//    @PostMapping("/articles/{id}/delete")
//    public String delete(@PathVariable Long id){
//        articleService.delete(id);
//        return "redirect:/articles";
//    }


}
