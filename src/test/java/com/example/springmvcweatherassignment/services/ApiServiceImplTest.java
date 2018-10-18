package com.example.springmvcweatherassignment.services;

import com.example.api.v1.domain.WeatherForecast;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Test
    public void getWeatherForecast() {

        WeatherForecast weatherForecast = apiService.getWeatherForecast("London", "UK");

        assertEquals(new WeatherForecast("London", "UK", 274.74, 966.21, 88.78), weatherForecast);
    }
}