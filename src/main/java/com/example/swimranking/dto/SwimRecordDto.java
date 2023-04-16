package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.swimranking.model.Event;
import com.example.swimranking.model.Swimmer;
import com.example.swimranking.model.SwimRecord;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Slf4j
public class SwimRecordDto {

    @NotEmpty
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date birth;

    private String club;

    @NotEmpty
    private String gender;

    private String country;

    private String event;

    // NotEmpty는 String에만 사용 null 과 ""을 다 배제하기 때문에
    @NotNull
    private double record;

    private boolean officialCheck;

    private Date measuredDate;



    @QueryProjection
    public SwimRecordDto(SwimRecord swimRecord) {

        Swimmer swimmer = swimRecord.getSwimmer();
        Event event = swimRecord.getEvent();

        String fin = "";

        if (event != null) {
            fin = event.isFinCheck() ? "핀" : "";
            String eventStr = fin + event.getStroke() + event.getDistance();
            this.event = eventStr;
        }

        if (swimmer != null) {
            this.birth = swimmer.getBirth();
            this.club = swimmer.getClub();
            this.gender = swimmer.getGender();
            this.country = swimmer.getCountry();
        }
        this.officialCheck =swimRecord.isOfficialCheck();
        this.name = swimRecord.getName();
        this.record = swimRecord.getRecord();
        this.measuredDate = swimRecord.getMeasuredDate();
    }

}
