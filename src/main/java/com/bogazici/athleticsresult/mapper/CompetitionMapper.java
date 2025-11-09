package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.CompetitionDto;
import com.bogazici.athleticsresult.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CompetitionMapper {
    @Mappings(
            @Mapping(target = "countryCode", source = "country.countryCode")
    )
    CompetitionDto mapToDto(Competition competition);
}
