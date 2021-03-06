package com.example.springmvcweatherassignment.controllers.v1;

import com.example.api.v1.domain.WeatherForecast;
import com.example.springmvcweatherassignment.services.ApiService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WeatherController.BASE_URI)
public class WeatherController {

    public static final String BASE_URI = "/api/v1";


    private ApiService apiService;

    public WeatherController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping(value = "/weatherforecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherForecast formPost(@RequestParam String city, @RequestParam String countryCode, Model model) {

        model.addAttribute("weatherforecast", apiService.getWeatherForecast(city, countryCode));

        return apiService.getWeatherForecast(city, countryCode);
    }

}
