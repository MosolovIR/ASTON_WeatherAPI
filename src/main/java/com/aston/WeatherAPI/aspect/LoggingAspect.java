package com.aston.WeatherAPI.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.aston.WeatherAPI.service.WeatherService.getWeather(..))")
    public void getWeatherMethod() {}

    @Before("getWeatherMethod() && args(cityName,..)")
    public void logBefore(String cityName) {
        log.info("Запрос погоды в городе " + cityName + ": метод getWeather() был вызван");
    }

    @After("getWeatherMethod()")
    public void logAfter() {
        log.info("Запрос погоды завершен: работа метода getWeather() завершена");
    }

    @AfterThrowing(value = "getWeatherMethod()", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        log.error("Ошибка при запросе погоды: " + exception.getMessage());
    }
}
