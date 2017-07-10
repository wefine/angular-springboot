package com.wefine.app.service.impl;


import com.wefine.app.entity.Article;
import com.wefine.app.repository.ArticleRepository;
import com.wefine.app.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository repository;

    @Override
    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public boolean createArticle(Article article) {
        if (repository.existsByTitleAndCategory(article.getTitle(), article.getCategory())) {
            return false;
        }

        repository.save(article);
        return true;
    }

    @Override
    public void updateArticle(Article article) {
        repository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        repository.delete(id);
    }
}
