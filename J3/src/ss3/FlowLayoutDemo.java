/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author QQ
 */
public class FlowLayoutDemo extends JFrame{
    FlowLayout canvas;
    JLabel lblUsername;
    JTextField txtUsername;
    JLabel lblPassword;
    JPasswordField txtPassword;
    JButton btnLogin;
    JButton btnCancel;
    
    public FlowLayoutDemo(){
        canvas = new FlowLayout(FlowLayout.LEFT, 10, 10);
        lblUsername = new JLabel("Username: ");
        txtUsername = new JTextField(10);
        lblPassword = new JLabel("Password: ");
        txtPassword = new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
    }
    
    public void display(){
        this.setTitle("Flow Layout Demo"); // Tựa đề frame
        
        this.setVisible(true); // Hiển thị frame
//        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
        this.setLayout(canvas);
        this.add(lblUsername);
        this.add(txtUsername);
        this.add(lblPassword);
        this.add(txtPassword);
        this.add(btnLogin);
        this.add(btnCancel);
        this.pack(); // Tự động chỉnh kích thước của frame dựa trên component
    }
    
    public static void main(String[] args) {
        new FlowLayoutDemo().display();
    }
}
