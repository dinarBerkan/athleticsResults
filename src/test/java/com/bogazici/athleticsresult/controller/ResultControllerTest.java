package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.request.CreateResultRequest;
import com.bogazici.athleticsresult.response.CreateResultResponse;
import com.bogazici.athleticsresult.service.ResultService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ResultControllerTest {
    @Mock
    private ResultService resultService;

    @InjectMocks
    private ResultController resultController;

    @Test
    void test_createAthlete_success() {
        //given
        CreateResultRequest request = CreateResultRequest.builder().build();
        CreateResultResponse response = CreateResultResponse.builder().resultId(1L).build();
        Mockito.when(resultService.createResult(request)).thenReturn(response);

        //when
        CreateResultResponse returningResponse = resultController.createResult(request);

        //then
        assertNotNull(returningResponse);
        assertEquals(response.getResultId(), returningResponse.getResultId());
    }
}