package com.bogazici.athleticsresult.dto;

import com.bogazici.athleticsresult.enumeration.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class AthleteDto {
    private Long id;

    private String name;

    private String birthDate;

    private Gender gender;

    private List<ResultDto> resultList;
}