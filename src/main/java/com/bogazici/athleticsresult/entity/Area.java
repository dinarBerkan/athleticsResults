package com.bogazici.athleticsresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Entity
@Table(schema = "ATHRESULT", name = "AREA")
@Data
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;

    @Column(nullable = false, length = 3, unique = true)
    private String areaCode;

    @NotNull
    private String areaName;

    @OneToMany(mappedBy = "area")
    private Set<Country> countries;
}