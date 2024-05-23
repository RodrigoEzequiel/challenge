package com.librosapi.challenge.localapi.utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static int leerEntero(String mensaje){
        System.out.println(mensaje);
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (Exception e) {
            return -1;
        }

    }
    public static String leerString(String mensaje) {
        System.out.println(mensaje);
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        } catch (Exception e) {
            return "";
        }
    }
    public static void imprimir(String mensaje){
        System.out.println(mensaje);
    }
}
