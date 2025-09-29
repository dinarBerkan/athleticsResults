package com.bogazici.athleticsresult.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date resultDate;

    private String resultLocation;
}
