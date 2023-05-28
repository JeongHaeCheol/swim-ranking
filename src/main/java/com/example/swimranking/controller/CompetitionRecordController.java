package com.example.swimranking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.CompetitionRecordDto;
import com.example.swimranking.model.CompetitionRecord;
import com.example.swimranking.repository.CompetitionRecordRepository;
import com.example.swimranking.repository.CompetitionRecordRepositoryCustom;
import com.example.swimranking.service.CompetitionRecordService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller("competition_record")
@RequiredArgsConstructor
@Slf4j
public class CompetitionRecordController {

    private final CompetitionRecordService competitionRecordService;


    @Operation(summary = "이름으로 대회기록 검색", description = "동명이인 구별 불가능")
    @GetMapping("/name")
    public ResponseEntity findByName(@RequestParam String name) {


        log.info("### called : param -> "  + name);

        List<CompetitionRecordDto> result = competitionRecordService.findCompetitionRecordByName(name);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }



    // DTO로 저장
    @PostMapping("/")
    @Operation(summary = "대회기록 저장")
    public ResponseEntity postResult(@RequestBody CompetitionRecordDto competitionRecordDto) {
        

        log.info("### save postResult : " + competitionRecordDto);
        boolean result = competitionRecordService.SaveCompetitionRecordByRelation(competitionRecordDto);

        if(result == false) {
            ResponseEntity.ok("result : save failed");
        }

        return ResponseEntity.ok(result);
    }
    
}
