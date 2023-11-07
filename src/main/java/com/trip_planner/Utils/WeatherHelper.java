package com.trip_planner.Utils;

import com.alibaba.fastjson.JSON;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class WeatherHelper {

    public static WeatherApiResponse getWeatherApiResponse(Double lat, Double lon){

        try {
            // Encoding parameters to ensure they are URL safe
            String encodedLat = URLEncoder.encode(lat.toString(), StandardCharsets.UTF_8);
            String encodedLon = URLEncoder.encode(lon.toString(), StandardCharsets.UTF_8);

            // Construct http connection
            URL url = UriComponentsBuilder
                    .fromHttpUrl(Constant.WEATHER_API_URL)
                    .queryParam(Constant.WEATHER_API_PARAM_LATITUDE, encodedLat)
                    .queryParam(Constant.WEATHER_API_PARAM_LONGITUDE, encodedLon)
                    .queryParam(Constant.WEATHER_API_PARAM_EXCLUDE, Constant.WEATHER_API_EXCLUDE)
                    .queryParam(Constant.WEATHER_API_PARAM_APIKEY, Constant.WEATHER_API_KEY)
                    .queryParam(Constant.WEATHER_API_PARAM_UNITS, Constant.WEATHER_API_UNITS)
                    .build().toUri().toURL();

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod(Constant.HTTP_REQUEST.GET.toString());

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = HttpHelper.getURLResponse(connection);
                return JSON.parseObject(response, WeatherApiResponse.class);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Extract useful information from the original response from weather api
     *
     * @param response response from the weather api
     * @return A weatherVo contains essential information
     */
    public static List<WeatherVo> extractWeatherData(WeatherApiResponse response) {
        List<WeatherVo> weatherVoList = new ArrayList<>();

        // Extract current day's weather
        WeatherApiResponse.Current current = response.current;
        WeatherVo currentWeatherVo = new WeatherVo();

        WeatherApiResponse.Weather weather = current.weather.get(0);
        currentWeatherVo.setMain(weather.main);
        currentWeatherVo.setDescription(weather.description);
        currentWeatherVo.setTemp(current.temp);
        currentWeatherVo.setFeelsLike(current.feels_like);
        currentWeatherVo.setSunrise(String.valueOf(current.sunrise));
        currentWeatherVo.setSunset(String.valueOf(current.sunset));

        weatherVoList.add(currentWeatherVo);

        // Extract next three days' weather
        List<WeatherApiResponse.Daily> dailyList = response.daily;

        for (int i = 1; i <= 3; i++) {
            WeatherApiResponse.Daily daily = dailyList.get(i);
            WeatherVo dailyWeatherVo = new WeatherVo();
            
            WeatherApiResponse.Weather weatherDaily = daily.weather.get(0);
            dailyWeatherVo.setMain(weatherDaily.main);
            dailyWeatherVo.setDescription(weatherDaily.description);
            dailyWeatherVo.setTemp(daily.temp.day);
            dailyWeatherVo.setFeelsLike(daily.feels_like.day);
            dailyWeatherVo.setSunrise(String.valueOf(daily.sunrise));
            dailyWeatherVo.setSunset(String.valueOf(daily.sunset));

            weatherVoList.add(dailyWeatherVo);
        }
        return weatherVoList;
    }


}
