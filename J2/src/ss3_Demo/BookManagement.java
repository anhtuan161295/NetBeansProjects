/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3_Demo;

import java.util.ArrayList;

/**
 *
 * @author QQ
 */
public class BookManagement {
    public ArrayList<Books> list = new ArrayList<>();
    
    
    public void addBooks(){
        //Khởi tạo lớp đối tượng Books
        //Gọi phương thức nhập
        //Dùng phương thức add để add đối tượng Books vào list
        Books bk = new Books();
        bk.input();
        list.add(bk);
    }
    
    public void addBooks02(Books b){
        //Khởi tạo lớp đối tượng Books
        //Gọi phương thức nhập
        //Dùng phương thức add để add đối tượng Books vào list
        //Books bk = new Books();
        b.input();
        list.add(b);
    }
    
    public void display(){
        if(list.isEmpty()){
            System.out.println("No any books");
        }else{
            for (Books books : list) {
                System.out.println(books.toString());
            }
        }
    }
}
