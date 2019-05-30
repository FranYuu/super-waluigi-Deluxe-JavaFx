package appManager;

import enumeration.Direction;
import static enumeration.Direction.*;
import javafx.scene.Group;
import javafx.scene.control.Label;
import metier.Entity;
import serialization.Storage;
import serialization.StorageTxt;

/**
 * L'GraphicMover est composé d'un groupe qui composera un niveau.
 * @author Calvet & Gonçalves
 */
public class GraphicMover {
    private Group group;
    private Entity player;
    private Group playerZone;
    private Label score;
    private static final int SPEED_ANIMATION = 6;
    
    /**
     * Constructeur de GraphicMover.
     * @param group Groupe qui constituera l'environnement.
     * @param player Le joueur.
     * @param playerZone Group dans lequel sera placé le joueur.
     */
    public GraphicMover(Group group, Entity player, Group playerZone){
        this.group=group;
        this.player = player;
        this.playerZone = playerZone;
        Storage s = new StorageTxt();
        this.score = new Label(String.valueOf(s.initializationCompteurPiece()));
        playerZone.getChildren().add(score);
    }
    
    /**
     * Déplace l'entité dans la vue.
     * @param xMove Valeur ajoutée de X.
     * @param yMove Valeur ajoutée de Y.
     * @param direction Direction dans laquelle le joueur se déplace.
     * @param compteur Sert de délai entre chaque image des animations.
     */
    public void move(int xMove,int yMove, Direction direction, int compteur){
        group.setTranslateY(group.getTranslateY() + yMove);
        group.setTranslateX(group.getTranslateX() + xMove);
        // System.out.println(direction);
        if(direction == RIGHT){
            if(compteur % SPEED_ANIMATION == 0){ 
                this.player.rightAnimation();
            }
            playerZone.getChildren().set(0, player.getCurrentImage());
        }
        else if(direction == LEFT){
            if(compteur % SPEED_ANIMATION == 0){ 
                this.player.leftAnimation();
            }
            playerZone.getChildren().set(0, player.getCurrentImage());
        }
        else if(direction == UP){
            if(compteur % SPEED_ANIMATION == 0){ 
                this.player.jumpAnimation();
            }
            playerZone.getChildren().set(0, player.getCurrentImage());
        }
        else{
            if(compteur % SPEED_ANIMATION == 0){ 
                this.player.idleAnimation();
            }
            playerZone.getChildren().set(0, player.getCurrentImage());
        }
    }
    
    /**
     * Ajoute l'image de l'Entity dans le groupe qui compose la partie visuel de l'application.
     * @param e L'Entity possédant l'image à ajouter.
     */
    public void addDecoration(Entity e){
        group.getChildren().add(e.getCurrentImage());
        //System.out.println(e.getCurrentImage().getY());
        //System.out.println(e.getCurrentImage().getX());
    }
    
    /**
     * Supprime l'image du groupe qui compose la partie visuel de l'application.
     * @param e L'Entity qui possède l'image à supprimer.
     */
    public void deleteElement(Entity e){
        group.getChildren().remove(e.getCurrentImage());
    }
    
    /**
     * Déplace l'image du joueur vers le bas si il "meurt".
     */
    public void killPlayer(){
         //group.getChildren().remove(player.getCurrentImage());
         playerZone.setTranslateY(playerZone.getTranslateY()+5);
         if(playerZone.getTranslateY()>500)
             this.end();
    }
    public void end(){
        System.exit(0);
    }
    
    /**
     * Retourne le score.
     * @return score
     */
    public int getScore(){
        return Integer.parseInt(this.score.getText());
    }
    
    /**
     * Remplace le score actuel par un nouveau.
     * @param score Le nouveau score.
     */
    public void setScore(int score){
        this.score.setText(Integer.toString(score));
    }
    
}


