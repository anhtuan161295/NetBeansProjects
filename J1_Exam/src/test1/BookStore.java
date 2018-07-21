/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class BookStore {
    int nextBook = 0;
    String search;
    Books book[] = new Books[2];
    Scanner s = new Scanner(System.in);
    
    
    public void addBook(){
        //boolean a = nextBook > book.length;
        
        if(nextBook < book.length){
            
            book[nextBook] = new Books();
            
            System.out.print("Enter book type: ");
            book[nextBook].type = s.nextLine();
            System.out.print("Enter book title: ");
            book[nextBook].title = s.nextLine();
            
            System.out.print("Enter book price: ");
            book[nextBook].price = s.nextInt();
            System.out.print("Enter book edition: ");
            book[nextBook].edition = s.nextInt();
            nextBook++;
            s.nextLine();
        }else{
            
            System.out.println("Unable to add book");
             
        }

    }
    
    public void displayBook(){
        
            if(nextBook == 0){
                System.out.println("No book to display");
            }
            else {
                for (int i = 0; i < nextBook; i++) {
                System.out.println("Book " + (i+1));
                System.out.println("Book type: " + book[i].type);
                System.out.println("Book title: " + book[i].title);
                System.out.println("Book price: " + book[i].price);
                System.out.println("Book edition: " + book[i].edition);
            }
            
            }  
    }
    
    public void searchBook(){
        System.out.print("Search book by title: ");
        
        int j = 0;
       // try {
        search = s.nextLine();
        
            for (int i = 0; i < nextBook; i++) {
               
            if (book[i].title.contains(search)) {
                System.out.println("Result: ");
                System.out.println(book[i].title);
                j++;
            }       
            }   
            if (j == 0 ){
                System.out.println("No book to display");
            }
//            }catch(NullPointerException e){
//            System.out.println("No book to display");
//        }

        
    }
    
    public void menu(){
        
        BookStore test1 = new BookStore();
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
                    test1.addBook();
                    break;
                case 2:
                    test1.displayBook();
                    break;
                case 3:
                    test1.searchBook();
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
    
    public static void main(String[] args) {
        BookStore test = new BookStore();
        test.menu();
        
        
    }
    
}
