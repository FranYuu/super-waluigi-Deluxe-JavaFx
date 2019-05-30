package launch;

import appManager.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Première classe de l'application.
 * @author Calvet & Gonçalves.
 */
public class SuperWaluigiDeluxeEdition extends Application {
    
    /**
     * Méthode de démarrage
     * @param primaryStage Stage de démarrage.
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ihm/FXMLDocument.fxml")));
        // Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ihm/LevelsList.fxml")));
        SceneManager.setStage(primaryStage);
        SceneManager.setScene(new Scene(FXMLLoader.load(getClass().getResource("/ihm/FXMLDocument.fxml"))));
        primaryStage = SceneManager.getStage();
        
        // primaryStage.setScene(scene);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(720);
        primaryStage.show();
    }

    /**
     * Méthode de départ de l'application.0
     * @param args Tableau d'argument propre à Java.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
