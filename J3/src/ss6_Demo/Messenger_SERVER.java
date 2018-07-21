/*
 * This program demonstrate the use of Socket and server Socket classes in
 * networking Application.
 *
 * Copyright (c) 2007 Aptech Software Limited. All Rights Reserved.
 */
package ss6_Demo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Vincent
 */
public class Messenger_SERVER extends javax.swing.JFrame {

    static ServerSocket server;
    Socket client;
    DataInputStream dis;
    BufferedReader br;
    PrintStream ps;
    String strMessage = "";
    static boolean blnServerStarted = false;
    String s = "";
    Vector vecUsers = new Vector();

    /**
     * Creates new form ChatServer
     */
    public Messenger_SERVER() {

        initComponents();
    }

    public class ServerThread extends Thread {

        String strMsg = "";
        boolean blnSignIn;
        boolean blnConnect;
        int index = 0;

        public ServerThread() {
            try {
                server = new ServerSocket(10000); //Server dc gắn với port 10000
            } catch (IOException ex) {
                //Báo lỗi

            }
        }

        @Override
        public void run() {
            while (true) {
                if (!blnConnect) {
                    try {
                        client = server.accept(); //Server sẽ nhận tín hiệu từ client qua port 10000
                        //Gửi dữ liệu đến client
                        ps = new PrintStream(client.getOutputStream());
                        //Nhận dữ liệu từ client
                        br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        blnConnect = true;
                        blnSignIn = false;

                    } catch (IOException ex) {
                        //Báo lỗi
                        JOptionPane.showMessageDialog(null, "Error occured. Contact Vendor", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                }

                try {
//Khi Client Sign In thì dữ liệu được gửi đến server và gắn cho biến strMsg (có dữ liệu nên strMsg khác null)
//Lúc này server sẽ kiểm tra Client Sign In hay chưa = biến boolean blnSignIn
//Nếu blnSignIn = false thì tự động đổi thành true và hiện Client trong Khung đăng nhập Logged In
//Khi Client send 1 đoạn chat thì biến strMsg được gắn dữ liệu nhận được từ Client (có dữ liệu nên strMsg khác null)
//Lúc này blnSign = true nên nó nhảy qua phần else, tức là chỉ xuất đoạn chat của client ra khung chat
//Tương tự khi Client Sign Out
                    if ((strMsg = br.readLine()) != null) {
                        if (!blnSignIn) {
                            //Nếu chưa Sign In thì tự động gắn Sign In = true
                            //Client gửi đến dữ liệu là strName + " has logged in" khi tạo đối tượng ClientThread
                            //Dữ liệu được gán vào vector sau đó gắn vector và JList (khung Logged In)
                            vecUsers.addElement(strMsg);
                            lstClient.setListData(vecUsers);
                            blnSignIn = true;
                        } else {//Nếu Sign In = true rồi thì xuất dữ liệu ra khung chat
                            txaClientStatus.append(strMsg + "\n");
                        }
                    }
                } catch (IOException ex) {
                    //Nếu lỗi thì ngắt kết nối
                    blnConnect = false;
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStartServer = new javax.swing.JButton();
        lblServerStatus = new javax.swing.JLabel();
        scpClientStatus = new javax.swing.JScrollPane();
        txaClientStatus = new javax.swing.JTextArea();
        scpClient = new javax.swing.JScrollPane();
        lstClient = new javax.swing.JList();
        pnlBroadCastMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnBroadCastMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Server");
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        btnStartServer.setText("Start Server");
        btnStartServer.setPreferredSize(new java.awt.Dimension(150, 23));
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });
        getContentPane().add(btnStartServer);

        lblServerStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblServerStatus.setText("Logged In");
        lblServerStatus.setPreferredSize(new java.awt.Dimension(180, 20));
        getContentPane().add(lblServerStatus);

        scpClientStatus.setPreferredSize(new java.awt.Dimension(300, 150));

        txaClientStatus.setColumns(20);
        txaClientStatus.setEditable(false);
        txaClientStatus.setRows(5);
        scpClientStatus.setViewportView(txaClientStatus);

        getContentPane().add(scpClientStatus);

        scpClient.setPreferredSize(new java.awt.Dimension(130, 150));

        lstClient.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstClient.setEnabled(false);
        scpClient.setViewportView(lstClient);

        getContentPane().add(scpClient);

        pnlBroadCastMessage.setPreferredSize(new java.awt.Dimension(430, 50));
        pnlBroadCastMessage.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        lblMessage.setText("Message:");
        lblMessage.setPreferredSize(new java.awt.Dimension(70, 20));
        pnlBroadCastMessage.add(lblMessage);

        txtMessage.setPreferredSize(new java.awt.Dimension(200, 20));
        pnlBroadCastMessage.add(txtMessage);

        btnBroadCastMessage.setText("BroadCast Message");
        btnBroadCastMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadCastMessageActionPerformed(evt);
            }
        });
        pnlBroadCastMessage.add(btnBroadCastMessage);

        getContentPane().add(pnlBroadCastMessage);

        setSize(new java.awt.Dimension(457, 275));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBroadCastMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadCastMessageActionPerformed
// TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String strMessage;
                strMessage = txtMessage.getText(); //Lấy dữ liệu field broadcast
                ps.println(strMessage); //Gửi dữ liệu đến Client
                txtMessage.setText(""); //Làm trống field
            }
        });
    }//GEN-LAST:event_btnBroadCastMessageActionPerformed

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
// TODO add your handling code here:
        blnServerStarted = true; //Boolean này là static, một khi start thì ko đổi
        btnStartServer.setEnabled(false); //Nút start không bấm được nữa
        new ServerThread().start(); //Chạy method run

    }//GEN-LAST:event_btnStartServerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Chỉnh lại giao diện ứng dụng cho giống với giao diện của windows
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Messenger_SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Messenger_SERVER().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBroadCastMessage;
    private javax.swing.JButton btnStartServer;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblServerStatus;
    private javax.swing.JList lstClient;
    private javax.swing.JPanel pnlBroadCastMessage;
    private javax.swing.JScrollPane scpClient;
    private javax.swing.JScrollPane scpClientStatus;
    private javax.swing.JTextArea txaClientStatus;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

}
