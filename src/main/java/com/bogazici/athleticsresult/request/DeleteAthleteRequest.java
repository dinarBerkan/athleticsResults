package com.bogazici.athleticsresult.request;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteAthleteRequest {
    private UUID athleteId;
}
