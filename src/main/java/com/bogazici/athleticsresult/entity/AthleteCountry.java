package com.bogazici.athleticsresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;


@Entity
@Table(schema = "ATHRESULT", name = "ATH_COUNTRY")
@Data
public class AthleteCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 3)
    private String countryCode;

    @NotNull
    @Column(length = 50)
    private String countryName;

    @OneToMany(mappedBy = "athleteCountry", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Athlete> athletes;
}
