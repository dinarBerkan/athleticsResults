package com.bogazici.athleticsresult.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class CreateAthleteRequest {
    private String athleteName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date athleteBirthDate;

    private String athleteGender;
}
