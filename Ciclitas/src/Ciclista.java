public abstract class Ciclista {
    // Identificador que va a tener el ciclista
    private int identificador;
    // Nombre del ciclista
    private String nombre;
    // Tiempo acumulado que tiene
    private int tiempoAcumulado;

    // Constructor de la clase
    public Ciclista(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tiempoAcumulado = 0;
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    // Llama al metodo imprimirTipo de las subclases para indicar el tipo de
    // ciclista que es
    public abstract String imprimirTipo();
}
