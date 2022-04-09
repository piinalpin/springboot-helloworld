package com.alterra.springboothelloworld.repository;

import com.alterra.springboothelloworld.domain.dao.Learning;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningRepository extends JpaRepository<Learning, Long> {
    
}
