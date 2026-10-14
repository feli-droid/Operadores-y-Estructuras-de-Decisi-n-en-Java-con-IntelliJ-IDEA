package Estructuras_Repetitivas_Sentencias_Ramificación.seccion5;

import java.util.Scanner;

public class Ejerciciointegrador {

    static final int CAPACIDAD_MAXIMA = 500;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalUnidades = 0;
        double valorInventario = 0;
        int productosRegistrados = 0;
        int productosDescontinuados = 0;
        int opcion;

        do {
            System.out.println("\n===== ALMACÉN LOGÍSTICO =====");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (totalUnidades > CAPACIDAD_MAXIMA) {
                        System.out.println("¡ALERTA! El almacén ya superó su capacidad máxima.");
                        break;
                    }
                    System.out.print("¿Cuántos productos componen el lote? ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\n-- Producto " + i + " de " + n + " --");
                        System.out.print("¿Está descontinuado? (s/n): ");
                        String resp = sc.next();

                        if (resp.equalsIgnoreCase("s")) {
                            productosDescontinuados++;
                            System.out.println("Producto descontinuado: se omite.");
                            continue;
                        }

                        System.out.print("Precio unitario: $");
                        double precio = sc.nextDouble();
                        while (precio <= 0) {
                            System.out.print("Error: el precio debe ser mayor a cero. Reintente: $");
                            precio = sc.nextDouble();
                        }

                        System.out.print("Cantidad en stock: ");
                        int stock = sc.nextInt();
                        while (stock <= 0) {
                            System.out.print("Error: el stock debe ser mayor a cero. Reintente: ");
                            stock = sc.nextInt();
                        }

                        totalUnidades += stock;
                        valorInventario += precio * stock;
                        productosRegistrados++;

                        if (totalUnidades > CAPACIDAD_MAXIMA) {
                            System.out.println("¡ALERTA DE SOBRECUPO! Capacidad máxima de "
                                    + CAPACIDAD_MAXIMA + " unidades superada ("
                                    + totalUnidades + "). Se aborta el resto del lote.");
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- Estado del Almacén ---");
                    System.out.println("Productos registrados:   " + productosRegistrados);
                    System.out.println("Productos descontinuados: " + productosDescontinuados);
                    System.out.println("Unidades totales:        " + totalUnidades + " / " + CAPACIDAD_MAXIMA);
                    System.out.printf("Valor del inventario:    $%,.2f%n", valorInventario);
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();
    }
}

