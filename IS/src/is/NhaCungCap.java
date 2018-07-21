/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is;

import java.util.ArrayList;

/**
 *
 * @author QQ
 */
public class NhaCungCap {
    String MaNhaCungCap;
    String TenNhaCungCap;
    String DiaChi;
    String DienThoai;
    String Fax;
    String Email;
    ArrayList<HangHoa> HangHoa;

    public NhaCungCap() {
    }

    public NhaCungCap(String MaNhaCungCap, String TenNhaCungCap, String DiaChi, String DienThoai, String Fax, String Email, ArrayList<HangHoa> HangHoa) {
        this.MaNhaCungCap = MaNhaCungCap;
        this.TenNhaCungCap = TenNhaCungCap;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.Fax = Fax;
        this.Email = Email;
        this.HangHoa=HangHoa;
    }
    
    
}
