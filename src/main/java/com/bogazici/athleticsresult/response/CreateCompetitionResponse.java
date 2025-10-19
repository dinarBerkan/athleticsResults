package com.bogazici.athleticsresult.response;

import com.bogazici.athleticsresult.dto.CompetitionDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCompetitionResponse {
    private final CompetitionDto competition;

    private Boolean success;

    private String message;
}