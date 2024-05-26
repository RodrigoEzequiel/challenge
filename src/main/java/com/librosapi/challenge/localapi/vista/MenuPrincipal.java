package com.librosapi.challenge.localapi.vista;

import com.librosapi.challenge.localapi.utils.ConsoleUtils;
import org.springframework.stereotype.Component;

@Component
public class MenuPrincipal {
    private MenuManager mm;

    public MenuPrincipal(MenuManager mm) {
        this.mm = mm;
    }

    public void imprimirMenuPrincipal(){
        int opcion = -1;
        while (opcion < 0 || opcion > 5) {
            ConsoleUtils.imprimir("Elija la opcion deseada:");
            ConsoleUtils.imprimir("Opcion 1: buscar libro por titulo y/o autor:");
            ConsoleUtils.imprimir("opcion 2: listar autores por apellido");
            ConsoleUtils.imprimir("opcion 3: listar libros registrados:");
            ConsoleUtils.imprimir("opcion 4: listar autores vivos: ");
            ConsoleUtils.imprimir("opcion 5: listar los 5 libros mas descargados");
            ConsoleUtils.imprimir("opcion 0: salir");
            opcion = ConsoleUtils.leerEntero("Ingrese una opcion");
            proccessOption(opcion);
            if(opcion != 0)
            opcion = -1;
        }
    }
    private void proccessOption( int opcion){
        switch (opcion){
            case 1:
                mm.buscarYGuardar();
                break;
            case 2:
                mm.buscarAutorPorApellido();
                break;
            case 3:
                mm.mostrarLibrosRegistrados();
                break;
            case 4:
                mm.mostrarAutoresVivos();
                break;
            case 5:
                mm.mostrarTop5();
                break;
            case 0:
                ConsoleUtils.imprimir("gracias por usar nuestro programa.");
                break;
            default:
                ConsoleUtils.imprimir("opcion incorrecta");
        }

    }
}
