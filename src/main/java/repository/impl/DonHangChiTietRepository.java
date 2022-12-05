
package repository.impl;

import custom.donHangChiTietCustom;
import entity.DonHangChiTiet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class DonHangChiTietRepository implements ICommonRepository<DonHangChiTiet>{

    @Override
    public List<DonHangChiTiet> getAll() {
        List<DonHangChiTiet> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM DonHangChiTiet");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public boolean addOrUpdate(DonHangChiTiet t) {
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
    public boolean delete(DonHangChiTiet t) {
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
    public List<DonHangChiTiet> searchByKey(String key) {
        List<DonHangChiTiet> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("SELECT a FROM DonHangChiTiet a WHERE "
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
    public DonHangChiTiet getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public donHangChiTietCustom getByHoaDon(int idHoaDon){
        donHangChiTietCustom donHangChiTiet = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new custom.donHangChiTietCustom(a.id, a.soLuong, a.donGia, a.idDonHang.id"
                    + ", a.idThucDon.id) FROM DonHangChiTiet a WHERE a.idDonHang.id = :idHoaDon";
            TypedQuery<donHangChiTietCustom> query = session.createQuery(hql, donHangChiTietCustom.class);
            query.setParameter("idHoaDon", idHoaDon);
            donHangChiTiet = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donHangChiTiet;
    }

}
