/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


/**
 *
 * @author QQ
 */
public class JPanelDemo extends JFrame{
    JPanel panel;
    TitledBorder title;
    public void display(){
        panel = new JPanel(); // Tạo panel
        title = new TitledBorder("My Panel"); // Tiêu đề panel
        panel.setBorder(title); // Tạo khung đường viên xung quanh title
        
        this.getContentPane().add(panel); // Gắn panel vào frame
        
        this.setTitle("JPanel Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
    }
    
    public static void main(String[] args) {
        new JPanelDemo().display();
    }
}
