package Operadores_Estructuras_Decisión.seccion5;

public class Errorfallthrough {
    public static void main(String[] args) {
        int opcionCategoria = 1;

        switch (opcionCategoria) {
            case 1:
                System.out.println("Categoría Selección: Lunes (Jornada Laboral)");
                break;
            case 2:
                System.out.println("Categoría Selección: Martes (Jornada Laboral)");
                break;
            case 3:
                System.out.println("Categoría Selección: Miércoles (Jornada Laboral)");
                break;
            default:
                System.out.println("Día no identificado");
                break;
        }
    }
}