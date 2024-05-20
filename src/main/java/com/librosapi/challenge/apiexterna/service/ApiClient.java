package com.librosapi.challenge.apiexterna.service;

import com.librosapi.challenge.apiexterna.model.ApiResponseDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final String GUTENDEX_URL  = "https://gutendex.com/books/?search=";
    private final Conversor conversor;

    public ApiClient() {
        this.conversor = new Conversor();
    }

    public ApiResponseDTO getDatos(String param){
        String search = param.trim().replace(" ", "+");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GUTENDEX_URL + search))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return conversor.obtenerDatos(response.body(), ApiResponseDTO.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
}
