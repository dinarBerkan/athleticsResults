package com.bogazici.athleticsresult.request;

import lombok.Data;
import java.util.Date;

@Data
public class CreateAthleteRequest {
    private String athleteName;

    private Date athleteBirthDate;

    private String athleteGender;
}
