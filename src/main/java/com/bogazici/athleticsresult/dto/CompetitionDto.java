package com.bogazici.athleticsresult.dto;

import com.bogazici.athleticsresult.entity.Country;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Builder
public class CompetitionDto {
    private UUID competitionId;

    private String competitionName;

    private Date startDate;

    private Date endDate;

    private Country country;
}