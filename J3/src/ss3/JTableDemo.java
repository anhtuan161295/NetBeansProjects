/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author QQ
 */
public class JTableDemo extends JFrame{
    String[] columnName;
    Object[][] data;
    JTable table;
    DefaultTableModel model;
    
    public JTableDemo(){
        columnName = new String[]{"Name","Surname","Age"};
        data = new Object[][]{
            {"Alex","Paul","23"},
            {"Michael","John",20},
            {"Jollibe","Mcdonalds",15}
                            };
        model = new DefaultTableModel(data, columnName);
        table = new JTable(model);
        
    }
    
    public void display(){
        this.add(table);
        
        this.setTitle("Flow Layout Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
//        this.pack(); // Tự động chỉnh kích thước của frame dựa trên component
        this.setSize(400,300); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java
    }
    
    public static void main(String[] args) {
        new JTableDemo().display();
    }
}
