public class Escalador extends Ciclista {
    // Aceleracion media de la subida
    private float AceleracionPromedioSubida;
    // Grado de la rampa soportada
    private float GradoRampaSoportada;

    // Constructor de la clase Escalador
    public Escalador(int identificador, String nombre, float AceleracionPromedioSubida, float GradoRampaSoportada) {
        super(identificador, nombre);
        this.AceleracionPromedioSubida = AceleracionPromedioSubida;
        this.GradoRampaSoportada = GradoRampaSoportada;
    }

    // Getters y Setters
    public float getAceleracionPromedioSubida() {
        return AceleracionPromedioSubida;
    }

    public void setAceleracionPromedioSubida(float AceleracionPromedioSubida) {
        this.AceleracionPromedioSubida = AceleracionPromedioSubida;
    }

    public float getGradoRampaSoportada() {
        return GradoRampaSoportada;
    }

    public void setGradoRampaSoportada(float GradoRampaSoportada) {
        this.GradoRampaSoportada = GradoRampaSoportada;
    }

    // Imprime el tipo del jugador si es de tipo Escalador
    public String imprimirTipo() {
        return "El jugador " + getNombre() + " es un escalador";
    }
}
