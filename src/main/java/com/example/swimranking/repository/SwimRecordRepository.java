package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.SwimRecord;

@Repository
public interface SwimRecordRepository extends JpaRepository<SwimRecord, Integer> {

    public SwimRecord findSwimRecordById(int id);
    public SwimRecord findSwimRecordByName(String Name);
    public SwimRecord findSwimRecordBySwimmerId(int id);
    
}
