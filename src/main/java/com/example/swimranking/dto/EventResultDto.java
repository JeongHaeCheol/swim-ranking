package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.swimranking.model.Competition;
import com.example.swimranking.model.Event;
import com.example.swimranking.model.EventResult;
import com.example.swimranking.model.Swimmer;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class EventResultDto {

    private Date birth;

    // 동명이인 구별을 돕는 컬럼이기 때문에 swimmer의 club으로 할당
    private String club;

    private String country;

    private String gender;

    @NotEmpty
    private String name;

    private int swimmer_id;

    private String competitionName;

    private String eventName;

    private String distance;

    private String stroke;

    @NotNull
    private double raceTime;

    private String raceRank;

    @QueryProjection
    public EventResultDto(EventResult eventResult, String club, Date birth, String country, String gender) {
        this.birth = birth;
        this.club = club;
        this.country = country;
        this.gender = gender;
        
        this.name = eventResult.getName();
        this.swimmer_id = eventResult.getSwimmer().getId();
        this.competitionName = eventResult.getCompetition().getName();
        this.eventName = eventResult.getEvent().getName();
        this.distance = eventResult.getEvent().getDistance();
        this.stroke = eventResult.getEvent().getStroke();
        this.raceTime = eventResult.getRaceTime();
        this.raceRank = eventResult.getRaceRank();
    }


    
}
