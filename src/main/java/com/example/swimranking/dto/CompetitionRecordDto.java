package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.swimranking.model.Competition;
import com.example.swimranking.model.Event;
import com.example.swimranking.model.CompetitionRecord;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionRecordDto {

    private Date birth;

    // 동명이인 구별을 돕는 컬럼이기 때문에 Member의 club으로 할당
    private String club;

    private String country;

    private String gender;

    private String ageRange;

    @NotEmpty
    private String name;

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
    public CompetitionRecordDto(CompetitionRecord payload, String club, Date birth, String country, String gender) {
        this.birth = birth;
        this.club = club;
        this.country = country;
        this.gender = gender;
        this.poolSize = payload.getCompetition().getPoolSize();
        this.competitionDate = payload.getCompetition().getDate();
        this.ageRange = payload.getAgeRange();
        this.name = payload.getName();
        this.competitionName = payload.getCompetition().getName();
        this.eventName = payload.getEvent().getName();
        this.distance = payload.getEvent().getDistance();
        this.stroke = payload.getEvent().getStroke();
        this.raceTime = payload.getRaceTime();
        this.raceRank = payload.getRaceRank();
    }

    @QueryProjection
    public CompetitionRecordDto(CompetitionRecord payload) {

        Competition competition = payload.getCompetition();
        Event event = payload.getEvent();

        
        if(competition != null) {
            this.competitionName = competition.getName();
            this.competitionDate = competition.getDate();
            this.poolSize = competition.getPoolSize();
        }
        if(event != null) {
            this.eventName = event.getName();
            this.distance = event.getDistance();
            if(event.isFinCheck()){
                this.stroke = "핀" + event.getStroke();
            }
            else {
                this.stroke = event.getStroke();
            }
        }
     
        this.ageRange = payload.getAgeRange();
        this.name = payload.getName();
        this.raceTime = payload.getRaceTime();
        this.raceRank = payload.getRaceRank();
    }

    

    
}
