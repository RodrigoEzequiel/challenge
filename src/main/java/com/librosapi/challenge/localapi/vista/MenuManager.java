package com.librosapi.challenge.localapi.vista;

import com.librosapi.challenge.apiexterna.model.ApiResponseDTO;
import com.librosapi.challenge.apiexterna.service.ApiClient;
import com.librosapi.challenge.localapi.model.Author;
import com.librosapi.challenge.localapi.model.Book;
import com.librosapi.challenge.localapi.service.ApiResponseManager;
import com.librosapi.challenge.localapi.service.AuthorsService;
import com.librosapi.challenge.localapi.service.BookService;
import com.librosapi.challenge.localapi.utils.ConsoleUtils;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;

@Component
public class MenuManager {
    private ApiClient apiClient = new ApiClient();
    private ApiResponseManager arm = new ApiResponseManager();
    private final BookService bs;
    private final AuthorsService as;

    public MenuManager(BookService bs, AuthorsService as) {
        this.bs = bs;
        this.as = as;
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

    public void mostrarTop5() {
        System.err.println("ESTOS SON LOS LIBROS REGISTRADOS MAS DESCARGADOS");
        List<Book> top5 = bs.top5();
        top5.forEach(System.err::println);
    }

    public void mostrarAutoresVivos() {
        System.err.println("ESTOS SON LOS AUTORES REGISTRADOS VIVOS");
        List<Author> autoresVivos = as.autoresVivos();
        autoresVivos.forEach(System.err::println);
    }

    public void mostrarLibrosRegistrados() {
        System.err.println("LIBROS REGISTRADOS");
        List<Book> librosRegistrados = bs.listarLibrosRegistrados();
        librosRegistrados.forEach(System.err::println);
    }

    public void buscarAutorPorApellido() {
        String buscado = ConsoleUtils.leerString("Ingrese el apellido del autor a buscar:");
        List<Author> autoresPorApellido = as.autoresPorApellido(buscado);
        System.err.println("BUSCANDO AUTORES POR APELLIDO");
        autoresPorApellido.forEach(System.err::println);
    }
}
