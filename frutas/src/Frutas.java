import java.sql.SQLException;
import java.util.List;

import modelos.FrutasDAO;
import modelos.FrutasDTO;

public class Frutas {
    public static void main(String[] args) throws Exception {

        FrutasDAO frutaDAO = new FrutasDAO();

        frutaDAO.createTable();

        // frutaDAO.dropTable();

        frutaDAO.insertFrutas();

        // SELECT LISTA fruta
        List<FrutasDTO> listaFrutas = frutaDAO.selectFrutas();
        for (FrutasDTO item : listaFrutas) {
            System.out.println(item);
        }

        // cerrar conexion
        try {
            frutaDAO.getConn().close();
        } catch (SQLException sqle) {
            System.out.println("error cerrar conexion: " + sqle.getMessage());
        } finally {
            System.out.println("ejecucion finalizada");
        }
    }
}
