
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Casper
 */
class MP3 {

    private static String filename;
    private Player player;

    public MP3(String filename) {
        MP3.filename = filename;
    }

    public void close() {
        if (player != null) {
            player.close();

        }
    }

    public void play() {

        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("The playback file is damage " + filename);
        }
        new Thread() {
            //@Override
            @Override
            public void run() {
                try {
                    player.play();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }
}

 class gameSelection extends javax.swing.JFrame {

    public int numberOfGamePlay = 0;
    public static int  numberOfGames= 0;
    ImageIcon medalIcon = new ImageIcon(getClass().getResource("/images/medal.gif"));

    /**
     * Creates new form OyunSecme
     */
    public gameSelection() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameSelectionScreen = new javax.swing.JPanel();
        logoImage = new javax.swing.JLabel();
        battleShipOne = new javax.swing.JLabel();
        battleShipTwo = new javax.swing.JLabel();
        battleShipThree = new javax.swing.JLabel();
        fireOne = new javax.swing.JLabel();
        fireTwo = new javax.swing.JLabel();
        bombTwo = new javax.swing.JLabel();
        bombOne = new javax.swing.JLabel();
        bombFour = new javax.swing.JLabel();
        bombThree = new javax.swing.JLabel();
        bulletOne = new javax.swing.JLabel();
        bulletThree = new javax.swing.JLabel();
        bulletTwo = new javax.swing.JLabel();
        bulletFour = new javax.swing.JLabel();
        bulletSix = new javax.swing.JLabel();
        bulletFive = new javax.swing.JLabel();
        ufoOneGif = new javax.swing.JLabel();
        ufoGif = new javax.swing.JLabel();
        playGameBtn = new javax.swing.JLabel();
        exitGameSelectionScreenBtn = new javax.swing.JLabel();
        restartBtn = new javax.swing.JLabel();
        skorboardBtn = new javax.swing.JLabel();
        soundOnOffBtn = new javax.swing.JLabel();
        gameSelectionScreenBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);

        gameSelectionScreen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        gameSelectionScreen.setForeground(new java.awt.Color(240, 240, 240));
        gameSelectionScreen.setPreferredSize(new java.awt.Dimension(800, 600));
        gameSelectionScreen.setLayout(null);

        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-game-controller-96.png"))); // NOI18N
        logoImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoImageMouseExited(evt);
            }
        });
        gameSelectionScreen.add(logoImage);
        logoImage.setBounds(340, 20, 96, 96);

        battleShipOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jet.png"))); // NOI18N
        gameSelectionScreen.add(battleShipOne);
        battleShipOne.setBounds(160, 460, 128, 128);

        battleShipTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jetSpaceWar.png"))); // NOI18N
        gameSelectionScreen.add(battleShipTwo);
        battleShipTwo.setBounds(470, 460, 128, 128);

        battleShipThree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/helicopter.png"))); // NOI18N
        gameSelectionScreen.add(battleShipThree);
        battleShipThree.setBounds(318, 148, 128, 128);

        fireOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fireOne.png"))); // NOI18N
        gameSelectionScreen.add(fireOne);
        fireOne.setBounds(210, 598, 24, 24);

        fireTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fireOne.png"))); // NOI18N
        gameSelectionScreen.add(fireTwo);
        fireTwo.setBounds(520, 600, 24, 24);

        bombTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/missile.png"))); // NOI18N
        gameSelectionScreen.add(bombTwo);
        bombTwo.setBounds(209, 421, 32, 32);

        bombOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/missile.png"))); // NOI18N
        gameSelectionScreen.add(bombOne);
        bombOne.setBounds(209, 338, 32, 32);

        bombFour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bomb.png"))); // NOI18N
        gameSelectionScreen.add(bombFour);
        bombFour.setBounds(520, 401, 32, 32);

        bombThree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bomb.png"))); // NOI18N
        gameSelectionScreen.add(bombThree);
        bombThree.setBounds(520, 221, 32, 32);

        bulletOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulletOne.png"))); // NOI18N
        gameSelectionScreen.add(bulletOne);
        bulletOne.setBounds(348, 308, 24, 24);

        bulletThree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulletOne.png"))); // NOI18N
        gameSelectionScreen.add(bulletThree);
        bulletThree.setBounds(348, 381, 24, 24);

        bulletTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulletOne.png"))); // NOI18N
        gameSelectionScreen.add(bulletTwo);
        bulletTwo.setBounds(348, 346, 24, 24);

        bulletFour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulletOne.png"))); // NOI18N
        gameSelectionScreen.add(bulletFour);
        bulletFour.setBounds(390, 308, 24, 24);

        bulletSix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulletOne.png"))); // NOI18N
        gameSelectionScreen.add(bulletSix);
        bulletSix.setBounds(390, 381, 24, 24);

        bulletFive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulletOne.png"))); // NOI18N
        gameSelectionScreen.add(bulletFive);
        bulletFive.setBounds(390, 343, 24, 24);

        ufoOneGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ufo.gif"))); // NOI18N
        gameSelectionScreen.add(ufoOneGif);
        ufoOneGif.setBounds(60, 40, 290, 70);

        ufoGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ufo.gif"))); // NOI18N
        ufoGif.setText("jLabel1");
        gameSelectionScreen.add(ufoGif);
        ufoGif.setBounds(480, 40, 290, 70);

        playGameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playGameGreenBtn.png"))); // NOI18N
        playGameBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playGameBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playGameBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playGameBtnMouseExited(evt);
            }
        });
        gameSelectionScreen.add(playGameBtn);
        playGameBtn.setBounds(30, 150, 170, 60);

        exitGameSelectionScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitGreenBtn.png"))); // NOI18N
        exitGameSelectionScreenBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitGameSelectionScreenBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitGameSelectionScreenBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitGameSelectionScreenBtnMouseExited(evt);
            }
        });
        gameSelectionScreen.add(exitGameSelectionScreenBtn);
        exitGameSelectionScreenBtn.setBounds(30, 230, 170, 60);

        restartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restartGreenBtn.png"))); // NOI18N
        restartBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restartBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restartBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restartBtnMouseExited(evt);
            }
        });
        gameSelectionScreen.add(restartBtn);
        restartBtn.setBounds(580, 150, 170, 60);

        skorboardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resultsGreenBtn.png"))); // NOI18N
        skorboardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skorboardBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                skorboardBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                skorboardBtnMouseExited(evt);
            }
        });
        gameSelectionScreen.add(skorboardBtn);
        skorboardBtn.setBounds(580, 230, 170, 60);

        soundOnOffBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speaker_off.png"))); // NOI18N
        soundOnOffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soundOnOffBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soundOnOffBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soundOnOffBtnMouseExited(evt);
            }
        });
        gameSelectionScreen.add(soundOnOffBtn);
        soundOnOffBtn.setBounds(740, 10, 50, 60);

        gameSelectionScreenBackground.setForeground(new java.awt.Color(240, 240, 240));
        gameSelectionScreenBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spaceBackgroundWalpaper.jpg"))); // NOI18N
        gameSelectionScreenBackground.setText("oyunSecmeArkaPlan");
        gameSelectionScreenBackground.setMaximumSize(new java.awt.Dimension(800, 600));
        gameSelectionScreenBackground.setMinimumSize(new java.awt.Dimension(800, 600));
        gameSelectionScreenBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameSelectionScreenBackgroundMouseClicked(evt);
            }
        });
        gameSelectionScreen.add(gameSelectionScreenBackground);
        gameSelectionScreenBackground.setBounds(0, -80, 800, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameSelectionScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameSelectionScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void logoImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoImageMouseEntered
        // TODO add your handling code here:
        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/invadersTwo.png")));
    }//GEN-LAST:event_logoImageMouseEntered

    private void logoImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoImageMouseExited
        // TODO add your handling code here:
        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-game-controller-96.png")));
    }//GEN-LAST:event_logoImageMouseExited

    private void playGameBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playGameBtnMouseClicked
        // TODO add your handling code here:
        if (numberOfGames == 0) {
            levelOneGameLoad levelOneGameLoad = new levelOneGameLoad();
            levelOneGameLoad.setVisible(true);
            numberOfGames++;
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "If the game has been never played run.\n!The game has been played at least once.", "Information Message", JOptionPane.WARNING_MESSAGE);
            setVisible(true);
            new gameLevelOne().setVisible(false);
        }
    }//GEN-LAST:event_playGameBtnMouseClicked

    private void playGameBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playGameBtnMouseEntered
        // TODO add your handling code here:
        playGameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playGameBlueBtn.png")));
    }//GEN-LAST:event_playGameBtnMouseEntered

    private void playGameBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playGameBtnMouseExited
        // TODO add your handling code here:
        playGameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playGameGreenBtn.png")));
    }//GEN-LAST:event_playGameBtnMouseExited

    private void exitGameSelectionScreenBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitGameSelectionScreenBtnMouseClicked
        // TODO add your handling code here:
        try {
            JOptionPane.showMessageDialog(this, "Exit  game", "Exit", JOptionPane.WARNING_MESSAGE);
            Thread.sleep(2000);
            System.exit(0);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, "The exit process was aborted:\nError"+ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_exitGameSelectionScreenBtnMouseClicked

    private void exitGameSelectionScreenBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitGameSelectionScreenBtnMouseEntered
        // TODO add your handling code here:    
        exitGameSelectionScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitBlueBtn.png")));
    }//GEN-LAST:event_exitGameSelectionScreenBtnMouseEntered

    private void exitGameSelectionScreenBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitGameSelectionScreenBtnMouseExited
        // TODO add your handling code here:
        exitGameSelectionScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitGreenBtn.png")));
    }//GEN-LAST:event_exitGameSelectionScreenBtnMouseExited

    private void restartBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartBtnMouseClicked
        // TODO add your handling code here:
        if (numberOfGames > 0) {
            levelOneGameLoad loadLevelOne = new levelOneGameLoad();
            setVisible(false);
            loadLevelOne.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "The game has been played at least once.", "Information Message", JOptionPane.WARNING_MESSAGE);
            setVisible(true);
        }
    }//GEN-LAST:event_restartBtnMouseClicked

    private void restartBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartBtnMouseEntered
        // TODO add your handling code here:
        restartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restartBlueBtn.png")));
    }//GEN-LAST:event_restartBtnMouseEntered

    private void restartBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restartBtnMouseExited
        // TODO add your handling code here:
        restartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restartGreenBtn.png")));
    }//GEN-LAST:event_restartBtnMouseExited

    private void skorboardBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skorboardBtnMouseClicked
        // TODO add your handling code here:
        gameLevelOne levelOne = new gameLevelOne();
        if (numberOfGames == 0) {
            JOptionPane.showMessageDialog(this, "Please,Look again after the game has been played.", "Information", JOptionPane.WARNING_MESSAGE);
        } else if (numberOfGames > 0) {
            if (levelOne.getElapsedTime()< 5) {
                String message = "Player  Skor Board: " + "\n"
                        + "Player : " + "BlackHole" + "\n"
                        + "Spent Fire : " + (gameLevelOne.spentFires + gameLevelTwo.spentFires+gameLevelThree.spentFires) + "\n"
                        + "The Pass Time: " + ((double) gameLevelOne.elapsedTimes / 1000 + (double) gameLevelTwo.elapsedTimes / 1000+(double) gameLevelThree.elapsedTimes/1000) + " saniye dir.";
                JOptionPane.showMessageDialog(this, message, "Skorboard", JOptionPane.INFORMATION_MESSAGE, medalIcon);
            }
        } else if (levelOne.getElapsedTime()> 5) {
            String message1 = "Player  Skor Board: " + "\n"
                    + "Player" + " : " + "\n"
                    + "Spent Fire : " + gameLevelOne.spentFires + "\n"
                    + "The Pass Time: " + (double) gameLevelOne.elapsedTimes / 1000 + " saniye dir.";
            JOptionPane.showMessageDialog(this, message1, "Skorboard", JOptionPane.INFORMATION_MESSAGE, medalIcon);
        }

    }//GEN-LAST:event_skorboardBtnMouseClicked

    private void skorboardBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skorboardBtnMouseEntered
        // TODO add your handling code here:
        skorboardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resultsBlueBtn.png")));
    }//GEN-LAST:event_skorboardBtnMouseEntered

    private void skorboardBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skorboardBtnMouseExited
        // TODO add your handling code here:
        skorboardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resultsGreenBtn.png")));
    }//GEN-LAST:event_skorboardBtnMouseExited

    private void gameSelectionScreenBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameSelectionScreenBackgroundMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_gameSelectionScreenBackgroundMouseClicked
    String soundOnMessage;
    private void soundOnOffBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soundOnOffBtnMouseClicked
        // TODO add your handling code here:
        //After sound on, The move objects have been speed contain game. You can end of the game and The sound close continue th game.
        soundOnMessage = "After sound on,if the objects are moving fastly in the  game. \n"
                + "You can ending of the game and the sound close start again the game.";
        JOptionPane.showMessageDialog(null, soundOnMessage);
        String filename = "zajdi.wav";
        MP3 mp3 = new MP3(filename);
        try {
            soundOnOffBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speakerWhiteNew.png")));
            mp3 = new MP3(filename);
            mp3.play();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_soundOnOffBtnMouseClicked

    private void soundOnOffBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soundOnOffBtnMouseEntered
        // TODO add your handling code here:
        soundOnOffBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speakerWhiteNew.png")));
    }//GEN-LAST:event_soundOnOffBtnMouseEntered

    private void soundOnOffBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soundOnOffBtnMouseExited
        // TODO add your handling code here:
        soundOnOffBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speaker_off.png")));
    }//GEN-LAST:event_soundOnOffBtnMouseExited

    public class gameScreen extends JFrame {
        public gameScreen(String title) throws HeadlessException {
            super(title);
        }
    }
    public void gamePlayLevelOne() {
        gameScreen screenOne = new gameScreen("Space War Level I");
        screenOne.setResizable(false); 
        screenOne.setFocusable(false);
        screenOne.setSize(800, 600);
        screenOne.setLocationRelativeTo(null);
        screenOne.setUndecorated(true);
        screenOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLevelOne levelOne = new gameLevelOne();
        levelOne.requestFocus();
        levelOne.addKeyListener(levelOne);
        levelOne.setFocusable(true);
        levelOne.setFocusTraversalKeysEnabled(false);
        screenOne.add(levelOne);
        screenOne.setVisible(true);
    }

    public void gamePlayLevelTwo() {
        gameScreen screenTwo = new gameScreen("Space War Level II");
        screenTwo.setResizable(false);
        screenTwo.setFocusable(false);
        screenTwo.setSize(800, 600);
        screenTwo.setLocationRelativeTo(null);
        screenTwo.setUndecorated(true);
        screenTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLevelTwo levelTwo = new gameLevelTwo();
        levelTwo.requestFocus();
        levelTwo.addKeyListener(levelTwo);
        levelTwo.setFocusable(true);
        levelTwo.setFocusTraversalKeysEnabled(false);
        screenTwo.add(levelTwo);
        screenTwo.setVisible(true);
    }

    public void gamePlayLevelThree(){
        gameScreen screenThree=new gameScreen("Space War Level III");
        screenThree.setResizable(false);
        screenThree.setFocusable(false);
        screenThree.setSize(800,600);
        screenThree.setLocationRelativeTo(null);
        screenThree.setUndecorated(true);
        screenThree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLevelThree levelThree=new gameLevelThree();
        levelThree.requestFocus();
        levelThree.addKeyListener(levelThree);
        levelThree.setFocusable(true);
        levelThree.setFocusTraversalKeysEnabled(false);
        screenThree.add(levelThree);
        screenThree.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " Hatasi Olustu", "Error", JOptionPane.ERROR);
        }
        //</editor-fold>
        //   OyunSeviyeIki seviyeIki=new OyunSeviyeIki();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new gameSelection().setVisible(true);
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel battleShipOne;
    private javax.swing.JLabel battleShipThree;
    private javax.swing.JLabel battleShipTwo;
    private javax.swing.JLabel bombFour;
    private javax.swing.JLabel bombOne;
    private javax.swing.JLabel bombThree;
    private javax.swing.JLabel bombTwo;
    private javax.swing.JLabel bulletFive;
    private javax.swing.JLabel bulletFour;
    private javax.swing.JLabel bulletOne;
    private javax.swing.JLabel bulletSix;
    private javax.swing.JLabel bulletThree;
    private javax.swing.JLabel bulletTwo;
    private javax.swing.JLabel exitGameSelectionScreenBtn;
    private javax.swing.JLabel fireOne;
    private javax.swing.JLabel fireTwo;
    private javax.swing.JPanel gameSelectionScreen;
    private javax.swing.JLabel gameSelectionScreenBackground;
    private javax.swing.JLabel logoImage;
    private javax.swing.JLabel playGameBtn;
    private javax.swing.JLabel restartBtn;
    private javax.swing.JLabel skorboardBtn;
    private javax.swing.JLabel soundOnOffBtn;
    private javax.swing.JLabel ufoGif;
    private javax.swing.JLabel ufoOneGif;
    // End of variables declaration//GEN-END:variables
}
