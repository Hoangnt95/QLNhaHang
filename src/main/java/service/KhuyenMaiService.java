/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.KhuyenMaiView;
import ViewModel.NhanVienView;
import entity.KhuyenMai;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.InterfaceKhuyenMai;
import repository.InterfaceNhanVien;
import repository.KhuyenMaiRepository;
import repository.NhanVienRepository;
import service.IServiceKhuyenMai;

/**
 *
 * @author antao
 */
public class KhuyenMaiService implements IServiceKhuyenMai{
    InterfaceKhuyenMai daokm;
    List<KhuyenMaiView> listKMModel;
    private KhuyenMaiRepository _dao;
    
    public KhuyenMaiService(){
        daokm = new KhuyenMaiRepository();
        _dao  = new KhuyenMaiRepository();
        getlst();
        
    }
    
    public List<KhuyenMai> getlst(){
        return _dao.getAll();
    }

    @Override
    public List<KhuyenMaiView> getAll() {
        List<KhuyenMaiView> list =  new ArrayList();
         for(KhuyenMai x : daokm.getAll()){
             list.add(new KhuyenMaiView(x.getId(),x.getMaGiamGia(), x.getPhanTram(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getTrangThai()));        
         }
         return list;
    }
    
    public KhuyenMaiView create(KhuyenMaiView km){
        _dao.create(new KhuyenMai(
                    km.getMaGiamGia(), 
                    km.getPhanTram(),
                    km.getNgayBatDau(),
                    km.getNgayKetThuc(),
                    km.getTrangThai()));
        return new KhuyenMaiView(
                    km.getMaGiamGia(),
                    km.getPhanTram(),
                    km.getNgayBatDau(), 
                    km.getNgayKetThuc(), 
                    km.getTrangThai());
    }
    
    public KhuyenMaiView update(KhuyenMaiView km){
        _dao.create(new KhuyenMai(
                    km.getId(),
                    km.getMaGiamGia(), 
                    km.getPhanTram(),
                    km.getNgayBatDau(),
                    km.getNgayKetThuc(),
                    km.getTrangThai()));
        return new KhuyenMaiView(
                    km.getId(),
                    km.getMaGiamGia(),
                    km.getPhanTram(),
                    km.getNgayBatDau(), 
                    km.getNgayKetThuc(), 
                    km.getTrangThai());
    }
    @Override
    public KhuyenMaiView findById(int id) {
        var x = _dao.findById(id);
        return new KhuyenMaiView(
                    x.getId(), 
                    x.getMaGiamGia(), 
                    x.getPhanTram(), 
                    x.getNgayBatDau(),
                    x.getNgayKetThuc(), 
                    x.getTrangThai());
                   
    }
    

    @Override
    public KhuyenMaiView remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
