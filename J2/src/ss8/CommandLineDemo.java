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
public class CommandLineDemo {
    public static void main(String[] args) {
        Locale currentLocale;
        ResourceBundle messages;
        currentLocale = new Locale("en", "US");
        
        messages = ResourceBundle.getBundle("ss8/"+"Apps_vi_VI",currentLocale);
        
        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("inquiry"));
        System.out.println(messages.getString("farewell"));
        
    }
}
