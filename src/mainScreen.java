
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Casper
 */
public class mainScreen extends javax.swing.JFrame {

    /**
     * Creates new form AnaEkran
     */
    public mainScreen() {
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

        loginpanel = new javax.swing.JPanel();
        gamerBtn = new javax.swing.JLabel();
        gameSelectionScreenBtn = new javax.swing.JLabel();
        gameNameGif = new javax.swing.JLabel();
        exitMainScreenBtn = new javax.swing.JLabel();
        mainScreenBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);

        loginpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        loginpanel.setLayout(null);

        gamerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoSyr.png"))); // NOI18N
        loginpanel.add(gamerBtn);
        gamerBtn.setBounds(450, 420, 360, 60);

        gameSelectionScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectGameGreen.png"))); // NOI18N
        gameSelectionScreenBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameSelectionScreenBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gameSelectionScreenBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gameSelectionScreenBtnMouseExited(evt);
            }
        });
        loginpanel.add(gameSelectionScreenBtn);
        gameSelectionScreenBtn.setBounds(610, 490, 168, 60);

        gameNameGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spaceWarOne.gif"))); // NOI18N
        loginpanel.add(gameNameGif);
        gameNameGif.setBounds(40, 420, 160, 60);

        exitMainScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitGreenBtn.png"))); // NOI18N
        exitMainScreenBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMainScreenBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMainScreenBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMainScreenBtnMouseExited(evt);
            }
        });
        loginpanel.add(exitMainScreenBtn);
        exitMainScreenBtn.setBounds(40, 490, 170, 60);

        mainScreenBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundJava.jpg"))); // NOI18N
        mainScreenBackground.setText("anaEkranArkaPlan");
        loginpanel.add(mainScreenBackground);
        mainScreenBackground.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gameSelectionScreenBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameSelectionScreenBtnMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new gameSelection().setVisible(true);
    }//GEN-LAST:event_gameSelectionScreenBtnMouseClicked

    private void gameSelectionScreenBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameSelectionScreenBtnMouseEntered
        // TODO add your handling code here:
        gameSelectionScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectGameBlue.png")));
    }//GEN-LAST:event_gameSelectionScreenBtnMouseEntered

    private void gameSelectionScreenBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameSelectionScreenBtnMouseExited
        // TODO add your handling code here:
        gameSelectionScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectGameGreen.png")));
    }//GEN-LAST:event_gameSelectionScreenBtnMouseExited

    private void exitMainScreenBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMainScreenBtnMouseEntered
        // TODO add your handling code here:
        exitMainScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitBlueBtn.png")));
    }//GEN-LAST:event_exitMainScreenBtnMouseEntered

    private void exitMainScreenBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMainScreenBtnMouseExited
        // TODO add your handling code here:
        exitMainScreenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitGreenBtn.png")));
    }//GEN-LAST:event_exitMainScreenBtnMouseExited

    private void exitMainScreenBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMainScreenBtnMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMainScreenBtnMouseClicked

    /**
     * @param args the command line arguments
     *
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
            JOptionPane.showMessageDialog(null,"Unexpected a situation has been occurred:\nError : "+ex.getMessage(),"Error Message",JOptionPane.ERROR);
        }
        //</editor-fold>
        try {
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |  InstantiationException | IllegalAccessException |UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mainScreen().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitMainScreenBtn;
    private javax.swing.JLabel gameNameGif;
    private javax.swing.JLabel gameSelectionScreenBtn;
    private javax.swing.JLabel gamerBtn;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JLabel mainScreenBackground;
    // End of variables declaration//GEN-END:variables
}