/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zMayChu;

import java.util.Scanner;
import zChaMe.ChaMe;

/**
 *
 * @author QQ
 */
public class DoiTuong extends ChaMe{
    //Properties
    int no;
    String name;
    Scanner s;
    //Constructor
    public DoiTuong(){
        
        
    }
    
    //Method
    public void output(){
        System.out.println("No: " + no);
        System.out.println("Name: " + name);
    }

    @Override
    protected void input() {
        s = new Scanner(System.in);
        System.out.print("Enter no: ");
        no = s.nextInt();
        //Xóa bộ đệm // Flush all
        s.nextLine();
        
        System.out.print("Enter name: ");
        name = s.nextLine();
    }
    
    
}
