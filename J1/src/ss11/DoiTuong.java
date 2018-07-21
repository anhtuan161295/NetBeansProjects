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
public class DoiTuong implements ChaNuoi{
    int code;
    String name;
    Scanner s = new Scanner(System.in);
    public DoiTuong(){
        
        
    }
    public void input(){
        System.out.println("Enter code: ");
        code = s.nextInt();
        s.nextLine();
        System.out.println("Enter name: ");
        name = s.nextLine();
    }
    
    @Override
    public String toString(){
        return "Code: " + code +"\n" + 
                "Name: " + name + "\n" +
                "Money: " + usd;
    }
}
