package com.example.swimranking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.EventResultDto;
import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.dto.TrendChangeDto;
import com.example.swimranking.model.EventResult;
import com.example.swimranking.model.Swimmer;
import com.example.swimranking.repository.EventResultRepository;
import com.example.swimranking.repository.EventResultRepositoryCustom;
import com.example.swimranking.service.EventResultService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final EventResultService eventResultService;


    @GetMapping("/trend")
    public ResponseEntity getTrend(@RequestParam int swimmerId, @RequestParam int eventId) {

        List<TrendChangeDto> result = eventResultService.getTrend(swimmerId, eventId);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }


    
}
