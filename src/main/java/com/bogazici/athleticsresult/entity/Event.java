package com.bogazici.athleticsresult.entity;

import com.bogazici.athleticsresult.enumeration.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(schema = "ATHRESULT", name = "EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String eventName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
