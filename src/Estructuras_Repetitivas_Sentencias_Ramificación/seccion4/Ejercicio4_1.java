package Estructuras_Repetitivas_Sentencias_Ramificación.seccion4;

public class Ejercicio4_1 {
    public static void main(String[] args) {
        boolean encontrado = false;

        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 && i % 11 == 0) {
                System.out.println("Primer número divisible entre 7 y 11: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún número.");
        }
    }
}
