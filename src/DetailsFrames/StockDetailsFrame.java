/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DetailsFrames;

import DataEnteringFrames.StaffFrame;
import DataEnteringFrames.StockFrame;
import MyConn.MyConn;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nuwantha
 */
public class StockDetailsFrame extends javax.swing.JFrame {

    int xMouse, yMouse;

    /**
     * Creates new form LogInFrame
     */
    public StockDetailsFrame() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Icon.jpg")));
        jTable1.getTableHeader().setFont(new Font("Tahome", Font.PLAIN, 18));
        jTable1.setRowHeight(30);

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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Stock Details");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "Name", "Recommmend Price", "Min Price", "Max Price", "No In Stock", "Active Inactive"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ID", "Service Code", "Name", "Recommend Price", "Min Price", "Max Price", "Is Active" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Search By :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Order By :");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ID", "Service Code", "Name", "Recommend Price", "Min Price", "Max Price", "Is Active" }));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ascending", "Descending" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jComboBox2)
                    .addComponent(jComboBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-938)/2, (screenSize.height-616)/2, 938, 616);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "select * from stock ";
        String order = "asc";
        String orderType = "";
        if (jComboBox3.getSelectedIndex() == 0) {
            order = "asc";
        } else {
            order = "desc";
        }
        if (jComboBox2.getSelectedIndex() == 0) {
            sql = "select * from stock ";
        } else if (jComboBox2.getSelectedIndex() == 1) {
            orderType = "iid";
        } else if (jComboBox2.getSelectedIndex() == 2) {
            orderType = "icode";
        } else if (jComboBox2.getSelectedIndex() == 3) {
            orderType = "iname";
        } else if (jComboBox2.getSelectedIndex() == 4) {
            orderType = "irecommendprice";
        } else if (jComboBox2.getSelectedIndex() == 5) {
            orderType = "iminprice";
        } else if (jComboBox2.getSelectedIndex() == 6) {
            orderType = "imaxprice";
        } else if (jComboBox2.getSelectedIndex() == 7) {
            orderType = "iisactive";
        } else if (jComboBox2.getSelectedIndex() == 8) {
            orderType = "idescription";
        }
        if (jComboBox2.getSelectedIndex() == 0) {
            sql = "select * from stock ";
        } else {
            sql = sql + " order by " + orderType + "  " + order + " ";
        }
        try {
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            int x = df.getRowCount();
            for (int i = 0; i < x; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                if (rs.getBoolean(8)) {
                    v.add("Active");
                } else {
                    v.add("Inactive");
                }
                df.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        StockFrame frame = new StockFrame();
        frame.setVisible(true);
        frame.jTextField2.setText(jTable1.getValueAt(row, 0).toString());
        frame.jTextField7.setText(jTable1.getValueAt(row, 1).toString());
        frame.jTextField3.setText(jTable1.getValueAt(row, 2).toString());
        frame.jTextField4.setText(jTable1.getValueAt(row, 3).toString());
        frame.jTextField5.setText(jTable1.getValueAt(row, 4).toString());
        frame.jTextField6.setText(jTable1.getValueAt(row, 5).toString());
        frame.jLabel10.setText(jTable1.getValueAt(row, 6).toString()+"  Items In Stock");
        if (jTable1.getValueAt(row, 7).toString().equals("Active")) {
            frame.jCheckBox1.setSelected(true);
        } else {
            frame.jCheckBox1.setSelected(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String sql = "select * from stock ";
        String order = "asc";
        String order2 = "asc";
        String orderType = "";
        if (jComboBox3.getSelectedIndex() == 0) {
            order = "asc";
        } else {
            order = "desc";
        }
        if (jComboBox2.getSelectedIndex() == 0) {
            sql = "select * from stock ";
        } else if (jComboBox2.getSelectedIndex() == 1) {
            orderType = "iid";
        } else if (jComboBox2.getSelectedIndex() == 2) {
            orderType = "icode";
        } else if (jComboBox2.getSelectedIndex() == 3) {
            orderType = "iname";
        } else if (jComboBox2.getSelectedIndex() == 4) {
            orderType = "irecommendprice";
        } else if (jComboBox2.getSelectedIndex() == 5) {
            orderType = "iminprice";
        } else if (jComboBox2.getSelectedIndex() == 6) {
            orderType = "imaxprice";
        } else if (jComboBox2.getSelectedIndex() == 7) {
            orderType = "iisactive";
        } else if (jComboBox2.getSelectedIndex() == 8) {
            orderType = "idescription";
        }
        if (jComboBox1.getSelectedIndex() == 0) {
            sql = "select * from services ";
        } else if (jComboBox1.getSelectedIndex() == 1) {
            order2 = "iid";
        } else if (jComboBox1.getSelectedIndex() == 2) {
            order2 = "icode";
        } else if (jComboBox1.getSelectedIndex() == 3) {
            order2 = "iname";
        } else if (jComboBox1.getSelectedIndex() == 4) {
            order2 = "irecommendprice";
        } else if (jComboBox1.getSelectedIndex() == 5) {
            order2 = "iminprice";
        } else if (jComboBox1.getSelectedIndex() == 6) {
            order2 = "imaxprice";
        } else if (jComboBox1.getSelectedIndex() == 7) {
            order2 = "iisactive";
        } else if (jComboBox1.getSelectedIndex() == 8) {
            order2 = "idescription";
        }
        if (jComboBox2.getSelectedIndex() == 0) {
            sql = "select * from stock where "+order2+" like '"+jTextField2.getText()+"%' ";
        } else {
            sql = sql + " where "+order2+" like '"+jTextField2.getText()+"%' order by " + orderType + "  " + order + " ";
        }
        try {
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            int x = df.getRowCount();
            for (int i = 0; i < x; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                if (rs.getBoolean(8)) {
                    v.add("Active");
                } else {
                    v.add("Inactive");
                }
                df.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField2KeyReleased

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
            java.util.logging.Logger.getLogger(StockDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new StockDetailsFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
