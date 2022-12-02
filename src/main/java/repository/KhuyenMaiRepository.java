/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.KhuyenMai;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.InterfaceKhuyenMai;
import util.HibernateUtil;

/**
 *
 * @author antao
 */
public class KhuyenMaiRepository implements InterfaceKhuyenMai{

    @Override
    public List<KhuyenMai> getAll() {
        Transaction trans = null;
        List<KhuyenMai> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            lists = session.createQuery("FROM KhuyenMai").getResultList();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public KhuyenMai create(KhuyenMai khuyenMai) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            session.save(khuyenMai);
            trans.commit();
            return khuyenMai;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public KhuyenMai update(KhuyenMai khuyenMai) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            session.update(khuyenMai);
            trans.commit();
            return khuyenMai;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public KhuyenMai findById(int id) {
        Transaction trans = null;
        KhuyenMai khuyenMai = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            khuyenMai = session.get(KhuyenMai.class, id);
            trans.commit();
            return khuyenMai;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public KhuyenMai remove(int id) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            KhuyenMai khuyenMai = session.get(KhuyenMai.class, id);
            if(khuyenMai != null){
                session.delete(khuyenMai);
                System.out.println("deleted nhan vien");
            }
            trans.commit();
            return khuyenMai;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    
    
}
