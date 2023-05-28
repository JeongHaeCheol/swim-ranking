package com.example.swimranking.dto;

import javax.validation.constraints.NotEmpty;

import com.example.swimranking.model.Event;
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
public class EventDto {
    
    
    @NotEmpty
    private String name;

    @NotEmpty
    private String distance;

    @NotEmpty
    private String stroke;

    private boolean finCheck;

    
    @QueryProjection
    public EventDto(Event payload) {
        this.name = payload.getName();
        this.distance = payload.getDistance();
        this.stroke = payload.getStroke();
        this.finCheck = payload.isFinCheck();
    }

    

}
