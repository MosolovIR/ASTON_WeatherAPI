package presenter;

import model.Service;
import model.WeatherService;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new WeatherService();
    }

    public void getInfo(String city) {
        String answer = service.get(city);
        view.printAnswer(answer);
    }
}
