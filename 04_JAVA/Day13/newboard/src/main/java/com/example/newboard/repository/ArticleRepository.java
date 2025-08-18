package com.example.newboard.repository;

import com.example.newboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByIdAndAuthor_Email(Long id, String email);
    long deleteByIdAndAuthor_Email(Long id, String email);
}


// CRUD
// findAll()
