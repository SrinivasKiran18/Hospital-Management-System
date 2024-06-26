/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class admitPatient extends javax.swing.JFrame  implements Runnable{
    
    int hour,seconds,minutes;
    
    
    /**
     * Creates new form admitPatient
     */
    public admitPatient() {
        initComponents();
        showDate();
        Thread t=new Thread(this);
        t.start();
        
    }
    
    void showDate(){
    Date d= new Date();
    SimpleDateFormat sd= new SimpleDateFormat("dd-MM-yyyy");
    pad.setText(sd.format(d));
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pi = new javax.swing.JTextField();
        pn = new javax.swing.JTextField();
        pd = new javax.swing.JTextField();
        pad = new javax.swing.JTextField();
        pat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ADMIT PATIENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 24, -1, -1));

        jLabel2.setText("Enter Patient's ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 74, -1, -1));

        jLabel3.setText("Enter Patients Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 114, -1, -1));

        jLabel4.setText("Enter Patient's Disease:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 154, -1, -1));

        jLabel5.setText("Enter Admit Date:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 194, -1, -1));

        jLabel6.setText("Enter Admit Time:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 234, -1, -1));

        pi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piActionPerformed(evt);
            }
        });
        getContentPane().add(pi, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 71, 215, -1));
        getContentPane().add(pn, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 111, 215, -1));
        getContentPane().add(pd, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 151, 215, -1));

        pad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padActionPerformed(evt);
            }
        });
        getContentPane().add(pad, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 191, 215, -1));
        getContentPane().add(pat, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 231, 215, -1));

        jButton1.setText("ADMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 271, -1, -1));

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 338, -1, -1));

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 338, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bg11.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        String pid=pi.getText();
//        String pname=pn.getText();
//        String pdis=pd.getText();
//        String paddate=pad.getText();
//        String padtime=pat.getText();
        
        try{ Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","srinivas");
        
        String sql = "insert into paitient_record values (?,?,?,?,?)";
        PreparedStatement ptstmt = conn.prepareStatement(sql);
        ptstmt.setString(1, pi.getText());
        ptstmt.setString(2, pn.getText());
        ptstmt.setString(3, pd.getText());
        ptstmt.setString(4, pad.getText());
        ptstmt.setString(5, pat.getText());
        ptstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "data inserted successfully");
       conn.close();
       pi.setText("");pn.setText("");pd.setText("");pat.setText("");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }       

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PATIENT obj =new PATIENT();
        obj.setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LoginPage obj =new LoginPage();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void padActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_padActionPerformed

    private void piActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piActionPerformed

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
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admitPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField pad;
    private javax.swing.JTextField pat;
    private javax.swing.JTextField pd;
    private javax.swing.JTextField pi;
    private javax.swing.JTextField pn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    while(true){
    Calendar cal= Calendar.getInstance();
    hour=cal.get(Calendar.HOUR_OF_DAY);
    minutes=cal.get(Calendar.MINUTE);
    seconds=cal.get(Calendar.SECOND);
    
        SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss:aa");
        Date dat = cal.getTime();
        String time24 =sdf24.format(dat);
        pat.setText(time24);
        
        
    
    }
    
    
    }
}
