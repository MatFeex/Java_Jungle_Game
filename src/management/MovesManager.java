/*
Class manageant la totalité des déplacements effectués ainsi que la gestion des combats (prises de pièces)
Certains déplacements et combats dépendent du choix des variantes effectué dans la première interface
*/
package management;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author mathieu & Elea
 */

public final class MovesManager {
    // depuis la classe mère :
    private JPanel selectedPanel;
    private JPanel boardPanel;
    private int XPosition;
    private int Yposition;
    private String[] userEntries;
    private boolean blacksCanPlayBol; // indique au programme à qui est le tour de joué (si true, c'est aux noirs de jouer et si false, c'est aux blancs)

    // ces variables sont manipulées à travers toute la classe et sont modifiées à chaque click sur le plateau de jeu ou  sur un Jpanel d'animal (à chaque appel de la classe)

    private static int[] grid = new int[4]; //contient les valeur en pixels des coordonnées X et Y du Jpanel de telle sorte qu'il s'affiche corectement dans une case
    private final int row;
    private final int column;
    private int[] riverOccupationTab = new int[12]; // 12 cases d'eau donc 12 valeurs binaires indiquant si oui (1) ou non (0) un animal se trouve dans la case d'eau ciblée
    private final boolean isRiverBol;
    private final boolean canRiverBol;
    private final boolean canJumpBol;
    private boolean isTrapBol;
    
    
    public MovesManager(JPanel selectedPanel,JPanel boardPanel,int Xposition,int Yposition,String[] userEntries){ 
        this.selectedPanel = selectedPanel;
        this.boardPanel = boardPanel;
        this.XPosition = Xposition;
        this.Yposition = Yposition;
        this.userEntries = userEntries;
        
        grid = getGridFromPixels(Xposition,Yposition); // cadrillage du plateau de jeu par nombres de pixels et obtention des lignes/colonnes/coordonnées X et Y de l'endroit du click
        row = grid[3];
        column = grid[2];
        
        riverOccupationTab = riverOccupation(); //tableau repertoriant l'occupation de la rivière
        isRiverBol = isRiver(); // l'endroit du click est sur une rivière ?
        canRiverBol = canRiver(); // Le panel sélectionné est il autorisé a aller dans la rivière?
        canJumpBol = canJump(); // Le panel sélectionné peut il sauter par dessus la rivière?
    }
    
    
    private static void setBorderFromPixels(int X, int Y,JPanel boardPanel,Color colorTrap){
        // RECUPERE LE COMPOSANT AUX COORDONEES INDIQUEES ET CHANGE SA BORDER EN ROUGE SI CE COMPOSANT EST UN ANIMAL AFIN D'INDIQUER QUE L'ANIMAL EST DANS UN PIEGE
        JComponent c = (JComponent) boardPanel.getComponentAt(X,Y);
        if (c.getName() != "boardLab"){ // empèche de modifier la border du JLabel du plateau car on souhaite modifier la border des pièces uniquement
            c.setBorder(BorderFactory.createLineBorder(colorTrap,4));
        }
    }
    
