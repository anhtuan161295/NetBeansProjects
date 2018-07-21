/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss8;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author QQ
 */
public class Apps {
    Locale currentLocale;
    ResourceBundle messages;
    
    public void showEN(){
        currentLocale = new Locale("en", "US");
        messages = ResourceBundle.getBundle("ss8/"+"Apps_en_US",currentLocale);
        display();
    }
    public void showVI(){
        currentLocale = new Locale("vi", "VI");
        messages = ResourceBundle.getBundle("ss8/"+"Apps_vi_VI",currentLocale);
        display();
    }
    public void display(){
        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("inquiry"));
        System.out.println(messages.getString("farewell"));

    }
    public void menu(){
        showVI();
    }
    public static void main(String[] args) {
        new Apps().menu();
    }
    
}
