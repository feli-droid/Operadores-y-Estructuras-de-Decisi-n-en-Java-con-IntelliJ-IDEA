package Operadores_Estructuras_Decisión.seccion2;

public class Refactorizacionternario {
    public static void main(String[] args) {
        boolean cookieSesionActiva = true;

        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";

        System.out.println("Estado de conexión: " + estadoConexion);
    }
}
