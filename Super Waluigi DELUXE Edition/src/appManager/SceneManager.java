package appManager;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Permet la gestion des scenes de l'application.
 * @author Calvet & Gonçalves
 */
public abstract class SceneManager {
    private static Stage primaryStage;
    
    /**
     * Remplace la scène actuel.
     * @param s La nouvelle scene.
     * @throws IllegalStateException 
     */
    public static void setScene(Scene s)throws IllegalStateException{
        if(primaryStage != null)
            primaryStage.setScene(s);
        else
            throw new IllegalStateException("primaryStage is null in SceneManager.java");
    }
    
    /**
     * Initialise le Stage.
     * @param s Le nouveau Stage
     */
    public static void setStage(Stage s){
        primaryStage = s;
    }
    
    /**
     * Retourne le stage actuel.
     * @return primaryStage
     */
    public static Stage getStage(){
        return primaryStage;
    }
}
