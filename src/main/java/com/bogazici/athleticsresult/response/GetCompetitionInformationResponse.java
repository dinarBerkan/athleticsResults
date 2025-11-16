package com.bogazici.athleticsresult.response;

import com.bogazici.athleticsresult.dto.CompetitionDto;
import lombok.Data;

@Data
public class GetCompetitionInformationResponse {
    private CompetitionDto competition;
}