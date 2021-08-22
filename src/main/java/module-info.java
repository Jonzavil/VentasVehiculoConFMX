module ec.edu.espol.compraventavehiculog6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.compraventavehiculog6 to javafx.fxml;
    opens ec.edu.espol.controller to javafx.fxml;
    exports ec.edu.espol.compraventavehiculog6;
    exports ec.edu.espol.controller;
    requires java.mail;
}
