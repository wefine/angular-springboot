package com.wefine.app.controller;


import com.wefine.app.entity.Article;
import com.wefine.app.service.ArticleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("api")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("article")
    public ResponseEntity<Article> getArticleById(@RequestParam("id") String id) {
        Article article = articleService.findById(Long.parseLong(id));

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @GetMapping("articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> list = articleService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("article")
    public ResponseEntity<Void> createArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        Article a = articleService.create(article);
        if (a.getId() == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.update(article);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @DeleteMapping("article")
    public ResponseEntity<Void> deleteArticle(@RequestParam("id") String id) {
        articleService.delete(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
