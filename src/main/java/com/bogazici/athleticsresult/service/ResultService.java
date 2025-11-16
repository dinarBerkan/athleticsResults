package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.entity.Athlete;
import com.bogazici.athleticsresult.entity.Competition;
import com.bogazici.athleticsresult.entity.Event;
import com.bogazici.athleticsresult.entity.Result;
import com.bogazici.athleticsresult.repository.ResultRepository;
import com.bogazici.athleticsresult.request.CreateResultRequest;
import com.bogazici.athleticsresult.response.CreateResultResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ResultService {
    private final AthleteService athleteService;

    private final EventService eventService;

    private final CompetitionService competitionService;

    private final ResultRepository resultRepository;


    public CreateResultResponse createResult(CreateResultRequest request) {
        Athlete resultAthlete = athleteService.getAthleteForResult(UUID.fromString(request.getAthleteId()));
        Event event = eventService.getEventForResult(request.getEventId());
        Competition competition = competitionService.getCompetitionForResult(request.getCompetitionId());
        Result result = Result.builder().athlete(resultAthlete).event(event).competition(competition)
                .resultMark(request.getResultMark())
                .resultDate(request.getResultDate())
                .build();
        resultRepository.save(result);
        return CreateResultResponse.builder().success(true).resultId(result.getId()).build();
    }
}