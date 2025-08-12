package com.example.newboard.web.view;

import com.example.newboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {
    private final ArticleService articleService;

    @GetMapping({"/", "/articles"})
    public String list(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "article-list";
    }
}
