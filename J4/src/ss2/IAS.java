/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ss1.DBConnection;

/**
 *
 * @author QQ
 */
public class IAS extends javax.swing.JFrame {

    Connection conn = null;
    String database = "Stronghold";
    String account = "sa";
    String password = "123456";
    DefaultTableModel model;
    Vector<Vector> fieldData;
    Vector fieldName;
    int row = 0;
    int UpdateClicked = 0;

    /**
     * Creates new form IAS
     */
    public IAS() {
        initComponents();
        load();
        setState();
    }

    public void load() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        fieldName = new Vector();
        fieldData = new Vector<>();
        try {

            String query = "Select * from Item";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            //Table database có 3 cột, meta đếm cột từ 1 đến 3 nên lặp i = 1, i <= 3 CHÚ Ý: <= 3 KO PHẢI <3
            //Lấy tên từng cột và gắn vào vector fieldName
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                fieldName.add(meta.getColumnName(i));
            }
            //Vector temp sẽ add lần lượt code, name, price 3 cái riêng biệt. Lúc này temp có 3 phần tử (3 cột)
            //Sau đó vector fieldData sẽ add tất cả phần tử trong temp (tức là 1 phần tử của fieldData sẽ gồm 3 cái code, name, price hay 3 cột)
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getInt(3));
                fieldData.add(temp);

            }
            //Gắn tên cột và dữ liệu vào model
            model = new DefaultTableModel(fieldData, fieldName);
            //Gắn model vào table
            tblData.setModel(model);
            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }
    }

    public void setState() {
        txtItemCode.setEnabled(false);
        txtItemName.setEnabled(false);
        txtPrice.setEnabled(false);

        load();
    }

    public void setTextTxt() {
        txtItemCode.setText("");
        txtItemName.setText("");
        txtPrice.setText("");
    }

    public void setState(boolean ICodeEnable, boolean NamePriceEnable) {
        txtItemCode.setEnabled(ICodeEnable);
//        txtItemCode.setEditable(ICodeEditable);
        txtItemName.setEnabled(NamePriceEnable);
        txtPrice.setEnabled(NamePriceEnable);
    }

    public void setStateBtn(boolean New, boolean Update, boolean Delete) {
        btnNew.setEnabled(New);
        btnUpdate.setEnabled(Update);
        btnDelete.setEnabled(Delete);
    }

    public void doInsert() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        String code = txtItemCode.getText().trim();
        String name = txtItemName.getText().trim();
        String price = txtPrice.getText().trim();

        String query = "Insert into Item(ICode, ItemName, Rate) values (?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, code);
            st.setString(2, name);
            st.setString(3, price);
            int rs = st.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Insert successfully", "Successful Message", JOptionPane.INFORMATION_MESSAGE);
                load();
            } else {
                JOptionPane.showMessageDialog(null, "Save unsuccessfully", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                txtItemCode.requestFocus();
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }

    }

    public void doUpdate() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        String code = txtItemCode.getText().trim();
        String name = txtItemName.getText().trim();
        String price = txtPrice.getText().trim();

        String query = "Update Item set ItemName=?, Rate=? where ICode=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(3, code);
            st.setString(1, name);
            st.setString(2, price);
            int rs = st.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Update successfully", "Successful Message", JOptionPane.INFORMATION_MESSAGE);
                load();
            } else {
                JOptionPane.showMessageDialog(null, "Save unsuccessfully", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                txtItemCode.requestFocus();
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

        }

    }

    public void doDelete() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        String code = txtItemCode.getText().trim();
        String name = txtItemName.getText().trim();
        String price = txtPrice.getText().trim();

        String query = "Delete from Item where ICode=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, code);
//            st.setString(2, name);
//            st.setString(3, price);
            int rs = st.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Delete successfully", "Successful Message", JOptionPane.INFORMATION_MESSAGE);
                load();
            } else {
                JOptionPane.showMessageDialog(null, "Save unsuccessfully", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                txtItemCode.requestFocus();
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Item Automatically System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setText("Item Code");

        jLabel3.setText("Item Name");

        jLabel4.setText("Price");

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

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ICode", "ItemName", "Rate"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

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
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        if (evt.getActionCommand().equals("New")) {
            btnNew.setText("Save");
            setStateBtn(true, false, false);
            setState(true, true);
            setTextTxt();
            UpdateClicked = 0;
        }
        if (evt.getActionCommand().equals("Save") && UpdateClicked == 0) {
            doInsert();
            btnNew.setText("New");
            setStateBtn(true, true, true);
            setState();
        }
        if (evt.getActionCommand().equals("Save") && UpdateClicked == 1) {
            doUpdate();
            btnNew.setText("New");
            setStateBtn(true, true, true);
            setState();
            UpdateClicked = 0;
        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        row = tblData.getSelectedRow();
        if (row != -1) {
            setState(false, true);
            txtItemCode.setText("" + tblData.getValueAt(row, 0));
            txtItemName.setText("" + tblData.getValueAt(row, 1));
            txtPrice.setText("" + tblData.getValueAt(row, 2));
        }
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        setStateBtn(true, false, false);
        btnNew.setText("Save");
        UpdateClicked = 1;
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        doDelete();
        setState();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
