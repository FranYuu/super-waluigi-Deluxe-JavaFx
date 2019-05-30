package serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe qui permet la persistance de données.
 * @author Calvet & Gonçalves
 */
public class StorageTxt extends Storage{
    private BufferedWriter writer;
    private BufferedReader reader;
    private boolean isToRead;
    private final static String FILE_PATH= "src/serialization/score.txt";

    /**
     * Ouvre un fichier soit en lecture soit en écriture en fonction de isToRead.
     * @param nameFile Nom du fichier à ouvrir.
     * @param isToRead Booleen à true pour ouvrir le fichier en lecture, false pour l'ouvrir en écriture.
     * @throws IOException 
     */
    private void openFile(String nameFile, boolean toRead) throws IOException{
        isToRead = toRead;
        if(isToRead){
            reader = new BufferedReader(new FileReader(new File(nameFile)));
        }
        else{
            writer = new BufferedWriter(new FileWriter(new File(nameFile)));
        }
    }
    
    /**
     * Ecriture d'un entier dans un fichier
     * @param score Le score en jeu.
     * @throws IOException 
     */
    private void write(int score) throws IOException{
        String s = "";
        s = String.valueOf(score);
        if(s != null){
            writer.write(s, 0, s.length());
            writer.newLine();
        }
    }
    
    /**
     * Lecture d'un fichier.
     * @return Le contenu du fichier sous forme de chaine de caractère.
     * @throws IOException 
     */
    private String read() throws IOException{
        String s = reader.readLine();
        return s;
    }
    
    /**
     * Ferme le fichier qu'il soit en lecture ou en Ecriture.
     * @throws IOException 
     */
    private void closeFile() throws IOException{
        if(isToRead){
            reader.close();
        }
        else{
            writer.close();
        }
    }
    
    /**
     * Lit le score du fichier score.txt est le retourne sous forme d'entier. Si il y a une Exception, retourne 0.
     * @return score ou 0 si Exception.
     */
    @Override
    public int initializationCompteurPiece (){
        try{
            openFile(FILE_PATH, true);
            int score = Integer.parseInt(read());
            closeFile();
            return score;
        }
        catch(IOException exc){
            System.out.println("Erreur : " + exc.getMessage());
            return 0;
        }
    }

    /**
     * Modifie le score et le sauvegarde dans score.txt.
     * @param score Le nouveau score.
     * @throws IOException 
     */
    @Override
    public void saveScore(int score) throws IOException{
        this.openFile(FILE_PATH, false);
        this.write(score);
        this.closeFile();
    }
}