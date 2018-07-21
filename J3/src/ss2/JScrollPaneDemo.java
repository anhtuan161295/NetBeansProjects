/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author QQ
 */
public class JScrollPaneDemo extends JFrame{
    JTextArea textarea;
    JScrollPane scrollpane;

    public JScrollPaneDemo() {
        textarea = new JTextArea(20, 5);
        scrollpane = new JScrollPane();
        scrollpane.getViewport().add(textarea);
        
    }
    
    
    public void display(){
        this.add(scrollpane);
        
        this.setTitle("JSrollPane Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
    }
    
    public static void main(String[] args) {
        new JScrollPaneDemo().display();
    }
}