    public static void showWhoWon(JPanel boardPanel,String[] userEntries,JPanel selectedPanel){
        // Affiche un message de victoire au joueur concerné si une pièce de couleur adverse se trouve dans la tanière
        int X = grid[0];
        int Y = grid[1];
        boolean blacksInGame = true;
        boolean whitesInGame = true;
                Component[] panelsOnBoard = boardPanel.getComponents(); //récupère tous les composants du plateau de jeu
        for (int i = 0; i < panelsOnBoard.length; i++) { // parcours la liste
           if (panelsOnBoard[i].getName() != "boardLab"){ //récupère le noms et effectue l'action pour tout composant différents du Label(image de fond) du plateau
                panelsOnBoard[i] = (JComponent) panelsOnBoard[i]; // isole un composant
                if (panelsOnBoard[i].getBackground().getRed() == 200 || panelsOnBoard[i].getBackground().getRed() == 255){ //la pièce est de couleur blanche 
                    blacksInGame = false;                }
                else if (panelsOnBoard[i].getBackground().getRed() == 50 || panelsOnBoard[i].getBackground().getRed() == 0){ //la pièce est de couleur blanche 
                    whitesInGame = false;                }
           }
        }
        
        int rsp = selectedPanel.getBackground().getRed();
        ImageIcon wonIcon = new ImageIcon(System.getProperty("user.dir")+"\\src\\images\\victory.png");
        if (X==17 && Y==298 && rsp==200){ //la pièce sur la tanière noire doit etre de couleur blanche 
            JOptionPane.showOptionDialog(null,"Bravo ! "+userEntries[4].toString()+" a gagné !","Message de victoire",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE,wonIcon,null,0);
        }
        else if (X==856 && Y==298 && rsp==50){ //la pièce sur la tanière clanche doit etre de couleur noire  
            JOptionPane.showOptionDialog(null,"Bravo ! "+userEntries[3].toString()+" a gagné !","Message de victoire",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE,wonIcon,null,0);
        }
        //else if (!blacksInGame) JOptionPane.showOptionDialog(null,"Bravo ! "+userEntries[4].toString()+" a gagné !","Message de victoire",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE,wonIcon,null,0);
        //else if (!whitesInGame) JOptionPane.showOptionDialog(null,"Bravo ! "+userEntries[3].toString()+" a gagné !","Message de victoire",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE,wonIcon,null,0);       
        
    }
    
    
    public static void setBorderIfTrapOrRiver(JPanel boardPanel){
        // On eleve la border à tous les composants (car certains animaux peuvent avoir eu une bordure bleue ou rouge si rivière ou piège et peuvent être sorties de ces cases spéciales)
        Component[] panelsOnBoard = boardPanel.getComponents(); //récupère tous les composants du plateau de jeu
        for (int i = 0; i < panelsOnBoard.length; i++) { // parcours la liste
           if (panelsOnBoard[i].getName() != "boardLab"){ //récupère le noms et effectue l'action pour tout composant différents du Label(image de fond) du plateau
            panelsOnBoard[i] = (JComponent) panelsOnBoard[i]; // isole un composant
            ((JComponent) panelsOnBoard[i]).setBorder(null); // enlève la border du composant  
           }
        }

        // modifier border si jpanel dans rivière en bleue ou en rouge si piège
        Color colorRiver = Color.blue;
        Color colorTrap = Color.red;
        for (int i = 0; i < panelsOnBoard.length; i++) { // parcours la liste
           if (panelsOnBoard[i].getName() != "boardLab"){ //récupère le noms et effectue l'action pour tout composant différents du Label du plateau
                panelsOnBoard[i] = (JComponent) panelsOnBoard[i]; //isole un composant
                int X = panelsOnBoard[i].getX();
                int Y = panelsOnBoard[i].getY();
                if (panelsOnBoard[i].getX() >= 331 && panelsOnBoard[i].getX() < 646){ // condition sur les X pour être sur une case rivière
                    if (panelsOnBoard[i].getY() >= 110 && panelsOnBoard[i].getY() < 298 || panelsOnBoard[i].getY() >= 391 && panelsOnBoard[i].getY() < 577){// condition sur les Y pour être sur une case rivière
                        ((JComponent)panelsOnBoard[i]).setBorder(BorderFactory.createLineBorder(colorRiver,4)); // si est sur une case rivière --> border bleue
                    }
                }
                else if (X==17&&Y==204 ||
                         X==856&&Y==204 ||
                         X==121&&Y==298 ||  // toutes les coordonéées des pièges
                         X==751&&Y==298 ||
                         X==17&&Y==391 ||
                         X==856&&Y==391
                        ){
                    ((JComponent)panelsOnBoard[i]).setBorder(BorderFactory.createLineBorder(colorTrap,4)); }
            }
        }
    }

    
    private int[] getInitialGrid(){
        //retourne les coordonnées actuelles du JPanel donc pas de changement de place  
        int currentX = selectedPanel.getX();
        int currentY = selectedPanel.getY();
        grid[0] = currentX;
        grid[1] = currentY;
        return grid;
    }
    
    
    public int[] getLegitPositionBoardClick(){
        // VERIFIE LES DEPLACEMENTS QUE LE JPANEL SELECTIONE PEUT FAIRE LORSQUE CELUI CI SE DEPLACE SUR UNE CASE VIDE
        int currentX = selectedPanel.getX();
        int currentY = selectedPanel.getY();
        if (grid[0] == currentX || grid[1] == currentY){ //evite le deplacement en diagonale
            if (canJump() == true){ // (distance de deplacement > 1 case ) si l'animal peut sauter par dessus la rivière : retourne les coordonés du click 
                return grid;     
            }
            else if ( grid[1] < currentY + 110 && grid[1] > currentY - 110 && grid[0] < currentX + 121 && grid[0] > currentX - 121){ // (distance de deplacement = 1 case )condition permettant de se déplacer que d'une case horizontale ou verticale (dimension d'une case : 121x110)
                    if (isRiverBol == true && canRiverBol == true || isRiverBol == false){ // vérifie si l'animal peut aller ou non dans la rivière avant de retourner les coordonnés du click 
                        return grid;
                    }
                    else return getInitialGrid(); // sinon retourne les coordonnés actuel : pas de déplacement
                }
                else {return getInitialGrid();}
        }
        else {return getInitialGrid();}     
    }
    
