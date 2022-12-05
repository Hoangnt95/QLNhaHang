package repository.impl;

import entity.Ban;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class BanRepository implements ICommonRepository<Ban> {

    @Override
    public List<Ban> getAll() {
        List<Ban> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ban");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public boolean addOrUpdate(Ban t) {
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
    public boolean delete(Ban t) {
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
    public List<Ban> searchByKey(String key) {
        List<Ban> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT a FROM Ban a WHERE "
                    + "a.maLoai LIKE CONCAT('%',:ma,'%') OR a.tenLoai LIKE CONCAT('%',:ten,'%')");
            query.setParameter("ma", key);
            query.setParameter("ten", key);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public Ban getOne(String ma) {
        Ban ban = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM Ban a WHERE a.maBan = :ma";
            TypedQuery<Ban> query = session.createQuery(hql, Ban.class);
            query.setParameter("ma", ma);
            ban = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban;
    }

}
