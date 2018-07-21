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
public class Assertion {
    public static void main(String[] args) {
        int a;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        a = s.nextInt();
        assert(a>0 && a<10): "The number is out of range";
        System.out.println("Your number is " + a);
    }
}
