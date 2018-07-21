/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.util.Hashtable;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author QQ
 */
public class JSliderDemo extends JFrame implements ChangeListener{
    JSlider slider;
    Hashtable<Integer, JLabel> label;

    public JSliderDemo() {
        slider = new JSlider(0, 0, 30, 15); // Tạo thanh slider
        slider.setMajorTickSpacing(10);     // Đặt khoảng cách giá trị trên slider
        slider.setPaintTicks(true);         // Hiển thị dấu gạch chia các khoảng giá trị
        slider.setPaintLabels(true);        // Hiển thị nhãn của các khoảng giá trị (hiển thị số dưới dấu gạch)
        
//        label = new Hashtable<>();
//        label.put(0, new JLabel("A"));
//        label.put(10, new JLabel("B"));
//        label.put(20, new JLabel("C"));
//        label.put(30, new JLabel("D"));
//        slider.setLabelTable(label);        // Gắn table vào slider
//        slider.setPaintLabels(true);
//        slider.addChangeListener(this);
    }
    
    public void display(){
        this.add(slider);
        
        this.setTitle("JSlider Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
        
    }
    
    public static void main(String[] args) {
        new JSliderDemo().display();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Nếu slider dc kéo thì in giá trị ra màn hình
        if(slider.getValueIsAdjusting()){
            System.out.println(slider.getValue());
        }
    }
}
