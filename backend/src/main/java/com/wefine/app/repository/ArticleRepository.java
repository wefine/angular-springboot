package com.wefine.app.repository;


import com.wefine.app.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    boolean existsByTitleAndCategory(String title, String category);
}