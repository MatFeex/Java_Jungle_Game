/*
CLASSE DE GESTION DES FICHIERS - SAUVEGARDE DES DEPLACEMENTS DANS UN FICHIER - RESTAURATION ET CHARGEMENT DE PARTIES
 */
package management;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import static game.GUI_game.blacksCanPlayBol;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author mathieu & Elea
 */
public class FilesManager{
    private LinkedList<PanelsProperties> PanelsProperties; // listes qui stock les propriétes des JPanels à chaque déplacement
    private final JPanel boardPanel;
    private final JPanel yourTurnPanel;
    private boolean recovery; // permet au programme de savoir si la class est appellée pour une nouvelle partie ou pour la restauration d'une sauvegarde
    
    public FilesManager(JPanel boardPanel,JPanel yourTurnPanel,boolean recovery) {
        this.boardPanel = boardPanel;
        this.recovery = recovery;
        this.yourTurnPanel = yourTurnPanel;
        this.PanelsProperties = new LinkedList<>();
        if (recovery) loadGameFromFile(); // si appelé pour restauration de partie : on charge le fichier de sauvegarde et on récupère les données
        else addPanelsProperties(); // sinon, nouvelle partie : on initise le fichier json de sauvegarde des coups avec le coup 1 --> les positions initiales des JPanel
    }    

    public void saveGameToFile(){
        // METHODE APPELLEE LORS LORSQUE LE BOUTON DE SAUVEGARDE DE LA PARTIE EN COURS EST PRESSE
        String path = System.getProperty("user.dir")+"\\data\\dataCurrentGame.json"; // fichier stockant la totalité des informations de deplacement d'une partie, ce dernier est overwritten à chaque lancement de l'application
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm"); // pour que l'utilisateur se repère dans les sauvegardes générées et pour éviter les doublons
        Date date = new Date();
        String fileName = (format.format(date)).replace(":", "h");
        String path2 = System.getProperty("user.dir")+"\\Sauvegardes de parties\\"+fileName+".json"; // chemin d'accès du fichier de sauvegarde qui s'apprête à etre crée sous le nom de "date du jour + heure".json
 
        try{
            File folder = new File(System.getProperty("user.dir")+"\\Sauvegardes de parties"); // definition d'un dossier
            if (!folder.exists() && !folder.isDirectory()) folder.mkdir(); // création du dossier si non existence
            File source = new File(path); //fichier source
            File destination = new File(path2); //fichier destination
            FileReader fReader = new FileReader(source);
            BufferedReader bReader = new BufferedReader(fReader);  
            FileWriter fWriter = new FileWriter(destination);      
            String str = null;
            while((str = bReader.readLine()) != null)// Copie du contenu dans le nouveau fichier         
            {
               fWriter.write(str);
               fWriter.write("\n");
               fWriter.flush();
            }
            fWriter.close();
            }
        catch(IOException e){e.printStackTrace();}
        JOptionPane.showOptionDialog(null,"Votre fichier de sauvegarde a bien été créé dans le répertoire de Sauvegardes de parties","Sauvegarde réussie",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,0);

        }
    
    
    private void saveCurrentGameToDataFile(){
        // SAUVEGARDE AUTOMATIQUE DE LA PARTIE A CHAQUE COUP --> A DIFFERENCIER DE LA METHODE saveGameToFile() qui elle est associé au bouton sauvegarde de partie et est donc pas automatique
        Gson gson = new Gson(); // json manager
        String path = System.getProperty("user.dir")+"\\data\\dataCurrentGame.json"; // fichier stockant la totalité des informations de deplacement d'une partie, ce dernier est overwritten à chaque lancement de l'application
        File folder = new File(System.getProperty("user.dir")+"\\data"); // definition d'un dossier
        if (!folder.exists() && !folder.isDirectory()) folder.mkdir(); // création du dossier si non existence
        try(FileWriter writer = new FileWriter(path)){
            gson.toJson(PanelsProperties, writer); // ecriture dans le fichier des propriétés des tous les JPanels après conversion de PanelsProperties en json
            writer.close(); //fermeture du fichier
        }catch(IOException e){e.printStackTrace();}
    }
    
    public void addPanelsProperties(){
        // APPELLER POUR INITIALISER LE FICHIER DE SAUVEGARDE dataCurrentGame.json EN CAS DE NOUVELLE PARTIE
        PanelsProperties PanelsProperties = new PanelsProperties();
        getPanelsBoard().forEach(panel -> { // pour tous les JPanel de la liste  (donc pour tous les JPanel du plateau de jeu) :
            String name = panel.getAccessibleContext().getAccessibleName(); // on récupère le nom unique du JPanel
            PanelsProperties.PanelProperties panelProperties = new PanelsProperties.PanelProperties(panel.isVisible(), panel.getX(), panel.getY(), name); //on fourni à l'objet panelProperties les propriété requises (visibilité au sein du plateau, position X et Y et nom)
            PanelsProperties.addPanelProperties(panelProperties); // on ajoute ces propriété au HashMap panels contenant l'ensemble des propriétés de tous les JPanels
        });
        this.PanelsProperties.addLast(PanelsProperties); // ajout de l'objet tout juste créé à la fin de la liste LinkedList<PanelsProperties>
        saveCurrentGameToDataFile(); // sauvegarde sur le fichier dataCurrentGame.json
    }
    
