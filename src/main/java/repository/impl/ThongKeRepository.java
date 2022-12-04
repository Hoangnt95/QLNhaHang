/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author hieu
 */
public class ThongKeRepository {
    public BigDecimal TongTien2() {
        BigDecimal a =  new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong * H.DonGia) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n";
                    //+ "where MONTH(HD.ThoiGianTao) = MONTH(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
               a = (BigDecimal) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public long TongTien3() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (S.id) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n";
                    //+ "where MONTH(HD.ThoiGianTao) = MONTH(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
      public long TongTien4() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n";
                    //+ "where MONTH(HD.ThoiGianTao) = MONTH(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
        public long TongTien5() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n";
                    //+ "where MONTH(HD.ThoiGianTao) = MONTH(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}
