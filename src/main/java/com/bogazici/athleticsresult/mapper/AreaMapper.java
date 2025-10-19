package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.AreaDto;
import com.bogazici.athleticsresult.entity.Area;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {
    AreaDto mapToDto(Area area);
}
