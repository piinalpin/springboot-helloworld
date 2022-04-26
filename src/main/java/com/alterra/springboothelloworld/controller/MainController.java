package com.alterra.springboothelloworld.controller;

import com.alterra.springboothelloworld.service.MainService;
import com.alterra.springboothelloworld.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public ResponseEntity<Object> hello() {
        log.info("Add feature management user");
        return mainService.main();
    }
    
}
