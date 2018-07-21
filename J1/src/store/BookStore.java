/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.Scanner;
import server.BookMag;

/**
 *
 * @author QQ
 */
public class BookStore {
    public static void main(String[] args) {
        BookStore test = new BookStore();
        test.menu();
    }
    
    public void menu(){
        BookMag a = new BookMag();
        int choose;
        String ans;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Menu");
            System.out.println("1. Add book");
            System.out.println("2. Display book");
            System.out.println("3. Search book");
            System.out.println("4. Exit");
            
            System.out.print("Enter a number: ");
            choose = s.nextInt();
            s.nextLine();
            switch (choose){
                case 1:
                    a.addBook();
                    break;
                case 2:
                    a.displayBook();
                    break;
                case 3:
                    a.searchBook();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Enter a number again!");
            }
            System.out.print("Continue (Y/N) ? ");
                ans = s.nextLine();
        }while(ans.equalsIgnoreCase("y"));
    }
}
