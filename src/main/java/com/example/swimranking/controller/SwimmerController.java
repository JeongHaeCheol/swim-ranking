package com.example.swimranking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.service.SwimmerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("swimmer/")
@RequiredArgsConstructor
public class SwimmerController {


    // private final SwimmerService swimmerService;

    // @GetMapping()
    // public ResponseEntity getSwimmer(@RequestParam String name) {

    //     List<SwimmerDto> result = swimmerService.findSwimmersByName(name);

    //     return ResponseEntity.ok(result);

    // }

    
}
