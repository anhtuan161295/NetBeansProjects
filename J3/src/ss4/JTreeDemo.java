/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss4;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author QQ
 */
public class JTreeDemo extends JFrame implements TreeSelectionListener{

    JScrollPane scroll;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode node;
    JTree tree;
    JLabel display;

    public JTreeDemo() {
        this.showGUI();
        tree.addTreeSelectionListener(this);
    }
    
    

    public void showGUI() {
        root = new DefaultMutableTreeNode("Catalogue");
        
        node = new DefaultMutableTreeNode("Books");
        node.add(new DefaultMutableTreeNode("XML Simplified"));
        node.add(new DefaultMutableTreeNode("Java by Example"));
        node.add(new DefaultMutableTreeNode("C# Simplified"));
        root.add(node);
        
        node = new DefaultMutableTreeNode("Compact disc");
        node.add(new DefaultMutableTreeNode("MSDN 2005"));
        node.add(new DefaultMutableTreeNode("Visual Studio .NET"));
        node.add(new DefaultMutableTreeNode("NetBeans 7.1"));
        root.add(node);
        
        tree = new JTree(root);
        scroll = new JScrollPane(tree);
        display = new JLabel("Status: none");
        
    }

    public void display() {
        this.setLayout(new BorderLayout());
        this.getContentPane().add(scroll,BorderLayout.CENTER);
        this.getContentPane().add(display,BorderLayout.SOUTH);
        
        this.setTitle("JTree Demo"); // Tựa đề frame
        this.setVisible(true); // Hiển thị frame
        this.setSize(500, 500); // Kích thước frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Tự động tắt khi stop java

    }

    public static void main(String[] args) {
        new JTreeDemo().display();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        display.setText("Status: "+ tree.getLastSelectedPathComponent().toString());
    }

}
