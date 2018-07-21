/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates02;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class DoiTuong {
    //Properties
    int no;
    String name;
    Scanner s;
    //Constructor
    public DoiTuong(){
        
        
    }
    
    //Method
//    public void output(){
//        System.out.println("No: " + no);
//        System.out.println("Name: " + name);
//    }

    @Override
    public String toString() {
        return "No: " + no + "\n" +
                "Name: " + name ;
    }
    
    
}
