/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import custom.BanCustom;
import custom.KhuVucCustom;
import entity.Ban;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.KhuVuc;
import entity.KhuyenMai;
import entity.MonAn;
import java.awt.Color;
import static java.awt.Frame.DEFAULT_CURSOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import service.impl.BanServiceImpl;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.KhuVucServiceImpl;

/**
 *
 * @author ngocKhanh
 */
public class GopBan extends javax.swing.JDialog {

    private BanServiceImpl bandao;
    KhuVucServiceImpl kvdao;
    DonHangServiceImpl dhdao;
    DonHangChiTietServiceImpl dhctdao;
    public static TestDonHang dh;
    KhuyenMai km;
    String MaBan;
    int idDH;
    JPanel jps;
    List<Ban> arrBan;
    List<KhuVuc> khuvucList;
    List<JPanel> listjp = new ArrayList<JPanel>();
    List<Ban> ban;

    public GopBan(java.awt.Frame parent, boolean modal, String maban, KhuyenMai khuyenmai, int iddh) {
        super(parent, modal);
        initComponents();
        MaBan = maban;
        km = khuyenmai;
        idDH = iddh;
        bandao = new BanServiceImpl();
        kvdao = new KhuVucServiceImpl();
        dhdao = new DonHangServiceImpl();
        dhctdao = new DonHangChiTietServiceImpl();
        load();
    }

    void load() {
        khuvucList = kvdao.getLists();
        List<String> abc = new ArrayList<>();
        //  List<Ban> listban = bandao.getLists();
        List<BanCustom> arrBan = bandao.getkhuvuc(1);
        for (KhuVuc nv : khuvucList) {
            jps = new JPanel();
            jps.setSize(362, DEFAULT_CURSOR);
            jps.setName(nv.getTenKV());
            listjp.add(jps);
            abc.add(nv.getTenKV());

        }
        for (int a = 0; a < listjp.size(); a++) {
            tab.add(listjp.get(a));
            tab.repaint();
        }
        FillBan(arrBan);
    }

