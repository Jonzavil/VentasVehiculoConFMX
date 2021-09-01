package ec.edu.espol.compraventavehiculog6;

import ec.edu.espol.model.Vendedor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //despues de crear el Grafo de escena paso el ROOT NODE como parametro a la escena
        //el scene continene al {ROOTNODE(ROOT),()DIMENSIONES}
        scene = new Scene(loadFXML("Login"), 640, 480);
        //Paso la escena al stage
        stage.setScene(scene);
        //Establecemos el titulo de la ventana
        stage.setTitle("Marketplace de Vehiculos");
        //mostrar la ventana principal
        //mostramos el stage
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(FXMLLoader fxmlloader) throws IOException {
        scene.setRoot(fxmlloader.load());
        // .load() saca el root note
    }
    
    public static FXMLLoader loadFXMLLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    

    
    
    public static void main(String[] args) {
        Application.launch();
    }

}