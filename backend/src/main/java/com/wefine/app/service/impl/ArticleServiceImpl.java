package com.wefine.app.service.impl;

import com.wefine.app.core.service.impl.ServiceWrapperImpl;
import com.wefine.app.entity.Article;
import com.wefine.app.repository.ArticleRepository;
import com.wefine.app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl
        extends ServiceWrapperImpl<Article> implements ArticleService {

    private ArticleRepository repo;

    @Autowired
    public ArticleServiceImpl(ArticleRepository repo) {
        super(repo, article -> {
            long count = repo.exists(article.getTitle(), article.getCategory());
            return count != 0;
        });

        this.repo = repo;
    }
}
