/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class Student {
    String ID, Name, Batch, Mark;
    Scanner s = new Scanner(System.in);

    public Student() {
        System.out.print("Enter ID: ");
        ID = s.nextLine();
        System.out.print("Enter Name: ");
        Name = s.nextLine();
        System.out.print("Enter Batch: ");
        Batch = s.nextLine();
        System.out.print("Enter Mark: ");
        Mark = s.nextLine();
        
    }
    
    public void setValues(String ID, String Name, String Batch, String Mark){
        this.ID = ID;
        this.Name = Name;
        this.Batch = Batch;
        this.Mark = Mark;
    }

    @Override
    public String toString() {
        String str = "student ID: " + ID + "\r\n" + 
                "student Name: " + Name + "\r\n" + 
                "student Batch: " + Batch + "\r\n" + 
                "student Mark: " + Mark + "\r\n" 
                ;
        return str;
    }
    
    
}
