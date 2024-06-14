package recuperacion.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import recuperacion.models.Conexion;
import recuperacion.models.Meteorologia;
import recuperacion.models.MetereologiaDAOImp;

public class AppMeteorologia {

    public static void main(String[] args) throws Exception {
        MetereologiaDAOImp meteorologiaDAO = new MetereologiaDAOImp();
        mainInicializarBD();
        mainGetSelectAllMeteorologia(meteorologiaDAO);
        mainGetSumMaxMinMeteorologia(meteorologiaDAO);
        mainInsertarRegistro(meteorologiaDAO);
        mainFinalizarApp(meteorologiaDAO);
    }

    /*
     * Inicializar la BD
     * Comprobar si existe la tabla 'meteorologia'
     * Insertar registros en lote
     */
    public static void mainInicializarBD() {

        String sqlCrearTabla = """
                CREATE TABLE IF NOT EXISTS "meteorologia" (
                    "fecha"	TEXT,
                    "precipitacion"	REAL NOT NULL,
                    "temperaturaMaxima"	REAL NOT NULL,
                    "temperaturaMinima"	REAL NOT NULL,
                PRIMARY KEY("fecha")
                );
                """;

        String sqlInsertarRegistros = """
                INSERT INTO "meteorologia" VALUES ('02-09-2018',0.0,36.7,24.0);
                INSERT INTO "meteorologia" VALUES ('03-09-2018',0.0,32.1,20.8);
                INSERT INTO "meteorologia" VALUES ('04-09-2018',0.0,29.3,16.7);
                INSERT INTO "meteorologia" VALUES ('05-09-2018',0.0,26.8,15.7);
                INSERT INTO "meteorologia" VALUES ('06-09-2018',0.0,28.1,16.1);
                INSERT INTO "meteorologia" VALUES ('07-09-2018',0.0,30.4,16.9);
                INSERT INTO "meteorologia" VALUES ('08-09-2018',2.0,24.1,17.9);
                INSERT INTO "meteorologia" VALUES ('09-09-2018',0.0,26.5,15.1);
                INSERT INTO "meteorologia" VALUES ('10-09-2018',0.0,29.3,15.8);
                INSERT INTO "meteorologia" VALUES ('11-09-2018',0.0,29.3,21.4);
                INSERT INTO "meteorologia" VALUES ('12-09-2018',0.0,30.2,21.4);
                INSERT INTO "meteorologia" VALUES ('13-09-2018',0.0,32.7,20.1);
                INSERT INTO "meteorologia" VALUES ('14-09-2018',2.4,29.8,19.2);
                INSERT INTO "meteorologia" VALUES ('15-09-2018',0.0,25.1,17.6);
                INSERT INTO "meteorologia" VALUES ('16-09-2018',0.0,29.2,17.4);
                INSERT INTO "meteorologia" VALUES ('17-09-2018',30.4,28.2,18.8);
                INSERT INTO "meteorologia" VALUES ('18-09-2018',0.0,29.4,18.3);
                INSERT INTO "meteorologia" VALUES ('19-09-2018',0.0,31.3,19.5);
                INSERT INTO "meteorologia" VALUES ('20-09-2018',0.0,30.9,19.9);
                INSERT INTO "meteorologia" VALUES ('21-09-2018',0.0,31.5,19.3);
                INSERT INTO "meteorologia" VALUES ('22-09-2018',0.0,33.9,21.1);
                INSERT INTO "meteorologia" VALUES ('23-09-2018',0.0,34.3,20.8);
                INSERT INTO "meteorologia" VALUES ('24-09-2018',0.0,34.2,21.3);
                INSERT INTO "meteorologia" VALUES ('25-09-2018',0.0,33.5,21.1);
                INSERT INTO "meteorologia" VALUES ('26-09-2018',5.6,29.3,20.2);
                INSERT INTO "meteorologia" VALUES ('27-09-2018',0.0,28.5,20.6);
                INSERT INTO "meteorologia" VALUES ('28-09-2018',0.0,26.8,16.9);
                INSERT INTO "meteorologia" VALUES ('29-09-2018',0.0,28.1,16.0);
                INSERT INTO "meteorologia" VALUES ('30-09-2018',0.0,28.6,17.4);
                INSERT INTO "meteorologia" VALUES ('01-10-2018',0.0,28.7,18.2);
                INSERT INTO "meteorologia" VALUES ('02-10-2018',0.0,27.1,15.0);
                INSERT INTO "meteorologia" VALUES ('03-10-2018',0.0,27.9,15.1);
                INSERT INTO "meteorologia" VALUES ('04-10-2018',0.0,28.2,15.6);
                INSERT INTO "meteorologia" VALUES ('05-10-2018',0.0,28.7,16.1);
                INSERT INTO "meteorologia" VALUES ('06-10-2018',0.0,28.7,15.7);
                INSERT INTO "meteorologia" VALUES ('07-10-2018',0.0,27.5,17.1);
                INSERT INTO "meteorologia" VALUES ('08-10-2018',0.0,24.2,13.1);
                INSERT INTO "meteorologia" VALUES ('09-10-2018',7.0,21.7,13.9);
                INSERT INTO "meteorologia" VALUES ('10-10-2018',1.8,22.3,12.7);
                INSERT INTO "meteorologia" VALUES ('11-10-2018',0.0,22.0,16.0);
                INSERT INTO "meteorologia" VALUES ('12-10-2018',0.0,26.1,14.8);
                INSERT INTO "meteorologia" VALUES ('13-10-2018',0.0,29.0,17.0);
                INSERT INTO "meteorologia" VALUES ('14-10-2018',11.2,25.5,12.6);
                INSERT INTO "meteorologia" VALUES ('15-10-2018',6.0,17.1,10.1);
                INSERT INTO "meteorologia" VALUES ('16-10-2018',0.0,17.1,10.0);
                INSERT INTO "meteorologia" VALUES ('17-10-2018',0.0,22.3,12.5);
                INSERT INTO "meteorologia" VALUES ('18-10-2018',9.4,18.9,10.7);
                INSERT INTO "meteorologia" VALUES ('19-10-2018',0.0,17.7,8.7);
                INSERT INTO "meteorologia" VALUES ('20-10-2018',0.6,19.0,12.0);
                INSERT INTO "meteorologia" VALUES ('21-10-2018',0.0,23.6,15.5);
                INSERT INTO "meteorologia" VALUES ('22-10-2018',0.0,23.5,13.7);
                INSERT INTO "meteorologia" VALUES ('23-10-2018',0.0,23.1,16.5);
                INSERT INTO "meteorologia" VALUES ('24-10-2018',0.0,22.7,13.7);
                INSERT INTO "meteorologia" VALUES ('25-10-2018',0.0,24.0,13.1);
                INSERT INTO "meteorologia" VALUES ('26-10-2018',0.0,18.1,13.6);
                INSERT INTO "meteorologia" VALUES ('27-10-2018',5.2,17.6,10.0);
                INSERT INTO "meteorologia" VALUES ('28-10-2018',3.0,10.0,4.2);
                INSERT INTO "meteorologia" VALUES ('29-10-2018',0.0,10.2,5.0);
                INSERT INTO "meteorologia" VALUES ('30-10-2018',15.4,13.8,7.3);
                INSERT INTO "meteorologia" VALUES ('31-10-2018',5.6,12.0,5.8);
                INSERT INTO "meteorologia" VALUES ('01-11-2018',0.0,13.8,5.5);
                INSERT INTO "meteorologia" VALUES ('02-11-2018',0.0,12.4,7.5);
                INSERT INTO "meteorologia" VALUES ('03-11-2018',0.0,17.1,8.1);
                INSERT INTO "meteorologia" VALUES ('04-11-2018',0.0,16.9,7.8);
                INSERT INTO "meteorologia" VALUES ('05-11-2018',11.2,13.6,8.3);
                INSERT INTO "meteorologia" VALUES ('06-11-2018',0.0,13.5,6.0);
                INSERT INTO "meteorologia" VALUES ('07-11-2018',0.2,16.0,7.8);
                INSERT INTO "meteorologia" VALUES ('08-11-2018',15.2,16.2,7.6);
                INSERT INTO "meteorologia" VALUES ('09-11-2018',0.0,12.8,7.6);
                INSERT INTO "meteorologia" VALUES ('10-11-2018',0.0,16.3,8.2);
                INSERT INTO "meteorologia" VALUES ('11-11-2018',0.0,18.8,10.2);
                INSERT INTO "meteorologia" VALUES ('12-11-2018',0.0,16.7,9.8);
                INSERT INTO "meteorologia" VALUES ('13-11-2018',0.0,17.6,9.8);
                INSERT INTO "meteorologia" VALUES ('14-11-2018',0.0,17.2,15.0);
                INSERT INTO "meteorologia" VALUES ('15-11-2018',3.2,19.1,12.2);
                INSERT INTO "meteorologia" VALUES ('16-11-2018',0.0,18.6,13.0);
                INSERT INTO "meteorologia" VALUES ('17-11-2018',0.0,19.1,13.1);
                INSERT INTO "meteorologia" VALUES ('18-11-2018',10.0,14.6,10.0);
                INSERT INTO "meteorologia" VALUES ('19-11-2018',2.6,13.2,9.2);
                INSERT INTO "meteorologia" VALUES ('20-11-2018',6.6,14.5,9.4);
                INSERT INTO "meteorologia" VALUES ('21-11-2018',0.4,13.6,10.2);
                INSERT INTO "meteorologia" VALUES ('22-11-2018',3.4,12.0,9.1);
                INSERT INTO "meteorologia" VALUES ('23-11-2018',3.4,12.3,6.6);
                INSERT INTO "meteorologia" VALUES ('24-11-2018',0.0,11.5,5.2);
                INSERT INTO "meteorologia" VALUES ('25-11-2018',1.6,16.4,10.3);
                INSERT INTO "meteorologia" VALUES ('26-11-2018',4.2,14.7,8.4);
                INSERT INTO "meteorologia" VALUES ('27-11-2018',0.0,13.3,5.6);
                INSERT INTO "meteorologia" VALUES ('28-11-2018',0.0,15.5,5.2);
                INSERT INTO "meteorologia" VALUES ('29-11-2018',0.0,15.4,6.0);
                INSERT INTO "meteorologia" VALUES ('30-11-2018',0.2,14.5,7.8);
                INSERT INTO "meteorologia" VALUES ('01-12-2018',0.0,13.3,5.4);
                INSERT INTO "meteorologia" VALUES ('02-12-2018',0.0,15.1,6.9);
                INSERT INTO "meteorologia" VALUES ('03-12-2018',0.0,19.2,9.4);
                INSERT INTO "meteorologia" VALUES ('04-12-2018',0.0,20.8,10.5);
                INSERT INTO "meteorologia" VALUES ('05-12-2018',0.0,21.0,11.4);
                INSERT INTO "meteorologia" VALUES ('06-12-2018',0.0,19.8,9.9);
                INSERT INTO "meteorologia" VALUES ('07-12-2018',0.0,17.3,9.2);
                INSERT INTO "meteorologia" VALUES ('08-12-2018',0.0,15.8,7.2);
                INSERT INTO "meteorologia" VALUES ('09-12-2018',0.0,19.6,8.6);
                INSERT INTO "meteorologia" VALUES ('10-12-2018',0.0,18.9,11.0);
                INSERT INTO "meteorologia" VALUES ('11-12-2018',0.0,14.9,9.5);
                INSERT INTO "meteorologia" VALUES ('12-12-2018',0.0,12.6,8.7);
                INSERT INTO "meteorologia" VALUES ('13-12-2018',6.4,13.0,6.9);
                INSERT INTO "meteorologia" VALUES ('14-12-2018',0.0,9.3,5.0);
                INSERT INTO "meteorologia" VALUES ('15-12-2018',0.0,12.6,3.4);
                INSERT INTO "meteorologia" VALUES ('16-12-2018',0.2,13.4,5.2);
                INSERT INTO "meteorologia" VALUES ('17-12-2018',0.0,12.6,5.3);
                INSERT INTO "meteorologia" VALUES ('18-12-2018',0.0,13.2,5.4);
                INSERT INTO "meteorologia" VALUES ('19-12-2018',0.6,12.3,7.3);
                INSERT INTO "meteorologia" VALUES ('20-12-2018',0.0,12.8,6.3);
                INSERT INTO "meteorologia" VALUES ('21-12-2018',0.0,14.0,4.5);
                INSERT INTO "meteorologia" VALUES ('22-12-2018',0.0,15.0,5.5);
                INSERT INTO "meteorologia" VALUES ('23-12-2018',0.0,17.2,6.8);
                INSERT INTO "meteorologia" VALUES ('24-12-2018',0.0,16.5,5.4);
                INSERT INTO "meteorologia" VALUES ('25-12-2018',0.0,16.3,8.5);
                INSERT INTO "meteorologia" VALUES ('26-12-2018',0.0,13.6,6.3);
                INSERT INTO "meteorologia" VALUES ('27-12-2018',0.0,14.1,5.3);
                INSERT INTO "meteorologia" VALUES ('28-12-2018',0.0,13.5,4.4);
                INSERT INTO "meteorologia" VALUES ('29-12-2018',0.0,10.9,3.1);
                INSERT INTO "meteorologia" VALUES ('30-12-2018',0.0,15.7,8.7);
                INSERT INTO "meteorologia" VALUES ('31-12-2018',0.0,15.1,3.7);
                """;

        Connection conn = null;
        Statement statement = null;

        // Creación de tabla 'meteorologia' si no existe
        try {
            conn = Conexion.getConexion();
            statement = conn.createStatement();
            statement.executeUpdate(sqlCrearTabla);
        } catch (SQLException sqle) {
            System.out.println("ERROR Creación Tabla 'meteorologia' (mainInicializarBD): " + sqle.getMessage());
        } finally {
            Conexion.close(conn);
            Conexion.close(statement);
        }

        // Insertar registros en lote
        try {
            conn = Conexion.getConexion();
            // Revisar si la conexión está en modo autocommit (por defecto true)
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            statement = conn.createStatement();
            statement.executeUpdate(sqlInsertarRegistros);
            conn.commit();
        } catch (SQLException sqlec) {
            System.out.println("ERROR Commit (mainInicializarBD): " + sqlec.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqler) {
                System.out.println("ERROR Rollback (mainInicializarBD): " + sqler.getMessage());
            }
        } finally {
            Conexion.close(conn);
            Conexion.close(statement);
        }
    }

