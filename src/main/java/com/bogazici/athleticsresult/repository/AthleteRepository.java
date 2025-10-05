package com.bogazici.athleticsresult.repository;

import com.bogazici.athleticsresult.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AthleteRepository extends JpaRepository<Athlete, UUID> {
}