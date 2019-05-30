package metier;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Element le plus haut des éléments du jeux.
 * @author Calvet & Gonçalves
 */
public abstract class Entity{
    /**
     * Position en X de l'Entity.
     */
    protected int posX;
    
    /**
     * Position en Y de l'Entity.
     */
    protected int posY;
    
    /**
     * Largeur de l'Entity.
     */
    protected int width;
    
    /**
     * Hauteur de l'Entity.
     */
    protected int height;
    
    /**
     * Image de l'Entity affichée en jeu.
     */
    protected ImageView currentImage;
    
    private ColliderBox collider;
    
    /**
     * Type de l'Entity.
     */
    protected Type type;

    /**
     * Constructeur d'une Entity.
     * @param currentImage Adresse de l'image.
     * @param posX Position en X.
     * @param posY Position en Y.
     * @param width Largeur d'un Entity.
     * @param height Hauteur d'un Entity.
     */
    public Entity (String currentImage,int posX,int posY,int width,int height){
        this.posX = posX;
        this.posY = posY;
        this.currentImage = new ImageView(currentImage);
        this.currentImage.setX(posX);
        this.currentImage.setY(posY);
        this.width=width;
        this.height=height;
        collider=new ColliderBox(posX,posY,width,height);
        resizeImage(width,height);
    
    }
   /**
     * Retourne height.
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Augmente la taille du joueur.
     */
    public void powerUp() {
        this.height =(int)(height*1.5);
        collider.SetHeight(height);
    }
    
    /**
     * Diminue la taille du joueur.
     */
    public void powerDown() {
        this.height =(int)(height/1.5);
        collider.SetHeight(height);
    }
    /**
     * Retourne posX.
     * @return posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Modifie posX.
     * @param posX La nouvelle valeur de posX.
     */
    public void setPosX(int posX) {
        this.posX = posX;
        collider.SetPosX(posX);
    }

    /**
     * Retourne posY.
     * @return posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Modifie posY.
     * @param posY La nouvelle valeur de posY.
     */
    public void setPosY(int posY) {
        this.posY = posY;
        collider.SetPosY(posY);
    }
    
    /**
     * Modifie l'image de l'Entity.
     * @param pathImage L'url de l'image à changer.
     */
    public void setCurrentImage(String pathImage) {
        this.getCurrentImage().setImage(new Image(pathImage));
    }
    
    /**
     * Modifie l'image de l'Entity.
     * @param image L'ImageView de l'image à changer.
     */
    public void setCurrentImage(ImageView image) {
        this.currentImage = image;
        this.currentImage.setX(this.posX);
        this.currentImage.setY(this.posY);
        this.resizeImage(this.width, this.height);
    }
    
    /**
     * Retourne currentImage.
     * @return currentImage
     */
    public ImageView getCurrentImage() {
        return currentImage;
    }
    
    /**
     * Change la taille de l'image.
     * @param height La nouvelle valeur de height.
     * @param width La nouvelle valeur de width.
     */
    public void resizeImage(int height, int width) {
        this.currentImage.setFitHeight(height);
        this.currentImage.setFitWidth(width);
        collider.SetHeight(height);
        collider.SetWidth(width);
    }
    
    /**
     * Modifie la position courante de l'image.
     * @param posX La nouvelle valeur de posX.
     * @param posY La nouvelle valeur de posY.
     */
    public void replaceImage(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.currentImage.setX(posX);
        this.currentImage.setY(posY);
        collider.SetPosX(posX);
        collider.SetPosY(posY);
    }
    
    /**
     * Retourne le collider.
     * @return collider
     */
    public ColliderBox getCollider(){
        return collider;    
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
    
    /**
     * Retourne le Type de l'Entity.
     * @return type
     */
    public Type getType(){
        return type;
    }
    
    /**
     * Modifie le type d'une Entity.
     * @param type Le nouveau Type.
     */
    private void setType(Type type){
        this.type=type;       
    }
    
    /**
     *Si c'est une entité autre que le bloc elle retourne rien car elle ne contient pas d'objet
     * @return rien
     */
    public Entity getItem(){
        return null;
    }
    
    /**
     * Retourne un booléen quand l'Entity est utilisé.
     * @return true;
     */
    public boolean isUsed(){
        return true;
    }
}
