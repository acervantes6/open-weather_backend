package gfi.open_weather_challenge.service;

import gfi.open_weather_challenge.model.Weather;
import gfi.open_weather_challenge.model.WeatherResponse;
import gfi.open_weather_challenge.repository.weatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherService implements IWeatherService{

    @Autowired
    private weatherRepository weatherRepository;

    private final String API_KEY = "6a90d97228828e79eea854accfeb9521";
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid=" + API_KEY;

    @Override
    public Weather getWeatherByCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(BASE_URL, WeatherResponse.class, city);

        if (weatherResponse != null) {
            Weather weather = new Weather();
            weather.setCity(city);
            weather.setDescription(weatherResponse.getWeather().get(0).getDescription());
            weather.setTemperature(weatherResponse.getMain().getTemp());
            weather.setHumidity(weatherResponse.getMain().getHumidity());
            weather.setTimestamp(LocalDateTime.now());
            return weatherRepository.save(weather);
        }
        return null;
    }


    @Override
    public List<Weather> getWeatherHistory() {
        return weatherRepository.findAll();
    }
}
