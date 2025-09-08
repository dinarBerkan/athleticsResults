package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.ResultDto;
import com.bogazici.athleticsresult.entity.Result;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AthleteMapper.class, EventMapper.class})
public interface ResultMapper {
    ResultDto resultToResultDto(Result result);

    List<ResultDto> resultToResultDtoList(List<Result> resultList);
}