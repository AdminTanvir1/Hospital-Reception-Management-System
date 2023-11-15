package javaapplication1;

import java.awt.Color;

public class Doc_popup extends javax.swing.JFrame {

    /**
     * Creates new form Doc_popup
     */
    public Doc_popup() {
        setUndecorated(true);
        initComponents();
        
        setBackground(new Color(0,0,0,98));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(29, 180, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        S_doc.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        S_doc.setForeground(new java.awt.Color(29, 180, 254));
        S_doc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S_doc.setText("Doctors Name");
        getContentPane().add(S_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 210, 29));

        S_desig.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        S_desig.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S_desig.setText("designation");
        getContentPane().add(S_desig, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 167, 29));

        S_degr.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        S_degr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S_degr.setText("Degree");
        getContentPane().add(S_degr, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 413, 167, 33));

        S_uni.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        S_uni.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S_uni.setText("University");
        getContentPane().add(S_uni, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 167, 34));

        S_num.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        S_num.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S_num.setText("Mobile Number");
        getContentPane().add(S_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 167, 38));

        S_img.setMaximumSize(new java.awt.Dimension(110, 110));
        S_img.setMinimumSize(new java.awt.Dimension(110, 110));
        S_img.setPreferredSize(new java.awt.Dimension(110, 110));
        getContentPane().add(S_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 110, 110));

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 40, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/All_Dashboard_Image/Doctor_pop-up.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 490, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Doc_popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doc_popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doc_popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doc_popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doc_popup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel S_degr = new javax.swing.JLabel();
    public static final javax.swing.JLabel S_desig = new javax.swing.JLabel();
    public static final javax.swing.JLabel S_doc = new javax.swing.JLabel();
    public static final javax.swing.JLabel S_img = new javax.swing.JLabel();
    public static final javax.swing.JLabel S_num = new javax.swing.JLabel();
    public static final javax.swing.JLabel S_uni = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    
}
