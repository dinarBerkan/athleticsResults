package com.bogazici.athleticsresult.dto;

import com.bogazici.athleticsresult.enumeration.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class EventDto{
    private Long id;

    private String eventName;

    private EventType eventType;
}
