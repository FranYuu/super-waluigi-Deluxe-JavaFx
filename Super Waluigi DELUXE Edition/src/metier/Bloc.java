package metier;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.Entity.*;


/**
 * Le Bloc est l'entité qui compose majoritairement notre environnement de jeu.
 * @author Calvet & Gonçalves
 */
public class Bloc extends Entity {
    private Entity item;
    private boolean used;
    
    /**
     * Constructeur du Bloc qui appelle le constructeur de l'Entity.
     * @param pathImage Adresse de l'image.
     * @param posX Position en X.
     * @param posY Position en Y.
     * @param width Largeur d'un bloc.
     * @param height Hauteur d'un bloc.
     * @param type Type de bloc.
     */
    public Bloc(String pathImage, int posX, int posY,int width,int height,Type type){
        super(pathImage,posX,posY,width,height);
        this.type=type;
        used=false;
    }
    
    /**
     * Construit un bloc destructible.
     * @param pathImage Adresse de l'image.
     * @param posX Position en X.
     * @param posY Position en Y.
     * @param width Largeur d'un bloc.
     * @param height Hauteur d'un bloc. 
     */
    public Bloc(String pathImage, int posX, int posY,int width,int height){
        super(pathImage,posX,posY,width,height);
        this.type=Type.blocDestructible;
        used=false;
    }
    
    /**
     * Construit un bloc contenant un objet.
     * @param pathImage Adresse de l'image.
     * @param posX Position en X.
     * @param posY Position en Y.
     * @param width Largeur d'un bloc.
     * @param height Hauteur d'un bloc. 
     * @param type Type du bloc.
     * @param item Objet "sortant" du bloc à son contact par le bas.
     * @param pathItem Adresse de l'image du nouvelle objet.
     */
    public Bloc(String pathImage, int posX, int posY,int width,int height,Type type,Type item,String pathItem){
        super(pathImage,posX,posY,width,height);
        this.type=type;
        used=false;
        if(type==Type.blocUndestructible){
            this.item=new Bloc(pathItem, this.posX, this.posY-this.height,width,height,item);
            //System.out.println(this.item.getPosX());
            //System.out.println(this.item.getPosY());
            used=false;
        }
    }
    
    /**
     *Pemet de retourner l'objet que contient le bloc si il y a en a un et le place juste au dessus du bloc
     * @return le nouvelle objet
     */
    public Entity getItem(){
        if(!used&&item!=null){
            item.setPosX(posX);
            item.setPosY(posY-height);
            used=true;
            return item;
        }
        else{
            item=null;
            return item;
        }
    }
    
    /**
     * Retourne un booléen pour savoir si un objet est utlisé.
     * @return used
     */
     public boolean isUsed(){
        return used;
    }
    
    
    /**
     * Constructeur par défaut qui initialise le positionnement, la largeur et la hauteur à 0.
     * @param pathImage Adresse de l'image.
     */
    public Bloc(String pathImage){
        this(pathImage, 0, 0,0,0);
    }

    /**
     * N'est pas implémenté pour ce projet.
     */
    @Override
    public void jumpAnimation() {
        try{
            throw new UnsupportedOperationException("Not supported yet.");
        }
        catch(UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * N'est pas implémenté pour ce projet.
     */
    @Override
    public void leftAnimation() {
        try{
            throw new UnsupportedOperationException("Not supported yet.");
        }
        catch(UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * N'est pas implémenté pour ce projet.
     */
    @Override
    public void rightAnimation() {
        try{
            throw new UnsupportedOperationException("Not supported yet.");
        }
        catch(UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * N'est pas implémenté pour ce projet.
     */
    @Override
    public void idleAnimation() {
        try{
            throw new UnsupportedOperationException("Not supported yet.");
        }
        catch(UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
}
