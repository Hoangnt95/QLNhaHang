/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author antao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienView {
    private int id;
    
    private String maNV;
    
    private String hotenNV;
    
    private int gioiTinh;
    
    private String diaChi;
    
    private String thanhPho;
    
    private String sdt;
    
    private String email;
    
    private Date ngaySinh;
    
    private String matKhau;
    
    private boolean vaiTro;
    
    private int trangThai;

    public NhanVienView(String maNV, String hotenNV, int gioiTinh, String diaChi, String thanhPho, String sdt, String email, Date ngaySinh, String matKhau, boolean vaiTro, int trangThai) {
        this.maNV = maNV;
        this.hotenNV = hotenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.sdt = sdt;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }
    
    
}