    public int[] getLegitPositionPanelClick(JPanel panel){
        // VERIFIE LES DEPLACEMENTS QUE LE JPANEL SELECTIONE PEUT FAIRE LORSQUE CELUI CI SOUHAITE MANGER UN AUTRE ANIMAL
        int currentX = selectedPanel.getX();
        int currentY = selectedPanel.getY();
        boolean canEatBol = canEat(panel);
        if (grid[0] == currentX || grid[1] == currentY){ //evite le deplacement en diagonale
            if (canJump() == true){
                if (canEatBol == true){return grid;}
                else {return getInitialGrid();}    
            }
            else if ( grid[1] < currentY + 110 && grid[1] > currentY - 110 && grid[0] < currentX + 121 && grid[0] > currentX - 121){ //condition permettant de se déplacer que d'une case horizontale ou verticale (dimension d'une case : 121x110)
                if (canEatBol == true){return grid;} // si l'animal du panel sélectionner peut manger l'animal du panel sur lequel on vient de cliquer (proie) : retourne les coordonnées du panel proie
                else {return getInitialGrid();}// sinon retourne les coordonnés actuel : pas de déplacement
            }
            else {return getInitialGrid();}     
        }
        return getInitialGrid();     
    }
    
            
    private int[] riverOccupation(){
        // recherche si un animal se trouve dans la rivère case par case et met à jour le tableau d'occupation (0 : case innocupée et 1 : case occupée)
        if (!"boardLab".equals(boardPanel.getComponentAt(331,110).getName())) {riverOccupationTab[0]=1;} //row==1 && column == 3
        if (!"boardLab".equals(boardPanel.getComponentAt(436,110).getName())) {riverOccupationTab[1]=1;} //row==1 && column == 4
        if (!"boardLab".equals(boardPanel.getComponentAt(541,110).getName())) {riverOccupationTab[2]=1;} //row==1 && column == 5
        if (!"boardLab".equals(boardPanel.getComponentAt(331,204).getName())) {riverOccupationTab[3]=1;} //row==2 && column == 3
        if (!"boardLab".equals(boardPanel.getComponentAt(436,204).getName())) {riverOccupationTab[4]=1;} //row==2 && column == 4
        if (!"boardLab".equals(boardPanel.getComponentAt(541,204).getName())) {riverOccupationTab[5]=1;} //row==2 && column == 5
        if (!"boardLab".equals(boardPanel.getComponentAt(331,391).getName())) {riverOccupationTab[6]=1;} //row==4 && column == 3
        if (!"boardLab".equals(boardPanel.getComponentAt(436,391).getName())) {riverOccupationTab[7]=1;} //row==4 && column == 4
        if (!"boardLab".equals(boardPanel.getComponentAt(541,391).getName())) {riverOccupationTab[8]=1;} //row==4 && column == 5
        if (!"boardLab".equals(boardPanel.getComponentAt(331,484).getName())) {riverOccupationTab[9]=1;} //row==5 && column == 3
        if (!"boardLab".equals(boardPanel.getComponentAt(436,484).getName())) {riverOccupationTab[10]=1;}//row==5 && column == 4
        if (!"boardLab".equals(boardPanel.getComponentAt(541,484).getName())) {riverOccupationTab[11]=1;}//row==5 && column == 5
        return riverOccupationTab;
    }
    
    
        
