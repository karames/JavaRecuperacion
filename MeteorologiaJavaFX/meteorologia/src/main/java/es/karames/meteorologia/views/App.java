package es.karames.meteorologia.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) throws Exception {

        // Cargar la vista principal desde el archivo fxml en un HBox
        HBox layoutPrincipal = FXMLLoader
                .load(getClass().getResource("/es/karames/meteorologia/views/ventanaPrincipal.fxml"));

        // Crear la escena que contiene el layout principal
        Scene escena = new Scene(layoutPrincipal, 800, 500);

        // Establecer CSS
        escena.getStylesheets()
                .add(getClass().getResource("/es/karames/meteorologia/styles/styles.css").toExternalForm());

        // Establecer escena, título y mostrar
        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.setTitle("METEOROLOGIA");
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
