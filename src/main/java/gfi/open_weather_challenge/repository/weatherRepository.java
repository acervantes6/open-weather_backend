package gfi.open_weather_challenge.repository;

import gfi.open_weather_challenge.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface weatherRepository extends JpaRepository<Weather, Long> {
}
