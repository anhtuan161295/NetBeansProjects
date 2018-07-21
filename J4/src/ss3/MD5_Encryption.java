/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author QQ
 */
public class MD5_Encryption {

    public static String encryptPassword(String key) {
        //Mật khẩu sẽ lấy từ tham số
        String password = key;
        //Chuyển password từ String về Byte
        byte[] bytePlainText = password.getBytes();
        //Tạo đối tượng MessageDigest và đặt thuật toán mã hóa là MD5
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {

        }
        //Cài đặt lại đối tượng MessageDigest về trạng thái ban đầu (xóa hết dữ liệu)
        md.reset();
        //Thêm dữ liệu cho MessageDigest bằng method update(), ở đây dữ liệu là password dạng byte
        md.update(bytePlainText);
        //Mật khẩu sau khi mã hóa sẽ dc gắn vào mảng byte tên là encodePassword
        byte[] encodePassword = md.digest();
        //StringBuilder là 1 đối tượng cho phép ta xây dựng 1 đối tượng String
        //Khởi tạo đối tượng StringBuilder
        StringBuilder sb = new StringBuilder();
        //Long = 8 bytes
        //Convert byte sang String
        for (int i = 0; i < encodePassword.length; i++) {
            sb.append(Long.toString(encodePassword[i] & 0xFF, 16));
        }
        //Trả về String
        return new String(sb);
    }

    public static void main(String[] args) {
        String password = "abc123";
        String myPass = MD5_Encryption.encryptPassword(password);
        System.out.println("Password Encrypt: " + myPass);
    }
}
