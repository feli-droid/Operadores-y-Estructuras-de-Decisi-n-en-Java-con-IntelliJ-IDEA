package Estructuras_Repetitivas_Sentencias_Ramificación.seccion1;

import java.util.Scanner;

public class Ejecicio1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double LIMITE = 1_000_000;

        boolean procesando = true;
        double acumulado = 0;
        String causa = "";

        while (procesando) {
            System.out.print("Monto de la transacción: $");
            double monto = sc.nextDouble();

            if (monto < 0) {
                causa = "Monto negativo (no válido)";
                procesando = false;
            } else {
                acumulado += monto;
                if (acumulado > LIMITE) {
                    causa = "Se superó el límite máximo de $1'000.000";
                    procesando = false;
                }
            }
        }

        System.out.println("\n--- Informe de caja ---");
        System.out.printf("Saldo final acumulado: $%,.2f%n", acumulado);
        System.out.println("Causa de finalización: " + causa);
        sc.close();
    }
}
