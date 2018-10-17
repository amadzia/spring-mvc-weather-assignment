package com.example.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    @JsonInclude
    private String cityName;
    @JsonInclude
    private String countryCode;
    @JsonInclude
    private String averageTemperature;
    @JsonInclude
    private String averagePressure;
    @JsonInclude
    private String averageHumidity;


}
