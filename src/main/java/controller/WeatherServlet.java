package controller;

import model.WeatherService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    private WeatherService weatherService = new WeatherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getParameter("city");
        if (city == null || city.isEmpty()) {
            city = "Moscow";
        }

        try {
            String weatherInfo = weatherService.get(city);

            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("<html><body>");
            resp.getWriter().write("<h1>Погода в городе: " + city + "</h1>");
            resp.getWriter().write("<pre>" + weatherInfo + "</pre>");
            resp.getWriter().write("</body></html>");

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{Something went wrong}");
        }
    }
}
