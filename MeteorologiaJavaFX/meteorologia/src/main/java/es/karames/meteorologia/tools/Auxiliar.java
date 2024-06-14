package es.karames.meteorologia.tools;

import es.karames.meteorologia.models.Meteorologia;

public class Auxiliar {

    public boolean formato(Meteorologia registro) {

        String fecha = registro.getFecha();
        String precipitacion = String.valueOf(registro.getPrecipitacion());
        String temperaturaMaxima = String.valueOf(registro.getTemperaturaMaxima());
        String temperaturaMinima = String.valueOf(registro.getTemperaturaMinima());

        String regexFecha = "^[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}$";
        String regexDouble = "^[1-9]?[0-9].[0-9]$";

        if (!fecha.matches(regexFecha) ||
                !precipitacion.matches(regexDouble) ||
                !temperaturaMaxima.matches(regexDouble) ||
                !temperaturaMinima.matches(regexDouble)) {
            return false;
        } else {
            return true;
        }
    }
}
