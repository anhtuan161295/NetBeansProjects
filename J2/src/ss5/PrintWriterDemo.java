/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

import java.io.PrintWriter;

/**
 *
 * @author QQ
 */
public class PrintWriterDemo {
    public static void main(String[] args) {
        int i = -7;
        String s = "This is a string";
        
        PrintWriter pw = new PrintWriter(System.out, true);
        
        pw.println("Print the value: ");
        pw.println(i);
        pw.println(s);
        
        pw.close();
    }
}
