package com.bogazici.athleticsresult.request;

import com.bogazici.athleticsresult.enumeration.EventType;
import com.bogazici.athleticsresult.enumeration.Gender;
import lombok.Data;

@Data
public class CreateEventRequest {
    private String eventName;

    private EventType eventType;

    private Gender gender;
}