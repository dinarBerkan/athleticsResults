package com.bogazici.athleticsresult.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ResultDto {
    private Long id;

    private String competitionName;

    private AthleteDto athlete;

    private EventDto event;

    private String resultMark;

    private Date resultDate;

    private String resultLocation;
}
