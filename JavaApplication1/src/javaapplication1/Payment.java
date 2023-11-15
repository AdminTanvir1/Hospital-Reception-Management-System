
package javaapplication1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import static javaapplication1.Cart.Price1;
import static javaapplication1.Cart.Price2;
import static javaapplication1.Cart.Price3;
import static javaapplication1.Cart.Price44;
import static javaapplication1.Invoice.Invoice_name;
import static javaapplication1.Invoice.Invoice_mobile;
import static javaapplication1.Invoice.Invoice_email;
import static javaapplication1.Invoice.Invoice_address;
import static javaapplication1.Invoice.Invoice_Invoice_Id;
import static javaapplication1.Invoice.Invoice_date;
import static javaapplication1.Invoice.Invoice_Price1;
import static javaapplication1.Invoice.Invoice_Price2;
import static javaapplication1.Invoice.Invoice_Price3;
import static javaapplication1.Invoice.Invoice_Price4;
import static javaapplication1.Invoice.Invoice_SubTotal;
import static javaapplication1.Invoice.Invoice_Tax;
import static javaapplication1.Invoice.Invoice_Total;
import static javaapplication1.Invoice.Invoice_Discount;
import static javaapplication1.Invoice.Invoice_Admin;
import static javaapplication1.Invoice.Invoice_PaymentWay;
import static javaapplication1.Invoice.print_invoice;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import project.ConnectionProvider;

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

import static javaapplication1.MedicineInfo.My_Pic7;
import static javaapplication1.MedicineInfo.My_Name_Set7;

import static javaapplication1.Ambulance.My_Pic8;
import static javaapplication1.Ambulance.My_Name_Set8;
import static javaapplication1.Cart.Clear_My_Cart;
import static javaapplication1.Cart.Payment_from_Cart;
import static javaapplication1.Profile.set_from_myDatabase;

/**
 *
 * @author Tanvir
 */
public class Payment extends javax.swing.JFrame {

    /**
     * Creates new form Payment
     */
    public Payment() {
        initComponents();
        setDataToCard();
        curDateTime();
        randomnumbers();
        No_items();
        Admin_Name.setText(My_Name_Set9.getText());
        
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
    
    
    
    
    public void No_items(){
        
              deicount_set.setVisible(false);
              getName.setVisible(false);
              Discount.setVisible(false);
              SubTotal.setVisible(false);
              Tax.setVisible(false);
              Total_Sum.setVisible(false);
              Address_12.setVisible(false);
              Email_12.setVisible(false);
              PayBox.setVisible(false);
              Pay_img.setVisible(false);
              jTextField6.setVisible(false);
              jButton2.setVisible(false);
              MyDate.setVisible(false);
              jLabel3.setVisible(false);
              Invoice_Num.setVisible(false);
              Admin_Name.setVisible(false);          
    }
    public void Yes_items(){
              deicount_set.setVisible(true);
              getName.setVisible(true);
              Discount.setVisible(true);
              SubTotal.setVisible(true);
              Tax.setVisible(true);
              Total_Sum.setVisible(true);
              Address_12.setVisible(true);
              Email_12.setVisible(true);
              PayBox.setVisible(true);
              Pay_img.setVisible(true);
              jTextField6.setVisible(true);
              jButton2.setVisible(true);
              MyDate.setVisible(true);
              jLabel3.setVisible(true);
              Invoice_Num.setVisible(true);
              Admin_Name.setVisible(true);          
    }
    
    public void calculation() {

  int discount = Integer.parseInt(Discount.getText());
  int tax = Integer.parseInt(Tax.getText());

  // Typecast the strings to integers
  int pay1 = Integer.parseInt(Pay1.getText());
  int pay2 = Integer.parseInt(Pay2.getText());
  int pay3 = Integer.parseInt(Pay3.getText());
  int pay4 = Integer.parseInt(Pay4.getText());

  // Calculate the subtotal
  int subtotal = pay1 + pay2 + pay3 + pay4 - discount;

  int taxAmount = subtotal * tax / 100;

  // Calculate the total sum
  int totalSum = subtotal  + taxAmount;

  // Set the SubTotal text field to the sum
  SubTotal.setText(String.valueOf(subtotal));

  // Set the Total Sum text field to the sum
  Total_Sum.setText(String.valueOf(totalSum));
}

    public void curDateTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    MyDate.setText (dtf.format (now));
    }
    
