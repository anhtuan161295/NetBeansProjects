/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

/**
 *
 * @author QQ
 */
public class NotePad {
    public static void main(String[] args) {
        try {
//            Runtime run = Runtime.getRuntime();
//            Process pc = run.exec("NotePad src/ss5/test.txt");
            
            Runtime.getRuntime().exec("NotePad src/ss5/test.txt");
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
