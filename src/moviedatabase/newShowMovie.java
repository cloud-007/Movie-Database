/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mazharul Islam
 */
public class newShowMovie extends javax.swing.JFrame {

    private String s, curMovie, Review[];
    int reviewIndex;
    public static boolean ok;

    /**
     * Creates new form showMovie
     *
     * @param s
     */
    public newShowMovie(String s) {
        this.s = s;
        initComponents();
        this.setDesign(this.s);
        this.setReview();
        this.setCurrentReview(this.reviewIndex);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public newShowMovie() {
        initComponents();
        this.setDesign(this.s);
        this.setReview();
        this.setCurrentReview(this.reviewIndex);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    protected void setS(String s) {
        this.s = s;
    }

    private void setreviewIndex(int x) {
        this.reviewIndex = x;
    }

    private void setCurrentReview(int index) {
        if (index == -1) {
            this.setDefault();
        } else {
            this.movieReview.setText(Review[index]);
            this.movieReview.setEditable(false);
            this.anonymousNumber.setText("Anonymous : " + Integer.toString(this.reviewIndex + 1));
            this.anonymousNumber.setEditable(false);
        }
    }

    private void setReview() {
        String x = review.allReview(this.curMovie);
        if (x.length() == 0) {
            this.setreviewIndex(-1);
        } else {
            Review = x.split("\\,");
            this.setreviewIndex(0);
        }
    }

    private void setDefault() {
        this.anonymousNumber.setText("NullUser");
        this.anonymousNumber.setEditable(false);
        this.movieReview.setText("No review Found");
        this.movieReview.setEditable(false);
        this.reviewNext.setEnabled(false);
        this.reviewPrev.setEnabled(false);
    }

    private void setDesign(String s) {
        /// s = "DILWALE DULHANIA LE JAYENGE,ROMANCE,ADITYA CHOPRA,192,8.1,nothing";
        String temp[] = s.split(",");
        this.curMovie = temp[0];
        this.movieName.setText(temp[0]);
        this.movieGenre.setText(temp[1]);
        this.movieDirector.setText(temp[2]);
        this.movieLength.setText(temp[3]);
        this.movieRating.setText(temp[4]);
        this.movieName.setEditable(false);
        this.movieGenre.setEditable(false);
        this.movieDirector.setEditable(false);
        this.movieLength.setEditable(false);
        this.movieRating.setEditable(false);
        this.movieReview.setHorizontalAlignment(JTextField.CENTER);
        this.anonymousNumber.setHorizontalAlignment(JTextField.CENTER);

        Image img = imageGenerate.checkUrl(temp[5]);
        if (img != null) {
            img.getScaledInstance(this.imageHolder.getWidth(),
                    this.imageHolder.getHeight(), Image.SCALE_SMOOTH);
            this.imageHolder.setIcon(new ImageIcon(img));
        } else {
            Image image = new imageGenerate().getDefault();
            image.getScaledInstance(this.imageHolder.getWidth(),
                    this.imageHolder.getHeight(), Image.SCALE_SMOOTH);
            this.imageHolder.setIcon(new ImageIcon(image));
        }

        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        imageHolder = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        movieRating = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        movieDirector = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        movieLength = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        movieName = new javax.swing.JTextField();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        movieGenre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        reviewNext = new javax.swing.JButton();
        reviewPrev = new javax.swing.JButton();
        movieReview = new javax.swing.JTextField();
        anonymousNumber = new javax.swing.JTextField();
        addReviewButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/Background1.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setPreferredSize(new java.awt.Dimension(800, 600));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageHolder.setBackground(new java.awt.Color(255, 51, 102));
        getContentPane().add(imageHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 300, 370));

        playButton.setBackground(new java.awt.Color(51, 0, 51));
        playButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        playButton.setForeground(new java.awt.Color(255, 255, 255));
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-play-40.png"))); // NOI18N
        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 230, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Rating   :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 93, -1));

