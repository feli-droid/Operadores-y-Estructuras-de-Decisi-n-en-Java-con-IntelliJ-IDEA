package com.taller.practico;

public class Reto2AprobacionNotas {
    public static void main(String[] args) {
        double calificacionFinal = 100.0;
        int porcentajeAsistencia = 80;
        boolean entregoProyectoFinal = true;

        String dictamen;

        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            dictamen = "Aprobado";
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            dictamen = "Pendiente de Examen Extraordinario";
        } else {
            dictamen = "Reprobado";
        }

        System.out.println("Calificación: " + calificacionFinal
                + " | Asistencia: " + porcentajeAsistencia + "%"
                + " | Proyecto entregado: " + entregoProyectoFinal);
        System.out.println("Dictamen académico: " + dictamen);
    }
}