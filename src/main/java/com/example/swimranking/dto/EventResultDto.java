package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.swimranking.model.Competition;
import com.example.swimranking.model.Event;
import com.example.swimranking.model.EventResult;
import com.example.swimranking.model.Swimmer;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String ageRange;

    @NotEmpty
    private String name;

    private int swimmer_id;

    private String competitionName;

    private String eventName;

    private String distance;

    private String stroke;

    private int poolSize;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date competitionDate;

    @NotNull
    private double raceTime;

    private String raceRank;

    @QueryProjection
    public EventResultDto(EventResult eventResult, String club, Date birth, String country, String gender) {
        this.birth = birth;
        this.club = club;
        this.country = country;
        this.gender = gender;
        this.poolSize = eventResult.getCompetition().getPoolSize();
        this.competitionDate = eventResult.getCompetition().getDate();
        this.ageRange = eventResult.getAgeRange();
        this.name = eventResult.getName();
        this.swimmer_id = eventResult.getSwimmer().getId();
        this.competitionName = eventResult.getCompetition().getName();
        this.eventName = eventResult.getEvent().getName();
        this.distance = eventResult.getEvent().getDistance();
        this.stroke = eventResult.getEvent().getStroke();
        this.raceTime = eventResult.getRaceTime();
        this.raceRank = eventResult.getRaceRank();
    }

    @QueryProjection
    public EventResultDto(EventResult eventResult) {

        Swimmer swimmer = eventResult.getSwimmer();
        Competition competition = eventResult.getCompetition();
        Event event = eventResult.getEvent();

        if(swimmer != null) {
            this.birth = swimmer.getBirth();
            this.club = swimmer.getClub();
            this.country = swimmer.getCountry();
            this.gender = swimmer.getGender();
            this.swimmer_id = swimmer.getId();
        }
        
        if(competition != null) {
            this.competitionName = competition.getName();
            this.competitionDate = competition.getDate();
            this.poolSize = competition.getPoolSize();
        }
        if(event != null) {
            this.eventName = event.getName();
            this.distance = event.getDistance();
            this.stroke = event.getStroke();
        }
     
        this.ageRange = eventResult.getAgeRange();
        this.name = eventResult.getName();
        this.raceTime = eventResult.getRaceTime();
        this.raceRank = eventResult.getRaceRank();
    }


    
}
