package com.librosapi.challenge.localapi.vista;

import com.librosapi.challenge.apiexterna.model.ApiResponseDTO;
import com.librosapi.challenge.apiexterna.service.ApiClient;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.service.ApiResponseManager;
import com.librosapi.challenge.localapi.service.BookService;
import com.librosapi.challenge.localapi.utils.ConsoleUtils;
import org.springframework.stereotype.Component;

import java.util.List;

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
        System.err.println("AGUARDANDO RESPUESTA DE LA API...");
        ApiResponseDTO respuesta = apiClient.getDatos(busqueda);
        if(respuesta.results().isEmpty()) {
            System.err.println("NO SE HA PODIDO ESTABLECER CONEXION CON LA API");
            return;
        }
        System.err.println("LEYENDO RESPUESTA DE LA API...");
        List<Book> libros = arm.convertirDtoAEntidad(respuesta.results());
        System.err.println("GUARDADO EN BASES DE DATOS LOS RESULTADOS...");
        List<Book> guardados = libros.stream().map(bs::guardar).toList();
        System.err.println("MOSTRANDO LOS RESULTADOS...");
        System.err.println("=================================================================================================================");
        guardados.forEach(System.err::println);
        System.err.println("=================================================================================================================");
    }
}
