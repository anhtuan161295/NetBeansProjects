/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author QQ
 */
public class CardLayoutDemo extends JFrame implements ActionListener{
    CardLayout canvas;
    Panel panel;
    JButton btn;
    String[] labels;
    int cardno;
    
    
    
    public CardLayoutDemo(){
        canvas = new CardLayout();
        panel = new Panel();
        btn = new JButton("Next");
        labels = new String[4];
        cardno = 0;
    }
    
    public void display(){
        panel.setLayout(canvas);
        labels[0] = "The first card";
        labels[1] = "The second card";
        labels[2] = "The third card";
        labels[3] = "The last card";
        
        for (int i = 0; i < 4; i++) {
            panel.add(labels[i], new JLabel(labels[i], JLabel.CENTER));
        }
        canvas.show(panel, labels[0]);
        this.setLayout(new BorderLayout());
        this.add("Center", panel);
        this.add("South", btn);
        btn.addActionListener(this);
        
        
        this.setTitle("Card Layout Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.pack(); // Tự động chỉnh kích thước của frame dựa trên component
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(++cardno >= 4){
            cardno = 0;
        }
        canvas.show(panel, labels[cardno]);
    }
   
    
    public static void main(String[] args) {
        new CardLayoutDemo().display();
    }

    
}
