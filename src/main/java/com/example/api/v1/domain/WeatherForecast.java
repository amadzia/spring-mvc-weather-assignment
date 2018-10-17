package com.example.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    private String cityName;
    private String countryCode;
    private String averageTemperature;
    private String averagePressure;
    private String averageHumidity;
}
