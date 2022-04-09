package com.alterra.springboothelloworld.controller;

import com.alterra.springboothelloworld.domain.dto.LearningRequest;
import com.alterra.springboothelloworld.service.LearningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/learning")
public class LearningController {

    @Autowired
    private LearningService learningService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return learningService.getAll();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addLearning(@RequestBody LearningRequest request) {
        return learningService.addLearning(request);
    }
    
    
}
