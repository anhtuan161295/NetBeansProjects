/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss8;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class StringDemo {
    //Properties
    String str = "abcd";
    Scanner s = new Scanner(System.in);
    
    //Constructor
    
    //Method
    void checkStr(){
        boolean str1 = str.endsWith("abcd");
        boolean str2 = str.endsWith("ab");
        boolean str3 = str.startsWith("ab");
        boolean str4 = str.startsWith("bc");
        System.out.println("The string is '" + str +"'");
//        System.out.println("Ends with 'abcd'");
//        System.out.println("Return: " + str1);
//        System.out.println("Ends with 'ab'");
//        System.out.println("Return: " + str2);
//        System.out.println("Starts with 'ab'");
//        System.out.println("Return: " + str3);
//        System.out.println("Starts with 'bc'");
//        System.out.println("Return: " + str4);
//          if(str2){
//              System.out.println("OK");
//          }else{
//              System.out.println("Not OK");
//          }

    }
    public static void main(String[] args) {
        StringDemo test = new StringDemo();
        test.checkStr();
    }
    
}
