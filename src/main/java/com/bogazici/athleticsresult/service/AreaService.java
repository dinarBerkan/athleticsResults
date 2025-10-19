package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.dto.AreaDto;
import com.bogazici.athleticsresult.entity.Area;
import com.bogazici.athleticsresult.mapper.AreaMapper;
import com.bogazici.athleticsresult.repository.AreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AreaService {
    private AreaRepository areaRepository;

    private AreaMapper areaMapper;

    public AreaDto findByAreaCode(String areaCode) {
        Optional<Area> areaOptional = areaRepository.findByAreaCode(areaCode);
        if (areaOptional.isPresent()) {
            return areaMapper.mapToDto(areaOptional.get());
        } else {
            throw new RuntimeException("No such area");
        }
    }
}
