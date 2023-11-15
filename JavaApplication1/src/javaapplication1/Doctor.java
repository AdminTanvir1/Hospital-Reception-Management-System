
package javaapplication1;

import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static javax.swing.text.html.HTML.Tag.OPTION;
import project.ConnectionProvider;
import static javaapplication1.Doc_popup.S_doc;
import static javaapplication1.Doc_popup.S_desig;
import static javaapplication1.Doc_popup.S_degr;
import static javaapplication1.Doc_popup.S_uni;
import static javaapplication1.Doc_popup.S_num;
import static javaapplication1.Doc_popup.S_img;
import static javaapplication1.Patients_List.Patient_Table;
import javax.swing.table.DefaultTableModel;

import static javaapplication1.Dashboard1.myimg;
import static javaapplication1.Dashboard1.loginName1;



import static javaapplication1.Patients_List.My_Pic3;
import static javaapplication1.Patients_List.My_Name_Set3;

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





public class Doctor extends javax.swing.JFrame {
    private String imagePath;
    public Doctor() {
        setUndecorated(true);
        initComponents();
        setDataToCard();
        find_Doctor.setVisible(false);
        Doc_Table.setVisible(false);
        
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           ResultSet rs = st.executeQuery("select * from doctor_info");
           ResultSetMetaData rsmd = rs.getMetaData();
           int n = rsmd.getColumnCount();
           DefaultTableModel dtm = (DefaultTableModel) Doc_Table.getModel();
           dtm.setRowCount(0);
           while(rs.next()){
               Vector v = new Vector();
               for(int i = 1; i <= n; i++){
                   v.add(rs.getString("name"));
                   v.add(rs.getString("number"));
                   v.add(rs.getString("designation"));
                   v.add(rs.getString("degree"));
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
    if (rs.next()) { 
        String totalColumnName = rs.getMetaData().getColumnName(14);
        if (totalColumnName.contains("Total")) {
            String sqlQuery = "SELECT SUM(" + totalColumnName + ") FROM invoice";
            ResultSet sumResult = st.executeQuery(sqlQuery);
            if (sumResult.next()) { 
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
    
    
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void setDoctorInfo(String name, String number, String designation, String degree, String university, String imagePath) {
    try {
        Connection con = ConnectionProvider.getCon();
        InputStream is = new FileInputStream(new File(imagePath));
        
        // Assuming 'image' is the BLOB column in your database
        PreparedStatement pst = con.prepareStatement("INSERT INTO doctor_info (name, number, designation, degree, university, image) VALUES (?, ?, ?, ?, ?, ?)");
        
        pst.setString(1, name);
        pst.setString(2, number);
        pst.setString(3, designation);
        pst.setString(4, degree);
        pst.setString(5, university);
        pst.setBlob(6, is);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data inserted successfully");
    } catch (SQLException ex) {
        Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_name = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_designation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Doc_Table = new javax.swing.JTable();
        Doc_University = new javax.swing.JTextField();
        Doc_Degree = new javax.swing.JTextField();
        select_image = new javax.swing.JButton();
        Doc_Image_Signup = new javax.swing.JLabel();
        find_Doctor = new javax.swing.JButton();
        newPatient = new javax.swing.JButton();
        bar1 = new javax.swing.JPanel();
        oldPatient = new javax.swing.JButton();
        bar2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        loginName2 = new javax.swing.JLabel();
        loginName4 = new javax.swing.JLabel();
        loginName5 = new javax.swing.JLabel();
        loginName6 = new javax.swing.JLabel();
        loginName7 = new javax.swing.JLabel();
        loginName8 = new javax.swing.JLabel();
        loginName9 = new javax.swing.JLabel();
        loginName = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        loginName11 = new javax.swing.JLabel();
        numberOfDoctor = new javax.swing.JLabel();
        numberOfPatient = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Close_Button = new javax.swing.JLabel();
        numberOfReports = new javax.swing.JLabel();
        TotalNumberOfMoney = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        txt_name.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctor's Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_name);
        txt_name.setBounds(410, 370, 280, 40);

        txt_phone.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mobile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        txt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneActionPerformed(evt);
            }
        });
        txt_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_phoneKeyTyped(evt);
            }
        });
        getContentPane().add(txt_phone);
        txt_phone.setBounds(410, 420, 280, 40);

        txt_designation.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Designation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(txt_designation);
        txt_designation.setBounds(410, 470, 280, 40);

        jButton1.setBackground(new java.awt.Color(29, 180, 254));
        jButton1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 700, 190, 30);

        My_Image2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        My_Image2.setForeground(new java.awt.Color(29, 180, 254));
        My_Image2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        My_Image2.setText("Tanvir");
        getContentPane().add(My_Image2);
        My_Image2.setBounds(40, 180, 170, 30);

        Doc_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Number", "Designation", "Degree"
            }
        ));
        jScrollPane1.setViewportView(Doc_Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(780, 310, 460, 400);

        Doc_University.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "University", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Doc_University.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Doc_UniversityActionPerformed(evt);
            }
        });
        getContentPane().add(Doc_University);
        Doc_University.setBounds(410, 570, 280, 40);

        Doc_Degree.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Degree", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(Doc_Degree);
        Doc_Degree.setBounds(410, 520, 280, 40);

        select_image.setText("Choose Image");
        select_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_imageActionPerformed(evt);
            }
        });
        getContentPane().add(select_image);
        select_image.setBounds(420, 650, 110, 23);
        getContentPane().add(Doc_Image_Signup);
        Doc_Image_Signup.setBounds(600, 610, 90, 90);

        find_Doctor.setBackground(new java.awt.Color(29, 180, 254));
        find_Doctor.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        find_Doctor.setForeground(new java.awt.Color(255, 255, 255));
        find_Doctor.setText("Find");
        find_Doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_DoctorActionPerformed(evt);
            }
        });
        getContentPane().add(find_Doctor);
        find_Doctor.setBounds(460, 720, 190, 30);

        newPatient.setBackground(new java.awt.Color(29, 180, 254));
        newPatient.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        newPatient.setForeground(new java.awt.Color(255, 255, 255));
        newPatient.setText("New Doctor");
        newPatient.setBorder(null);
        newPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newPatientMouseClicked(evt);
            }
        });
        newPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPatientActionPerformed(evt);
            }
        });
        newPatient.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                newPatientPropertyChange(evt);
            }
        });
        getContentPane().add(newPatient);
        newPatient.setBounds(400, 310, 110, 30);

        bar1.setBackground(new java.awt.Color(29, 180, 254));
        getContentPane().add(bar1);
        bar1.setBounds(400, 350, 110, 5);

        oldPatient.setBackground(new java.awt.Color(102, 102, 102));
        oldPatient.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        oldPatient.setForeground(new java.awt.Color(255, 255, 255));
        oldPatient.setText("Old Doctor");
        oldPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oldPatientMouseClicked(evt);
            }
        });
        oldPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPatientActionPerformed(evt);
            }
        });
        getContentPane().add(oldPatient);
        oldPatient.setBounds(600, 310, 110, 30);

        bar2.setBackground(new java.awt.Color(204, 204, 204));
        bar2.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(bar2);
        bar2.setBounds(600, 350, 110, 5);

        jButton2.setBackground(new java.awt.Color(29, 180, 254));
        jButton2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("List");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(970, 720, 190, 30);

        My_Pic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/profileImages/tanvirImg.png"))); // NOI18N
        getContentPane().add(My_Pic2);
        My_Pic2.setBounds(76, 52, 110, 110);

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

        loginName4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName4.setForeground(new java.awt.Color(255, 255, 255));
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

        loginName11.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName11.setForeground(new java.awt.Color(29, 180, 254));
        loginName11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName11.setText("Doctors");
        loginName11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName11MouseExited(evt);
            }
        });
        getContentPane().add(loginName11);
        loginName11.setBounds(100, 325, 120, 20);

        numberOfDoctor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfDoctor.setText("10");
        getContentPane().add(numberOfDoctor);
        numberOfDoctor.setBounds(420, 168, 70, 80);

        numberOfPatient.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfPatient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfPatient.setText("23");
        getContentPane().add(numberOfPatient);
        numberOfPatient.setBounds(678, 168, 70, 80);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Doctor_png.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setDoctorInfo(txt_name.getText(), txt_phone.getText(), txt_designation.getText(), Doc_Degree.getText(), Doc_University.getText(), imagePath);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Doc_UniversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Doc_UniversityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Doc_UniversityActionPerformed

    private void select_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_imageActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif");
        filechooser.setFileFilter(filter);
        int result = filechooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath(); // Set the imagePath
            Doc_Image_Signup.setIcon(ResizeImage(imagePath));
        }
    }//GEN-LAST:event_select_imageActionPerformed

    private void find_DoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_DoctorActionPerformed
        // TODO add your handling code here:
        String name = txt_name.getText();
        String number = txt_phone.getText();
        
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from doctor_info where name = '"+name+"' and number ='"+number+"'");
          
           if(rs.next())
           {
              
              new Doc_popup().setVisible(true);
              S_doc.setText(rs.getString(1)); 
              S_desig.setText(rs.getString(3));
              S_degr.setText(rs.getString(4));
              S_uni.setText(rs.getString(5));
              S_num.setText(rs.getString(2));
              
               Blob imageBlob = (Blob) rs.getBlob(6);

                if (imageBlob != null) {
                // Convert BLOB to byte array
                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                // Convert byte array to ImageIcon
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                S_img.setIcon(imageIcon);
               }
              
           }else
               
           JOptionPane.showMessageDialog(null,"No details found");
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }//GEN-LAST:event_find_DoctorActionPerformed

    private void newPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPatientMouseClicked
        // TODO add your handling code here:
        newPatient.setBackground(new Color(29,180,254));
        bar1.setBackground(new Color(29,180,254));

        oldPatient.setBackground(new Color(102,102,102));
        bar2.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_newPatientMouseClicked

    private void newPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientActionPerformed
        txt_designation.setVisible(true);
        Doc_Degree.setVisible(true);
        Doc_University.setVisible(true);
        select_image.setVisible(true);
        Doc_Image_Signup.setVisible(true);
        select_image.setVisible(true);
        jButton1.setVisible(true);
        
        find_Doctor.setVisible(false);
    }//GEN-LAST:event_newPatientActionPerformed

    private void newPatientPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_newPatientPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_newPatientPropertyChange

    private void oldPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldPatientMouseClicked
        // TODO add your handling code here:
        newPatient.setBackground(new Color(102,102,102));
        bar1.setBackground(new Color(102,102,102));

        oldPatient.setBackground(new Color(29,180,254));
        bar2.setBackground(new Color(29,180,254));
    }//GEN-LAST:event_oldPatientMouseClicked

    private void oldPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPatientActionPerformed
        // TODO add your handling code here:
        txt_designation.setVisible(false);
        Doc_Degree.setVisible(false);
        Doc_University.setVisible(false);

        select_image.setVisible(false);
        Doc_Image_Signup.setVisible(false);
        select_image.setVisible(false);
        jButton1.setVisible(false);
        
        find_Doctor.setVisible(true);

    }//GEN-LAST:event_oldPatientActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Doc_Table.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loginName4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseClicked
        setVisible(false);
        new Patients_List().setVisible(true);
        
        My_Pic3.setIcon(My_Pic2.getIcon());
