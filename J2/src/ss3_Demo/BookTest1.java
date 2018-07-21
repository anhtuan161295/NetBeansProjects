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
public class BookTest1 {
    public static void main(String[] args) {
        BookTest1 test = new BookTest1();
        test.menu();
    }
    
    public void menu(){
        
        BookList test1 = new BookList();
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
                    test1.doAdd();
                    break;
                case 2:
                    test1.doList();
                    break;
                case 3:
                    //test1.searchBook();
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
