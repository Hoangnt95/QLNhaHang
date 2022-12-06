/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.BanCustom;
import entity.Ban;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class BanRepositoryImpl implements ICommonRepository<Ban, BanCustom> {

    @Override
    public boolean addOrUpdate(Ban t) {
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

    public BanCustom Getban(String ma) {
        BanCustom result = new BanCustom();
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            hql = "select new custom.BanCustom(a.id, a.maBan, a.soLuongChoNgoi,"
                    + "a.trangThai,a.idKhuVuc.id) from Ban a WHERE a.maBan = :maban";
            Query query = session.createQuery(hql);
            query.setParameter("maban", ma);
            result = (BanCustom) query.getSingleResult();
        }

        return result;
    }

    @Override
    public List<BanCustom> findByKey(String key) {
        List<BanCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a"
                    + " WHERE a.maBan LIKE CONCAT('%',:ma,'%')";
            TypedQuery<BanCustom> query = session.createQuery(hql, BanCustom.class);
            query.setParameter("ma", key);
            list = query.getResultList();
        }
        return list;
    }

    public List<BanCustom> getkhuvuc(int idkv) {
        List<BanCustom> result = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a"
                    + " WHERE a.idKhuVuc.id = :idkv";
            Query query = session.createQuery(hql);
            query.setParameter("idkv", idkv);
            result = query.getResultList();
        }

        return result;
    }

    public List<Ban> getAll() {
        List<Ban> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("From Ban");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    @Override
    public Ban findById(int id) {
        Ban ban = new Ban();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM Ban a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            ban = (Ban) query.getSingleResult();
        }
        return ban;
    }

    public boolean UpdateBan(Ban ban) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE Ban SET trangThai =:tt  WHERE maBan = :maban";
            Query query = session.createQuery(hql);
            query.setParameter("tt", ban.getTrangThai());
            query.setParameter("maban", ban.getMaBan());
            if (query.executeUpdate() < 1) {
                return false;
            }
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Ban getIDbyMa(String maBan) {
        Ban ban = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from Ban a WHERE a.maBan = :maBan ";
            TypedQuery<Ban> query = session.createQuery(hql, Ban.class);
            query.setParameter("maBan", maBan);

            ban = query.getSingleResult();
            return ban;
        } catch (Exception e) {
            return null;
        }

    }

    public Ban getBanByKV(String maban, String tenkv) {
        Ban ban = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from Ban a WHERE a.maBan = :maBan and a.idKhuVuc.tenKV =: tenkv";
            TypedQuery<Ban> query = session.createQuery(hql, Ban.class);
            query.setParameter("maBan", maban);
            query.setParameter("tenkv", tenkv);
            ban = query.getSingleResult();
        }
        return ban;
    }

    public List<BanCustom> GetbanByTrangThai(int tt) {
        List<BanCustom> result = null;
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {

            hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a WHERE a.trangThai = :tt";
            //String hql = "select a from Ban a WHERE a.id = :id ";
            Query query = session.createQuery(hql);
            query.setParameter("tt", tt);
            //  query.setParameter("tt", 0);             
            result = query.getResultList();
        }

        return result;
    }
}
