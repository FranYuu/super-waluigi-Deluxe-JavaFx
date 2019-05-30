/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import animation.Control;
import appManager.GraphicMover;
import appManager.Mediator;
import appManager.SceneManager;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metier.Bloc;
import metier.Entity;
import metier.Player;
import metier.Type;

/**
 * Controleur associé à LevelsListController.fxml
 * @author Calvet & Gonçalves
 */
public class LevelsListController extends VBox {
    private Stage stage = new Stage();
    
    /**
     * Charge un niveau.
     * @param event Un évenement.
     * @throws IOException 
     */
    @FXML
    private void level(ActionEvent event) throws IOException{
//        Stage stage = new Stage();
//
//        Group root = new Group();
//        Group playerZone = new Group();
//        Group decorationZone = new Group();
//        
//        Entity blocTest = new Bloc("file:src\\images\\bloc.jpg", 20, 20, 20, 20);
//        blocTest.resizeImage(30, 30);
//        Entity player = new Player("file:src\\images\\spritePlayer\\waluigi-right-2.png", 300, 200, 20, 20);
//        
//        decorationZone.getChildren().add(blocTest.getCurrentImage());
//        playerZone.getChildren().add(player.getCurrentImage());
//        root.getChildren().add(playerZone);
//        root.getChildren().add(decorationZone);
//        
//        Scene scene = new Scene(root);
//        Control playerControl = new Control(scene);
//        playerControl.readInputKeys();
//        
//        stage.setScene(scene);
//        stage.setMinHeight(500);
//        stage.setMinWidth(720);
//        stage.show();
//-----------------------------------------------------------
        Group root = new Group();
        Group playerZone = new Group();
        Group decorationZone = new Group();
        
        Entity blocTest = new Bloc("file:src/images/bloc.jpg", 20, 20,30,30);
        Entity background = new Bloc("file:src/images/background.png", 0, 0,1000,2000);
        Entity player = new Player("file:src/images/spritePlayer/waluigi-right-2.png",100, 200,60,30);
        Entity mur = new Bloc("file:src/images/wall.png", 0, 0,600,100);
        Entity sol = new Bloc("file:src/images/ground.png", 100, 500,100,2000);
        Entity sol2 = new Bloc("file:src/images/ground.png", 2400, 500,100,2000);
        Entity death = new Bloc("file:src/images/bloc.jpg", 0, 600,100,10000,Type.deathZone);
        Entity blocDes = new Bloc("file:src/images/bloc.jpg", 350, 300,50,50,Type.blocUndestructible);
        Entity bloc = new Bloc("file:src/images/bloc.jpg", 300, 300,50,50,Type.blocUndestructible);
        Entity bloc2 = new Bloc("file:src/images/bloc.jpg", 400, 300,50,50,Type.blocUndestructible);
        Entity blocIndes = new Bloc("file:src/images/bloc.jpg", 350, 100,50,50,Type.blocUndestructible,Type.mushroom,"file:src/images/mushroom.png");
        Entity blocIndes2 = new Bloc("file:src/images/bloc.jpg", 2000, 300,50,50,Type.blocUndestructible,Type.mushroom,"file:src/images/mushroom.png");
        Entity pipe = new Bloc("file:src/images/pipe.png", 700, 400,100,150,Type.blocUndestructible);
        Entity coin = new Bloc("file:src/images/coin.png", 150, 450,30,30,Type.piece);
        Entity coin1 = new Bloc("file:src/images/coin.png", 0, -50,30,30,Type.piece);
        Entity coin2 = new Bloc("file:src/images/coin.png", 1100, 450,30,30,Type.piece);
        Entity coin3 = new Bloc("file:src/images/coin.png", 1150, 450,30,30,Type.piece);
        Entity coin4 = new Bloc("file:src/images/coin.png", 1200, 450,30,30,Type.piece);
        Entity fakeMonster = new Bloc("file:src/images/fake.png", 3000, 400,100,100,Type.monstre);
        Entity fin = new Bloc("file:src/images/flag.png", 4300, 100,400,40,Type.end);
        
        decorationZone.getChildren().add(bloc.getCurrentImage());
        decorationZone.getChildren().add(bloc2.getCurrentImage());
        decorationZone.getChildren().add(mur.getCurrentImage());
        //decorationZone.getChildren().add(background.getCurrentImage());
        decorationZone.getChildren().add(sol.getCurrentImage());
        decorationZone.getChildren().add(sol2.getCurrentImage());
        decorationZone.getChildren().add(coin.getCurrentImage());
        decorationZone.getChildren().add(coin1.getCurrentImage());
        decorationZone.getChildren().add(coin2.getCurrentImage());
        decorationZone.getChildren().add(coin3.getCurrentImage());
        decorationZone.getChildren().add(coin4.getCurrentImage());
        decorationZone.getChildren().add(fakeMonster.getCurrentImage());
        decorationZone.getChildren().add(fin.getCurrentImage());
        decorationZone.getChildren().add(blocDes.getCurrentImage());
        decorationZone.getChildren().add(blocIndes2.getCurrentImage());
        decorationZone.getChildren().add(blocIndes.getCurrentImage());
        decorationZone.getChildren().add(pipe.getCurrentImage());
        //decorationZone.getChildren().add(death.getCurrentImage());
        
        playerZone.getChildren().add(player.getCurrentImage());
        root.getChildren().add(background.getCurrentImage());
        root.getChildren().add(decorationZone);        
         root.getChildren().add(playerZone);
        Scene scene = new Scene(root);
        // scene.getStylesheets().add(FXMLDocumentController.class.getResource("file:/src/styles/style.css").toExternalForm());
        Control playerControl = new Control(scene);
        GraphicMover movingZone = new GraphicMover(decorationZone, player, playerZone);
        ArrayList<Entity> environnement=new ArrayList<>();
        //playerControl.readInputKeys();
        
        ///////////////////////////////////////////////////////////////
        environnement.add(bloc);
        environnement.add(pipe);
        environnement.add(bloc2);
        environnement.add(mur);
        environnement.add(sol);
        environnement.add(sol2);
        environnement.add(blocDes);
        environnement.add(coin);
        environnement.add(coin1);
        environnement.add(coin2);
        environnement.add(coin3);
        environnement.add(coin4);
        environnement.add(fakeMonster);
        environnement.add(fin);
        environnement.add(blocIndes);
        environnement.add(blocIndes2);
        environnement.add(death);
        
        
        //Layer environnement = new Layer(listEntite); 
        //Layer Hero = new Layer(player);
        Mediator mediateur = new Mediator (playerControl,movingZone,environnement,player);
        
        ////////////////////////////////////////////////////////////////////
        //-------------------------------------------
        SceneManager.setScene(scene);
        //-------------------------------------------
//        stage.setScene(scene);
//        stage.setMinHeight(500);
//        stage.setMinWidth(720);
//        stage.show();
//-----------------------------------------------------------
    }  
}
