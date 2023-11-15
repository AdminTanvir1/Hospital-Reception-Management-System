package javaapplication1;
import java.awt.Color;
import static java.awt.Event.ENTER;
import java.awt.event.KeyEvent;
import java.sql.*;
import project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import static javaapplication1.Dashboard1.myimg;
import static javaapplication1.Dashboard1.loginName1;

import static javaapplication1.Doctor.My_Pic2;
import static javaapplication1.Doctor.My_Image2;



import static javaapplication1.Seat_Booking.My_Pic4;
import static javaapplication1.Seat_Booking.My_Name_Set4;

import static javaapplication1.Prescription_Find.My_Pic5;
import static javaapplication1.Prescription_Find.My_Name_Set5;

import static javaapplication1.Lab_Report.My_Pic6;
import static javaapplication1.Lab_Report.My_Name_Set6;

import static javaapplication1.MedicineInfo.My_Pic7;
import static javaapplication1.MedicineInfo.My_Name_Set7;

import static javaapplication1.Ambulance.My_Pic8;
import static javaapplication1.Ambulance.My_Name_Set8;
import static javaapplication1.Cart.Payment_from_Cart;

import static javaapplication1.Payment.My_Pic9;
import static javaapplication1.Payment.My_Name_Set9;
import static javaapplication1.Profile.set_from_myDatabase;

public class Patients_List extends javax.swing.JFrame {

