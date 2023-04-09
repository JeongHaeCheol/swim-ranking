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
public class RecordController {

    private final EventResultService eventResultService;


    @GetMapping("/simple")
    public ResponseEntity getSimple(@RequestParam String name) {

        List<EventResult> result = eventResultService.getSimple(name);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }



    // 동명이인을 구별하기 위한 검색 ->  join을 사용 -> 필요없을듯? -> 연관관계 활용하는 쿼리 사용하는게 더 나을듯
    @GetMapping("/event_result")
    public ResponseEntity getEventResult(@RequestParam String name) {

        List<EventResultDto> result = eventResultService.findEventResultByNameJoin(name);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }

    // 이름만으로 검색 -> 연관관계 테이블을 검색에 활용하지 않음
    @GetMapping("/event_result2")
    public ResponseEntity getEventResult2(@RequestParam String name) {


        log.info("### called : param -> "  + name);

        List<EventResultDto> result = eventResultService.findEventResultByName(name);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }

    @PostMapping("/event_result")
    public ResponseEntity postEventResult(@RequestBody EventResult eventResult) {
        
        EventResult result = eventResultService.saveEventResult(eventResult);

        if(result == null) {
            ResponseEntity.ok("result : save failed");
        }

        return ResponseEntity.ok(result);
    }



    @PostMapping("/result")
    public ResponseEntity postResult(@RequestBody EventResultDto eventResultDto) {
        

        log.info("### save postResult : " + eventResultDto);
        boolean result = eventResultService.SaveEventResultByRelation(eventResultDto);

        if(result == false) {
            ResponseEntity.ok("result : save failed");
        }

        return ResponseEntity.ok(result);
    }
    
}
