/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss6_TestDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author QQ
 */
public class BookList {
    HashMap<String, Books> list = new HashMap<>();
    Scanner s = new Scanner(System.in);
//    String filename;
    ArrayList<String> filename = new ArrayList<>();
    public void addBook(){
        //Books book = new Books();
        String a,b,c ="";
        int d =0;
        
        String str = ("^[B][0-9]{4}-[A][0-9]{2}$");
        boolean isTrue;
        //ID phải theo pattern
        do {  
            System.out.print("Enter book id: ");
            a = s.nextLine();
            isTrue = Pattern.matches(str, a);
            if(isTrue == false){
            System.out.println("Book ID pattern is Bxxxx-Axx (x is digit).");
            }
        } while (isTrue == false);
        
        //Title ko dc để trống
        do {            
            System.out.print("Enter book title: ");
            b = s.nextLine();
            if(b.isEmpty()){
            System.out.println("Book title can not be null.");
        }
        } while (b.isEmpty());
        
        //Category ko dc để trống
        do {            
            System.out.print("Enter book category: ");
            c = s.nextLine();
            if(c.isEmpty()){
            System.out.println("Book category can not be null.");
        }
        } while (c.isEmpty());
        
        //Edition phải là số
        //Tạo biến temp kiểu String, scanner lấy giá trị
        //Nếu đúng pattern thí parseInt, ko đúng thì báo lỗi
        String temp;
        boolean isNum;
        do {            
            System.out.print("Enter book edition: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if(isNum){
                    d = Integer.parseInt(temp);
                }else{
                    System.out.println("Edition must be integer.");
                }
        } while (!isNum);
    
        System.out.println("New book added.");
        Books book = new Books(a, b, c, d);
        
        list.put(book.ID, book);
        
//        if(isTrue == false || book.title.isEmpty() || book.category.isEmpty() ){
//            System.out.println("Can not add book !");
//        }

    }
    public void printList(){
        //Mỗi phần tử của list đều là kiểu book
        //Nên phải dò for each với biến kiểu Books
        //list.values trả về giá trị dạng Books
        
        if (list.isEmpty()) {
            System.out.println("No any book in list.");
        } else {
            for (Books book : list.values()) {
            System.out.println(book.toString());
        }
        }
        
    }
    
    public void searched(String ID){
        
        System.out.print("Search book by ID: ");
        //Biến đếm lỗi
        int j = 0;
        //Nạp giá trị cho ID
        ID = s.nextLine();
        //Nếu tìm được thì j tăng lên 1 và hiển thị kết quả tìm.
        //Nếu ko tìm dc thì j ko đổi > hiện thông báo.
        System.out.println("Result: ");
        for (String id : list.keySet()) {
        if (list.get(id).ID.toLowerCase().contains(ID.toLowerCase())) {
            System.out.println("Book ID: " + list.get(id).ID);
            System.out.println("Book title: " + list.get(id).title);
            System.out.println("Book category: " + list.get(id).category);
            System.out.println("Book edition: " + list.get(id).edition);
            System.out.println("");
            j++;
        }       
        }   
        if (j == 0 ){
            System.out.println("No book to display");
        }
    }
    
    public void saveToFile(String filename){
        //Tạo 1 FileOutputStream để chép ra File.
        FileOutputStream fos = null;
        String source = "";
        //Dò theo Key trong hashmap, keySet trả về tất cả các Key có trong Map
        //Key lúc mình add là Book ID kiểu String nên phải for each theo String
        //Dùng get để lấy value theo key.
        // \r\n là xuống dòng, tùy theo hệ điều hành là Windows hay Mac thì khác nhau
        for (String object : list.keySet()) {
            source += "Book ID: " + list.get(object).ID + "\r\n" +
                    "Book title: " + list.get(object).title + "\r\n" +
                    "Book category: " + list.get(object).category + "\r\n" +
                    "Book edition: " + list.get(object).edition + "\r\n\r\n" ;
        }
        
        
            System.out.println("Enter file name to save: ");
            filename = s.nextLine();
            //Lấy filename để lúc exit mở file txt = notepad
//            this.filename = filename;
            this.filename.add(filename);
        try {
            fos = new FileOutputStream("src/ss6_TestDemo/" + filename + ".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] buf = source.getBytes();
        if(buf.length == 0){
            System.out.println("No any book in list.");
        }else{
            for (int i = 0; i < buf.length; i++) {
            try {
                fos.write(buf[i]);
            } catch (IOException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        
            System.out.println("File is saved on Hard Disk");
        }
        
        
    }
    
    public void exit(){
        try {
            for (String string : filename) {
                Runtime.getRuntime().exec("NotePad src/ss6_TestDemo/" + string + ".txt");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
}

    


   


