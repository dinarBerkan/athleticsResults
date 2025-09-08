package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.enumeration.Gender;
import com.bogazici.athleticsresult.request.CreateAthleteRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import com.bogazici.athleticsresult.service.AthleteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AthleteControllerTest {

    private static final String ATHLETE_NAME = "TestAthlete";

    private static final Long ATHLETE_ID = 1L;

    @Mock
    AthleteService athleteService;

    @InjectMocks
    AthleteController athleteController;

    @Test
    void test_getAthleteInformation_success() {
        //given
        AthleteDto athleteDto = AthleteDto.builder().id(ATHLETE_ID).name(ATHLETE_NAME).build();
        GetAthleteInformationResponse response = new GetAthleteInformationResponse();
        response.setAthlete(athleteDto);
        Mockito.when(athleteService.getAthleteInformation(ATHLETE_ID)).thenReturn(response);

        //when
        GetAthleteInformationResponse resultingResponse = athleteController.getAthleteInformation(ATHLETE_ID);

        //then
        assertNotNull(resultingResponse);
        assertEquals(athleteDto, resultingResponse.getAthlete());
    }

    @Test
    void test_createAthlete_success() {
        //given
        CreateAthleteRequest request = new CreateAthleteRequest();
        request.setAthleteName(ATHLETE_NAME);
        request.setAthleteGender(Gender.MEN.name());
        request.setAthleteBirthDate(Date.valueOf("2000-01-01"));

        CreateAthleteResponse response = CreateAthleteResponse.builder().success(true).athleteId(ATHLETE_ID).build();
        Mockito.when(athleteService.createAthlete(request)).thenReturn(response);

        //when
        CreateAthleteResponse resultingResponse = athleteController.createAthlete(request);

        //then
        assertNotNull(resultingResponse);
        assertEquals(response, resultingResponse);
    }
}