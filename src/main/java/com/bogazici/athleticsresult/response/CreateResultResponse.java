package com.bogazici.athleticsresult.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateResultResponse {
    private Boolean success;

    private Long resultId;
}