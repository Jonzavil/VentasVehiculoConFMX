/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.compraventavehiculog6.App;
import ec.edu.espol.model.ErrorException;
import ec.edu.espol.model.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ZavalaAvila
 */
public class PantallaCompradorController implements Initializable {
    ObservableList<Vehiculo> list;
    @FXML
    private Button perfil;
    @FXML
    private TextField buscar;
    @FXML
    private ComboBox<String> cmbxOrdenar;
    @FXML
    private TableView<Vehiculo> table;
    @FXML
    private TableColumn<Vehiculo, String> img;
    @FXML
    private TableColumn<Vehiculo, String> tipo;
    @FXML
    private TableColumn<Vehiculo, String> placa;
    @FXML
    private TableColumn<Vehiculo, String> marca;
    @FXML
    private TableColumn<Vehiculo, String> modelo;
    @FXML
    private TableColumn<Vehiculo, String> motor;
    @FXML
    private TableColumn<Vehiculo, Integer> año;
    @FXML
    private TableColumn<Vehiculo, Double> recorrido;
    @FXML
    private TableColumn<Vehiculo, String> combustible;
    @FXML
    private TableColumn<Vehiculo, String> color;
    @FXML
    private TableColumn<Vehiculo, String> vidrios;
    @FXML
    private TableColumn<Vehiculo, String> traccion;
    @FXML
    private TableColumn<Vehiculo, String> transmicion;
    @FXML
    private Button CerrarSesion;
    @FXML
    private TableColumn<Vehiculo,Double> precio;
    @FXML
    private Button Buscarbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void perfil(MouseEvent event) {
    }

    @FXML
    private void cerrar(MouseEvent event) {
        try {
            FXMLLoader fxmloader = App.loadFXMLLoader("Login");
            App.setRoot(fxmloader);
            LoginController hc= fxmloader.getController();
            Alert a=new Alert(AlertType.INFORMATION,"Sesion Cerrada");
            a.show();
        } catch (IOException ex) {
            Alert a=new Alert(AlertType.ERROR,"No se puede cerrar sesion");
            a.show();
        }
    }

    @FXML
    private void buscarV(MouseEvent event) {
        String contenido= buscar.getText();
        ArrayList<Vehiculo> o=Vehiculo.busquedaPorVehiculo(contenido);
        if(o.isEmpty()){
            try {
                throw new ErrorException("archivo vacio");
            } catch (ErrorException ex) {
                Alert a=new Alert(AlertType.ERROR,"Archivo vacio o no existe");
                a.show();
            }
        }else{
            table.getChildrenUnmodifiable().clear();
            for(Vehiculo j:o){
                list = FXCollections.observableArrayList(new Vehiculo(j.getImg(),j.getPlaca(),j.getMarca(),j.getModelo(),j.getTipoMotor(),j.getAño(),j.getRecorrido(),j.getColor(),j.getTipoCombustible(),j.getPrecio(),j.getVidrios(),j.getTransmision(),j.getTraccion()));
            }
            img.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Imagen"));
            tipo.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Tipo"));
            placa.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Placa"));
            marca.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Marca"));
            modelo.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Modelo"));
            motor.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Motor"));
            año.setCellValueFactory(new PropertyValueFactory<Vehiculo,Integer>("Año"));
            recorrido.setCellValueFactory(new PropertyValueFactory<Vehiculo,Double>("Recorrido"));
            combustible.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Combustible"));
            color.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Color"));
            vidrios.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Vidrios"));
            traccion.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Traccion"));
            transmicion.setCellValueFactory(new PropertyValueFactory<Vehiculo,String>("Transmicion"));
            precio.setCellValueFactory(new PropertyValueFactory<Vehiculo,Double>("Precio"));
            table.setItems(list);
        }
    }
    
}
