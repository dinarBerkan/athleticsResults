package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.entity.Competition;
import com.bogazici.athleticsresult.entity.Country;
import com.bogazici.athleticsresult.mapper.CompetitionMapper;
import com.bogazici.athleticsresult.repository.CompetitionRepository;
import com.bogazici.athleticsresult.request.CreateCompetitionRequest;
import com.bogazici.athleticsresult.request.DeleteCompetitionRequest;
import com.bogazici.athleticsresult.response.CreateCompetitionResponse;
import com.bogazici.athleticsresult.response.DeleteCompetitionResponse;
import com.bogazici.athleticsresult.response.GetCompetitionInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    private final CompetitionMapper competitionMapper;

    private final CountryService countryService;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public CreateCompetitionResponse createCompetition(CreateCompetitionRequest request) {
        Competition competition = Competition.builder()
                                    //.competitionId(UUID.randomUUID())
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

    public DeleteCompetitionResponse deleteCompetition(DeleteCompetitionRequest request) {
        Optional<Competition> competition = competitionRepository.findById(request.getCompetitionId());
        DeleteCompetitionResponse response;
        if (competition.isPresent()) {
            competitionRepository.delete(competition.get());
            response = DeleteCompetitionResponse.builder().result(Boolean.TRUE).message("Competition deleted successfully").build();
        } else {
            response = DeleteCompetitionResponse.builder().result(Boolean.FALSE).message("Competition not found").build();
        }
        return response;
    }

    public GetCompetitionInformationResponse getCompetitionInformation(String competitionId) {
        Optional<Competition> competition = competitionRepository.findById(UUID.fromString(competitionId));
        GetCompetitionInformationResponse response = new GetCompetitionInformationResponse();
        if (competition.isPresent()) {
            response.setCompetition(competitionMapper.mapToDto(competition.get()));
        } else {
            throw new RuntimeException("Competition not found");
        }
        return response;
    }

    public Competition getCompetitionForResult(String competitionId) {
        Optional<Competition> competition = competitionRepository.findById(UUID.fromString(competitionId));
        if (competition.isPresent()) {
            return competition.get();
        }
        throw new RuntimeException("Competition not found");
    }
}