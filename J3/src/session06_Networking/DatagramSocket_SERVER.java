/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session06_Networking;
import java.net.*;
import java.util.*;
public class DatagramSocket_SERVER {
    public static void main(String args[]){
        try{
            DatagramSocket socket = null;
            System.out.println("Khởi động Server...");
            socket = new DatagramSocket(1234);
            for (int i = 0; i < 10; i++) {
                byte[] buf = new byte[100];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);

                socket.receive(packet);

                buf = new Date().toString().getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
               
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            }
            socket.close();
        }catch(Exception e){}
    }
}