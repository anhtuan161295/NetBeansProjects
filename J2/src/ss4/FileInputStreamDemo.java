/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        String filename;
        System.out.println("Enter file name: ");
        filename = s.nextLine();
        
        FileInputStream fis = new FileInputStream("src/ss4/" + filename + ".txt");
        int size = fis.available();
        
        System.out.println("File contents: ");
        for (int i = 0; i < size; i++) {
            System.out.print((char)fis.read());
        }
        System.out.println("\n");
        
    }
}
