package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.CountryDto;
import com.bogazici.athleticsresult.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AreaMapper.class})
public interface CountryMapper {
    CountryDto mapToDto(Country country);
}