/*
CLASSE DE L'INTERFACE DE CREATION DE PARTIE : SAISIES DES PSEUDOS ET VARIANTES
 */
package game;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

/**
 *
 * @author mathieu & Elea
 */
public class GUI_making extends javax.swing.JFrame {

    public GUI_making() {
        
        initComponents(); // création et affichage des composants
        
        // Parametres de fenetre
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(0,102,51)));
        this.setLocationRelativeTo(null); // centre la frame
        
        this.setVisible(true);
        //Rend non visibles les éléments de choix de la variante 
        this.variationTitleLabel.setVisible(false);
        this.radioButtonPanel.setVisible(false);
        this.OKLabel.setVisible(false);
        this.radioButtonPanel.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        OKLabel = new javax.swing.JLabel();
        movePanel = new javax.swing.JPanel();
        pseudosTitleLabel = new javax.swing.JLabel();
        underTitlePanel = new java.awt.Panel();
        pseudoImage1 = new javax.swing.JLabel();
        player1Field = new javax.swing.JTextField();
        player2Field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pseudoImage2 = new javax.swing.JLabel();
        playpanel = new javax.swing.JPanel();
        playLabel = new javax.swing.JLabel();
        variationTitleLabel = new javax.swing.JLabel();
        radioButtonPanel = new javax.swing.JPanel();
        opt1RBut = new javax.swing.JRadioButton();
        opt2RBut = new javax.swing.JRadioButton();
        opt3RBut = new javax.swing.JRadioButton();
        loadPanel = new javax.swing.JPanel();
        loadLabel = new javax.swing.JLabel();
        rulesPanel = new javax.swing.JPanel();
        rulesLabel = new javax.swing.JLabel();
        variationsPanel = new javax.swing.JPanel();
        variationsLabel = new javax.swing.JLabel();
        pseudosPanel = new javax.swing.JPanel();
        pseudosLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1450, 760));
        setName("makingFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        contentPanel.setLayout(null);

        titleLabel.setFont(new java.awt.Font("ROG Fonts", 1, 60)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("JEU DE LA JUNGLE");
        contentPanel.add(titleLabel);
        titleLabel.setBounds(390, 40, 677, 72);

        OKLabel.setFont(new java.awt.Font("ROG Fonts", 0, 18)); // NOI18N
        OKLabel.setForeground(new java.awt.Color(255, 255, 255));
        OKLabel.setText("             OK");
        OKLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OKLabelMousePressed(evt);
            }
        });
        contentPanel.add(OKLabel);
        OKLabel.setBounds(970, 580, 170, 60);

        movePanel.setBackground(new java.awt.Color(0, 102, 51));
        movePanel.setLayout(null);

        pseudosTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        pseudosTitleLabel.setFont(new java.awt.Font("ROG Fonts", 0, 36)); // NOI18N
        pseudosTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        pseudosTitleLabel.setText("PSEUDOS :");
        pseudosTitleLabel.setToolTipText("");
        movePanel.add(pseudosTitleLabel);
        pseudosTitleLabel.setBounds(30, 30, 280, 44);

        underTitlePanel.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout underTitlePanelLayout = new javax.swing.GroupLayout(underTitlePanel);
        underTitlePanel.setLayout(underTitlePanelLayout);
        underTitlePanelLayout.setHorizontalGroup(
            underTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        underTitlePanelLayout.setVerticalGroup(
            underTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        movePanel.add(underTitlePanel);
        underTitlePanel.setBounds(30, 80, 230, 10);

        pseudoImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userIcon.png"))); // NOI18N
        pseudoImage1.setName("2"); // NOI18N
        movePanel.add(pseudoImage1);
        pseudoImage1.setBounds(60, 180, 40, 40);

        player1Field.setBackground(new java.awt.Color(0, 102, 51));
        player1Field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        player1Field.setForeground(new java.awt.Color(204, 204, 204));
        player1Field.setBorder(null);
        movePanel.add(player1Field);
        player1Field.setBounds(110, 170, 280, 50);

        player2Field.setBackground(new java.awt.Color(0, 102, 51));
        player2Field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        player2Field.setForeground(new java.awt.Color(204, 204, 204));
        player2Field.setBorder(null);
        movePanel.add(player2Field);
        player2Field.setBounds(110, 270, 280, 50);

        jSeparator1.setForeground(new java.awt.Color(0, 255, 0));
        movePanel.add(jSeparator1);
        jSeparator1.setBounds(110, 320, 280, 10);

        jSeparator2.setForeground(new java.awt.Color(51, 255, 51));
        movePanel.add(jSeparator2);
        jSeparator2.setBounds(110, 220, 280, 10);

        pseudoImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userIcon.png"))); // NOI18N
        movePanel.add(pseudoImage2);
        pseudoImage2.setBounds(60, 280, 40, 40);

        playpanel.setBackground(new java.awt.Color(0, 204, 102));
        playpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 102), 3));
        playpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playLabel.setFont(new java.awt.Font("ROG Fonts", 0, 18)); // NOI18N
        playLabel.setForeground(new java.awt.Color(255, 255, 255));
        playLabel.setText("          Jouer");
        playLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playLabelMousePressed(evt);
            }
        });
        playpanel.add(playLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 182, 60));

        movePanel.add(playpanel);
        playpanel.setBounds(180, 420, 182, 60);

        variationTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        variationTitleLabel.setFont(new java.awt.Font("ROG Fonts", 0, 36)); // NOI18N
        variationTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        variationTitleLabel.setText("Variante :");
        variationTitleLabel.setToolTipText("");
        movePanel.add(variationTitleLabel);
        variationTitleLabel.setBounds(30, 30, 280, 44);

        radioButtonPanel.setBackground(new java.awt.Color(0, 102, 51));
        radioButtonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opt1RBut.setBackground(new java.awt.Color(0, 102, 51));
        opt1RBut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        opt1RBut.setForeground(new java.awt.Color(204, 204, 204));
        opt1RBut.setText("Les chiens peuvent aller dans l'eau");
        opt1RBut.setName("var1"); // NOI18N
        radioButtonPanel.add(opt1RBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 40));

        opt2RBut.setBackground(new java.awt.Color(0, 102, 51));
        opt2RBut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        opt2RBut.setForeground(new java.awt.Color(204, 204, 204));
        opt2RBut.setText("Les rats sont immunisés contre les éléphants");
        opt2RBut.setName("var2"); // NOI18N
        radioButtonPanel.add(opt2RBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 450, 40));

        opt3RBut.setBackground(new java.awt.Color(0, 102, 51));
        opt3RBut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        opt3RBut.setForeground(new java.awt.Color(204, 204, 204));
        opt3RBut.setText("Les léopards sautent les rivières verticalement");
        opt3RBut.setName("var3"); // NOI18N
        radioButtonPanel.add(opt3RBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 490, 40));

        movePanel.add(radioButtonPanel);
        radioButtonPanel.setBounds(20, 130, 500, 270);

        contentPanel.add(movePanel);
        movePanel.setBounds(120, 160, 540, 530);

        loadPanel.setBackground(new java.awt.Color(0, 204, 102));

        loadLabel.setFont(new java.awt.Font("ROG Fonts", 0, 18)); // NOI18N
        loadLabel.setForeground(new java.awt.Color(255, 255, 255));
        loadLabel.setText("      Charger une partie");
        loadLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loadLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout loadPanelLayout = new javax.swing.GroupLayout(loadPanel);
        loadPanel.setLayout(loadPanelLayout);
        loadPanelLayout.setHorizontalGroup(
            loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loadPanelLayout.setVerticalGroup(
            loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        contentPanel.add(loadPanel);
        loadPanel.setBounds(890, 410, 310, 50);

        rulesPanel.setBackground(new java.awt.Color(0, 154, 88));

        rulesLabel.setFont(new java.awt.Font("ROG Fonts", 0, 14)); // NOI18N
        rulesLabel.setForeground(new java.awt.Color(255, 255, 255));
        rulesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rulesLabel.setText("Regles du jeu");
        rulesLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rulesLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout rulesPanelLayout = new javax.swing.GroupLayout(rulesPanel);
        rulesPanel.setLayout(rulesPanelLayout);
        rulesPanelLayout.setHorizontalGroup(
            rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rulesPanelLayout.setVerticalGroup(
            rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        contentPanel.add(rulesPanel);
        rulesPanel.setBounds(960, 490, 170, 40);

        variationsPanel.setBackground(new java.awt.Color(0, 204, 102));

        variationsLabel.setFont(new java.awt.Font("ROG Fonts", 0, 18)); // NOI18N
        variationsLabel.setForeground(new java.awt.Color(255, 255, 255));
        variationsLabel.setText("     choisir une Variante");
        variationsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                variationsLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout variationsPanelLayout = new javax.swing.GroupLayout(variationsPanel);
        variationsPanel.setLayout(variationsPanelLayout);
        variationsPanelLayout.setHorizontalGroup(
            variationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(variationsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        variationsPanelLayout.setVerticalGroup(
            variationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(variationsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        contentPanel.add(variationsPanel);
        variationsPanel.setBounds(890, 330, 310, 50);

        pseudosPanel.setBackground(new java.awt.Color(0, 204, 102));

        pseudosLabel.setFont(new java.awt.Font("ROG Fonts", 0, 18)); // NOI18N
        pseudosLabel.setForeground(new java.awt.Color(255, 255, 255));
        pseudosLabel.setText("      PSEUDOS");
        pseudosLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pseudosLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pseudosPanelLayout = new javax.swing.GroupLayout(pseudosPanel);
        pseudosPanel.setLayout(pseudosPanelLayout);
        pseudosPanelLayout.setHorizontalGroup(
            pseudosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pseudosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        pseudosPanelLayout.setVerticalGroup(
            pseudosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pseudosPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pseudosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        contentPanel.add(pseudosPanel);
        pseudosPanel.setBounds(240, 400, 170, 60);

        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeImage.png"))); // NOI18N
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeLabelMousePressed(evt);
            }
        });
        contentPanel.add(closeLabel);
        closeLabel.setBounds(1370, 40, 30, 30);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jgl.jpg"))); // NOI18N
        contentPanel.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1450, 760);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void displayComponents(boolean bol1,boolean bol2){
        // Permet d'afficher ou de cacher les composants souhaités lorsque le Panel principal bouge
        
        // setVisible(bol1)
        variationsPanel.setVisible(bol1);
        loadPanel.setVisible(bol1);
        rulesPanel.setVisible(bol1);
        
        pseudosTitleLabel.setVisible(bol1);
        jSeparator1.setVisible(bol1);
        jSeparator2.setVisible(bol1);
        player1Field.setVisible(bol1);
        player2Field.setVisible(bol1);
        pseudoImage1.setVisible(bol1);
        pseudoImage2.setVisible(bol1);
        playLabel.setVisible(bol1);

        // setVisible(bol2)
        pseudosLabel.setVisible(bol2);
        variationTitleLabel.setVisible(bol2);
        radioButtonPanel.setVisible(bol2);
        OKLabel.setVisible(bol2);
    }

    private void variationsLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_variationsLabelMousePressed
        // Anime le JPanel principal et affiche la selection des variantes
        animation.Animation.moveComponentToPosition("right",150, 780, 1, 4, movePanel);
        displayComponents(false,true);
        
    }//GEN-LAST:event_variationsLabelMousePressed

    private void pseudosLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pseudosLabelMouseClicked
        // Anime le JPanel principal et affiche l'entré des pseudos
        animation.Animation.moveComponentToPosition("left",780, 150, 1, 4, movePanel);
        displayComponents(true,false);
    }//GEN-LAST:event_pseudosLabelMouseClicked

    private void closeLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMousePressed
        System.exit(0); //ferme le programme
    }//GEN-LAST:event_closeLabelMousePressed

    private void OKLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKLabelMousePressed
        // Anime le JPanel principal et affiche l'entré des pseudos
        animation.Animation.moveComponentToPosition("left",780, 150, 1, 4, movePanel);
        displayComponents(true,false);
    }//GEN-LAST:event_OKLabelMousePressed

    private void playLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playLabelMousePressed
        // Averti l'utilisateur en cas de non saisie de pseudos et lance la partie avec le boolean recupération false car l'utilisateur souhaite créer une nouvelle partie
        if (player1Field.getText().equals("") || player2Field.getText().equals("")){
            int answer = JOptionPane.showConfirmDialog(null,"Souhaitez-vous continuer sans pseudos?","Avertissement pseudos",JOptionPane.YES_NO_OPTION);
            if (answer==0){ this.dispose();new GUI_game(getEntries(),false); }
        }
        else{ this.dispose();new GUI_game(getEntries(),false); }
        
    }//GEN-LAST:event_playLabelMousePressed

    
    private void rulesLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesLabelMousePressed
        // Renvoie sur la page internet wikipedia qui explique toutes les règles du jeu
        try{
            if(Desktop.isDesktopSupported()) {Desktop.getDesktop().browse(new URI("https://fr.wikipedia.org/wiki/Jeu_du_combat_des_animaux"));}
        }
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_rulesLabelMousePressed

    private void loadLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadLabelMousePressed
        // Averti l'utilisateur en cas de non saisie de pseudos et lance la partie avec le boolean recupération true car l'utilisateur souhaite restaurer une sauvegarde de partie
        if (player1Field.getText().equals("") || player2Field.getText().equals("")){
            int answer = JOptionPane.showConfirmDialog(null,"Souhaitez-vous continuer sans pseudos?","Avertissement pseudos",JOptionPane.YES_NO_OPTION);
            if (answer==0){ 
                this.dispose();
                new GUI_game(getEntries(),true);  
            }
        }
        else{ this.dispose();new GUI_game(getEntries(),true); }
    }//GEN-LAST:event_loadLabelMousePressed


    public String[] getEntries(){
        // Recupère les saisies et complète les champs vide par des valeurs par défault si besoin
        if (opt1RBut.isSelected()){
            userEntries[0] = "Yes";} // 'Yes' impliquera la prise en compte de la variante et 'No' = variante ignorée
        else userEntries[0] = "No";
        if (opt2RBut.isSelected()){
            userEntries[1] = "Yes";}
        else userEntries[1] = "No";
        if (opt3RBut.isSelected()){
            userEntries[2] = "Yes";}
        else userEntries[2] = "No";
        if (!player1Field.getText().equals("")) userEntries[3] = player1Field.getText();
        else userEntries[3] = "Joueur 1";
        if (!player2Field.getText().equals(""))userEntries[4] = player2Field.getText();
        else userEntries[4] = "Joueur 2";
        return userEntries;

    }

    private final String[] userEntries = new String[5]; // stock les 2 pseudos et la reponse de l'utilisateur concernant les 3 variantes
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OKLabel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel loadLabel;
    private javax.swing.JPanel loadPanel;
    private javax.swing.JPanel movePanel;
    private javax.swing.JRadioButton opt1RBut;
    private javax.swing.JRadioButton opt2RBut;
    private javax.swing.JRadioButton opt3RBut;
    private javax.swing.JLabel playLabel;
    private javax.swing.JTextField player1Field;
    private javax.swing.JTextField player2Field;
    private javax.swing.JPanel playpanel;
    private javax.swing.JLabel pseudoImage1;
    private javax.swing.JLabel pseudoImage2;
    private javax.swing.JLabel pseudosLabel;
    private javax.swing.JPanel pseudosPanel;
    private javax.swing.JLabel pseudosTitleLabel;
    private javax.swing.JPanel radioButtonPanel;
    private javax.swing.JLabel rulesLabel;
    private javax.swing.JPanel rulesPanel;
    private javax.swing.JLabel titleLabel;
    private java.awt.Panel underTitlePanel;
    private javax.swing.JLabel variationTitleLabel;
    private javax.swing.JLabel variationsLabel;
    private javax.swing.JPanel variationsPanel;
    // End of variables declaration//GEN-END:variables
}
