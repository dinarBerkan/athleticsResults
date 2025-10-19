package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.request.CreateCompetitionRequest;
import com.bogazici.athleticsresult.response.CreateCompetitionResponse;
import com.bogazici.athleticsresult.service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("competition")
@AllArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @PostMapping("/create")
    public CreateCompetitionResponse createCompetition(@RequestBody CreateCompetitionRequest request) {
        return competitionService.createCompetition(request);
    }
}
