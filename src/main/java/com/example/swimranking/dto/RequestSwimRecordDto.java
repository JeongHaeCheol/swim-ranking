package com.example.swimranking.dto;

import javax.validation.constraints.NotEmpty;

import com.example.swimranking.model.SwimRecord;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestSwimRecordDto {


    private SwimRecord swimRecord;

    @NotEmpty
    private String SwimmingPoolName;
    
}
