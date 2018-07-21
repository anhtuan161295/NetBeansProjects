/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class Pupils extends Person{
    public String name;
    public int age;
    public String nationality;
    Scanner s = new Scanner(System.in);
    
    public Pupils(){
        System.out.print("Enter name: ");
        name = s.nextLine();
        
        System.out.print("Enter age: ");
        age = s.nextInt();
        s.nextLine();
        System.out.print("Enter nationality: ");
        nationality = s.nextLine();
    }
    

    @Override
    public void personalReport() {
        
    }
    
}
