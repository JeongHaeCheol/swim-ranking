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
public class CompetitionDto {
 
    @NotEmpty
    private String name;
    private String location;
    private Date date;
    private int poolSize;


    @QueryProjection
    public CompetitionDto(Competition payload) {
        this.name = payload.getName();
        this.location = payload.getLocation();
        this.date = payload.getDate();
        this.poolSize = payload.getPoolSize();
    }
    
}
