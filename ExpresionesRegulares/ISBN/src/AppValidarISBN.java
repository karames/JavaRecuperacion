import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AppValidarISBN {
    public static void main(String[] args) throws Exception {

        List<String> listaISBN = new ArrayList<String>();

        // ISBN válidos
        listaISBN.add("9788481647822");
        listaISBN.add("978-8481647822");
        listaISBN.add("978 8481647822");
        listaISBN.add("9798481647822");
        listaISBN.add("979-8481647822");
        listaISBN.add("979 8481647822");

        // ISBN inválidos
        listaISBN.add("9778481647822");
        listaISBN.add("978--8481647822");
        listaISBN.add("978  8481647822");
        listaISBN.add("978 84 81 64 78 22");

        String regex = "^(978|979)[- ]?[0-9]{10}$";
        String mensaje;
        boolean isMatch;

        for (String isbn : listaISBN) {
            isMatch = Pattern.compile(regex).matcher(isbn).find();
            mensaje = isMatch ? " válido" : " inválido";
            System.out.println("ISBN " + isbn + mensaje);
        }

    }
}
