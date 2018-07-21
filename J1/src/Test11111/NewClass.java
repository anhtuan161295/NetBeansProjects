/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test11111;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class NewClass {
    int id;
    String name;
    Scanner s = new Scanner(System.in);
    
    public NewClass(){
        id = s.nextInt();
        name = s.nextLine();
    }
    public NewClass(int id, String name){
        
        this.id = id;
        this.name = name;
    }
}
