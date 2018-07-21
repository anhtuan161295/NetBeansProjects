/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates02;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class ThucThi {
    
    public static void main(String[] args) {
        QuanLy quanly = new QuanLy();
        Scanner s = new Scanner(System.in);
        String a;
        int choose;
        
        System.out.println("----------------------");
        System.out.println("1. Add");
        System.out.println("2. Display");
        System.out.println("3. Exit");
        System.out.println("----------------------");
        do {
        do {
        System.out.print("Enter your number: ");
        choose = s.nextInt();
        switch(choose){
            case 1:
                quanly.add();
                break;
            case 2:
                quanly.display();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Error");
                break;
        }
        }while(choose < 1 || choose >3);
            s.nextLine();
            System.out.println("Continue ? (Y/N) ");
            a = s.nextLine();
        }while(a.equalsIgnoreCase("y"));
            
    }
}
    
