/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import prtype.DBconnection;
import prtype.validations;

/**
 *
 * @author SACHUU
 */
public class MAINInterface extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int time = 0;
    DefaultTableModel model;

    public MAINInterface() {
        initComponents();
        con = DBconnection.connect(); //connect to the database
        custTableload(); //load the customer table
        resTableload();//load reservation table
        setfullscreen();//set full screen window
        roomtableload();//load room details

        jDateChooser1.setMinSelectableDate(new Date());//disable old dates
        jDateChooser2.setMinSelectableDate(new Date());//disable old dates

        jTextField12.setText("0");
        jTextField13.setText("#");
        
        

        //CLOCK
        new Thread() {
            public void run() {
                while (time == 0) {
                    Calendar cal = new GregorianCalendar();

                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int ampm = cal.get(Calendar.AM_PM);
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int date = cal.get(Calendar.DATE);

                    String day = "", Month = "";
                    if (hour == 0 && ampm == 1) {
                        hour = 12;
                    }
                    //AM PM
                    if (ampm == 1) {
                        day = "PM";
                    } else {
                        day = "AM";
                    }

                    //MONTH
                    if (month == 0) {
                        Month = "January";
                    } else if (month == 1) {
                        Month = "February";
                    } else if (month == 2) {
                        Month = "March";
                    } else if (month == 3) {
                        Month = "April";
                    } else if (month == 4) {
                        Month = "May";
                    } else if (month == 5) {
                        Month = "June";
                    } else if (month == 6) {
                        Month = "July";
                    } else if (month == 7) {
                        Month = "August";
                    } else if (month == 8) {
                        Month = "September";
                    } else if (month == 9) {
                        Month = "October";
                    } else if (month == 10) {
                        Month = "November";
                    } else if (month == 11) {
                        Month = "December";
                    }
                    String clock = hour + ":" + min + ":" + sec + " ";
                    String today = year + " " + Month + " " + date;

                    clockss.setText(clock);
                    clockss2.setText(clock);
                    

                    dayss.setText(day);
                    dayss2.setText(day);
                    

                    yearss.setText(String.valueOf(year));
                    yearss2.setText(String.valueOf(year));
                    

                    Monthss.setText(String.valueOf(Month));
                    Monthss2.setText(String.valueOf(Month));
                    

                    datess.setText(String.valueOf(date));
                    datess2.setText(String.valueOf(date));
                   
                }
            }
        }.start();
    }

    public void setfullscreen() {

        this.setResizable(false);

        Toolkit kit = Toolkit.getDefaultToolkit();

        int xsize = (int) kit.getScreenSize().getWidth();
        int ysize = (int) kit.getScreenSize().getHeight();

        int x = xsize;
        int y = ysize;

        this.setSize(x, y);//set size

        //moving to the center
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int Width = this.getSize().width;
        int Height = this.getSize().height;

        int locationx = (dimension.width - Width) / 2;
        int locationy = (dimension.height - Height) / 2;

        this.setLocation(locationx, locationy);

    }

    public void roomtableload() {
        String sql = "SELECT * FROM rooms";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));//assign vlues to the table
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void custTableload() {
        String sql = "SELECT * FROM customer";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));//assign vlues to the table
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void resTableload() {
        String sql = "SELECT * FROM reservation";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));//assign vlues to the table
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //validating NIC and Passport numbers
    public boolean nicppvalidation(int n, String num) {

        boolean m = false;

        if (n == 10 && num.charAt(9) == 'V' || num.charAt(9) == 'v') {

            for (int i = 0; i < 9; i++) {
                if (!(Character.isDigit(num.charAt(i)))) {
                    m = false;

                } else {
                    m = true;
                }
            }
        } else if (n == 8 && Character.isLetter(num.charAt(0))) {
            for (int i = 1; i <= 7; i++) {
                if (!(Character.isDigit(num.charAt(i)))) {
                    m = false;
                } else {
                    m = true;
                }

            }
        } else {
            m = false;

        }

        return m;
    }

    public float currentTotal(float d, String b, String t, String ty, int head) {

        float amount = 0;
        int rooms = 0;

        if (head % 4 != 0) {
            rooms = (head / 4) + 1;
        } else {
            rooms = head / 4;
        }

        if (b.compareTo("Full") == 0 && ty.compareTo("A/C") == 0) {
            if (t.contains("Yes")) {
                amount = (float) ((1500.0 * d) + (50 * d)) * rooms;
            } else {

                amount = (float) ((1500.0 * d)) * rooms;
            }
        } else if (b.compareTo("Full") == 0 && ty.compareTo("None A/C") == 0) {
            if (t.contains("Yes")) {
                amount = (float) ((1000.0 * d) + (50 * d)) * rooms;
            } else {
                amount = (float) ((1000.0 * d)) * rooms;
            }
        } else if (b.compareTo("Half") == 0 && ty.compareTo("A/C") == 0) {
            if (t.contains("Yes")) {
                amount = (float) ((1200.0 * d) + (50 * d)) * rooms;
            } else {
                amount = (float) ((1200.0 * d)) * rooms;
            }
        } else if (b.compareTo("Half") == 0 && ty.compareTo("None A/C") == 0) {
            if (t.contains("Yes")) {
                amount = (float) ((900.0 * d) + (50 * d)) * rooms;
            } else {
                amount = (float) ((900.0 * d)) * rooms;
            }
        }

        return amount;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        yearss = new javax.swing.JLabel();
        Monthss = new javax.swing.JLabel();
        clockss = new javax.swing.JLabel();
        dayss = new javax.swing.JLabel();
        datess = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton19 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        datess2 = new javax.swing.JLabel();
        Monthss2 = new javax.swing.JLabel();
        yearss2 = new javax.swing.JLabel();
        clockss2 = new javax.swing.JLabel();
        dayss2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));

        jTabbedPane7.setBackground(new java.awt.Color(204, 255, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 290, 100, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(320, 290, 19, 15);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(320, 330, 179, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 330, 47, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADDRESS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 380, 76, 22);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(320, 380, 179, 23);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(320, 430, 179, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PHONE");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(100, 430, 57, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NIC/PASSPORT No.");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 480, 156, 22);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(320, 470, 179, 23);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/addcustomer.png"))); // NOI18N
        jButton1.setText("ADD");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(100, 540, 114, 45);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton2.setText("DELETE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(610, 540, 117, 45);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton3.setText("UPDATE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(230, 540, 121, 45);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/search.png"))); // NOI18N
        jButton4.setText("SEARCH");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(360, 540, 117, 45);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Home+Button.png"))); // NOI18N
        jButton11.setText("HOME");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(490, 540, 114, 45);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CID", "Cname", "Caddress", "Cphone", "NIC/PASSPORT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 620, 631, 300);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "RoomNO", "Availability", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(802, 616, 625, 310);

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/search.png"))); // NOI18N
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(1360, 540, 69, 45);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room Number");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(820, 430, 114, 22);

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField12);
        jTextField12.setBounds(990, 430, 45, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Availability(y/n)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(820, 470, 123, 22);

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField13);
        jTextField13.setBounds(990, 470, 45, 23);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/power-button-md.png"))); // NOI18N
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20);
        jButton20.setBounds(1710, 940, 69, 45);

        jButton22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Home+Button.png"))); // NOI18N
        jButton22.setText("Home");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton22);
        jButton22.setBounds(1790, 940, 109, 45);

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setPreferredSize(new java.awt.Dimension(1910, 190));
        jPanel7.setLayout(null);

        yearss.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss.setForeground(new java.awt.Color(255, 255, 255));
        yearss.setText("year");
        jPanel7.add(yearss);
        yearss.setBounds(1640, 120, 48, 25);

        Monthss.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss.setForeground(new java.awt.Color(255, 255, 255));
        Monthss.setText("month");
        jPanel7.add(Monthss);
        Monthss.setBounds(1700, 110, 150, 37);

        clockss.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss.setForeground(new java.awt.Color(255, 255, 255));
        clockss.setText("jLabel40");
        jPanel7.add(clockss);
        clockss.setBounds(1670, 70, 128, 37);

        dayss.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss.setForeground(new java.awt.Color(255, 255, 255));
        dayss.setText("AM");
        jPanel7.add(dayss);
        dayss.setBounds(1810, 70, 36, 37);

        datess.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess.setForeground(new java.awt.Color(255, 255, 255));
        datess.setText("date");
        jPanel7.add(datess);
        datess.setBounds(1850, 120, 48, 25);

        jLabel32.setFont(new java.awt.Font("Lucida Sans Unicode", 3, 80)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("CUSTOMER & ROOM");
        jPanel7.add(jLabel32);
        jLabel32.setBounds(560, 40, 850, 98);

        jLabel33.setFont(new java.awt.Font("Lucida Sans Unicode", 3, 50)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("DETAILS");
        jPanel7.add(jLabel33);
        jLabel33.setBounds(880, 110, 220, 77);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9);
        jPanel9.setBounds(1130, 140, 270, 10);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel10);
        jPanel10.setBounds(570, 140, 270, 10);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 0, 1910, 190);

