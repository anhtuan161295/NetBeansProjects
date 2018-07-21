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
public class Books {
    String id, title, category;
    int edition;
    Scanner s = new Scanner(System.in);
    
    public void setValue(){
        System.out.print("Enter book id: ");
        id = s.nextLine();
        System.out.print("Enter book title: ");
        title = s.nextLine();
        System.out.print("Enter book category: ");
        category = s.nextLine();
//        s.nextLine();
        System.out.print("Enter book edition: ");
        edition = s.nextInt();
    }
    public void toSetValue(String id, String title, String category, int edition){
        this.id = id;
        this.title = title;
        this.category = category;
        this.edition = edition;
    }

    @Override
    public String toString() {
        String str = "Book id: " + id + "\n" +
                "Book title: " + title + "\n" +
                "Book category: " + category + "\n" +
                "Book edition: " + edition + "\n" 
                ;
        return str;
    }
    
    
}
