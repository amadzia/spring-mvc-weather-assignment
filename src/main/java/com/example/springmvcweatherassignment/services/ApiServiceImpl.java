package com.example.springmvcweatherassignment.services;

import com.example.api.v1.domain.WeatherData;
import com.example.api.v1.domain.WeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Double> temperatures = new ArrayList<>();

        for (int i = 0; i < weatherData.getList().size(); i++) {
            temperatures.add(weatherData.getList().get(i).main.temp);
        }

        Double temperaturesSum = temperatures.stream().mapToDouble(Double::doubleValue).sum();

        int temperaturesSize = (int) temperatures.stream().filter(Objects::nonNull).count();

        Double averageTemperature = temperaturesSum / temperaturesSize;

        weatherForecast.setAverageTemperature(new DecimalFormat("0.00").format(averageTemperature));

    }

    private void extractCalculateAndRetainAverageHumidity() {

        List<Integer> humidities = new ArrayList<>();

        for (int i = 0; i < weatherData.getList().size(); i++) {
            humidities.add(weatherData.getList().get(i).main.humidity);
        }

        Integer humiditySum = humidities.stream().mapToInt(Integer::intValue).sum();

        int humiditiesSize = (int) humidities.stream().filter(Objects::nonNull).count();

        Double averageHumidity = (double) (humiditySum / humiditiesSize);

        weatherForecast.setAverageHumidity(new DecimalFormat("0.00").format(averageHumidity));

    }

    private void extractCalculateAndRetainAveragePressure() {

        List<Double> pressures = new ArrayList<>();

        for (int i = 0; i < weatherData.getList().size(); i++) {
            pressures.add(weatherData.getList().get(i).main.pressure);
        }

        Double pressureSum = pressures.stream().mapToDouble(Double::doubleValue).sum();

        int pressuresSize = (int) pressures.stream().filter(Objects::nonNull).count();

        Double averagePressure = pressureSum / pressuresSize;

        weatherForecast.setAveragePressure(new DecimalFormat("0.00").format(averagePressure));
    }
}
