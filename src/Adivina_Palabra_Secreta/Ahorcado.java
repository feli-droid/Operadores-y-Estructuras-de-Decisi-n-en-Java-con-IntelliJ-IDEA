package Adivina_Palabra_Secreta;

import java.util.Random;
import java.util.Scanner;
public class Ahorcado {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static final String[] PALABRAS = {
            "JAVA", "VARIABLE", "BUCLE", "CONSOLA", "COMPILADOR",
            "OBJETO", "CADENA", "METODO", "PROGRAMA", "INTELLIJ"
    };

    // Estadísticas acumuladas de la sesión (opción 2 del menú)
    private static int partidasJugadas = 0;
    private static int partidasGanadas = 0;
    private static double puntajeAcumulado = 0.0;
    private static double mejorPuntaje = 0.0;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcionMenu();

            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("\n¡Gracias por jugar! Hasta pronto.");
                    break;
                default:
                    // Nunca debería ocurrir: leerOpcionMenu() ya valida el rango
                    System.out.println("Opción no reconocida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    // ------------------------------------------------------------------
    // FASE 1: Menú y validación de entradas
    // ------------------------------------------------------------------
    private static void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("   AHORCADO DE CONSOLA");
        System.out.println("==============================");
        System.out.println("1. Jugar");
        System.out.println("2. Ver Estadísticas");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }

    /** Lee líneas completas y las convierte con Integer.parseInt hasta obtener 1, 2 o 3. */
    private static int leerOpcionMenu() {
        int opcion = 0;
        boolean valida = false;

        while (!valida) {
            String entrada = scanner.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.print("⚠ Opción fuera de rango. Ingresa 1, 2 o 3: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("⚠ Entrada no válida (\"" + entrada + "\"). Ingresa un número 1, 2 o 3: ");
            }
        }
        return opcion;
    }

    // ------------------------------------------------------------------
    // FASE 2: Registro del jugador + inicialización de variables
    // ------------------------------------------------------------------
    private static String pedirNombreJugador() {
        String nombre;
        do {
            System.out.print("\nIngresa tu nombre: ");
            nombre = scanner.nextLine().trim().toUpperCase();   // normalización
            if (nombre.length() == 0) {
                System.out.println("⚠ El nombre no puede estar vacío.");
            }
        } while (nombre.length() == 0);
        return nombre;
    }

    // ------------------------------------------------------------------
    // FASE 3: Bucle principal del juego
    // ------------------------------------------------------------------
    private static void jugarPartida() {
        String nombreJugador = pedirNombreJugador();
        String palabraSecreta = PALABRAS[random.nextInt(PALABRAS.length)];

        // Reto 2: dificultad dinámica según la longitud de la palabra
        final int MAX_INTENTOS = palabraSecreta.length() <= 5 ? 6
                : palabraSecreta.length() <= 8 ? 7 : 8;

        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 0.0;
        boolean juegoGanado = false;
        boolean rendido = false;
        char ultimaLetra = ' ';
        int totalTurnos = 0;     // letras válidas arriesgadas
        int aciertos = 0;        // letras que sí estaban en la palabra

        // Máscara: "_ _ _ _"
        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append("_ ");
        }
        mascara.setLength(mascara.length() - 1); // quita el último espacio

        StringBuilder historial = new StringBuilder();

        System.out.printf("%nHola, %s. La palabra tiene %d letras y tienes %d intentos.%n",
                nombreJugador, palabraSecreta.length(), MAX_INTENTOS);
        System.out.println("(Escribe 0 para rendirte)");

        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\nPalabra:   " + mascara);
            System.out.println("Usadas:    " + (historial.length() == 0 ? "-" : historial));
            System.out.println("Intentos:  " + intentosRestantes + " / " + MAX_INTENTOS);

            // Reto 1: pista con substring cuando queda 1 solo intento
            if (intentosRestantes == 1) {
                System.out.println("💡 Pista: la palabra empieza con \""
                        + palabraSecreta.substring(0, 1) + "\"");
            }

            System.out.print("Ingresa una letra: ");
            String entrada = scanner.nextLine().trim().toUpperCase();

            // Validaciones (cada una salta el turno con continue)
            if (entrada.length() == 0) {
                System.out.println("⚠ No ingresaste nada.");
                continue;
            }
            if (entrada.equals("0")) {
                rendido = true;
                break;                                   // rendición
            }
            if (entrada.length() > 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("⚠ Ingresa UNA sola letra (A-Z).");
                continue;
            }

