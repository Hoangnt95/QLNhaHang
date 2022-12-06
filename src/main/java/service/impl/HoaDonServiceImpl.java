/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.BanCustom;
import custom.HDBanhang;
import custom.HoaDonCustom;
import custom.KhuyenMaiCustom;
import entity.Ban;
import entity.DonHang;
import entity.HoaDon;
import entity.KhuVuc;
import entity.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.DonHangRepositoryImpl;
import repository.impl.HoaDonRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class HoaDonServiceImpl implements ICommonService<HoaDonCustom> {

    private HoaDonRepositoryImpl repo;
    private DonHangRepositoryImpl repoDonHang;

    public HoaDonServiceImpl() {
        repo = new HoaDonRepositoryImpl();
    }

    @Override
    public List<HoaDonCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(HoaDonCustom t) {
        String mess = "";
        DonHang donHang = repoDonHang.findById(t.getIdDonHang());
        if (this.repo.addOrUpdate(new HoaDon(t.getId(), t.getMaHD(), t.getNgayTao()
                , t.getNgayThanhToan(), t.getTrangThai(), t.getGhiChu(), donHang))) {
            mess  ="Thanh cong";
        }else{
            mess = "That bai";
        }
        return mess;
    }
     public String UpdateTrangThaiban(HoaDon hd){
        
        if (!repo.UpdateTrangThaiban(hd)) {
            return "That bai";
        }
        return "Thanh cong";
       }
    public List<HoaDon> getAll(){
        return this.repo.getAll();
    }

    public List<HDBanhang> getListHDCustom(String ma) {
        return this.repo.getListHDCustom(ma);
    }
    public List<HoaDon> getHDByMaDH(String madh){
         return this.repo.getHDByMaDH(madh);
     }
    public HoaDon getIDByMaHD(String mahd){
          return this.repo.getIDByMaHD(mahd);
    }
    public String insert(HoaDon hd){
       if (!this.repo.addOrUpdate(hd)) {
            return "That bai";
        }
        return "Thanh cong";
    }
    public HoaDon getByMaDH(String madh){
        return this.repo.getByMaDH(madh);
    }
}
