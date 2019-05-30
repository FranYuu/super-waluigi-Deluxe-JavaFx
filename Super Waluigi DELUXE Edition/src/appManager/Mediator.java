package appManager;

import animation.Control;
import enumeration.Direction;
import static enumeration.Direction.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import metier.Entity;
import metier.Type;
import serialization.Storage;
import serialization.StorageTxt;

/**
 * La classe mediator sert à autoriser à des entités leur déplacement.
 * @authors Calvet
 */
public class Mediator {
    private ArrayList<Entity> listEntity ;
    private Entity player;
    private Entity ajouter;
    private AnimationTimer timer;
    private Control input;
    private GraphicMover visual;
    private int movingValue=7;
    private boolean forbidMovement,forbidHaut,forbidBas,forbidDroite,forbidGauche,movementAllowed=true,death=false;
    private boolean powerUp=false;
    private int jumpLenth=40,jump;
    private int compteur = 0;
    private int compteurPiece;
    private Storage storage;
    
    /**
     * Le constructeur de médiateur.
     * @param input Le controleur qui gère les saisies clavier.
     * @param visual L'environment graphique où se trouve les images des différent éléments.
     * @param listEntity Collection de toute les entités sauf le player.
     * @param player Le héro.
     */
    public Mediator(Control input,GraphicMover visual, ArrayList<Entity> listEntity,Entity player){
        this.player=player;
        this.input=input;
        this.visual=visual;
        this.listEntity=listEntity;
        this.storage = new StorageTxt();
        this.compteurPiece = storage.initializationCompteurPiece();
        
        
        input.readInputKeys();
        // System.out.println( this.player.getPosX());
        // System.out.println( this.player.getPosY());
        this.timer = new AnimationTimer() {
            @Override
            public void handle(long now) {//permet le déplacement du personnage
                // System.out.println(compteurPiece);
                if(movementAllowed&&!death){
                    compteur++;
                    IsAllowed();
                    if(!input.isUp())
                        jump=0;
                    if (input.isUp()&& !forbidHaut && jump>0){
                        //int uravity=movingValue+(int)Math.sqrt(jump/2);
                        move(0,movingValue);
                        visual.move(0, movingValue, UP, compteur);
                        jump-=1;
                    }
                    if ((!input.isUp()||jump==0)&&!forbidBas){
                        move(0,-movingValue);
                        visual.move(0, -movingValue, DOWN, compteur);
                    }
                    if(forbidBas){
                        visual.move(0, 0, DOWN, compteur);
                    }
                    if (input.isLeft()&& !forbidGauche){
                        move(movingValue,0);
                        visual.move(movingValue,0, LEFT, compteur);
                    }
                    if (input.isRight()&& !forbidDroite){
                        move(-movingValue,0);
                        visual.move(-movingValue,0, RIGHT, compteur);
                   }
                
               }
               if(death){
                        visual.killPlayer();
                        visual.move(0, 0, UP, compteur);
               }
               
            };
        };
        this.timer.start();
    }
    
    /**
     * Elle modifie les attributs de position d'une entite
     * @param xMove Valeur ajouté à l'attribut posX.
     * @param yMove Valeur ajouté à l'attribut posY.
     */
    public void move(int xMove,int yMove/*,Direction direction*/){
        for (Entity e : listEntity ){
            e.setPosX(e.getPosX()+xMove);
            e.setPosY(e.getPosY()+yMove); 
        }
    }
    
    /**
     * Elle teste les collisions dans différentes directions et interdit le déplacement en fonction.
     */
    public void IsAllowed(){
        forbidMovement=false;
        forbidHaut=false;
        forbidBas=false;
        forbidDroite=false;
        forbidGauche=false;
        Entity em=null;
        Direction direction=Direction.NEUTRAL;
        if(ajouter!=null&&!listEntity.contains(ajouter)){
            listEntity.add(ajouter);
            visual.addDecoration(ajouter);
            ajouter=null;
        }
        for (Entity e : listEntity ){
            direction=e.getCollider().isColliding(player.getCollider());//donne la direction de la collision entre le personnage et les autres entités
            
            //em=comportement(e,direction);
            if(comportement(e,direction)!=null)
                em=comportement(e,direction);
            if(direction==direction.RIGHT){
                forbidDroite=true;
             }   
            if(direction==direction.LEFT){
                forbidGauche=true;
             }
            if(direction==direction.UP){
                forbidHaut=true;
                jump=0;
             }
            if(direction==direction.DOWN){
                forbidBas=true;
                jump=jumpLenth;
             }
        }
        if(em!=null){
            if (em==player){
                if(powerUp){
                    powerUp=false;
                    player.powerDown();
                    
                }
                else
                    killPlayer();
                
            }
            else{
              visual.deleteElement(em);
              listEntity.remove(em);
            }
        }
    } 
    
    /**
     * Définit le comportement d'une Entity lorsqu'elle est au contact d'une autre.
     * @param e L'autre Entity avec qui elle est en contact.
     * @param direction Côté où il y a contact.
     * @return null ou une Entity.
     */
    public Entity comportement(Entity e,Direction direction){
        
        if(direction==direction.NEUTRAL){ //si il n'ya pas de collision
            return null;
        }
        else if(e.getType()==Type.piece){
                compteurPiece = compteurPiece + 1;
                visual.setScore(compteurPiece);
                try{
                    storage.saveScore(this.compteurPiece);
                }
                catch(IOException exc){
                    System.out.println("Erreur : " + exc.getMessage());
                }
                return e;
        }
        else if(e.getType()==Type.mushroom){
                if(!powerUp){
                    player.powerUp();
                    powerUp=true;
                }
               return e; 
        }
        else if(e.getType()==Type.deathZone){
            return player;
        }
        else if(e.getType()==Type.end){
               movementAllowed=false;
               try{
                   sleep(3000);
                   SceneManager.setScene(new Scene(FXMLLoader.load(getClass().getResource("/ihm/LevelsList.fxml"))));
               }
               catch(IOException exc){
                   System.out.println("Erreur : " + exc.getMessage());
               }
               catch(InterruptedException exc){
                   System.out.println("Erreur : " + exc.getMessage());
               }
        }
        else if(direction==direction.UP){
            if(e.getType()==Type.blocDestructible){
                return e;
            }
            if(e.getType()==Type.blocUndestructible&&!e.isUsed()){
                    ajouter=e.getItem();
                return null;
            }
        }
        else if(direction==direction.DOWN){
             if(e.getType()==Type.monstre){
                return e;
            }
        }
        else if(direction==direction.RIGHT  || direction==direction.LEFT ){
           if(e.getType()==Type.monstre){
               movementAllowed=false;
               if(direction==direction.RIGHT&&powerUp){
                    move(movingValue*2,0);
                    visual.move(movingValue*2,0, DOWN, compteur);
               }
               if(powerUp&&direction==direction.LEFT ){
                   move(-movingValue*2,0);
                   visual.move(-movingValue*2,0, DOWN, compteur);
               }
               movementAllowed=true;
               return player;
            }
        }
        return null;
    }
    
    /**
     * Interdit le déplacement du joueur lorque celui-ci "meurt".
     */
    public void killPlayer(){
        death=true;
       
    }
        
        
    
}

