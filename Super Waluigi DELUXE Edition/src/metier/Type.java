package metier;

/**
 * Enumération de tout les type possible à associer à une Entity.
 * @author Calvet
 */
public enum Type {
    /**
     * Entity peut être détruite.
     */
    blocDestructible,
    
    /**
     * Entity ne peut être détruite.
     */
    blocUndestructible,
    
    /**
     * Entity considérée comme un monstre.
     */
    monstre,
    
    /**
     * Entity considérée comme une pièce.
     */
    piece,
    
    /**
     * Entity considérée comme le joueur.
     */
    player,
    
    /**
     * Entity considérée comme fin de niveau.
     */
    end,
    
    /**
     * Entity considérée comme un champignon.
     */
    mushroom,
    deathZone,
    plant,
};
