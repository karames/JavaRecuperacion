package es.karames.meteorologia.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import es.karames.meteorologia.tools.Auxiliar;

public class MetereologiaDAOImp implements MeteorologiaDAO {

    private Connection conn = Conexion.getConexion();

    public Connection getConn() {
        return conn;
    }

    /*
     * Devolver todos los datos de la tabla 'meteorologia'
     */
    @Override
    public List<Meteorologia> getSelectAllMeteorologia() {

        String sqlSelect = "SELECT * FROM meteorologia";
        List<Meteorologia> meteorologiaList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            Meteorologia meteorologiaRegistro;

            while (resultSet.next()) {
                String fecha = resultSet.getString("fecha");
                double precipitacion = resultSet.getDouble("precipitacion");
                double temperaturaMaxima = resultSet.getDouble("temperaturaMaxima");
                double temperaturaMinima = resultSet.getDouble("temperaturaMinima");
                meteorologiaRegistro = new Meteorologia(fecha, precipitacion, temperaturaMaxima, temperaturaMinima);
                meteorologiaList.add(meteorologiaRegistro);
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR Select *: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
            Conexion.close(resultSet);
        }

        return meteorologiaList;
    }

    /*
     * Obtener cantidad total de precipitaciones
     * Máximo temperaturas máximas
     * Mínimo temperaturas mínimas
     */
    @Override
    public double[] getSumMaxMinMeteorologia() {

        double[] datos = new double[3];
        String sqlSumPrecipitacion = "SELECT sum(precipitacion) from meteorologia";
        String sqlMaxTemperaturaMaxima = "SELECT max(temperaturaMaxima) from meteorologia";
        String sqlMinTemperaturaMinima = "SELECT min(temperaturaMinima) from meteorologia";
        Statement statement = null;
        ResultSet resultSet = null;

        // Obtener total de precipitaciones
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlSumPrecipitacion);
            datos[0] = resultSet.getDouble(1);
        } catch (SQLException sqle) {
            System.out.println("ERROR: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
            Conexion.close(resultSet);
        }

        // Obtener máximo temperaturas máximas
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlMaxTemperaturaMaxima);
            datos[1] = resultSet.getDouble(1);
        } catch (SQLException sqle) {
            System.out.println("ERROR: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
            Conexion.close(resultSet);
        }

        // Obtener mínimo temperaturas mínimas
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlMinTemperaturaMinima);
            datos[2] = resultSet.getDouble(1);
        } catch (SQLException sqle) {
            System.out.println("ERROR: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
            Conexion.close(resultSet);
        }

        return datos;
    }

    /*
     * Insertar nuevo registro en la base de datos
     */
    @Override
    public int insertarRegistro(Meteorologia registro) {

        String fecha = registro.getFecha();
        Double precipitacion = registro.getPrecipitacion();
        Double temperaturaMaxima = registro.getTemperaturaMaxima();
        Double temperaturaMinima = registro.getTemperaturaMinima();

        String sqlInsert = "INSERT INTO meteorologia VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        int rows = 0; // registros insertados
        Auxiliar validarDatos = new Auxiliar();

        // Validación de datos
        if (validarDatos.formato(registro)) {
            try {
                preparedStatement = conn.prepareStatement(sqlInsert);
                preparedStatement.setString(1, fecha);
                preparedStatement.setDouble(2, precipitacion);
                preparedStatement.setDouble(3, temperaturaMaxima);
                preparedStatement.setDouble(4, temperaturaMinima);
                rows = preparedStatement.executeUpdate();
            } catch (SQLException sqle) {
                System.out.println("ERROR Insertar Registro: " + sqle.getMessage());
            } finally {
                Conexion.close(preparedStatement);
            }
        } else {
            System.out.println("Formato no válido");
        }

        return rows;
    }
}
