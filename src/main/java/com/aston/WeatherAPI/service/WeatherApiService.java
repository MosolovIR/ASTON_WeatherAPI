package com.aston.WeatherAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class WeatherApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "http://api.openweathermap.org/data/2.5/weather";
    @Value("${weatherstack.api-key}")
    private final String apiKey = System.getenv("API_KEY");

    public Map<String, Object> getWeather(String city) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("q",city)
                .queryParam("appid",apiKey)
                .build().toUriString();
        try {
            return restTemplate.getForObject(url, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при запросе данных о погоде" + e.getMessage());
        }
    }
}
