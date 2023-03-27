package com.example.swimranking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.swimranking.dto.EventResultDto;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import static com.example.swimranking.model.QSwimmer.swimmer;
import static com.example.swimranking.model.QEventResult.eventResult;


// QClass import by static !!!!!!!!!!!
@Repository
@RequiredArgsConstructor
public class EventResultRepositoryCustom {
    
    private final JPAQueryFactory queryFactory;


    // 1. 이름으로 조회 (구별을 위해 Swimmer 엔티티와 조인)
    public List<EventResultDto> findEventResultByName(String name) {
        List<EventResultDto> result = queryFactory.select(Projections.constructor(EventResultDto.class, eventResult, swimmer.birth, swimmer.club, swimmer.country, swimmer.gender))
        .from(eventResult, swimmer)
        .where(eventResult.name.eq(swimmer.name))
        .fetch();

        return result;

    }
    
    
}
