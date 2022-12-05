/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import entity.HoaDonChiTiet;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.HoaDonChiTietRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class HoaDonChiTietService implements ICommonService<HoaDonChiTiet> {

    private ICommonRepository repo;

    public HoaDonChiTietService() {
        this.repo = new HoaDonChiTietRepository();
    }

    @Override
    public List<HoaDonChiTiet> getLists() {
        return repo.getAll();
    }

    @Override
    public List<HoaDonChiTiet> search(String key) {
        return repo.searchByKey(key);
    }

    @Override
    public String addOrUpdate(HoaDonChiTiet t) {
        if (repo.addOrUpdate(t)) {
            return "Thanh cong";
        }else if(t.getId() == 0){
            return "bbbb";
        }
        return "That bai";
    }

    @Override
    public String delete(HoaDonChiTiet t) {
        if (repo.delete(t)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public HoaDonChiTiet getOne(String ma) {
        return (HoaDonChiTiet) this.repo.getOne(ma);
    }

}
