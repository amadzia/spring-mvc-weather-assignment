package com.example.springmvcweatherassignment.services;

import com.example.api.v1.domain.WeatherForecast;
import org.junit.Before;
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

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getWeatherForecast() {

        WeatherForecast weatherForecast = apiService.getWeatherForecast("London", "UK");

        assertEquals(new WeatherForecast("London", "UK", null, null, null), weatherForecast);
    }
}