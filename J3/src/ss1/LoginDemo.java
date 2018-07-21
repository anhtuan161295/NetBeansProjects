/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author QQ
 */
public class LoginDemo extends JFrame{
    JPanel panel;
    TitledBorder title;
    JLabel lblUser, lblPassword;
    JTextField txtUser;
    JPasswordField txtPassword;
    JButton btnLogin;

    public LoginDemo() {
        panel = new JPanel(); // Tạo panel
        title = new TitledBorder("Login"); // Tiêu đề panel
        panel.setBorder(title); // Tạo khung đường viên xung quanh title
        
        lblUser = new JLabel("User: "); // Gắn chữ cho label
        lblPassword = new JLabel("Password: ");
        txtUser = new JTextField(25); // Độ dài của text field
        txtPassword = new JPasswordField(25);
        btnLogin = new JButton("Login");
        
    }
    
    public void display(){
       
        this.getContentPane().add(panel); // Gắn panel vào frame
        // Add label, text field, button vào panel
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        
        this.setTitle("Login Form"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
    }
    
    public static void main(String[] args) {
        new LoginDemo().display();
    }
}
