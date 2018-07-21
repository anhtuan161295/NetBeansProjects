/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class ManageEvents {
    ArrayList<Event> al = new ArrayList<>();
    String filename;
    Scanner s = new Scanner(System.in);
    
    
    public void menu(){
        int choose;
        String ans;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Open");
            System.out.println("3. Save");
            System.out.println("4. Ignore");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
//        Ở đây dùng biến temp để kiếm tra choose
//        Dung để tránh trường hợp nhập chữ mà scanner là nextInt, sẽ báo lỗi
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
                    add();
                    break;
                case 2:
                    open();
                    break;
                case 3:
                    save();
                    break;
                case 4:
                    ignore();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a number again!");
            }
                }else{
                    System.out.println("Please enter a number!");
                }
        } while (!isNum);

            System.out.print("Continue (Y/N) ? ");
                ans = s.nextLine();
        }while(ans.equalsIgnoreCase("y"));
        
    }
    
    
    public void add(){
// Constructor của Event bên kia là input dữ liệu vào
// Nên khi tạo đối tượng là hiện phần nhập, đối tượng có dữ liệu thì add vào arraylist
        Event test1 = new Event();
        al.add(test1);
    }
    
    public void open(){
        try {
//        Tạo file input stream
        FileInputStream fis;
//        filename là tên file mình nhập lúc save, xem phương thức save
        fis = new FileInputStream("src/test/" + filename + ".txt");
//        cái này là kiểm tra file có chứa dữ liệu ko
        int size = fis.available();
        System.out.println("File contents: ");
//        Nếu chứa dữ liệu thì xuất ra màn hình
        for (int i = 0; i < size; i++) {
            System.out.print((char)fis.read());
        }
        System.out.println("\n");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, please save before open");
        } catch (IOException ex) {
            Logger.getLogger(ManageEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    public void save(){
        FileOutputStream fos = null;
        String source = "";
        String filename;
        
//        For each, mỗi phần tử trong arraylist al là kiểu Event (hay generic Event)
//        Nên muốn lấy giá trị của biến thì phải dùng event.
//        Chỗ này là nạp giá trị cho source
        for (Event event : al) {
            source += "Time: " + event.time+ "\r\n" +
                    "Place: " + event.place + "\r\n" +
                    "Content: " + event.content + "\r\n\r\n" 
                     ;
        }
        
        System.out.println("Enter file name to save: ");
        filename = s.nextLine();
        //Lấy filename để open sau khi save
        this.filename = filename;

        try {
//            Đường dẫn của file được ghi dữ liệu vào
            fos = new FileOutputStream("src/test/" + filename + ".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Đọc giá trị của biến source
        byte[] buf = source.getBytes();
        if(buf.length == 0){
            System.out.println("No any book in list.");
        }else{
            for (int i = 0; i < buf.length; i++) {
//           Ghi dữ liệu trong source vào file
                try {
                    fos.write(buf[i]);
                } catch (IOException ex) {
                    Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("File is saved on Hard Disk");
        }
    }
    
    public void ignore(){
        System.out.println("Ignore");
    }
    
    public void delete(){
//        Xóa hết phần tử trong arraylist al
        al.removeAll(al);
    }
    
    public static void main(String[] args) {
        ManageEvents test = new ManageEvents();
        test.menu();
    }
}
