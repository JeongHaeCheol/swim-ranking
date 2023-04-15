package com.example.swimranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.SwimmingPool;

@Repository
public interface SwimmingPoolRepository extends JpaRepository<SwimmingPool, Integer> {

    public SwimmingPool findSwimmingPoolById(int id);
    public SwimmingPool findSwimmingPoolByName(String Name);

    
}