    public boolean isRiver(){
        // Retourne si oui ou non les coordonnées du click sont sur une rivière
        boolean isRiverBol = false;
        if (row == 1 || row == 2 || row == 4 || row == 5){
            if (column > 2 && column <6){
                isRiverBol = true;
            }
        }
        return isRiverBol;
    }

        
    public boolean canRiver(){
        // Retourne si oui ou non l'animal peut aller dans une rivière
        boolean canRiverBol = false;
        String isAllowedInRiver = selectedPanel.getName();
        if (isAllowedInRiver == "Rat"){canRiverBol = true;}
        else if (userEntries[0] == "Yes"){
            if (isAllowedInRiver  == "Dog"){canRiverBol = true;}
        }
        return canRiverBol;
    }
    
    
    public boolean isTrap(int[] gridPredatorOrPrey){
        // Retourne si oui ou non les coordonnées du click sont sur un piège
        boolean isTrapBol = false;
        int rowRank = 0;
        int columnRank = 0;
        
        columnRank = gridPredatorOrPrey[2];
        rowRank= gridPredatorOrPrey[3];
                
        if (rowRank == 2 && (columnRank == 0 || columnRank == 8)){isTrapBol = true;}
        else if (rowRank == 3 && (columnRank == 1 || columnRank == 7)){isTrapBol = true;}
        else if (rowRank == 4 && (columnRank == 0 || columnRank == 8)){isTrapBol = true;}
        
        return isTrapBol;
    }
    
    private boolean elephantCanEatRat(){ // depend de la variante choisie
        boolean elephantCanEatRatBol;
        if (userEntries[1]=="Yes"){elephantCanEatRatBol = false;} // dans le cas où l'utilisateur aurait choisi la variante "rat immunisé contre elephant"
        else elephantCanEatRatBol = true;
        return elephantCanEatRatBol;
    }

