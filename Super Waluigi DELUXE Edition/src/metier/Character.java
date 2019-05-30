package metier;

import javafx.scene.image.ImageView;

/**
 * Un Character est soit le Player soit un Monster.
 * @author Calvet & Gonçalves
 */
public abstract class Character extends Entity{
    
    /**
     * Constructeur du Character qui appelle le constructeur de l'Entity.
     * @param currentImage Adresse de l'image.
     * @param posX Position en X.
     * @param posY Position en Y.
     * @param width Largeur d'un Character.
     * @param height Hauteur d'un Character.
     */
    public Character(String currentImage, int posX, int posY,int width,int height){
        super(currentImage,posX,posY,width,height);
    }

    /**
     * Méthode abstraite pour l'animation du saut.
     */
    public abstract void jumpAnimation();
    
    /**
     * Méthode abstraite pour l'animation gauche.
     */
    public abstract void leftAnimation();
    
    /**
     * Méthode abstraite pour l'animation droite.
     */
    public abstract void rightAnimation();
    
    /**
     * Méthode abstraite pour l'animation attendre.
     */
    public abstract void idleAnimation();
}
