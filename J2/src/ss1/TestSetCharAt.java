/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class TestSetCharAt {
    StringBuilder str;
    Scanner s = new Scanner(System.in);
    public TestSetCharAt(){
        
        str = new StringBuilder("Test test");
        
    }
    
    public void testSetCharAt(){
        System.out.println("String before: " + str);
        str.setCharAt(1, 'B');
        System.out.println("String after: " + str);
    }
    
    
    public static void main(String[] args) {
        TestSetCharAt test = new TestSetCharAt();
        test.testSetCharAt();
    }
}
