package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.entity.Athlete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AthleteMapper {
    AthleteMapper INSTANCE = Mappers.getMapper(AthleteMapper.class);

    @Mappings({
            @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
    })
    AthleteDto athleteToAthleteDto(Athlete athlete);
}
