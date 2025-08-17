package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.ResultDto;
import com.bogazici.athleticsresult.entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultMapper {
    ResultMapper INSTANCE = Mappers.getMapper(ResultMapper.class);

    ResultDto resultToResultDto(Result result);
}