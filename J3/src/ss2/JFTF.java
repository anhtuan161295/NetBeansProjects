/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author QQ
 */
public class JFTF extends JFrame{
    JFormattedTextField text;
    MaskFormatter format;
    JPanel panel;
    TitledBorder title;
    
    public JFTF(){
        panel = new JPanel();
        title = new TitledBorder("JFormattedTextField Demo");
        panel.setBorder(title);
        try {
            format = new MaskFormatter("##/##/####");
            format.getPlaceholderCharacter();
        } catch (ParseException ex) {
            Logger.getLogger(JFTF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        text = new JFormattedTextField(format);
        text.setColumns(6); // Khoảng trống cho số kí tự nhập vào, ##/##/#### là 6 kí tự nên để 6 cột
        
    }
    
    public void display(){
        this.setTitle("JFormattedTextField Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
        this.getContentPane().add(panel);
        panel.add(text);
        
    }
    
    public static void main(String[] args) {
        new JFTF().display();
    }
}
