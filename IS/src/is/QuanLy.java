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
public class QuanLy {

    ArrayList<NhaCungCap> list = new ArrayList<>();
    ArrayList<HangHoa> list2 = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public void XemCuaHang() {
        if (!list.isEmpty()) {
            for (NhaCungCap item : list) {
                System.out.println("Ma Nha Cung Cap: " + item.MaNhaCungCap);
                System.out.println("Ten Nha Cung Cap: " + item.TenNhaCungCap);
                System.out.println("Dia Chi: " + item.DiaChi);
                System.out.println("Dien Thoai: " + item.DienThoai);
                System.out.println("Fax: " + item.Fax);
                System.out.println("Email: " + item.Email);

            }
        } else {
            System.out.println("Khong co nha cung cap nao");
        }

    }

    public void ThemCuaHang() {
        NhaCungCap newNCC = new NhaCungCap();

        System.out.print("Ma Nha Cung Cap: ");
        newNCC.MaNhaCungCap = s.nextLine();
        System.out.print("Ten Nha Cung Cap: ");
        newNCC.TenNhaCungCap = s.nextLine();
        System.out.print("Dia Chi: ");
        newNCC.DiaChi = s.nextLine();
        System.out.print("Dien Thoai: ");
        newNCC.DienThoai = s.nextLine();
        System.out.print("Fax: ");
        newNCC.Fax = s.nextLine();
        System.out.print("Email: ");
        newNCC.Email = s.nextLine();

        list.add(newNCC);
        System.out.println("Them nha cung cap thanh cong");

    }

    public void SuaCuaHang(String MaNhaCungCap) {
        int index = -1;
        if (!list.isEmpty()) {
            for (NhaCungCap item : list) {
                if (item.MaNhaCungCap.equals(MaNhaCungCap)) {
                    index = list.indexOf(item);
                }
            }

            if (index != -1) {
                System.out.println("Ma nha cung cap hop le!");
                System.out.println("Nhap ten nha cung cap moi: ");
                list.get(index).TenNhaCungCap = s.nextLine();
                System.out.println("Sua ten thanh cong");
            } else {
                System.out.println("Ma nha cung cap khong hop le!");
            }

        } else {
            System.out.println("Khong co nha cung cap nao");
        }

    }

    public void XoaCuaHang(String MaNhaCungCap) {
        int index = -1;
        if (!list.isEmpty()) {
            for (NhaCungCap item : list) {
                if (item.MaNhaCungCap.equals(MaNhaCungCap)) {
                    index = list.indexOf(item);
                }
            }
            if (index != -1) {
                System.out.println("Ma nha cung cap hop le!");
                System.out.println("Xac nhan xoa nha cung cap ? (Y/N)");
                String ans = s.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    list.remove(index);
                    System.out.println("Xoa nha cung cap thanh cong");
                }
            } else {
                System.out.println("Ma nha cung cap khong hop le!");
            }

        } else {
            System.out.println("Khong co nha cung cap nao");
        }

    }

    public void XemHangHoa() {
        if (!list2.isEmpty()) {
            for (HangHoa item : list2) {
                System.out.println("Ma Hang: " + item.MaHang);
                System.out.println("Ten Hang: " + item.TenHang);
                System.out.println("Gia: " + item.Gia);
                System.out.println("Nha Cung Cap: " + item.NhaCungCap);
            }
        } else {
            System.out.println("Khong co hang hoa nao");
        }
    }

    public void ThemHangHoa() {
        HangHoa newHH = new HangHoa();

        System.out.print("Ma Hang: ");
        newHH.MaHang = s.nextLine();
        System.out.print("Ten Hang: ");
        newHH.TenHang = s.nextLine();
        System.out.print("Gia: ");
        newHH.Gia = s.nextLine();

        System.out.print("Nhap Ten Nha Cung Cap: ");
        String tenNCC = s.nextLine();
        if (checkNCCHopLe(tenNCC) != null) {
            System.out.println("Nha cung cap hop le");
            newHH.NhaCungCap = checkNCCHopLe(tenNCC);
            list2.add(newHH);
            System.out.println("Them hang hoa thanh cong");
        } else {
            System.out.println("Nha cung cap khong hop le");
        }

    }

    public void SuaHangHoa() {

    }

    public void XoaHangHoa() {

    }

    public NhaCungCap checkNCCHopLe(String tenNCC) {
        for (NhaCungCap item : list) {
            if (tenNCC.equals(item.TenNhaCungCap)) {
                return item;
            } else {
                return null;
            }
        }
        return null;
    }
}
