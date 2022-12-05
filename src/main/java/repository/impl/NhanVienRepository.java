
package repository.impl;

import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class NhanVienRepository implements ICommonRepository<NhanVien>{

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM NhanVien");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public boolean addOrUpdate(NhanVien t) {
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
    public boolean delete(NhanVien t) {
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
    public List<NhanVien> searchByKey(String key) {
        List<NhanVien> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("SELECT a FROM NhanVien a WHERE "
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
    public NhanVien getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
