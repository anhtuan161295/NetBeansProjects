/*
 * @author: Lê Thanh Nhân| FPT University
 * : NhanLT@fpt.com.vn| L3nhan@gmail.com|
 * : +84.8.3925 2891| +84.942 64 3646
 * : NhanID
*/
package session06_Networking;
import java.net.*;
public class DatagramSocket_CLIENT {
    public static void main(String[] args){
        try{
            DatagramSocket socket = new DatagramSocket();
            for (int i=0; i<10; i++) {
                byte[] buf = new byte[100];                                                     
                InetAddress address = InetAddress.getLocalHost();

                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1234);     //Gửi packet phải có 4 tham số
                socket.send(packet);
                
                packet = new DatagramPacket(buf, buf.length);                   // Nhận packet chỉ cần 2 tham số
                socket.receive(packet);
                
                String received = new String(packet.getData());         //Chuyển kiểu byte thành string và in ra màn hình
                System.out.println("Current server time: " + received);
                Thread.sleep(1000);
            }
            socket.close();
        
        }catch(Exception e){}
   }
}