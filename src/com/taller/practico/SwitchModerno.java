package com.taller.practico;

import java.util.Scanner;

public class SwitchModerno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número del día (1=Lunes ... 7=Domingo): ");
        int dia = sc.nextInt();

        final String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Desconocido";
        };

        final String jornada = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Jornada Laboral";
            case 6 -> "Jornada Parcial";
            case 7 -> "Día de Descanso";
            default -> "Entrada inválida (use un número del 1 al 7)";
        };

        System.out.println("Día: " + nombreDia + " | Tipo de jornada: " + jornada);
        sc.close();
    }
}