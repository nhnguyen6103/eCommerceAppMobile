module javaproject.desktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;


    opens javaproject.desktop to javafx.fxml;
    exports javaproject.desktop;
}