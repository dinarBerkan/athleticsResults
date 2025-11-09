package com.bogazici.athleticsresult.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCompetitionResponse {
    private Boolean result;

    private String message;
}