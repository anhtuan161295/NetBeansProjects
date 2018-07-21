/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session08_JavaMail;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class Email_SMTP_UI extends javax.swing.JFrame {
    public Email_SMTP_UI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrom = new java.awt.Label();
        lblTo = new java.awt.Label();
        lblSubject = new java.awt.Label();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taBody = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Email applications");

        lblFrom.setAlignment(java.awt.Label.RIGHT);
        lblFrom.setText("From:");

        lblTo.setAlignment(java.awt.Label.RIGHT);
        lblTo.setText("To:");

        lblSubject.setAlignment(java.awt.Label.RIGHT);
        lblSubject.setText("Subject:");

        taBody.setColumns(20);
        taBody.setRows(5);
        taBody.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearStatus(evt);
            }
        });
        jScrollPane1.setViewportView(taBody);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSend)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFrom)
                        .addComponent(btnSend))
                    .addComponent(lblFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTo, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void send(String host, String to, String from,
        String password, String subject, String body) throws Exception{
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        final String login = from;
        final String pwd = password;
        Authenticator pa = null;
        if (login != null && pwd != null) {
            props.put("mail.smtp.auth", "true");
            pa = new Authenticator (){
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(login, pwd);
                }
            };
        }
        Session session = Session.getInstance(props, pa);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
        msg.setSubject(subject);
        msg.setText(body);
        // — Set some other header information –
        msg.setHeader("Mail-tool", "JavaMail4Test");
        msg.setSentDate(new Date());
        msg.saveChanges();   
        Transport.send(msg);    //Send the message
    }
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
            
            String host="smtp.gmail.com";
            String from=txtFrom.getText().trim();
            String to = txtTo.getText().trim();         
            String subject=txtSubject.getText().trim();
            String body=taBody.getText().trim();
            //Validate fields
            if (from.equals("")) {
                JOptionPane.showMessageDialog(null,
                    "From field cannot left blank.", "Alert Message", 
                    JOptionPane.INFORMATION_MESSAGE);
                txtFrom.requestFocus();
                return;
            }
            if (to.equals("")) {
                JOptionPane.showMessageDialog(null,"To field cannot left blank.", "Alert Message",
                    JOptionPane.INFORMATION_MESSAGE);
                txtTo.requestFocus();
                return;
            }
            if (body.equals("")) {
                JOptionPane.showMessageDialog(null,"Empty in the mail", "Alert Message",
                    JOptionPane.INFORMATION_MESSAGE);
                taBody.requestFocus();
                return;
            }
            //Enter password to send
            JPasswordField pwd = new JPasswordField(20);
            int action = JOptionPane.showConfirmDialog(null, pwd, "Enter your password",
                    JOptionPane.OK_CANCEL_OPTION); 
            String password = new String(pwd.getPassword());
            if(action==JOptionPane.OK_OPTION){
                try{             
                    if (subject.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email will be sent without a subject.", "Alert Message",
                        JOptionPane.INFORMATION_MESSAGE);
                    subject = "";
                    }
                    send(host, to, from, password, subject, body);
                    lblStatus.setText("Message was sent successfully.");
                    JOptionPane.showMessageDialog(null, "Message was sent successfully.", "Message", 
                            JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ex){}
            }
    }//GEN-LAST:event_btnSendActionPerformed
    private void clearStatus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clearStatus
        lblStatus.setText("");
    }//GEN-LAST:event_clearStatus
    public static void main(String args[]) {
         new Email_SMTP_UI().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblFrom;
    private javax.swing.JLabel lblStatus;
    private java.awt.Label lblSubject;
    private java.awt.Label lblTo;
    private javax.swing.JTextArea taBody;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
