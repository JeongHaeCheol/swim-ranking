package com.example.swimranking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.model.Swimmer;
import com.example.swimranking.service.SwimmerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SwimmerController {


    private final SwimmerService swimmerService;

    @GetMapping("/swimmer")
    public ResponseEntity getSwimmer(@RequestParam String name) {

        List<SwimmerDto> result = swimmerService.findSwimmersByName(name);

        if(result == null || result.isEmpty()) {
            return ResponseEntity.ok("result : no data");
        }
        
        return ResponseEntity.ok(result);

    }

    @PostMapping("/swimmer")
    public ResponseEntity postSwimmer(@RequestBody SwimmerDto swimmerDto) {
        
        Swimmer swimmer = swimmerService.saveSwimmer(swimmerDto);

        if(swimmer == null) {
            ResponseEntity.ok("result : save failed");
        }

        return ResponseEntity.ok(swimmer);
        
    }

    
}
