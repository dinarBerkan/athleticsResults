package com.bogazici.athleticsresult.dto;

import com.bogazici.athleticsresult.enumeration.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class AthleteDto {
    private UUID id;

    private String name;

    private String birthDate;

    private Gender gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ResultDto> resultList;
}