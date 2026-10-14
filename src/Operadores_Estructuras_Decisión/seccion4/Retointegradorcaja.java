package Operadores_Estructuras_Decisión.seccion4;

public class Retointegradorcaja {


    static final double PRECIO_UNITARIO = 250.00;
    static final double IVA = 0.16;

    static double calcularTotal(int cantidad, String tipoCliente, String cupon) {

        double subtotalBase = cantidad * PRECIO_UNITARIO;

        double porcentajeDescuento = switch (tipoCliente) {
            case "VIP" -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO" -> 0.05;
            default -> 0.0;
        };
        double descuentoCliente = subtotalBase * porcentajeDescuento;
        double subtotalConDescuento = subtotalBase - descuentoCliente;

        double descuentoCupon;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        } else {
            descuentoCupon = 0.00;
        }

        // 4. Impuestos y total
        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * IVA;
        double total = baseImponible + iva;

        System.out.println("Cliente: " + tipoCliente + " | Cantidad: " + cantidad + " | Cupón: " + cupon);
        System.out.println("  Subtotal base:        $" + subtotalBase);
        System.out.println("  Descuento cliente:   -$" + descuentoCliente);
        System.out.println("  Descuento cupón:     -$" + descuentoCupon);
        System.out.println("  Base imponible:       $" + baseImponible);
        System.out.println("  IVA (16%):           +$" + iva);
        System.out.println("  Total a pagar = $" + total);
        System.out.println();
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Caso de Prueba A (esperado: 638.00) ===");
        calcularTotal(3, "VIP", "PROMO1 año");

        System.out.println("=== Caso de Prueba B (esperado: 275.50) ===");
        calcularTotal(1, "NUEVO", "PROMO1 año");
    }
}
