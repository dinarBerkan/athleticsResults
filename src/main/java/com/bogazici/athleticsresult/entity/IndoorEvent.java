package com.bogazici.athleticsresult.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDOOR")
public class IndoorEvent extends Event {
}