/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session07_RMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
	 
public class B_Implements extends UnicastRemoteObject implements A_Interface{

    public B_Implements() throws RemoteException {}
    
    @Override
    public String doProcess(String s) throws RemoteException {
        return ("'" + s + "' proccessed");
    }
}
