/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import javafx.scene.image.ImageView;
import metier.Sprite;

/**
 * AnimationManager gère l'animation visuel des Character.
 * @author Calvet & Gonçalves
 */
public class AnimationManager {
    private Sprite s;
    private int delay;
    private ImageView currentSprite;
    private int currentIndex; 
    
    /**
     * Retourne le Sprites.
     * @return s
     */
    public Sprite getListeSprites(){
        return this.s;
    }
    
    /**
     * Modifie le Sprite.
     * @param s Nouveau Sprite.
     */
    private void setListeSprites(Sprite s){
        this.s = s;
    }
    
    /**
     * Retourne le delay.
     * @return delay
     */
    public int getDelay(){
        return this.delay;
    }
    
    /**
     * Modifie le delay.
     * @param delay Nouveau delay.
     */
    private void setDelay(int delay){
        this.delay = delay;
    }
    
    /**
     * Retourne le Sprite courant.
     * @return currentSprite
     */
    public ImageView getCurrentSprite(){
        return this.currentSprite;
    }
    
    /**
     * Constructeur d'un AnimationManager.
     * @param s Un Sprite.
     * @param delay Le delais entre chaque image.
     */
    public AnimationManager(Sprite s, int delay){
        this.s = s;
        this.delay = delay;
        this.currentIndex = 0;
    }
    
    /**
     * Joue l'animation en passant les images une a une.
     */
    public void play(){
        this.currentIndex++;
        this.currentSprite = new ImageView(s.getListeImages().get(currentIndex));
        this.currentIndex = this.currentIndex % delay;
    }
}
