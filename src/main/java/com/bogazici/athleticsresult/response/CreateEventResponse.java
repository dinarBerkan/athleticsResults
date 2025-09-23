package com.bogazici.athleticsresult.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateEventResponse {
    private Boolean success;

    private String message;

    private Long eventId;
}