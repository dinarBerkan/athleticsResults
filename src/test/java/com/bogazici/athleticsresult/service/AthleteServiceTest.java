package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.entity.Athlete;
import com.bogazici.athleticsresult.entity.Result;
import com.bogazici.athleticsresult.enumeration.Gender;
import com.bogazici.athleticsresult.mapper.AthleteMapper;
import com.bogazici.athleticsresult.mapper.AthleteMapperImpl;
import com.bogazici.athleticsresult.mapper.ResultMapper;
import com.bogazici.athleticsresult.mapper.ResultMapperImpl;
import com.bogazici.athleticsresult.repository.AthleteRepository;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Will be fixed in future")
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ResultMapperImpl.class, AthleteMapperImpl.class})
class AthleteServiceTest {
    private static final Long ATHLETE_ID = 1L;

    private static final String ATHLETE_NAME = "Athlete";

    private static final Gender ATHLETE_GENDER = Gender.MEN;

    private static final Date ATHLETE_BIRTH_DATE = Date.valueOf("2000-01-01");

    @Mock
    private static AthleteRepository athleteRepository;

    @InjectMocks
    private static AthleteService athleteService;

    @BeforeAll
    static void setUp() {
        athleteRepository = Mockito.mock(AthleteRepository.class);
        athleteService = new AthleteService(athleteRepository, Mappers.getMapper(AthleteMapper.class), Mappers.getMapper(ResultMapper.class));
    }

    @Test
    public void test_getAthleteInformation_withoutResult_success() {
        //given
        Athlete testAthlete = Athlete.builder().id(ATHLETE_ID).name(ATHLETE_NAME).gender(ATHLETE_GENDER).birthDate(ATHLETE_BIRTH_DATE).build();
        Mockito.when(athleteRepository.findById(ATHLETE_ID)).thenReturn(Optional.of(testAthlete));

        //when
        GetAthleteInformationResponse response = athleteService.getAthleteInformation(ATHLETE_ID);

        //then
        assertNotNull(response);
        assertEquals(ATHLETE_ID, response.getAthlete().getId());
        assertEquals(ATHLETE_NAME, response.getAthlete().getName());
        assertEquals(ATHLETE_GENDER, response.getAthlete().getGender());
        assertEquals(ATHLETE_BIRTH_DATE.toString(), response.getAthlete().getBirthDate());
    }

    @Test
    public void test_getAthleteInformation_withResult_success() {
        //given
        Athlete testAthlete = Athlete.builder().id(ATHLETE_ID).name(ATHLETE_NAME).gender(ATHLETE_GENDER).birthDate(ATHLETE_BIRTH_DATE).build();
        Result result1 = Result.builder().id(1L).athlete(testAthlete).build();
        Result result2 = Result.builder().id(2L).athlete(testAthlete).build();
        testAthlete.setResultList(List.of(result1, result2));
        Mockito.when(athleteRepository.findById(ATHLETE_ID)).thenReturn(Optional.of(testAthlete));

        //when
        GetAthleteInformationResponse response = athleteService.getAthleteInformation(ATHLETE_ID); // mocking mappers problem

        //then
        assertNotNull(response);
        assertEquals(ATHLETE_ID, response.getAthlete().getId());
        assertEquals(ATHLETE_NAME, response.getAthlete().getName());
        assertEquals(ATHLETE_GENDER, response.getAthlete().getGender());
        assertEquals(ATHLETE_BIRTH_DATE.toString(), response.getAthlete().getBirthDate());
    }

    @Test
    public void createAthlete() {
    }

    @Test
    void getAthleteForResult() {
    }
}