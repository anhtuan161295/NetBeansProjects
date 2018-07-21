/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss11;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class Number {
    
 
    public static void main(String[] args) {
        int a = 3;
        int b = 0;
        int c;
        Scanner s = new Scanner(System.in);
        try{
            System.out.println("Enter number: ");
            c = s.nextInt();
            System.out.println("U entered number: " + c);
            //System.out.println(a/b);
        }catch(ArithmeticException e){
            //System.out.println("Can not divide by zero");
            //e.printStackTrace();
        }catch(Exception e1){
            System.out.println("You did not enter a number");
        }
        
        
    }
}
