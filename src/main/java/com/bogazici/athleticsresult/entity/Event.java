package com.bogazici.athleticsresult.entity;

import com.bogazici.athleticsresult.enumeration.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(schema = "ATHRESULT", name = "EVENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventName;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
}
