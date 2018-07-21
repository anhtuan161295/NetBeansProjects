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
public class Books {
    //Properties
    String type ;
    String title ;
    int price ;
    int edition ;
    Scanner s = new Scanner(System.in);
    
    
    //Constructor
    public Books() {
        System.out.print("Enter book type: ");
        type = s.nextLine();
        System.out.print("Enter book title: ");
        title = s.nextLine();
        System.out.print("Enter book price: ");
        price = s.nextInt();
        System.out.print("Enter book edition: ");
        edition = s.nextInt();
    }

    
    //Method
 
}
