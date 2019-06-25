package com.example.malut.usersbase.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkService {

    static String jsonLine = null;

    public String getHTTPData(String urlString){

        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            if(httpURLConnection.getResponseCode() == 200){
                BufferedReader r = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null)
                    sb.append(line);
                jsonLine = sb.toString();
                httpURLConnection.disconnect();

            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonLine;
    }
}
