/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienCustom {
    
    private int id;
    
    private String maNV;
    
    private String matKhau;
    
    private String email;
    
    private int gioiTinh;
    
    private String hoTenNV;
    
    private Date ngaySinh;
    
    private String sdt;
    
    private String diaChi;
    
    private String thanhPho;
    
    private int trangThai;
    
    private boolean vaiTro;
    
    public String VaiTroToString(){
        return vaiTro==true?"Quản lý":"Nhân viên";
    }
    
    public String TrangThaiToString(){
        if (trangThai ==  0) {
            return "Full time";
        }else if (trangThai == 1) {
            return "Part time";
        }
        return "Đã nghỉ việc";
    }
        
    public Object[] toRowData(){
        return new Object[]{id,maNV,matKhau,email,gioiTinh==0?"Nam":"Nữ",hoTenNV,ngaySinh,sdt
            ,diaChi,thanhPho,VaiTroToString(),TrangThaiToString()};
    }
    
}