        movieRating.setBackground(new java.awt.Color(0, 0, 51));
        movieRating.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movieRating.setForeground(new java.awt.Color(255, 255, 255));
        movieRating.setMaximumSize(null);
        movieRating.setName(""); // NOI18N
        movieRating.setPreferredSize(new java.awt.Dimension(80, 30));
        getContentPane().add(movieRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 238, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Length   :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 93, -1));

        movieDirector.setBackground(new java.awt.Color(0, 0, 51));
        movieDirector.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movieDirector.setForeground(new java.awt.Color(255, 255, 255));
        movieDirector.setMaximumSize(null);
        movieDirector.setName(""); // NOI18N
        movieDirector.setPreferredSize(new java.awt.Dimension(80, 30));
        getContentPane().add(movieDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 238, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Director :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 93, -1));

        movieLength.setBackground(new java.awt.Color(0, 0, 51));
        movieLength.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movieLength.setForeground(new java.awt.Color(255, 255, 255));
        movieLength.setMaximumSize(null);
        movieLength.setName(""); // NOI18N
        movieLength.setPreferredSize(new java.awt.Dimension(80, 30));
        getContentPane().add(movieLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 238, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Genre     :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 93, -1));

        movieName.setBackground(new java.awt.Color(0, 0, 51));
        movieName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movieName.setForeground(new java.awt.Color(255, 255, 255));
        movieName.setMaximumSize(null);
        movieName.setName(""); // NOI18N
        movieName.setPreferredSize(new java.awt.Dimension(80, 30));
        movieName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieNameActionPerformed(evt);
            }
        });
        getContentPane().add(movieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 240, -1));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Name     : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 91, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Movie Details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 50, -1, -1));

        movieGenre.setBackground(new java.awt.Color(0, 0, 51));
        movieGenre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        movieGenre.setForeground(new java.awt.Color(255, 255, 255));
        movieGenre.setMaximumSize(null);
        movieGenre.setName(""); // NOI18N
        movieGenre.setPreferredSize(new java.awt.Dimension(80, 30));
        getContentPane().add(movieGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 238, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Movie Review");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 18, -1, -1));

        reviewNext.setBackground(new java.awt.Color(0, 51, 51));
        reviewNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-forward-button-40.png"))); // NOI18N
        reviewNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewNextActionPerformed(evt);
            }
        });
        jPanel1.add(reviewNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        reviewPrev.setBackground(new java.awt.Color(0, 51, 51));
        reviewPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-back-arrow-40.png"))); // NOI18N
        reviewPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewPrevActionPerformed(evt);
            }
        });
        jPanel1.add(reviewPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        movieReview.setBackground(new java.awt.Color(0, 51, 51));
        movieReview.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        movieReview.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(movieReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, 70));

        anonymousNumber.setBackground(new java.awt.Color(0, 51, 51));
        anonymousNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        anonymousNumber.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(anonymousNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 210, 220));

        addReviewButton.setBackground(new java.awt.Color(0, 0, 51));
        addReviewButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addReviewButton.setForeground(new java.awt.Color(255, 255, 255));
        addReviewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/icons8-ball-point-pen-30.png"))); // NOI18N
        addReviewButton.setText("Add Review");
        addReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReviewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addReviewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 190, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moviedatabase/Images/Background1.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Coming Soon...");
    }//GEN-LAST:event_playButtonActionPerformed

    private void movieNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieNameActionPerformed

    private void reviewNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewNextActionPerformed
        if (this.reviewIndex == -1) {
            this.reviewNext.setEnabled(false);
            this.reviewPrev.setEnabled(false);
        } else if (this.reviewIndex < Review.length - 1) {
            this.setreviewIndex(this.reviewIndex + 1);
            this.setCurrentReview(this.reviewIndex);
        } else {
            JOptionPane.showMessageDialog(null, "No more review!");
        }
    }//GEN-LAST:event_reviewNextActionPerformed

    private void reviewPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewPrevActionPerformed
        if (this.reviewIndex == -1) {
            this.reviewNext.setEnabled(false);
            this.reviewPrev.setEnabled(false);
        } else if (this.reviewIndex > 0) {
            this.setreviewIndex(this.reviewIndex - 1);
            this.setCurrentReview(this.reviewIndex);
        } else {
            JOptionPane.showMessageDialog(null, "No more review!");
        }
    }//GEN-LAST:event_reviewPrevActionPerformed

    private void addReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReviewButtonActionPerformed
        new addReview(this.curMovie).setVisible(true);
    }//GEN-LAST:event_addReviewButtonActionPerformed

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
            java.util.logging.Logger.getLogger(newShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newShowMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newShowMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReviewButton;
    private javax.swing.JTextField anonymousNumber;
    private javax.swing.JLabel imageHolder;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField movieDirector;
    private javax.swing.JTextField movieGenre;
    private javax.swing.JTextField movieLength;
    private javax.swing.JTextField movieName;
    private javax.swing.JTextField movieRating;
    private javax.swing.JTextField movieReview;
    private javax.swing.JButton playButton;
    private javax.swing.JButton reviewNext;
    private javax.swing.JButton reviewPrev;
    // End of variables declaration//GEN-END:variables
}
