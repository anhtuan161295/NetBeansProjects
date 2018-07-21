/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class SocketDemo_CLIENT {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            System.out.print("Nhập một số: ");
            int i = new Scanner(System.in).nextInt();
            os.write(i);
            System.out.println("Gửi " + i + " đến server...");

            int j = is.read();
            System.out.println("Nhận kết quả xử lý từ server: " + j);

            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Không tạo được socket!");
        }
    }
}
