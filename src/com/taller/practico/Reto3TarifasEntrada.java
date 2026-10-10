package com.taller.practico;

public class Reto3TarifasEntrada {
    public static void main(String[] args) {
        double precioBase = 100.0;
        String[] tipos = {"VIP", "ESTUDIANTE", "GENERAL", "ADULTO_MAYOR"};

        for (String tipoEntrada : tipos) {
            double precioFinal;

            if (tipoEntrada.equals("VIP")) {
                precioFinal = precioBase * 1.10;          // +10% recargo
            } else if (tipoEntrada.equals("ESTUDIANTE")) {
                precioFinal = precioBase * 0.50;          // -50%
            } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
                precioFinal = precioBase * 0.60;          // -40%
            } else {
                precioFinal = precioBase;                 // GENERAL
            }

            System.out.println("Tipo de entrada: " + tipoEntrada + " | Monto final a pagar: $" + precioFinal);
        }
    }
}
