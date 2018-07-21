/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss6_TestDemo;

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
            System.out.println("1. Add new book");
            System.out.println("2. Display book list");
            System.out.println("3. Search book by ID");
            System.out.println("4. Save to file");
            System.out.println("5. Quit");
            
//            System.out.print("Enter a number: ");
//            choose = s.nextInt();
//            s.nextLine();
        String temp;
        boolean isNum;
        do {            
            System.out.print("Enter a number: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if(isNum){
                    choose = Integer.parseInt(temp);
                    switch (choose){
                case 1:
                    test1.addBook();
                    break;
                case 2:
                    test1.printList();
                    break;
                case 3:
                    test1.searched("");
                    break;
                case 4:
                    test1.saveToFile("");
                    break;
                case 5:
                    test1.exit();
                default:
                    System.out.println("Enter a number again!");
            }
                }else{
                    System.out.println("Please enter a number!");
                }
        } while (!isNum);
                
//            switch (choose){
//                case 1:
//                    test1.addBook();
//                    break;
//                case 2:
//                    test1.printList();
//                    break;
//                case 3:
//                    test1.searched("");
//                    break;
//                case 4:
//                    test1.saveToFile("");
//                    break;
//                case 5:
//                    test1.exit();
//                default:
//                    System.out.println("Enter a number again!");
//            }
            System.out.print("Continue (Y/N) ? ");
                ans = s.nextLine();
        }while(ans.equalsIgnoreCase("y"));
        
    }
}
