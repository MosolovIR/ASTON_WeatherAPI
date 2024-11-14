package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;
import model.WeatherService;

import java.io.IOException;

public class WeatherServlet extends HttpServlet {
    private final String ERROR_MESSAGE = "Вы не указали город";
    private Service weatherService = new WeatherService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String city = request.getParameter("city");

        if (city == null || city.isEmpty()) {
            response.getWriter().write(ERROR_MESSAGE);
        }

        String result = weatherService.get(city);
//        response.setContentType("text/plain;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(result);
    }
}
