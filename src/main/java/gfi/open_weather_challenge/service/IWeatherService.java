package gfi.open_weather_challenge.service;

import gfi.open_weather_challenge.model.Weather;

import java.util.List;

public interface IWeatherService {
    public Weather getWeatherByCity(String city);

    public List<Weather> getWeatherHistory();
}
