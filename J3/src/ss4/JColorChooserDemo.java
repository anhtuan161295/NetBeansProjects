/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author QQ
 */
public class JColorChooserDemo extends JFrame implements ChangeListener {

    JLabel lblDisplay;
    JColorChooser clcPane;
    Color color;

    public JColorChooserDemo() {
        clcPane = new JColorChooser();
        lblDisplay = new JLabel("Test color display", JLabel.CENTER);
        lblDisplay.setForeground(color.yellow);
        lblDisplay.setFont(new Font("SansSerif", Font.BOLD, 45));
        clcPane.getSelectionModel().addChangeListener(this);
    }

    public void display() {

        this.setLayout(new GridLayout(2, 1));
        this.add(clcPane);
        this.add(lblDisplay);

        this.setTitle("JColorChooser Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(500, 500); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java

    }

    public static void main(String[] args) {
        new JColorChooserDemo().display();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        color = clcPane.getColor();
        lblDisplay.setForeground(color);
    }

}
