package es.karames.meteorologia.controllers;

import es.karames.meteorologia.models.Contacto;
// import es.karames.meteorologia.models.Contacto;
import es.karames.meteorologia.models.Meteorologia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaPrincipalController {

    @FXML
    private TableView<Meteorologia> tablaMeteorologia;
    @FXML
    private TableColumn<Meteorologia, String> columnaFecha;
    @FXML
    private TableColumn<Meteorologia, Double> columnaPrecipitacion;
    @FXML
    private TableColumn<Meteorologia, Double> columnaTemperaturaMaxima;
    @FXML
    private TableColumn<Meteorologia, Double> columnaTemperaturaMinima;
    @FXML
    private Label labelFecha;
    @FXML
    private Label labelPrecipitacion;
    @FXML
    private Label labelTemperaturaMaxima;
    @FXML
    private Label labelTemperaturaMinima;
    @FXML
    private ObservableList<Meteorologia> listaMeteorologia;

    @FXML
    public void initialize() {

        // crear borde para el ImageView
        DropShadow borde = new DropShadow();
        borde.setRadius(10.0);
        borde.setOffsetX(0);
        borde.setOffsetY(0);
        borde.setColor(Color.BLACK);

        // crea un ObservableArrayList para los contactos
        listaMeteorologia = FXCollections.observableArrayList();

        // agregamos algunos contactos de muestra
        listaMeteorologia.add(new Meteorologia("01-01-2024", 0.0, 0.0, 0.0));
        listaMeteorologia.add(new Meteorologia("02-01-2024", 0.0, 0.0, 0.0));
        listaMeteorologia.add(new Meteorologia("03-01-2024", 0.0, 0.0, 0.0));
        listaMeteorologia.add(new Meteorologia("04-01-2024", 0.0, 0.0, 0.0));

        // almacenamos los contactos de la lista en la tabla
        tablaMeteorologia.setItems(listaMeteorologia);

        // configuramos las columnas nombre, teléfono y correo
        columnaFecha.setCellValueFactory(cellData -> cellData.getValue().getFecha());
        columnaPrecipitacion.setCellValueFactory(cellData -> cellData.getValue().getPrecipitacion());
        columnaTemperaturaMaxima.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaMaxima());
        columnaTemperaturaMaxima.setCellValueFactory(cellData -> cellData.getValue().getTemperaturaMinima());

        // evento para actualizar la información del contacto seleccionado en la tabla
        // tablaMeteorologia.getSelectionModel().selectedItemProperty().addListener(
        // (observable, oldValue, newValue) -> mostrarDetallesContacto(newValue));

    }

    // mostramos los detalles de un contacto en la parte derecha de la ventana
    public void mostrarDetallesContacto(Contacto contacto) {

        // comrpobamos si tenemos un Contacto
        if (contacto != null) {
            labelNombre.setText("Nombre: " + contacto.getNombre().getValue());
            labelTelefono.setText("Teléfono: " + contacto.getTelefono().getValue());
            labelCorreo.setText("Correo: " + contacto.getCorreo().getValue());
            labelWebPersonal.setText("Web personal: " + contacto.getWebPersonal().getValue());

            // si tenemos imagen de perfil
            if (contacto.getImagenPerfil().getValue() != null && !contacto.getImagenPerfil().getValue().isEmpty()) {
                imagenPerfil.setImage(new Image(getClass().getResourceAsStream(contacto.getRutaImagenPerfil())));
            } else {
                imagenPerfil.setImage(null);
            }
        } else {
            labelNombre.setText("Elige un contacto para visualizar sus datos");
            imagenPerfil.setImage(null);
        }
    }

    @FXML
    private NuevoContactoController crearVentanaContacto() throws Exception {

        // cargamos el archivo FXML del formulario
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/aula/agenda/vista/nuevoContacto.fxml"));
        Parent root = loader.load();

        // enlazamos el controlador del formulario con el controlador principal
        NuevoContactoController controladorSecundario = loader.getController();
        controladorSecundario.setControladorPrincipal(this);

        // crear un nuevo Stage (ventana)
        Stage ventanaFormulario = new Stage();
        ventanaFormulario.setTitle("Añadir nuevo contacto");
        ventanaFormulario.initModality(Modality.WINDOW_MODAL); // modal
        ventanaFormulario.initOwner(tablaContactos.getScene().getWindow()); // asigna la ventana principal como
                                                                            // propietaria

        // establecer la escena y mostrar la ventana
        Scene escena = new Scene(root);

        // establecemos CSS
        escena.getStylesheets()
                .add(getClass().getResource("/com/aula/agenda/estilos/estilos.css").toExternalForm());

        // mostramos ventana
        ventanaFormulario.setScene(escena);
        ventanaFormulario.show();

        // devolvemos el controlador de la ventana
        return controladorSecundario;
    }

    @FXML
    private void mostrarFormulario() throws Exception {
        crearVentanaContacto();
    }

    public void agregarContacto(Contacto c) {
        // la tabla está enlazada con listaContactos, se actualizará automáticamente
        listaContactos.add(c);
    }

    @FXML
    private void editarContacto() throws Exception {

        Contacto contactoSeleccionado = tablaContactos.getSelectionModel().getSelectedItem();

        if (contactoSeleccionado != null) {
            NuevoContactoController controladorSecundario = crearVentanaContacto();
            controladorSecundario.setContactoActual(contactoSeleccionado);

        } else {

            // informa al usuario que debe seleccionar un contacto para editarlo
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "ERROR al editar contacto. Debes seleccionar un contacto de la tabla para poder editarlo.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void eliminarContacto() {

        int indiceSeleccionado = tablaContactos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado >= 0) {
            // Borrar el contacto de la lista de contactos
            tablaContactos.getItems().remove(indiceSeleccionado);

            // mostramos alerta
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Contacto Borrado");
            alerta.setHeaderText(null);
            alerta.setContentText("El contacto ha sido borrado de forma correcta.");
            alerta.showAndWait();

        } else {

            // Informa al usuario que debe seleccionar un contacto para borrarlo
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "ERROR al borrar contacto. Debes seleccionar un contacto de la tabla para poder borrarlo.");
            alerta.showAndWait();

        }
    }

    public void mostrarMensajeEdicion(Contacto c) {

        tablaContactos.getSelectionModel().clearSelection();

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Contacto modificado");
        alerta.setHeaderText(null);
        alerta.setContentText(
                "El contacto " + c.getNombre().getValue() + " ha sido modificado de forma correcta.");
        alerta.showAndWait();
    }

}
