/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import prtype.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import static prtype.validations.truecount;

/**
 *
 * @author User
 */
public class Add extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    int time = 0;

    public Add() {
        initComponents();
        con = DBconnection.connect();
        setfullscreen();

        vTableload();
        pTableload();
        tTableload();
        pkTableload();
        rTableload();

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
                    clockss3.setText(clock);
                    clockss4.setText(clock);

                    dayss.setText(day);
                    dayss2.setText(day);
                    dayss3.setText(day);
                    dayss4.setText(day);

                    yearss.setText(String.valueOf(year));
                    yearss2.setText(String.valueOf(year));
                    yearss3.setText(String.valueOf(year));
                    yearss4.setText(String.valueOf(year));

                    Monthss.setText(String.valueOf(Month));
                    Monthss2.setText(String.valueOf(Month));
                    Monthss3.setText(String.valueOf(Month));
                    Monthss4.setText(String.valueOf(Month));

                    datess.setText(String.valueOf(date));
                    datess2.setText(String.valueOf(date));
                    datess3.setText(String.valueOf(date));
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

        int x = xsize;//(xsize * 84) / 100;
        int y = ysize;//(ysize * 84) / 100;

        this.setSize(x, y);//set size

        //moving to the center
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int Width = this.getSize().width;
        int Height = this.getSize().height;

        int locationx = (dimension.width - Width) / 2;
        int locationy = (dimension.height - Height) / 2;

        this.setLocation(locationx, locationy);

    }

    public void pTableload() {
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;

            String str = "Select * from package";
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }

    }

    public void vTableload() {
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;

            String str = "Select * from vehicle";
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }

    }

    public void tTableload() {
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;

            String str = "Select tourID,RID,Name,Phone,VehicleNo,Date,Destination,Distance,Rate,Price from transporttour";
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();

            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }

    }

    public void pkTableload() {
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;

            String str = "Select tourID,RID,Name,Phone,VehicleNo,PackageId,Date,Days,Price from packagetour";
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();

            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }
    }   
        
    public void rTableload()
    {
        try
        {
        
        ps= null;
        rs=null;    
            
        String str="Select * from rate";
        ps=con.prepareStatement(str);
        rs=ps.executeQuery();
        
        jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Vno = new javax.swing.JTextField();
        capacity = new javax.swing.JTextField();
        model = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        clockss = new javax.swing.JLabel();
        dayss = new javax.swing.JLabel();
        yearss = new javax.swing.JLabel();
        Monthss = new javax.swing.JLabel();
        datess = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();
        pricebox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        yearss2 = new javax.swing.JLabel();
        Monthss2 = new javax.swing.JLabel();
        datess2 = new javax.swing.JLabel();
        clockss2 = new javax.swing.JLabel();
        dayss2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        des = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        lbPid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pName = new javax.swing.JTextField();
        pricepday = new javax.swing.JTextField();
        days = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        datess4 = new javax.swing.JLabel();
        yearss4 = new javax.swing.JLabel();
        Monthss4 = new javax.swing.JLabel();
        clockss4 = new javax.swing.JLabel();
        dayss4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        rtype = new javax.swing.JTextField();
        rrate = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        datess3 = new javax.swing.JLabel();
        yearss3 = new javax.swing.JLabel();
        Monthss3 = new javax.swing.JLabel();
        clockss3 = new javax.swing.JLabel();
        dayss3 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Availability");

        type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Model");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("Vehicle information");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Type");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Capacity");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("VehicleNo");

        Vno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Vno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VnoActionPerformed(evt);
            }
        });

        capacity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacityActionPerformed(evt);
            }
        });

        model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton7.setText("RESET");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "VehicleNo", "Model", "Capacity", "AC", "Type", "DriverID", "Availability"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("AC");

        clockss.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss.setText("jLabel40");

        dayss.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss.setText("AM");

        yearss.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss.setText("year");

        Monthss.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss.setText("month");

        datess.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess.setText("date");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("AC");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Non AC");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Yes");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("No");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Price");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(590, 590, 590)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(clockss, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dayss))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(yearss)
                        .addGap(18, 18, 18)
                        .addComponent(Monthss)
                        .addGap(10, 10, 10)
                        .addComponent(datess))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel10)
                        .addGap(86, 86, 86)
                        .addComponent(Vno, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel12)
                        .addGap(86, 86, 86)
                        .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(jLabel13)
                        .addGap(62, 62, 62)
                        .addComponent(jRadioButton1)
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButton2)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel44)
                        .addGap(33, 33, 33)
                        .addComponent(pricebox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(jRadioButton3)
                .addGap(2, 2, 2)
                .addComponent(jRadioButton4)
                .addContainerGap(178, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clockss)
                    .addComponent(dayss))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(yearss))
                    .addComponent(Monthss)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(datess)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(Vno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel12))
                            .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel13))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jRadioButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel44))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(pricebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton4))))))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton2)))
                .addGap(189, 189, 189))
        );

        jTabbedPane1.addTab("Vehicle", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

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
        jScrollPane3.setViewportView(jTable3);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Tour ID");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("RID");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Name");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("...............");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("...............");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("...............");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Phone");

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

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Vehicle No");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("................");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Date");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("................");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton10.setText("Reset");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/contact.png"))); // NOI18N
        jButton11.setText("Change Contact Number");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        yearss2.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss2.setText("year");

        Monthss2.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss2.setText("month");

        datess2.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess2.setText("date");

        clockss2.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss2.setText("jLabel40");

        dayss2.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss2.setText("AM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clockss2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayss2)
                                .addGap(39, 39, 39))
                            .addComponent(jLabel26)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(yearss2)
                                .addGap(18, 18, 18)
                                .addComponent(Monthss2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datess2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton11)
                        .addGap(38, 38, 38)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clockss2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dayss2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearss2)
                            .addComponent(Monthss2)
                            .addComponent(datess2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jLabel26)
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transport Tour", jPanel3);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Package Information");

        des.setColumns(20);
        des.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        des.setRows(5);
        jScrollPane4.setViewportView(des);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("PackageId");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Description");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("PricepDay");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Days");

        pName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNameActionPerformed(evt);
            }
        });
        pName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pNameKeyTyped(evt);
            }
        });

        pricepday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pricepday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricepdayActionPerformed(evt);
            }
        });
        pricepday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pricepdayKeyTyped(evt);
            }
        });

        days.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysActionPerformed(evt);
            }
        });
        days.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                daysKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton8.setText("Reset");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PackageId", "Name", "Price per Day", "Days", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/power-button-md.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        datess4.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess4.setText("date");

        yearss4.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss4.setText("year");

        Monthss4.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss4.setText("month");

        clockss4.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss4.setText("jLabel40");

        dayss4.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss4.setText("AM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton23)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(clockss4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dayss4)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(yearss4)
                        .addGap(18, 18, 18)
                        .addComponent(Monthss4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datess4)))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel14))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbPid, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pricepday, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clockss4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dayss4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearss4)
                            .addComponent(Monthss4)
                            .addComponent(datess4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(lbPid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pricepday, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton1)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jButton23))
        );

        jTabbedPane1.addTab("Package", jPanel1);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rtype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rtypeKeyTyped(evt);
            }
        });

        rrate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setText("No             :");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setText("Type          :");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setText("Rate          :");

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/add.png"))); // NOI18N
        jButton15.setText("Add");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Update.png"))); // NOI18N
        jButton16.setText("Update");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton17.setText("Delete");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton18.setText("Reset");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel40))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rtype)
                            .addComponent(rrate, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(151, 151, 151)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(782, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(222, 222, 222)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton17)
                            .addComponent(jButton15)
                            .addComponent(jButton16)
                            .addComponent(jButton18)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rate", jPanel5);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

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

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Tour Id");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("RID");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Name");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Phone");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Vehicle No");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Package Id");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Date");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText(".........................");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText(".........................");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText(".........................");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("........................");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("........................");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("........................");

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/contact.png"))); // NOI18N
        jButton12.setText("Change Contact Number ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/delete.png"))); // NOI18N
        jButton13.setText("DELETE");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/reset.png"))); // NOI18N
        jButton14.setText("Reset");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/power-button-md.png"))); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        datess3.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        datess3.setText("date");

        yearss3.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        yearss3.setText("year");

        Monthss3.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        Monthss3.setText("month");

        clockss3.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        clockss3.setText("jLabel40");

        dayss3.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        dayss3.setText("AM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addGap(351, 351, 351)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(clockss3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(dayss3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(yearss3)
                        .addGap(18, 18, 18)
                        .addComponent(Monthss3)
                        .addGap(10, 10, 10)
                        .addComponent(datess3))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton12)
                .addGap(97, 97, 97)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1494, 1494, 1494)
                .addComponent(jButton24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clockss3)
                            .addComponent(dayss3))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Monthss3)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearss3)
                                    .addComponent(datess3)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel35)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel36)
                                .addGap(43, 43, 43)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel37)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel38)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel39)))))
                .addGap(107, 107, 107)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addGap(345, 345, 345)
                .addComponent(jButton24))
        );

        jTabbedPane1.addTab("Package Tour", jPanel4);

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/Home+Button.png"))); // NOI18N
        jButton19.setText("HOME");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/images/power-button-md.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19)
                    .addComponent(jButton21))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daysActionPerformed

    private void pricepdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricepdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricepdayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            String name = pName.getText();
            String desc = des.getText();
            String price = pricepday.getText();
            String day = days.getText();
            
        prtype.validations.emptyCheck(name);
        prtype.validations.emptyCheck(desc);
        prtype.validations.emptyCheck(price);
        prtype.validations.emptyCheck(day);
        
       
        
        if(truecount==4){
            
        
        
        
        int x = JOptionPane.showConfirmDialog(null, "Do you want to add this package?");

        if (x == 0) {
            

            try {
                String q = "INSERT INTO package(pName,price,days,description) values('" + name + "','" + price + "','" + day + "','" + desc + "')";
                ps = con.prepareStatement(q);
                ps.execute();
                pTableload();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
            truecount=0;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You cannot have empty fields!","Warning",JOptionPane.WARNING_MESSAGE);
            truecount=0;
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void VnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VnoActionPerformed

    private void capacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capacityActionPerformed

    private void modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void pNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String vac="";
        String vav="";
        
        
        String vehicleno= Vno.getText();
        String vmodel= model.getText();
        String vcapacity= capacity.getText();
        
        String vtype=type.getText();
        String price=pricebox.getText();
        
        if(jRadioButton3.isSelected()){
            vav="y";
        }
        
        else if(jRadioButton4.isSelected()){
            vav="n";
        }
        
        
        if(jRadioButton1.isSelected()){
            vac="AC";
        }
        else if(jRadioButton2.isSelected()){
             vac="Non AC";
        }
        
        
            
        prtype.validations.emptyCheck(vehicleno);
        prtype.validations.emptyCheck(vmodel);
        prtype.validations.emptyCheck(vcapacity);
        prtype.validations.emptyCheck(vac);
        prtype.validations.emptyCheck(vtype);
        prtype.validations.emptyCheck(vav);
        prtype.validations.emptyCheck(price);
        
        if(truecount==7)
        {    
            
            
            int x=JOptionPane.showConfirmDialog(null,"Do you want to add new vehicle?");
                if(x==0)
                {
                   
                    
                    try
                    {  
                    
                        String q= "INSERT INTO vehicle(vehicleNo, model, capacity,AC,type,Price,availability) values('"+vehicleno+"','"+vmodel+"','"+vcapacity+"','"+vac+"','"+vtype+"','"+price+"','"+vav+"')";
                        ps= con.prepareStatement(q);
                        ps.execute();
                        vTableload();
                    }
       
                    catch(SQLException e){
                        System.out.println(e);   
                    }        
                }
                truecount=0;
        }
        
        
        
        
        else{
            JOptionPane.showMessageDialog(null,"You cannot have empty fields!","Warning",JOptionPane.WARNING_MESSAGE);
            truecount=0;}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int r = jTable2.getSelectedRow();

        String pid = jTable2.getValueAt(r, 0).toString();
        String pname = jTable2.getValueAt(r, 1).toString();
        String pprice = jTable2.getValueAt(r, 2).toString();
        String pdays = jTable2.getValueAt(r, 3).toString();
        String pdesc = jTable2.getValueAt(r, 4).toString();

        lbPid.setText(pid);
        pName.setText(pname);
        pricepday.setText(pprice);
        days.setText(pdays);
        des.setText(pdesc);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String ppid = lbPid.getText();
            String pname = pName.getText();
            String ppricepday = pricepday.getText();
            String pdays = days.getText();
            String pdes = des.getText();
            
            prtype.validations.emptyCheck(pname);
        prtype.validations.emptyCheck(ppricepday);
        prtype.validations.emptyCheck(pdays);
        prtype.validations.emptyCheck(pdes);
        
        if(truecount==4){
        
        int x = JOptionPane.showConfirmDialog(null, "Do you want to update this package?");

        if (x == 0) {
            

            String q = "UPDATE package SET pName='" + pname + "',price='" + ppricepday + "' , days='" + pdays + "', description='" + pdes + "'  where pID= '" + ppid + "'";
            try {
                ps = con.prepareStatement(q);
                ps.execute();
                pTableload();

            } catch (Exception e) {
                System.out.println(e);
            }
        }truecount=0;
        }
        else{
             JOptionPane.showMessageDialog(null,"You cannot have empty fields!","Warning",JOptionPane.WARNING_MESSAGE);
            truecount=0;
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this package?");

        if (x == 0) {
            String pckgid = lbPid.getText();
            String que = "DELETE from package where pID='" + pckgid + "'";

            try {
                ps = con.prepareStatement(que);
                ps.execute();
                pTableload();
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r1 = jTable1.getSelectedRow();

        String vno = jTable1.getValueAt(r1, 0).toString();
        String vmod = jTable1.getValueAt(r1, 1).toString();
        String vcap = jTable1.getValueAt(r1, 2).toString();
        String vac = jTable1.getValueAt(r1, 3).toString();
        String vtype = jTable1.getValueAt(r1, 4).toString();
        String price=jTable1.getValueAt(r1,5).toString();
        String vav = jTable1.getValueAt(r1, 6).toString();


        Vno.setText(vno);
        model.setText(vmod);
        capacity.setText(vcap);
        
        type.setText(vtype);

        pricebox.setText(price);
   
        
        if(vac.equals("AC")){
            jRadioButton1.setSelected(true);
            
        }
        
        else if(vac.equals("Non AC")){
            jRadioButton2.setSelected(true);
        }
        
        if(vav.equals("y")){
            jRadioButton3.setSelected(true);
            
        }
        
        else if(vav.equals("n")){
            jRadioButton4.setSelected(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int x=JOptionPane.showConfirmDialog(null,"Delete this entry?");
        
        if(x==0){
        String no=Vno.getText();
        String que="DELETE from vehicle where vehicleNo='"+no+"'";
        
        try{
            ps=con.prepareStatement(que);
            ps.execute();
            vTableload();
            
            Vno.setText("");
            model.setText("");
            capacity.setText("");
        
            type.setText("");
            pricebox.setText("");
         
        
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
        }
            
        catch(Exception e)
       {
           System.out.println(e);     
                
        }
        }     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you want to clear all the fields?");

        if (x == 0) {
            lbPid.setText("");
            pName.setText("");
            pricepday.setText("");
            days.setText("");
            des.setText("");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String no= Vno.getText();
       String mod=model.getText();
       String cap=capacity.getText();
       
       String tp=type.getText();
       String price=pricebox.getText();
      
       String vac="";
       String vav="";
       
       if(jRadioButton1.isSelected()){
            vac="AC";
        }
        else if(jRadioButton2.isSelected()){
             vac="Non AC";
        }
       
       if(jRadioButton3.isSelected()){
            vav="y";
        }
        
        else if(jRadioButton4.isSelected()){
            vav="n";
        }
       
       
       
       
        prtype.validations.emptyCheck(no);
        prtype.validations.emptyCheck(mod);
        prtype.validations.emptyCheck(cap);
        prtype.validations.emptyCheck(vac);
        prtype.validations.emptyCheck(tp);
        prtype.validations.emptyCheck(vav);
        prtype.validations.emptyCheck(price);
       
        
        if(truecount==7){
       
       int x=JOptionPane.showConfirmDialog(null,"Do you want to update this vehicle?");
       if(x==0){
       
       String srti="UPDATE vehicle SET model='"+mod+"', capacity='"+cap+"', AC='"+vac+"', type='"+tp+"', Price='"+price+"', availability='"+vav+"' where vehicleNo='"+no+"' ";
       
        try {
            ps=con.prepareStatement(srti);
            ps.execute();
            vTableload();
        } catch (Exception e) {
            
            System.out.println(e);}

        
            try {
                ps = con.prepareStatement(srti);
                ps.execute();
                vTableload();
            } 
            catch (Exception e) {
                System.out.println(e);
            }

        }
        truecount=0;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You cannot have empty fields!","Warning",JOptionPane.WARNING_MESSAGE);
            truecount=0;}
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Vno.setText("");
        model.setText("");
        capacity.setText("");
       
        type.setText("");

        pricebox.setText("");
        
        
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to change phone number?");

        if (x == 0) {
            String newp = jTextField1.getText();
            String ttid = jLabel18.getText();

            String q = "UPDATE transporttour SET Phone='" + newp + "' where tourID= '" + ttid + "'";
            try {
                ps = con.prepareStatement(q);
                ps.execute();
                tTableload();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int r = jTable3.getSelectedRow();

        String aid = jTable3.getValueAt(r, 0).toString();
        String arid = jTable3.getValueAt(r, 1).toString();
        String aname = jTable3.getValueAt(r, 2).toString();
        String aphone = jTable3.getValueAt(r, 3).toString();
        String avehi = jTable3.getValueAt(r, 4).toString();
        String adate = jTable3.getValueAt(r, 5).toString();

        jLabel18.setText(aid);
        jLabel19.setText(arid);
        jLabel20.setText(aname);
        jTextField1.setText(aphone);
        jLabel23.setText(avehi);
        jLabel25.setText(adate);
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this transport tour?");

        if (x == 0) {
            String ttid = jLabel18.getText();
            String que = "DELETE from transporttour where tourID='" + ttid + "'";

            try {
                ps = con.prepareStatement(que);
                ps.execute();
                tTableload();
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to clear all the fields?");

        if (x == 0) {
            jLabel18.setText("");
            jLabel19.setText("");
            jLabel20.setText("");
            jLabel23.setText("");
            jLabel25.setText("");
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int r = jTable4.getSelectedRow();

        String bid = jTable4.getValueAt(r, 0).toString();
        String brid = jTable4.getValueAt(r, 1).toString();
        String bname = jTable4.getValueAt(r, 2).toString();
        String bphone = jTable4.getValueAt(r, 3).toString();
        String bvehi = jTable4.getValueAt(r, 4).toString();
        String bpckgid = jTable4.getValueAt(r, 5).toString();
        String bdate = jTable4.getValueAt(r, 6).toString();

        jLabel34.setText(bid);
        jLabel35.setText(brid);
        jLabel36.setText(bname);
        jTextField2.setText(bphone);
        jLabel37.setText(bvehi);
        jLabel38.setText(bpckgid);
        jLabel39.setText(bdate);

    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to change phone number?");

        if (x == 0) {
            String newp = jTextField2.getText();
            String ttid = jLabel34.getText();

            String q = "UPDATE packagetour SET Phone='" + newp + "' where tourID= '" + ttid + "'";
            try {
                ps = con.prepareStatement(q);
                ps.execute();
                pkTableload();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this transport tour?");

        if (x == 0) {
            String ttid = jLabel34.getText();
            String que = "DELETE from packagetour where tourID='" + ttid + "'";

            try {
                ps = con.prepareStatement(que);
                ps.execute();
                pkTableload();
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to clear all the fields?");

        if (x == 0) {
            jLabel34.setText("");
            jLabel35.setText("");
            jLabel36.setText("");
            jLabel37.setText("");
            jLabel38.setText("");
            jLabel39.setText("");
            jTextField2.setText("");

        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // LOG OUT

        loggin log = new loggin();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1KeyTyped

    private void pricepdayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricepdayKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_pricepdayKeyTyped

    private void daysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daysKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_daysKeyTyped

    private void pNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pNameKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_pNameKeyTyped

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int r= jTable5.getSelectedRow();
        
        String no=jTable5.getValueAt(r,0).toString();
        String typ=jTable5.getValueAt(r,1).toString();
        String rate= jTable5.getValueAt(r, 2).toString();
        
        jLabel43.setText(no);
        rtype.setText(typ);
        rrate.setText(rate);
        
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String typ= rtype.getText();
        String rate= rrate.getText();
        
        prtype.validations.emptyCheck(typ);
        prtype.validations.emptyCheck(rate);
        
        
        if(truecount==2){
        
        int x=JOptionPane.showConfirmDialog(null,"Do you want to add new type?");
                if(x==0)
                {
                   
                    
                    try
                    {  
                    
                        String q= "INSERT INTO rate(Type,Rate) values('"+typ+"','"+rate+"')";
                        ps= con.prepareStatement(q);
                        ps.execute();
                        rTableload();
                    }
       
                    catch(SQLException e){
                        System.out.println(e);   
                    }        
                }
                truecount=0;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You cannot have empty fields!","Warning",JOptionPane.WARNING_MESSAGE);
            truecount=0;
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String typ=rtype.getText();
       String rate=rrate.getText();
       String no=jLabel43.getText();
      
        prtype.validations.emptyCheck(typ);
        prtype.validations.emptyCheck(rate);
        
        if(truecount==2){
       
       int x=JOptionPane.showConfirmDialog(null,"Do you want to update rate?");
       if(x==0){
       
       String srti="UPDATE rate SET Type='"+typ+"', Rate='"+rate+"' where No='"+no+"'";
       
        try {
            ps=con.prepareStatement(srti);
            ps.execute();
            rTableload();
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
       }
        truecount=0;}
       else {
           JOptionPane.showMessageDialog(null,"You cannot have empty fields!","Warning",JOptionPane.WARNING_MESSAGE);
            truecount=0;
       }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        int x=JOptionPane.showConfirmDialog(null,"Delete this entry?");
        
        if(x==0){
        String no=jLabel43.getText();
        String que="DELETE from rate where No='"+no+"'";
        
        try{
            ps=con.prepareStatement(que);
            ps.execute();
            rTableload();
            
            jLabel43.setText("");
            rtype.setText("");
            rrate.setText("");
        
               
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jLabel43.setText("");
            rtype.setText("");
            rrate.setText("");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void rtypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rtypeKeyTyped
       char tchar=evt.getKeyChar();
        if(Character.isDigit(tchar))
        {
            evt.consume();
        }
    }//GEN-LAST:event_rtypeKeyTyped

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        hub h=new hub();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton19ActionPerformed

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
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Monthss;
    private javax.swing.JLabel Monthss2;
    private javax.swing.JLabel Monthss3;
    private javax.swing.JLabel Monthss4;
    private javax.swing.JTextField Vno;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField capacity;
    private javax.swing.JLabel clockss;
    private javax.swing.JLabel clockss2;
    private javax.swing.JLabel clockss3;
    private javax.swing.JLabel clockss4;
    private javax.swing.JLabel datess;
    private javax.swing.JLabel datess2;
    private javax.swing.JLabel datess3;
    private javax.swing.JLabel datess4;
    private javax.swing.JTextField days;
    private javax.swing.JLabel dayss;
    private javax.swing.JLabel dayss2;
    private javax.swing.JLabel dayss3;
    private javax.swing.JLabel dayss4;
    private javax.swing.JTextArea des;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbPid;
    private javax.swing.JTextField model;
    private javax.swing.JTextField pName;
    private javax.swing.JTextField pricebox;
    private javax.swing.JTextField pricepday;
    private javax.swing.JTextField rrate;
    private javax.swing.JTextField rtype;
    private javax.swing.JTextField type;
    private javax.swing.JLabel yearss;
    private javax.swing.JLabel yearss2;
    private javax.swing.JLabel yearss3;
    private javax.swing.JLabel yearss4;
    // End of variables declaration//GEN-END:variables
}
