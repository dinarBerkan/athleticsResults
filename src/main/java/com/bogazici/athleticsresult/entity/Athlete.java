package com.bogazici.athleticsresult.entity;

import com.bogazici.athleticsresult.enumeration.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "ATHRESULT", name = "ATHLETE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Athlete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(length = 50)
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private AthleteCountry athleteCountry;

    @OneToMany(mappedBy = "athlete", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Result> resultList;
}
