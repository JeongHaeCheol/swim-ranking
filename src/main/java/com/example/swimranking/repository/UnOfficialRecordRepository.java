package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.UnOfficialRecord;

@Repository
public interface UnOfficialRecordRepository extends JpaRepository<UnOfficialRecord, Integer> {

    public SwimmingPool findUnOfficialRecordById(int id);
    public SwimmingPool findUnOfficialRecordByName(String Name);

    
}
