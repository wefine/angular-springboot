package com.wefine.app.controller;

import com.wefine.app.entity.People;
import com.wefine.app.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/people")
public class PeopleController {

    @Resource
    private PeopleService service;

    @GetMapping
    public ResponseEntity<List<People>> getAllArticles() {
        List<People> list = service.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getPeople(@PathVariable long id) {
        People people = service.findById(id);

        if (people != null) {
            return new ResponseEntity<>(people, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPeople(@RequestBody People People) {
        return new ResponseEntity<>(service.create(People), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeople(@PathVariable long id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