    public int whatRank(String animal,boolean isPredator, JPanel anyPanel){
        // Associe à chaque animal un rang selon les règles du jeu
        int Xposition = anyPanel.getX();
        int Yposition = anyPanel.getY();
        int[] gridPredatorOrPrey = getGridFromPixels(Xposition,Yposition); // renvoie les variables row et column selon la position du JPanel entré en argument
        
        int rank = 1; // initialise le rang en tant que rat
        
        // vérification si l'animal est sur une case piège        
        if (isTrap(gridPredatorOrPrey) == true && !isPredator){rank = 0;} //le rang d'un animal est egal à zero uniquement en tant que proie, il retrouve son rang normal lorsque qu'il sort de la case donc lorsque qu'il devient prédateur
        else if (animal == "Cat"){rank = 2;}
        else if (animal == "Wolf"){rank = 3;}
        else if (animal == "Dog"){rank = 4;}
        else if (animal == "Leopard"){rank = 5;}
        else if (animal == "Lion"){rank = 6;}
        else if (animal == "Tiger"){rank = 7;}
        else if (animal == "Elephant"){rank = 8;}
        return rank;
    }
        
    
    public boolean canEat(JPanel panel){
        // DETERMINE SI OUI OU NON LE PREDATEUR (selectedPanel) PEUT MANGER OU NON LA PROIE (panel) SELON SON RANG ET LES CONDITIONS/REGLES DU JEU 
        boolean canEatBol;
        boolean predatorInRiverBol;
        boolean preyInRiverBol;
        
        try{
            if (((LineBorder)selectedPanel.getBorder()).getLineColor().getBlue()==255){ //border bleue donc predateur dans la rivière
            predatorInRiverBol = true;
            }
            else predatorInRiverBol = false;
        } 
        catch(java.lang.NullPointerException err) {predatorInRiverBol = false;}//retourne cette erreur si le panel n'a pas de bordure et donc ce dernier n'est pas situé dans la rivière
        
        try{
            if (((LineBorder)panel.getBorder()).getLineColor().getBlue()==255){ //border bleue donc proie dans la rivière
            preyInRiverBol = true;
            }
            else preyInRiverBol = false;
        } 
        catch(java.lang.NullPointerException err) {preyInRiverBol = false;}//retourne cette erreur si le panel n'a pas de bordure et donc ce dernier n'est pas situé dans la rivère

        String predator = selectedPanel.getName(); // animal susceptible de manger 
        String prey = panel.getName(); // animal susceptible d'être mangé
        
        int rankPredator = whatRank(predator,true,selectedPanel); // obtention du rang de l'animal du panel sélectionner ( predateur)
        int rankPrey = whatRank(prey,false,panel); // obtention du rang de l'animal du panel sur lequel l'utilisateur vient de cliquer, pièce suceptible d'être mangé (proie)
        
        // CONDITIONS DE PRISE DES PIECES SELON LES REGLES DU JEU DE LA JUNGLE ET DES VARIANTES CHOISIES PAR L'UTILISATEUR
        if (predator == "Rat" && prey == "Elephant" && !predatorInRiverBol){canEatBol = true;} // un rat ne peut dévorer un élephant en étant dans l'eau
        else if (predator == "Elephant" && prey == "Rat" && !elephantCanEatRat() && !preyInRiverBol){canEatBol = false;} // si choix "Yes" pour "rat immunisé contre elephant"
        else if (predator == "Elephant" && prey == "Rat" && elephantCanEatRat() && !preyInRiverBol){canEatBol = true;} // si choix "No" pour "rat immunisé contre elephant"
        else if (predator == "Rat" && prey == "Rat" && predatorInRiverBol && !preyInRiverBol){canEatBol = true;} //un rat peut manger un autre rat sur terre depuis une case rivière
        else if (predator == "Rat" && prey == "Rat" && predatorInRiverBol && preyInRiverBol){canEatBol = true;} //les rats peuvent se manger entre eux dans la rivière
        else if (predator == "Dog" && prey == "Dog" && predatorInRiverBol && preyInRiverBol){canEatBol = true;} // si la variante correspondante permet aux chiens d'aller dans la rivière, les chiens se manger entre eux dans la rivière 
        else if (predator == "Dog" && prey == "Dog" && predatorInRiverBol && !preyInRiverBol){canEatBol = true;} // si la variante correspondante permet aux chiens d'aller dans la rivière, un chien peut manger un autre chien sur terre depuis une case rivière 
        else if (predator == "Dog" && prey == "Rat" && predatorInRiverBol && preyInRiverBol){canEatBol = true;} // si la variante correspondante permet aux chiens d'aller dans la rivière, les chiens peuvent manger les rats dans la rivière
        else if (rankPredator >= rankPrey && !predatorInRiverBol && !preyInRiverBol){canEatBol = true;} // si le rang du prédateur est superieur à celui de la proie et si les deux animaux sont tous les deux sur terre ou tous les deux dans la rivière
        else canEatBol = false;
        return canEatBol;
    }
    
    
    public boolean canJump(){
        // DETERMINE SI L'ANIMAL PEUT SAUTER PAR DESSUS LES RIVIERES (que ce soit horizontalement ou verticalement)
        boolean canJumpBol = false;
        String animal = selectedPanel.getName();
        int currentX = selectedPanel.getX();
        int currentY = selectedPanel.getY();
        
        String directionY;
        if (grid[1] < currentY){directionY = "north";} //determine dans quel sens se déplace l'animal
        else directionY = "south";
        
        // saut de rivière horizontale
        if (animal=="Tiger" || animal == "Lion"){
            if (currentX == 226 && grid[0] == 646 || currentX == 646 && grid[0] == 226 ){ // si column = 2 ou 6 ( de par et d'autre de la rivière)
                if (currentY == 110 && riverOccupationTab[0] == 0 && riverOccupationTab[1]==0 && riverOccupationTab[2]==0){canJumpBol = true;} // row 1 
                else if (currentY == 204 && riverOccupationTab[3] == 0 && riverOccupationTab[4]==0 && riverOccupationTab[5]==0){canJumpBol = true;} // row 2
                else if (currentY == 391 && riverOccupationTab[6] == 0 && riverOccupationTab[7]==0 && riverOccupationTab[8]==0){canJumpBol = true;} // row 4
                else if (currentY == 484 && riverOccupationTab[9] == 0 && riverOccupationTab[10]==0 && riverOccupationTab[11]==0){canJumpBol = true;} // row 5
            }
        }
         // saut de rivière verticale
        if ( animal == "Tiger" || animal == "Lion" || (animal == "Leopard" && userEntries[2] == "Yes")){ // si 'Yes' : les leopards peuvent sauter verticalement les rivières
            if (currentY == 17 && grid[1] == 298 || (currentY == 298 && grid[1] == 17 && directionY == "north")  ){ // si row = 0 ou si row = 3 selon sens de délacement 
                if (currentX == 331 && riverOccupationTab[0] == 0 && riverOccupationTab[3]==0){canJumpBol = true;} //column = 4
                else if (currentX == 436 && riverOccupationTab[1] == 0 && riverOccupationTab[4]==0){canJumpBol = true;} //column = 5
                else if (currentX == 541 && riverOccupationTab[2] == 0 && riverOccupationTab[5]==0){canJumpBol = true;} //column = 6
            }
            else if (currentY == 577 && grid[1] == 298 || (currentY == 298 && grid[1] == 577 && directionY == "south")){  // si row = 6 ou si row = 3 selon sens de délacement
                if (currentX == 331 && riverOccupationTab[6] == 0 && riverOccupationTab[9]==0){canJumpBol = true;} //column = 4
                else if (currentX == 436 && riverOccupationTab[7] == 0 && riverOccupationTab[10]==0){canJumpBol = true;} //column = 4
                else if (currentX == 541 && riverOccupationTab[8] == 0 && riverOccupationTab[11]==0){canJumpBol = true;} //column = 4
            }     
        }
        return canJumpBol;
    }
    
    

