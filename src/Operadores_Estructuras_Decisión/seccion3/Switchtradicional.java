package Operadores_Estructuras_Decisión.seccion3;

import java.util.Scanner;


public class Switchtradicional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número del día (1=Lunes ... 7=Domingo): ");
        int dia = sc.nextInt();

        String nombreDia;
        String jornada;

        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                jornada = "Jornada Laboral";
                break;
            case 2:
                nombreDia = "Martes";
                jornada = "Jornada Laboral";
                break;
            case 3:
                nombreDia = "Miércoles";
                jornada = "Jornada Laboral";
                break;
            case 4:
                nombreDia = "Jueves";
                jornada = "Jornada Laboral";
                break;
            case 5:
                nombreDia = "Viernes";
                jornada = "Jornada Laboral";
                break;
            case 6:
                nombreDia = "Sábado";
                jornada = "Jornada Parcial";
                break;
            case 7:
                nombreDia = "Domingo";
                jornada = "Día de Descanso";
                break;
            default:
                nombreDia = "Desconocido";
                jornada = "Entrada inválida (use un número del 1 al 7)";
                break;
        }

        System.out.println("Día: " + nombreDia + " | Tipo de jornada: " + jornada);
        sc.close();
    }
}
