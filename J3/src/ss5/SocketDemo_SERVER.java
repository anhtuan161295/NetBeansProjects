/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author QQ
 */
public class SocketDemo_SERVER {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Khởi tạo server...");
            Socket socket = ss.accept();
            OutputStream os = socket.getOutputStream(); //Gửi dữ liệu từ stream
            InputStream is = socket.getInputStream();   //Đọc dữ liệu từ stream

            int i = is.read();          //Đọc request từ Client
            i = i + 1;                    //Server xử lý
            os.write(i);                //Gửi kết quả cho Client

            os.close();
            is.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("Lỗi khởi tạo server!");
        }
    }

}
