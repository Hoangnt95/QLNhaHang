/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.BanCustom;
import custom.KhuyenMaiCustom;
import custom.MonAnCustom;
import entity.Ban;
import entity.KhuyenMai;
import entity.MonAn;
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
public class MonAnRepositoryImpl implements ICommonRepository<MonAn, MonAnCustom> {

    @Override
    public boolean addOrUpdate(MonAn t) {
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
    public List<MonAnCustom> findByKey(String key) {
        List<MonAnCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.MonAnCustom(a.id, a.maMon, "
                    + "a.tenMon, a.donViTinh, a,hinhAnh, a.donGia, a.ghiChu, a.trangThai, a.idDanhMuc.id) FROM KhuyenMai a"
                    + " WHERE a.maMon LIKE CONCAT('%',:ma,'%')";
            TypedQuery<MonAnCustom> query = session.createQuery(hql, MonAnCustom.class);
            query.setParameter("ma", key);
            list = query.getResultList();
        }
        return list;
    }

    public List<MonAn> getAll() {
        List<MonAn> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            javax.persistence.Query query = session.createQuery("From MonAn");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    @Override
    public MonAn findById(int id) {
        MonAn monAn = new MonAn();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM MonAn a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            monAn = (MonAn) query.getSingleResult();
        }
        return monAn;
    }

    public MonAn getIdByMa(String key) {
        MonAn td = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM MonAn a WHERE a.maMon = : ma";
            TypedQuery<MonAn> query = session.createQuery(hql, MonAn.class);
            query.setParameter("ma", key);

            td = query.getSingleResult();
        }
        return td;
    }
    public List<MonAn> GetThucDon(String key) {
      List<MonAn> result = null;
      try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from MonAn a where a.danhMuc.maLoai = : ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", key);
            result = query.getResultList();
        }
      
        return result;
        }
    public List<MonAn> TimKiem(String key){
        List<MonAn> result = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM MonAn a WHERE a.tenMon like concat('%',:tenmon,'%')";
            TypedQuery<MonAn> query = session.createQuery(hql, MonAn.class);
            query.setParameter("tenmon", key);
            
            result= query.getResultList();
        }
        return result;
    }
    public MonAn getIdBytenMon(String key){
         MonAn td = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM MonAn a WHERE a.tenMon = : ten";
            TypedQuery<MonAn> query = session.createQuery(hql, MonAn.class);
            query.setParameter("ten", key);
            
            td=  query.getSingleResult();
        }
        return td;
     }
}