<<<<<<< HEAD
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/IMG-20170312-WA0035.jpg"))); // NOI18N
=======
        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\SACHUU\\Desktop\\images\\IMG-20170312-WA0035.jpg")); // NOI18N
>>>>>>> 94c61fb6ae284793223e9b77b4b3627f31ec125c
        jPanel1.add(jLabel30);
        jLabel30.setBounds(0, 190, 1910, 800);

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(0, 990, 1920, 40);

        jTabbedPane7.addTab("CUSTOMER / ROOM DETAILS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reservation ID");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 230, 116, 22);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("RID");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(270, 230, 30, 14);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("CID");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(270, 270, 30, 14);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Customer ID");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 270, 100, 22);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CUSTOMER`s PHONE");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 310, 173, 22);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CUSTOMER`s NAME");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 360, 163, 22);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField5);
        jTextField5.setBounds(270, 310, 158, 23);

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/fill.png"))); // NOI18N
        jButton12.setText("FILL");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(770, 890, 95, 45);

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton13.setText("RESET");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(620, 890, 109, 45);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(270, 360, 158, 23);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CHECK-IN Date");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(20, 410, 123, 22);

        jDateChooser1.setDateFormatString("yyyy-M-d");
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(270, 410, 158, 20);

        jDateChooser2.setDateFormatString("yyyy-M-d");
        jPanel2.add(jDateChooser2);
        jDateChooser2.setBounds(270, 470, 158, 20);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("CHECK-OUT Date");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(20, 470, 140, 22);

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("NO.Of Days");
        jPanel2.add(jLabel37);
        jLabel37.setBounds(20, 520, 93, 22);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("0");
        jPanel2.add(jLabel38);
        jLabel38.setBounds(270, 530, 8, 17);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ROOM No(s):");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(20, 590, 107, 22);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("HEAD COUNT");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(20, 800, 110, 22);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField8);
        jTextField8.setBounds(270, 590, 156, 23);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField9);
        jTextField9.setBounds(270, 810, 148, 23);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("TYPE");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(20, 640, 41, 22);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None A/C", "A/C", " " }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(230, 640, 109, 28);

        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("FULL BOARD");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(20, 680, 129, 31);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("BED TEA");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(220, 700, 71, 22);

        jRadioButton4.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("YES");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton4);
        jRadioButton4.setBounds(310, 700, 55, 31);

        jRadioButton3.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("NO");
        jPanel2.add(jRadioButton3);
        jRadioButton3.setBounds(380, 700, 51, 31);

        jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("HALF BOARD");
        jRadioButton2.setToolTipText("");
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(20, 750, 131, 31);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/search.png"))); // NOI18N
        jButton8.setText("SEARCH");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(70, 890, 122, 45);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton7.setText("UPDATE");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(210, 890, 121, 45);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton6.setText("DELETE");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(350, 890, 117, 45);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton5.setText("ADD");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(500, 890, 97, 45);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RID", "CID", "Phone", "Cname", "in-date", "out-date", "NO.of Days", "Room No", "Count", "Type", "BedTea", "BoardType", "Total(Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(102, 102, 102));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(550, 350, 1089, 459);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/power-button-md.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton19);
        jButton19.setBounds(1710, 940, 69, 45);

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Home+Button.png"))); // NOI18N
        jButton18.setText("Home");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton18);
        jButton18.setBounds(1790, 940, 109, 45);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/money.png"))); // NOI18N
        jButton23.setText("Payment");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton23);
        jButton23.setBounds(890, 890, 115, 45);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(null);

        datess2.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess2.setForeground(new java.awt.Color(255, 255, 255));
        datess2.setText("date");
        jPanel3.add(datess2);
        datess2.setBounds(1830, 130, 48, 25);

        Monthss2.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss2.setForeground(new java.awt.Color(255, 255, 255));
        Monthss2.setText("month");
        jPanel3.add(Monthss2);
        Monthss2.setBounds(1680, 120, 160, 37);

        yearss2.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss2.setForeground(new java.awt.Color(255, 255, 255));
        yearss2.setText("year");
        jPanel3.add(yearss2);
        yearss2.setBounds(1620, 130, 48, 25);

        clockss2.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss2.setForeground(new java.awt.Color(255, 255, 255));
        clockss2.setText("jLabel40");
        jPanel3.add(clockss2);
        clockss2.setBounds(1630, 70, 128, 37);

        dayss2.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss2.setForeground(new java.awt.Color(255, 255, 255));
        dayss2.setText("AM");
        jPanel3.add(dayss2);
        dayss2.setBounds(1770, 70, 36, 37);

        jLabel29.setFont(new java.awt.Font("Lucida Sans Unicode", 3, 100)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("RESERVATIONS");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(450, 40, 792, 89);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);
        jPanel6.setBounds(450, 130, 783, 9);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1910, 190);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1910, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 990, 1910, 40);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/AP120521026936_0.jpg"))); // NOI18N
        jPanel2.add(jLabel31);
        jLabel31.setBounds(0, 190, 1910, 810);

        jTabbedPane7.addTab("RESERVATION DETAILS", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setBounds(0, 0, 1930, 1096);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char alpha = evt.getKeyChar();

        if (!(Character.isLetter(alpha) || alpha == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char alpha = evt.getKeyChar();

        if (!(Character.isDigit(alpha) || alpha == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char alpha = evt.getKeyChar();
        if (!(Character.isDigit(alpha) || alpha == KeyEvent.VK_BACK_SPACE || alpha == 'V' || alpha == 'v' || alpha == 'm' || alpha == 'M')) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Add customers
        String name, address, nicp;
        String phone;

        //get values from text fields
        name = jTextField1.getText();
        address = jTextField2.getText();
        phone = jTextField3.getText();
        nicp = jTextField4.getText();

        boolean nicpp = false;
        boolean validate = false;

        nicpp = nicppvalidation(nicp.length(), nicp); //call nicppvalidation function to validate the nic/pasport number

        validations newcustomer = new validations();

        //Customer detail validations
        boolean a = newcustomer.custname(name);
        boolean b = newcustomer.address(address);
        boolean c = newcustomer.phone(phone);
        boolean d = newcustomer.nicpp(nicp);

        if ((jTextField3.getText().length() == 10))//check the length of the phone number
        {
            validate = true;
        } else {
            JOptionPane.showMessageDialog(null, "Enter valid telephone number"); //This will show an error when the phone number is invalid
            jTextField3.setText("");
        }

        if (validate == true && nicpp == true && a == true && b == true && c == true && d == true) {
            String sql = "INSERT INTO customer (Name,Address,Phone,NICPP) VALUES('" + name + "','" + address + "','" + phone + "','" + nicp + "')";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED");//display messegebox
            } catch (Exception e) {
                System.out.println(e);
            }
            custTableload(); //load the customer table
        } else if (nicpp == false) {
            JOptionPane.showMessageDialog(null, "Enter valid NIC/PASSPORT NO."); //This will show an error when the phone number is invalid
            jTextField4.setText("");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //Delete customer details
        int cid = Integer.parseInt(jLabel5.getText());

        String sql = "DELETE FROM customer WHERE CID='" + cid + "'";
        int responce = JOptionPane.showConfirmDialog(null, "Do You Want to Delete  Records?");

        if (responce == 0) {
            try {
                pst = con.prepareStatement(sql);
                pst.execute();

            } catch (Exception e) {
            }
        }
        custTableload();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //Update customer details
        String name = jTextField1.getText();
        String address = jTextField2.getText();
        int phone = Integer.parseInt(jTextField3.getText());
        String nicpp = jTextField4.getText();
        int cid = Integer.parseInt(jLabel5.getText());

        boolean validate = false;
        boolean nicppVali = false;

        nicppVali = nicppvalidation(jTextField4.getText().length(), nicpp);

        if ((jTextField3.getText().length() == 9)) {
            validate = true;

        } else {
            JOptionPane.showMessageDialog(null, "Enter a Valide Telephone Number.");
            jTextField3.setText("");
        }

        String sql = "UPDATE customer SET Name='" + name + "',Address='" + address + "',Phone='" + phone + "',NICPP='" + nicpp + "' WHERE CID='" + cid + "'";

        System.out.println(nicppVali);
        if (validate == true && nicppVali == true) {

            int responce = (JOptionPane.showConfirmDialog(null, "Do You Want to Update Records?"));
            if (responce == 0) {

                try {
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    custTableload();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //Search customer details
        int phone = Integer.parseInt(jTextField3.getText());
        String sql = "SELECT * FROM customer WHERE Phone='" + phone + "'";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel5.setText(rs.getString("CID"));
                jTextField1.setText(rs.getString("name"));
                jTextField2.setText(rs.getString("Address"));
                jTextField3.setText(rs.getString("phone"));
                jTextField4.setText(rs.getString("NICPP"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        //Reset text fields and load the table
        custTableload();
        roomtableload();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jLabel5.setText("CID");

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        //get values from the table
        int r = jTable1.getSelectedRow();
        String cid = jTable1.getValueAt(r, 0).toString();
        String name = jTable1.getValueAt(r, 1).toString();
        String address = jTable1.getValueAt(r, 2).toString();
        String phone = jTable1.getValueAt(r, 3).toString();
        String nicpp = jTable1.getValueAt(r, 4).toString();

        //assign values to the text fields
        jLabel5.setText(cid);
        jTextField1.setText(name);
        jTextField2.setText(address);
        jTextField3.setText(phone);
        jTextField4.setText(nicpp);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char alpha = evt.getKeyChar();

        if (!(Character.isDigit(alpha) || alpha == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        //Fill the Customer ID and Name in Reservation section
        int phone;

        phone = Integer.parseInt(jTextField5.getText());

        String sql = "SELECT CID,Name FROM customer WHERE Phone='" + phone + "'";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                jLabel18.setText(rs.getString("CID"));
                jTextField6.setText(rs.getString("Name"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        jLabel17.setText("RID");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // Reset Text Fields

        jLabel17.setText("RID");
        jLabel18.setText("CID");
        jTextField5.setText("");
        jTextField6.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jLabel38.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jComboBox1.setSelectedItem("None A/C");
        jLabel38.setText("0");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();

        resTableload();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char alpha = evt.getKeyChar();

        if (!(Character.isLetter(alpha) || alpha == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped

    }//GEN-LAST:event_jDateChooser1KeyTyped

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char alpha = evt.getKeyChar();

        if (!(Character.isDigit(alpha) || alpha == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char alpha = evt.getKeyChar();

        if (!(Character.isDigit(alpha) || alpha == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Search reservations

        int cphone = Integer.parseInt(jTextField5.getText());

        String sql = "SELECT * FROM reservation WHERE Cphone='" + cphone + "'"; //serach & retrieve data from reservation table

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Update reservation details

        int rid = Integer.parseInt(jLabel17.getText());
        int cid = Integer.parseInt(jLabel18.getText());
        int cphone = Integer.parseInt(jTextField5.getText());
        String cname = jTextField6.getText();

        //Date fomat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String idate = dateFormat.format(jDateChooser1.getDate());
        String odate = dateFormat.format(jDateChooser2.getDate());

        try {
            Date Idate = new SimpleDateFormat("yyyy-MM-dd").parse(idate);
            Date Odate = new SimpleDateFormat("yyyy-MM-dd").parse(odate);
            jDateChooser1.setDate(Idate);
            jDateChooser2.setDate(Odate);

            long diff = Odate.getDate() - Idate.getDate();
            if (diff == 0) {
                diff = 1;
                jLabel38.setText(String.valueOf(diff));
            } else {
                jLabel38.setText(String.valueOf(diff));
            }
        } catch (ParseException ex) {
            Logger.getLogger(MAINInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        int roomNo = Integer.parseInt(jTextField8.getText());
        String type = jComboBox1.getSelectedItem().toString();
        int count = Integer.parseInt(jTextField9.getText());
        int days = Integer.parseInt(jLabel38.getText());

        //Radio button
        jRadioButton1.setActionCommand("Full");
        jRadioButton2.setActionCommand("Half");
        jRadioButton3.setActionCommand("No");
        jRadioButton4.setActionCommand("Yes");

        if (days == 0) {
            days = 1;
        }

        String Btype = buttonGroup1.getSelection().getActionCommand();
        String tea = buttonGroup2.getSelection().getActionCommand();
        float total = currentTotal(days, Btype, tea, type, count);
        //Add entered data into data base

        String sql = "UPDATE reservation  SET CID='" + cid + "',Cphone='" + cphone + "',Cname='" + cname + "',Idate='" + idate + "',Odate='" + odate + "',RoomNo='" + roomNo + "',Count='" + count + "',Type='" + type + "',BedTea='" + tea + "',BoardType='" + Btype + "',Total='" + total + "' WHERE RID='" + rid + "'";
        try {
            pst = con.prepareStatement(sql);

            pst.execute();

            JOptionPane.showMessageDialog(null, "DONE");
        } catch (Exception e) {
            System.out.println(e);
        }
        resTableload();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Cansel Reservations
        int rmno = Integer.parseInt(jTextField8.getText());
        int rid = Integer.parseInt(jLabel17.getText());

        String sql = "DELETE FROM reservation WHERE RID='" + rid + "'"; //sql query for delete records from reservation table
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?");

        if (x == 0) {
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                resTableload();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            String sql1 = "Update rooms Set Availability='y' Where RoomNo='" + rmno + "'";
            pst = con.prepareStatement(sql1);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Add Reservations

        int Count = 0;

        int cid = Integer.parseInt(jLabel18.getText());
        String cphone = jTextField5.getText();
        String cname = jTextField6.getText();

        //Date fomat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String idate = dateFormat.format(jDateChooser1.getDate());
        String odate = dateFormat.format(jDateChooser2.getDate());
        validations newreservation = new validations();
        boolean d = newreservation.date(idate, odate);

        try {
            Date Idate = new SimpleDateFormat("yyyy-MM-dd").parse(idate);
            Date Odate = new SimpleDateFormat("yyyy-MM-dd").parse(odate);
            jDateChooser1.setDate(Idate);
            jDateChooser2.setDate(Odate);

            long diff = Odate.getDate() - Idate.getDate();

            if (diff == 0) {
                diff = 1;
                jLabel38.setText(String.valueOf(diff));
            } else {
                jLabel38.setText(String.valueOf(diff));
            }
            jLabel38.setText(String.valueOf(diff));
        } catch (ParseException ex) {
            Logger.getLogger(MAINInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        String roomNo = jTextField8.getText();
        String type = jComboBox1.getSelectedItem().toString();
        String count = jTextField9.getText();

        int days = Integer.parseInt(jLabel38.getText());

        //Radio button
        jRadioButton1.setActionCommand("Full");
        jRadioButton2.setActionCommand("Half");
        jRadioButton3.setActionCommand("No");
        jRadioButton4.setActionCommand("Yes");

        if (days == 0) {
            days = 1;
        }

        boolean a = newreservation.custname(cname);
        boolean b = newreservation.phone(cphone);
        boolean c = newreservation.Headcount(count);
        boolean f = newreservation.roomNO(roomNo);

        String Btype = buttonGroup1.getSelection().getActionCommand();
        String tea = buttonGroup2.getSelection().getActionCommand();

        if (c == true) {
            Count = Integer.parseInt(count);
        }

        float total = currentTotal(days, Btype, tea, type, Count);

        //Add entered data into data base
        if (a == true && b == true && c == true && d == true && f == true) {
            String sql = "INSERT INTO reservation (CID,Cphone,Cname,Idate,Odate,RoomNo,Count,Type,BedTea,BoardType,Total) Values('" + cid + "','" + cphone + "','" + cname + "','" + idate + "','" + odate + "','" + roomNo + "','" + Count + "','" + type + "','" + tea + "','" + Btype + "','" + total + "')";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "DONE");
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                String sql1 = "Update rooms Set Availability='n' Where RoomNo='" + roomNo + "'";
                pst = con.prepareStatement(sql1);
                pst.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Can`t add values", "ERROR!", JOptionPane.WARNING_MESSAGE);
        }
        roomtableload();
        resTableload();
        roomtableload();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // Reservation table
        int r = jTable2.getSelectedRow();

        //Set Date to jDateChooser 1and 2
        String idate = jTable2.getValueAt(r, 4).toString();
        String odate = jTable2.getValueAt(r, 5).toString();
        try {
            Date Idate = new SimpleDateFormat("yyyy-MM-dd").parse(idate);
            Date Odate = new SimpleDateFormat("yyyy-MM-dd").parse(odate);
            jDateChooser1.setDate(Idate);
            jDateChooser2.setDate(Odate);

            long diff = Odate.getDate() - Idate.getDate();
            if (diff == 0) {
                diff = 1;
            }
            jLabel38.setText(String.valueOf(diff));
        } catch (ParseException ex) {
            Logger.getLogger(MAINInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField6.setText(jTable2.getValueAt(r, 3).toString());
        jLabel17.setText(jTable2.getValueAt(r, 0).toString());
        jLabel18.setText(jTable2.getValueAt(r, 1).toString());
        jTextField5.setText(jTable2.getValueAt(r, 2).toString());
        jTextField8.setText(jTable2.getValueAt(r, 6).toString());
        jTextField9.setText(jTable2.getValueAt(r, 7).toString());
        jComboBox1.setSelectedItem(jTable2.getValueAt(r, 8).toString());
        String B = jTable2.getValueAt(r, 10).toString();
        String t = jTable2.getValueAt(r, 9).toString();

        if (B.contains("Full")) {
            jRadioButton1.setSelected(true);
        } else if (B.contains("Half")) {
            jRadioButton2.setSelected(true);
        }
        if (t.contains("Yes")) {
            jRadioButton4.setSelected(true);
        } else if (t.contains("No")) {
            jRadioButton3.setSelected(true);
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        //Search for room details
        int roomno = Integer.parseInt(jTextField12.getText());

        String availability;
        availability = jTextField13.getText();

        if (availability.charAt(0) == 'Y' || availability.charAt(0) == 'y') {
            availability = "y";
        } else if (availability.charAt(0) == 'N' || availability.charAt(0) == 'n') {
            availability = "n";
        } else if (availability.equals("#") || availability.equals("")) {
            availability = "x";
        }

        if (availability == "x") {

            System.out.println("1");
            try {
                String sql = "Select * from rooms Where  RoomNo='" + roomno + "'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable4.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
            }
        } else if (availability != "") {
            System.out.println("2");
            try {
                String sql = "Select * from rooms Where  Availability='" + availability + "'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable4.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
            }
        }


    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        // TODO add your handling code here:
        char alpha = evt.getKeyChar();

        if (!(Character.isLetter(alpha) || alpha == KeyEvent.VK_BACK_SPACE) || !(alpha == 'N' || alpha == 'n' || alpha == 'y') || alpha == 'Y') {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // LOGOUT

        loggin log = new loggin();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // LOGOUT

        loggin log = new loggin();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        hub h = new hub();
                    h.jButton1.setEnabled(false);
                    h.jButton3.setEnabled(false);
                    h.jButton5.setEnabled(false);
                    h.jButton6.setEnabled(false);
                    h.jButton7.setEnabled(false);
                    h.jButton8.setEnabled(false);

                    h.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        hub h = new hub();
                    h.jButton1.setEnabled(false);
                    h.jButton3.setEnabled(false);
                    h.jButton5.setEnabled(false);
                    h.jButton6.setEnabled(false);
                    h.jButton7.setEnabled(false);
                    h.jButton8.setEnabled(false);

                    h.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        Respayment rp=new Respayment();
        rp.setVisible(true);
    }//GEN-LAST:event_jButton23ActionPerformed

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
            java.util.logging.Logger.getLogger(MAINInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAINInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAINInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAINInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAINInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Monthss;
    private javax.swing.JLabel Monthss1;
    private javax.swing.JLabel Monthss2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel clockss;
    private javax.swing.JLabel clockss1;
    private javax.swing.JLabel clockss2;
    private javax.swing.JLabel datess;
    private javax.swing.JLabel datess1;
    private javax.swing.JLabel datess2;
    private javax.swing.JLabel dayss;
    private javax.swing.JLabel dayss1;
    private javax.swing.JLabel dayss2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
<<<<<<< HEAD
=======
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
>>>>>>> 94c61fb6ae284793223e9b77b4b3627f31ec125c
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
<<<<<<< HEAD
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
=======
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
>>>>>>> 94c61fb6ae284793223e9b77b4b3627f31ec125c
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
<<<<<<< HEAD
=======
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
>>>>>>> 94c61fb6ae284793223e9b77b4b3627f31ec125c
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
<<<<<<< HEAD
=======
    private javax.swing.JPanel jPanel5;
>>>>>>> 94c61fb6ae284793223e9b77b4b3627f31ec125c
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
<<<<<<< HEAD
=======
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
>>>>>>> 94c61fb6ae284793223e9b77b4b3627f31ec125c
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel yearss;
    private javax.swing.JLabel yearss1;
    private javax.swing.JLabel yearss2;
    // End of variables declaration//GEN-END:variables
}
