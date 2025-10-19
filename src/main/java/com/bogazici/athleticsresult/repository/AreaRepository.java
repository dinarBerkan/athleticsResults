package com.bogazici.athleticsresult.repository;

import com.bogazici.athleticsresult.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByAreaCode(String areaCode);
}
