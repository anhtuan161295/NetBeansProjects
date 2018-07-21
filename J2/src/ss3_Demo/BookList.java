/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3_Demo;

import java.util.TreeMap;

/**
 *
 * @author QQ
 */
public class BookList {
    TreeMap<Integer, Books> list = new TreeMap<>();
    
    public void doAdd(){
        int i = 0;
        Books book = new Books();
        book.input();
        list.put(i, book);
    }
    public void doAdd(int i, Books book){
        book.input();
        list.put(i, book);
    }
    public void doList(){
        Books book = new Books();
        System.out.println(list.values());
    }
    
}
