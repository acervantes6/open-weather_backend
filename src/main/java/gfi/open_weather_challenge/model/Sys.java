package gfi.open_weather_challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sys {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}
