package com.bogazici.athleticsresult.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteAthleteResponse {
    private Boolean result;

    private String message;
}
