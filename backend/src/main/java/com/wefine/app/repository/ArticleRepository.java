package com.wefine.app.repository;


import com.wefine.app.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select count (id) from Article where title = ?1 and category = ?2")
    long exists(String title, String category);
}
