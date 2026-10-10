package com.taller.practico;

public class Refactorizacionternario {
    public static void main(String[] args) {
    boolean cookieSesionActiva = true;

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
