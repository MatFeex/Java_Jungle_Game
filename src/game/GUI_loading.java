/*
Classe d'affichage du nom du jeu 
 */
package game;

import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author mathieu
 */
public class GUI_loading extends JFrame{
    
        public GUI_loading() throws InterruptedException { // Création de la fenetre de chargement
        
        ImageIcon imageLoad = new ImageIcon ("src/images/loadingImage.png");
        JLabel labelLoad = new JLabel();
        labelLoad.setIcon(imageLoad);
        
        // Caractéristiques de la frame
        this.setSize(604,340); // taille
        this.setResizable(false); // taille non modifiable
        this.add(labelLoad);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// stop running quand est fermée
        this.setLocationRelativeTo(null); // centre la frame
        this.setUndecorated(true); // enlève la top barre
        this.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        this.dispose();
        
    }
}
