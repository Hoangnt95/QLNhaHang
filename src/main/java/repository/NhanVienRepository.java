/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DanhMuc;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.InterfaceNhanVien;
import util.HibernateUtil;

/**
 *
 * @author antao
 */
public class NhanVienRepository implements InterfaceNhanVien{

    @Override
    public List<NhanVien> getAll() {
        Transaction trans = null;
        List<NhanVien> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            lists = session.createQuery("FROM NhanVien").getResultList();
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
    public NhanVien create(NhanVien nhanVien) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            session.save(nhanVien);
            trans.commit();
            return nhanVien;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public NhanVien update(NhanVien nhanVien) {
        Transaction trans = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            session.update(nhanVien);
            trans.commit();
            return nhanVien;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public NhanVien findById(int id) {
       Transaction trans = null;
       NhanVien nhanVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            nhanVien = session.get(NhanVien.class, id);
            trans.commit();
            return nhanVien;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }  
    }

    @Override
    public NhanVien remove(int id) {
       Transaction trans = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            trans = session.beginTransaction();
            NhanVien nhanVien = session.get(NhanVien.class, id);
            if(nhanVien != null){
                session.delete(nhanVien);
                System.out.println("deleted nhan vien");
            }
            trans.commit();
            return nhanVien;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }    
}
