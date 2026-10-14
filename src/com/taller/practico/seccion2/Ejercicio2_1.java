package com.taller.practico.seccion2;

import java.util.Scanner;

public class Ejercicio2_1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int pin;

    do {
        System.out.print("Ingrese su PIN (4 dígitos): ");
        pin = sc.nextInt();

        if (pin < 1000 || pin > 9999) {
            System.out.println("Error: La clave debe tener exactamente 4 dígitos positivos");
        }
    } while (pin < 1000 || pin > 9999);

    System.out.println("PIN aceptado. Acceso concedido.");
    sc.close();
}
}