/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class arr01 {
    //Properties
    int[] arr = new int[5];
    Scanner s = new Scanner(System.in);
    int sum = 0;
    //Constructor
    
    //Method
    void ary(){
        String a;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");       
            arr[i] = s.nextInt();
            sum += arr[i];
            s.nextLine();
                    
            System.out.println("Continue ? (Y/N)");
            a = s.nextLine();
            if (a.equalsIgnoreCase("y")){
            }
            else {
                System.out.println("Sum: " + sum);
                System.out.println("The third number is: " + arr[2]);
                break;
            }
        }
        
       
    }
    
    public static void main(String[] args) {
//        arr01 test = new arr01();
//        test.ary();
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        System.out.println("Array List before update : " + test1);
        test1.add(3);
        System.out.println("Array List after update: " + test1);
        System.out.println("The third number is: " + test1.get(2));
    }
}
