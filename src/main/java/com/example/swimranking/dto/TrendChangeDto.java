package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.example.swimranking.model.Competition;
import com.example.swimranking.model.EventResult;
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
public class TrendChangeDto {


    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date date;

    private String competitionName;

    @NotNull
    private double raceTime;



    @QueryProjection
    public TrendChangeDto(EventResult eventResult) {
        Competition competition = eventResult.getCompetition();
        if(competition != null) {
            this.date = competition.getDate();
            this.competitionName = competition.getName();
        }   
        this.raceTime = eventResult.getRaceTime();
    }


    
}