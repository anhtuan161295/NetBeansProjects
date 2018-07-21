/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3_Demo;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class Books {
    int id;
    String title;
    float price;
    Scanner s = new Scanner(System.in);
    
    public void input(){
        System.out.print("Enter book id: ");
        id = s.nextInt();
        s.nextLine();
        System.out.print("Enter book title: ");
        title = s.nextLine();
        
        System.out.print("Enter book price: ");
        price = s.nextFloat();
    }

    @Override
    public String toString() {
        String s = "Book id: " + id + "\n" +
                "Book title: " + title + "\n" +
                "Book price: " + price + "\n";
        return s;
    }        

    
//    public static void main(String[] args) {
//        Books test = new Books();
//        test.input();
//        System.out.println(test.toString());
//    }
    
}
