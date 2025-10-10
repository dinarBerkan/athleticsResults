package com.bogazici.athleticsresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String competitionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @NotNull
    private String resultMark;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resultDate;

    @NotNull
    private String resultLocation;
}
