package recuperacion.models;

public class Meteorologia {

    private String fecha;
    private double precipitacion;
    private double temperaturaMaxima;
    private double temperaturaMinima;

    public Meteorologia(String fecha, double precipitacion, double temperaturaMaxima, double temperaturaMinima) {
        this.fecha = fecha;
        this.precipitacion = precipitacion;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(double precipitacion) {
        this.precipitacion = precipitacion;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public String toString() {
        return "Meteorologia [fecha=" + fecha + ", precipitacion=" + precipitacion + ", temperaturaMaxima="
                + temperaturaMaxima + ", temperaturaMinima=" + temperaturaMinima + "]";
    }
}
