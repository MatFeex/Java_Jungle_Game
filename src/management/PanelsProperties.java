package management;

import java.util.HashMap;
import java.util.Map;


/*
 * Class permettant de gérer certaines propriétés necessaires à l'enregistrement des déplacements des JPanels lors de la partie
 * afin de pouvoir rétablir d'anciennes sauvegarde de parties ou de revenir en arrière
 */

/**
 *
 * @author mathieu & Elea
 */
public class PanelsProperties {
    
    public static class PanelProperties{
        // obtention-gestion des propriétés requises pour un JPanel
        private boolean visible;
        private int x;
        private int y;
        private String name;

        public PanelProperties(boolean visible, int x, int y, String name) {
            this.visible = visible;
            this.x = x;
            this.y = y;
            this.name = name;
        }
        
        // retroune les paramètres en argument de la classe
        public boolean isVisible() {
            return visible;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getName() {
            return name;
        }
    }
    
    private Map<String, PanelProperties> panels = new HashMap<>(); // HashMap qui contiendra l'integralité des informations requises de chaque JPanel à chaque coup
    

    public Map<String, PanelProperties> getPanels() { // getter
        return panels;
    }
    
    public void addPanelProperties(PanelProperties panelProperties){
        // ajoute aux HashMap 'panels' les propriété du JPanel dont la clé est son nom et la valeur ses propriétés 
        panels.put(panelProperties.getName(), panelProperties);
    }
    
    public PanelProperties getPanelProperties(String namePanel){
        // recupère les propriété du JPanel ciblé à l'aide de la clé HashMap correspondante : son nom
        return panels.get(namePanel);
    }
}
