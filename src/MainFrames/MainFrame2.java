/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrames;

import DataEnteringFrames.GRNFrame;
import MyConn.MyConn;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Nuwantha
 */
public class MainFrame2 extends javax.swing.JFrame {

    int xMouse, yMouse;
    Font maxFont = new Font("Tahoma", Font.BOLD, 25);
    Font minFont = new Font("Tahoma", Font.BOLD, 20);

    /**
     * Creates new form LogInFrame
     */
    public MainFrame2() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Icon.jpg")));
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setSize(tk.getScreenSize());
        this.setLocation(0, 0);

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);
        jTextArea1.setOpaque(false);
        jTextArea1.setBackground(new Color(0, 0, 0, 30));
        
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportBorder(null);

         LogOut.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Logout.png")).getScaledInstance(163 - 10, 146, Image.SCALE_SMOOTH)));

        LogOut.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Logout.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        PosSystem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/POS.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        GRN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/GRN.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        Details.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Details.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        Reports.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Report.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        BarcodeGenarator.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Barcode.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        Backup.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Backup.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        Summary.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Summary.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        DataEntering.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/DataEntering.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        SendEMails.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/GMail.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));

        try {
            String sql = "select * from stock where inoinstock between 0 and 20 ";
            ResultSet rs = MyConn.search(sql);
            jTextArea1.setText("Stock Low :\n");
            while (rs.next()) {
                jTextArea1.setText(jTextArea1.getText() + rs.getString(1) + "-" + rs.getString(3) + "(" + rs.getString(7) + ")\n");
            }
            jTextArea1.setText(jTextArea1.getText()+"\nDue Deals With Suppliers :");
            Date today = new Date();
            java.sql.Date sqlToday = new java.sql.Date(today.getTime());
            Date tomorrow = new Date(today.getYear(), today.getMonth(), today.getDate() + 1);
            Date sqlTomorrow = new java.sql.Date(tomorrow.getTime());
            String sql1 = "select * from due where duefinishingdate = '"+sqlToday.toString()+"' or duefinishingdate = '"+sqlTomorrow+"'  " ;
            ResultSet rs1 = MyConn.search(sql1);
            while (rs1.next()) {                
                if (rs1.getBoolean(3)) {
                    String sql2 = "select * from grn where due_dueid = '"+rs1.getString(1) +"' " ;
                    ResultSet rs2 = MyConn.search(sql2);
                    while (rs2.next()) {   
                        String sql3 = "select sname from suppliers where sid = '"+rs2.getString(3) +"' " ;
                        ResultSet rs3 = MyConn.search(sql3);
                        while (rs3.next()) {                            
                            jTextArea1.setText(jTextArea1.getText()+"\nGRN No. "+rs2.getString(1)+" To "+rs3.getString(3)+"\n" );
                        }
                        
                    }
                } else {
                }
            }
        } catch (Exception e ) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        Details = new javax.swing.JLabel();
        Reports = new javax.swing.JLabel();
        LogOut = new javax.swing.JLabel();
        Backup = new javax.swing.JLabel();
        BarcodeGenarator = new javax.swing.JLabel();
        Summary = new javax.swing.JLabel();
        PosSystem = new javax.swing.JLabel();
        DataEntering = new javax.swing.JLabel();
        GRN = new javax.swing.JLabel();
        Settings = new javax.swing.JLabel();
        SendEMails = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("-");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(208, 208, 208))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setSelectionColor(new java.awt.Color(0, 51, 204));
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        Details.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        Details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DetailsMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetailsMouseClicked(evt);
            }
        });

        Reports.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Reports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Reports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        Reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportsMouseExited(evt);
            }
        });

        LogOut.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogOutMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });

        Backup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Backup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Backup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        Backup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackupMouseExited(evt);
            }
        });

        BarcodeGenarator.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BarcodeGenarator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BarcodeGenarator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        BarcodeGenarator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BarcodeGenaratorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BarcodeGenaratorMouseExited(evt);
            }
        });

        Summary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Summary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Summary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        Summary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SummaryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SummaryMouseExited(evt);
            }
        });

        PosSystem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PosSystem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PosSystem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        PosSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PosSystemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PosSystemMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PosSystemMouseClicked(evt);
            }
        });

        DataEntering.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DataEntering.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DataEntering.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        DataEntering.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DataEnteringMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DataEnteringMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataEnteringMouseClicked(evt);
            }
        });

        GRN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GRN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        GRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GRNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GRNMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GRNMouseClicked(evt);
            }
        });

        Settings.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Settings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Settings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        Settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SettingsMouseExited(evt);
            }
        });

        SendEMails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SendEMails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SendEMails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        SendEMails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SendEMailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SendEMailsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PosSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarcodeGenarator, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SendEMails, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DataEntering, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Summary, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LogOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Reports, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Details, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendEMails, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DataEntering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PosSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Summary, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarcodeGenarator, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1029, 731));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3KeyPressed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void DetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsMouseEntered
        Details.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Details.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Details");
    }//GEN-LAST:event_DetailsMouseEntered

    private void DetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsMouseExited
        Details.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Details.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_DetailsMouseExited

    private void DetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsMouseClicked
        DetailsFrames frame = new DetailsFrames();
        frame.setVisible(true);
    }//GEN-LAST:event_DetailsMouseClicked

    private void ReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsMouseExited
        Reports.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Report.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_ReportsMouseExited

    private void ReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsMouseEntered
        Reports.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Report.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Reports");
    }//GEN-LAST:event_ReportsMouseEntered

    private void LogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseExited
        LogOut.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Logout.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_LogOutMouseExited

    private void LogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseEntered
        LogOut.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Logout.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Log Out");
    }//GEN-LAST:event_LogOutMouseEntered

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        // TODO add your handling code here:
        LogInFrame frame = new LogInFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutMouseClicked

    private void BackupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackupMouseExited
        Backup.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Backup.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_BackupMouseExited

    private void BackupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackupMouseEntered
        Backup.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Backup.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Backup");
    }//GEN-LAST:event_BackupMouseEntered

    private void BarcodeGenaratorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarcodeGenaratorMouseEntered
        BarcodeGenarator.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Barcode.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Barcode Genarator");
    }//GEN-LAST:event_BarcodeGenaratorMouseEntered

    private void BarcodeGenaratorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarcodeGenaratorMouseExited
        BarcodeGenarator.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Barcode.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_BarcodeGenaratorMouseExited

    private void SummaryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SummaryMouseExited
        Summary.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Summary.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_SummaryMouseExited

    private void SummaryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SummaryMouseEntered
        Summary.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Summary.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Summary");
    }//GEN-LAST:event_SummaryMouseEntered

    private void PosSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosSystemMouseClicked
        PosFrame frame = new PosFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_PosSystemMouseClicked

    private void PosSystemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosSystemMouseExited
        PosSystem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/POS.png")).getScaledInstance(153, 147, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_PosSystemMouseExited

    private void PosSystemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PosSystemMouseEntered
        PosSystem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/POS.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("POS System");
    }//GEN-LAST:event_PosSystemMouseEntered

    private void DataEnteringMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataEnteringMouseExited
        DataEntering.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/DataEntering.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_DataEnteringMouseExited

    private void DataEnteringMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataEnteringMouseEntered
        DataEntering.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/DataEntering.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Data Entering");
    }//GEN-LAST:event_DataEnteringMouseEntered

    private void GRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GRNMouseClicked
        GRNFrame frame = new GRNFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_GRNMouseClicked

    private void GRNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GRNMouseExited
        GRN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/GRN.png")).getScaledInstance(153, 147, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_GRNMouseExited

    private void GRNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GRNMouseEntered
        GRN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/GRN.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("GRN");
    }//GEN-LAST:event_GRNMouseEntered

    private void SettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsMouseExited
        Settings.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Settings.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_SettingsMouseExited

    private void SettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsMouseEntered
        Settings.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Settings.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Settings");
    }//GEN-LAST:event_SettingsMouseEntered

    private void SendEMailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendEMailsMouseExited
        SendEMails.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/GMail.png")).getScaledInstance(163, 157, Image.SCALE_SMOOTH)));
        jLabel14.setText(null);
    }//GEN-LAST:event_SendEMailsMouseExited

    private void SendEMailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendEMailsMouseEntered
        SendEMails.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/GMail.png")).getScaledInstance(183, 177, Image.SCALE_SMOOTH)));
        jLabel14.setText("Send Mails");
    }//GEN-LAST:event_SendEMailsMouseEntered

    private void DataEnteringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataEnteringMouseClicked
        DataEnteringFrames frame = new DataEnteringFrames();
        frame.setVisible(true);
    }//GEN-LAST:event_DataEnteringMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backup;
    private javax.swing.JLabel BarcodeGenarator;
    private javax.swing.JLabel DataEntering;
    private javax.swing.JLabel Details;
    private javax.swing.JLabel GRN;
    private javax.swing.JLabel LogOut;
    private javax.swing.JLabel PosSystem;
    private javax.swing.JLabel Reports;
    private javax.swing.JLabel SendEMails;
    private javax.swing.JLabel Settings;
    private javax.swing.JLabel Summary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
