/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author QQ
 */
public class FileIOStringDemo {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("src/ss4/test1.txt");
        FileOutputStream fos = new FileOutputStream("src/ss4/test2.txt");
        int size = fis.available();
        
        for (int i = 0; i < size; i++) {
            fos.write(fis.read());
        }
        System.out.println("File copy....."); //Thông báo xử lý
        
        fis.close();
        fos.close();
    }
}
