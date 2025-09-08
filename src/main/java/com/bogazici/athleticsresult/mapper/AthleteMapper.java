package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.entity.Athlete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ResultMapper.class})
public interface AthleteMapper {

    @Mappings({
            @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "resultList", ignore = true)
    })
    AthleteDto athleteToAthleteDto(Athlete athlete);
}
