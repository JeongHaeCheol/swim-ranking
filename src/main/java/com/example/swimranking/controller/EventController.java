package com.example.swimranking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.swimranking.model.Event;
import com.example.swimranking.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller("event")
@RequiredArgsConstructor
@Slf4j
public class EventController {

    private final EventService eventService;


    @GetMapping()
    @Operation(summary = "종목 리스트" , description = "eventId를 찾을때 사용")
    public ResponseEntity findAll() {
        List<Event> result = eventService.findAll();
        return ResponseEntity.ok(result);
    }
    
}
