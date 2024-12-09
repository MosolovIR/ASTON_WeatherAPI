package com.aston.WeatherAPI.repository;

import com.aston.WeatherAPI.model.City;
import com.aston.WeatherAPI.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    List<WeatherData> findByCity(City city);
}
