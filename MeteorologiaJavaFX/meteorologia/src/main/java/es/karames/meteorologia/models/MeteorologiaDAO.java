package es.karames.meteorologia.models;

import java.util.List;

public interface MeteorologiaDAO {

    public List<Meteorologia> getSelectAllMeteorologia();

    public double[] getSumMaxMinMeteorologia();

    public int insertarRegistro(Meteorologia registro);
}
