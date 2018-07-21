/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session07_RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class D_Client {
    private void startClient(){
        try {
            // Bật localhost port 1234
            Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1234);

            // Tìm service từ server
            A_Interface object = (A_Interface)myRegistry.lookup("rmi://localhost:1234/B_Implements");

            // Gọi method server
            String result = object.doProcess("Client message");
            System.out.println("Message Sent...");
            System.out.println(result);
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        new D_Client().startClient();
    }
}
    

