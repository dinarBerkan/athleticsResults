package com.bogazici.athleticsresult.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "ATHRESULT", name = "RESULT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String competitionName;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String resultMark;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resultDate;

    private String resultLocation;
}
