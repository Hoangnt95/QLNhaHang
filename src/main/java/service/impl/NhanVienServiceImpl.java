/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.NhanVienCustom;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.NhanVienRepositoryImpl;
import service.ICommonService;
import util.Validate;

/**
 *
 * @author admin
 */
public class NhanVienServiceImpl implements ICommonService<NhanVienCustom> {

    private NhanVienRepositoryImpl repo;
    private List<NhanVienCustom> list;

    public NhanVienServiceImpl() {
        repo = new NhanVienRepositoryImpl();
        list = new ArrayList<>();
    }

    @Override
    public List<NhanVienCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(NhanVienCustom t) {
        String mess = "";
        int check = 0;
        if (t.getMaNV().isEmpty()) {
            mess = "Ma NV khong duoc bo trong";
            check++;
        } else if (!(t.getMaNV().matches(Validate.checkMaNV))) {
            mess = "Ma NV khong dung dinh dang";
            check++;
        }
        if (t.getHoTenNV().isEmpty()) {
            mess = "Ho ten khong duoc bo trong";
            check++;
        } else if ((!t.getHoTenNV().matches(Validate.checkString))) {
            mess = "Ho ten nhap vao chi la chu";
            check++;
        }
        if (t.getSdt().isEmpty()) {
            mess = "Sdt khong duoc bo trong";
            check++;
        } else if ((!t.getSdt().matches(Validate.checkSdt))) {
            mess = "Sdt khong dung dinh dang";
            check++;
        }
        if (check == 0) {
            if (this.repo.addOrUpdate(new NhanVien(t.getId(), t.getMaNV(), t.getHoTenNV(),
                    t.getGioiTinh(), t.getDiaChi(), t.getThanhPho(), t.getSdt(),
                    t.getEmail(), t.getNgaySinh(), t.getMatKhau(), t.isVaiTro(), t.getTrangThai()))) {
                mess = "Thanh cong";
            } else {
                mess = "That bai";
            }
        }

        return mess;
    }

    public NhanVienCustom checkLogin(String user, String pass) {
        NhanVienCustom nhanVien = this.repo.getNhanVien(user, pass);
        if (nhanVien == null) {
            nhanVien = null;
        }
        return nhanVien;
    }

}
