package es.karames.meteorologia.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static String HOST = "jdbc:sqlite:datosMeteorologicos.db";
    // private static String DB = "datosMeteorologicos.db";

    /*
     * Conexión con la base de datos
     */
    public static Connection getConexion() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(HOST);
        } catch (SQLException sqle) {
            System.out.println("ERROR Conexión BD: " + sqle.getMessage());
        }

        return conn;
    }

    /*
     * Cerrar Conexión BD
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR Cerrar Conexión BD': " + sqle.getMessage());
        }
    }

    /*
     * Cerrar Statement
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR Cerrar Statement: " + sqle.getMessage());
        }
    }

    /*
     * Cerrar PreparedStatement
     */
    public static void close(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR Cerrar PreparedStatement: " + sqle.getMessage());
        }
    }

    /*
     * Cerrar ResultSet
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR Cerrar ResultSet: " + sqle.getMessage());
        }
    }
}
