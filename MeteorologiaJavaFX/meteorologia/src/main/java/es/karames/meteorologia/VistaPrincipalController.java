package es.karames.meteorologia;

import java.io.IOException;

import javafx.fxml.FXML;

public class VistaPrincipalController {

    @FXML
    private void btnCambiarVistaSecundaria() throws IOException {
        App.setRoot("vistaSecundaria");
    }
}
