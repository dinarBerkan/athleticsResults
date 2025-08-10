package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.dto.ResultDto;
import com.bogazici.athleticsresult.request.CreateAthleteRequest;
import com.bogazici.athleticsresult.request.CreateResultRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.CreateResultResponse;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import com.bogazici.athleticsresult.service.AthleteService;
import com.bogazici.athleticsresult.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("result")
public class ResultController {
    private final ResultService resultService;

    @Autowired
    ResultController(ResultService resultService) {
        this.resultService = resultService;
    }


    @PostMapping("/create-result")
    public CreateResultResponse createAthlete(@RequestBody CreateResultRequest request) {
        return resultService.createResult(request);
    }
}
