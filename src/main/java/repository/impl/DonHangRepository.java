package repository.impl;

import custom.donHangCustom;
import entity.Ban;
import entity.DonHang;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class DonHangRepository implements ICommonRepository<DonHang> {

    @Override
    public List<DonHang> getAll() {
        List<DonHang> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DonHang");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public boolean addOrUpdate(DonHang t) {
        boolean check = false;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.beginTransaction();
            try {
                session.saveOrUpdate(t);
                trans.commit();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }
        }
        return check;
    }

    @Override
    public boolean delete(DonHang t) {
        boolean check = false;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.beginTransaction();
            try {
                session.delete(t);
                trans.commit();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }
        }
        return check;
    }

    @Override
    public List<DonHang> searchByKey(String key) {
        List<DonHang> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT a FROM DonHang a WHERE "
                    + "a.maLoai LIKE CONCAT('%',:ma,'%') OR a.tenLoai LIKE CONCAT('%',:ten,'%')");
            query.setParameter("ma", key);
            query.setParameter("ten", key);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public DonHang findById(int id) {
        DonHang donHang = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM DonHang a WHERE a.id = :id";
            TypedQuery<DonHang> query = session.createQuery(hql, DonHang.class);
            query.setParameter("id", id);
            donHang = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donHang;
    }

    public donHangCustom getByBan(int ma) {
        donHangCustom donHang = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new custom.donHangCustom(a.id, a.maDH, a.ngayTao, a.trangThai, a.idBan.id, a.idNhanVien.id, a.idKhuyenMai.id\n"
                    + ") FROM DonHang a WHERE a.idBan.id = :ma";
            TypedQuery<donHangCustom> query = session.createQuery(hql, donHangCustom.class);
            query.setParameter("ma", ma);
            donHang = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donHang;
    }

    @Override
    public DonHang getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
