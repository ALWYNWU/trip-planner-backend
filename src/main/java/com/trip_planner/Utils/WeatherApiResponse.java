package com.trip_planner.Utils;
import lombok.Data;
import java.util.List;
@Data
public class WeatherApiResponse {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public Current current;
    public List<Daily> daily;
    @Data
    public static class Current {
        public long dt;
        public long sunrise;
        public long sunset;
        public double temp;
        public double feels_like;
        public int pressure;
        public int humidity;
        public double dew_point;
        public double uvi;
        public int clouds;
        public int visibility;
        public double wind_speed;
        public int wind_deg;
        public List<Weather> weather;
    }
    @Data
    public static class Daily {
        public long dt;
        public long sunrise;
        public long sunset;
        public long moonrise;
        public long moonset;
        public double moon_phase;
        public String summary;
        public Temp temp;
        public FeelsLike feels_like;
        public int pressure;
        public int humidity;
        public double dew_point;
        public double wind_speed;
        public int wind_deg;
        public double wind_gust;
        public List<Weather> weather;
        public int clouds;
        public double pop;
        public double uvi;
        public double rain;
    }
    @Data
    public static class Temp {
        public double day;
        public double min;
        public double max;
        public double night;
        public double eve;
        public double morn;
    }
    @Data
    public static class FeelsLike {
        public double day;
        public double night;
        public double eve;
        public double morn;
    }
    @Data
    public static class Weather {
        public int id;
        public String main;
        public String description;
        public String icon;
    }
}