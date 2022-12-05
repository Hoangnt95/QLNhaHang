/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import custom.BanCustom;
import custom.DHCTBanHangCustom;
import custom.DonHangChiTietCustom;
import custom.DonHangCustom;
import custom.MonAnCustom;
import entity.Ban;
import entity.DonHangChiTiet;
import entity.DonHang;
import entity.KhuVuc;
import entity.MonAn;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import service.impl.BanServiceImpl;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.KhuVucServiceImpl;
import service.impl.MonAnServiceImpl;

public class DLSoLuong extends javax.swing.JDialog {

    private DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
    private MonAnServiceImpl thucdondao = new MonAnServiceImpl();
    private DonHangServiceImpl donhangdao = new DonHangServiceImpl();
    private KhuVucServiceImpl kvdao = new KhuVucServiceImpl();
    private BanServiceImpl bandao = new BanServiceImpl();
    int sl = 0;
    MonAn arrThucDon;
    public String gioden, mamon, TenBan;
    public String maban;
    public int idban;
    DHCTBanHangCustom mon;
   

    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     * @param MaMon
     * @param tenban
     * @param MaBan
     */
    public DLSoLuong(java.awt.Frame parent, boolean modal, String MaMon, String tenban, String MaBan) {
        super(parent, modal);
        initComponents();
        mamon = MaMon;
        TenBan = tenban;
        maban = MaBan;
        //JOptionPane.showMessageDialog(this, MaMon);
        Fill();

          
        if (mon != null) {
            txtgia.setText(String.valueOf(mon.getDonGia()));
            txtSl.setText(String.valueOf(mon.getSoLuong()));
           // btngoi.setText("Cap Nhat");
        }

    }

    private void Fill() {
        arrThucDon = thucdondao.getIdByMa(mamon);
        txtSl.setText("1");
        lblban.setText(maban + " ");

        lblTenMon.setText(arrThucDon.getTenMon());
        lblDVT.setText(arrThucDon.getDonViTinh());
        txtgia.setText(String.valueOf(arrThucDon.getDonGia()));
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
        lblTenMon = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        txtSl = new javax.swing.JTextField();
        btngoi = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btntru = new javax.swing.JButton();
        btncong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblban = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(140, 140, 6));
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));

        lblTenMon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTenMon.setForeground(new java.awt.Color(51, 0, 0));
        lblTenMon.setText("Món");

        txtSl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSlActionPerformed(evt);
            }
        });
        txtSl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSlKeyReleased(evt);
            }
        });

        btngoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btngoi.setText("Đồng ý");
        btngoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngoiActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btntru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntruActionPerformed(evt);
            }
        });

        btncong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncongActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Số lượng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Giá:");

        lblban.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblban.setForeground(new java.awt.Color(0, 51, 0));
        lblban.setText("Bàn1");

        txtgia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtgiaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblban)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTenMon))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(btngoi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btntru, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btncong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblban)
                    .addComponent(lblTenMon))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btntru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btncong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDVT)
                        .addComponent(jLabel1)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngoi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncongActionPerformed
        sl = Integer.parseInt(txtSl.getText());
        if (sl < 30) {
            sl++;
            txtSl.setText(String.valueOf(sl));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btncongActionPerformed

    private void btntruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntruActionPerformed
        try {
            sl = Integer.parseInt(txtSl.getText());
            if (sl != 1 && sl != 0) {
                sl--;
                txtSl.setText(String.valueOf(sl));
            }
        } catch (Exception e) {
            txtSl.setText("1");
        }

    }//GEN-LAST:event_btntruActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btngoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngoiActionPerformed

        MonAn thucdon = thucdondao.getIdByMa(mamon);
        DonHang donHang = donhangdao.getDHbyMa(maban);
        Ban ban = bandao.getIDbyMa(maban);
        int idma = thucdon.getId();
        int iddh = donHang.getId();
        
       // mon = dhctdao.GetDSCT(idma, iddh);
//       if(donhangdao.getDHbyMa(maban)== null){
//           DonHang dh = new DonHang();
//           dh.setIdBan(ban);
//           dh.setTrangThai(0);
//           String insert = donhangdao.insert(dh);
//       }
      // mon = dhctdao.GetDsChiTiet(mamon, maban);
//        if (mon != null) {
//           // mon = dhctdao.GetDsChiTiet(mamon, maban);
//          
//            DonHangChiTiet dhct = new DonHangChiTiet();
//            BigDecimal giaBan = new BigDecimal(txtgia.getText());
//            int sl = Integer.parseInt(txtSl.getText());
//            BigDecimal tien = new BigDecimal(sl).multiply(giaBan);
//            dhct.setDonGia(giaBan);
//            dhct.setSoLuong(sl);
//            dhct.setId(mon.getId());
//            String updatect = dhctdao.UpdateChiTiet(dhct);
//        }
        if (mon == null) {
            DonHangChiTiet dhct = new DonHangChiTiet();
            BigDecimal giaBan = new BigDecimal(txtgia.getText());          
            dhct.setIdDonHang(donHang);
            int sl = Integer.parseInt(txtSl.getText());
            BigDecimal tien = new BigDecimal(sl).multiply(giaBan);
            dhct.setDonGia(giaBan);
            dhct.setIdMonAn(thucdon);
            dhct.setSoLuong(sl);
            JOptionPane.showMessageDialog(this, "Khanh");
            String insertDHCT = dhctdao.insert(dhct);
        }

        Ban b = new Ban();
        b.setTrangThai(1);
        b.setMaBan(maban);
        String updateban = bandao.UpdateBan(b);

       // Ban ban = bandao.getIDbyMa(maban);
        KhuVuc kv = ban.getIdKhuVuc();
        TestDonHang.dh.FillBan(bandao.getkhuvuc(kv.getId()));
        TestDonHang.dh.updateUI();
        JpGoiMon.gm.fillDsMon(donHang.getId());
        JpGoiMon.gm.updateUI();

        this.dispose();
    }//GEN-LAST:event_btngoiActionPerformed

    private void txtSlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSlKeyReleased
//        try {
//            sl = Integer.parseInt(txtSl.getText());
//            if (txtSl.getText().equals("0") || sl > 30) {
//                txtSl.setText("1");
//            }
//        } catch (Exception e) {
//            txtSl.setText("1");
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlKeyReleased

    private void txtgiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgiaKeyReleased
        try {
            Integer.parseInt(txtgia.getText());

        } catch (Exception e) {
            txtgia.setText(String.valueOf(arrThucDon.getDonGia()));
        }
        if (txtgia.getText().equals("0")) {
            txtgia.setText(String.valueOf(arrThucDon.getDonGia()));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiaKeyReleased

    private void txtSlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlActionPerformed
        // TODO add your handling code here:
        try {
            sl = Integer.parseInt(txtSl.getText());
            if (txtSl.getText().equals("0") || sl > 30) {
                //txtSl.setText("1");
            }
        } catch (Exception e) {
            txtSl.setText("1");
        } 
    }//GEN-LAST:event_txtSlActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncong;
    private javax.swing.JButton btngoi;
    private javax.swing.JButton btntru;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JLabel lblban;
    private javax.swing.JTextField txtSl;
    private javax.swing.JTextField txtgia;
    // End of variables declaration//GEN-END:variables
}