package com.bogazici.athleticsresult.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class CreateResultRequest {
    private Long id;

    private String competitionName;

    private UUID athleteId;

    private Long eventId;

    private String resultMark;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date resultDate;

    private String resultLocation;
}
