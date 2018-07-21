/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session08_JavaMail;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.*;
public class Email_POP_UI extends javax.swing.JFrame {  
    public Email_POP_UI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReceive = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMessage = new javax.swing.JTextArea();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Email Client Application");

        btnReceive.setText("Receive");
        btnReceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiveActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(102, 102, 102));
        lblStatus.setText("No any email.");

        taMessage.setEditable(false);
        taMessage.setColumns(20);
        taMessage.setRows(5);
        jScrollPane2.setViewportView(taMessage);

        txtEmail.setText("javamail4test@gmail.com");

        txtPassword.setText("1234++++");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Username:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(txtPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReceive)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReceive)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void receive(String email, String password){
        Properties props =System.getProperties();
        String host = "pop.gmail.com";
        final String username = email;
        final String pwd = password;
        String provider = "pop3s";
        try {
            props.put("mail.smtp.host", "pop.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable","true");
            javax.mail.Authenticator pa = null; //default: no authentication
            if (username != null && password != null) { 
            props.put("mail.smtp.auth", "true");
            pa = new javax.mail.Authenticator (){
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, pwd);
                }
            };
            }
            // Connect to POP3 server
            Session session = Session.getDefaultInstance(props, pa);
            Store store = session.getStore(provider);
            store.connect(host, username, password);
            Folder inbox = store.getFolder("INBOX");    //// Open INBOX Folder
            if (inbox == null) {
                System.out.println("No INBOX");
                System.exit(1);
            } 
            inbox.open(Folder.READ_ONLY);
            // retrieve mail from server
             Message[] messages = inbox.getMessages();
            if(messages.length<1){ 
                lblStatus.setText("No new mail on server");
            }
            String s=null;
            for (int i = 0; i < messages.length; i++) {
                s=("\n---- Message " + (i+1)+ " ----\n");
                taMessage.append(s);
                s="Subject: " + messages[i].getSubject() + "\n";
                s+="---------------------------\n";
                s+= (String)messages[i].getContent();
                taMessage.append(s);              
            }            
            inbox.close(false); // Close connection message 
            store.close(); 
        } 
        catch (Exception ex) {} 
    }
    private void btnReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiveActionPerformed
        String email = txtEmail.getText().trim();         
        String password=txtPassword.getText().trim();
        //Validate
        if (email.equals("")) {
                JOptionPane.showMessageDialog(null,
                    "Email cannot left blank.", "Alert Message", 
                    JOptionPane.INFORMATION_MESSAGE);
                txtEmail.requestFocus();
                return;
            }
            if (password.equals("")) {
                JOptionPane.showMessageDialog(null,"Password cannot left blank.", "Alert Message",
                    JOptionPane.INFORMATION_MESSAGE);
                txtPassword.requestFocus();
                return;
            }
        
        receive(email, password);
    }//GEN-LAST:event_btnReceiveActionPerformed
    public static void main(String args[]) {
        new Email_POP_UI().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReceive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextArea taMessage;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
