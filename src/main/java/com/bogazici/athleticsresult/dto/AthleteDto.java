package com.bogazici.athleticsresult.dto;

import com.bogazici.athleticsresult.enumeration.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AthleteDto {
    private Long id;

    private String name;

    private Date birthdate;

    private Gender gender;
}