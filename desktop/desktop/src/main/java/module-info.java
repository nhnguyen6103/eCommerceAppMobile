module javaproject.desktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    requires com.jfoenix;


    opens javaproject.desktop.controller to javafx.fxml;
    exports javaproject.desktop;
}