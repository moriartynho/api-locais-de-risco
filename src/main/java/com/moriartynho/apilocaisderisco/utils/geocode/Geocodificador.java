package com.moriartynho.apilocaisderisco.utils.geocode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class Geocodificador {

	public String[] decodificador(String endereco) throws IOException {
		endereco = URLEncoder.encode(endereco, "UTF-8");
		String apiKey = "AIzaSyA7Xl0MLSgwlXj5R5yjx3MJmXTsWewPZi8";
		String stringUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + endereco + "&key=" + apiKey;
		
		URL url = new URL(stringUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        
        StringBuilder responseJson = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                responseJson.append(line);
            }
        }
        connection.disconnect();
        
        Gson gson = new Gson();
        GeocodeResponse geocodeResponse = gson.fromJson(responseJson.toString(), GeocodeResponse.class);

        
        if ("OK".equals(geocodeResponse.getStatus())) {
            if (!geocodeResponse.getResults().isEmpty()) {
                Location location = geocodeResponse.getResults().get(0).getGeometry().getLocation();
                Double latitude = location.getLat();
                Double longitude = location.getLng();
                String[] latiudeELongitude = {latitude.toString(), longitude.toString()};
                return latiudeELongitude;
            } else {
                throw new RuntimeException("Nenhum resultado encontrado.");
            }
        } else {
        	throw new RuntimeException("Erro na resposta da API: " + geocodeResponse.getStatus());
        }

	}

}
