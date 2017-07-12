package com.wefine.app.controller;


import com.wefine.app.entity.Article;
import com.wefine.app.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        log.info("Get all articles...");
        List<Article> list = articleService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createArticle(
            @RequestBody Article article,
            UriComponentsBuilder builder) {
        log.info("Add article...");
        Article a = articleService.create(article);
        if (a.getId() == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        log.info("Update article...");
        articleService.update(article);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
        log.info("Delete article...");
        articleService.delete(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable String id) {
        log.info("Find article by id...");
        Article article = articleService.findById(Long.parseLong(id));

        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
