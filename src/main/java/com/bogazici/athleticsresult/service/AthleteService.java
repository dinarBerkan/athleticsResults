package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.dto.ResultDto;
import com.bogazici.athleticsresult.entity.Athlete;
import com.bogazici.athleticsresult.enumeration.Gender;
import com.bogazici.athleticsresult.mapper.AthleteMapper;
import com.bogazici.athleticsresult.mapper.ResultMapper;
import com.bogazici.athleticsresult.repository.AthleteRepository;
import com.bogazici.athleticsresult.request.CreateAthleteRequest;
import com.bogazici.athleticsresult.request.DeleteAthleteRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.DeleteAthleteResponse;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AthleteService {
    private final AthleteRepository athleteRepository;

    private final AthleteMapper athleteMapper;

    private final ResultMapper resultMapper;

    @Autowired
    AthleteService(AthleteRepository athleteRepository, AthleteMapper athleteMapper, ResultMapper resultMapper) {
        this.athleteRepository = athleteRepository;
        this.athleteMapper = athleteMapper;
        this.resultMapper = resultMapper;
    }

    public GetAthleteInformationResponse getAthleteInformation(UUID athleteId) {
        GetAthleteInformationResponse response = new GetAthleteInformationResponse();
        Optional<Athlete> athleteOptional = athleteRepository.findById(athleteId);
        if (athleteOptional.isPresent()) {
            Athlete athlete = athleteOptional.get();
            AthleteDto athleteDto = athleteMapper.athleteToAthleteDto(athlete);
            if(!CollectionUtils.isEmpty(athlete.getResultList())) {
                List<ResultDto> resultDtoList = resultMapper.resultToResultDtoList(athlete.getResultList());
                athleteDto.setResultList(resultDtoList);
            }
            response.setAthlete(athleteDto);
        }
        return response;
    }

    public CreateAthleteResponse createAthlete(CreateAthleteRequest request) {
        Athlete athlete = Athlete.builder().name(request.getAthleteName()).birthDate(request.getAthleteBirthDate()).gender(Gender.valueOf(request.getAthleteGender())).build();
        Athlete savedAthlete = athleteRepository.save(athlete);
        return CreateAthleteResponse.builder().success(Boolean.TRUE).message("Athlete created successfully.").athleteId(savedAthlete.getId()).build();
    }

    public Athlete getAthleteForResult(UUID athleteId) {
        Optional<Athlete> athleteOptional = athleteRepository.findById(athleteId);
        if (athleteOptional.isPresent()) {
            return athleteOptional.get();

        } else {
            throw new RuntimeException("Athlete with id " + athleteId + " not found");
        }
    }

    public DeleteAthleteResponse deleteAthlete(DeleteAthleteRequest request) {
        Athlete athleteToDelete = athleteRepository.findById(request.getAthleteId()).orElse(null);
        DeleteAthleteResponse response = DeleteAthleteResponse.builder().build();
        if (athleteToDelete != null) {
            athleteRepository.delete(athleteToDelete);
            response.setResult(Boolean.TRUE);
            response.setMessage("Athlete deleted successfully.");
        } else {
            response.setResult(Boolean.FALSE);
            response.setMessage("Athlete with id " + request.getAthleteId() + " not found.");
        }
        return response;
    }
}