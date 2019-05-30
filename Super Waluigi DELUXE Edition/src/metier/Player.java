package metier;

import animation.AnimationManager;
import animation.Control;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 * Le Player est un Character que le joueur déplace à l'aide du clavier.
 * @author Calvet & Gonçalves
 */
public class Player extends Character{
    private ArrayList<String> listeGauche = new ArrayList<>();
    private ArrayList<String> listeDroite = new ArrayList<>();
    private ArrayList<String> listeAttend = new ArrayList<>();
    private ArrayList<String> listeSaut = new ArrayList<>();

    private Sprite gauche, droite, attend, saut;
    private AnimationManager animationGauche, animationDroite, animationAttend, animationSaut;
    
    /**
     * Constructeur du Player qui appelle le constructeur du Character.
     * @param currentImage Adresse de l'image.
     * @param posX Position en X.
     * @param posY Position en Y.
     * @param width Largeur d'un Player.
     * @param height Hauteur d'un Player.
     */
    public Player(String currentImage, int posX, int posY,int width,int height){
        super(currentImage,posX,posY,width,height);
        this.type=Type.player;
        
        for(int i = 0 ; i < 5 ; i++){
            this.listeGauche.add("file:src/images/spritePlayer/waluigi-left-" + i + ".png");
            this.listeDroite.add("file:src/images/spritePlayer/waluigi-right-" + i + ".png");
            this.listeAttend.add("file:src/images/spritePlayer/waluigi-idle-" + i + ".png");
//            if(i < 4){
//                this.listeSaut.add("file:C:/Users/alexi/Documents/GitHub/super-waluigi/Super Waluigi DELUXE Edition/src/images/spritePlayer/waluigi-idle-" + i + ".png");
//            }
//            else{
//                this.listeSaut.add("file:C:/Users/alexi/Documents/GitHub/super-waluigi/Super Waluigi DELUXE Edition/src/images/spritePlayer/waluigi-jump-" + i + ".png");
//            }
        }
        for(int i = 0 ; i < 4 ; i++){
            this.listeSaut.add("file:src/images/spritePlayer/waluigi-jump-" + i + ".png");
            if(i == 3)
                this.listeSaut.add("file:src/images/spritePlayer/waluigi-jump-0.png");
        }
        
        this.gauche = new Sprite(this.listeGauche);
        this.droite = new Sprite(this.listeDroite);
        this.attend = new Sprite(this.listeAttend);
        this.saut = new Sprite(this.listeSaut);
        
        this.animationGauche = new AnimationManager(this.gauche, 4);
        this.animationDroite = new AnimationManager(this.droite, 4);
        this.animationAttend = new AnimationManager(this.attend, 4);
        this.animationSaut = new AnimationManager(this.saut, 4);
    }

    /**
     * Joue l'animation pour sauter.
     */
    @Override
    public void jumpAnimation() {
        animationSaut.play();
        this.setCurrentImage(this.animationSaut.getCurrentSprite());
    }

    /**
     * Joue l'animation pour marcher vers la gauche.
     */
    @Override
    public void leftAnimation() {
        animationGauche.play();
        this.setCurrentImage(this.animationGauche.getCurrentSprite());
    }

    /**
     * Joue l'animation pour marcher vers la droite.
     */
    @Override
    public void rightAnimation() {
        animationDroite.play();
        this.setCurrentImage(this.animationDroite.getCurrentSprite());
    }

    /**
     * Joue l'animation quand le joueur ne fait rien.
     */
    @Override
    public void idleAnimation() {
        animationAttend.play();
        this.setCurrentImage(this.animationAttend.getCurrentSprite());
    }
}
