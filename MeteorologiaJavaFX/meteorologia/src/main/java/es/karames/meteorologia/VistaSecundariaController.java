package es.karames.meteorologia;

import java.io.IOException;

import javafx.fxml.FXML;

public class VistaSecundariaController {

    @FXML
    private void btnCambiarVistaPrincipal() throws IOException {
        App.setRoot("vistaPrincipal");
    }
}
