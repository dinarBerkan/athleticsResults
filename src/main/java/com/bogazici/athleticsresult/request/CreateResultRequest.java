package com.bogazici.athleticsresult.request;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.dto.EventDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateResultRequest {
    private Long id;

    private String competitionName;

    private Long athleteId;

    private Long eventId;

    private String resultMark;

    private Date resultDate;

    private String resultLocation;
}
