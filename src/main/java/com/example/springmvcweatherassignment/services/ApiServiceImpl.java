package com.example.springmvcweatherassignment.services;

import com.example.api.v1.domain.WeatherData;
import com.example.api.v1.domain.WeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;
    private WeatherData weatherData;
    private WeatherForecast weatherForecast;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherForecast getWeatherForecast(String cityName, String countryCode) {

        weatherData = restTemplate.getForObject("https://samples.openweathermap.org/data/2.5/forecast?q="
                + cityName + "," + countryCode + "&appid=b6907d289e10d714a6e88b30761fae22", WeatherData.class);

        weatherForecast = new WeatherForecast();

        weatherForecast.setCityName(cityName);
        weatherForecast.setCountryCode(countryCode);

        extractCalculateAndRetainAverageTemperature();

        extractCalculateAndRetainAverageHumidity();

        extractCalculateAndRetainAveragePressure();

        return weatherForecast;
    }

    private void extractCalculateAndRetainAverageTemperature() {
    }

    private void extractCalculateAndRetainAverageHumidity() {
    }

    private void extractCalculateAndRetainAveragePressure() {
    }
}
