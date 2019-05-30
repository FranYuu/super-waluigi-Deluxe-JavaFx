package animation;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 * Control gère les la saisie des touches du clavier qui permettent le déplacement.
 * @author Calvet & Gonçalves
 */
public class Control {
    private boolean up, down, left, right;
    private Scene scene;
    private AnimationTimer timer;
    
    /**
     * Constructeur de Control
     * @param scene La scene à controler.
     */
    public Control(Scene scene){
        this.scene = scene;
    }
    
    /**
     * Retourne up.
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * Retourne down.
     * @return down
     */
    public boolean isDown() {
        return down;
    }

    /**
     * Retourne left
     * @return left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * Retourne right
     * @return right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * Retourne la scene.
     * @return scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Modifie la scene.
     * @param scene La nouvelle scene.
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    /**
     * Lit les entrées clavier(haut, bas, gauche, droite) quand elles sont pressées et relachées.
     */
    public void readInputKeys(){
        this.getScene().setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ke){
                switch(ke.getCode()){
                    case Z :
                        up = true;
                        break;
                    case S :
                        down = true;
                        break;
                    case Q :
                        left = true;
                        break;
                    case D :
                        right = true;
                        break;
                    default:
                }
            }
        });
        
        this.getScene().setOnKeyReleased(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                switch(ke.getCode()){
                    case Z :
                        up = false;
                        break;
                    case S :
                        down = false;
                        break;
                    case Q :
                        left = false;
                        break;
                    case D :
                        right = false;
                        break;
                    default:
                }
            }
        });
        
    }
}
