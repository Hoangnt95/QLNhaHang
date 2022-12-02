/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;


import ViewModel.NhanVienView;
import java.util.List;

/**
 *
 * @author antao
 */
public interface IServiceNhanVien {
    List<NhanVienView> getAll();
    
    NhanVienView findById(int id);
    
    NhanVienView remove(int id);
}
