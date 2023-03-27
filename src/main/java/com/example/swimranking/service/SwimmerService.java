package com.example.swimranking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.repository.SwimmerRepository;
import com.example.swimranking.repository.SwimmerRepositoryCustom;
import com.querydsl.core.QueryFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SwimmerService {


    private final SwimmerRepository swimmerRepository;
    private final SwimmerRepositoryCustom swimmerRepositoryCustom;


    public List<SwimmerDto> findSwimmersByName(String name) {
        return swimmerRepositoryCustom.findSwimmersByName(name);        
    }


    

    
}
