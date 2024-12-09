package com.aston.WeatherAPI.service;

import com.aston.WeatherAPI.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weatherstack.api-key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public WeatherService (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public WeatherDTO getWeather(String city) {
        String url = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + city;
        return restTemplate.getForObject(url, WeatherDTO.class);
    }
}
