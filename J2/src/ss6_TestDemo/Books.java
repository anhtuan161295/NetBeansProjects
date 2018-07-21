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
public class Books {
    String ID, title, category;
    int edition;
    Scanner s = new Scanner(System.in);
    
    public Books(String ID, String title, String category, int edition){
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.edition = edition;
    }
    
    public Books(){
        
    }

    @Override
    public String toString() {
        String str = "Book id: " + ID + "\n" +
                "Book title: " + title + "\n" +
                "Book category: " + category + "\n" +
                "Book edition: " + edition + "\n" 
                ;
        return str;
    }
    
    
}
