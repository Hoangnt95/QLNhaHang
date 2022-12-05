/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import entity.NhanVien;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.NhanVienRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class NhanVienService implements ICommonService<NhanVien> {

    private ICommonRepository repo;

    public NhanVienService() {
        this.repo = new NhanVienRepository();
    }

    @Override
    public List<NhanVien> getLists() {
        return repo.getAll();
    }

    @Override
    public List<NhanVien> search(String key) {
        return repo.searchByKey(key);
    }

    @Override
    public String addOrUpdate(NhanVien t) {
        if (repo.addOrUpdate(t)) {
            return "Thanh cong";
        }else if(t.getId() == 0){
            return "bbbb";
        }
        return "That bai";
    }

    @Override
    public String delete(NhanVien t) {
        if (repo.delete(t)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public NhanVien getOne(String ma) {
        return (NhanVien) this.repo.getOne(ma);
    }

}
