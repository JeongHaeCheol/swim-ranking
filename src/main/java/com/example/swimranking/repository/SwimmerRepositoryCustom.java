package com.example.swimranking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.swimranking.dto.SwimmerDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;



@Repository
@RequiredArgsConstructor
public class SwimmerRepositoryCustom {
    
    
    private final JPAQueryFactory queryFactory;

    private QSwimmer qSwimmer = QSwimmer.swimmer;

    public List<SwimmerDto> findSwimmersByName(String name) {
        List<SwimmerDto> result = queryFactory.select(Projections.constructor(SwimmerDto.class, qSwimmer))
        .where(qSwimmer.name.eq(name))
        .orderBy(qSwimmer.name.asc())
        .fetch();

        return result;

    }
    
    
}
