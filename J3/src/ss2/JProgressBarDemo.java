/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

/**
 *
 * @author QQ
 */
public class JProgressBarDemo extends JFrame{
    JLabel label;
    JPanel panel;
    TitledBorder title;
    JProgressBar progressbar;
    
    public JProgressBarDemo(){
        panel = new JPanel();                       //Tạo panel
        title = new TitledBorder("Progress bar");   //Tạo title cho panel
        panel.setBorder(title);                     //Gắn panel cho panel
        
        progressbar = new JProgressBar(0,0,100);    //Tạo progress bar
    }
    
    public void display(){
        
        this.setTitle("JProgressBar Demo");         // Tựa đề frame
        this.setVisible(true);                      // Hiển thị frame
        this.setSize(400,300);                      // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
        panel.add(progressbar);                 //Gắn progress bar vào panel
        this.getContentPane().add(panel);       //Add panel vào frame
        this.autorun();                         //Chạy hàm autorun
    }
    
    public void autorun(){
        int num = 0;
        while (num <= 100) {            
            try {
                progressbar.setValue(num); //Gán giá trị cho progress bar
                Thread.sleep(1500);        // Đợi 1,5 giây
                num+=10;                   // Giá trị tăng 10
            } catch (InterruptedException ex) {
                Logger.getLogger(JProgressBarDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Progress is completed");
    }
    
    public static void main(String[] args) {
        new JProgressBarDemo().display();
    }
}
