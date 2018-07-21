/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author QQ
 */
public class BookList {
    TreeMap<String, Books> list = new TreeMap<>();
    
    public void add(Books b){
        b.toSetValue("dsaasd","abc","dfds",4);
        list.put(b.id, b);
          
    }
    
    public void add01(){
        Books book = new Books();
        book.setValue();
        list.put(book.id, book);
    }
    
    public void display(){
        for (Books book : list.values()) {
            System.out.println(book.toString());
        }
    }
    public static void main(String[] args) {
        BookList t = new BookList();
        Books b2 = new Books();
        t.add(b2);
        t.display();
    }
}
