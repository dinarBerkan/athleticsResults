package com.bogazici.athleticsresult.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(schema = "ATHRESULT", name = "COMPETITION")
@Data
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID competitionId;

    private String competitionName;

    private Date startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_code", referencedColumnName = "countryCode", nullable = false)
    private Country country;
}