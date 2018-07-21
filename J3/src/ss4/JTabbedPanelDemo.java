/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author QQ
 */
public class JTabbedPanelDemo extends JFrame{
    JTabbedPane pane;
    
    public JTabbedPanelDemo()  {
        pane = new JTabbedPane();
        pane.addTab("Tab-01", showPanel("Tab-01 Contents"));
        pane.addTab("Tab-02", showPanel("Tab-02 Contents"));
        pane.addTab("Tab-03", showPanel("Tab-02 Contents"));
        
        pane.setBackgroundAt(0, Color.red);
        pane.setBackgroundAt(1, Color.green);
        pane.setBackgroundAt(2, Color.blue);
        
        this.getContentPane().add(pane);
    }
    
    public static JPanel showPanel(String s){
        JPanel p = new JPanel();
        p.add(new JLabel(s));
        return p;
    }
    
    public void display() {
        
        
        this.setTitle("JTabbedPanel Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(500, 500); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java

    }

    public static void main(String[] args) {
        new JTabbedPanelDemo().display();
    }
}
