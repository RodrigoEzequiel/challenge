package com.librosapi.challenge;

import com.librosapi.challenge.apiexterna.model.ApiResponseDTO;
import com.librosapi.challenge.apiexterna.service.ApiClient;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.service.ApiResponseManager;
import com.librosapi.challenge.localapi.service.BookService;
import com.librosapi.challenge.localapi.vista.MenuManager;
import com.librosapi.challenge.localapi.vista.MenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LibrosApplication implements CommandLineRunner {
	@Autowired
	private MenuManager mm;

	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MenuPrincipal menuPrincipal = new MenuPrincipal(mm);
		menuPrincipal.imprimirMenuPrincipal();
	}
}
