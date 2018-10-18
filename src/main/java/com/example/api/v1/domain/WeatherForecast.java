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
    private Double averageTemperature;
    private Double averagePressure;
    private Double averageHumidity;
}