    public void FillBan(List<BanCustom> arrBan) {
        //  arrBan = bandao.getLists();
        if (arrBan != null) {
            jpBan.removeAll();
            //jptang2.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for (int i = 0; i < arrBan.size(); i++) {
                btn[i] = new JButton();
                String name = String.valueOf(arrBan.get(i).getMaBan());
                btn[i].setName(name);
                //btn[i].setSize(50,50);
                String[] mb = arrBan.get(i).getMaBan().split(" ");
                btn[i].setText(mb[0]);
                // btn[i].setIcon(new javax.swing.ImageIcon("D:\\DuAnMau\\BaiTap\\TestCalender\\src\\icons\\icons8-bill.png"));
//                Border thickBorder = new LineBorder(Color.WHITE,8);
//                btn[i].setBorder(thickBorder);
                btn[i].setBackground(Color.decode("#8080ff"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
                if (arrBan.get(i).getTrangThai() == 1) {
                    btn[i].setBackground(Color.decode("#66ff66"));
                    btn[i].setIcon(new javax.swing.ImageIcon("C:\\DuAn1\\QLNhaHang\\image\\iconApp\\ico-Table.png"));
                }
                if (arrBan.get(i).getTrangThai() == 0) {
                    btn[i].setBackground(Color.decode("#8080ff"));
                    btn[i].setIcon(new javax.swing.ImageIcon("C:\\DuAn1\\QLNhaHang\\image\\iconApp\\ico-Table.png"));
                }
                if (arrBan.get(i).getTrangThai() == 2) {
                    btn[i].setBackground(Color.decode("#ff6699"));
                    btn[i].setIcon(new javax.swing.ImageIcon("C:\\DuAn1\\QLNhaHang\\image\\iconApp\\ico-Table.png"));
                }
//               // btn[i].setPreferredSize(new Dimension(80, 60));
//               
                btn[i].addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {

                        System.out.println(e.getComponent().getName());
                        //ban = bandao.Getban(e.getComponent().getName());
                        lblMaBan.setText(e.getComponent().getName());
                        int xacNhan = JOptionPane.showConfirmDialog(e.getComponent(), "Bạn có muốn gộp với bàn" + " " + e.getComponent().getName());
                        if (xacNhan == JOptionPane.YES_OPTION) {
                            Ban b = getBan();
                            taoDonHangTam();

                            b.setTrangThai(1);
                            b.setMaBan(b.getMaBan());
                            String udate = bandao.UpdateBan(b);
                            //gopBan();
                            gop(e.getComponent().getName());
                            DonHang dh = dhdao.findById(idDH);
                            String xoa = dhdao.deleteDHTamThoi(dh.getMaDH());

                            Ban ban = bandao.getIDbyMa(MaBan);
                            KhuVuc kv = ban.getIdKhuVuc();
                            TestDonHang.dh.FillBan(bandao.getkhuvuc(kv.getId()));
                            JpGoiMon1.gm.removeAll();
                            TestDonHang.dh.fillLb();
                            // deleteDHCu(dh.getMaDH());
                           dispose();
                           //System.exit(0);
                        }
                       
                    }
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();

            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tab = new javax.swing.JTabbedPane();
        jpBan = new javax.swing.JPanel();
        lblMaBan = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gộp bàn"));

        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\Dang xuat.png")); // NOI18N
        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(lblMaBan)
                        .addGap(127, 127, 127)
                        .addComponent(btnHuy))
                    .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuy)
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaBan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBan, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        // TODO add your handling code here:
        int a = tab.getSelectedIndex();
        String tenkv = tab.getTitleAt(a);
        KhuVuc kv = kvdao.getByTen(tenkv);

        List<BanCustom> arrBan = bandao.getkhuvuc(kv.getId());
        FillBan(arrBan);
    }//GEN-LAST:event_tabMouseClicked
    public Ban getBan() {
        int a = tab.getSelectedIndex();
        String tenkv = tab.getTitleAt(a);
        return bandao.getBanByKV(lblMaBan.getText(), tenkv);
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed
    // tạo hoá đơn tạm

    public void taoDonHangTam() {
        List<DonHang> list = dhdao.getLists();
        Ban ban = bandao.getIDbyMa(lblMaBan.getText());
        DonHang donhang = dhdao.getDHbyMa(lblMaBan.getText());
        System.out.println(donhang);
        if (donhang == null) {
            System.out.println("aaa");
            int so = list.size();
            int so1 = so + 1;
            String AUTOMAHD = "DH".concat(String.valueOf(so1));
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            DonHang dh = new DonHang();
            dh.setMaDH(AUTOMAHD);
            dh.setIdKhuyenMai(km);
            dh.setIdBan(ban);
            dh.setNgayTao(date);
            dhdao.insert(dh);
        }
    }

    // xoá đơn hàng cũ
    //cap nhat trang thai ban
//    public String updateTrangThaiBan(String maBanGopVao) {
//       return bandao.UpdateTrangThaibanGop(maBanGopVao);
//    }
    // insert dhct moi vao ban gop
    public void gopBan() {
        //Ban b = bandao.getIDbyMa(MaBan);
        List<DonHangChiTiet> list = dhctdao.getListByIDDH(idDH);
        DonHang dh = dhdao.getDHbyMa(lblMaBan.getText());
        for (DonHangChiTiet x : list) {
            x.setIdDonHang(dh);
            dhctdao.insert(x);
        }
        Ban ban = bandao.getIDbyMa(MaBan);
        ban.setTrangThai(0);
        bandao.UpdateBan(ban);

    }
    public void gop(String maban){
         List<DonHangChiTiet> list = dhctdao.getListByIDDH(idDH);
         for (int i = 0; i < list.size(); i++) {
            //DonHang dh = dhdao.findById(idDH);
            DonHang dh = dhdao.getDH(maban);
            //MonAn ma = tddao.getIdByTenMon((String) model.getValueAt(r, 2));
            MonAn ma = list.get(i).getIdMonAn();
                List<DonHangChiTiet> listdhct = dhctdao.getDHCT(dh.getId(), ma.getId());
                if(listdhct.size()==0){
                    DonHangChiTiet up = new DonHangChiTiet();
                    up.setIdDonHang(list.get(i).getIdDonHang());
                    up.setIdMonAn(list.get(i).getIdMonAn());
                    up.setSoLuong(list.get(i).getSoLuong());
                    up.setDonGia(list.get(i).getDonGia());
                    
                    String insert = dhctdao.insert(up);
                }else{
                    //JOptionPane.showMessageDialog(this, "Khanh");
                    for (DonHangChiTiet dhct : listdhct) {
                        DonHangChiTiet up2 = new DonHangChiTiet();
                        up2.setId(dhct.getId());
                        up2.setIdDonHang(dhct.getIdDonHang());
                        up2.setIdMonAn(dhct.getIdMonAn());
                        up2.setSoLuong(dhct.getSoLuong()+list.get(i).getSoLuong());
                        up2.setDonGia(dhct.getDonGia());
                        dhctdao.UpdateChiTiet(up2);
                    }
                }
        }
          Ban ban = bandao.getIDbyMa(MaBan);
        ban.setTrangThai(0);
        bandao.UpdateBan(ban);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GopBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GopBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GopBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GopBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                GopBan dialog = new GopBan(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                GopBan dialog = new GopBan(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpBan;
    private javax.swing.JLabel lblMaBan;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
