package com.example.newboard.service;

import com.example.newboard.domain.Article;
import com.example.newboard.repository.ArticleRepository;
import com.example.newboard.web.dto.ArticleCreateRequest;
import com.example.newboard.web.dto.ArticleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public void create(ArticleCreateRequest req) {
        articleRepository.save(
                Article.builder()
                        .title(req.getTitle())
                        .content(req.getContent())
                        .build()
        );
    }

    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow((() -> new IllegalArgumentException("Article not found :" + id)));
    }

    @Transactional
    public void update(Long id, ArticleUpdateRequest req) {
        var article = findById(id);
        article.update(req.getTitle(), req.getContent());
    }

    @Transactional
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
