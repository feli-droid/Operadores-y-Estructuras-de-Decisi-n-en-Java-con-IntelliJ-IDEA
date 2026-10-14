package Estructuras_Repetitivas_Sentencias_Ramificación.seccion3;

import java.util.Scanner;

public class Ejecicio3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero N: ");
        int n = sc.nextInt();

        System.out.println("\n--- Tabla de multiplicar del " + n + " ---");
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%4d x %2d = %6d%n", n, i, n * i);
        }

        System.out.println("\n--- Conteo regresivo desde " + n + " hasta 0 ---");

        int paso = (n >= 0) ? -1 : 1;
        for (int i = n; i != n + (Math.abs(n) + 1) * paso; i += paso) {
            System.out.print(i + " ");
        }
        System.out.println();
        sc.close();
    }
}

