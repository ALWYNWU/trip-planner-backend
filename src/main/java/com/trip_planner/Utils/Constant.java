package com.trip_planner.Utils;

public class Constant {
    public enum HTTP_REQUEST{
        GET, POST, PUT, DELETE
    }
    public static final String INVALID_CITY_NAME_MSG = "Invalid city or country name, can not parse it";
    public static final String ERROR_MSG = "Something went wrong, please try again later";
    public static final String DELETE_SUCCESS = "Delete city successful!";
    public static final String SAVE_SUCCESS = "Create city successful!";
    public static final String UPDATE_SUCCESS = "Update city successful!";
    public static final String GEO_API_KEY = "xJbuLIF8Y0+tiqr9yO1u1Q==gVqCT5e5A8ApAc0j";
    public static final String GEO_API_URL = "https://api.api-ninjas.com/v1/geocoding";
    public static final String GEO_API_HEADER = "X-Api-Key";
    public static final String GEO_API_PARAM_CITY = "city";
    public static final String GEO_API_PARAM_COUNTRY = "country";
    public static final String WEATHER_API_KEY = "a08ca67eb71fc7cf6edb10c34560feee";
    public static final String WEATHER_API_URL = "https://api.openweathermap.org/data/3.0/onecall";
    public static final String WEATHER_API_EXCLUDE = "hourly,minutely";
    public static final String WEATHER_API_UNITS = "metric";
    public static final String WEATHER_API_PARAM_LATITUDE = "lat";
    public static final String WEATHER_API_PARAM_LONGITUDE = "lon";
    public static final String WEATHER_API_PARAM_EXCLUDE = "exclude";
    public static final String WEATHER_API_PARAM_APIKEY = "appid";
    public static final String WEATHER_API_PARAM_UNITS = "units";
    public static final String CODE = "code";
    public static final String MESSAGE = "msg";
    public static final String DATA = "data";

}
