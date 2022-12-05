/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import entity.HoaDon;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.HoaDonRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class HoaDonService implements ICommonService<HoaDon> {

    private ICommonRepository repo;

    public HoaDonService() {
        this.repo = new HoaDonRepository();
    }

    @Override
    public List<HoaDon> getLists() {
        return repo.getAll();
    }

    @Override
    public List<HoaDon> search(String key) {
        return repo.searchByKey(key);
    }

    @Override
    public String addOrUpdate(HoaDon t) {
        if (repo.addOrUpdate(t)) {
            return "Thanh cong";
        }else if(t.getId() == 0){
            return "bbbb";
        }
        return "That bai";
    }

    @Override
    public String delete(HoaDon t) {
        if (repo.delete(t)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public HoaDon getOne(String ma) {
        return (HoaDon) this.repo.getOne(ma);
    }

}
