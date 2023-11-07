package com.trip_planner.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpHelper {
    /**
     * This method reads the input stream from the provided HttpURLConnection and
     * returns the response as a String.
     *
     * @param connection The HttpURLConnection from which to read the response.
     * @return A String containing the JSON response from the server.
     * @throws IOException If an I/O error occurs while reading from the input stream.
     */
    public static String getURLResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = in.readLine();
        in.close();
        return response;
    }
}
