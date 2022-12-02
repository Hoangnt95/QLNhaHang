/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.NhanVien;
import java.util.List;

/**
 *
 * @author antao
 */
public interface InterfaceNhanVien {
    
    List<NhanVien> getAll();

    NhanVien create(NhanVien nhanVien);

    NhanVien update(NhanVien nhanVien);
    
    NhanVien findById(int id);
    
    NhanVien remove(int id);
}
