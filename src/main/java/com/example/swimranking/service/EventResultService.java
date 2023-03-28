package com.example.swimranking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.dto.EventResultDto;
import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.model.EventResult;
import com.example.swimranking.model.Swimmer;
import com.example.swimranking.repository.EventResultRepository;
import com.example.swimranking.repository.EventResultRepositoryCustom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventResultService {

    
    private final EventResultRepositoryCustom eventResultRepositoryCustom;
    private final EventResultRepository eventResultRepository;
    

    public List<EventResultDto> findEventResultByNameJoin(String name) {
        return eventResultRepositoryCustom.findEventResultByNameJoin(name);   
    }

    public List<EventResult> getSimple(String name) {
        return eventResultRepository.findEventResultByName(name);   
    }

    public EventResult saveEventResult(EventResult eventResult) {

        try {
            eventResultRepository.saveAndFlush(eventResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save eventResult : " + eventResult);
        return eventResult;

    }

    public List<EventResultDto> findEventResultByName(String name) {
        return eventResultRepositoryCustom.findEventResultByName(name);

    }

    

    
}
