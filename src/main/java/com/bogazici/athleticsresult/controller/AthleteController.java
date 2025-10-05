package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.request.CreateAthleteRequest;
import com.bogazici.athleticsresult.request.DeleteAthleteRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.DeleteAthleteResponse;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import com.bogazici.athleticsresult.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("athlete")
public class AthleteController {
    private final AthleteService athleteService;

    @Autowired
    AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping("/get-athlete-information")
    public GetAthleteInformationResponse getAthleteInformation(@RequestParam UUID athleteId) {
        return athleteService.getAthleteInformation(athleteId);
    }

    @PostMapping("/create-athlete")
    public CreateAthleteResponse createAthlete(@RequestBody CreateAthleteRequest request) {
        return athleteService.createAthlete(request);
    }

    @DeleteMapping("/delete-athlete")
    public DeleteAthleteResponse deleteAthlete(@RequestBody DeleteAthleteRequest request) {
        return athleteService.deleteAthlete(request);
    }
}
