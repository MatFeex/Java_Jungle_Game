/*
Classe de création de l'interface principale de jeu
 */
package game;

import management.FilesManager;
import management.MovesManager;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.Image;  
import java.awt.Toolkit;  
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author mathieu & Elea
 */
public class GUI_game : javax.swing.JFrame {

    public GUI_game(String[] userEntries,boolean recovery){ // prend en entrée les saisies de l'utilisateur et le boolean recovery pour indiquer à la classe le mode de partie (nouvelle ou restauration de sauvegarde)
        this.userEntries = userEntries;
        this.recovery = recovery;
        // permet d'avertir l'utilisateur avant de fermer definitivement l'application
        WindowListener exitlistener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int answer = JOptionPane.showConfirmDialog(null,"Assurez-vous d'avoir fait les sauvegardes voulues.\nQuitter ?",
                        "Avertissement sauvegarde",JOptionPane.YES_NO_OPTION);
                if (answer==0){ System.exit(0);}
            }
        };

        initComponents(); //création et affichage de tout les composants de l'IHM
        
        boardPanel.setFocusable(true);
        addWindowListener(exitlistener);//ajout de la commande à la fenetre pour un 'safe close'
        setTitle("Jeu de la jungle - Partie en cours");
        ImageIcon iconFrame = new ImageIcon(getClass().getResource("/images/elephant.png")); 
        setIconImage(iconFrame.getImage()); //logo de la Frame
        setMaximumSize(getMinimumSize());
        setMinimumSize(getMinimumSize());
        setPreferredSize(getPreferredSize());
        getRootPane().setBorder(BorderFactory.createMatteBorder(0,3,3,3,new Color(51,150,51))); // petite border verte autour de la frame
        setLocationRelativeTo(null); // centre la frame dans l'ecran
        setVisible(true);
        
        try {
            displayAnimalsAlive();// initialise l'affichage sous forme de tableau répertoriant les pièces prises ou non sur le plateau de jeu
        } catch (IOException | URISyntaxException err) {err.printStackTrace();}
        
        filesManager = new FilesManager(boardPanel,yourTurnPanel,recovery); //initialise le ficher de sauvegarde des coups (depuis une sauvegarde ou depuis le plateau de jeu selon la valeur de recovery)
        
        blacksCanPlayBol = true; //les noirs commencent 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel =  new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image backgrd = Toolkit.getDefaultToolkit().getImage(  
                    GUI_game.class.getResource("/images/jungle_background.jpg"));  
                g.drawImage(backgrd, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        };
        contentPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        player1Label = new javax.swing.JLabel();
        player2Label = new javax.swing.JLabel();
        boardPanel = new javax.swing.JPanel();
        blackTigerPanel = new javax.swing.JPanel();
        blackTigerLabel = new javax.swing.JLabel();
        blackElephantPanel = new javax.swing.JPanel();
        blackElephantLabel = new javax.swing.JLabel();
        blackCatPanel = new javax.swing.JPanel();
        blackCatLabel = new javax.swing.JLabel();
        blackWolfPanel = new javax.swing.JPanel();
        blackWolfLabel = new javax.swing.JLabel();
        blackLeopardPanel = new javax.swing.JPanel();
        blackLeopardLabel = new javax.swing.JLabel();
        blackDogPanel = new javax.swing.JPanel();
        blackDogLabel = new javax.swing.JLabel();
        blackLionPanel = new javax.swing.JPanel();
        blackLionLabel = new javax.swing.JLabel();
        blackRatPanel = new javax.swing.JPanel();
        blackRatLabel = new javax.swing.JLabel();
        whiteRatPanel = new javax.swing.JPanel();
        whiteRatLabel = new javax.swing.JLabel();
        whiteLionPanel = new javax.swing.JPanel();
        whiteLionLabel = new javax.swing.JLabel();
        whiteDogPanel = new javax.swing.JPanel();
        whiteDogLabel = new javax.swing.JLabel();
        whiteLeopardPanel = new javax.swing.JPanel();
        whiteLeopardLabel = new javax.swing.JLabel();
        whiteWolfPanel = new javax.swing.JPanel();
        whiteWolfLabel = new javax.swing.JLabel();
        whiteCatPanel = new javax.swing.JPanel();
        whiteCatLabel = new javax.swing.JLabel();
        whiteElephantPanel = new javax.swing.JPanel();
        whiteElephantLabel = new javax.swing.JLabel();
        whiteTigerPanel = new javax.swing.JPanel();
        whiteTigerLabel = new javax.swing.JLabel();
        boardLabel = new javax.swing.JLabel();
        yourTurnPanel = new javax.swing.JPanel();
        yourTurnLabel = new javax.swing.JLabel();
        restartLabel = new javax.swing.JLabel();
        whitePartsLabel = new javax.swing.JLabel();
        blackPartsPanel = new javax.swing.JPanel();
        bLab8 = new javax.swing.JLabel();
        bLab7 = new javax.swing.JLabel();
        bLab6 = new javax.swing.JLabel();
        bLab5 = new javax.swing.JLabel();
        bLab4 = new javax.swing.JLabel();
        bLab3 = new javax.swing.JLabel();
        bLab2 = new javax.swing.JLabel();
        bLab1 = new javax.swing.JLabel();
        whitePartsPanel = new javax.swing.JPanel();
        wLab8 = new javax.swing.JLabel();
        wLab7 = new javax.swing.JLabel();
        wLab6 = new javax.swing.JLabel();
        wLab5 = new javax.swing.JLabel();
        wLab4 = new javax.swing.JLabel();
        wLab3 = new javax.swing.JLabel();
        wLab2 = new javax.swing.JLabel();
        wLab1 = new javax.swing.JLabel();
        blackPartsLabel = new javax.swing.JLabel();
        rulesLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        savePanel = new javax.swing.JPanel();
        saveLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 850));
        setName("gameFrame"); // NOI18N

        backgroundPanel.setLayout(new java.awt.GridBagLayout());

        contentPanel.setMinimumSize(new java.awt.Dimension(1500, 850));
        contentPanel.setOpaque(false);
        contentPanel.setPreferredSize(new java.awt.Dimension(1500, 850));
        contentPanel.setLayout(null);

        titleLabel.setFont(new java.awt.Font("ROG Fonts", 1, 60)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("jeu de la jungle");
        contentPanel.add(titleLabel);
        titleLabel.setBounds(410, 0, 700, 70);

        player1Label.setFont(new java.awt.Font("ROG Fonts", 0, 24)); // NOI18N
        player1Label.setForeground(new java.awt.Color(255, 255, 255));
        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Label.setText(""+userEntries[3]);
        player1Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentPanel.add(player1Label);
        player1Label.setBounds(0, 130, 260, 70);

        player2Label.setFont(new java.awt.Font("ROG Fonts", 0, 24)); // NOI18N
        player2Label.setForeground(new java.awt.Color(255, 255, 255));
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText(""+userEntries[4]);
        player2Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentPanel.add(player2Label);
        player2Label.setBounds(1230, 130, 260, 70);

        boardPanel.setBackground(new java.awt.Color(0, 153, 153));
        boardPanel.setMaximumSize(new java.awt.Dimension(950, 660));
        boardPanel.setMinimumSize(new java.awt.Dimension(950, 660));
        boardPanel.setPreferredSize(new java.awt.Dimension(970, 680));
        boardPanel.setLayout(null);

        blackTigerPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackTigerPanel.setName("Tiger"); // NOI18N
        blackTigerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackTigerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tiger.png"))); // NOI18N
        blackTigerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackTigerLabelMousePressed(evt);
            }
        });
        blackTigerPanel.add(blackTigerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 87));

        boardPanel.add(blackTigerPanel);
        blackTigerPanel.setBounds(17, 17, 98, 87);
        blackTigerPanel.getAccessibleContext().setAccessibleName("blackTiger");
        blackTigerPanel.getAccessibleContext().setAccessibleDescription("");

        blackElephantPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackElephantPanel.setName("Elephant"); // NOI18N
        blackElephantPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackElephantLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/elephant.png"))); // NOI18N
        blackElephantLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackElephantLabelMousePressed(evt);
            }
        });
        blackElephantPanel.add(blackElephantLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 98, 87));

        boardPanel.add(blackElephantPanel);
        blackElephantPanel.setBounds(226, 17, 98, 87);
        blackElephantPanel.getAccessibleContext().setAccessibleName("blackElephant");
        blackElephantPanel.getAccessibleContext().setAccessibleDescription("");

        blackCatPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackCatPanel.setName("Cat"); // NOI18N
        blackCatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackCatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cat.png"))); // NOI18N
        blackCatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackCatLabelMousePressed(evt);
            }
        });
        blackCatPanel.add(blackCatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 80));

        boardPanel.add(blackCatPanel);
        blackCatPanel.setBounds(121, 110, 98, 87);
        blackCatPanel.getAccessibleContext().setAccessibleName("blackCat");
        blackCatPanel.getAccessibleContext().setAccessibleDescription("");

        blackWolfPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackWolfPanel.setName("Wolf"); // NOI18N
        blackWolfPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackWolfLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wolf.png"))); // NOI18N
        blackWolfLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackWolfLabelMousePressed(evt);
            }
        });
        blackWolfPanel.add(blackWolfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 98, 87));

        boardPanel.add(blackWolfPanel);
        blackWolfPanel.setBounds(226, 204, 98, 87);
        blackWolfPanel.getAccessibleContext().setAccessibleName("blackWolf");
        blackWolfPanel.getAccessibleContext().setAccessibleDescription("");

        blackLeopardPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackLeopardPanel.setName("Leopard"); // NOI18N
        blackLeopardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackLeopardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leopard.png"))); // NOI18N
        blackLeopardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackLeopardLabelMousePressed(evt);
            }
        });
        blackLeopardPanel.add(blackLeopardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 90));

        boardPanel.add(blackLeopardPanel);
        blackLeopardPanel.setBounds(226, 391, 98, 87);
        blackLeopardPanel.getAccessibleContext().setAccessibleName("blackLeopard");
        blackLeopardPanel.getAccessibleContext().setAccessibleDescription("");

        blackDogPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackDogPanel.setName("Dog"); // NOI18N
        blackDogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackDogLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dog.png"))); // NOI18N
        blackDogLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackDogLabelMousePressed(evt);
            }
        });
        blackDogPanel.add(blackDogLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 90));

        boardPanel.add(blackDogPanel);
        blackDogPanel.setBounds(121, 484, 98, 87);
        blackDogPanel.getAccessibleContext().setAccessibleName("blackDog");
        blackDogPanel.getAccessibleContext().setAccessibleDescription("");

        blackLionPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackLionPanel.setName("Lion"); // NOI18N
        blackLionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackLionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lion.png"))); // NOI18N
        blackLionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackLionLabelMousePressed(evt);
            }
        });
        blackLionPanel.add(blackLionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 90));

        boardPanel.add(blackLionPanel);
        blackLionPanel.setBounds(17, 577, 98, 87);
        blackLionPanel.getAccessibleContext().setAccessibleName("blackLion");
        blackLionPanel.getAccessibleContext().setAccessibleDescription("");

        blackRatPanel.setBackground(new java.awt.Color(0, 0, 0));
        blackRatPanel.setName("Rat"); // NOI18N
        blackRatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blackRatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rat.png"))); // NOI18N
        blackRatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blackRatLabelMousePressed(evt);
            }
        });
        blackRatPanel.add(blackRatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, -1));

        boardPanel.add(blackRatPanel);
        blackRatPanel.setBounds(226, 577, 98, 87);
        blackRatPanel.getAccessibleContext().setAccessibleName("blackRat");
        blackRatPanel.getAccessibleContext().setAccessibleDescription("");

        whiteRatPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteRatPanel.setName("Rat"); // NOI18N
        whiteRatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteRatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rat.png"))); // NOI18N
        whiteRatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteRatLabelMousePressed(evt);
            }
        });
        whiteRatPanel.add(whiteRatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, -1));

        boardPanel.add(whiteRatPanel);
        whiteRatPanel.setBounds(646, 17, 98, 87);
        whiteRatPanel.getAccessibleContext().setAccessibleName("whiteRat");
        whiteRatPanel.getAccessibleContext().setAccessibleDescription("");

        whiteLionPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteLionPanel.setName("Lion"); // NOI18N
        whiteLionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteLionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lion.png"))); // NOI18N
        whiteLionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteLionLabelMousePressed(evt);
            }
        });
        whiteLionPanel.add(whiteLionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 90));

        boardPanel.add(whiteLionPanel);
        whiteLionPanel.setBounds(856, 17, 98, 87);
        whiteLionPanel.getAccessibleContext().setAccessibleName("whiteLion");
        whiteLionPanel.getAccessibleContext().setAccessibleDescription("");

        whiteDogPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteDogPanel.setName("Dog"); // NOI18N
        whiteDogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteDogLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dog.png"))); // NOI18N
        whiteDogLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteDogLabelMousePressed(evt);
            }
        });
        whiteDogPanel.add(whiteDogLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 90));

        boardPanel.add(whiteDogPanel);
        whiteDogPanel.setBounds(751, 110, 98, 87);
        whiteDogPanel.getAccessibleContext().setAccessibleName("whiteDog");
        whiteDogPanel.getAccessibleContext().setAccessibleDescription("");

        whiteLeopardPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteLeopardPanel.setName("Leopard"); // NOI18N
        whiteLeopardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteLeopardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leopard.png"))); // NOI18N
        whiteLeopardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteLeopardLabelMousePressed(evt);
            }
        });
        whiteLeopardPanel.add(whiteLeopardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 98, 87));

        boardPanel.add(whiteLeopardPanel);
        whiteLeopardPanel.setBounds(646, 204, 98, 87);
        whiteLeopardPanel.getAccessibleContext().setAccessibleName("whiteLeopard");
        whiteLeopardPanel.getAccessibleContext().setAccessibleDescription("");

        whiteWolfPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteWolfPanel.setName("Wolf"); // NOI18N
        whiteWolfPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteWolfLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wolf.png"))); // NOI18N
        whiteWolfLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteWolfLabelMousePressed(evt);
            }
        });
        whiteWolfPanel.add(whiteWolfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 98, 87));

        boardPanel.add(whiteWolfPanel);
        whiteWolfPanel.setBounds(646, 391, 98, 87);
        whiteWolfPanel.getAccessibleContext().setAccessibleName("whiteWolf");
        whiteWolfPanel.getAccessibleContext().setAccessibleDescription("");

        whiteCatPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteCatPanel.setName("Cat"); // NOI18N
        whiteCatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteCatLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cat.png"))); // NOI18N
        whiteCatLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteCatLabelMousePressed(evt);
            }
        });
        whiteCatPanel.add(whiteCatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 87));

        boardPanel.add(whiteCatPanel);
        whiteCatPanel.setBounds(751, 484, 98, 87);
        whiteCatPanel.getAccessibleContext().setAccessibleName("whiteCat");
        whiteCatPanel.getAccessibleContext().setAccessibleDescription("");

        whiteElephantPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteElephantPanel.setName("Elephant"); // NOI18N
        whiteElephantPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteElephantLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/elephant.png"))); // NOI18N
        whiteElephantLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteElephantLabelMousePressed(evt);
            }
        });
        whiteElephantPanel.add(whiteElephantLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 87));

        boardPanel.add(whiteElephantPanel);
        whiteElephantPanel.setBounds(646, 577, 98, 87);
        whiteElephantPanel.getAccessibleContext().setAccessibleName("whiteElephant");
        whiteElephantPanel.getAccessibleContext().setAccessibleDescription("");

        whiteTigerPanel.setBackground(new java.awt.Color(255, 255, 255));
        whiteTigerPanel.setName("Tiger"); // NOI18N
        whiteTigerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteTigerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tiger.png"))); // NOI18N
        whiteTigerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteTigerLabelMousePressed(evt);
            }
        });
        whiteTigerPanel.add(whiteTigerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 90));

        boardPanel.add(whiteTigerPanel);
        whiteTigerPanel.setBounds(856, 577, 98, 87);
        whiteTigerPanel.getAccessibleContext().setAccessibleName("whiteTiger");
        whiteTigerPanel.getAccessibleContext().setAccessibleDescription("");

        boardLabel.setBackground(new java.awt.Color(255, 255, 255));
        boardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/board_game.png"))); // NOI18N
        boardLabel.setFocusable(false);
        boardLabel.setName("boardLab"); // NOI18N
        boardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardLabelMousePressed(evt);
            }
        });
        boardPanel.add(boardLabel);
        boardLabel.setBounds(10, 10, 950, 660);

        contentPanel.add(boardPanel);
        boardPanel.setBounds(260, 90, 970, 680);

        yourTurnPanel.setOpaque(false);
        yourTurnPanel.setLayout(new java.awt.GridBagLayout());

        yourTurnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turn.png"))); // NOI18N
        yourTurnPanel.add(yourTurnLabel, new java.awt.GridBagConstraints());

        contentPanel.add(yourTurnPanel);
        yourTurnPanel.setBounds(40, 230, 170, 130);

        restartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restart.png"))); // NOI18N
        restartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                restartLabelMousePressed(evt);
            }
        });
        contentPanel.add(restartLabel);
        restartLabel.setBounds(10, 800, 40, 40);

        whitePartsLabel.setFont(new java.awt.Font("ROG Fonts", 0, 14)); // NOI18N
        whitePartsLabel.setForeground(new java.awt.Color(255, 255, 255));
        whitePartsLabel.setText("Pieces prises :");
        contentPanel.add(whitePartsLabel);
        whitePartsLabel.setBounds(1290, 410, 150, 40);

        blackPartsPanel.setBackground(new java.awt.Color(0, 102, 51));
        blackPartsPanel.setLayout(new java.awt.GridLayout(8, 0));

        bLab8.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab8.setForeground(new java.awt.Color(255, 255, 255));
        bLab8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab8);

        bLab7.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab7.setForeground(new java.awt.Color(255, 255, 255));
        bLab7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab7);

        bLab6.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab6.setForeground(new java.awt.Color(255, 255, 255));
        bLab6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab6);

        bLab5.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab5.setForeground(new java.awt.Color(255, 255, 255));
        bLab5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab5);

        bLab4.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab4.setForeground(new java.awt.Color(255, 255, 255));
        bLab4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab4);

        bLab3.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab3.setForeground(new java.awt.Color(255, 255, 255));
        bLab3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab3);

        bLab2.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab2.setForeground(new java.awt.Color(255, 255, 255));
        bLab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab2);

        bLab1.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        bLab1.setForeground(new java.awt.Color(255, 255, 255));
        bLab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        blackPartsPanel.add(bLab1);

        contentPanel.add(blackPartsPanel);
        blackPartsPanel.setBounds(25, 470, 200, 300);

        whitePartsPanel.setBackground(new java.awt.Color(0, 102, 51));
        whitePartsPanel.setLayout(new java.awt.GridLayout(8, 0));

        wLab8.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab8.setForeground(new java.awt.Color(255, 255, 255));
        wLab8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab8);

        wLab7.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab7.setForeground(new java.awt.Color(255, 255, 255));
        wLab7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab7);

        wLab6.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab6.setForeground(new java.awt.Color(255, 255, 255));
        wLab6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab6);

        wLab5.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab5.setForeground(new java.awt.Color(255, 255, 255));
        wLab5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab5);

        wLab4.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab4.setForeground(new java.awt.Color(255, 255, 255));
        wLab4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab4);

        wLab3.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab3.setForeground(new java.awt.Color(255, 255, 255));
        wLab3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab3);

        wLab2.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab2.setForeground(new java.awt.Color(255, 255, 255));
        wLab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab2);

        wLab1.setFont(new java.awt.Font("ROG Fonts", 0, 12)); // NOI18N
        wLab1.setForeground(new java.awt.Color(255, 255, 255));
        wLab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wLab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        whitePartsPanel.add(wLab1);

        contentPanel.add(whitePartsPanel);
        whitePartsPanel.setBounds(1273, 470, 200, 300);

        blackPartsLabel.setFont(new java.awt.Font("ROG Fonts", 0, 14)); // NOI18N
        blackPartsLabel.setForeground(new java.awt.Color(255, 255, 255));
        blackPartsLabel.setText("Pieces prises :");
        contentPanel.add(blackPartsLabel);
        blackPartsLabel.setBounds(60, 410, 150, 40);

        rulesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rules.png"))); // NOI18N
        rulesLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rulesLabelMousePressed(evt);
            }
        });
        contentPanel.add(rulesLabel);
        rulesLabel.setBounds(130, 790, 50, 60);

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backLabelMousePressed(evt);
            }
        });
        contentPanel.add(backLabel);
        backLabel.setBounds(70, 790, 50, 60);

        savePanel.setBackground(new java.awt.Color(0, 204, 102));
        savePanel.setLayout(null);

        saveLabel.setFont(new java.awt.Font("ROG Fonts", 0, 14)); // NOI18N
        saveLabel.setForeground(new java.awt.Color(255, 255, 255));
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveLabel.setText("SAUVEGARDER LA PARTIE");
        saveLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveLabelMousePressed(evt);
            }
        });
        savePanel.add(saveLabel);
        saveLabel.setBounds(0, 0, 260, 40);

        contentPanel.add(savePanel);
        savePanel.setBounds(620, 790, 260, 40);

        backgroundPanel.add(contentPanel, new java.awt.GridBagConstraints());

        getContentPane().add(backgroundPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void restartLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartLabelMousePressed
        // OPTIONS PROPOSEES A L'UTILISATEUR EN CAS DE RENOUVELLEMENT DE PARTIE
        int answer = JOptionPane.showConfirmDialog(contentPanel,"Souhaitez-vous changer de variante ou de pseudos?",
                        "Avertissement paramètres de partie",JOptionPane.YES_NO_OPTION);
                if (answer==0){ this.dispose();new GUI_making();}
                if (answer==1){this.dispose();new GUI_game(userEntries,recovery);}
    }//GEN-LAST:event_restartLabelMousePressed
    
    
    private void unselection(){
        //changement de couleur informant les joueurs de la deselection de la pièce
        if (selectedPanel.getBackground().getRed() == 200) selectedPanel.setBackground(Color.white); 
        else if (selectedPanel.getBackground().getRed() == 50) selectedPanel.setBackground(Color.black);
        selectedPanel = unselectedPanel; //on vide le contenu de selectedPanel avec un JPanel nonvisible servant uniquement a cet effet
    }
   
    
    private void displayAnimalsAlive() throws IOException, URISyntaxException{
        // reinitialise les valeurs par default avant de voir si les animaux sont toujours en jeu ou non
        bLab1.setText("1 - RAT PRIS"); bLab1.setForeground(Color.red);
        wLab1.setText("1 - RAT PRIS"); wLab1.setForeground(Color.red);
        bLab2.setText("2 - CHAT PRIS"); bLab2.setForeground(Color.red);
        wLab2.setText("2 - CHAT PRIS"); wLab2.setForeground(Color.red);
        bLab3.setText("3 - LOUP PRIS"); bLab3.setForeground(Color.red);
        wLab3.setText("3 - LOUP PRIS"); wLab3.setForeground(Color.red);
        bLab4.setText("4 - CHIEN PRIS"); bLab4.setForeground(Color.red);
        wLab4.setText("4 - CHIEN PRIS"); wLab4.setForeground(Color.red);    
        bLab5.setText("5 - LEOPARD PRIS"); bLab5.setForeground(Color.red);
        wLab5.setText("5 - LEOPARD PRIS"); wLab5.setForeground(Color.red);
        bLab6.setText("6 - LION PRIS"); bLab6.setForeground(Color.red);
        wLab6.setText("6 - LION PRIS"); wLab6.setForeground(Color.red);
        bLab7.setText("7 - TIGRE PRIS"); bLab7.setForeground(Color.red);
        wLab7.setText("7 - TIGRE PRIS"); wLab7.setForeground(Color.red);
        bLab8.setText("8 - ELEPHANT PRIS"); bLab8.setForeground(Color.red);
        wLab8.setText("8 - ELEPHANT PRIS"); wLab8.setForeground(Color.red);

        Component[] panelsOnBoard = boardPanel.getComponents(); //récupère tous les composants du plateau de jeu
        for (int i = 0; i < panelsOnBoard.length; i++) { // parcours la liste
           if (panelsOnBoard[i].getName() != "boardLab" && panelsOnBoard[i].isShowing()==true){ //récupère le noms et effectue l'action pour tout composant visible différent du Label(image de fond) du plateau
                panelsOnBoard[i] = panelsOnBoard[i]; // isole un composant
                displayAnimalAliveFromPanel((JPanel) panelsOnBoard[i]); //met à jour le label indiquant que l'animal est toujours en jeu
           }
        }
    }
    
    private void displayAnimalAliveFromPanel(JPanel anypanel) throws IOException, URISyntaxException{
        int redPanel = anypanel.getBackground().getRed(); // recupère la valeur du rouge (car suffisant pour la condition) du JPanel
        
        // associe le rang de l'animal à son nom puis l'affiche sur l'interface en tant que pièce en jeu du bon coté (selon la couleur du JPanel)
        String animal = anypanel.getName();
        String text;
        if (animal == "Rat"){
            text = "1 - RAT EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab1.setText(text);
                bLab1.setForeground(Color.white);
            }
            else {wLab1.setText(text);wLab1.setForeground(Color.white);}
            
        }
        else if (animal == "Cat"){
            text = "2 - CHAT EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab2.setText(text);
                bLab2.setForeground(Color.white);
            }
            else {wLab2.setText(text);wLab2.setForeground(Color.white);}
        }
        else if (animal == "Wolf"){
            text = "3 - LOUP EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab3.setText(text);
                bLab3.setForeground(Color.white);
            }
            else {wLab3.setText(text);wLab3.setForeground(Color.white);}
        }
        else if (animal == "Dog"){
            text = "4 - CHIEN EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab4.setText(text);
                bLab4.setForeground(Color.white);
            }
            else {wLab4.setText(text);wLab4.setForeground(Color.white);}
        }
        else if (animal == "Leopard"){
            text = "5 - LEOPARD EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab5.setText(text);
                bLab5.setForeground(Color.white);
            }
            else {wLab5.setText(text);wLab5.setForeground(Color.white);}
        }
        else if (animal == "Lion"){
            text = "6 - LION EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab6.setText(text);
                bLab6.setForeground(Color.white);
            }
            else {wLab6.setText(text);wLab6.setForeground(Color.white);}
        }
        else if (animal == "Tiger"){
            text = "7 - TIGRE EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab7.setText(text);
                bLab7.setForeground(Color.white);
            }
            else {wLab7.setText(text);wLab7.setForeground(Color.white);}
        }
        else if (animal == "Elephant"){
            text = "8 - ELEPHANT EN JEU";
            if (redPanel == 0 || redPanel == 50){
                bLab8.setText(text);
                bLab8.setForeground(Color.white);
            }
            else {wLab8.setText(text);wLab8.setForeground(Color.white);}
        }
    }
    
    
    private void moveSelectedPanelOrSelection(JPanel panel, Color Backgroundcolor) throws IOException, URISyntaxException{
        // ACTIONS A EFFECTUER LORSQUE L'ON CLICK SUR UN ANIMAL 
        // selectedPanel est le JPanel sur lequel on a cliqué avant et panel est le JPanel de l'animal sur lequel on vient de cliquer
        
        // on récupère la valeur du rouge du panel sélectionné et du panel sur lequel on vient de cliquer
        int redSelectedPanel = selectedPanel.getBackground().getRed();
        int redPanel = panel.getBackground().getRed();
        
        //SELECTION
        if (selectedPanel == unselectedPanel){ // condition pour determiner si il s'agit d'une SELECTION d'une pièce ou d'un COMBAT à effectuer
            if (!blacksCanPlayBol && redPanel == 0){return;} // si les noirs peuvent pas jouer et que la pièce est noir : il ne se passe rien (on quitte la méthode)
            
            else if (!blacksCanPlayBol && redPanel == 255 || blacksCanPlayBol && redPanel == 0){ // vérification de qui peut jouer
                panel.setBackground(Backgroundcolor);// modifie le background du panel sélectionné afin d'indiquer la selection
                selectedPanel = panel; //sélection du JPanel
                return;
            }
        }
        //COMBAT
        else if (redSelectedPanel == 50 && redPanel == 255 || redSelectedPanel == 200 && redPanel == 0 ) //condition permettant de ne pas faire d'action entre animaux de même couleur
        {   
            int X = panel.getX(); 
            int Y = panel.getY();
            int currentX = selectedPanel.getX();
            int currentY = selectedPanel.getY();
            
            if (X == currentX || Y == currentY){ // évite le deplacement en diagonale
                grid = new MovesManager(selectedPanel,boardPanel,X,Y,userEntries).getLegitPositionPanelClick(panel); // recupère la position que le panel sélectionné prendra après avoir été étudié par la methode getLegitPositionPanelClick
                if (grid[0]==X && grid[1]==Y){ // vérification que les coordonnées du futur déplacemement sont différentes des coordonnés actuelles
                    selectedPanel.setLocation(grid[0], grid[1]); // mis à jour de la position
                    
                    // Animation de la main qui pointe du doigt le joueur à qui c'est le tour de joué
                    if (blacksCanPlayBol) animation.Animation.moveComponentToPosition("right",40, 1275, 1, 10, yourTurnPanel);
                    else animation.Animation.moveComponentToPosition("left",1275, 40, 1, 10, yourTurnPanel);
                    
                    panel.setVisible(false); // rend non visible le panel car vient d'être mangé
                    
                    blacksCanPlayBol = !blacksCanPlayBol; // c'est à l'autre couleur de jouer
                    
                    filesManager.addPanelsProperties(); // ecriture sur fichier des positions du déplacement tout juste effectué
                }
                
                displayAnimalsAlive(); // mis à jour de l'affichage des animaux en jeu/mangés
            }
            MovesManager.setBorderIfTrapOrRiver(boardPanel); // mis à jour des border des JPanels (bleu si rivière, rouge si piège et null sinon)
            MovesManager.showWhoWon(boardPanel,userEntries,selectedPanel); // vérifie si quelqu'un à gagné
            unselection(); // déselection du JPanel sélectionné
        }
        else if (selectedPanel == panel) unselection(); // déselectionne la pièce en cas de double click un même animal
    }
    

    // METHODES ASSOCIEES AUX 16 JPANELS PRESENTS SUR LE PLATEAU : Chaque JPanel a sa propre méthode pour effectuer un action lorsque l'on click sur celui ci
    private void blackTigerLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackTigerLabelMousePressed
        try{moveSelectedPanelOrSelection(blackTigerPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackTigerLabelMousePressed

    private void blackElephantLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackElephantLabelMousePressed
        try{moveSelectedPanelOrSelection(blackElephantPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackElephantLabelMousePressed

    private void blackCatLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackCatLabelMousePressed
        try{moveSelectedPanelOrSelection(blackCatPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackCatLabelMousePressed

    private void blackWolfLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackWolfLabelMousePressed
        try{moveSelectedPanelOrSelection(blackWolfPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackWolfLabelMousePressed

    private void blackLeopardLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackLeopardLabelMousePressed
        try{moveSelectedPanelOrSelection(blackLeopardPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackLeopardLabelMousePressed

    private void blackDogLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackDogLabelMousePressed
        try{moveSelectedPanelOrSelection(blackDogPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackDogLabelMousePressed

    private void blackLionLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackLionLabelMousePressed
        try{moveSelectedPanelOrSelection(blackLionPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackLionLabelMousePressed

    private void whiteRatLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteRatLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteRatPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteRatLabelMousePressed

    private void whiteLionLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteLionLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteLionPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteLionLabelMousePressed

    private void whiteDogLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteDogLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteDogPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteDogLabelMousePressed

    private void whiteLeopardLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteLeopardLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteLeopardPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteLeopardLabelMousePressed

    private void whiteWolfLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteWolfLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteWolfPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteWolfLabelMousePressed

    private void whiteCatLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteCatLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteCatPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteCatLabelMousePressed

    private void whiteElephantLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteElephantLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteElephantPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteElephantLabelMousePressed

    private void whiteTigerLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteTigerLabelMousePressed
        try{moveSelectedPanelOrSelection(whiteTigerPanel,whiteSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_whiteTigerLabelMousePressed

    private void blackRatLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackRatLabelMousePressed
        try{moveSelectedPanelOrSelection(blackRatPanel,blackSelectedPanelColor);}
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_blackRatLabelMousePressed

    private void boardLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardLabelMousePressed
        // ACTIONS A EFFECTUER SI CLICK SUR LE PLATEAU DE JEU
        int redSelectedPanel = selectedPanel.getBackground().getRed();
        if (selectedPanel != unselectedPanel){ //vérifie qu'un panel a été selectionné
            int currentX = selectedPanel.getX(); //coordonnées x actuels du panel selectionné
            int currentY = selectedPanel.getY(); //coordonnées y actuels du panel selectionné
            grid = new MovesManager(selectedPanel,boardPanel,evt.getX(),evt.getY(),userEntries).getLegitPositionBoardClick();
            if (grid[0]==currentX && grid[1]==currentY)return; //si après vérification du deplacement, les coordonnées retournées sont identiques à ceux actuels, rien ne se passse (on quitte la méthode)

            selectedPanel.setLocation(grid[0], grid[1]); //déplacement du JPanel sélectionner après vérification du respect des règles de déplacement par la méthode getLegitPositionBoardClick()
            MovesManager.setBorderIfTrapOrRiver(boardPanel); // mis à jour des border (bleu si rivière, rouge si piège et null sinon)
            filesManager.addPanelsProperties(); // mis à jour du fichier d'enregistrement des coups
            
            blacksCanPlayBol = !blacksCanPlayBol; // c'est à l'autre couleur de jouer 
            
            // Animation de la main qui pointe du doigt le joueur à qui c'est le tour de joué
            if (blacksCanPlayBol) animation.Animation.moveComponentToPosition("left",1275, 40, 1, 10, yourTurnPanel);
            else animation.Animation.moveComponentToPosition("right",40, 1275, 1, 10, yourTurnPanel);
            
            try {
                displayAnimalsAlive(); // mis à jour des animaux toujours en jeu
            } catch (IOException | URISyntaxException err) {}
            MovesManager.showWhoWon(boardPanel,userEntries,selectedPanel); // vérifie si quelqu'un à gagné
            unselection(); // déselection du JPanel sélectionné
            
        }
    }//GEN-LAST:event_boardLabelMousePressed

    private void rulesLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesLabelMousePressed
        // Ouvre la page Web wikipédia indiquant toutes les règles du jeu 
        try{
            if(Desktop.isDesktopSupported()) {Desktop.getDesktop().browse(new URI("https://fr.wikipedia.org/wiki/Jeu_du_combat_des_animaux"));}
        }
        catch(IOException | URISyntaxException err){}
    }//GEN-LAST:event_rulesLabelMousePressed

    private void backLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMousePressed
        // BOUTON RETOUR EN ARRIERE
        filesManager.back(); // retour d'un coup en arrière
        MovesManager.setBorderIfTrapOrRiver(boardPanel); // mis à jour des border des JPanels (bleu si rivière, rouge si piège et null sinon)
        MovesManager.showWhoWon(boardPanel,userEntries,selectedPanel); // vérifie si quelqu'un à gagné
        try {
            displayAnimalsAlive();// mise à jour de l'affichage des animaux en jeu
        } catch (IOException | URISyntaxException err) {err.printStackTrace();}
        
    }//GEN-LAST:event_backLabelMousePressed

    private void saveLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLabelMousePressed
        filesManager.saveGameToFile(); // on sauvegarde la partie en cours dans un fichier qui sera générer dans le repertoire Sauvegarde de parties
    }//GEN-LAST:event_saveLabelMousePressed


    // gestion de la taille de la fenetre
    @Override
    public Dimension getMinimumSize() {
        return new Dimension(1500, 900);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(1920, 1080);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1550, 900);
    }
    // fin


    // Variables declarées manuellement
    private final String[] userEntries; // données saisies par l'utilisateur dans l'interface précedente
    private final  JPanel unselectedPanel = new JPanel(); //on vide le contenu de selectedPanel avec un JPanel nonvisible servant uniquement a cet effet
    private JPanel selectedPanel = unselectedPanel; // initialiser en tant que unselectedPanel car aucun animal n'est pour l'instant séléctionné
    private final Color whiteSelectedPanelColor = new Color(200,200,200);
    private final Color blackSelectedPanelColor = new Color(50,50,50);
    private int[] grid; // stock les coordonnées des JPanels s'appretant à etre deplacé après avoir été étudiées par des méthodes de controle de déplacement
    public static boolean blacksCanPlayBol; // indique au programme à qui est le tour de joué (si true, c'est aux noirs de jouer et si false, c'est aux blancs)
    private FilesManager filesManager;
    private boolean recovery; //indique au programme si la class GUI_game est appellée pour une nouvelle partie ou pour la restauration d'une ancienne partie depuis une sauvegarde
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bLab1;
    private javax.swing.JLabel bLab2;
    private javax.swing.JLabel bLab3;
    private javax.swing.JLabel bLab4;
    private javax.swing.JLabel bLab5;
    private javax.swing.JLabel bLab6;
    private javax.swing.JLabel bLab7;
    private javax.swing.JLabel bLab8;
    private javax.swing.JLabel backLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel blackCatLabel;
    private javax.swing.JPanel blackCatPanel;
    private javax.swing.JLabel blackDogLabel;
    private javax.swing.JPanel blackDogPanel;
    private javax.swing.JLabel blackElephantLabel;
    private javax.swing.JPanel blackElephantPanel;
    private javax.swing.JLabel blackLeopardLabel;
    private javax.swing.JPanel blackLeopardPanel;
    private javax.swing.JLabel blackLionLabel;
    private javax.swing.JPanel blackLionPanel;
    private javax.swing.JLabel blackPartsLabel;
    private javax.swing.JPanel blackPartsPanel;
    private javax.swing.JLabel blackRatLabel;
    private javax.swing.JPanel blackRatPanel;
    private javax.swing.JLabel blackTigerLabel;
    private javax.swing.JPanel blackTigerPanel;
    private javax.swing.JLabel blackWolfLabel;
    private javax.swing.JPanel blackWolfPanel;
    private javax.swing.JLabel boardLabel;
    public javax.swing.JPanel boardPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel restartLabel;
    private javax.swing.JLabel rulesLabel;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JPanel savePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel wLab1;
    private javax.swing.JLabel wLab2;
    private javax.swing.JLabel wLab3;
    private javax.swing.JLabel wLab4;
    private javax.swing.JLabel wLab5;
    private javax.swing.JLabel wLab6;
    private javax.swing.JLabel wLab7;
    private javax.swing.JLabel wLab8;
    private javax.swing.JLabel whiteCatLabel;
    private javax.swing.JPanel whiteCatPanel;
    private javax.swing.JLabel whiteDogLabel;
    private javax.swing.JPanel whiteDogPanel;
    private javax.swing.JLabel whiteElephantLabel;
    private javax.swing.JPanel whiteElephantPanel;
    private javax.swing.JLabel whiteLeopardLabel;
    private javax.swing.JPanel whiteLeopardPanel;
    private javax.swing.JLabel whiteLionLabel;
    private javax.swing.JPanel whiteLionPanel;
    private javax.swing.JLabel whitePartsLabel;
    private javax.swing.JPanel whitePartsPanel;
    private javax.swing.JLabel whiteRatLabel;
    private javax.swing.JPanel whiteRatPanel;
    private javax.swing.JLabel whiteTigerLabel;
    private javax.swing.JPanel whiteTigerPanel;
    private javax.swing.JLabel whiteWolfLabel;
    private javax.swing.JPanel whiteWolfPanel;
    private javax.swing.JLabel yourTurnLabel;
    private static javax.swing.JPanel yourTurnPanel;
    // End of variables declaration//GEN-END:variables

}
