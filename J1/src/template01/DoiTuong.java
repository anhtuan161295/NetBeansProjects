/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template01;


import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class DoiTuong {
    //Properties
    int no;
    String name;
    Scanner s = new Scanner(System.in);;
    //Constructor
    public DoiTuong(){
        
        
    }
    
    //Method
    void output(){
        System.out.println("No: " + no);
        System.out.println("Name: " + name);
    }
    void input(){
        System.out.print("Enter no: ");
        no = s.nextInt();
        //Xóa bộ đệm // Flush all
        s.nextLine();
        
        System.out.print("Enter name: ");
        name = s.nextLine();
    }
    
    
}
