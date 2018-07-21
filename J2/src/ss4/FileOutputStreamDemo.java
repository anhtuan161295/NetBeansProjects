/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        String source;
        
        
        String filename;
        System.out.println("Enter file name to save: ");
        filename = s.nextLine();
        
        System.out.println("Enter a string to save to Hard Disk: ");
        source = s.nextLine();
        byte[] buf = source.getBytes();
        FileOutputStream fos = new FileOutputStream("src/ss4/" + filename + ".txt");
        for (int i = 0; i < buf.length; i++) {
            fos.write(buf[i]);
        }
        System.out.println("File is saved on Hard Disk");
        
        
    }
}