My_Name_Set3.setText(My_Image2.getText());
    }//GEN-LAST:event_loginName4MouseClicked

    private void loginName4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseEntered
        // TODO add your handling code here:
        loginName4.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName4MouseEntered

    private void loginName4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseExited
        // TODO add your handling code here:
        loginName4.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName4MouseExited

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
        new Find_for_Prescription().setVisible(true);
        My_Pic5.setIcon(My_Pic2.getIcon());
My_Name_Set5.setText(My_Image2.getText());
        
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
        My_Pic6.setIcon(My_Pic2.getIcon());
My_Name_Set6.setText(My_Image2.getText());
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
        My_Pic7.setIcon(My_Pic2.getIcon());
My_Name_Set7.setText(My_Image2.getText());
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
        My_Pic8.setIcon(My_Pic2.getIcon());
My_Name_Set8.setText(My_Image2.getText());
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
        
        My_Pic9.setIcon(My_Pic2.getIcon());
My_Name_Set9.setText(My_Image2.getText());
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

    private void loginName11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName11MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_loginName11MouseClicked

    private void loginName11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName11MouseEntered
        
    }//GEN-LAST:event_loginName11MouseEntered

    private void loginName11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName11MouseExited
        
    }//GEN-LAST:event_loginName11MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
        new Doctor().setVisible(true);
        set_from_myDatabase.doClick();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Close_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close_ButtonMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Close_ButtonMouseClicked

    private void loginName2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseEntered
        // TODO add your handling code here:
        loginName2.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName2MouseEntered

    private void loginName2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseExited
        // TODO add your handling code here:
        loginName2.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName2MouseExited

    private void loginName2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Dashboard1().setVisible(true);
        myimg.setIcon(My_Pic2.getIcon());
