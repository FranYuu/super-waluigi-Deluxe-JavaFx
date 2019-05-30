package metier;
import enumeration.Direction;
import static enumeration.Direction.*;
/**
 * Le ColliderBox est une zone qui recouvre une entité et qui vérifie les collisions.
 * @author Calvet
 */
public class ColliderBox {
    private int posX;
    private int posY;
    private int width;
    private int height;
    
    /**
     * Constructeur de la ColliderBox.
     * @param posX Position en X de la ColliderBox.
     * @param posY Position en Y de la CollisionBox.
     * @param width Largeur de la CollisionBox.
     * @param height Hauteur de la CollisionBox.
     */
    public ColliderBox(int posX,int posY, int width,int height){
        this.posX=posX;
        this.posY=posY;
        this.width=width;
        this.height=height;    
    }
    
    /**
     * Retourne la position en X.
     * @return posX
     */
    public int GetPosX(){
        return posX;
    }
    
    /**
     * Retourne la position en Y.
     * @return posY
     */
    public int GetPosY(){
        return posY;
    }
    
    /**
     * Retourne la largeur.
     * @return width
     */
    public int GetWidth (){
        return width;
    }
    
    /**
     * Retourne la hauteur.
     * @return height
     */
    public int GetHeight(){
        return height;
    }
    
    /**
     * Modifie la valeur de la position en X.
     * @param posX Nouvelle position de X.
     */
    public void SetPosX(int posX){
        this.posX=posX;
    }
    
    /**
     * Modifie la valeur de la position en Y.
     * @param posY Nouvelle position de Y.
     */
    public void SetPosY(int posY){
        this.posY=posY;
    }
    
    /**
     * Modifie la largeur.
     * @param width Nouvelle largeur.
     */
    public void SetWidth(int width){
        this.width=width;
    }
    
    /**
     * Modifie la hauteur.
     * @param height Nouvelle hauteur.
     */
    public void SetHeight(int height){
        this.height=height;
    }
    
    /**
     * Verifie si la ColliderBox actuel est en contact avec une autre CollideBox.
     * @param c Un autre ColliderBox.
     * @return 
     */
    public Direction isColliding(ColliderBox c){
        /*
        System.out.println("Boite");
        System.out.println(posX);
        System.out.println(posY);
        System.out.println(width);
        System.out.println(height);
        System.out.println("Personnage");
        System.out.println(c.GetPosX());
        System.out.println(c.GetPosY());
        System.out.println(c.GetWidth());
        System.out.println(c.GetHeight());
        */
        if(!((c.GetPosX() >= posX + width)
        || (c.GetPosX() + c.GetWidth() <= posX)
        || ( c.GetPosY()>=  posY+ height)
        || (c.GetPosY() + c.GetHeight() <= posY))){
            if(c.GetPosX()+c.GetWidth() <posX+10 && c.GetPosY()+c.GetHeight()>posY &&c.GetPosY()<posY+height ){
                // System.out.println("collision à droite.");
                return Direction.RIGHT;
            }
            else if (c.GetPosX() >posX + width-10 && c.GetPosY()+c.GetHeight()>posY &&c.GetPosY()<posY+height){
                // System.out.println("collision à gauche");
                return Direction.LEFT;
            }
            else if(c.GetPosX()+c.GetWidth() >posX && c.GetPosX() <posX + width  && c.GetPosY()>posY  ){
                // System.out.println("collision en haut ");
                return Direction.UP;
            }
            else {
                // System.out.println("collision en bas");
                return Direction.DOWN;        
            }
            
        }
        
        
        return Direction.NEUTRAL ;
        /*
        if(c.GetPosX() <posX && c.GetPosY()+c.GetHeight()>posY &&c.GetPosY()<posY+height)
              System.out.println("collision à droite.");
        
        else if (c.GetPosX() >posX + width && c.GetPosY()+c.GetHeight()>posY &&c.GetPosY()<posY+height)
              System.out.println("collision à gauche");
        return 0;
        */
    }
    
    /**
     * Retourne la position en X.
     * @return posX
     */
    public int getPosX() {
        return posX;
    }
    
    /**
     * Retourne la position en Y.
     * @return posY
     */
    public int getPosY() {
        return posY;
    }
}
