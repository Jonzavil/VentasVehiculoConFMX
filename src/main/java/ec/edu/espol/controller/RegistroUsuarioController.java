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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.RadioMenuItem;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class RegistroUsuarioController implements Initializable {

    @FXML
    private TextField txtnombres;
    @FXML
    private TextField txtapellidos;
    @FXML
    private TextField txtorganizacion;
    @FXML
    private TextField txtcorreo;
    @FXML
    private TextField txtclave;
    @FXML
    private Button btnregistrar;
    @FXML
    private Button btnregresar;
    @FXML
    private RadioButton radiobtnvendedor;
    @FXML
    private RadioButton radiobtncomprador;
    @FXML
    private RadioButton radiobtnambos;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // TODO
      

        
 
    }    

    @FXML
    private void RegistrarUsuario(MouseEvent event) {
//        radiobtncomprador.setOnMouseClicked((MouseEvent c)->{
//            radiobtncomprador.setSelected(false);
//            radiobtnambos.setSelected(false);
//            
//        });
//        radiobtncomprador.setOnMouseClicked((MouseEvent c)->{
//            radiobtnvendedor.setSelected(false);
//            radiobtnambos.setSelected(false);
//            
//        });
//        radiobtnambos.setOnMouseClicked((MouseEvent c)->{
//            radiobtncomprador.setSelected(false);
//            radiobtnvendedor.setSelected(false);             
//        });
//        
        
    }

    @FXML
    private void SceneRegresar(MouseEvent event) {
       try {
            FXMLLoader fxmloader = App.loadFXMLLoader("Login");
            App.setRoot(fxmloader); 
            LoginController hc= fxmloader.getController(); //recupero el controlador
               
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"No se pudo abrir el archivo");
                a.show();
            }


 
    }

    @FXML
    private void btn1(ActionEvent event) {
        radiobtncomprador.setSelected(false);
        radiobtnambos.setSelected(false);
        btnregistrar.setOnMouseClicked((MouseEvent v)->{
            try {
            FXMLLoader fxmloader = App.loadFXMLLoader("Pantallavendedor");
            App.setRoot(fxmloader); 
            PantallavendedorController hc= fxmloader.getController(); //recupero el controlador
            String nom=txtnombres.getText();
            String ape=txtapellidos.getText();
            String orgn=txtorganizacion.getText();
            String cor=txtcorreo.getText();
            String contr=txtclave.getText();
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"No se pudo abrir el archivo");
                a.show();
            }
            
        });
        
        
        
        
    }

   @FXML
    private void btn2(ActionEvent event) {
        radiobtnvendedor.setSelected(false);
        radiobtnambos.setSelected(false);
        btnregistrar.setOnMouseClicked((MouseEvent v)->{
            try {
            FXMLLoader fxmloader = App.loadFXMLLoader("Pantallavendedor");
            App.setRoot(fxmloader); 
            PantallavendedorController hc= fxmloader.getController(); //recupero el controlador
            String nom=txtnombres.getText();
            String ape=txtapellidos.getText();
            String orgn=txtorganizacion.getText();
            String cor=txtcorreo.getText();
            String contr=txtclave.getText();
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"No se pudo abrir el archivo");
                a.show();
            }
        });
         
    }

    @FXML
    private void btn3(ActionEvent event) {
        radiobtncomprador.setSelected(false);
        radiobtnvendedor.setSelected(false);
        btnregistrar.setOnMouseClicked((MouseEvent v)->{
            try {
            FXMLLoader fxmloader = App.loadFXMLLoader("Pantallavendedor");
            App.setRoot(fxmloader); 
            PantallavendedorController hc= fxmloader.getController(); //recupero el controlador
            String nom=txtnombres.getText();
            String ape=txtapellidos.getText();
            String orgn=txtorganizacion.getText();
            String cor=txtcorreo.getText();
            String contr=txtclave.getText();
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR,"No se pudo abrir el archivo");
                a.show();
            }
        });
        
        
   }
    
}
