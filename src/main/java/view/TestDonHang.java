package view;

import custom.BanCustom;
import custom.KhuVucCustom;
import entity.Ban;
import entity.KhuVuc;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.DEFAULT_CURSOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import service.ICommonService;
import service.impl.BanServiceImpl;
import service.impl.KhuVucServiceImpl;

public class TestDonHang extends javax.swing.JPanel {

    private BanServiceImpl bandao;
    KhuVucServiceImpl kvdao;
    public static TestDonHang dh;
    JPanel jps;
    List<BanCustom> arrBan;
    //List<Ban> listBan;
    List<KhuVucCustom> khuvucList;
    List<JPanel> listjp = new ArrayList<JPanel>();
    BanCustom ban;
    int idBan;

    public TestDonHang() {
        initComponents();
        dh = this;
        bandao = new BanServiceImpl();
        kvdao = new KhuVucServiceImpl();
        load();
    }

    public void load() {
        khuvucList = kvdao.findByKey("");
        List<String> abc = new ArrayList<>();
//        List<BanCustom> listban = bandao.findByKey("");
        List<BanCustom> arrBan = bandao.getkhuvuc(1);
        for (KhuVucCustom nv : khuvucList) {
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
        if (arrBan != null) {
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for (int i = 0; i < arrBan.size(); i++) {
                btn[i] = new JButton();
                String name = String.valueOf(arrBan.get(i).getMaBan());
                btn[i].setName(name);
                String[] mb = arrBan.get(i).getMaBan().split(" ");
                btn[i].setText(mb[0]);
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
                btn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        JpGoiMon goimon;
                        System.out.println(e.getComponent().getName());
                        ban = bandao.Getban(e.getComponent().getName());
                        if (ban != null) {
                            goimon = new JpGoiMon(ban.getTrangThai(), ban.getMaBan());
                             
                            pnlBanHang.removeAll();
                            pnlBanHang.add(goimon);
                            pnlBanHang.updateUI();
                        }
                    }
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();

            }
        }

    }

    public void fillLb() {
        pnlBanHang.removeAll();
        pnlBanHang.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnlBan = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        jpBan = new javax.swing.JPanel();
        pnlBanHang = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1244, 713));

        jLabel17.setText("jLabel17");

        jLabel18.setText("Hello");

        pnlBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Bàn"));

        jRadioButton1.setText("Tất cả");

        jRadioButton2.setText("đang phục vụ");

        jRadioButton3.setText("Đã đặt");

        jRadioButton4.setText("Trống");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 204));

        jButton5.setBackground(new java.awt.Color(255, 0, 0));

        jButton6.setBackground(new java.awt.Color(0, 204, 0));

        jLabel11.setText("Bàn trống");

        jLabel13.setText("Đang phục vụ");

        jLabel14.setText("Bàn đặt");

        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan);
        pnlBan.setLayout(pnlBanLayout);
        pnlBanLayout.setHorizontalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBanLayout.createSequentialGroup()
                        .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBanLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(pnlBanLayout.createSequentialGroup()
                        .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBanLayout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(27, 27, 27)
                                .addComponent(jRadioButton3)
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1))
                            .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlBanLayout.setVerticalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBan, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap())
        );

        pnlBanHang.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlBan, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 935, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel17)
                        .addGap(207, 207, 207))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        // TODO add your handling code here:
        int index = tab.getSelectedIndex();
        String tenKV = tab.getTitleAt(index);
        List<KhuVucCustom> listKhuVuc = kvdao.findByKey(tenKV);
        List<BanCustom> listBan = bandao.getkhuvuc(listKhuVuc.get(0).getId());
        FillBan(listBan);
    }//GEN-LAST:event_tabMouseClicked

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
//         arrBan = bandao.GetbanByTrangThai(0);
//        FillBan(arrBan);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JPanel jpBan;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
