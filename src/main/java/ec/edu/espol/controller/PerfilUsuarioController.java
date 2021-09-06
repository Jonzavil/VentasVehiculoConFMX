/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.compraventavehiculog6.App;
import ec.edu.espol.model.Comprador;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class PerfilUsuarioController implements Initializable {

    @FXML
    private TextField campocontraseactual;
    @FXML
    private TextField campocontrasenueva;
    @FXML
    private Button btonguardacontras;
    @FXML
    private RadioButton radiobtnvendedor;
    @FXML
    private RadioButton radiobtncomprador;
    @FXML
    private RadioButton radiobtnambos;
    
    private ArrayList<Persona> personas;
    @FXML
    private Button btnregresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Persona.readFile("personas.dat");
    }    

    @FXML
    private void cambiarlacontraseña(MouseEvent event) {
        for(Persona c: personas){
            if(c.getClave().equals(campocontraseactual.getText())){
                c.setClave(campocontrasenueva.getText());
                if(c instanceof Vendedor){
                    if(radiobtnvendedor.isSelected()){
                        radiobtncomprador.setSelected(false);
                        radiobtnambos.setSelected(false);
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }        
                    }
                    else if(radiobtncomprador.isSelected()){
                        radiobtnvendedor.setSelected(false);
                        radiobtnambos.setSelected(false);
                        Comprador.nextCompradorFx(c.getNombre(),c.getApellidos(),c.getOrganizacion(),c.getCorreoElectronico(),c.getClave());
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }   
                        
                    }
                    else if(radiobtnambos.isSelected()){
                        radiobtncomprador.setSelected(false);
                        radiobtnvendedor.setSelected(false);
                        Persona.nextAmbosFx(c.getNombre(),c.getApellidos(),c.getOrganizacion(),c.getCorreoElectronico(),c.getClave());
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }  
                        
                    }
                }
                else if(c instanceof Comprador){
                    if(radiobtnvendedor.isSelected()){
                        radiobtncomprador.setSelected(false);
                        radiobtnambos.setSelected(false);
                        Vendedor.nextVendedorFx(c.getNombre(),c.getApellidos(),c.getOrganizacion(),c.getCorreoElectronico(),c.getClave());
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }        
                    }
                    else if(radiobtncomprador.isSelected()){
                        radiobtnvendedor.setSelected(false);
                        radiobtnambos.setSelected(false);
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }   
                        
                    }
                    else if(radiobtnambos.isSelected()){
                        radiobtncomprador.setSelected(false);
                        radiobtnvendedor.setSelected(false);
                        Persona.nextAmbosFx(c.getNombre(),c.getApellidos(),c.getOrganizacion(),c.getCorreoElectronico(),c.getClave());
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }  
                        
                    }
                    
                }
                else if(c instanceof Persona){
                    if(radiobtnvendedor.isSelected()){
                        radiobtncomprador.setSelected(false);
                        radiobtnambos.setSelected(false);
                        Vendedor.nextVendedorFx(c.getNombre(),c.getApellidos(),c.getOrganizacion(),c.getCorreoElectronico(),c.getClave());
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }        
                    }
                    else if(radiobtncomprador.isSelected()){
                        radiobtnvendedor.setSelected(false);
                        radiobtnambos.setSelected(false);
                        Comprador.nextCompradorFx(c.getNombre(),c.getApellidos(),c.getOrganizacion(),c.getCorreoElectronico(),c.getClave());
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }   
                        
                    }
                    else if(radiobtnambos.isSelected()){
                        radiobtncomprador.setSelected(false);
                        radiobtnvendedor.setSelected(false);
                        try {                           
                            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
                            App.setRoot(fxmloader);    
                        } catch (IOException ex) {                         
                            Alert v = new Alert(AlertType.ERROR,"Error");
                            v.show();
                        }  
                        
                    }
                    
                    
                }
            
            }
        }
        
        
    }

    @FXML
    private void regresomenu(MouseEvent event) {
//        for(Persona c: personas){
//            if(c.getClave().equals(campocontraseactual.getText())){
//                if(c instanceof Vendedor){
//                    try {                           
//                        FXMLLoader fxmloader = App.loadFXMLLoader("PantallaVendedor");
//                        App.setRoot(fxmloader);    
//                    } catch (IOException ex) {                         
//                        Alert r = new Alert(AlertType.ERROR,"Error");
//                        r.show();
//                    }        
//                }
//                    
//                else if(c instanceof Comprador){
//                    try {                           
//                        FXMLLoader fxmloader = App.loadFXMLLoader("PantallaComprador");
//                        App.setRoot(fxmloader);    
//                    } catch (IOException ex) {                         
//                        Alert t = new Alert(AlertType.ERROR,"Error");
//                        t.show();
//                    }        
//                }
//                else if(c instanceof Persona){
//                    try {                           
//                        FXMLLoader fxmloader = App.loadFXMLLoader("PantallaComprador");
//                        App.setRoot(fxmloader);    
//                    } catch (IOException ex) {                         
//                        Alert t = new Alert(AlertType.ERROR,"Error");
//                        t.show();
//                    }  
//                    
//                }
//            
//            }
//        }
        try {                           
            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
            App.setRoot(fxmloader);    
        } catch (IOException ex) {                         
            Alert r = new Alert(AlertType.ERROR,"Error");
            r.show();
        }   
        

    }
    
}
