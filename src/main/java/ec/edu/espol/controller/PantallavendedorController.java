/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.compraventavehiculog6.App;
import ec.edu.espol.model.Vehiculo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class PantallavendedorController implements Initializable {

    @FXML
    private Button btnregistrovehiculo;
    @FXML
    private Button btnaceptaroferta;
    @FXML
    private Button btnperfil;
    @FXML
    private GridPane camposregistro;
    @FXML
    private Button btnsalirpantallavendedor;
    @FXML
    private GridPane grippaneoferta;
    @FXML
    private VBox vboxofertas;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventoregistrovehiculo(MouseEvent event) {
        Label id = new Label("ID: ");
        TextField campoid= new TextField();
        Label placa = new Label("Placa: ");
        TextField campoplaca= new TextField();
        Label marca = new Label("Marca: ");
        TextField campomarca= new TextField();
        Label modelo = new Label("Modelo: ");
        TextField campomodelo= new TextField();
        Label tipoMotor = new Label("Tipo Motor: ");
        TextField campotipom= new TextField();
        Label year = new Label("Año: ");
        TextField campoyear= new TextField();
        Label recorrido = new Label("Recorrido: ");
        TextField camporecorrido= new TextField();
        Label tipoCombustible = new Label("Combustible: ");
        TextField campotipocombustible= new TextField();
        Label precio = new Label("Precio: ");
        TextField campoprecio= new TextField();
        Label vidrios = new Label("Vidrios: ");
        TextField campovidrio= new TextField();
        Label traccion = new Label("Traccion: ");
        TextField campotraccion= new TextField();
        Label transmicion = new Label("Transmicion: ");
        TextField campotransmicion= new TextField();
        Label color = new Label("Color: ");
        TextField campocolor= new TextField();
        Button btnregistrarvehi= new Button("Registrar");
        Button btnsubirimagen=new Button("Subir imagen: ");
        TextField direccionimage= new TextField();
        Button btnsalir=new Button("Salir");
        camposregistro.setVgap(2);
        camposregistro.setHgap(8);
        camposregistro.add(id, 0, 0);
        camposregistro.add(campoid, 1, 0);
        camposregistro.add(placa, 0, 1);
        camposregistro.add(campoplaca, 1, 1);
        camposregistro.add(marca, 0, 2);
        camposregistro.add(campomarca, 1, 2);
        camposregistro.add(modelo, 0, 3);
        camposregistro.add(campomodelo, 1, 3);
        camposregistro.add(tipoMotor, 0, 4);
        camposregistro.add(campotipom, 1, 4);
        camposregistro.add(year, 0, 5);
        camposregistro.add(campoyear, 1, 5);
        camposregistro.add(recorrido, 0, 6);
        camposregistro.add(camporecorrido, 1, 6);
        camposregistro.add(tipoCombustible, 0, 7);
        camposregistro.add(campotipocombustible, 1, 7);
        camposregistro.add(precio, 0, 8);
        camposregistro.add(campoprecio, 1, 8);
        camposregistro.add(vidrios, 0, 9);
        camposregistro.add(campovidrio, 1, 9);
        camposregistro.add(traccion, 0, 10);
        camposregistro.add(campotraccion, 1, 10);
        camposregistro.add(transmicion, 0, 11);
        camposregistro.add(campotransmicion, 1, 11);
        camposregistro.add(color, 0, 12);
        camposregistro.add(campocolor, 1, 12);
        camposregistro.add(btnsubirimagen,0,13);
        camposregistro.add(direccionimage,1,13);
        camposregistro.add(btnsalir,0,14);
        camposregistro.add(btnregistrarvehi,1,14);
        //"^[0-9]+(.[0-9]+)?$"
        
        btnsubirimagen.setOnMouseClicked((MouseEvent n)->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All imagenes", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png"));
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                direccionimage.setText(file.getPath());
            }
        });
        
        btnregistrarvehi.setOnMouseClicked((MouseEvent x)->{
            ArrayList<Vehiculo> vehiculos = new ArrayList<>();
            if(!campoid.getText().matches("[0-9]+$") || !campoplaca.getText().matches("[a-zA-Z_0-9]+$") || !campomarca.getText().matches("[a-zA-Z]+$") || !campomodelo.getText().matches("[a-zA-Z]+$") || !campotipom.getText().matches("[a-zA-Z]+$") || !campoyear.getText().matches("[0-9]+$") || !camporecorrido.getText().matches("[0-9]+$") || !campotipocombustible.getText().matches("[a-zA-Z]+$") || !campoprecio.getText().matches("[0-9]+$") || (!campovidrio.getText().matches("[a-zA-Z]+$") && campovidrio.getText()==null)|| (!campotraccion.getText().matches("[a-zA-Z]+$")&& campotraccion.getText()==null)|| (!campotransmicion.getText().matches("[a-zA-Z]+$") && campotransmicion.getText()==null) || !campocolor.getText().matches("[a-zA-Z]+$") || direccionimage.getText()==null){
                Alert h = new Alert(AlertType.ERROR,"Volver a registrarse correctamente");
                h.show(); 
            }else{
                if(campovidrio.getText()==null && campotransmicion.getText()==null && campotraccion.getText()==null){
                    Vehiculo v1 = new Vehiculo(Integer.parseInt(campoid.getText()),campoplaca.getText(),campomarca.getText(),campomodelo.getText(),campotipom.getText(),Integer.parseInt(campoyear.getText()),Integer.parseInt(camporecorrido.getText()),campocolor.getText(),campotipocombustible.getText(),Integer.parseInt(campoprecio.getText())); 
                    vehiculos.add(v1);
                    Vehiculo.saveFile("vehiculos.dat", vehiculos);
                    camposregistro.getChildren().clear();
                }
                else{
                    Vehiculo v2 = new Vehiculo(Integer.parseInt(campoid.getText()),campoplaca.getText(),campomarca.getText(),campomodelo.getText(),campotipom.getText(),Integer.parseInt(campoyear.getText()),Integer.parseInt(camporecorrido.getText()),campocolor.getText(),campotipocombustible.getText(),Integer.parseInt(campoprecio.getText()),campovidrio.getText(),campotransmicion.getText(),campotraccion.getText());
                    vehiculos.add(v2);
                    Vehiculo.saveFile("vehiculos.dat", vehiculos);
                    camposregistro.getChildren().clear();
                }
            }
            
        });
        
        btnsalir.setOnMouseClicked((MouseEvent m)->{
            camposregistro.getChildren().clear();
        });


        
        
    }

    @FXML
    private void eventoaceptarofer(MouseEvent event) {
    }

    @FXML
    private void eventoperfil(MouseEvent event) {
    }

    @FXML
    private void salirpantallavendedor(MouseEvent event) {
        try {
            FXMLLoader fxmloader = App.loadFXMLLoader("IngresarUsuario");
            App.setRoot(fxmloader); 
        } catch (IOException ex) {
            Alert a = new Alert(AlertType.ERROR,"Error");
            a.show();
        }
    }
    
}
