module ec.edu.espol.compraventavehiculog6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphicsEmpty;

    opens ec.edu.espol.compraventavehiculog6 to javafx.fxml;
    opens ec.edu.espol.controller to javafx.fxml;
    opens ec.edu.espol.util to javafx.fxml;
    exports ec.edu.espol.compraventavehiculog6;
    exports ec.edu.espol.controller;
    exports ec.edu.espol.util; 
    requires java.mail;
}
