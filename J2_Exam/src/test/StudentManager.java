/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class StudentManager {
    public static void main(String[] args) {
        StudentManager test = new StudentManager();
        test.menu();
    }
    
    
    public void menu(){
        StudentList test = new StudentList();
        int choose;
        String ans;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Menu");
            System.out.println("1. Add new student");
            System.out.println("2. Display student list");
            System.out.println("3. Search a student by ID");
            System.out.println("4. Save to file");
            System.out.println("5. Quit");
//        Ở đây dùng biến temp để kiếm tra choose
//        Dung để tránh trường hợp nhập chữ mà scanner là nextInt, sẽ báo lỗi
        String temp;
        boolean isNum;
        do {            
            System.out.print("Please select 1/2/3/4/5: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if(isNum){
                    choose = Integer.parseInt(temp);
                    switch (choose){
                case 1:
                    test.add(new Student());
                    break;
                case 2:
                    test.printVector();
                    break;
                case 3:
                    test.search("");
                    break;
                case 4:
                    test.saveToFile("");
                    break;
                case 5:
                    System.exit(0);
                    break;
               
                default:
                    System.out.println("Enter a number again!");
            }
                }else{
                    System.out.println("Please enter a number!");
                }
        } while (!isNum);

            System.out.print("Continue (Y/N) ? ");
                ans = s.nextLine();
        }while(ans.equalsIgnoreCase("y"));
        
    }
}
