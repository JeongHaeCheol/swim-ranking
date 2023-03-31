package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.Competition;


@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    
    public Competition findCompetitionByName(String name);
}
