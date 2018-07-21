/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import javax.swing.JFrame;

/**
 *
 * @author QQ
 */
public class JFrameDemo extends JFrame{
    public void display(){
        this.setTitle("JFrame Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
    }
    
    public static void main(String[] args) {
        new JFrameDemo().display();
    }
}
