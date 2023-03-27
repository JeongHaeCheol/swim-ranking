package com.example.swimranking.dto;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.example.swimranking.model.Competition;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Data
public class CompetitionDto {
 
    @NotEmpty
    private String name;
    private String location;
    private Date date;


    @QueryProjection
    public CompetitionDto(Competition competition) {
        this.name = competition.getName();
        this.location = competition.getLocation();
        this.date = competition.getDate();
    }
    
}
