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
import ss1.DBConnection;

/**
 *
 * @author QQ
 */
public class IAS2 extends javax.swing.JFrame {

    Connection conn = null;
    String database = "Stronghold";
    String account = "sa";
    String password = "123456";
    PreparedStatement st = null;
    ResultSet rs = null;

    Vector<Vector> fieldData;
    Vector fieldName;
    int contro = 0;

    /**
     * Creates new form IAS2
     */
    public IAS2() {
        initComponents();
        load();
        selectData();
    }

    public void load() {
        //Mở kết nối database
        conn = DBConnection.getDBConnection(database, account, password);
        fieldName = new Vector();
        fieldData = new Vector<>();
        try {

            String query = "Select * from Item";
            st = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();
//            rs.first();
//            txtItemCode.setText(rs.getString(1));
//            txtItemName.setText(rs.getString(2));
//            txtPrice.setText(rs.getString(3));
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

            //Đóng kết nối
//            conn.close();
        } catch (SQLException ex) {

        }
    }

    public void moveFirstRecord() {
        try {
            if (!rs.isFirst()) {
//Nếu con trỏ không ở record đầu tiên thì di chuyển con trỏ ra vị trí đầu tiên, hiển thị lên field
//Nút First và Previous bị disable, chỉ có next và last
                rs.first();
                txtItemCode.setText(rs.getString(1));
                txtItemName.setText(rs.getString(2));
                txtPrice.setText(rs.getString(3));
                btnFirst.setEnabled(false);
                btnPrevious.setEnabled(false);
                btnNext.setEnabled(true);
                btnLast.setEnabled(true);
            } else {
//Nếu con trỏ đã ở record đầu tiên thì chỉnh nút lại như trên
                btnFirst.setEnabled(false);
                btnPrevious.setEnabled(false);
                btnNext.setEnabled(true);
                btnLast.setEnabled(true);
            }
        } catch (SQLException ex) {

        }

    }

    public void movePreviusRecord() {
        //Khi bấm Previous thì enable nút Next và Last
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        try {
            //Nếu con trỏ ở record đầu tiên thì disable nút First và Previous
            if (rs.isFirst()) {
                btnFirst.setEnabled(false);
                btnPrevious.setEnabled(false);
            } else {
                //Nếu con trỏ không ở record đầu tiên thì di chuyển về trước 1 cái
                rs.previous();
                txtItemCode.setText(rs.getString(1));
                txtItemName.setText(rs.getString(2));
                txtPrice.setText(rs.getString(3));
            }

        } catch (SQLException ex) {

        }
    }

    public void moveNextRecord() {
        //Khi bấm Next thì enable nút Previous và First
        btnPrevious.setEnabled(true);
        btnFirst.setEnabled(true);
        try {
            if (rs.isLast()) {
                //Nếu con trỏ ở record cuối cùng thì disable Last và Next
                btnLast.setEnabled(false);
                btnNext.setEnabled(false);
            } else {
                //Nếu ko ở cuối thì con trỏ tăng lên 1 và xuất dữ liệu ra field
                rs.next();
                txtItemCode.setText(rs.getString(1));
                txtItemName.setText(rs.getString(2));
                txtPrice.setText(rs.getString(3));

            }
        } catch (SQLException ex) {

        }
    }

    public void moveLastRecord() {
        try { //Giống với First, chỉ đổi vị trí
            if (!rs.isLast()) {
                rs.last();
                txtItemCode.setText(rs.getString(1));
                txtItemName.setText(rs.getString(2));
                txtPrice.setText(rs.getString(3));
                btnLast.setEnabled(false);
                btnNext.setEnabled(false);
                btnFirst.setEnabled(true);
                btnPrevious.setEnabled(true);
            } else {
                btnLast.setEnabled(false);
                btnNext.setEnabled(false);
                btnFirst.setEnabled(true);
                btnPrevious.setEnabled(true);
            }
        } catch (SQLException ex) {

        }
    }

    public void selectData() {
        txtItemCode.setText("" + fieldData.get(0).get(0));
        txtItemName.setText("" + fieldData.get(0).get(1));
        txtPrice.setText("" + fieldData.get(0).get(2));

    }

    public void moveFirst() {
        //Khi bấm First thì enable Next và Last
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
//Vector đếm index bắt đầu = 0 nên 0 là index cho phần tử đầu tiên
//Nếu là phần tử đầu tiên thì disable 2 nút sau
        contro = 0;
        txtItemCode.setText("" + fieldData.get(contro).get(0));
        txtItemName.setText("" + fieldData.get(contro).get(1));
        txtPrice.setText("" + fieldData.get(contro).get(2));
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
    }

    public void movePrevious() {
        //Khi bấm Previous thì enable Next và Last
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
//Nếu index = 0 (phần tử đầu tiên) thì disable 2 nút, ngược lại thì index giảm, hiển thị phần tử trước
        if (contro == 0) {
            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
        } else {
            contro--;
            txtItemCode.setText("" + fieldData.get(contro).get(0));
            txtItemName.setText("" + fieldData.get(contro).get(1));
            txtPrice.setText("" + fieldData.get(contro).get(2));
        }
    }

    public void moveNext() {
        //Khi bấm Next thì enable First và Previous
        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
//Index đếm từ 0, hàm size() đếm từ 1 vì size() là đếm số phần tử trong Vector, nên phải trừ 1 để lấy được số Index
//Ở đây size()-1 chính là index của phần tử cuối cùng trong Vector
//Nếu là index cuối cùng thì disable 2 nút, ngược lại index tăng 1 và hiển thị phần tử kế tiếp
        if (contro == fieldData.size() - 1) {
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
        } else {
            contro++;
            txtItemCode.setText("" + fieldData.get(contro).get(0));
            txtItemName.setText("" + fieldData.get(contro).get(1));
            txtPrice.setText("" + fieldData.get(contro).get(2));
        }
    }

    public void moveLast() {
        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
//size()-1 là index của phần tử cuối cùng của Vector
//Khi bấm nút Last sẽ disable Last và next, enable First và Previous
        contro = fieldData.size() - 1;
        txtItemCode.setText("" + fieldData.get(contro).get(0));
        txtItemName.setText("" + fieldData.get(contro).get(1));
        txtPrice.setText("" + fieldData.get(contro).get(2));
        btnLast.setEnabled(false);
        btnNext.setEnabled(false);
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
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Item Automatically System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Item Code");

        jLabel3.setText("Item Name");

        jLabel4.setText("Price");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
//        moveFirstRecord();
        moveFirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
//        movePreviusRecord();
        movePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
//        moveNextRecord();
        moveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
//        moveLastRecord();
        moveLast();
    }//GEN-LAST:event_btnLastActionPerformed

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
            java.util.logging.Logger.getLogger(IAS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IAS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IAS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IAS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IAS2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
