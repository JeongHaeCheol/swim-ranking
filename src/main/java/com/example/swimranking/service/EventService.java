package com.example.swimranking.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.swimranking.model.Event;
import com.example.swimranking.repository.EventRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {


    private final EventRepository eventRepository;

    private List<String> strokeList = new ArrayList<>();

    private List<Event> eventList = new ArrayList<>();

    @PostConstruct
    public void init() {


        // 이미 존재하면 init 생략
        if( !eventRepository.findAll().isEmpty()) {
            return;
        }

        strokeList.add("자유형");
        strokeList.add("배영");
        strokeList.add("평영");
        strokeList.add("접영");
        strokeList.add("개인혼영"); // index = 4, 100 이상
        strokeList.add("계영"); // index >= 5, 200 이상
        strokeList.add("혼계영");
        strokeList.add("혼성 계영");
        strokeList.add("혼성 혼계영");

        for (int fin = 0; fin <2; fin++) {

            for(int i = 0; i < strokeList.size(); i++) {
                Integer distance = 25;
                String stroke = strokeList.get(i);

                for(int j = 0; j < 5; j++) {

                    Event event = new Event();

                    if(j > 0) {
                        distance = distance * 2;
                    }

                    // 접배평자 200m까지만 (자유형 400m 이상은 밑에서 처리)
                    if(i <= 3 && distance > 200) {
                        continue;
                    }

                    // 개인 혼영은 100m이하는 생성x
                    if(i == 4 && distance < 100) {
                        continue;
                    }

                    // 계영 단위는 200m이하는 생성x
                    if(i >= 5 && distance < 200) {
                        continue;
                    }

                    if(fin == 0) {
                        event.setFinCheck(false);
                    } 
                    else {
                        event.setFinCheck(true);
                    }
                    event.setDistance(distance.toString());
                    event.setStroke(stroke);
                    eventList.add(event);
                }
            }
        }

        // 중장거리
        for(int l = 0; l < 2; l++) {
            for(int k = 0; k < 4; k++) { 

                Event event = new Event();

                if(l == 0) {
                    event.setFinCheck(false);
                }
                else {
                    event.setFinCheck(true);
                }
                Integer distance = 400;
                if(k == 1) {
                    distance = 800;
                }
                if(k == 2) {
                    distance = 1500;
                }
                if(k == 3) {
                    distance = 3800;
                }
                event.setDistance(distance.toString());
                event.setStroke("자유형");
                eventList.add(event);
            }
        }
   

        eventRepository.saveAll(eventList);
        log.info("### event entity init");

    }
    
}
