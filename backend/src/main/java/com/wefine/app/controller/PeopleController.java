package com.wefine.app.controller;

import com.wefine.app.entity.People;
import com.wefine.app.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("api")
public class PeopleController {

    @Resource
    private PeopleService service;

    @GetMapping("peoples")
    public ResponseEntity<List<People>> getAllArticles() {
        List<People> list = service.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
