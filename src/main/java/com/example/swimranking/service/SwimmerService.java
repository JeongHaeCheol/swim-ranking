package com.example.swimranking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.model.Swimmer;
import com.example.swimranking.repository.SwimmerRepository;
import com.example.swimranking.repository.SwimmerRepositoryCustom;
import com.querydsl.core.QueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SwimmerService {

    
    private final SwimmerRepository swimmerRepository;
    private final SwimmerRepositoryCustom swimmerRepositoryCustom;
    

    public List<SwimmerDto> findSwimmersByName(String name) {
        // return swimmerRepositoryCustom.findSwimmersByName(name);       
        return null; 
    }

    // public Swimmer saveSwimmer(SwimmerDto swimmerDto) {
        
    //     Swimmer swimmer = new Swimmer(swimmerDto);

    //     try {
    //         swimmerRepository.saveAndFlush(swimmer);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }

    //     log.info("save Swimmer : " + swimmer);
    //     return swimmer;

    // }

    

    
}
