/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author QQ
 */
public class DataOutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            FileOutputStream source = new FileOutputStream("src/ss4/Data.dat");
            DataOutputStream outData = new DataOutputStream(source);
            
            outData.writeBytes("Hello, how are you ?");
            outData.write(13);
            outData.write(10);
            outData.writeBytes("Fine, thanks. And you ?");
            
            outData.close();
        } catch (IOException e) {}
            try {
                FileInputStream destination = new FileInputStream("src/ss4/Data.dat");
                DataInputStream inData = new DataInputStream(destination);
                
                String s;
                while((s = inData.readLine()) != null){
                    System.out.println(s);
                }
            } catch (EOFException e1) {
                System.out.println("Finish reading file");
            } catch (IOException e2){
                
            }
        }
    }

