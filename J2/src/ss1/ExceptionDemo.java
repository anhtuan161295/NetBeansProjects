/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class ExceptionDemo {
    
    
    public ExceptionDemo(){
        
    }
    public void display(int a) {
        try{
        if(a<0){
            throw new Exception();
        }
            System.out.println("You entered a positive number");
    }catch(Exception e){
            System.out.println("You entered a negative number");
    }
    
}
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ExceptionDemo test = new ExceptionDemo();
        System.out.println("Enter a number: ");
        
        int a = s.nextInt();
        test.display(a);
        
    }
}
