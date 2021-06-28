/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import javax.swing.JFrame;

/**
 *
 * @author Mazharul Islam
 */
public class searchMovie extends javax.swing.JFrame {

    /**
     * Creates new form searchMovie
     */
    public searchMovie() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchByName = new javax.swing.JButton();
        searchByGenre = new javax.swing.JButton();
        searchByDirector = new javax.swing.JButton();
        searchByRatings = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Movie");
        setBounds(new java.awt.Rectangle(650, 200, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchByName.setBackground(new java.awt.Color(51, 0, 51));
        searchByName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchByName.setForeground(new java.awt.Color(255, 255, 255));
        searchByName.setText("Search By Name");
        searchByName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameActionPerformed(evt);
            }
        });
        getContentPane().add(searchByName, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 146, 163, 51));

        searchByGenre.setBackground(new java.awt.Color(51, 0, 51));
        searchByGenre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchByGenre.setForeground(new java.awt.Color(255, 255, 255));
        searchByGenre.setText("Search By Genre");
        searchByGenre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchByGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByGenreActionPerformed(evt);
            }
        });
        getContentPane().add(searchByGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 224, 163, 51));

        searchByDirector.setBackground(new java.awt.Color(51, 0, 51));
        searchByDirector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchByDirector.setForeground(new java.awt.Color(255, 255, 255));
        searchByDirector.setText("Search By Director");
        searchByDirector.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchByDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByDirectorActionPerformed(evt);
            }
        });
        getContentPane().add(searchByDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 302, 160, 51));

        searchByRatings.setBackground(new java.awt.Color(51, 0, 51));
        searchByRatings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchByRatings.setForeground(new java.awt.Color(255, 255, 255));
        searchByRatings.setText("Search By Ratings");
        searchByRatings.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchByRatings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByRatingsActionPerformed(evt);
            }
        });
        getContentPane().add(searchByRatings, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 380, 163, 51));

        backButton.setBackground(new java.awt.Color(51, 0, 51));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-back-40.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 25, 58, 58));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/adminForm.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        new homePage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameActionPerformed
        new searchByName().setVisible(true);
    }//GEN-LAST:event_searchByNameActionPerformed

    private void searchByGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByGenreActionPerformed
        new searchByGenre().setVisible(true);
    }//GEN-LAST:event_searchByGenreActionPerformed

    private void searchByDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByDirectorActionPerformed
        new searchByDirector().setVisible(true);
    }//GEN-LAST:event_searchByDirectorActionPerformed

    private void searchByRatingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByRatingsActionPerformed
        new searchByRating().setVisible(true);
    }//GEN-LAST:event_searchByRatingsActionPerformed

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
            java.util.logging.Logger.getLogger(searchMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton searchByDirector;
    private javax.swing.JButton searchByGenre;
    private javax.swing.JButton searchByName;
    private javax.swing.JButton searchByRatings;
    // End of variables declaration//GEN-END:variables
}