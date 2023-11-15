/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication1.Dashboard1.DocCombo;
import javax.swing.JOptionPane;
import project.ConnectionProvider;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import static javaapplication1.Cart.Price2;

import static javaapplication1.Dashboard1.myimg;
import static javaapplication1.Dashboard1.loginName1;

import static javaapplication1.Doctor.My_Pic2;
import static javaapplication1.Doctor.My_Image2;

import static javaapplication1.Patients_List.My_Pic3;
import static javaapplication1.Patients_List.My_Name_Set3;

import static javaapplication1.Seat_Booking.My_Pic4;
import static javaapplication1.Seat_Booking.My_Name_Set4;

import static javaapplication1.Prescription_Find.My_Pic5;
import static javaapplication1.Prescription_Find.My_Name_Set5;

import static javaapplication1.Lab_Report.My_Pic6;
import static javaapplication1.Lab_Report.My_Name_Set6;



import static javaapplication1.Ambulance.My_Pic8;
import static javaapplication1.Ambulance.My_Name_Set8;
import static javaapplication1.Cart.Payment_from_Cart;

import static javaapplication1.Payment.My_Pic9;
import static javaapplication1.Payment.My_Name_Set9;
import static javaapplication1.Profile.set_from_myDatabase;

/**
 *
 * @author Tanvir
 */
public class MedicineInfo extends javax.swing.JFrame {

