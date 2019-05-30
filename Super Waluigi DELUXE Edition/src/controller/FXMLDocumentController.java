package controller;

import animation.Control;
import appManager.GraphicMover;
import appManager.Mediator;
import appManager.SceneManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import launch.SuperWaluigiDeluxeEdition;
import metier.Bloc;
import metier.Entity;
import metier.Player;
import metier.Type;

/**
 * Controleur associé à FXMLDocument.fxml
 * @author Calvet & Gonçalves
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GridPane mainPage;
    
    @FXML
    private Button newGame;
    
    //private Stage stage = new Stage();
    /**
     * Evènement déclenché lors de l'appui sur le bouton jouer. Affiche la liste de niveaux.
     * @param event Un évenement.
     * @throws IOException 
     */
    @FXML
    private void newGameButton(ActionEvent event) throws IOException {
 
//        Group root = new Group();
//        Group playerZone = new Group();
//        Group decorationZone = new Group();
//        
//        Entity blocTest = new Bloc("file:src/images/bloc.jpg", 20, 20,30,30);
//        Entity blocTest2 = new Bloc("file:src/images/bloc.jpg", 100, 20,30,30);
//        Entity player = new Player("file:src/images/spritePlayer/waluigi-right-2.png",100, 200,60,30);
//        Entity sol = new Bloc("file:src/images/bloc.jpg", 100, 500,100,1000);
//        Entity blocDes = new Bloc("file:src/images/bloc.jpg", 100, 100,100,100,Type.blocDestructible);
//        Entity blocIndes = new Bloc("file:src/images/bloc.jpg", 100, 300,100,100,Type.blocUndestructible,Type.mushroom,"file:src/images/mushroom.png");
//        Entity coin = new Bloc("file:src/images/coin.png", 150, 450,50,50,Type.piece);
//        Entity fakeMonster = new Bloc("file:src/images/bloc.jpg", 300, 400,100,100,Type.monstre);
//        Entity fin = new Bloc("file:src/images/flag.png", 1000, 100,400,40,Type.end);
//        
//        decorationZone.getChildren().add(blocTest.getCurrentImage());
//        decorationZone.getChildren().add(blocDes.getCurrentImage());
//        decorationZone.getChildren().add(blocTest2.getCurrentImage());
//        decorationZone.getChildren().add(sol.getCurrentImage());
//        decorationZone.getChildren().add(coin.getCurrentImage());
//        decorationZone.getChildren().add(fakeMonster.getCurrentImage());
//        decorationZone.getChildren().add(fin.getCurrentImage());
//        decorationZone.getChildren().add(blocIndes.getCurrentImage());
//        playerZone.getChildren().add(player.getCurrentImage());
//        root.getChildren().add(decorationZone);
//        root.getChildren().add(playerZone);
//        
//        Scene scene = new Scene(root);
//        // scene.getStylesheets().add(FXMLDocumentController.class.getResource("file:/src/styles/style.css").toExternalForm());
//        Control playerControl = new Control(scene);
//        GraphicMover movingZone = new GraphicMover(decorationZone, player, playerZone);
//        ArrayList<Entity> environnement=new ArrayList<>();
//        //playerControl.readInputKeys();
//        
//        ///////////////////////////////////////////////////////////////
//        environnement.add(blocTest);
//        environnement.add(blocTest2);
//        environnement.add(sol);
//        environnement.add(blocDes);
//        environnement.add(coin);
//        environnement.add(fakeMonster);
//        environnement.add(fin);
//        environnement.add(blocIndes);
//        //Layer environnement = new Layer(listEntite); 
//        //Layer Hero = new Layer(player);
//        ArrayList<Layer> jeu= new ArrayList<>();
//        Mediator mediateur = new Mediator (playerControl,movingZone,environnement,player);
        
        ////////////////////////////////////////////////////////////////////
        //------------------------------------------------------------
        SceneManager.setScene(new Scene(FXMLLoader.load(getClass().getResource("/ihm/LevelsList.fxml"))));
        //------------------------------------------------------------
//        stage.setScene(scene);
//        stage.setMinHeight(500);
//        stage.setMinWidth(720);
//        stage.show();
    }
    
//    @FXML
//    void handleButtonAction(ActionEvent event) {
//        try {
//            // vBox.getChildren().add(new MonUserControl());
//            vBox.getChildren().clear();
//            vBox.getChildren().add(new MonUserControl());
//            
//        } catch (IOException ex) {
//            System.out.println("ERREUR : " + ex.getMessage());
//            Logger.getLogger(FenetreAccueil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    /**
     * Quitte le jeu.
     * @param event 
     */
    @FXML
    private void exitButton(ActionEvent event){
        SceneManager.getStage().close();
    }

    /**
     * Méthode qui permet d'avoir un accès aux "variables" du fichier FXML. N'est pas utilisé pour ce projet.
     * @param location Chemin de fichier FXML.
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){}
}
