package com.bogazici.athleticsresult.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateAthleteResponse {
    private Boolean success;

    private String message;

    private UUID athleteId;
}