    /**
     * Creates new form MedicineInfo
     */
    public MedicineInfo() {
        initComponents();
        setDataToCard();
        UpdateCombo();
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
    
    public void UpdateCombo(){
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from medicine_info");
          
           while(rs.next())
           {
              mediCombo.addItem(rs.getString(1));
           }
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }
    public void MyTimer() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            // Show the pop-up text here.
            JOptionPane.showMessageDialog(null, "This is the pop-up text.");
        }
    }, 10000); 
   
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginName2 = new javax.swing.JLabel();
        loginName3 = new javax.swing.JLabel();
        loginName4 = new javax.swing.JLabel();
        loginName5 = new javax.swing.JLabel();
        loginName6 = new javax.swing.JLabel();
        loginName7 = new javax.swing.JLabel();
        loginName8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Close_Button = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        loginName10 = new javax.swing.JLabel();
        medi_name = new javax.swing.JTextField();
        medi_manu_date = new javax.swing.JTextField();
        medi_exp_date = new javax.swing.JTextField();
        medi_set_stock = new javax.swing.JTextField();
        medi_per_price = new javax.swing.JTextField();
        add_medi_info = new javax.swing.JButton();
        mediCombo = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        medi_price_get = new javax.swing.JTextField();
        numberOfDoctor = new javax.swing.JLabel();
        numberOfPatient = new javax.swing.JLabel();
        numberOfReports = new javax.swing.JLabel();
        TotalNumberOfMoney = new javax.swing.JLabel();
        loginName15 = new javax.swing.JLabel();
        loginName17 = new javax.swing.JLabel();
        loginName18 = new javax.swing.JLabel();
        loginName19 = new javax.swing.JLabel();
        loginName20 = new javax.swing.JLabel();
        loginName21 = new javax.swing.JLabel();
        loginName9 = new javax.swing.JLabel();
        loginName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        loginName2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName2.setForeground(new java.awt.Color(29, 180, 254));
        loginName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName2.setText("Dashboard");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(null);

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

        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        getContentPane().add(Logout);
        Logout.setBounds(40, 670, 140, 20);

        loginName10.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName10.setForeground(new java.awt.Color(255, 255, 255));
        loginName10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName10.setText("Dashboard");
        loginName10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName10MouseExited(evt);
            }
        });
        getContentPane().add(loginName10);
        loginName10.setBounds(100, 287, 120, 20);

        medi_name.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Medicine Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(medi_name);
        medi_name.setBounds(960, 410, 280, 40);

        medi_manu_date.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Manufacture Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        medi_manu_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medi_manu_dateActionPerformed(evt);
            }
        });
        getContentPane().add(medi_manu_date);
        medi_manu_date.setBounds(960, 460, 280, 40);

        medi_exp_date.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Expire Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(medi_exp_date);
        medi_exp_date.setBounds(960, 510, 280, 40);

        medi_set_stock.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        medi_set_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                medi_set_stockKeyTyped(evt);
            }
        });
        getContentPane().add(medi_set_stock);
        medi_set_stock.setBounds(960, 560, 280, 40);

        medi_per_price.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Price per Medicine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        medi_per_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                medi_per_priceKeyTyped(evt);
            }
        });
        getContentPane().add(medi_per_price);
        medi_per_price.setBounds(960, 610, 280, 40);

        add_medi_info.setBackground(new java.awt.Color(29, 180, 254));
        add_medi_info.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        add_medi_info.setForeground(new java.awt.Color(255, 255, 255));
        add_medi_info.setText("Store");
        add_medi_info.setBorder(null);
        add_medi_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_medi_infoActionPerformed(evt);
            }
        });
        getContentPane().add(add_medi_info);
        add_medi_info.setBounds(1010, 690, 190, 30);

        getContentPane().add(mediCombo);
        mediCombo.setBounds(450, 410, 280, 30);

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Number of Medicine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)));
        getContentPane().add(jTextField7);
        jTextField7.setBounds(450, 460, 280, 40);

        jButton4.setBackground(new java.awt.Color(29, 180, 254));
        jButton4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add to Cart");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(500, 690, 190, 30);

        medi_price_get.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        medi_price_get.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                medi_price_getKeyTyped(evt);
            }
        });
        getContentPane().add(medi_price_get);
        medi_price_get.setBounds(450, 510, 280, 40);

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

        loginName15.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName15.setForeground(new java.awt.Color(255, 255, 255));
        loginName15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName15.setText("Doctors");
        loginName15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName15MouseExited(evt);
            }
        });
        getContentPane().add(loginName15);
        loginName15.setBounds(100, 325, 120, 20);

        loginName17.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName17.setForeground(new java.awt.Color(255, 255, 255));
        loginName17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName17.setText("Patients List");
        loginName17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName17MouseExited(evt);
            }
        });
        getContentPane().add(loginName17);
        loginName17.setBounds(100, 360, 120, 20);

        loginName18.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName18.setForeground(new java.awt.Color(255, 255, 255));
        loginName18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName18.setText("Room / Seat");
        loginName18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName18MouseExited(evt);
            }
        });
        getContentPane().add(loginName18);
        loginName18.setBounds(100, 398, 120, 20);

        loginName19.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName19.setForeground(new java.awt.Color(255, 255, 255));
        loginName19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName19.setText("Prescription");
        loginName19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName19MouseExited(evt);
            }
        });
        getContentPane().add(loginName19);
        loginName19.setBounds(100, 435, 120, 20);

        loginName20.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName20.setForeground(new java.awt.Color(255, 255, 255));
        loginName20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName20.setText("Lab Reports");
        loginName20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName20MouseExited(evt);
            }
        });
        getContentPane().add(loginName20);
        loginName20.setBounds(100, 474, 120, 20);

        loginName21.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName21.setForeground(new java.awt.Color(29, 180, 254));
        loginName21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName21.setText("Medicines");
        loginName21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName21MouseExited(evt);
            }
        });
        getContentPane().add(loginName21);
        loginName21.setBounds(100, 513, 120, 20);

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

        My_Pic7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/profileImages/tanvirImg.png"))); // NOI18N
        getContentPane().add(My_Pic7);
        My_Pic7.setBounds(76, 52, 110, 110);

        My_Name_Set7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        My_Name_Set7.setForeground(new java.awt.Color(29, 180, 254));
        My_Name_Set7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        My_Name_Set7.setText("Name");
        getContentPane().add(My_Name_Set7);
        My_Name_Set7.setBounds(40, 180, 170, 30);

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sell Medicine");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(500, 340, 140, 40);

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Medicine");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(990, 340, 140, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/All_Dashboard_Image/Medicine_png.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Doctor().setVisible(true);
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
        setVisible(false);
        new Patients_List().setVisible(true);
    }//GEN-LAST:event_loginName4MouseClicked

    private void loginName4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseEntered
        // TODO add your handling code here:
        loginName4.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName4MouseEntered

    private void loginName4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseExited
        // TODO add your handling code here:
        loginName4.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName4MouseExited

    private void loginName5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Seat_Booking().setVisible(true);
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
    }//GEN-LAST:event_loginName8MouseClicked

    private void loginName8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseEntered
        // TODO add your handling code here:
        loginName8.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName8MouseEntered

    private void loginName8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseExited
        // TODO add your handling code here:
        loginName8.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName8MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
        new MedicineInfo().setVisible(true);
        set_from_myDatabase.doClick();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Close_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close_ButtonMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Close_ButtonMouseClicked

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutMouseClicked

    private void loginName10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName10MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Dashboard1().setVisible(true);
        myimg.setIcon(My_Pic7.getIcon());
