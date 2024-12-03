package gfi.open_weather_challenge.controller;

import gfi.open_weather_challenge.model.Weather;
import gfi.open_weather_challenge.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public ResponseEntity<Weather> getCurrentWeather(@RequestParam String city) {
        Weather weather = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(weather);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Weather>> getWeatherHistory() {
        List<Weather> history = weatherService.getWeatherHistory();
        return ResponseEntity.ok(history);
    }
}
