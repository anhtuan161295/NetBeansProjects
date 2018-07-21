/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author QQ
 */
public class JButtonListenerDemo extends JFrame implements ActionListener{
    JButton btnTest;
    
    public JButtonListenerDemo(){
        btnTest = new JButton("Test");
        btnTest.addActionListener(this);
    }
    
  
    
    public void display(){
        this.add(btnTest);
        
        this.setVisible(true);
        this.setTitle("JButtonListener Demo");
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new JButtonListenerDemo().display();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Hello, how are you ? ");
    }
}
