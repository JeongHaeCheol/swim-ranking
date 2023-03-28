package com.example.swimranking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.example.swimranking.dto.SwimmerDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="swimmers")
@NoArgsConstructor
public class Swimmer {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    @NotEmpty
    private String name;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date birth;

    private String club;

    @NotEmpty
    private String gender;
    private String country;



    public Swimmer(SwimmerDto swimmerDto) {
        this.name = swimmerDto.getName();
        this.birth = swimmerDto.getBirth();
        this.club = swimmerDto.getClub();
        this.gender = swimmerDto.getGender();
        this.country = swimmerDto.getCountry();
    }



    
}
