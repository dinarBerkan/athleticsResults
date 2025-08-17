package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.entity.Athlete;
import com.bogazici.athleticsresult.enumeration.Gender;
import com.bogazici.athleticsresult.mapper.AthleteMapper;
import com.bogazici.athleticsresult.repository.AthleteRepository;
import com.bogazici.athleticsresult.request.CreateAthleteRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AthleteService {
    private final AthleteRepository athleteRepository;

    private final AthleteMapper athleteMapper;

    @Autowired
    AthleteService(AthleteRepository athleteRepository, AthleteMapper athleteMapper) {
        this.athleteRepository = athleteRepository;
        this.athleteMapper = athleteMapper;
    }

    public GetAthleteInformationResponse getAthleteInformation(Long athleteId) {
        GetAthleteInformationResponse response = new GetAthleteInformationResponse();
        Optional<Athlete> athleteOptional = athleteRepository.findById(athleteId);
        if (athleteOptional.isPresent()) {
            Athlete athlete = athleteOptional.get();
            AthleteDto athleteDto = athleteMapper.athleteToAthleteDto(athlete);
            response.setAthlete(athleteDto);
        }
        return response;
    }

    public CreateAthleteResponse createAthlete(CreateAthleteRequest request) {
        Athlete athlete = Athlete.builder().name(request.getAthleteName()).birthDate(request.getAthleteBirthDate()).gender(Gender.valueOf(request.getAthleteGender())).build();
        Athlete savedAthlete = athleteRepository.save(athlete);
        return CreateAthleteResponse.builder().success(Boolean.TRUE).message("Athlete created successfully.").athleteId(savedAthlete.getId()).build();
    }

    public Athlete getAthleteForResult(Long athleteId) {
        Optional<Athlete> athleteOptional = athleteRepository.findById(athleteId);
        if (athleteOptional.isPresent()) {
            return athleteOptional.get();

        } else {
            throw new RuntimeException("Athlete with id " + athleteId + " not found");
        }
    }
}