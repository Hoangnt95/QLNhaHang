package view;

import javax.swing.JPanel;

public class TrangChu extends javax.swing.JFrame {

    public TrangChu() {
        initComponents();
         show(new ThongKeJPanel());
        
    }
    
    public void show(JPanel a) {
        lbl_hihi.removeAll();
        lbl_hihi.add(a);
        lbl_hihi.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        btn_hoadon = new javax.swing.JButton();
        btn_thucdon = new javax.swing.JButton();
        btn_khuyenmai = new javax.swing.JButton();
        btn_nhanvien = new javax.swing.JButton();
        btn_thongke = new javax.swing.JButton();
        btn_ban = new javax.swing.JButton();
        btn_donhang = new javax.swing.JButton();
        lbl_hihi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Trang Chủ");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\Dang xuat.png")); // NOI18N
        jButton14.setText("Đăng Xuất");
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btn_hoadon.setBackground(new java.awt.Color(255, 255, 255));
        btn_hoadon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_hoadon.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\bill.png")); // NOI18N
        btn_hoadon.setText("QL Hoá Đơn");
        btn_hoadon.setBorder(null);
        btn_hoadon.setBorderPainted(false);
        btn_hoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoadonActionPerformed(evt);
            }
        });

        btn_thucdon.setBackground(new java.awt.Color(255, 255, 255));
        btn_thucdon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_thucdon.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\menu.png")); // NOI18N
        btn_thucdon.setText("Thực đơn");
        btn_thucdon.setBorder(null);
        btn_thucdon.setBorderPainted(false);
        btn_thucdon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thucdonActionPerformed(evt);
            }
        });

        btn_khuyenmai.setBackground(new java.awt.Color(255, 255, 255));
        btn_khuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_khuyenmai.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\sale-tag.png")); // NOI18N
        btn_khuyenmai.setText("Khuyến Mãi");
        btn_khuyenmai.setBorder(null);
        btn_khuyenmai.setBorderPainted(false);
        btn_khuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khuyenmaiActionPerformed(evt);
            }
        });

        btn_nhanvien.setBackground(new java.awt.Color(255, 255, 255));
        btn_nhanvien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_nhanvien.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\Nhan vien.png")); // NOI18N
        btn_nhanvien.setText("Nhân Viên");
        btn_nhanvien.setBorder(null);
        btn_nhanvien.setBorderPainted(false);
        btn_nhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanvienActionPerformed(evt);
            }
        });

        btn_thongke.setBackground(new java.awt.Color(255, 255, 255));
        btn_thongke.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_thongke.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\thongKe.png")); // NOI18N
        btn_thongke.setText("Thống kê");
        btn_thongke.setBorder(null);
        btn_thongke.setBorderPainted(false);
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        btn_ban.setBackground(new java.awt.Color(255, 255, 255));
        btn_ban.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_ban.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\dining-table.png")); // NOI18N
        btn_ban.setText("QL Bàn");
        btn_ban.setBorder(null);
        btn_ban.setBorderPainted(false);
        btn_ban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banActionPerformed(evt);
            }
        });

        btn_donhang.setBackground(new java.awt.Color(255, 255, 255));
        btn_donhang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_donhang.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\QLNhaHang\\image\\iconApp\\Ban hang.png")); // NOI18N
        btn_donhang.setText("Bán hàng");
        btn_donhang.setBorder(null);
        btn_donhang.setBorderPainted(false);
        btn_donhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_donhangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_donhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_thucdon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khuyenmai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
            .addComponent(btn_nhanvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_ban, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_thongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_donhang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_thucdon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_ban, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        lbl_hihi.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 590, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(560, 560, 560))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_hihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(lbl_hihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thucdonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thucdonActionPerformed
       show(new ThucDonpanel());
    }//GEN-LAST:event_btn_thucdonActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btn_khuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenmaiActionPerformed
        show(new KhuyenMaiJpanel());
    }//GEN-LAST:event_btn_khuyenmaiActionPerformed

    private void btn_banActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banActionPerformed
        show(new BanJPanel());
    }//GEN-LAST:event_btn_banActionPerformed

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        show(new ThongKeJPanel());
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void btn_hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoadonActionPerformed
        show(new HoaDonJpanel());
    }//GEN-LAST:event_btn_hoadonActionPerformed

    private void btn_donhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_donhangActionPerformed
        show(new DonHangJPanel());
    }//GEN-LAST:event_btn_donhangActionPerformed

    private void btn_nhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanvienActionPerformed
        show(new NhanVienJpanel());
    }//GEN-LAST:event_btn_nhanvienActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ban;
    private javax.swing.JButton btn_donhang;
    private javax.swing.JButton btn_hoadon;
    private javax.swing.JButton btn_khuyenmai;
    private javax.swing.JButton btn_nhanvien;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JButton btn_thucdon;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel lbl_hihi;
    // End of variables declaration//GEN-END:variables
}
