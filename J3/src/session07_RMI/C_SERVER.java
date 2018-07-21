/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session07_RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class C_SERVER {
    private void startService(){
        try {
            // Khởi tạo port 1234
            B_Implements sp = new B_Implements();
            Registry registry = LocateRegistry.createRegistry(1234);

            // Tạo một service mới tên service
            registry.rebind("rmi://localhost:1234/B_Implements", sp);
            System.out.println("System is ready...");
        } catch (RemoteException e) {}
      
    }
    public static void main(String[] args){
        new C_SERVER().startService();
    }
}
