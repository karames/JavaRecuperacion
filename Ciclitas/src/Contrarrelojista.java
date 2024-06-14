public class Contrarrelojista extends Ciclista {
    // Velocidad maxima del contrarrelojista
    private double velocidadMaxima;

    // Constructor
    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        this.velocidadMaxima = velocidadMaxima;
    }

    // Getters y Setters
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    // Imprime el tipo del jugador si es de tipo contrarrelojista
    public String imprimirTipo() {
        return "El jugador " + getNombre() + " es un contrarrelojista";
    }
}
