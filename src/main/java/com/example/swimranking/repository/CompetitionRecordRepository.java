package com.example.swimranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.CompetitionRecord;


@Repository
public interface CompetitionRecordRepository extends JpaRepository<CompetitionRecord, Integer> {
    
    List<CompetitionRecord> findByName(String name);
}
