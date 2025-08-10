package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.dto.EventDto;
import com.bogazici.athleticsresult.dto.ResultDto;
import com.bogazici.athleticsresult.entity.Athlete;
import com.bogazici.athleticsresult.entity.Event;
import com.bogazici.athleticsresult.entity.Result;
import com.bogazici.athleticsresult.enumeration.EventType;
import com.bogazici.athleticsresult.repository.EventRepository;
import com.bogazici.athleticsresult.repository.ResultRepository;
import com.bogazici.athleticsresult.request.CreateResultRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.CreateResultResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultService {
    private final AthleteService athleteService;

    private final EventService eventService;

    private final ResultRepository resultRepository;


    public CreateResultResponse createResult(CreateResultRequest request) {
        Athlete resultAthlete = athleteService.getAthleteForResult(request.getAthleteId());
        Event event = eventService.getEventForResult(request.getEventId());
        Result result = Result.builder().athlete(resultAthlete).event(event)
                .competitionName(request.getCompetitionName())
                .resultMark(request.getResultMark())
                .resultDate(request.getResultDate())
                .resultLocation(request.getResultLocation())
                .build();
        resultRepository.save(result);
        return CreateResultResponse.builder().success(true).resultId(result.getId()).build();
    }
}