    public void back(){
        // méthode de retour en arrière
        if(PanelsProperties.size() > 1){ // empèche le retour en arrière si il reste 1 seul coup (le premier)
            PanelsProperties.removeLast(); // on retire le dernier objet de la liste LinkedList<PanelsProperties>
            updateBoardPanel(PanelsProperties.getLast()); // on met à jour le plateau de jeu avec les propriété des JPanels du coup précédent (dernier élément de la liste)
            
            blacksCanPlayBol = !blacksCanPlayBol; // c'est à l'autre couleur de jouer (elle recommence puisque qu'un retour vient d'être effectuer)

            // Appel à la classe Animation pour animer la main qui pointe du doigt le joueur à qui c'est le tour de joué
            if (blacksCanPlayBol) animation.Animation.moveComponentToPosition("left",1275, 40, 1, 10, yourTurnPanel);
            else animation.Animation.moveComponentToPosition("right",40, 1275, 1, 10, yourTurnPanel);
        }
    }
    
    public void updateBoardPanel(PanelsProperties PanelsProperties){
        // Met à jour le plateau de jeu (position + visibilité du JPanel concerné)
        getPanelsBoard().forEach(panel -> { // pour tous les JPanel de la liste faire :
            PanelsProperties.PanelProperties properties = PanelsProperties.getPanelProperties(panel.getAccessibleContext().getAccessibleName()); //on récupère les propriétés requises pour chaque JPanel de la liste que l'on stock dans un Objet properties de la classe PanelProperties 
            panel.setVisible(properties.isVisible()); //on défini la visibilité du JPanel selon la valeur de la propriété corespondante
            panel.setLocation(properties.getX(), properties.getY()); // de même, on défini sa location
        });
    }
    
    private List<JPanel> getPanelsBoard(){
        //retourne dans une liste l'ensemble des JPanels du plateau de jeu boardPanel
        return Arrays.stream(boardPanel.getComponents()).filter(JPanel.class::isInstance).map(JPanel.class::cast).collect(Collectors.toList());
    }    
    
    
    public void loadGameFromFile(){ 
        // METHODE QUI PERMET LE CHARGEMENT D'UNE PARTIE DEPUIS UNE SAUVEGARDE
        String path = "";
        path = chooseFile(); // on récupère le repertoire d'accès depuis la fenètre de selection de fichier
        Gson gson = new Gson();
        LinkedList<PanelsProperties> PanelsProperties = new LinkedList<>();
        try{
            JsonReader reader = new JsonReader(new FileReader(path)); // json reader-manager
            LinkedList<PanelsProperties> list = gson.fromJson(reader, new TypeToken<LinkedList<PanelsProperties>>(){}.getType()); // lecture du fichier json et conversion des données dans une LinkedList<PanelsProperties>
            if(list != null && !list.isEmpty()) PanelsProperties = list; // vérification de contenu
            reader.close(); // fermeture du fichier
        }catch(IOException | JsonSyntaxException e){}
        this.PanelsProperties = PanelsProperties; // on rend la variable global
        try{
            updateBoardPanel(PanelsProperties.getLast()); // met à jour la position des JPanel du plateau
        }catch(NoSuchElementException e){ // en cas de fichier corrompu (ne contenant pas les données requises), la restauration de partie est ignorée et une nouvelle partie est crée
            addPanelsProperties(); // recupération des JPanel du plateau et ajout de leur propriété dans la liste.
        }
        saveCurrentGameToDataFile(); // sauvegarde sur le fichier dataCurrentGame.json (en effet, une copie du fichier de sauvegarde est crée dans le fichier dataCurrentGame.json et c'est donc ce dernier qui sera utilisé pour la suite)
    }
    
    private String chooseFile(){
        // AFFICHE UNE FENETRE DE SELECTION DE FICHIER AFIN DE CHOISIR L'EMPLACEMENT DU FICHIER DE SAUVEGARDE
        JFileChooser chooserSaveFile = new JFileChooser(".");//"." afin d'ouvrir le filechooser dans le repertoire de travail actuel
        // Configuration du FileChooser
        File file;
        int answer;
        String path = "";
        chooserSaveFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        answer = chooserSaveFile.showOpenDialog(null); // stock la reponse de l'utilisateur

        if (answer == JFileChooser.APPROVE_OPTION){
            file = chooserSaveFile.getSelectedFile(); // recupere le fichier selectionné
            path = file.getPath(); // recupere son chemin d'accès
        }  
        return path;
    }
}
