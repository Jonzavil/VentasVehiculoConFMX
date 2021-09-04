/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.compraventavehiculog6.App;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.ErrorException;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    ArrayList<Persona> personas;
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
        personas=Persona.readFile("personas.dat");
    }    

    @FXML
    private void Menuusuario(MouseEvent event) {
        try {
            System.out.println(textcorreo.getText()+textcontrase.getText());
            if((Persona.validarClave(textcorreo.getText(),textcontrase.getText()))&&(Persona.searchByCorreo(personas, textcorreo.getText()) instanceof Vendedor)){
                FXMLLoader fxmloader = App.loadFXMLLoader("Pantallavendedor");
                App.setRoot(fxmloader);
                PantallavendedorController hc= fxmloader.getController();
            }else if(Persona.validarClave(textcorreo.getText(),textcontrase.getText())&&(Persona.searchByCorreo(personas, textcorreo.getText()) instanceof Comprador)){
                FXMLLoader fxmloader = App.loadFXMLLoader("PantallaComprador");
                App.setRoot(fxmloader);
                PantallaCompradorController hcc= fxmloader.getController();
            }else if(Persona.validarClave(textcorreo.getText(),textcontrase.getText())&&(Persona.searchByCorreo(personas, textcorreo.getText()) instanceof Persona)){
                FXMLLoader fxmloader = App.loadFXMLLoader("AmbosPantalla");
                App.setRoot(fxmloader);
                AmbosPantallaController hcc= fxmloader.getController();
            }else{
                throw new ErrorException("Contraseña Erronea");
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
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"Error");
                a.show();
            }
        
    }
    
}
