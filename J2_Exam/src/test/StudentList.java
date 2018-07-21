/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class StudentList {
    Vector<Student> studentList = new Vector<>();
    String filename;
    
    public void add(Student student){
        studentList.add(student);
    }
    
    public void printVector(){
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }
    
    public void search(String ID){
//        String ID;
        Scanner s = new Scanner(System.in);
        System.out.print("Search student by ID: ");
        //Biến đếm lỗi
        int j = 0;
        //Nạp giá trị cho ID
        ID = s.nextLine();
        //Nếu tìm được thì j tăng lên 1 và hiển thị kết quả tìm.
        //Nếu ko tìm dc thì j ko đổi > hiện thông báo.
        System.out.println("Result: ");
        for (Student student : studentList) {
        if (student.ID.toLowerCase().contains(ID.toLowerCase())) {
            System.out.println("Student ID: " + student.ID);
            System.out.println("Student Name: " + student.Name);
            System.out.println("Student Batch: " + student.Batch);
            System.out.println("Student Mark: " + student.Mark);
            System.out.println("");
            j++;
        }       
        }   
        if (j == 0 ){
            System.out.println("Student not found");
        }
    }
    
    public void saveToFile(String filename){
//        String filename;
        Scanner s = new Scanner(System.in);
        //Tạo 1 FileOutputStream để chép ra File.
        FileOutputStream fos = null;
        String source = "";
        //Vector có generic (kiểu) Student nên dùng for each kiểu student
        // \r\n là xuống dòng, tùy theo hệ điều hành là Windows hay Mac thì khác nhau
        for (Student student : studentList) {
            source += "Student ID: " + student.ID + "\r\n" +
                    "Student Name: " + student.Name + "\r\n" +
                    "Student Batch: " + student.Batch + "\r\n" +
                    "Student Mark: " + student.Mark + "\r\n\r\n" ;
        }
        
            System.out.println("Enter file name to save: ");
            filename = s.nextLine();
            //Lấy filename để lúc exit mở file txt = notepad
            this.filename = filename;

        try {
            fos = new FileOutputStream("src/test/" + filename + ".dat");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found !");
        }
        byte[] buf = source.getBytes();
        if(buf.length == 0){
            System.out.println("No any book in list.");
        }else{
            for (int i = 0; i < buf.length; i++) {
            try {
                fos.write(buf[i]);
            } catch (IOException ex) {
                Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        
            System.out.println("File is saved on Hard Disk");
        }
    }
}
