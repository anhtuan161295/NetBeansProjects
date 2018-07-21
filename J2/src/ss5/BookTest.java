/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class BookTest {
    public static void main(String[] args) {
        BookTest test = new BookTest();
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
            System.out.println("4. Save book");
            System.out.println("5. Exit");
            
            System.out.print("Enter a number: ");
            choose = s.nextInt();
            s.nextLine();
            switch (choose){
                case 1:
                    test1.add01();
                    break;
                case 2:
                    test1.display();
                    break;
                case 3:
                    //test1.searchBook();
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter a number again!");
            }
            System.out.print("Continue (Y/N) ? ");
                ans = s.nextLine();
        }while(ans.equalsIgnoreCase("y"));
        
    }
}
