/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import javax.swing.JOptionPane;
import moviedatabase.allMovie;
import moviedatabase.movie;

/**
 *
 * @author Mazharul Islam
 */
public class searchByRating extends javax.swing.JFrame {

    /**
     * Creates new form searchByRating
     */
    public searchByRating() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startField = new javax.swing.JTextField();
        endField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search By Rating");
        setBounds(new java.awt.Rectangle(750, 300, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Start");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 170, 69, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("End");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 170, 69, -1));

        startField.setBackground(new java.awt.Color(0, 0, 51));
        startField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(startField, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 130, 69, -1));

        endField.setBackground(new java.awt.Color(0, 0, 51));
        endField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        endField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(endField, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 130, 69, -1));

        okButton.setBackground(new java.awt.Color(0, 0, 51));
        okButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-ok-25.png"))); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 168, -1));

        backButton.setBackground(new java.awt.Color(0, 0, 51));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-back-40.png"))); // NOI18N
        backButton.setToolTipText("");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 21, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/Background1.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(null);
        jLabel3.setMinimumSize(null);
        jLabel3.setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (this.startField.getText().length() == 0 || this.endField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Starting and Ending rating required");
        } else if ((Float.parseFloat(this.startField.getText()) < 0 || Float.parseFloat(this.startField.getText()) > 10)
                || (Float.parseFloat(this.endField.getText()) < 0 || Float.parseFloat(this.endField.getText()) > 10)) {
            JOptionPane.showMessageDialog(null, "Rating must be between 0-10");
        } else {
            String s = movie.getRating(Float.parseFloat(this.startField.getText()), Float.parseFloat(this.endField.getText()));
            if (s.equals("NOTHING")) {
                JOptionPane.showMessageDialog(null, "No Movie Found:(");
            } else {
                this.setVisible(false);
                new allMovie(s, 2).setVisible(true);
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchByRating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchByRating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchByRating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchByRating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchByRating().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField endField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField startField;
    // End of variables declaration//GEN-END:variables
}