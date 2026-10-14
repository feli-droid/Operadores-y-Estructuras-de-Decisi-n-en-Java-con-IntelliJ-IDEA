package Estructuras_Repetitivas_Sentencias_Ramificación.seccion4;

public class Ejercicio4_2 {
    public static void main(String[] args) {
        System.out.println("Pares entre 1 y 50 que no son múltiplos de 5:");
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                continue;   // omite impares
            }
            if (i % 5 == 0) {
                continue;   // omite múltiplos de 5
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
