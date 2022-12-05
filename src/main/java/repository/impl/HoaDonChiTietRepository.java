
package repository.impl;

import entity.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class HoaDonChiTietRepository implements ICommonRepository<HoaDonChiTiet>{

    @Override
    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM HoaDonChiTiet");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public boolean addOrUpdate(HoaDonChiTiet t) {
        boolean check = false;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction trans = session.beginTransaction();
            try{
                session.saveOrUpdate(t);
                trans.commit();
                check = true;
            }catch(Exception e){
                e.printStackTrace();
                trans.rollback();
            }
        }
        return check;
    }

    @Override
    public boolean delete(HoaDonChiTiet t) {
        boolean check = false;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction trans = session.beginTransaction();
            try{
                session.delete(t);
                trans.commit();
                check = true;
            }catch(Exception e){
                e.printStackTrace();
                trans.rollback();
            }
        }
        return check;
    }

    @Override
    public List<HoaDonChiTiet> searchByKey(String key) {
        List<HoaDonChiTiet> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("SELECT a FROM HoaDonChiTiet a WHERE "
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
    public HoaDonChiTiet getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
