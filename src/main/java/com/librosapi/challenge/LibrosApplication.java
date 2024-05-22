package com.librosapi.challenge;

import com.librosapi.challenge.apiexterna.model.ApiResponseDTO;
import com.librosapi.challenge.apiexterna.service.ApiClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiClient apiclient = new ApiClient();
		ApiResponseDTO respuesta = apiclient.getDatos("Charles Dickens");
		System.out.println("Respuesta:" + respuesta);
	}
}
