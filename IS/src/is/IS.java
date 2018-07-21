/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class IS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        QuanLy quanly = new QuanLy();
        Scanner s = new Scanner(System.in);
        String a;
        int choose;

        System.out.println("----------------------");
        System.out.println("1. Xem cua hang");
        System.out.println("2. Them cua hang");
        System.out.println("3. Sua cua hang");
        System.out.println("4. Xoa cua hang");
        System.out.println("5. Xem hang hoa");
        System.out.println("6. Them hang hoa");
        System.out.println("7. Sua hang hoa");
        System.out.println("8. Xoa hang hoa");
        System.out.println("9. Exit");
        System.out.println("----------------------");
        String temp;
        boolean isNum;
        do {
            do {
                System.out.print("Enter your number: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if (isNum) {
                    choose = Integer.parseInt(temp);
                    switch (choose) {
                        case 1:
                            quanly.XemCuaHang();
                            break;
                        case 2:
                            quanly.ThemCuaHang();
                            break;
                        case 3:
                            System.out.print("Nhap ma nha cung cap: ");
                            String maNCC = s.nextLine();
                            quanly.SuaCuaHang(maNCC);
                            break;
                        case 4:
                            System.out.println("Nhap ma nha cung cap: ");
                            String maNCC1 = s.nextLine();
                            quanly.XoaCuaHang(maNCC1);
                            break;
                        case 5:
                            quanly.XemHangHoa();
                            break;
                        case 6:
                            quanly.ThemHangHoa();
                            break;
                        case 7:
                            quanly.SuaHangHoa();
                            break;
                        case 8:
                            quanly.XoaHangHoa();
                            break;
                        case 9:
                            System.exit(0);
                        default:
                            System.out.println("Invalid number");
                            break;
                    }
                } else {
                    System.out.println("Please enter a number!");

                }

            } while (!isNum);
            System.out.println("Continue ? (Y/N) ");
            a = s.nextLine();
        } while (a.equalsIgnoreCase("y"));
    }

}