loginName1.setText(My_Name_Set7.getText());
    }//GEN-LAST:event_loginName10MouseClicked

    private void loginName10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName10MouseEntered
        // TODO add your handling code here:
        loginName10.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName10MouseEntered

    private void loginName10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName10MouseExited
         // TODO add your handling code here:
         loginName10.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName10MouseExited

    private void medi_manu_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medi_manu_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medi_manu_dateActionPerformed

    private void add_medi_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_medi_infoActionPerformed

            // TODO add your handling code here:
            String Medicine_Name = medi_name.getText();
            String Manufacture = medi_manu_date.getText();
            String Expire = medi_exp_date.getText();
            String Stock = medi_set_stock.getText();
            String Price = medi_per_price.getText();
            if(Medicine_Name.equals("")|| Manufacture.equals("")||Expire.equals("")||Stock.equals("")||Price.equals(""))
            JOptionPane.showMessageDialog(null,"Every Field Is Required!");
        else{
           try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate("Insert into medicine_info value('"+Medicine_Name+"','"+Manufacture+"','"+Expire+"','"+Stock+"','"+Price+"')");
            JOptionPane.showMessageDialog(null,"Medicine Added Successfully!");
            //setVisible(false);
            //new Login().setVisible(true);
            }
        
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
        } 
        }
        
    }//GEN-LAST:event_add_medi_infoActionPerformed


    // Check if the cart JFrame is visible
    
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String Medicine_Price1 = medi_price_get.getText();

        Price2.setText(Medicine_Price1);
        JOptionPane.showMessageDialog(null,"Add to Cart Successfully!");
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void loginName15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName15MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Doctor().setVisible(true);
        My_Pic2.setIcon(My_Pic7.getIcon());
My_Image2.setText(My_Name_Set6.getText());
    }//GEN-LAST:event_loginName15MouseClicked

    private void loginName15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName15MouseEntered
        // TODO add your handling code here:

        loginName15.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName15MouseEntered

    private void loginName15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName15MouseExited
        // TODO add your handling code here:
        loginName15.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName15MouseExited

    private void loginName17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName17MouseClicked
        setVisible(false);
        new Patients_List().setVisible(true);
        My_Pic3.setIcon(My_Pic7.getIcon());
My_Name_Set3.setText(My_Name_Set7.getText());
    }//GEN-LAST:event_loginName17MouseClicked

    private void loginName17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName17MouseEntered
        // TODO add your handling code here:
        loginName17.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName17MouseEntered

    private void loginName17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName17MouseExited
        // TODO add your handling code here:
        loginName17.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName17MouseExited

    private void loginName18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName18MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Seat_Booking().setVisible(true);
        My_Pic4.setIcon(My_Pic7.getIcon());
