package com.example.swimranking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.EventResultDto;
import com.example.swimranking.repository.EventResultRepositoryCustom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EventResultController {


    // 추후 서비스로 변경
    private final EventResultRepositoryCustom eventResultRepositoryCustom;

    @GetMapping("/event_result")
    public ResponseEntity getEventResult(@RequestParam String name) {

        List<EventResultDto> result = eventResultRepositoryCustom.findEventResultByName(name);

        log.info("test : " + result.toString());
        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }

    // @PostMapping("/swimmer")
    // public ResponseEntity postSwimmer(@RequestBody SwimmerDto swimmerDto) {
        
    //     Swimmer swimmer = swimmerService.saveSwimmer(swimmerDto);

    //     if(swimmer == null) {
    //         ResponseEntity.ok("result : save failed");
    //     }

    //     return ResponseEntity.ok(swimmer);
        
    // }

    
}
