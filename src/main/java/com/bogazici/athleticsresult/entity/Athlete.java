package com.bogazici.athleticsresult.entity;

import com.bogazici.athleticsresult.enumeration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "ATHRESULT", name = "ATHLETE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Athlete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "athlete")
    private List<Result> resultList;
}
