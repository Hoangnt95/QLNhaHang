/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import ViewModel.KhuyenMaiView;
import java.util.List;

/**
 *
 * @author antao
 */
public interface IServiceKhuyenMai {
    List<KhuyenMaiView> getAll();
    
    KhuyenMaiView findById(int id);
    
    KhuyenMaiView remove(int id);
}
