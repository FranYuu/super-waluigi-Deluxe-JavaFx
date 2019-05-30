/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.IOException;

/**
 * Classe abstraite qui sert de point d'entrée à la sérialization textuel.
 * @author Calvet & Goncalves
 */
public abstract class Storage{
    /**
     * Méthode abstraite pour la sauvegarde du score.
     * @param score Entier représentant le score.
     * @throws IOException 
     */
    public abstract void saveScore(int score) throws IOException;
    
    /**
     * Méthode pour initialiser, en début de partie, le score.
     * @return Le score lu dans un fichier texte.
     */
    public abstract int initializationCompteurPiece();
}
