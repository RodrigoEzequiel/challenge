package com.librosapi.challenge.localapi.vista;

import com.librosapi.challenge.apiexterna.model.ApiResponseDTO;
import com.librosapi.challenge.apiexterna.service.ApiClient;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.service.ApiResponseManager;
import com.librosapi.challenge.localapi.service.BookService;
import com.librosapi.challenge.localapi.utils.ConsoleUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class MenuManager {
    private ApiClient apiClient = new ApiClient();
    private ApiResponseManager arm = new ApiResponseManager();
    private final BookService bs;

    public MenuManager(BookService bs) {
        this.bs = bs;
    }

    public void buscarYGuardar(){
        String busqueda = ConsoleUtils.leerString("ingrese el titulo o nombre de autor:");
        ApiResponseDTO respuesta = apiClient.getDatos(busqueda);
        List<Book> libros = arm.convertirDtoAEntidad(respuesta.results());
        List<Book> guardados = libros.stream().map(bs::guardar).toList();
        guardados.forEach(System.out::println);
    }
}
