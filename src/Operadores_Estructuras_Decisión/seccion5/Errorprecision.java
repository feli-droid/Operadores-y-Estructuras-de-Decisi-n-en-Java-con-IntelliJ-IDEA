package Operadores_Estructuras_Decisión.seccion5;

public class Errorprecision {
    public static void main(String[] args) {
        int tareasCompletadas = 3;
        int tareasTotales = 4;

        double porcentajeAvance = ((double) tareasCompletadas / tareasTotales) * 100;

        System.out.println("El porcentaje de avance es: " + porcentajeAvance + "%");
    }
}