loginName1.setText(My_Image2.getText());
    }//GEN-LAST:event_loginName2MouseClicked

    private void loginName5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Seat_Booking().setVisible(true);
        
        My_Pic4.setIcon(My_Pic2.getIcon());
My_Name_Set4.setText(My_Image2.getText());
    }//GEN-LAST:event_loginName5MouseClicked

    private void txt_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phoneKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_phoneKeyTyped
    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image image = MyImage.getImage();
        Image newImage = image.getScaledInstance(Doc_Image_Signup.getWidth(), Doc_Image_Signup.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(newImage);
        return resizedImage;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Close_Button;
    private javax.swing.JTextField Doc_Degree;
    private javax.swing.JLabel Doc_Image_Signup;
    private javax.swing.JTable Doc_Table;
    private javax.swing.JTextField Doc_University;
    private javax.swing.JLabel Logout;
    public static final javax.swing.JLabel My_Image2 = new javax.swing.JLabel();
    public static final javax.swing.JLabel My_Pic2 = new javax.swing.JLabel();
    private javax.swing.JLabel TotalNumberOfMoney;
    private javax.swing.JPanel bar1;
    private javax.swing.JPanel bar2;
    private javax.swing.JButton find_Doctor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loginName;
    private javax.swing.JLabel loginName11;
    private javax.swing.JLabel loginName2;
    private javax.swing.JLabel loginName4;
    private javax.swing.JLabel loginName5;
    private javax.swing.JLabel loginName6;
    private javax.swing.JLabel loginName7;
    private javax.swing.JLabel loginName8;
    private javax.swing.JLabel loginName9;
    private javax.swing.JButton newPatient;
    private javax.swing.JLabel numberOfDoctor;
    private javax.swing.JLabel numberOfPatient;
    private javax.swing.JLabel numberOfReports;
    private javax.swing.JButton oldPatient;
    private javax.swing.JButton select_image;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
