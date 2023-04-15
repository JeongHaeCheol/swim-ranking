package com.example.swimranking.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.swimranking.model.Swimmer;
import com.example.swimranking.model.SwimmingPool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestDataConstructorService {

    private final SwimmerService swimmerService;

    private final SwimmingPoolService swimmingPoolService;

    @PostConstruct
    public void init() {

        Calendar calendar = Calendar.getInstance();

        if(swimmerService.countSwimmer() == 0) {
            List<Swimmer> swimmerList  = new ArrayList<>();
            int birArgs = 80;
            for(int i = 0; i < 25; i++) {
                
                Swimmer swimmer = new Swimmer();
                swimmer.setGender(i % 2 ==  1 ? "남" : "여");
                swimmer.setName("swimmer " + i);
                swimmer.setCountry("Korea");

                Date now = new Date();
                calendar.setTime(now);
                calendar.add(Calendar.YEAR, i * -1);
                Date birth = calendar.getTime();
                swimmer.setBirth(birth);
            
                swimmerList.add(swimmer);     
            }

            swimmerService.saveSwimmers(swimmerList);
            log.info("### Swimmer Test Data save");
        }


        if(swimmingPoolService.countSwimmingPool() == 0) {
            List<SwimmingPool> swimmingPoolsList = new ArrayList();

            for(int i = 0; i < 10; i++) {
                SwimmingPool swimmingPool = new SwimmingPool();
                swimmingPool.setLocation("test " + i );
                swimmingPool.setName("수영장Test" + i);
                swimmingPoolsList.add(swimmingPool);
            }

            swimmingPoolService.saveSwimmingPoolList(swimmingPoolsList);
        }



    }

}