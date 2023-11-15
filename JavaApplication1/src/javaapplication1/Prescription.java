package javaapplication1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class Prescription extends javax.swing.JFrame {

    public Prescription() {
        setUndecorated(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 480));
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(595, 430, 110, 22);

        PetName.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        PetName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PetName.setText("Name");
        PetName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(PetName);
        PetName.setBounds(20, 150, 130, 15);

        patAge.setText("year");
        getContentPane().add(patAge);
        patAge.setBounds(70, 180, 60, 16);

        jLabel2.setText("Age");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 180, 21, 16);

        jLabel3.setText("Gender");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 210, 50, 16);

        genderLevel.setText("Level");
        getContentPane().add(genderLevel);
        genderLevel.setBounds(80, 210, 70, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Date:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(560, 130, 40, 16);

        Date1.setText("Date from DataBase");
        getContentPane().add(Date1);
        Date1.setBounds(595, 130, 110, 16);

        DoctorName1.setFont(new java.awt.Font("Montserrat SemiBold", 1, 16)); // NOI18N
        DoctorName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DoctorName1.setText("Doctor Name");
        getContentPane().add(DoctorName1);
        DoctorName1.setBounds(470, 20, 240, 20);

        Doc_uni_data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Doc_uni_data.setText("Dhaka Medical Collage");
        getContentPane().add(Doc_uni_data);
        Doc_uni_data.setBounds(540, 60, 170, 16);

        doc_degi_data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        doc_degi_data.setText("General Surgen");
        getContentPane().add(doc_degi_data);
        doc_degi_data.setBounds(620, 40, 90, 16);

        Doc_mob_data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Doc_mob_data.setText("Mobile Number");
        getContentPane().add(Doc_mob_data);
        Doc_mob_data.setBounds(590, 80, 120, 16);

        problem12.setFont(new java.awt.Font("Montserrat Medium", 2, 12)); // NOI18N
        problem12.setText("Problem in Details");
        getContentPane().add(problem12);
        problem12.setBounds(200, 150, 500, 50);

        Doc_degree_data.setText("MBBS,");
        getContentPane().add(Doc_degree_data);
        Doc_degree_data.setBounds(520, 60, 50, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/prescription.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(720, 440));
        jLabel1.setMinimumSize(new java.awt.Dimension(720, 440));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //dispose();
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setJobName("Print Form");

    job.setPrintable(new Printable() {
        public int print(Graphics pg, PageFormat pf, int pageNum) {
            pf.setOrientation(PageFormat.LANDSCAPE);
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.47, 0.47);

            // Print the entire JFrame form
            JButton button = (JButton) evt.getSource();
            JPanel panel = (JPanel) button.getParent();
            panel.print(g2);

            return Printable.PAGE_EXISTS;

        }
    });

    boolean ok = job.printDialog();
    if (ok) {
        try {

            job.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }            
    }//GEN-LAST:event_jButton1ActionPerformed
   


    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel Date1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel Doc_degree_data = new javax.swing.JLabel();
    public static final transient javax.swing.JLabel Doc_mob_data = new javax.swing.JLabel();
    public static final transient javax.swing.JLabel Doc_uni_data = new javax.swing.JLabel();
    public static final javax.swing.JLabel DoctorName1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel PetName = new javax.swing.JLabel();
    public static final transient javax.swing.JLabel doc_degi_data = new javax.swing.JLabel();
    public static final javax.swing.JLabel genderLevel = new javax.swing.JLabel();
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static final javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel5;
    public static final javax.swing.JLabel patAge = new javax.swing.JLabel();
    public static final javax.swing.JLabel problem12 = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables

    private void print(PDPageContentStream contentStream) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
