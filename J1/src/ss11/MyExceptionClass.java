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
public class MyExceptionClass {
    String str = "";
    Scanner s = new Scanner(System.in);
    
    public MyExceptionClass(){
        System.out.println("Enter string: ");
        str = s.nextLine();
    }
    public void display() throws MyException{
        if(str.equalsIgnoreCase("asd")){
            throw new MyException("Wrong");
        }
    }
    
    public static void main(String[] args) throws MyException {
        MyExceptionClass test = new MyExceptionClass();
        test.display();
    }
}
