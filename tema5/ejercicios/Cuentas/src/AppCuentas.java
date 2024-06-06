import java.time.LocalDate;

import models.Cliente;
import models.Cuenta;

public class AppCuentas {
    public static void main(String[] args) throws Exception {

        Cliente cliente1 = new Cliente("Pepe", "Martínez", "C/ Estación 22",
                "Valencia", LocalDate.of(2000, 1, 1));
        Cliente cliente2 = new Cliente("Marta", "García", "C/ Mayor 25", "Madrid",
                LocalDate.of(2002, 2, 2));

        Cuenta cuenta1 = new Cuenta(111, 1000, cliente1);
        Cuenta cuenta2 = new Cuenta(222, 2000, cliente2);

        cuenta1.ingresar(100);
        cuenta1.ingresar(500);
        cuenta1.retirar(120);

        cuenta2.ingresar(1000);
        cuenta2.retirar(4000);
        cuenta2.retirar(1000);

        cuenta1.verDatos();
        cuenta2.verDatos();
    }
}
