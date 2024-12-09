package com.aston.WeatherAPI.controller;

import com.aston.WeatherAPI.dto.WeatherDTO;
import com.aston.WeatherAPI.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherDTO> getWeather(@PathVariable String city) {
        WeatherDTO weather = weatherService.getWeather(city);
        return ResponseEntity.ok(weather);
    }
}
