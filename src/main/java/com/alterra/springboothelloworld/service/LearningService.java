package com.alterra.springboothelloworld.service;

import com.alterra.springboothelloworld.domain.dao.Learning;
import com.alterra.springboothelloworld.domain.dto.LearningRequest;
import com.alterra.springboothelloworld.repository.LearningRepository;
import com.alterra.springboothelloworld.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LearningService {

    @Autowired
    private LearningRepository learningRepository;

    public ResponseEntity<Object> getAll() {
        log.info("Get all learning");
        return ResponseUtil.build("Success", learningRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> addLearning(LearningRequest request) {
        log.info("Add learning");
        Learning learning = Learning.builder()
            .material(request.getMaterial())
            .build();
        learningRepository.save(learning);
        return ResponseUtil.build("Success", learning, HttpStatus.OK);
    }
    
}