My_Name_Set4.setText(My_Name_Set7.getText());
    }//GEN-LAST:event_loginName18MouseClicked

    private void loginName18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName18MouseEntered
        // TODO add your handling code here:
        loginName18.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName18MouseEntered

    private void loginName18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName18MouseExited
        // TODO add your handling code here:
        loginName18.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName18MouseExited

    private void loginName19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName19MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Prescription_Find().setVisible(true);
        My_Pic5.setIcon(My_Pic7.getIcon());
My_Name_Set5.setText(My_Name_Set7.getText());
    }//GEN-LAST:event_loginName19MouseClicked

    private void loginName19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName19MouseEntered
        // TODO add your handling code here:
        loginName19.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName19MouseEntered

    private void loginName19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName19MouseExited
        // TODO add your handling code here:
        loginName19.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName19MouseExited

    private void loginName20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName20MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Lab_Report().setVisible(true);
        My_Pic6.setIcon(My_Pic7.getIcon());
My_Name_Set6.setText(My_Name_Set7.getText());
    }//GEN-LAST:event_loginName20MouseClicked

    private void loginName20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName20MouseEntered
        // TODO add your handling code here:
        loginName20.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName20MouseEntered

    private void loginName20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName20MouseExited
        // TODO add your handling code here:
        loginName20.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName20MouseExited

    private void loginName21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName21MouseClicked

    }//GEN-LAST:event_loginName21MouseClicked

    private void loginName21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName21MouseEntered

    }//GEN-LAST:event_loginName21MouseEntered

    private void loginName21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName21MouseExited

    }//GEN-LAST:event_loginName21MouseExited

    private void loginName9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName9MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Ambulance().setVisible(true);
        My_Pic8.setIcon(My_Pic7.getIcon());
My_Name_Set8.setText(My_Name_Set7.getText());
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
        My_Pic9.setIcon(My_Pic7.getIcon());
My_Name_Set9.setText(My_Name_Set7.getText());
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

    private void medi_set_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medi_set_stockKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_medi_set_stockKeyTyped

    private void medi_per_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medi_per_priceKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_medi_per_priceKeyTyped

    private void medi_price_getKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medi_price_getKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_medi_price_getKeyTyped

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
            java.util.logging.Logger.getLogger(MedicineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicineInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Close_Button;
    private javax.swing.JLabel Logout;
    public static final javax.swing.JLabel My_Name_Set7 = new javax.swing.JLabel();
    public static final javax.swing.JLabel My_Pic7 = new javax.swing.JLabel();
    private javax.swing.JLabel TotalNumberOfMoney;
    private javax.swing.JButton add_medi_info;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel loginName;
    private javax.swing.JLabel loginName10;
    private javax.swing.JLabel loginName15;
    private javax.swing.JLabel loginName17;
    private javax.swing.JLabel loginName18;
    private javax.swing.JLabel loginName19;
    private javax.swing.JLabel loginName2;
    private javax.swing.JLabel loginName20;
    private javax.swing.JLabel loginName21;
    private javax.swing.JLabel loginName3;
    private javax.swing.JLabel loginName4;
    private javax.swing.JLabel loginName5;
    private javax.swing.JLabel loginName6;
    private javax.swing.JLabel loginName7;
    private javax.swing.JLabel loginName8;
    private javax.swing.JLabel loginName9;
    private javax.swing.JComboBox<String> mediCombo;
    private javax.swing.JTextField medi_exp_date;
    private javax.swing.JTextField medi_manu_date;
    private javax.swing.JTextField medi_name;
    private javax.swing.JTextField medi_per_price;
    private javax.swing.JTextField medi_price_get;
    private javax.swing.JTextField medi_set_stock;
    private javax.swing.JLabel numberOfDoctor;
    private javax.swing.JLabel numberOfPatient;
    private javax.swing.JLabel numberOfReports;
    // End of variables declaration//GEN-END:variables
}
