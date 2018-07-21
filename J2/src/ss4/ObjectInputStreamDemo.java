/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 *
 * @author QQ
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/ss4/test.bin");
            ObjectInputStream is = new ObjectInputStream(fis);
            
            String name = (String)is.readObject();
            Date birthday = (Date)is.readObject();
            System.out.println("Name: " + name);
            System.out.println("Birth day: " + birthday);
            
            is.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e1){
            System.out.println("Class of serialized object not found");
        }
    }
}
