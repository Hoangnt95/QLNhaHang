/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import entity.Ban;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class BanService implements ICommonService<Ban> {

    private ICommonRepository repo;

    public BanService() {
        this.repo = new BanRepository();
    }

    @Override
    public List<Ban> getLists() {
        return repo.getAll();
    }

    @Override
    public List<Ban> search(String key) {
        return repo.searchByKey(key);
    }

    @Override
    public String addOrUpdate(Ban t) {
        if (repo.addOrUpdate(t)) {
            return "Thanh cong";
        }else if(t.getId() == 0){
            return "bbbb";
        }
        return "That bai";
    }

    @Override
    public String delete(Ban t) {
        if (repo.delete(t)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public Ban getOne(String ma) {
        return (Ban) this.repo.getOne(ma);
    }

}
