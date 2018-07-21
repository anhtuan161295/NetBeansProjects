/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session08_JavaMail;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class SimpleSMTP_Sending {
     public void smtpSend(){
        //Setup properties of mail system
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //Interact with messaging systems
        Session session = Session.getInstance(props,
            new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("javamail4test@gmail.com",
                                "1234++++");   //Parameter: Login, Password
                }//End getPasswordAuthentication
            }); //End Authenticator
            try {
                Message message = new MimeMessage(session); //MimeMessage is Subclass of the Message class
                message.setFrom(new InternetAddress("javamail4test@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("javamail4test@gmail.com"));
                message.setSubject("Test Sending");
                message.setText("Dear G0963," + "\nI'd like to test mail sending!");
                Transport.send(message);
                System.out.println("Message was sent");
            } catch (MessagingException e) {}
    }
     public static void main(String[] args) {
        new SimpleSMTP_Sending().smtpSend();
    }
}