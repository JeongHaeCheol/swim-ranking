package com.example.swimranking.dto;

import javax.validation.constraints.NotEmpty;

import com.example.swimranking.model.UnOfficialRecord;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestUnOfficialRecordDto {


    private UnOfficialRecord unOfficialRecord;

    @NotEmpty
    private String SwimmingPoolName;
    
}
