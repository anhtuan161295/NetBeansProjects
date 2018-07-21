/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author QQ
 */
public class TestPatternMatch {
    String str;
    Scanner s;
    public void testMask(){
        boolean isTrue;
        String rs = "^[b][0-9]-[b][0-9]$";
        s = new Scanner(System.in);
        do {
            System.out.println("Enter string: ");
            str = s.nextLine();
            isTrue = Pattern.matches(rs, str);
            if(isTrue){
                System.out.println("Pattern match");
            }else{
                System.out.println("Pattern not match");
            }
        }while(!isTrue);
       
    }
    
    public static void main(String[] args) {
        TestPatternMatch test = new TestPatternMatch();
        test.testMask();
    }
}
