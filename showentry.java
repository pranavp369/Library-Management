
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class showentry extends javax.swing.JFrame {

    /**
     * Creates new form showentry
     */
    public showentry() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        l2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();
        tf0 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cb1 = new javax.swing.JComboBox<>();
        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 420, 30));

        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STUDENT NAME", "REGISTER NO.", "BOOK ID", "BOOK NAME", "PUBLICATION", "DATE OF ISSUE", "DATE OF RETURN"
            }
        ));
        jScrollPane1.setViewportView(t1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 1230, -1));

        tf0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf0ActionPerformed(evt);
            }
        });
        jPanel1.add(tf0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 320, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("O.K");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 80, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 80, 30));

        cb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Register Number", "Book Id", " " }));
        jPanel1.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 140, 30));
        jPanel1.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1327, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf0ActionPerformed
String gid,name,bkname,id,bid,date,author,bname,pub,pubyr,isbn,doi,dor;
int flag=0;
int cb;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        gid = tf0.getText();
        cb = cb1.getSelectedIndex();
        Object[] empty = {"","","","","","",""};
        DefaultTableModel d = (DefaultTableModel)t1.getModel();
        d.setRowCount(0);
        String connectionURL = "jdbc:mysql://localhost:3306/libProj";
        //ConnectionURL, username and password should be specified in getConnection()
        try {
            System.out.println("Works");
            Connection conn = DriverManager.getConnection(connectionURL, "root", "sairam");
            String sql = "SELECT * FROM entry";
            Statement st = conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()){
                name = rs.getString("sname");
                bid = rs.getString("bid");
                id= rs.getString("sid");
              switch(cb){
                  case 0 :   if(gid.equalsIgnoreCase(id)){
                            flag = 1;}
                            break;
                  case 1 : if(gid.equalsIgnoreCase(bid)){
                            flag = 2;
                            String sql0 = "SELECT * FROM books where bid = "+bid+";";
                            Statement st1 = conn.createStatement();
                            ResultSet rs1 =null;
                            rs1 =st.executeQuery(sql0);
                            while(rs1.next()){ bkname = rs.getString("bname");}
                            }
                            break;
                  default: break; 
            }
         }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            jp1.showMessageDialog(null,ex);}
        if(flag ==1)
        {
            t1.setVisible(true);
            l2.setText("BOOKS TAKEN BY "+name);
            try {
                System.out.println("Works");
                Connection conn = DriverManager.getConnection(connectionURL, "root", "sairam");
                String sql = "SELECT * FROM entry,books where entry.bid = books.bid and sid = '"+gid+"'";
                Statement st = conn.createStatement();
                ResultSet rs=null;
                rs=st.executeQuery(sql);
                while(rs.next()){
                    //System.out.println(rs.getString("sname")+"\t"+rs.getString("dept"));
                    bname = rs.getString("bname");
                    bid= rs.getString("bid");
                    pub = rs.getString("pub");
                    doi = rs.getString("doi");
                    dor = rs.getString("dor");
                    Object row[] = {name,id,bid,bname,pub,doi,dor};
                    d.addRow(row);
                }
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                jp1.showMessageDialog(null,ex);}
           flag =0;
        }
        else if(flag == 2){
            t1.setVisible(true);
            try {
                System.out.println("Works");
                Connection conn = DriverManager.getConnection(connectionURL, "root", "sairam");
                String sql = "SELECT * FROM entry,books where entry.bid = books.bid and sid = '"+gid+"'";
                Statement st = conn.createStatement();
                ResultSet rs=null;
                rs=st.executeQuery(sql);
                while(rs.next()){
                    pub = rs.getString("pub");
                    doi = rs.getString("doi");
                    dor = rs.getString("dor");
                    Object row[] = {name,id,bid,bkname,pub,doi,dor};
                    d.addRow(row);
                }
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                jp1.showMessageDialog(null,ex);}
           flag =0;
        }
        else
        {
         t1.setVisible(true);
         l2.setText("");
         jp1.showMessageDialog(null,"NO books taken");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        entryhome s =new entryhome();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
jPanel1.setBackground(Color.yellow);         // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(showentry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showentry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showentry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showentry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showentry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JOptionPane jp1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JTable t1;
    private javax.swing.JTextField tf0;
    // End of variables declaration//GEN-END:variables
}
