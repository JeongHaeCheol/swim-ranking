package com.example.swimranking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.example.swimranking.dto.CompetitionDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Entity
@Table(name="competition")
@NoArgsConstructor
public class Competition {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    @NotEmpty
    private String name;
    private String location;

    private int poolSize;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date date;


    public Competition(CompetitionDto competitionDto) {
        this.name = competitionDto.getName();
        this.location = competitionDto.getLocation();
        this.date = competitionDto.getDate();
        this.poolSize = competitionDto.getPoolSize();
    }


}
