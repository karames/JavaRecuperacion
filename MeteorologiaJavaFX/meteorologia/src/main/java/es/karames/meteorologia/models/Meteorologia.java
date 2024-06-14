package es.karames.meteorologia.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Meteorologia {

    private SimpleStringProperty fecha;
    private SimpleDoubleProperty precipitacion;
    private SimpleDoubleProperty temperaturaMaxima;
    private SimpleDoubleProperty temperaturaMinima;

    public Meteorologia(String fecha, double precipitacion, double temperaturaMaxima, double temperaturaMinima) {
        this.fecha = new SimpleStringProperty(fecha);
        this.precipitacion = new SimpleDoubleProperty();
        this.temperaturaMaxima = new SimpleDoubleProperty(temperaturaMaxima);
        this.temperaturaMinima = new SimpleDoubleProperty(temperaturaMinima);
    }

    public SimpleStringProperty getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public SimpleDoubleProperty getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(double precipitacion) {
        this.precipitacion.set(precipitacion);
    }

    public SimpleDoubleProperty getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima.set(temperaturaMaxima);
    }

    public SimpleDoubleProperty getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima.set(temperaturaMinima);
    }

    @Override
    public String toString() {
        return "Meteorologia [fecha=" + fecha + ", precipitacion=" + precipitacion + ", temperaturaMaxima="
                + temperaturaMaxima + ", temperaturaMinima=" + temperaturaMinima + "]";
    }
}
