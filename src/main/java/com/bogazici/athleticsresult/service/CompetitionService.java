package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.entity.Competition;
import com.bogazici.athleticsresult.entity.Country;
import com.bogazici.athleticsresult.mapper.CompetitionMapper;
import com.bogazici.athleticsresult.repository.CompetitionRepository;
import com.bogazici.athleticsresult.request.CreateCompetitionRequest;
import com.bogazici.athleticsresult.response.CreateCompetitionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    private final CompetitionMapper competitionMapper;

    private final CountryService countryService;

    public CreateCompetitionResponse createCompetition(CreateCompetitionRequest request) {
        Competition competition = Competition.builder()
                                    .competitionName(request.getCompetitionName())
                                    .startDate(request.getStartDate())
                                    .endDate(request.getEndDate()).build();
        Country country = countryService.getCountryByCountryCode(request.getCountryCode());
        competition.setCountry(country);
        competitionRepository.save(competition);
        return CreateCompetitionResponse.builder()
                                                .competition(competitionMapper.mapToDto(competition))
                                                .message("Competition created successfully")
                                                .success(Boolean.TRUE).build();
    }
}