    public Patients_List() {
        setUndecorated(true);
        initComponents();
        setDataToCard();
        
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           ResultSet rs = st.executeQuery("select * from patientinfo");
           ResultSetMetaData rsmd = rs.getMetaData();
           int n = rsmd.getColumnCount();
           DefaultTableModel dtm = (DefaultTableModel) Patient_Table.getModel();
           dtm.setRowCount(0);
           while(rs.next()){
               Vector v = new Vector();
               for(int i = 1; i <= n; i++){
                   v.add(rs.getString("Patient_Name"));
                   v.add(rs.getString("Mobile_Number"));
                   v.add(rs.getString("Age"));
                   v.add(rs.getString("Gender"));
                   v.add(rs.getString("Assign_Doctor"));
                   v.add(rs.getString("Appointment_Time"));
                   v.add(rs.getString("Problem_in_Details"));
               }
               dtm.addRow(v);
           }

        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
        
    }
    public void setDataToCard(){
       try{
    Connection conn = ConnectionProvider.getCon();
    Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

    ResultSet rs = st.executeQuery("select * from doctor_info");
    rs.last();
    numberOfDoctor.setText(Integer.toString(rs.getRow()));

    rs = st.executeQuery("select * from patientinfo");
    rs.last();
    numberOfPatient.setText(Integer.toString(rs.getRow()));

    rs = st.executeQuery("select * from lab_report");
    rs.last();
    numberOfReports.setText(Integer.toString(rs.getRow()));

    rs = st.executeQuery("select * from invoice");
    if (rs.next()) { // Check if there are rows in the result set
        String totalColumnName = rs.getMetaData().getColumnName(14);
        if (totalColumnName.contains("Total")) {
            String sqlQuery = "SELECT SUM(" + totalColumnName + ") FROM invoice";
            ResultSet sumResult = st.executeQuery(sqlQuery);
            if (sumResult.next()) { // Check if there is a result in the sum query
                int total = sumResult.getInt(1);
                TotalNumberOfMoney.setText(Integer.toString(total));
            }
        }
     }
       }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Close_Button = new javax.swing.JLabel();
        loginName3 = new javax.swing.JLabel();
        loginName4 = new javax.swing.JLabel();
        loginName5 = new javax.swing.JLabel();
        loginName6 = new javax.swing.JLabel();
        loginName7 = new javax.swing.JLabel();
        loginName8 = new javax.swing.JLabel();
        loginName9 = new javax.swing.JLabel();
        loginName = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        loginName2 = new javax.swing.JLabel();
        numberOfDoctor = new javax.swing.JLabel();
        numberOfPatient = new javax.swing.JLabel();
        numberOfReports = new javax.swing.JLabel();
        TotalNumberOfMoney = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        Patient_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient_Name", "Mobile_Number", "Age", "Gender", "Assign_Doctor", "Date", "Details"
            }
        ));
        jScrollPane1.setViewportView(Patient_Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 310, 840, 410);

        jButton1.setText("All List");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 480, 72, 23);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1264, 20, 30, 30);

        Close_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Close_ButtonMouseClicked(evt);
            }
        });
        getContentPane().add(Close_Button);
        Close_Button.setBounds(1300, 20, 30, 30);

        loginName3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName3.setForeground(new java.awt.Color(255, 255, 255));
        loginName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName3.setText("Doctors");
        loginName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName3MouseExited(evt);
            }
        });
        getContentPane().add(loginName3);
        loginName3.setBounds(100, 325, 120, 20);

        loginName4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName4.setForeground(new java.awt.Color(29, 180, 254));
        loginName4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName4.setText("Patients List");
        loginName4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName4MouseExited(evt);
            }
        });
        getContentPane().add(loginName4);
        loginName4.setBounds(100, 360, 120, 20);

        loginName5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName5.setForeground(new java.awt.Color(255, 255, 255));
        loginName5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName5.setText("Room / Seat");
        loginName5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName5MouseExited(evt);
            }
        });
        getContentPane().add(loginName5);
        loginName5.setBounds(100, 398, 120, 20);

        loginName6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName6.setForeground(new java.awt.Color(255, 255, 255));
        loginName6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName6.setText("Prescription");
        loginName6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName6MouseExited(evt);
            }
        });
        getContentPane().add(loginName6);
        loginName6.setBounds(100, 435, 120, 20);

        loginName7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName7.setForeground(new java.awt.Color(255, 255, 255));
        loginName7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName7.setText("Lab Reports");
        loginName7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName7MouseExited(evt);
            }
        });
        getContentPane().add(loginName7);
        loginName7.setBounds(100, 474, 120, 20);

        loginName8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName8.setForeground(new java.awt.Color(255, 255, 255));
        loginName8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName8.setText("Medicines");
        loginName8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName8MouseExited(evt);
            }
        });
        getContentPane().add(loginName8);
        loginName8.setBounds(100, 513, 120, 20);

        loginName9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName9.setForeground(new java.awt.Color(255, 255, 255));
        loginName9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName9.setText("Ambulances");
        loginName9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName9MouseExited(evt);
            }
        });
        getContentPane().add(loginName9);
        loginName9.setBounds(100, 552, 120, 20);

        loginName.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName.setForeground(new java.awt.Color(255, 255, 255));
        loginName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName.setText("Payments");
        loginName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginNameMouseExited(evt);
            }
        });
        getContentPane().add(loginName);
        loginName.setBounds(100, 590, 120, 20);

        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        getContentPane().add(Logout);
        Logout.setBounds(40, 670, 140, 20);

        loginName2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName2.setForeground(new java.awt.Color(255, 255, 255));
        loginName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName2.setText("Dashboard");
        loginName2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName2MouseExited(evt);
            }
        });
        getContentPane().add(loginName2);
        loginName2.setBounds(100, 287, 120, 20);

        numberOfDoctor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfDoctor.setText("10");
        getContentPane().add(numberOfDoctor);
        numberOfDoctor.setBounds(420, 168, 70, 80);

        numberOfPatient.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfPatient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfPatient.setText("23");
        getContentPane().add(numberOfPatient);
        numberOfPatient.setBounds(680, 168, 70, 80);

        numberOfReports.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfReports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfReports.setText("23");
        getContentPane().add(numberOfReports);
        numberOfReports.setBounds(940, 168, 70, 80);

        TotalNumberOfMoney.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalNumberOfMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalNumberOfMoney.setText("23");
        getContentPane().add(TotalNumberOfMoney);
        TotalNumberOfMoney.setBounds(1200, 168, 70, 80);

        My_Pic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/profileImages/tanvirImg.png"))); // NOI18N
        getContentPane().add(My_Pic3);
        My_Pic3.setBounds(76, 52, 110, 110);

        My_Name_Set3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        My_Name_Set3.setForeground(new java.awt.Color(29, 180, 254));
        My_Name_Set3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        My_Name_Set3.setText("Tanvir");
        getContentPane().add(My_Name_Set3);
        My_Name_Set3.setBounds(40, 180, 170, 30);

        jButton2.setBackground(new java.awt.Color(29, 180, 254));
        jButton2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 730, 190, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/All_Dashboard_Image/patients_png.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 770);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
        new Patients_List().setVisible(true);
        set_from_myDatabase.doClick();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Close_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close_ButtonMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Close_ButtonMouseClicked

    private void loginName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Doctor().setVisible(true);
        
        My_Pic2.setIcon(My_Pic3.getIcon());
