package com.bogazici.athleticsresult.dto;

import com.bogazici.athleticsresult.enumeration.EventType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDto{
    private Long id;

    private String eventName;

    private EventType eventType;
}
