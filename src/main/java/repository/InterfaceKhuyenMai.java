/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entity.KhuyenMai;
import entity.NhanVien;
import java.util.List;

/**
 *
 * @author antao
 */
public interface InterfaceKhuyenMai {
    
    List<KhuyenMai> getAll();

    KhuyenMai create(KhuyenMai khuyenMai);

    KhuyenMai update(KhuyenMai khuyenMai);
    
    KhuyenMai findById(int id);
    
    KhuyenMai remove(int id);
}
