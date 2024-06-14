public class Velocista extends Ciclista {

    // Potencia media del velocista
    private double potenciaPromedio;
    // Velocidad media en sprint del velocista
    private double velocidadPromedioSprint;

    // Constructor de la clase
    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedioSprint) {
        super(identificador, nombre);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }

    // Getters y Setters
    public double getPotenciaPromedio() {
        return potenciaPromedio;
    }

    public void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }

    public double getVelocidadPromedioSprint() {
        return velocidadPromedioSprint;
    }

    public void setVelocidadPromedioSprint(double velocidadPromedioSprint) {
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }

    // Este en especifico devuelve si el ciclista es Velocista que es un velocista
    public String imprimirTipo() {
        return "El jugador " + getNombre() + " es un velocista";
    }
}