    /*
     * Obtener todos los datos de la tabla 'meteorologia'
     */
    public static void mainGetSelectAllMeteorologia(MetereologiaDAOImp meteorologiaDAO) {

        List<Meteorologia> meteorologiaList = meteorologiaDAO.getSelectAllMeteorologia();

        for (Meteorologia item : meteorologiaList) {
            System.out.print(item);
            System.out.println();
        }
    }

    /*
     * Obtener total precipitaciones, máximo y mínimo
     */
    public static void mainGetSumMaxMinMeteorologia(MetereologiaDAOImp meteorologiaDAO) {

        double[] datos = meteorologiaDAO.getSumMaxMinMeteorologia();

        System.out.println("TOTAL PRECIPITACIONES: " + datos[0]);
        System.out.println("MÁXIMO TEMPERATURAS MÁXIMAS: " + datos[1]);
        System.out.println("MÍNIMA TEMPERATURAS MÍNIMAS: " + datos[2]);
    }

    /*
     * Insertar registro
     */
    public static void mainInsertarRegistro(MetereologiaDAOImp meteorologiaDAO) {

        String fecha = "29-06-2024";
        double precipitacion = 9.9;
        double temperaturaMaxima = 99.9;
        double temperaturaMinima = 99.9;
        int rows = 0;

        Meteorologia registro = new Meteorologia(fecha, precipitacion, temperaturaMaxima, temperaturaMinima);
        rows = meteorologiaDAO.insertarRegistro(registro);

        if (rows == 0) {
            System.out.println("ERROR: El registro no ha sido insertado");
        } else {
            System.out.println("Registro insertado");
        }
    }

    /*
     * Cerrar base de datos
     */
    public static void mainFinalizarApp(MetereologiaDAOImp meteorologiaDAO) {
        try {
            meteorologiaDAO.getConn().close();
            System.err.println("Cerrada la BD");
        } catch (SQLException sqle) {
            System.out.println("ERROR no se puedo cerrar la BD: " + sqle.getMessage());
        } finally {
            System.out.println("Ejecución finalizada");
        }
    }

}
