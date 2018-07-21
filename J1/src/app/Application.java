/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import highSchool.PupilsManagement;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class Application {
    public static void main(String[] args) {
        PupilsManagement manage = new PupilsManagement();
        Scanner s = new Scanner(System.in);
        String a;
        int choose;
        
        System.out.println("----------------------");
        System.out.println("1. Add new pupils.");
        System.out.println("2. Display all information.");
        System.out.println("3. Quit.");
        System.out.println("----------------------");
        
        do {
            try{
        do {
        System.out.print("Enter your number: ");
        
        choose = s.nextInt();
                switch (choose) {
                    case 1:
                        manage.addPupils();
                        break;
                    case 2:
                        manage.showPupils();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Please enter a number again.");
                        break;
                }
                
        }while(choose < 1 || choose >3);
            }catch(InputMismatchException e){
                System.out.println("Please enter a number again.");
            }
            s.nextLine();
            System.out.println("Continue ? (Y/N) ");
            a = s.nextLine();
        }while(a.equalsIgnoreCase("y"));
    
    }
}
