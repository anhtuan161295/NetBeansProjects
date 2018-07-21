/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author QQ
 */
public class EASManagement extends javax.swing.JFrame {

    Connection conn = null;
    String database = "Stronghold";
    String account = "sa";
    String password = "123456";
    DefaultComboBoxModel model;
    Vector<Vector> fieldData;
    Vector fieldName;
    int row = 0;

    /**
     * Creates new form EAS
     */
    public EASManagement() {
        initComponents();
        setState();
        load();
    }

    public void load() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        fieldName = new Vector();
        fieldData = new Vector<>();
        try {

            String query = "Select * from Employees";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
//            ResultSetMetaData meta = rs.getMetaData();
            //Table database có 3 cột, meta đếm cột từ 1 đến 3 nên lặp i = 1, i <= 3 CHÚ Ý: <= 3 KO PHẢI <3
            //Lấy tên từng cột và gắn vào vector fieldName
//            for (int i = 1; i <= meta.getColumnCount(); i++) {
//                fieldName.add(meta.getColumnName(i));
//            }
            //Vector temp sẽ add lần lượt code, name, price 3 cái riêng biệt. Lúc này temp có 3 phần tử
            //Sau đó vector fieldData sẽ add tất cả phần tử trong temp (tức là 1 phần tử của fieldData sẽ gồm 3 cái code, name, price)
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                fieldData.add(temp);

            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }
    }

    public void searchDB() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);

        String empNo = txtEmpNo.getText();
        try {

            String query = "Select * from Employees where EmpNo=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, empNo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getRow() == 1) {
                    txtEmpName.setText(rs.getString(2));
                }
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }
    }

    public void search() {
        String no = txtEmpNo.getText().trim();
        int rs = 0;
        for (int i = 0; i < fieldData.size(); i++) {
            if (((String) fieldData.get(i).get(0)).equalsIgnoreCase(no)) {
                rs++;
                txtEmpName.setText("" + fieldData.get(i).get(1));
                cboSex.setSelectedItem(fieldData.get(i).get(3));
                //Không cho chỉnh sửa EmpNo sau khi search, như vậy thì ko sửa EmpNo dc = update
                setState(true, false, true, true);
            }
        }
        if (rs == 0) {
            JOptionPane.showMessageDialog(null, "Employee is not found", "Error Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void doInsert() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        String no = txtEmpNo.getText().trim();
        String name = txtEmpName.getText().trim();
        String sex = cboSex.getSelectedItem().toString();

        String query = "Insert into Employees(EmpNo, EmpName, Sex) values (?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, no);
            st.setString(2, name);
            st.setString(3, sex);
            int rs = st.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Insert successfully", "Successful Message", JOptionPane.INFORMATION_MESSAGE);
                load();
            } else {
                JOptionPane.showMessageDialog(null, "Save unsuccessfully", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                txtEmpNo.requestFocus();
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }

    }

    public void doUpdate() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        String no = txtEmpNo.getText().trim();
        String name = txtEmpName.getText().trim();
        String sex = cboSex.getSelectedItem().toString();

        String query = "Update Employees set EmpName=?, Sex=? where EmpNo=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(3, no);
            st.setString(1, name);
            st.setString(2, sex);

            int rs = st.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Update successfully", "Successful Message", JOptionPane.INFORMATION_MESSAGE);
                load();
            } else {
                JOptionPane.showMessageDialog(null, "Save unsuccessfully", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                txtEmpNo.requestFocus();
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }

    }

    public void doDelete() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        String no = txtEmpNo.getText().trim();
//        String name = txtEmpName.getText().trim();
//        String sex = cboSex.getSelectedItem().toString();

        String query = "Delete from Employees where EmpNo=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, no);

            int rs = st.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Delete successfully", "Successful Message", JOptionPane.INFORMATION_MESSAGE);
                load();
            } else {
                JOptionPane.showMessageDialog(null, "Save unsuccessfully", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                txtEmpNo.requestFocus();
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }

    }

    public void setState() {
        txtEmpNo.setEnabled(true);
        txtEmpNo.setEditable(true);
        txtEmpName.setEnabled(false);
        cboSex.setEnabled(false);

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void setState(boolean EmpNoEnable, boolean EmpNoEditable, boolean c, boolean d) {
        txtEmpNo.setEnabled(EmpNoEnable);

        txtEmpNo.setEditable(EmpNoEditable);
        txtEmpName.setEnabled(c);
        cboSex.setEnabled(c);

        btnUpdate.setEnabled(d);
        btnDelete.setEnabled(d);
    }

    public void setReset() {
        txtEmpNo.setText("");
        txtEmpName.setText("");
        cboSex.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmpNo = new javax.swing.JTextField();
        txtEmpName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cboSex = new javax.swing.JComboBox<>();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Employees Automatically System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Employee No");

        jLabel3.setText("Employee Name");

        jLabel4.setText("Sex");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSearch))
                                    .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnNew)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)))
                        .addGap(0, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        search();


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        if (evt.getActionCommand().equals("New")) {
            btnNew.setText("Add");
            setReset();
            setState(true, true, true, false);
            txtEmpNo.requestFocus();
        } else {
            btnNew.setText("New");
            doInsert();
            setReset();
            setState();
        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(null, "Do you want to update this employee ?", "Alert Message", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            doUpdate();
            setReset();
            setState();

        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(null, "Do you want to delete this employee ?", "Alert Message", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            doDelete();
            setReset();
            setState();

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EASManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EASManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EASManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EASManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EASManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JTextField txtEmpNo;
    // End of variables declaration//GEN-END:variables
}
