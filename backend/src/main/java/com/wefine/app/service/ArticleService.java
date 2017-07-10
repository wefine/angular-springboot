package com.wefine.app.service;


import com.wefine.app.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    Article getArticleById(Long articleId);

    boolean createArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(Long articleId);
}