module es.karames.meteorologia {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens es.karames.meteorologia to javafx.fxml;

    exports es.karames.meteorologia;
}
