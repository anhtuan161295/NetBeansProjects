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
public class BookMag {
    //Properties
    int nextBook = 0;
    String search;
    Books book[] = new Books[5];
    Scanner s = new Scanner(System.in);
    
    
    
    //Constructor
    public BookMag(){
        
    }

    //Method
    public void addBook(){
        boolean a = nextBook >= book.length;

        if(nextBook < book.length){
            
            book[nextBook] = new Books();
            nextBook++;
        }else{
            try{
            a = true;
            System.out.println("Unable to add book");
            }catch(Exception e){

            }    
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
        
        System.out.print("Enter the key words: ");
        search = s.nextLine();
        int count = 0;
        
        for (Books book1 : book) {
            boolean found = book1.title.contains(search);
            if (found == true) {
                System.out.println(book1.title);
                break;
            } else if (found == false) {
                System.out.println("No book to display");
                break;
            }
              
        }
        
        
    }
}

