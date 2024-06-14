import java.util.ArrayList;

public class Equipo {
    // Nombre del equipo
    private String nombre;
    // Pais del equipo
    private String pais;
    // Suma de los minutos que tienen en total todos los ciclistas juntos
    private int sumaMinutos;
    // ArrayList que guarda los ciclistas del equipo
    private ArrayList<Ciclista> ciclistas;

    // Constructor de la clase
    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciclistas = new ArrayList<>();
        // Bucle para sumar los minutos de todos los ciclistas
        for (Ciclista ciclista : ciclistas) {
            this.sumaMinutos += ciclista.getTiempoAcumulado();
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getSumaMinutos() {
        return sumaMinutos;
    }

    public void setSumaMinutos(int sumaMinutos) {
        this.sumaMinutos = sumaMinutos;
    }

    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    // Agrega a la lista de ciclistas el ciclista que queremos ingresar
    public void agregarCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    // Imprime por pantalla los datos del equipo
    public void imprimirDatosEquipo() {
        System.out.println(
                "Nombre: " + nombre + "\nPais: " + pais + "\nSuma de minutos: " + sumaMinutos + " Ciclistas: ");
    }

    // Imprime por pantalla la lista de los jugadores que hay en ese equipo
    public void listaJugadores() {
        // Bucle para imprimir el nombre de cada ciclista
        for (Ciclista ciclista : ciclistas) {
            System.out.println(ciclista.getNombre());
        }
    }

    // Busca un ciclista mediante su identificador
    public String buscarCiclista(int identificador) {
        // Bucle para comparar a cada ciclista y mostrarlo
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.getIdentificador() == identificador) {
                return ciclista.getIdentificador() + " " + ciclista.getNombre();
            }
        }
        return "No se ha encontrado al ciclista";
    }
}
