/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss11;

/**
 *
 * @author QQ
 */
public class QuanLy {
    DoiTuong doituong = new DoiTuong();
    public void add(){
        doituong.input();
    }
    public void display(){
        System.out.println(doituong.toString());
    }
}
