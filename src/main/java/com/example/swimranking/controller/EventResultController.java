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
public class EventResultController {


    // 추후 서비스로 변경
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


    @GetMapping("/event_result")
    public ResponseEntity getEventResult(@RequestParam String name) {

        List<EventResultDto> result = eventResultService.findEventResultByNameJoin(name);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }


    @GetMapping("/event_result2")
    public ResponseEntity getEventResult2(@RequestParam String name) {

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

    
}
