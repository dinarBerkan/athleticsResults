package com.bogazici.athleticsresult.repository;

import com.bogazici.athleticsresult.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}