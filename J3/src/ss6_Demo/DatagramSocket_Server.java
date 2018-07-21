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
import java.util.Date;

/**
 *
 * @author QQ
 */
public class DatagramSocket_Server {

    public static void main(String[] args) {
        try {
            //Kết nối đi từ socket server -> socket client
            DatagramSocket socket; //Tạo socket, điểm cuối của server
            System.out.println("Khởi động server...");
            socket = new DatagramSocket(1234); //Gán port 1234 cho socket

            for (int i = 0; i < 10; i++) { //Gửi dữ liệu về Client 10 lần
                byte[] buf = new byte[100]; //Tạo bộ đệm cho dữ liệu
                //Tạo gói dữ liệu, giống bên client
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet); //Nhận dữ liệu từ client
                //Gắn ngày giờ hiện tại cho buf, chuyển dữ liệu từ kiểu Date -> String -> Byte
                buf = new Date().toString().getBytes();

                InetAddress address = packet.getAddress(); //Lấy address của client từ dữ liệu dc gửi
                int port = packet.getPort(); //Lấy port của client từ dữ liệu dc gửi
                //Gửi dữ liệu về client
                packet = new DatagramPacket(buf, buf.length, address, port); //Gửi packet thì cần 4 tham số như client
                socket.send(packet);
            }
            //Đóng socket
            socket.close();

        } catch (IOException ex) {
            //Báo lỗi

        }

    }
}