My_Image2.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName3MouseClicked

    private void loginName3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseEntered
        // TODO add your handling code here:

        loginName3.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName3MouseEntered

    private void loginName3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseExited
        // TODO add your handling code here:
        loginName3.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName3MouseExited

    private void loginName4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseClicked
//
    }//GEN-LAST:event_loginName4MouseClicked

    private void loginName4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseEntered

    }//GEN-LAST:event_loginName4MouseEntered

    private void loginName4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseExited

    }//GEN-LAST:event_loginName4MouseExited

    private void loginName5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Seat_Booking().setVisible(true);
        My_Pic4.setIcon(My_Pic3.getIcon());
My_Name_Set4.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName5MouseClicked

    private void loginName5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseEntered
        // TODO add your handling code here:
        loginName5.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName5MouseEntered

    private void loginName5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseExited
        // TODO add your handling code here:
        loginName5.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName5MouseExited

    private void loginName6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName6MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Prescription_Find().setVisible(true);
        My_Pic5.setIcon(My_Pic3.getIcon());
My_Name_Set5.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName6MouseClicked

    private void loginName6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName6MouseEntered
        // TODO add your handling code here:
        loginName6.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName6MouseEntered

    private void loginName6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName6MouseExited
        // TODO add your handling code here:
        loginName6.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName6MouseExited

    private void loginName7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName7MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Lab_Report().setVisible(true);
        My_Pic6.setIcon(My_Pic3.getIcon());
My_Name_Set6.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName7MouseClicked

    private void loginName7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName7MouseEntered
        // TODO add your handling code here:
        loginName7.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName7MouseEntered

    private void loginName7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName7MouseExited
        // TODO add your handling code here:
        loginName7.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName7MouseExited

    private void loginName8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new MedicineInfo().setVisible(true);
        My_Pic7.setIcon(My_Pic3.getIcon());
My_Name_Set7.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName8MouseClicked

    private void loginName8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseEntered
        // TODO add your handling code here:
        loginName8.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName8MouseEntered

    private void loginName8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseExited
        // TODO add your handling code here:
        loginName8.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName8MouseExited

    private void loginName9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName9MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Ambulance().setVisible(true);
        My_Pic8.setIcon(My_Pic3.getIcon());
My_Name_Set8.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName9MouseClicked

    private void loginName9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName9MouseEntered
        // TODO add your handling code here:
        loginName9.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName9MouseEntered

    private void loginName9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName9MouseExited
        // TODO add your handling code here:
        loginName9.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName9MouseExited

    private void loginNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Payment().setVisible(true);
        My_Pic9.setIcon(My_Pic3.getIcon());
My_Name_Set9.setText(My_Name_Set3.getText());
Payment_from_Cart.doClick();
    }//GEN-LAST:event_loginNameMouseClicked

    private void loginNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseEntered
        // TODO add your handling code here:
        loginName.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginNameMouseEntered

    private void loginNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseExited
        // TODO add your handling code here:
        loginName.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginNameMouseExited

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutMouseClicked

    private void loginName2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Dashboard1().setVisible(true);
        myimg.setIcon(My_Pic3.getIcon());
loginName1.setText(My_Name_Set3.getText());
    }//GEN-LAST:event_loginName2MouseClicked

    private void loginName2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseEntered
        // TODO add your handling code here:
        loginName2.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName2MouseEntered

    private void loginName2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseExited
        // TODO add your handling code here:
        loginName2.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Dashboard1().setVisible(true);
        myimg.setIcon(My_Pic3.getIcon());
loginName1.setText(My_Name_Set3.getText());
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patients_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Close_Button;
    private javax.swing.JLabel Logout;
    public static final javax.swing.JLabel My_Name_Set3 = new javax.swing.JLabel();
    public static final javax.swing.JLabel My_Pic3 = new javax.swing.JLabel();
    public static final javax.swing.JTable Patient_Table = new javax.swing.JTable();
    private javax.swing.JLabel TotalNumberOfMoney;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loginName;
    private javax.swing.JLabel loginName2;
    private javax.swing.JLabel loginName3;
    private javax.swing.JLabel loginName4;
    private javax.swing.JLabel loginName5;
    private javax.swing.JLabel loginName6;
    private javax.swing.JLabel loginName7;
    private javax.swing.JLabel loginName8;
    private javax.swing.JLabel loginName9;
    private javax.swing.JLabel numberOfDoctor;
    private javax.swing.JLabel numberOfPatient;
    private javax.swing.JLabel numberOfReports;
    // End of variables declaration//GEN-END:variables
}
