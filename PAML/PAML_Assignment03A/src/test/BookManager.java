/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author QQ
 */
public class BookManager {

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.menu();
    }

    public void menu() {
        BookController test = new BookController();
        int choose;
        String ans;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1. Create xml file");
            System.out.println("2. Read xml file");
            System.out.println("3. Update xml file");
            System.out.println("4. Add node");
            System.out.println("5. Delete node");
            System.out.println("6. Exit");
//        Ở đây dùng biến temp để kiếm tra choose
//        Dung để tránh trường hợp nhập chữ mà scanner là nextInt, sẽ báo lỗi
            String temp;
            boolean isNum;
            do {
                System.out.print("Please select 1/2/3/4/5/6: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if (isNum) {
                    choose = Integer.parseInt(temp);
                    switch (choose) {
                        case 1:
                            test.createXML();
                            break;
                        case 2:
                            test.readXML();
                            break;
                        case 3:
                            String code;
                            String title;
                            String price;
                            String author;
                            String edition;
                            System.out.print("Enter book code : ");
                            code = s.nextLine();
                            Node book = test.getBookInfo(code);
                            if (book != null) {
                                System.out.print("Enter new title : ");
                                title = s.nextLine();
                                System.out.print("Enter new price : ");
                                price = s.nextLine();
                                System.out.print("Enter new author : ");
                                author = s.nextLine();
                                System.out.print("Enter new edition : ");
                                edition = s.nextLine();

                                Node book1 = test.getBook(code, title, price, author, edition);
                                test.updateXML(book1);
                                System.out.println("Book info updated!");
                            } else {
                                System.out.println("Book not found");
                            }
                            break;

                        case 4:
                            String nodeName;
                            String nodeValue;
                            System.out.print("Enter new node name : ");
                            nodeName = s.nextLine();
                            System.out.print("Enter new node value : ");
                            nodeValue = s.nextLine();

                            if (test.addNode(nodeName, nodeValue)) {
                                System.out.print("Add node success .");
                            } else {
                                System.out.print("Add node failed, node existed .");
                            }

                            break;
                        case 5:
                            String nodeName2;
                            System.out.print("Enter new node name : ");
                            nodeName2 = s.nextLine();

                            if (test.removeNode(nodeName2)) {
                                System.out.print("Delete node success .");
                            } else {
                                System.out.print("Delete node failed, node is not existed .");
                            }

                            break;
                        case 6:
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Enter a number again!");
                    }
                } else {
                    System.out.println("Please enter a number!");
                }
            } while (!isNum);

            System.out.print("Continue (Y/N) ? ");
            ans = s.nextLine();
        } while (ans.equalsIgnoreCase(
                "y"));

    }

}