            ultimaLetra = entrada.charAt(0);
            String letraTexto = String.valueOf(ultimaLetra);

            if (historial.indexOf(letraTexto) >= 0) {
                System.out.println("⚠ Ya intentaste la letra '" + ultimaLetra + "'.");
                continue;                                // letra repetida
            }

            historial.append(ultimaLetra).append(' ');
            totalTurnos++;

            // Buscar coincidencias y destapar la máscara
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String letraSecreta = String.valueOf(palabraSecreta.charAt(i));
                if (letraSecreta.equalsIgnoreCase(letraTexto)) {
                    mascara.setCharAt(i * 2, ultimaLetra);   // *2 por los espacios
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                intentosRestantes--;
            }

            // Operador ternario para el mensaje de retroalimentación
            System.out.println(acierto ? "✔ ¡Bien! La letra '" + ultimaLetra + "' está en la palabra."
                    : "✘ La letra '" + ultimaLetra + "' NO está en la palabra.");

            if (mascara.indexOf("_") == -1) {
                juegoGanado = true;
                break;                                   // victoria
            }
        }

        // ------------------------------------------------------------------
        // Cálculo de puntaje (Reto 3: multiplicador por eficiencia)
        // ------------------------------------------------------------------
        if (juegoGanado) {
            int fallos = totalTurnos - aciertos;
            double base = 50.0 + intentosRestantes * 12.5;
            double eficiencia = totalTurnos > 0 ? (double) aciertos / totalTurnos : 0.0;
            double multiplicador = 1.0 + eficiencia * 0.5 - fallos * 0.02;
            puntaje = base * Math.max(multiplicador, 1.0);
        }

        // Actualizar estadísticas globales
        partidasJugadas++;
        if (juegoGanado) partidasGanadas++;
        puntajeAcumulado += puntaje;
        if (puntaje > mejorPuntaje) mejorPuntaje = puntaje;

        mostrarResumen(nombreJugador, juegoGanado, rendido, palabraSecreta,
                intentosRestantes, MAX_INTENTOS, aciertos, totalTurnos, puntaje);
    }

    // ------------------------------------------------------------------
    // FASE 4: Resumen formateado con printf
    // ------------------------------------------------------------------
    private static void mostrarResumen(String jugador, boolean ganado, boolean rendido,
                                       String palabra, int restantes, int max,
                                       int aciertos, int totalTurnos, double puntaje) {
        // Casting a double para evitar la división entera
        double porcentaje = totalTurnos > 0 ? (double) aciertos / totalTurnos * 100 : 0.0;
        String estado = ganado ? "¡VICTORIA!" : (rendido ? "RENDICIÓN" : "DERROTA");

        System.out.println();
        System.out.printf("====================================================%n");
        System.out.printf("RESUMEN DE LA PARTIDA%n");
        System.out.printf("====================================================%n");
        System.out.printf("%-22s %s%n", "Jugador:", jugador);
        System.out.printf("%-22s %s%n", "Estado Final:", estado);
        System.out.printf("%-22s %s%n", "Palabra Secreta:", palabra);
        System.out.printf("%-22s %d / %d%n", "Intentos Restantes:", restantes, max);
        System.out.printf("%-22s %.2f%%%n", "Porcentaje Aciertos:", porcentaje);
        System.out.printf("%-22s %.2f pts%n", "Puntaje Final:", puntaje);
        System.out.printf("====================================================%n");
    }

    private static void mostrarEstadisticas() {
        System.out.printf("%n====== ESTADÍSTICAS DE LA SESIÓN ======%n");
        if (partidasJugadas == 0) {
            System.out.printf("Aún no has jugado ninguna partida.%n");
            return;
        }
        double porcentajeVictorias = (double) partidasGanadas / partidasJugadas * 100;
        System.out.printf("%-22s %d%n", "Partidas jugadas:", partidasJugadas);
        System.out.printf("%-22s %d%n", "Partidas ganadas:", partidasGanadas);
        System.out.printf("%-22s %.2f%%%n", "% de victorias:", porcentajeVictorias);
        System.out.printf("%-22s %.2f pts%n", "Puntaje acumulado:", puntajeAcumulado);
        System.out.printf("%-22s %.2f pts%n", "Mejor puntaje:", mejorPuntaje);
    }
}
