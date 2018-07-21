/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session07_RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
	 
public interface A_Interface extends Remote {
    String doProcess(String s) throws RemoteException;
}
