/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.NhanVienView;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.InterfaceNhanVien;
import repository.NhanVienRepository;
import service.IServiceNhanVien;

/**
 *
 * @author antao
 */
public class NhanVienService implements IServiceNhanVien {

    InterfaceNhanVien daonv;
    List<NhanVienView> listNVModel;
    private NhanVienRepository _dao;

    public NhanVienService() {
        daonv = new NhanVienRepository();
        _dao = new NhanVienRepository();
        getlst();

    }

    public List<NhanVien> getlst() {
        return _dao.getAll();
    }

    @Override
    public List<NhanVienView> getAll() {
        List<NhanVienView> list = new ArrayList();
        for (NhanVien x : daonv.getAll()) {
            list.add(new NhanVienView(
                    x.getId(),
                    x.getMaNV(),
                    x.getHoTenNV(),
                    x.getGioiTinh(),
                    x.getDiaChi(),
                    x.getThanhPho(),
                    x.getSdt(),
                    x.getEmail(),
                    x.getNgaySinh(),
                    x.getMatKhau(),
                    x.isVaiTro(),
                    x.getTrangThai()));
        }
        return list;
    }

    public NhanVienView create(NhanVienView nv) {
        _dao.create(new NhanVien(
                nv.getMaNV(),
                nv.getHotenNV(),
                nv.getGioiTinh(),
                nv.getDiaChi(),
                nv.getThanhPho(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getNgaySinh(),
                nv.getMatKhau(),
                nv.isVaiTro(),
                nv.getTrangThai()));
        return new NhanVienView(
                nv.getMaNV(),
                nv.getHotenNV(),
                nv.getGioiTinh(),
                nv.getDiaChi(),
                nv.getThanhPho(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getNgaySinh(),
                nv.getMatKhau(),
                nv.isVaiTro(),
                nv.getTrangThai());
    }

    public NhanVienView update(NhanVienView nv) {
        _dao.create(new NhanVien(
                nv.getId(),
                nv.getMaNV(),
                nv.getHotenNV(),
                nv.getGioiTinh(),
                nv.getDiaChi(),
                nv.getThanhPho(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getNgaySinh(),
                nv.getMatKhau(),
                nv.isVaiTro(),
                nv.getTrangThai()));
        return new NhanVienView(
                nv.getId(),
                nv.getMaNV(),
                nv.getHotenNV(),
                nv.getGioiTinh(),
                nv.getDiaChi(),
                nv.getThanhPho(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getNgaySinh(),
                nv.getMatKhau(),
                nv.isVaiTro(),
                nv.getTrangThai());
    }

    @Override
    public NhanVienView findById(int id) {
        var x = _dao.findById(id);
        return new NhanVienView(
                x.getId(),
                x.getMaNV(),
                x.getHoTenNV(),
                x.getGioiTinh(),
                x.getDiaChi(),
                x.getThanhPho(),
                x.getSdt(),
                x.getEmail(),
                x.getNgaySinh(),
                x.getMatKhau(),
                x.isVaiTro(),
                x.getTrangThai());
    }

    @Override
    public NhanVienView remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
