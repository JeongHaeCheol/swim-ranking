package com.example.swimranking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.swimranking.dto.CompetitionRecordDto;
import com.example.swimranking.dto.TrendChangeDto;
import com.example.swimranking.model.Competition;
import com.example.swimranking.model.Event;
import com.example.swimranking.model.CompetitionRecord;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import static com.example.swimranking.model.QCompetitionRecord.competitionRecord;
import static com.example.swimranking.model.QEvent.event;
import static com.example.swimranking.model.QCompetition.competition;;

// QClass import by static !!!!!!!!!!!
@Repository
@RequiredArgsConstructor
public class CompetitionRecordRepositoryCustom {

    private final JPAQueryFactory queryFactory;



    // 1. 이름으로 조회
    public List<CompetitionRecordDto> findCompetitionRecordByName(String name) {
        List<CompetitionRecordDto> result = queryFactory.select(Projections.constructor(
                CompetitionRecordDto.class, competitionRecord))
                .from(competitionRecord)
                .where(competitionRecord.name.eq(name))
                .orderBy(competitionRecord.competition.date.desc())
                .fetch();

        return result;
    }


}
