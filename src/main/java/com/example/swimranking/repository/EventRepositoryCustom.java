package com.example.swimranking.repository;


import org.springframework.stereotype.Repository;

import com.example.swimranking.model.Event;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import static com.example.swimranking.model.QSwimmer.swimmer;
import static com.example.swimranking.model.QEventResult.eventResult;
import static com.example.swimranking.model.QEvent.event;
import static com.example.swimranking.model.QCompetition.competition;;

@Repository
@RequiredArgsConstructor
public class EventRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    public Event findEventByName(String eventName){

        
        String[] strArr = null;
        String stroke = null;
        String distance = null;
        boolean finCheck = false;

        if(eventName != null) {
            strArr = eventName.split("\\s");

            if(strArr.length == 3 && strArr[0].equals("핀")){
                finCheck = true;
                stroke = strArr[1];
                distance = strArr[2];
            }
            else {
                finCheck = false;
                stroke = strArr[0];
                distance = strArr[1];
            }
        }

        Event result = queryFactory.selectFrom(event)
        .where(event.finCheck.eq(finCheck), event.stroke.eq(stroke), event.distance.eq(distance))
        .fetchOne();

        return result;

    }

    
}
