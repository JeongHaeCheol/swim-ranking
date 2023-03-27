package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    
}
