import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Crea un método que usando expresiones regulares nos diga si es válido o no el
 * formato de una dirección MAC de una interfaz de red.
 * Las direcciones MAC están compuestas de 12 caracteres,que puede ser una
 * combinación de números y letras (a, b, c, d, e, f).
 * Los formatos que se aceptan son:
 * 00:10:15:ad:a1:0f || 00-10-15-ad-a1-0f
 * 00:10:15:AD:A1:0F || 00-10-15-AD-A1-0F
 */
public class TestValidarDireccionMac {
    public static void main(String[] args) throws Exception {
        // String direccionMac = "00:10:15:ad:a1:0f";
        // String direccionMac = "00:10:15:AD:A1:0F";
        // String direccionMac = "00-10-15-ad-a1-0f";
        // String direccionMac = "00-10-15-AD-A1-0F";
        System.out.println("\nIntroduce dirección MAC");
        Scanner scanner = new Scanner(System.in);
        String direccionMac = scanner.nextLine();
        scanner.close();
        System.out.println("\nLa dirección MAC " + direccionMac + validarDireccionMac(direccionMac));
    }

    public static String validarDireccionMac(String mac) {
        String mensaje;

        // Si la cadena está vacía retornar falso
        if (mac == null || mac == "") {
            return mensaje = "Dirección MAC vacía";
        }

        // Regex para validar dirección MAC
        String regex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

        boolean isMatch = Pattern.compile(regex).matcher(mac).find();
        mensaje = isMatch ? " es válida" : " no es válida";
        return mensaje;
    }
}
