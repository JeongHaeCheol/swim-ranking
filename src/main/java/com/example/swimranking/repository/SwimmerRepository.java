package com.example.swimranking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.model.Swimmer;



@Repository
public interface SwimmerRepository extends JpaRepository<Swimmer, Integer> {

}
