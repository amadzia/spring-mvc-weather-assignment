package com.example.springmvcweatherassignment.services;

import com.example.api.v1.domain.WeatherData;
import com.example.api.v1.domain.WeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;
    private WeatherData weatherData;
    private WeatherForecast weatherForecast;
    private final String api_url;
    private final String api_key;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url, @Value("${api.key}") String api_key) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        this.api_key = api_key;
    }

    @Override
    public WeatherForecast getWeatherForecast(String cityName, String countryCode) {

        UriComponents uriComponent = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("q", "{value}")
                .queryParam("appid", "{value}").build()
                .expand(cityName + "," + countryCode, api_key).encode();

        weatherData = restTemplate.getForObject(uriComponent.toString(), WeatherData.class);

        weatherForecast = new WeatherForecast();

        weatherForecast.setCityName(cityName);
        weatherForecast.setCountryCode(countryCode);

        extractCalculateAndRetainAverageTemperature();

        extractCalculateAndRetainAverageHumidity();

        extractCalculateAndRetainAveragePressure();

        return weatherForecast;
    }

    private void extractCalculateAndRetainAverageTemperature() {
        List<Double> temperatures = new ArrayList<>();

        for (int i = 0; i < weatherData.getList().size(); i++) {
            temperatures.add(weatherData.getList().get(i).main.temp);
        }

        Double temperaturesSum = temperatures.stream().mapToDouble(Double::doubleValue).sum();

        int temperaturesSize = (int) temperatures.stream().filter(Objects::nonNull).count();

        Double averageTemperature = (double) Math.round(temperaturesSum / temperaturesSize * 100) / 100;

        weatherForecast.setAverageTemperature(averageTemperature);

    }

    private void extractCalculateAndRetainAverageHumidity() {

        List<Integer> humidities = new ArrayList<>();

        for (int i = 0; i < weatherData.getList().size(); i++) {
            humidities.add(weatherData.getList().get(i).main.humidity);
        }

        Integer humiditySum = humidities.stream().mapToInt(Integer::intValue).sum();

        int humiditiesSize = (int) humidities.stream().filter(Objects::nonNull).count();

        double averageHumidity = (double) Math.round((double) humiditySum / humiditiesSize * 100) / 100;

        weatherForecast.setAverageHumidity(averageHumidity);

    }

    private void extractCalculateAndRetainAveragePressure() {

        List<Double> pressures = new ArrayList<>();

        for (int i = 0; i < weatherData.getList().size(); i++) {
            pressures.add(weatherData.getList().get(i).main.pressure);
        }

        Double pressureSum = pressures.stream().mapToDouble(Double::doubleValue).sum();

        int pressuresSize = (int) pressures.stream().filter(Objects::nonNull).count();

        Double averagePressure = (double) Math.round(pressureSum / pressuresSize * 100) / 100;

        weatherForecast.setAveragePressure(averagePressure);
    }
}
