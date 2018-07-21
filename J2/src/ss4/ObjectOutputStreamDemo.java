/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;


/**
 *
 * @author QQ
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/ss4/test.bin");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            
            String myName = "Haha";
            Date birthday = new Date();
            
            os.writeObject(myName);
            os.writeObject(birthday);
            
            System.out.println("Successful");
            
            os.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
