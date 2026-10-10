package com.taller.practico;

public class RefactorizacionTernario {
    public static void main(String[] args) {
        boolean cookieSesionActiva = false;

        // Versión tradicional (para comparar):
        // String estadoConexion;
        // if (cookieSesionActiva == true) {
        //     estadoConexion = "ACTIVA";
        // } else {
        //     estadoConexion = "INACTIVA";
        // }

        // Versión con operador ternario (una sola línea):
        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";

        System.out.println("Estado de conexión: " + estadoConexion);
    }
}