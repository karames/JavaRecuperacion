package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FrutasDAO {

    private Connection conn = Conexion.getConexion();
    private Statement statement = null;
    private ResultSet rs = null;

    /*
     * CREAR TABLA fruta
     */
    public void createTable() {
        String sqlCrearTabla = """
                CREATE TABLE IF NOT EXISTS fruta (
                id INTEGER PRIMARY KEY,
                nombre TEXT NOT NULL,
                color TEXT NOT NULL
                );
                """;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sqlCrearTabla);
        } catch (SQLException sqle) {
            System.out.println("error crear tabla: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
        }
    }

    /*
     * BORRAR TABLA fruta
     */
    public void dropTable() {
        String sqlBorrarTabla = """
                DROP TABLE IF EXISTS fruta;
                """;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sqlBorrarTabla);
        } catch (SQLException sqle) {
            System.out.println("error borrar tabla: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
        }
    }

    /*
     * INSERTAR REGISTROS TABLA fruta
     */
    public void insertFrutas() {
        String sqlInsertarFrutas = """
                INSERT INTO fruta (nombre, color) VALUES
                ('apple', 'red'),
                ('banana', 'yellow'),
                ('watermelon', 'green'),
                ('pear', 'yellow'),
                ('orange', 'orange'),
                ('apple', 'yellow'),
                ('grape', 'purple'),
                ('apple', 'green'),
                ('kiwi', 'green'),
                ('strawberry', 'red');
                """;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sqlInsertarFrutas);
        } catch (SQLException sqle) {
            System.out.println("error insertar valores en tabla: " + sqle.getMessage());
        } finally {
            Conexion.close(statement);
        }
    }

    /*
     * SELECT TABLA fruta
     */
    public List<FrutasDTO> selectFrutas() {
        String sqlSelect = "SELECT * FROM fruta;";
        List<FrutasDTO> listaFrutas = new ArrayList<>();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sqlSelect);
            FrutasDTO frutaRegistro;
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String color = rs.getString("color");
                frutaRegistro = new FrutasDTO(id, nombre, color);
                listaFrutas.add(frutaRegistro);
            }
        } catch (SQLException sqle) {
            System.out.println("error select: " + sqle.getMessage());
        } finally {
            Conexion.close(rs);
            Conexion.close(statement);
        }
        return listaFrutas;
    }

    public Connection getConn() {
        return conn;
    }

}
