package com.example.swimranking.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.swimranking.model.Event;
import com.example.swimranking.model.UnOfficialRecord;
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
    public SwimRecordDto(UnOfficialRecord payload) {


        Event event = payload.getEvent();

        String fin = "";

        if (event != null) {
            fin = event.isFinCheck() ? "핀" : "";
            String eventStr = fin + event.getStroke() + event.getDistance();
            this.event = eventStr;
        }

        this.officialCheck =payload.isOfficialCheck();
        this.name = payload.getName();
        this.record = payload.getRecord();
        this.measuredDate = payload.getMeasuredDate();
    }

}
