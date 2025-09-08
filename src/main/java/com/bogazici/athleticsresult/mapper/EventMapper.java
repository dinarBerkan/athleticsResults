package com.bogazici.athleticsresult.mapper;

import com.bogazici.athleticsresult.dto.EventDto;
import com.bogazici.athleticsresult.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto eventToEventDto(Event event);
}