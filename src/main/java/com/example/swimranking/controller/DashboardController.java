package com.example.swimranking.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swimranking.dto.CompetitionRecordDto;
import com.example.swimranking.dto.TrendChangeDto;
import com.example.swimranking.model.CompetitionRecord;
import com.example.swimranking.repository.CompetitionRecordRepository;
import com.example.swimranking.repository.CompetitionRecordRepositoryCustom;
import com.example.swimranking.service.CompetitionRecordService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;





@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final CompetitionRecordService competitionRecordService;


    @GetMapping("/trend")
    @Operation(summary = "기록변화 추이 검색", description = "memberId와 eventID 필요")
    public ResponseEntity getTrend(@RequestParam int memberId, @RequestParam int eventId) {

        List<TrendChangeDto> result = competitionRecordService.getTrend(memberId, eventId);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }



    
}
