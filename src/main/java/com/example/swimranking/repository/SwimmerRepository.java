package com.example.swimranking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.model.Swimmer;



@Repository
public interface SwimmerRepository extends JpaRepository<Swimmer, Integer> {

    public Swimmer findSwimmerById(int id);

}
