package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

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

    private String club;

    private String country;

    @NotEmpty
    private String gender;

    @NotEmpty
    private String name;

    @NotEmpty
    private int swimmer_id;

    @NotEmpty
    private int competition_id;

    @NotEmpty
    private int event_id;

    @NotEmpty
    private double raceTime;

    @NotEmpty
    private String raceRank;

    @QueryProjection
    public EventResultDto(EventResult eventResult, Date birth, String club, String country, String gender) {
        this.birth = birth;
        this.club = club;
        this.country = country;
        this.gender = gender;
        
        this.name = eventResult.getName();
        this.swimmer_id = eventResult.getSwimmer_id();
        this.competition_id = eventResult.getCompetition_id();
        this.event_id = eventResult.getEvent_id();
        this.raceTime = eventResult.getRaceTime();
        this.raceRank = eventResult.getRaceRank();
    }

    
    
}
