/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss6_Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author QQ
 */
public class DatagramSocket_Client {

    public static void main(String[] args) {
        try {
//Socket là điểm cuối cùng (endpoint) của 1 kết nối (connection). 1 kết nối thì có 2 socket, như vậy client và server có 2 socket riêng.
//Socket là sự kết hợp giữa IP:port. VD: 127.0.0.1:80 là 1 socket
//IP là địa chỉ vật lý, dùng để phân biệt máy tính trong mạng LAN hoặc Internet. VD: 127.0.0.1 là IP 
//Port là cổng kết nối, dùng để phân biệt các chương trình (process) đang chạy trên máy của 1 máy trong mạng LAN/Internet. VD: Port 80
            //Kết nối đi từ socket client -> socket server
            //Tạo socket, điểm cuối của client
            DatagramSocket socket = new DatagramSocket(); //Datagram socket là 1 socket có giao thức UDP

            for (int i = 0; i < 10; i++) { //Tạo vòng lặp, gửi dữ liệu đến server 10 lần
                //Tạo địa chỉ để gửi đến, ở đây gửi đến server với địa chỉ là localhost
                InetAddress address = InetAddress.getLocalHost();
                byte[] buf = new byte[100]; //Tạo bộ đệm cho dữ liệu
                //Tạo gói dữ liệu, dữ liệu lấy từ bộ đệm ở trên, với độ dài (buf.length) là 100 (số phẩn tử mảng ở trên)
                //Gửi đến localhost, port là 1234
                //Gửi đi cần 4 tham số: dữ liệu, độ dài, địa chỉ, port
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1234);
                socket.send(packet); //Gửi dữ liệu đến server

                //Tạo gói nhận dữ liệu từ server
                //Nhận về chỉ cần 2 tham số: dữ liệu, độ dài
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                //getData là method lấy dữ liệu trong packet
                //new String sẽ chuyển dữ liệu từ kiểu byte sang string
                String received = new String(packet.getData());
                //Xuất kết quả ra màn hình
                System.out.println("Current server time: " + received);
                Thread.sleep(1000);
            }
            //Đóng socket
            socket.close();
        } catch (IOException ex) {
            //Báo lỗi

        } catch (InterruptedException ex) {

        }
    }
}
