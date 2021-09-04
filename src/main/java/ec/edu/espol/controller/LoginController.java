/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.compraventavehiculog6.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author ZavalaAvila
 */
public class LoginController implements Initializable {

    @FXML
    private Button btniniciarsesion;
    @FXML
    private Button btnregistrarse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sceneiniciosesion(MouseEvent event) {
        try {
            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
            App.setRoot(fxmloader); 
            IngresarUsuarioController hc= fxmloader.getController(); //recupero el controlador
               
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"No se pudo abrir el archivo");
                a.show();
            }
    }

    @FXML
    private void sceneregistrarse(MouseEvent event) {
        try {
            
            FXMLLoader fxmloader = App.loadFXMLLoader("RegistroUsuario");
            App.setRoot(fxmloader); 
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"Error");
                a.show();
            }
    }
    
}
