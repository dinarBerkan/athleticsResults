package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.request.CreateCompetitionRequest;
import com.bogazici.athleticsresult.request.DeleteCompetitionRequest;
import com.bogazici.athleticsresult.response.CreateCompetitionResponse;
import com.bogazici.athleticsresult.response.DeleteCompetitionResponse;
import com.bogazici.athleticsresult.service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("competition")
@AllArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @PostMapping("/create")
    public CreateCompetitionResponse createCompetition(@RequestBody CreateCompetitionRequest request) {
        return competitionService.createCompetition(request);
    }

    @DeleteMapping("/delete")
    public DeleteCompetitionResponse deleteCompetition(@RequestBody DeleteCompetitionRequest request) {
        return competitionService.deleteCompetition(request);
    }
}
