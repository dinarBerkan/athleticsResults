package com.bogazici.athleticsresult.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDto {
    private Long id;

    private String countryCode;

    private String countryName;

    private AreaDto area;
}