/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author QQ
 */
public class JListDemo extends JFrame implements ActionListener {

    JPanel panel;
    JList listDisplay;
    DefaultListModel model;
    JButton btnAdd;
    JButton btnRemove;
    JTextField txtName;
    String[] data;

    public JListDemo() {
        data = new String[]{"Alex Paul", "John Brown", "Bill Gate", "Peter Pan", "John Carter"};
        panel = new JPanel();
        model = new DefaultListModel();

        for (int i = 0; i < data.length; i++) {
            model.addElement(data[i]);
        }

        listDisplay = new JList(model);
        btnAdd = new JButton("+");
        btnRemove = new JButton("-");
        txtName = new JTextField(30);

        panel.add(btnAdd);
        panel.add(txtName);
        panel.add(btnRemove);

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
    }

    public void display() {
        this.setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        this.add(listDisplay, BorderLayout.CENTER);
        this.setTitle("JList Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(500, 500); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java

    }

    public static void main(String[] args) {
        new JListDemo().display();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            model.addElement(txtName.getText().trim());
        } else if (model.getSize() > 0) {
            model.removeElementAt(0);
        }
        

//        for (int i = data.length; i < data.length+1; i++) {
//            
//        }
    }

}
