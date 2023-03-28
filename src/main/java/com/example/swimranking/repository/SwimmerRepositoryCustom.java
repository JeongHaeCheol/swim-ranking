package com.example.swimranking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.model.QSwimmer;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import static com.example.swimranking.model.QSwimmer.swimmer;


// QClass import by static !!!!!!!!!!!
@Repository
@RequiredArgsConstructor
public class SwimmerRepositoryCustom {
    
    private final JPAQueryFactory queryFactory;

    public List<SwimmerDto> findSwimmersByName(String name) {
        List<SwimmerDto> result = queryFactory.select(Projections.constructor(SwimmerDto.class, swimmer))
        .from(swimmer)
        .where(swimmer.name.eq(name))
        .orderBy(swimmer.name.asc())
        .fetch();

        return result;

    }
    
    
}
