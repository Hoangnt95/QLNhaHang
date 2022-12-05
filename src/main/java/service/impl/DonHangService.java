/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.donHangCustom;
import entity.DonHang;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DonHangRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class DonHangService implements ICommonService<DonHang> {

    private DonHangRepository repo;

    public DonHangService() {
        this.repo = new DonHangRepository();
    }

    @Override
    public List<DonHang> getLists() {
        return repo.getAll();
    }

    @Override
    public List<DonHang> search(String key) {
        return repo.searchByKey(key);
    }

    @Override
    public String addOrUpdate(DonHang t) {
        if (repo.addOrUpdate(t)) {
            return "Thanh cong";
        }else if(t.getId() == 0){
            return "bbbb";
        }
        return "That bai";
    }

    @Override
    public String delete(DonHang t) {
        if (repo.delete(t)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public DonHang getOne(String ma) {
        return (DonHang) this.repo.getOne(ma);
    }
    
    public donHangCustom getByBan(int ban){
        return this.repo.getByBan(ban);
    }

}
