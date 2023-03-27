package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.EventResult;


@Repository
public interface EventResultRepository extends JpaRepository<EventResult, Integer> {
    
}
