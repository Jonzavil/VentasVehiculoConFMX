/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.compraventavehiculog6.App;
import ec.edu.espol.model.ErrorException;
import ec.edu.espol.model.Persona;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class IngresarUsuarioController implements Initializable {

    @FXML
    private TextField textcorreo;
    @FXML
    private PasswordField textcontrase;
    @FXML
    private Button btningresar;
    @FXML
    private Button btnregresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Menuusuario(MouseEvent event) {
        try {
            System.out.println(textcorreo.getText()+textcontrase.getText());
            if(Persona.validarClave(textcorreo.getText(),textcontrase.getText())){
                FXMLLoader fxmloader = App.loadFXMLLoader("Pantallavendedor");
                App.setRoot(fxmloader);
                PantallavendedorController hc= fxmloader.getController();
            }else{
                throw new ErrorException("COntraseña Erronea");
            }
        } catch (IOException ex) {
            Alert a = new Alert(AlertType.ERROR,"Fallo programa");
            a.show();
        } catch (ErrorException ex) {
            Alert a = new Alert(AlertType.ERROR,"Correo o Contraseña Incorrecta");
            a.show();
        }
        
    }

    @FXML
    private void sceneregresoinciosesion(MouseEvent event) {
       try {
            FXMLLoader fxmloader = App.loadFXMLLoader("Login");
            App.setRoot(fxmloader); 
            LoginController hc= fxmloader.getController(); //recupero el controlador
               
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"No se pudo abrir el archivo");
                a.show();
            }
        
    }
    
}
