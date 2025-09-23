package com.bogazici.athleticsresult.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OUTDOOR")
public class OutdoorEvent extends Event {
}