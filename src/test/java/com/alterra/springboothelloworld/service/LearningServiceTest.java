package com.alterra.springboothelloworld.service;

import com.alterra.springboothelloworld.domain.common.ApiResponse;
import com.alterra.springboothelloworld.domain.dao.Learning;
import com.alterra.springboothelloworld.domain.dto.LearningRequest;
import com.alterra.springboothelloworld.repository.LearningRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LearningService.class)
class LearningServiceTest {

    @MockBean
    private LearningRepository learningRepository;

    @Autowired
    private LearningService learningService;

    @Test
    void getAllSuccess_Test() {
        when(learningRepository.findAll())
                .thenReturn(List.of(Learning.builder()
                        .id(1L)
                        .createdAt(LocalDateTime.now())
                        .createdBy("SYSTEM")
                        .material("Hello World!")
                        .isDeleted(false)
                        .build()));

        ResponseEntity<Object> responseEntity = learningService.getAll();
        ApiResponse response = (ApiResponse) responseEntity.getBody();
        List<Learning> learnings = (List<Learning>) Objects.requireNonNull(response).getData();
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(1, learnings.size());
    }

    @Test
    void addLearningSuccess_Test() {
        when(learningRepository.save(any()))
                .thenReturn(Learning.builder()
                        .id(1L)
                        .createdAt(LocalDateTime.now())
                        .createdBy("SYSTEM")
                        .material("Hello World!")
                        .isDeleted(false)
                        .build());

        ResponseEntity<Object> responseEntity = learningService.addLearning(LearningRequest.builder().material("Hello World!").build());
        ApiResponse response = (ApiResponse) responseEntity.getBody();
        Learning learning = (Learning) Objects.requireNonNull(response).getData();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals("Success", response.getMessage());
        assertEquals(1L, learning.getId());
        assertEquals("Hello World!", learning.getMaterial());
    }

}