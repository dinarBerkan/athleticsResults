package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.CompetitionDto;
import com.bogazici.athleticsresult.entity.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CompetitionMapper {
    CompetitionDto mapToDto(Competition competition);
}
