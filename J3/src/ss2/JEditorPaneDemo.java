/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author QQ
 */
public class JEditorPaneDemo extends JFrame{
    JEditorPane editor;
    JScrollPane scroll;
    URL sUrl;
    
    public JEditorPaneDemo(){
        editor = new JEditorPane();
        scroll = new JScrollPane();
        try {
            sUrl = JEditorPaneDemo.class.getResource("Hello.html");
            editor.setPage(sUrl);
        } catch (IOException ex) {
            Logger.getLogger(JEditorPaneDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void display(){
        
        this.setTitle("JEditorPane Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        scroll.getViewport().add(editor);
        this.getContentPane().add(scroll);
    }
    
    public static void main(String[] args) {
        new JEditorPaneDemo().display();
    }
}
