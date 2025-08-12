package com.example.myboard.dto;

import com.example.myboard.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleCreateRequest {

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
