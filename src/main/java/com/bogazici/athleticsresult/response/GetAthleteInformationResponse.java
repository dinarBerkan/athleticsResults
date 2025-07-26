package com.bogazici.athleticsresult.response;

import com.bogazici.athleticsresult.dto.AthleteDto;
import lombok.Data;

@Data
public class GetAthleteInformationResponse {
    private AthleteDto athlete;
}
