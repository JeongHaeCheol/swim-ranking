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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Entity
@Table(name="competitions")
@NoArgsConstructor
public class Competition {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    @NotEmpty
    private String name;
    private String location;
    private Date date;


    public Competition(CompetitionDto competitionDto) {
        this.name = competitionDto.getName();
        this.location = competitionDto.getLocation();
        this.date = competitionDto.getDate();
    }


}
