package com.example.swimranking.dto;
import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

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
public class SwimmerDto {

    @NotEmpty
    private String name;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date birth;

    private String club;

    @NotEmpty
    private String gender;
    private String country;


    @QueryProjection
    public SwimmerDto(Swimmer swimmer) {
        this.name = swimmer.getName();
        this.birth = swimmer.getBirth();
        this.club = swimmer.getClub();
        this.gender = swimmer.getGender();
        this.country = swimmer.getCountry();
    }

    

}