    public void randomnumbers(){
    Random ran = new Random();
    int n=ran.nextInt (1000000)+1;
    String val = String.valueOf(n);
    Invoice_Num.setText (val);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Close_Button = new javax.swing.JLabel();
        Logout1 = new javax.swing.JLabel();
        loginName2 = new javax.swing.JLabel();
        loginName3 = new javax.swing.JLabel();
        loginName4 = new javax.swing.JLabel();
        loginName5 = new javax.swing.JLabel();
        loginName6 = new javax.swing.JLabel();
        loginName7 = new javax.swing.JLabel();
        loginName8 = new javax.swing.JLabel();
        loginName9 = new javax.swing.JLabel();
        loginName = new javax.swing.JLabel();
        getName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Matc_Mobile = new javax.swing.JTextField();
        Address_12 = new javax.swing.JTextField();
        Email_12 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        PayBox = new javax.swing.JComboBox<>();
        SubTotal = new javax.swing.JTextField();
        Total_Sum = new javax.swing.JTextField();
        Tax = new javax.swing.JTextField();
        Pay_img = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        MyDate = new javax.swing.JLabel();
        Invoice_Num = new javax.swing.JLabel();
        Admin_Name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Discount = new javax.swing.JTextField();
        numberOfDoctor = new javax.swing.JLabel();
        numberOfPatient = new javax.swing.JLabel();
        numberOfReports = new javax.swing.JLabel();
        TotalNumberOfMoney = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        gender1 = new javax.swing.JLabel();
        deicount_set = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(null);

        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        getContentPane().add(Logout);
        Logout.setBounds(40, 670, 140, 20);

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

        Logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Logout1MouseClicked(evt);
            }
        });
        getContentPane().add(Logout1);
        Logout1.setBounds(40, 670, 140, 20);

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

        loginName.setBackground(new java.awt.Color(255, 255, 255));
        loginName.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        loginName.setForeground(new java.awt.Color(29, 180, 254));
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

        Pay1.setEditable(false);
        Pay1.setBackground(new java.awt.Color(255, 255, 255));
        Pay1.setText("00");
        Pay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pay1ActionPerformed(evt);
            }
        });
        getContentPane().add(Pay1);
        Pay1.setBounds(600, 420, 100, 22);

        Pay2.setEditable(false);
        Pay2.setBackground(new java.awt.Color(255, 255, 255));
        Pay2.setText("00");
        getContentPane().add(Pay2);
        Pay2.setBounds(600, 460, 100, 22);

        Pay3.setEditable(false);
        Pay3.setBackground(new java.awt.Color(255, 255, 255));
        Pay3.setText("00");
        getContentPane().add(Pay3);
        Pay3.setBounds(600, 500, 100, 22);

        Pay4.setEditable(false);
        Pay4.setBackground(new java.awt.Color(255, 255, 255));
        Pay4.setText("00");
        getContentPane().add(Pay4);
        Pay4.setBounds(600, 540, 100, 22);

        getName.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        getName.setForeground(new java.awt.Color(29, 180, 254));
        getName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(getName);
        getName.setBounds(450, 320, 250, 30);

        jButton1.setBackground(new java.awt.Color(29, 180, 254));
        jButton1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Continue");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 720, 160, 30);

        Matc_Mobile.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Enter Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Matc_Mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Matc_MobileActionPerformed(evt);
            }
        });
        Matc_Mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Matc_MobileKeyTyped(evt);
            }
        });
        getContentPane().add(Matc_Mobile);
        Matc_Mobile.setBounds(450, 360, 250, 40);

        Address_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Set Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(Address_12);
        Address_12.setBounds(810, 320, 250, 40);

        Email_12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Set Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(Email_12);
        Email_12.setBounds(810, 360, 250, 40);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(850, 610, 170, 50);

        PayBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Bkash", "Card" }));
        PayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayBoxActionPerformed(evt);
            }
        });
        getContentPane().add(PayBox);
        PayBox.setBounds(810, 420, 250, 40);

        SubTotal.setEditable(false);
        SubTotal.setText("00");
        SubTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sub-Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(SubTotal);
        SubTotal.setBounds(460, 650, 80, 40);

        Total_Sum.setEditable(false);
        Total_Sum.setText("00");
        Total_Sum.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Total_Sum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_SumActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Sum);
        Total_Sum.setBounds(620, 650, 80, 40);

        Tax.setText("2");
        Tax.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tax %", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(Tax);
        Tax.setBounds(540, 650, 80, 40);

        Pay_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/profileImages/Cas_pay.png"))); // NOI18N
        getContentPane().add(Pay_img);
        Pay_img.setBounds(810, 490, 250, 210);

        jButton2.setBackground(new java.awt.Color(29, 180, 254));
        jButton2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Make Payment");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(850, 720, 190, 30);

        MyDate.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        MyDate.setText("Date Time");
        getContentPane().add(MyDate);
        MyDate.setBounds(1100, 320, 170, 30);

        Invoice_Num.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        Invoice_Num.setText("Invoice Number");
        getContentPane().add(Invoice_Num);
        Invoice_Num.setBounds(1180, 360, 120, 30);

        Admin_Name.setEditable(false);
        Admin_Name.setText("Tanvir");
        Admin_Name.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Receaptionist"));
        Admin_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admin_NameActionPerformed(evt);
            }
        });
        getContentPane().add(Admin_Name);
        Admin_Name.setBounds(1140, 710, 150, 40);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jLabel3.setText("Invoice No:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1100, 360, 70, 30);

        Discount.setText("00");
        getContentPane().add(Discount);
        Discount.setBounds(600, 580, 100, 22);

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

        My_Pic9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/profileImages/tanvirImg.png"))); // NOI18N
        getContentPane().add(My_Pic9);
        My_Pic9.setBounds(76, 52, 110, 110);

        My_Name_Set9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        My_Name_Set9.setForeground(new java.awt.Color(29, 180, 254));
        My_Name_Set9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        My_Name_Set9.setText("Name");
        getContentPane().add(My_Name_Set9);
        My_Name_Set9.setBounds(40, 180, 170, 30);

        jButton3.setBackground(new java.awt.Color(29, 180, 254));
        jButton3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Clear");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(630, 720, 80, 30);

        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel9.setText("Seat Rent:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(450, 420, 120, 18);

        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel10.setText("Doctor's Fee:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(450, 460, 160, 17);

        age1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        age1.setText("Medicine Cost:");
        getContentPane().add(age1);
        age1.setBounds(450, 500, 120, 16);

        gender1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        gender1.setText("Report Fee:");
        getContentPane().add(gender1);
        gender1.setBounds(450, 540, 120, 16);

        deicount_set.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        deicount_set.setForeground(new java.awt.Color(255, 51, 51));
        deicount_set.setText("Discount");
        getContentPane().add(deicount_set);
        deicount_set.setBounds(450, 580, 160, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/All_Dashboard_Image/Payment_png.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
        new Payment().setVisible(true);
        set_from_myDatabase.doClick();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Close_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close_ButtonMouseClicked
        // TODO add your handling code here:
        dispose();
        paymentFrame.dispose();
    }//GEN-LAST:event_Close_ButtonMouseClicked

    private void Logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logout1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_Logout1MouseClicked

    private void loginName2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Dashboard1().setVisible(true);
        myimg.setIcon(My_Pic9.getIcon());
loginName1.setText(My_Name_Set9.getText());
    }//GEN-LAST:event_loginName2MouseClicked

    private void loginName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Doctor().setVisible(true);
        My_Pic2.setIcon(My_Pic9.getIcon());
My_Image2.setText(My_Name_Set9.getText());

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
        My_Pic3.setIcon(My_Pic9.getIcon());
My_Name_Set3.setText(My_Name_Set9.getText());
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
        My_Pic4.setIcon(My_Pic9.getIcon());
My_Name_Set4.setText(My_Name_Set9.getText());
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
        My_Pic5.setIcon(My_Pic9.getIcon());
My_Name_Set5.setText(My_Name_Set9.getText());
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
        My_Pic6.setIcon(My_Pic9.getIcon());
My_Name_Set6.setText(My_Name_Set9.getText());
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
        My_Pic7.setIcon(My_Pic9.getIcon());
My_Name_Set7.setText(My_Name_Set9.getText());
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
        My_Pic8.setIcon(My_Pic9.getIcon());
My_Name_Set8.setText(My_Name_Set9.getText());
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

    }//GEN-LAST:event_loginNameMouseClicked

    private void loginNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseEntered
        // TODO add your handling code here:
        loginName.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginNameMouseEntered

    private void loginNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseExited
        // TODO add your handling code here:
        loginName.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginNameMouseExited

    private void Pay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pay1ActionPerformed

    private void Matc_MobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Matc_MobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Matc_MobileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        calculation();
        
        String Mobile_Number = Matc_Mobile.getText();
        
       try{
           Connection patientConn = ConnectionProvider.getCon();
           Statement patientStatement = patientConn.createStatement();
           ResultSet patientRs = patientStatement.executeQuery("select * from patientinfo where Mobile_Number ='"+Mobile_Number+"'");
          
           if(patientRs.next())
           {
              getName.setText(patientRs.getString("Patient_Name"));
              Yes_items();
              Admin_Name.setText(My_Name_Set9.getText());
           }else
               
           JOptionPane.showMessageDialog(null,"No details found, Please Registation First");
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayBoxActionPerformed
        // TODO add your handling code here:
        String selectrdValue = PayBox.getSelectedItem().toString();
        
        String imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\Blank_Pay.jpg";
                if (selectrdValue.equals("Cash")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\Cas_pay.png";
             } else if (selectrdValue.equals("Bkash")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\Bkas_pay.png";
             }
             else if (selectrdValue.equals("Card")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\Card_pay.png";
             }
              Pay_img.setIcon(new ImageIcon(imagePath));
    }//GEN-LAST:event_PayBoxActionPerformed

    private void Total_SumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_SumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_SumActionPerformed
        Invoice paymentFrame = new Invoice();
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        paymentFrame.setVisible(true);
        paymentFrame.setExtendedState(Invoice.ICONIFIED);
        

        String Name = getName.getText();
        String Mobile = Matc_Mobile.getText();
        
        
        
        String Price_1 = Pay1.getText();
        String Price_2 = Pay2.getText();
        String Price_3 = Pay3.getText();
        String Price_4 = Pay4.getText();
        String Get_Discount = Discount.getText();
        
        
        
        String Sub_Total = SubTotal.getText();
        String Tax_pay = Tax.getText();
        String Total = Total_Sum.getText();
        
        
        String Address = Address_12.getText();
        String Email = Email_12.getText();
        String Payment_way = PayBox.getSelectedItem().toString();
        
        
        String Date_Time = MyDate.getText();
        String invoice_id = Invoice_Num.getText();
        String Receptionist = Admin_Name.getText();
        
        
        if(invoice_id.equals("")|| Name.equals("")||Mobile.equals("")||Payment_way.equals("")|| Price_1.equals("")||Price_2.equals("")||Price_3.equals("")|| Price_4.equals("")||Get_Discount.equals("")||Tax_pay.equals("")|| Sub_Total.equals("")||Total.equals("")||Date_Time.equals("")||Receptionist.equals(""))
            JOptionPane.showMessageDialog(null,"Every Field Is Required!");
        else{
           try{
            java.sql.Connection con = ConnectionProvider.getCon();
            java.sql.Statement st = con.createStatement();
            st.executeUpdate("Insert into invoice value('"+invoice_id+"','"+Name+"','"+Mobile+"','"+Address+"','"+Email+"','"+Payment_way+"','"+Price_1+"','"+Price_2+"','"+Price_3+"','"+Price_4+"','"+Get_Discount+"','"+Tax_pay+"','"+Sub_Total+"','"+Total+"','"+Date_Time+"','"+Receptionist+"')");
            
                Invoice_name.setText(Name);
                Invoice_mobile.setText(Mobile);
                Invoice_email.setText(Email);
                Invoice_address.setText(Address);
                Invoice_Invoice_Id.setText(invoice_id);
                Invoice_date.setText(Date_Time);
                Invoice_Price1.setText(Price_1);
                Invoice_Price2.setText(Price_2);
                Invoice_Price3.setText(Price_3);
                Invoice_Price4.setText(Price_4);
                Invoice_SubTotal.setText(Sub_Total);
                Invoice_Tax.setText(Tax_pay);
                Invoice_Total.setText(Total);
                Invoice_Discount.setText(Get_Discount);
                Invoice_Admin.setText(Receptionist);
                Invoice_PaymentWay.setText(Payment_way);
                
                print_invoice.doClick();
                
                randomnumbers();
                
            JOptionPane.showMessageDialog(null,"Payment Successfull and Invoice Saved");
            No_items();
         }
        
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
        } 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loginName2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseEntered
        // TODO add your handling code here:
        loginName2.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName2MouseEntered

    private void loginName2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseExited
        // TODO add your handling code here:
        loginName9.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName2MouseExited

    private void Admin_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admin_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Admin_NameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Pay1.setText("00");
        Pay2.setText("00");
        Pay3.setText("00");
        Pay4.setText("00");
        Discount.setText("00");
        SubTotal.setText("00");
        Total_Sum.setText("00");
        Clear_My_Cart.doClick();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Matc_MobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Matc_MobileKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_Matc_MobileKeyTyped

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            } 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address_12;
    private javax.swing.JTextField Admin_Name;
    private javax.swing.JLabel Close_Button;
    private javax.swing.JTextField Discount;
    private javax.swing.JTextField Email_12;
    private javax.swing.JLabel Invoice_Num;
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel Logout1;
    private javax.swing.JTextField Matc_Mobile;
    private javax.swing.JLabel MyDate;
    public static final javax.swing.JLabel My_Name_Set9 = new javax.swing.JLabel();
    public static final javax.swing.JLabel My_Pic9 = new javax.swing.JLabel();
    public static final javax.swing.JTextField Pay1 = new javax.swing.JTextField();
    public static final javax.swing.JTextField Pay2 = new javax.swing.JTextField();
    public static final javax.swing.JTextField Pay3 = new javax.swing.JTextField();
    public static final javax.swing.JTextField Pay4 = new javax.swing.JTextField();
    private javax.swing.JComboBox<String> PayBox;
    private javax.swing.JLabel Pay_img;
    private javax.swing.JTextField SubTotal;
    private javax.swing.JTextField Tax;
    private javax.swing.JLabel TotalNumberOfMoney;
    private javax.swing.JTextField Total_Sum;
    private javax.swing.JLabel age1;
    private javax.swing.JLabel deicount_set;
    private javax.swing.JLabel gender1;
    private javax.swing.JLabel getName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField6;
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
