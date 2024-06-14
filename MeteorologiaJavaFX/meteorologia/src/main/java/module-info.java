module es.karames.meteorologia {

    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;

    opens es.karames.meteorologia.models to javafx.fxml;

    exports es.karames.meteorologia.models;

    opens es.karames.meteorologia.views to javafx.fxml;

    exports es.karames.meteorologia.views;

    opens es.karames.meteorologia.controllers to javafx.fxml;

    exports es.karames.meteorologia.controllers;
}
