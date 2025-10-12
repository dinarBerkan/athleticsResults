package com.bogazici.athleticsresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;


@Entity
@Table(schema = "ATHRESULT", name = "COUNTRY")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 3)
    private String countryCode;

    @NotNull
    @Column(length = 50)
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Athlete> athletes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "area_code", referencedColumnName = "areaCode", nullable = false)
    private Area area;
}
