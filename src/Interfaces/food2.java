/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.mysql.jdbc.Connection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import prtype.DBconnection;
import prtype.validations;
import java.awt.event.KeyEvent;

/**
 *
 * @author ASUS
 */
public class food2 extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int time=0;

    public food2() {
        initComponents();
        con = DBconnection.connect(); // database connection
        tableload();    // getting the infrmation from the database and pushing them to the jTable
        table3load();
        table1load();
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

                    clockss7.setText(clock);
                    dayss7.setText(day);
                    yearss7.setText(String.valueOf(year));
                    Monthss7.setText(String.valueOf(Month));
                    datess7.setText(String.valueOf(date));
                }
            }
        }.start();

    }

    public void setfullscreen() { // full screen adjustment

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

    public void tableload() {  // getting result set from database

        try {
            String sqq = "SELECT SupplierId,Name,Address,ContactNumber FROM supplier";
            pst = con.prepareStatement(sqq);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void table3load() {
        String sqs = " SELECT purchaseID,purchasedate,totalprize,description FROM foodpurchase";
        try {
            pst = con.prepareStatement(sqs);
            rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            ;
        } catch (Exception e) {
        }
    }

    public void table1load() {
        String sss = "SELECT ItemId,Name,Needed,OnHand,LeftToBuy,SupplierId from foodin";
        try {
            pst = con.prepareStatement(sss);
            rs = pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        sadd = new javax.swing.JTextField();
        scon = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cost = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        Datec = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        onhand = new javax.swing.JTextField();
        left = new javax.swing.JTextField();
        ssid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        needed = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Monthss7 = new javax.swing.JLabel();
        datess7 = new javax.swing.JLabel();
        yearss7 = new javax.swing.JLabel();
        clockss7 = new javax.swing.JLabel();
        dayss7 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.setName("FOOD"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Supplier ID");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Address");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Contact Number");

        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        sname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                snameKeyTyped(evt);
            }
        });

        scon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sconKeyTyped(evt);
            }
        });

        jLabel14.setText("Supplier ID");

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
        jScrollPane2.setViewportView(jTable2);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton5.setText("Add Supplier");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton6.setText("Remove Supplier");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton7.setText("Update Info");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/report.png"))); // NOI18N
        jButton8.setText("Report");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setBorderPainted(false);

        jLabel9.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jLabel9.setText("Supplier");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sadd, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(sname)
                            .addComponent(scon, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(50, 50, 50)))
                        .addGap(258, 258, 258))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(0, 99, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(349, 349, 349))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(sadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(scon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supplier", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Purchase ID");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Date");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Total Cost");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Description");

        jLabel19.setText("PID");

        cost.setText("                      ");
        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costKeyTyped(evt);
            }
        });

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
        jScrollPane3.setViewportView(jTable3);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton9.setText("Add");
        jButton9.setBorder(new javax.swing.border.MatteBorder(null));
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/report.png"))); // NOI18N
        jButton10.setText("Report");
        jButton10.setBorder(new javax.swing.border.MatteBorder(null));
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane4.setViewportView(desc);

        jLabel20.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jLabel20.setText("Purchases");

        Datec.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(cost, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(Datec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(Datec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(304, 304, 304))))
        );

        jTabbedPane1.addTab("Purchases", jPanel4);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        onhand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onhandActionPerformed(evt);
            }
        });
        onhand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onhandKeyTyped(evt);
            }
        });

        left.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                leftKeyTyped(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTable4);

        jLabel8.setText("Item ID");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton2.setText("Remove");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/report.png"))); // NOI18N
        jButton4.setText("View Needed");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setBorderPainted(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Item ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Needed");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("On Hand");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Left to Buy");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Supplier ID");

        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });

        needed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                neededKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jLabel7.setText("FOOD INVENTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ssid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(left, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(onhand, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(needed, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fname, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(733, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(492, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(109, 109, 109)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(needed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(onhand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Food", jPanel1);

        Monthss7.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss7.setText("month");

        datess7.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess7.setText("date");

        yearss7.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss7.setText("year");

        clockss7.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss7.setText("jLabel40");

        dayss7.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss7.setText("AM");

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Home+Button.png"))); // NOI18N
        jButton16.setText("Home");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/back.png"))); // NOI18N
        jButton17.setText("Back");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yearss7)
                        .addGap(18, 18, 18)
                        .addComponent(Monthss7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datess7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clockss7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dayss7)
                        .addGap(27, 27, 27)))
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockss7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayss7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearss7)
                    .addComponent(Monthss7)
                    .addComponent(datess7)
                    .addComponent(jButton17)
                    .addComponent(jButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("food");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onhandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onhandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onhandActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String name = sname.getText();     // adding the food supplier infomation to the supplier table in hms database
        String add = sadd.getText();
        int cont = Integer.parseInt(scon.getText());

        String contt = Integer.toString(cont);

        validations v4 = new validations();

        boolean a = v4.vcus(name);
        boolean b = v4.vcus(add);
        boolean c = v4.vcus(contt);

        if (a == true && b == true && c == true) {
            try {
                String s = "INSERT INTO supplier (Name,Address,ContactNumber) VALUES ('" + name + "','" + add + "','" + cont + "') ";
                pst = con.prepareStatement(s);
                pst.execute();
                tableload();

                sname.setText("");
                sadd.setText("");
                scon.setText("");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            sname.setText("");
            sadd.setText("");
            scon.setText("");
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Confirm Delete");   // deleting the supplier infomation
        if (x == 0) {
            String idd = jLabel14.getText();
            try {
                String sss = "DELETE FROM supplier WHERE SupplierId = '" + idd + "'";
                pst = con.prepareStatement(sss);
                pst.execute();
                tableload();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int r = jTable2.getSelectedRow();                        // setting the mouseclicked event in jTable
        String id = jTable2.getValueAt(r, 0).toString();
        String nm = jTable2.getValueAt(r, 1).toString();
        String num = jTable2.getValueAt(r, 2).toString();
        String addr = jTable2.getValueAt(r, 3).toString();

        jLabel14.setText(id);
        sname.setText(nm);
        sadd.setText(num);
        scon.setText(addr);

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Confirm Update ");  // update the supplier table
        if (x == 0) {
            String name = sname.getText();
            String address = sadd.getText();
            String cont = scon.getText();

            try {
                String sss = "UPDATE supplier set Name = '" + name + "',Address = '" + address + "', ContactNumber = '" + cont + "' ";
                pst = con.prepareStatement(sss);
                pst.execute();
                tableload();

            } catch (Exception e) {

            }

        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        double costs = Double.parseDouble(cost.getText());                   // food purchases insertion
        String datee = ((JTextField) Datec.getDateEditor().getUiComponent()).getText();
        String dess = desc.getText();

        System.out.println(costs);
        System.out.println(datee);
        System.out.println(dess);

        String costss = Double.toString(costs);

        validations v2 = new validations();
        boolean a = v2.vcus(datee);
        boolean b = v2.vcus(dess);
        boolean c = v2.vcus(costss);

        if (a == true && b == true && c == true) {
            try {
                String sqq = "INSERT INTO foodpurchase(purchasedate,totalprize,description) VALUES ('" + datee + "','" + costs + "','" + dess + "')";
                pst = con.prepareStatement(sqq);
                pst.execute();

                cost.setText("");
                desc.setText("");

                String sqs = " SELECT purchaseID,purchasedate,totalprize,description FROM foodpurchase";          // getting the resultset in to the jTable
                pst = con.prepareStatement(sqs);
                rs = pst.executeQuery();

                jTable3.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            cost.setText("");
            desc.setText("");

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = fname.getText();
        String nd = needed.getText();
        String onh = onhand.getText();
        String leftf = left.getText();
        String supid = ssid.getText();

        validations v3 = new validations();  // validations

        boolean a = v3.vcus(name);
        boolean b = v3.vcus(nd);
        boolean c = v3.vcus(onh);
        boolean d = v3.vcus(leftf);
        boolean f = v3.vcus(supid);

        if (a == true && b == true && c == true && d == true && f == true) {  // insertion in to foodin table
            try {
                String ssss = "INSERT INTO foodin(Name,Needed,OnHand,LeftToBuy,SupplierID) VALUES ('" + name + "','" + nd + "','" + onh + "','" + leftf + "','" + supid + "')";
                pst = con.prepareStatement(ssss);
                pst.execute();

                fname.setText("");
                needed.setText("");
                onhand.setText("");
                left.setText("");
                ssid.setText("");

                table1load();

            } catch (Exception e) {

            }
        } else {
            fname.setText("");
            needed.setText("");
            onhand.setText("");
            left.setText("");
            ssid.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int x = jTable4.getSelectedRow();          // getting the information from table to the text boxes

        String id = jTable4.getValueAt(x, 0).toString();
        String name = jTable4.getValueAt(x, 1).toString();
        String nd = jTable4.getValueAt(x, 2).toString();
        String onh = jTable4.getValueAt(x, 3).toString();
        String leftf = jTable4.getValueAt(x, 4).toString();
        String supiid = jTable4.getValueAt(x, 5).toString();

        jLabel8.setText(id);
        fname.setText(name);
        needed.setText(nd);
        onhand.setText(onh);
        left.setText(leftf);
        ssid.setText(supiid);

    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int z = JOptionPane.showConfirmDialog(null, "Confirm Update");   //updation of food inventory
        if (z == 0) {

            String id = jLabel8.getText();
            String name = fname.getText();
            String nd = needed.getText();
            String onh = onhand.getText();
            String leftf = left.getText();
            String supid = ssid.getText();

            try {
                String ssq = " UPDATE foodin set Name = '" + name + "',Needed = '" + nd + "',OnHand = '" + onh + "',LeftToBuy = '" + leftf + "',SupplierID = '" + supid + "' WHERE ItemId = '" + id + "' ";
                pst = con.prepareStatement(ssq);
                pst.execute();
                table1load();

            } catch (Exception e) {

            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        /*int r = jTable3.getSelectedRow();
        
        String id = jTable3.getValueAt(r, 0).toString();
        String nm = jTable3.getValueAt(r, 1).toString();
        String num = jTable3.getValueAt(r, 2).toString();
        String nog = jTable3.getValueAt(r, 3).toString();
        
        
        
        jLabel19.setText(id);
        jTextField1.setText(nm);
        cost.setText(num);
        desc.setText(nog);*/

    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Confirm Delete");    //deleting food items
        if (x == 0) {
            String idd = jLabel8.getText();
            try {
                String oo = "DELETE FROM foodin WHERE ItemId = '" + idd + "'";
                pst = con.prepareStatement(oo);
                pst.execute();
                table1load();

            } catch (Exception e) {

            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void snameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_snameKeyTyped
       char b = evt.getKeyChar();
       
       if (!(Character.isLetter(b) || b == KeyEvent.VK_BACK_SPACE || b == KeyEvent.VK_SPACE)){
           getToolkit().beep();
           evt.consume();
       }
       
    }//GEN-LAST:event_snameKeyTyped

    private void sconKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sconKeyTyped
        char c = evt.getKeyChar();
        String ss = scon.getText();
        if(!(Character.isDigit(c)  || c == KeyEvent.VK_BACK_SPACE)){
            getToolkit().beep();
            evt.consume();
        }
        if(ss.length()<1 && c != '0'){
            evt.consume();
        }else if(ss.length() == 10){
            evt.consume();
        }
    }//GEN-LAST:event_sconKeyTyped

    private void costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c)  || c == KeyEvent.VK_BACK_SPACE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_costKeyTyped

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
        char b = evt.getKeyChar();
       
       if (!(Character.isLetter(b) || b == KeyEvent.VK_BACK_SPACE || b == KeyEvent.VK_SPACE)){
           getToolkit().beep();
           evt.consume();
       }
    }//GEN-LAST:event_fnameKeyTyped

    private void neededKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_neededKeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c)  || c == KeyEvent.VK_BACK_SPACE  || c=='.')){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_neededKeyTyped

    private void onhandKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onhandKeyTyped
       char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c)  || c == KeyEvent.VK_BACK_SPACE || c == '.')){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_onhandKeyTyped

    private void leftKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_leftKeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c)  || c == KeyEvent.VK_BACK_SPACE || c == '.')){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_leftKeyTyped

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       hub h = new hub();
            h.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Cater c = new Cater();
       c.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(food2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(food2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(food2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(food2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new food2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Datec;
    private javax.swing.JLabel Monthss7;
    private javax.swing.JLabel clockss7;
    private javax.swing.JTextField cost;
    private javax.swing.JLabel datess7;
    private javax.swing.JLabel dayss7;
    private javax.swing.JTextArea desc;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField left;
    private javax.swing.JTextField needed;
    private javax.swing.JTextField onhand;
    private javax.swing.JTextField sadd;
    private javax.swing.JTextField scon;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField ssid;
    private javax.swing.JLabel yearss7;
    // End of variables declaration//GEN-END:variables
}