    public int[] getGridFromPixels(int Xposition, int Yposition){
        // DIVISE UN TABLEAU DE JEU DE TAILLE 950x660 EN CASE PAR DECOUPAGE PIXELS AFIN DE FACILITER LA GESTION DES DEPLACEMENTS DANS LE RESTE DU PROGRAMME
        int Ygrid = 1;
        int Xgrid = 1;
        int row = 1;
        int column=1;

        if (Xposition < 121){Xgrid = 17; column =0;}
        else if (Xposition < 226){Xgrid = 121; column =1;}
        else if (Xposition < 331){Xgrid = 226; column =2;}
        else if (Xposition < 436){Xgrid = 331; column =3;}
        else if (Xposition < 541){Xgrid = 436; column =4;}
        else if (Xposition < 646){Xgrid = 541; column =5;}
        else if (Xposition < 751){Xgrid = 646; column =6;}
        else if (Xposition < 856){Xgrid = 751; column =7;}
        else if (Xposition >= 856) {Xgrid=856;column =8;}
        
        if (Yposition < 110){Ygrid = 17; row =0;}
        else if (Yposition < 204){Ygrid = 110; row =1;}
        else if (Yposition < 298){Ygrid = 204; row =2;}
        else if (Yposition < 391){Ygrid = 298; row =3;}
        else if (Yposition < 484){Ygrid = 391; row =4;}
        else if (Yposition < 577){Ygrid = 484; row =5;}
        else if (Yposition >= 577) {Ygrid=577; row =6;}

        grid[0] = Xgrid;
        grid[1] = Ygrid;
        grid[2] = column;
        grid[3] = row;
        
        return grid;
    }
    

}
