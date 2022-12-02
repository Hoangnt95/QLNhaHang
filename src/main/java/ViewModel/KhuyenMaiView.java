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
public class KhuyenMaiView {
    private int id;
    
    private String maGiamGia;
    
    private int phanTram;
    
    private Date ngayBatDau;
    
    private Date ngayKetThuc;
    
    private int trangThai;

    public KhuyenMaiView(String maGiamGia, int phanTram, Date ngayBatDau, Date ngayKetThuc, int trangThai) {
        this.maGiamGia = maGiamGia;
        this.phanTram = phanTram;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    
    
}
