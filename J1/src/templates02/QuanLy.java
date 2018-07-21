/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates02;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class QuanLy {
    DoiTuong doituong;
    Scanner s = new Scanner(System.in);
    void add(){
        doituong = new DoiTuong();
        
        s = new Scanner(System.in);
        System.out.print("Enter no: ");
        doituong.no = s.nextInt();
        //Xóa bộ đệm // Flush all
        s.nextLine();
        
        System.out.print("Enter name: ");
        doituong.name = s.nextLine();
    }
    
    void display(){
        System.out.println(doituong.toString());
    }
    
}
