package metier;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

/**
 * Un Sprite est une image formant l'animation visuel complète d'une Entity.
 * @author Calvet & Gonçalves
 */
public class Sprite {
    private ArrayList<Image> listeImages = new ArrayList<>();
    
    /**
     * Constructeur d'un Sprite.
     * @param listeImages Liste de lien des images.
     */
    public Sprite(List<String> listeImages){
        for (String element : listeImages){
            this.listeImages.add(new Image(element));
        }
    }
    
    /**
     * Modifie la liste d'images.
     * @param listeImages Nouvelle liste d'image.
     */
    private void setImage(ArrayList<Image> listeImages){
        this.listeImages = listeImages;
    }
    
    /**
     * Retourne la liste d'images.
     * @return listeImages
     */
    public ArrayList<Image> getListeImages(){
        return listeImages;
    }
}
