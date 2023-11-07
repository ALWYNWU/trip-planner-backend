package com.trip_planner.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GeoHelper {

    @Data
    public static class GeoResponse {
        private String name;
        private String latitude;
        private String longitude;
        private String country;
        private String state;
    }

    /**
     * This method will parse city's latitude and longitude by city name and country name
     *
     * @param city city name
     * @param country country name
     * @return return a String array, array[0] is latitude, array[1] is longitude
     */
    public static String[] getGeoInfoByCityAndCountryName(String city, String country) {
        try {
            // Encoding parameters to ensure they are URL safe
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String encodedCountry = URLEncoder.encode(country, StandardCharsets.UTF_8);

            // Construct http connection
            URL url = UriComponentsBuilder
                    .fromHttpUrl(Constant.GEO_API_URL)
                    .queryParam(Constant.GEO_API_PARAM_CITY, encodedCity)
                    .queryParam(Constant.GEO_API_PARAM_COUNTRY, encodedCountry)
                    .build().toUri().toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Constant.HTTP_REQUEST.GET.toString());
            connection.setRequestProperty(Constant.GEO_API_HEADER, Constant.GEO_API_KEY);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                String response = HttpHelper.getURLResponse(connection);

                JSONArray jsonArray = JSON.parseArray(response);
                if (!jsonArray.isEmpty()) {
                    // Get the first object from JSON array
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    // Convert JSON object to GeoResponse class instance
                    GeoResponse geoResponse = JSON.toJavaObject(jsonObject, GeoResponse.class);
                    return new String[]{geoResponse.getLatitude(), geoResponse.getLongitude(), geoResponse.getName()};
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
