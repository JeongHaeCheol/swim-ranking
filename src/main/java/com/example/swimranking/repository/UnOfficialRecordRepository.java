package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.UnOfficialRecord;

@Repository
public interface UnOfficialRecordRepository extends JpaRepository<UnOfficialRecord, Integer> {

    public UnOfficialRecord findUnOfficialRecordById(int id);
    public UnOfficialRecord findUnOfficialRecordByName(String Name);
    
}
