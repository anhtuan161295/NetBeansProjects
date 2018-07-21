/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session08_JavaMail;
import javax.mail.*;
import java.util.Properties;
public class SimplePOP_Receiving {
    public void popReceive() {
        Properties props = new Properties(); 
        try {
            //01. Connect to the POP3 server
          Session session = Session.getDefaultInstance(props, null);
          Store store = session.getStore("pop3s");                      //parameter: provider
          store.connect("pop.gmail.com", "javamail4test", "1234++++");  //parameter: host, username, password
            //02. Open the folder
          Folder inbox = store.getFolder("INBOX");
          inbox.open(Folder.READ_ONLY);  
            //04. Get the messages from the server
          Message[] messages = inbox.getMessages();
          for (int i = 0; i < messages.length; i++) {
            System.out.println("---- Message " + (i+1) + "----");
            messages[i].writeTo(System.out);
          } 
            //05. Close the connection but don't remove the messages from the server
          inbox.close(false);
          store.close();   
        } 
        catch (Exception ex) {}    
    }
    public static void main(String[] args) {
        new SimplePOP_Receiving().popReceive();
    }
}

/*
 if (inbox == null) {
        System.out.println("No any email");
        System.exit(1);
      }  
 */