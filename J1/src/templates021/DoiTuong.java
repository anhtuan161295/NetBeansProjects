/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates021;

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
        s = new Scanner(System.in);
        System.out.print("Enter no: ");
        no = s.nextInt();
        //Xóa bộ đệm // Flush all
        s.nextLine();
        
        System.out.print("Enter name: ");
        name = s.nextLine();
        
    }
    
    //Method
    public void output(){
        System.out.println("No: " + no);
        System.out.println("Name: " + name);
    }
    
    
}
