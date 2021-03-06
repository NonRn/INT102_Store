/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author internet
 */
public class Login extends javax.swing.JFrame {
    private long id ;        // เก็บ ID ของผู้ที่ login เข้ามา
    private int empId;
    /*Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;*/
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userName = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        jLabel1.setText("USERNAME   : ");

        jLabel2.setText("PASSWORD  : ");

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("STORE");

        jLabel4.setText("Register");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed

        try {
            // เชื่อมต่อ Database ก่อน ให้เป็น PrepareStatement เพราะว่าให้มี ? เพื่อจะใส่ username password ทีหลัง
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Store","app","app");
            PreparedStatement ps = con.prepareStatement("select * from Login where username=? and password=? ");
            ps.setString(1, userName.getText());  // ใส่ username password ใน ?
            ps.setString(2, password.getText());

            ResultSet result = ps.executeQuery(); // run sql บรรทัดที่ 142
            
            if (result.next()) {  
                if (result.getInt(3) == 1) { // check ว่าที่ login เป็น Customer หรือ Employee
                    PreparedStatement ps3 = con.prepareStatement("select empid from Employee where username=?");
                    ps3.setString(1, userName.getText());   // ต่อ Database ว่า usernameนี้ เป็น User คนไหน
                    ResultSet rs = ps3.executeQuery();
                    rs.next();
                    empId = rs.getInt("empId");
                    Employee emp = new Employee();   // เปิดหน้า Employee ขึ้นมา
                    emp.setId(empId);   // ส่งไอดีไปเพื่อแสดงตัวตน
                    System.out.println("Employee login");
                    emp.setVisible(true);
                    con.close();
                    this.dispose();
                } else if (result.getInt(3) == 0) {  
                    PreparedStatement ps2 = con.prepareStatement("select cusId from CUSTOMER where username=?");
                    ps2.setString(1, userName.getText());
                    ResultSet resultId = ps2.executeQuery();
                    resultId.next();
                    id = resultId.getLong("CUSID");
                    Customer c = new Customer();
                    c.setId(id);
                    System.out.println("id : " + id + " Login");
                    c.setVisible(true);
                    con.close();
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is Extremely Wrong!\nClick OK and try again.2", "wrong Pass", JOptionPane.ERROR_MESSAGE);
                password.setText("");   //ถ้า username หรือ password ไม่มีใน database แจ้งเตือนว่า พาสเวิร์ดอาจผิด และลบข้อมูลในช่อง username password
                userName.setText("");
                userName.requestFocus();   //ให้ cursor ไปอยู่ที่ช่อง username อัตโนมัติ
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }//GEN-LAST:event_LoginActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed

    }//GEN-LAST:event_userNameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // เมื่อคลิ๊กที่ text คำว่า register ให้เปิดหน้า register
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // Log in โค้ดเหมือนด้านบน แต่ทำงานเมื่อกด Enter ในช่องใส่ Password 
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Store","app","app");
            PreparedStatement ps = con.prepareStatement("select * from Login where username=? and password=? ");
            ps.setString(1, userName.getText());
            ps.setString(2, password.getText());

            ResultSet result = ps.executeQuery();
            if (result.next()) {                  
                if (result.getInt(3) == 1) {
                    PreparedStatement ps3 = con.prepareStatement("select empid from Employee where username=?");
                    ps3.setString(1, userName.getText());
                    ResultSet rs = ps3.executeQuery();
                    rs.next();
                    empId = rs.getInt("empId");
                    Employee emp = new Employee();
                    emp.setId(empId);
                    System.out.println("Employee login");
                    con.close();
                    emp.setVisible(true);
                    this.dispose();
                } else if (result.getInt(3) == 0) {
                    PreparedStatement ps2 = con.prepareStatement("select cusId from CUSTOMER where username=?");
                    ps2.setString(1, userName.getText());
                    ResultSet resultId = ps2.executeQuery();
                    resultId.next();
                    id = resultId.getLong("CUSID");
                    Customer c = new Customer();
                    c.setId(id);
                    System.out.println("id : " + id + " Login");
                    c.setVisible(true);
                    con.close();
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is Extremely Wrong!\nClick OK and try again.2", "wrong Pass", JOptionPane.ERROR_MESSAGE);
                password.setText("");
                userName.setText("");
                userName.requestFocus();
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (Exception e){
            e.getMessage();
        }
        }
    }//GEN-LAST:event_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password;
    private javax.swing.JFormattedTextField userName;
    // End of variables declaration//GEN-END:variables
    private void close() {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
}
