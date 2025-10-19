package com.bogazici.athleticsresult.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaDto {
    private Long areaId;

    private String areaCode;

    private String areaName;
}