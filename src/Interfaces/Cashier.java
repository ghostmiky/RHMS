/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import prtype.DBconnection;

/**
 *
 * @author Tharindu
 */
public class Cashier extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    //PreparedStatement pst1 = null;
    ResultSet rs1 = null;
    int time = 0;

    public Cashier() {
        initComponents();
        con = DBconnection.connect();
        tableload2();
        temptableload();
        devtableload();
        billtableload();
        setfullscreen();

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

                    clockss4.setText(clock);
                    dayss4.setText(day);
                    yearss4.setText(String.valueOf(year));
                    Monthss4.setText(String.valueOf(Month));
                    datess4.setText(String.valueOf(date));
                }
            }
        }.start();
    }

    
    
    public void setfullscreen() {

        this.setResizable(false);

        Toolkit kit = Toolkit.getDefaultToolkit();

        int xsize = (int) kit.getScreenSize().getWidth();
        int ysize = (int) kit.getScreenSize().getHeight();

        int x = (xsize * 84) / 100;
        int y = (ysize * 84) / 100;

        this.setSize(x, y);//set size

        //moving to the center
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int Width = this.getSize().width;
        int Height = this.getSize().height;

        int locationx = (dimension.width - Width) / 2;
        int locationy = (dimension.height - Height) / 2;

        this.setLocation(locationx, locationy);

    }
    public void tableload2() {
        try {
            String s = "select * from fdorder";
            pst = con.prepareStatement(s);
            rs1 = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void temptableload() {
        try {
            String s = "select * from temporder";
            pst = con.prepareStatement(s);
            rs1 = pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void devtableload() {
        try {
            String r = "select * from fdelivery";
            pst = con.prepareStatement(r);
            rs1 = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void billtableload() {
        try {
            String r = "select * from resbill";
            pst = con.prepareStatement(r);
            rs1 = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*  public void tableload1() {
        try {

            String s = "select * from food";

            pst = con.prepareStatement(s);

            rs1 = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        amountbox = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        foodbox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        ans = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        pricebox = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        namebox = new javax.swing.JTextField();
        landbox = new javax.swing.JTextField();
        addressbox = new javax.swing.JTextField();
        buildingbox = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        contactbox = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        yearss4 = new javax.swing.JLabel();
        clockss4 = new javax.swing.JLabel();
        dayss4 = new javax.swing.JLabel();
        datess4 = new javax.swing.JLabel();
        Monthss4 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Bill no");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Amount");

        amountbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountboxActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton4.setText("Add to income");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton6.setText("Update bill");

        jLabel17.setText("             ");

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(72, 72, 72)
                        .addComponent(amountbox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(jButton6)
                        .addGap(47, 47, 47)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel17))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(545, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(amountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("      Bill     ", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Order ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Table no");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Food ID");

        foodbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        foodbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodboxActionPerformed(evt);
            }
        });
        foodbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                foodboxKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Quantity");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton2.setText("Add more");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton3.setText("Cancel order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total amount");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Print Bill");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Order ID");

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Price");

        pricebox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceboxActionPerformed(evt);
            }
        });
        pricebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceboxKeyTyped(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton5.setText("Cancel add more ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton13.setText("Add to total");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/cat.png"))); // NOI18N
        jButton10.setText("For Delivery");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(107, 107, 107))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(128, 128, 128)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(foodbox, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricebox)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10)
                        .addGap(41, 41, 41)
                        .addComponent(ans, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(jButton5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton10)
                        .addGap(0, 452, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel18))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(foodbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(pricebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(75, 75, 75)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(57, 57, 57))))
        );

        jTabbedPane1.addTab("     Order    ", jPanel1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Address");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Buildings");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Land marks");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton8.setText("Order now");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        namebox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        namebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameboxKeyTyped(evt);
            }
        });

        landbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        landbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                landboxKeyTyped(evt);
            }
        });

        addressbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressboxKeyTyped(evt);
            }
        });

        buildingbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buildingbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buildingboxKeyTyped(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton12.setText("Cancel order");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Contact no");

        contactbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contactbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactboxActionPerformed(evt);
            }
        });
        contactbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactboxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactboxKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(208, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(103, 103, 103)
                                .addComponent(buildingbox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(103, 103, 103)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressbox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(namebox, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(contactbox))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(103, 103, 103)
                                .addComponent(landbox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(addressbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(buildingbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(landbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton8)
                            .addComponent(jButton12)
                            .addComponent(jButton11)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delivery", jPanel3);

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/food.png"))); // NOI18N
        jButton14.setText("HeadChef");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        yearss4.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss4.setText("year");

        clockss4.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss4.setText("jLabel40");

        dayss4.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss4.setText("AM");

        datess4.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess4.setText("date");

        Monthss4.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss4.setText("month");

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/power-button-md.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Home+Button.png"))); // NOI18N
        jButton15.setText("Home");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clockss4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayss4)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yearss4)
                        .addGap(18, 18, 18)
                        .addComponent(Monthss4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datess4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton14)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19)
                                .addGap(23, 23, 23))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockss4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayss4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yearss4)
                        .addComponent(Monthss4)
                        .addComponent(datess4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(jButton19)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //add items to original table
        String tableno = jComboBox1.getSelectedItem().toString();
        String fID = foodbox.getText();
        String quantity = jComboBox2.getSelectedItem().toString();
        String price = pricebox.getText();

        if ((tableno.contains("0")) || (fID.isEmpty()) || (price.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Some text are missing");
        } else {
            try {
                String f = "INSERT INTO fdorder (tableNO,fID,Quantity) values ('" + tableno + "','" + fID + "','" + quantity + "')";
                pst = con.prepareStatement(f);
                pst.execute();

            } catch (Exception e) {
            }
            tableload2();

            int x = Integer.parseInt(quantity);
            int y = Integer.parseInt(price);

            int sum = x * y;
            String answer = Integer.toString(sum);
            ans.setText(answer);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //add items to temp table
        //int tableno=Integer.parseInt(jComboBox1.getSelectedItem().toString());
        String tableno = jComboBox1.getSelectedItem().toString();
        String fID = foodbox.getText();
        // String quantity=jComboBox2.getSelectedItem().toString();
        String quantity = jComboBox2.getSelectedItem().toString();
        String price = pricebox.getText();

        if ((tableno.contains("0")) || (fID.isEmpty()) || (price.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Some text are missing");
        }

        int x = Integer.parseInt(quantity);
        int y = Integer.parseInt(price);

        int sum = x * y;
        String answer = Integer.toString(sum);
        //ans.setText(answer);

        try {
            String t = "INSERT INTO temporder (tableNO,fID,Quantity,tfprice) values ('" + tableno + "','" + fID + "','" + quantity + "','" + answer + "')";

            pst = con.prepareStatement(t);
            pst.execute();
            temptableload();

        } catch (Exception e) {
            System.out.println(e);
        }
        foodbox.setText(null);
        jComboBox2.setSelectedItem("1");
        pricebox.setText(null);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String name = namebox.getText();
        String contactno = contactbox.getText();
        String address = addressbox.getText();
        String building = buildingbox.getText();
        String land = landbox.getText();

        if ((name.isEmpty()) || (contactno.isEmpty()) || (address.isEmpty()) || (building.isEmpty()) || (land.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Some text are missing");
        } else {
            try {
                String r = "INSERT INTO fdelivery (cname,contactno,caddress,cbuilding,clandmarks) values ('" + name + "','" + contactno + "','" + address + "','" + building + "','" + land + "')";
                pst = con.prepareStatement(r);
                pst.execute();
                devtableload();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int i = jTable1.getSelectedRow();

        String orderid = jTable1.getValueAt(i, 0).toString();
        String tableno = jTable1.getValueAt(i, 1).toString();
        String fID = jTable1.getValueAt(i, 2).toString();
        String quantity = jTable1.getValueAt(i, 3).toString();

        jLabel18.setText(orderid);
        jComboBox1.setSelectedItem(tableno);
        foodbox.setText(fID);
        jComboBox2.setSelectedItem(quantity);


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete");

        if (x == 0) {
            String orderid = jLabel18.getText();
            String p = "DELETE from fdorder WHERE orderID ='" + orderid + "'";

            try {
                pst = con.prepareStatement(p);
                pst.execute();
                tableload2();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        jLabel18.setText(null);
        jComboBox1.setSelectedItem("0");
        foodbox.setText(null);
        jComboBox2.setSelectedItem("1");


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

        int i = jTable3.getSelectedRow();

        String name = jTable3.getValueAt(i, 0).toString();
        String contactno = jTable3.getValueAt(i, 1).toString();
        String address = jTable3.getValueAt(i, 2).toString();
        String building = jTable3.getValueAt(i, 3).toString();
        String land = jTable3.getValueAt(i, 4).toString();

        namebox.setText(name);
        contactbox.setText(contactno);
        addressbox.setText(address);
        buildingbox.setText(building);
        landbox.setText(land);

    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked

        int i = jTable4.getSelectedRow();

        //String orderid = jTable4.getValueAt(i, 0).toString();
        String tableNO = jTable4.getValueAt(i, 0).toString();
        String fID = jTable4.getValueAt(i, 1).toString();
        String Quantity = jTable4.getValueAt(i, 2).toString();
        String pprice = jTable4.getValueAt(i, 3).toString();

        //jLabel18.setText(orderid);
        jComboBox1.setSelectedItem(tableNO);
        foodbox.setText(fID);
        jComboBox2.setSelectedItem(Quantity);
        pricebox.setText(pprice);


    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete");

        if (x == 0) {
            String contactno = contactbox.getText();
            String a = "DELETE from fdelivery WHERE contactno='" + contactno + "'";

            try {
                pst = con.prepareStatement(a);
                pst.execute();
                devtableload();

                namebox.setText(null);
                contactbox.setText(null);
                addressbox.setText(null);
                buildingbox.setText(null);
                landbox.setText(null);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update");

        if (x == 0) {
            String name = namebox.getText();
            String contact = contactbox.getText();
            String address = addressbox.getText();
            String building = buildingbox.getText();
            String land = landbox.getText();

            String s = "UPDATE fdelivery SET cname='" + name + "',contactno='" + contact + "',caddress='" + address + "',cbuilding='" + building + "',clandmarks='" + land + "' WHERE contactno='" + contact + "'";

            try {
                pst = con.prepareStatement(s);
                pst.execute();
                devtableload();

            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void foodboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodboxActionPerformed
        // TODO add your handling code here:
        String fID = foodbox.getText();
        String q = "SELECT price FROM food WHERE fID='" + fID + "'";
        //System.out.println(q);
        try {
            pst = con.prepareStatement(q);
            rs1 = pst.executeQuery();
            while (rs1.next()) {
                pricebox.setText(rs1.getString("price").toString());
                //System.out.println(rs1.getString("price").toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_foodboxActionPerformed

    private void foodboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_foodboxKeyTyped
        // TODO add your handling code here:

        String fID = foodbox.getText();
        String q = "SELECT price FROM food WHERE fID='" + fID + "'";
        //System.out.println(q);
        try {
            pst = con.prepareStatement(q);
            rs1 = pst.executeQuery();
            while (rs1.next()) {
                pricebox.setText(rs1.getString("price").toString());
                //System.out.println(rs1.getString("price").toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_foodboxKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String amount = ans.getText();
        amountbox.setText(amount);


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(jDateChooser1.getDate());
        // String odate = dateFormat.format(jDateChooser2.getDate());
        String amount = amountbox.getText();

        try {
            String i = "INSERT INTO resbill (idate,Amount) values ('" + date + "','" + amount + "')";
            pst = con.prepareStatement(i);
            pst.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
        billtableload();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int j = jTable2.getSelectedRow();

        String date = jTable2.getValueAt(j, 0).toString();
        String billno = jTable2.getValueAt(j, 1).toString();
        String amount = jTable2.getValueAt(j, 2).toString();

        jDateChooser1.setDateFormatString(date);
        jLabel17.setText(billno);
        amountbox.setText(amount);

    }//GEN-LAST:event_jTable2MouseClicked

    private void nameboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameboxKeyTyped

        //Name box textbox
        char vshar = evt.getKeyChar();
        if (Character.isDigit(vshar)) {
            evt.consume();
            namebox.setBackground(Color.RED);
            //JOptionPane.showMessageDialog(null,"Invalid enter");
        } else {
            namebox.setBackground(Color.white);
        }

    }//GEN-LAST:event_nameboxKeyTyped

    private void addressboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressboxKeyTyped

        //Address textbox
        char vshar = evt.getKeyChar();
        if (Character.isDigit(vshar)) {
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Invalid enter");
            addressbox.setBackground(Color.red);
        } else {
            addressbox.setBackground(Color.white);
        }

    }//GEN-LAST:event_addressboxKeyTyped

    private void buildingboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buildingboxKeyTyped

        //building textbox
        char vshar = evt.getKeyChar();
        if (Character.isDigit(vshar)) {
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Invalid enter");
            buildingbox.setBackground(Color.red);
        } else {
            buildingbox.setBackground(Color.white);
        }

    }//GEN-LAST:event_buildingboxKeyTyped

    private void landboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_landboxKeyTyped

        //landmarks textbox
        char vshar = evt.getKeyChar();
        if (Character.isDigit(vshar)) {
            evt.consume();
            landbox.setBackground(Color.red);
        } else {
            landbox.setBackground(Color.white);
        }

    }//GEN-LAST:event_landboxKeyTyped

    private void contactboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactboxKeyTyped

        //contact no textbox
        
        
        String contactNum = contactbox.getText();
        char alpha = evt.getKeyChar();
        if(contactNum.length()<1 && alpha != '0'){
        
            evt.consume();
            
        }
        else if(contactNum.length()==10){
            evt.consume();
            
        
        }

        /* int key = evt.getKeyCode();
        if((key>=evt.VK_0&&key<=evt.VK_9)||(key>=evt.VK_NUMPAD0&&key<=evt.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE)
        {
            contactbox.setEditable(true);
            contactbox.setBackground(Color.yellow);
        }
        else
        {
            contactbox.setEditable(false);
            contactbox.setBackground(Color.RED);
        }
         */
    }//GEN-LAST:event_contactboxKeyTyped

    private void priceboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceboxKeyTyped

        //price textbox
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, " numbers only");
        }

    }//GEN-LAST:event_priceboxKeyTyped

    private void jComboBox1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyTyped

        String table = jComboBox1.getSelectedItem().toString();

        if (table.contains("0")) {
            JOptionPane.showMessageDialog(null, "Enter the table number");
            jComboBox1.setBackground(Color.red);
        } else {
            jComboBox1.setBackground(Color.white);
        }

    }//GEN-LAST:event_jComboBox1KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete");

        if (x == 0) {
            String tableno = jComboBox1.getSelectedItem().toString();

            String q = "DELETE from temporder WHERE tableNO='" + tableno + "'";

            try {
                pst = con.prepareStatement(q);
                pst.execute();
                temptableload();

            } catch (Exception e) {
            }
        }
        jComboBox1.setSelectedItem("0");
        foodbox.setText(null);
        jComboBox2.setSelectedItem("1");
        pricebox.setText(null);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void priceboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceboxActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

    private void amountboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountboxActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        String fID = foodbox.getText();

        String q = "SELECT SUM(tfprice) as 'tot' FROM temporder ";

        try {
            pst = con.prepareStatement(q);
            rs1 = pst.executeQuery();

            while (rs1.next()) {
                ans.setText(rs1.getString("tot"));
                System.out.println(rs1.getString("price").toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        String tableno = jComboBox1.getSelectedItem().toString();

        String r = "DELETE from temporder WHERE tableNO='" + tableno + "'";

        try {
            pst = con.prepareStatement(r);
            pst.execute();
            temptableload();

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void contactboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactboxKeyPressed

      /*  int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE) {
            contactbox.setEditable(true);
            contactbox.setBackground(Color.yellow);
        } else {
            contactbox.setEditable(false);
            contactbox.setBackground(Color.RED);
        }
        */

    }//GEN-LAST:event_contactboxKeyPressed

    private void contactboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactboxActionPerformed

    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped

        if (jDateChooser1.contains(null)) {
            jDateChooser1.setBackground(Color.red);
        } else {
            jDateChooser1.setBackground(Color.white);
        }

    }//GEN-LAST:event_jDateChooser1KeyTyped

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String fID = foodbox.getText();

        String q = "SELECT SUM(tfprice) as 'tot' FROM temporder ";

        try {
            pst = con.prepareStatement(q);
            rs1 = pst.executeQuery();

            while (rs1.next()) {
                ans.setText(rs1.getString("tot"));
                System.out.println(rs1.getString("price").toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        HeadChef hc = new HeadChef();
        hc.setVisible(true);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        namebox.setText(null);
        contactbox.setText(null);
        addressbox.setText(null);
        buildingbox.setText(null);
        landbox.setText(null);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // LOGOUT

        loggin log = new loggin();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
         hub h = new hub();
                    h.jButton2.setEnabled(false);
                    h.jButton4.setEnabled(false);
                    h.jButton5.setEnabled(false);
                    h.jButton6.setEnabled(false);
                    h.jButton7.setEnabled(false);
                    h.jButton8.setEnabled(false);

                    h.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Monthss4;
    private javax.swing.JTextField addressbox;
    private javax.swing.JTextField amountbox;
    private javax.swing.JTextField ans;
    private javax.swing.JTextField buildingbox;
    private javax.swing.JLabel clockss4;
    private javax.swing.JTextField contactbox;
    private javax.swing.JLabel datess4;
    private javax.swing.JLabel dayss4;
    private javax.swing.JTextField foodbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField landbox;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField pricebox;
    private javax.swing.JLabel yearss4;
    // End of variables declaration//GEN-END:variables
}
