/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author QQ
 */
public class NewClass {
    public short getInt(){
        int s = 5;
        return (short) s;
    }

   
    
    public static void main(String[] args) {
        NewClass a = new NewClass();
        a.getInt();
        System.out.println(a.getInt());
    }


}
