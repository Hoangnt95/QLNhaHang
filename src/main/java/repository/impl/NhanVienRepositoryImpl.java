/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.NhanVienCustom;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class NhanVienRepositoryImpl implements ICommonRepository<NhanVien, NhanVienCustom> {

    @Override
    public boolean addOrUpdate(NhanVien t) {
        boolean check = false;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.saveOrUpdate(t);
                tran.commit();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                tran.rollback();
            }
        }
        return check;
    }

    @Override
    public List<NhanVienCustom> findByKey(String key) {
        List<NhanVienCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.maNV LIKE CONCAT('%',:ma,'%') OR a.hoTenNV LIKE CONCAT('%',:hoTen,'%')";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("ma", key);
            query.setParameter("hoTen", key);
            list = query.getResultList();
        }
        return list;
    }

    public List<NhanVienCustom> getNhanVienByUser(String user) {
        List<NhanVienCustom> nhanVien = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.maNV = :ma";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("ma", user);
            nhanVien = query.getResultList();
        }
        return nhanVien;
    }

    public NhanVienCustom getNhanVienByEmail(String email) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.email = :email";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("email", email);
            nhanVien = query.getSingleResult();
        }
        return nhanVien;
    }

    public NhanVienCustom getNhanVienByPassword(String pass) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.matKhau = :pass";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("pass", pass);
            nhanVien = query.getSingleResult();
        }
        return nhanVien;
    }
    
    @Override
    public NhanVien findById(int id) {
        NhanVien nhanVien = new NhanVien();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM NhanVien a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
        }
        return nhanVien;
    }
    
    public static void main(String[] args) {
        NhanVienCustom nhanVien = new NhanVienRepositoryImpl().getNhanVienByEmail("hoangnaa");
        if (nhanVien == null) {
            System.out.println("faild");
        }
        System.out.println(nhanVien);
    }

}
