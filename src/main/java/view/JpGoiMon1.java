/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import custom.BanCustom;
import custom.DHCTBanHangCustom;
import custom.DonHangCustom;
import custom.HoaDonCustom;
import entity.Ban;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.MonAn;
import entity.NhanVien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import service.impl.BanServiceImpl;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhuyenMaiServiceImpl;
import service.impl.MonAnServiceImpl;
import service.impl.NhanVienServiceImpl;
import util.UserHelper;

public final class JpGoiMon1 extends javax.swing.JPanel {

    private DonHangServiceImpl dhdao = new DonHangServiceImpl();
    private DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
    private BanServiceImpl bandao = new BanServiceImpl();
    private MonAnServiceImpl thucdondao = new MonAnServiceImpl();
    private KhuyenMaiServiceImpl kmdao = new KhuyenMaiServiceImpl();
    private HoaDonServiceImpl hddao = new HoaDonServiceImpl();
    private NhanVienServiceImpl nvdao = new NhanVienServiceImpl();
    String TenBan, MaBan, MaDH;
    String MaNV;
    KhuyenMai km;
    int tt, idDH;
    BigDecimal tienmon;
    BigDecimal giatien;
    BigDecimal tongtien;
    BigDecimal tienGiam;
    Date date;
    DonHang arrhd;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    List<DHCTBanHangCustom> order;
    List<BanCustom> arrBan;
    List<DonHang> listDH;
    List<KhuyenMai> listKM;
    public static JpGoiMon1 gm;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");

    /**
     * Creates new form JpGoiMon
     *
     * @param trangthai
     * @param tenban
     * @param idban
     */
    public JpGoiMon1(int trangthai, String maban) {
        initComponents();
        gm = this;
        MaBan = maban; 
        MaNV = UserHelper.getUser.getMaNV();
        jpDsMon.setVisible(false);
        jpThongTinThanhToan.setVisible(false);
        jScrollPane1.setVisible(false);
        loadToCBB();
         
        lblTenBan.setText(maban);
        lbltrangthai.setText(trangthai == 1 ? "Đang phục vụ" : "Trống");
       // btngoi.setVisible(true);
//        if (lbltrangthai.getText().equals("Trống")) {
//            //btngoi.setText("Gọi món");
//            //return;
//        }
//        if (lbltrangthai.getText().equals("2")) {
//            //btndatban.setText("Hủy đặt");
//           // return;
//        }
        if (lbltrangthai.getText().equals("Đang phục vụ")) {
            arrhd = dhdao.getDHbyMa(maban);
            //btndatban.setVisible(false);
            btnthugon.setVisible(false);
            btngoi.setText("Thanh Toán");
            lblgioden.setText(df.format(arrhd.getNgayTao()));
            jpThucDon1 thucdon = new jpThucDon1();
            thucdon.tenban = TenBan;
            thucdon.maban = maban;
            fillDsMon(arrhd.getId());
            jpthucdon.removeAll();
            jpthucdon.add(thucdon);
            jpthucdon.updateUI();
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

        jLabel5 = new javax.swing.JLabel();
        jpThongTinBan = new javax.swing.JPanel();
        lblTenBan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblgioden = new javax.swing.JLabel();
        lbltrangthai = new javax.swing.JLabel();
        jpThongTinThanhToan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbltienmon = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblgiamgia = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        lbltongtien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpDsMon = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btngoi = new javax.swing.JButton();
        btntachban = new javax.swing.JButton();
        btnthugon = new javax.swing.JButton();
        btnGopBan = new javax.swing.JButton();
        jpthucdon = new javax.swing.JPanel();

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 0));
        jLabel5.setText("Thời gian phục vụ gần nhất");

        setBackground(Color.decode("#e6e6e6"));

        jpThongTinBan.setBackground(Color.decode("#e6e6e6"));
        jpThongTinBan.setAutoscrolls(true);

        lblTenBan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTenBan.setForeground(new java.awt.Color(102, 51, 0));
        lblTenBan.setText("Bàn 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Giờ đến:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Trạng thái");

        lblgioden.setText(".....");

        lbltrangthai.setText("....");

        jpThongTinThanhToan.setBackground(Color.decode("#e6e6e6"));
        jpThongTinThanhToan.setAutoscrolls(true);
        jpThongTinThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpThongTinThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpThongTinThanhToanMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("Giảm giá:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("Tiền món:");

        lbltienmon.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbltienmon.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("THÀNH TIỀN:");

        lblgiamgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        cbbKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhuyenMaiItemStateChanged(evt);
            }
        });

        lbltongtien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltongtien.setForeground(new java.awt.Color(255, 0, 0));
        lbltongtien.setText("0");

        javax.swing.GroupLayout jpThongTinThanhToanLayout = new javax.swing.GroupLayout(jpThongTinThanhToan);
        jpThongTinThanhToan.setLayout(jpThongTinThanhToanLayout);
        jpThongTinThanhToanLayout.setHorizontalGroup(
            jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKhuyenMai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(lblgiamgia)
                                .addGap(26, 26, 26))
                            .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltienmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jpThongTinThanhToanLayout.setVerticalGroup(
            jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbltienmon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblgiamgia)
                    .addComponent(lblKhuyenMai)
                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbltongtien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel1.setBackground(Color.decode("#e6e6e6"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(Color.decode("#e6e6e6"));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpDsMon.setBackground(Color.decode("#e6e6e6"));
        jpDsMon.setMaximumSize(new java.awt.Dimension(32767, 400));
        jpDsMon.setOpaque(false);

        javax.swing.GroupLayout jpDsMonLayout = new javax.swing.GroupLayout(jpDsMon);
        jpDsMon.setLayout(jpDsMonLayout);
        jpDsMonLayout.setHorizontalGroup(
            jpDsMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jpDsMonLayout.setVerticalGroup(
            jpDsMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpDsMon);

        btngoi.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        btngoi.setForeground(new java.awt.Color(102, 51, 0));
        btngoi.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\add-item.png")); // NOI18N
        btngoi.setText("Gọi món");
        btngoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngoi.setPreferredSize(new java.awt.Dimension(100, 40));
        btngoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngoiActionPerformed(evt);
            }
        });
        jPanel2.add(btngoi);

        btntachban.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        btntachban.setForeground(new java.awt.Color(102, 51, 0));
        btntachban.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\tachHD.png")); // NOI18N
        btntachban.setText("Tách Bàn");
        btntachban.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntachban.setPreferredSize(new java.awt.Dimension(110, 40));
        btntachban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntachbanActionPerformed(evt);
            }
        });
        jPanel2.add(btntachban);

        btnthugon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnthugon.setForeground(new java.awt.Color(0, 51, 51));
        btnthugon.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\undo.png")); // NOI18N
        btnthugon.setMaximumSize(new java.awt.Dimension(93, 24));
        btnthugon.setPreferredSize(new java.awt.Dimension(100, 40));
        btnthugon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthugonActionPerformed(evt);
            }
        });
        jPanel2.add(btnthugon);

        btnGopBan.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        btnGopBan.setForeground(new java.awt.Color(102, 51, 0));
        btnGopBan.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\nhap.png")); // NOI18N
        btnGopBan.setText("Gộp Bàn");
        btnGopBan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGopBan.setPreferredSize(new java.awt.Dimension(110, 40));
        btnGopBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGopBanActionPerformed(evt);
            }
        });
        jPanel2.add(btnGopBan);

        javax.swing.GroupLayout jpThongTinBanLayout = new javax.swing.GroupLayout(jpThongTinBan);
        jpThongTinBan.setLayout(jpThongTinBanLayout);
        jpThongTinBanLayout.setHorizontalGroup(
            jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpThongTinThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblgioden, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpThongTinBanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenBan)
                .addGap(95, 95, 95))
            .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpThongTinBanLayout.createSequentialGroup()
                    .addGap(0, 145, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 146, Short.MAX_VALUE)))
        );
        jpThongTinBanLayout.setVerticalGroup(
            jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinBanLayout.createSequentialGroup()
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpThongTinBanLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblTenBan)))
                .addGap(18, 18, 18)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblgioden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbltrangthai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpThongTinThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jpThongTinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpThongTinBanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 526, Short.MAX_VALUE)))
        );

        jpthucdon.setBackground(Color.decode("#e6e6e6"));
        jpthucdon.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpThongTinBan, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpthucdon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpthucdon, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpThongTinBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents
    public void tinhtien() {
        // lblKhuyenMai.setText(String.valueOf(arrhd.getIdKhuyenMai().getPhanTram())+" %");
        int so = (int) cbbKhuyenMai.getSelectedItem();
        double giam = so * 0.01;
        BigDecimal phantram = new BigDecimal(giam);
        tienGiam = tienmon.multiply(phantram);
        tongtien = tienmon.subtract(tienGiam);
       lbltongtien.setText(chuyentien.format(tongtien));
    }

    public void fillThongTin() {
        arrhd = dhdao.getDHbyMa(MaBan);
        idDH = arrhd.getId();
        MaDH = arrhd.getMaDH();
        btngoi.setVisible(true);
         lbltienmon.setText(String.valueOf(chuyentien.format(tienmon)) + " VNĐ");
        int so = (int) cbbKhuyenMai.getSelectedItem();
        double giam = so * 0.01;
        BigDecimal phantram = new BigDecimal(giam);
        tienGiam = tienmon.multiply(phantram);
        tongtien = tienmon.subtract(tienGiam);
        lbltongtien.setText(chuyentien.format(tongtien));
        cbbKhuyenMai.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int so = (int) cbbKhuyenMai.getSelectedItem();
                km = kmdao.getIDbyPhanTram(so);
                DonHang dh = new DonHang();
                dh.setMaDH(MaDH);
                dh.setIdKhuyenMai(km);
                String updatehd = dhdao.updateDonHangGiamGia(dh);
                double giam = so * 0.01;
                BigDecimal phantram = new BigDecimal(giam);
                tienGiam = tienmon.multiply(phantram);
                tongtien = tienmon.subtract(tienGiam);
                lbltongtien.setText(chuyentien.format(tongtien));
            }
        });
    }

    public void fillDsMon(int idhd) {

        arrhd = dhdao.getDHbyMa(MaBan);
        order = dhctdao.getDSOder(arrhd.getId());
        idDH = arrhd.getId();
        idhd = idDH;
        if (order != null) {
            jpDsMon.setVisible(true);
            jpThongTinThanhToan.setVisible(true);
            jScrollPane1.setVisible(true);
            btngoi.setText("Thanh Toán");

            JPanel[] pn = new JPanel[order.size()];
            jpDsMon.removeAll();
            jpDsMon.setLayout(new BoxLayout(jpDsMon, BoxLayout.Y_AXIS));
            tienmon = new BigDecimal(0);
            for (int i = 0; i < order.size(); i++) {
                int sl = order.get(i).getSoLuong();
                BigDecimal dongia = new BigDecimal(order.get(i).getDonGia() + "");
                BigDecimal tien = new BigDecimal(sl).multiply(dongia);
                tienmon = tienmon.add(tien);
                pn[i] = new JPanel();
                pn[i].setName(order.get(i).getMaMon());
                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pn[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                pn[i].setBackground(Color.decode("#b3ff99"));
                pn[i].setLayout(new GridLayout());
                pn[i].setPreferredSize(new Dimension(270, 50));
                pn[i].setMaximumSize(new Dimension(270, 50));
                pn[i].setMinimumSize(new Dimension(270, 50));
                pn[i].add(new JLabel(order.get(i).getTenMon(), JLabel.CENTER)).setForeground(Color.decode("#001a66"));
                pn[i].add(new JLabel(String.valueOf(chuyentien.format(order.get(i).getDonGia())) + " VNĐ", JLabel.CENTER)).setForeground(Color.decode("#ff0000"));
                pn[i].add(new JLabel(String.valueOf(order.get(i).getSoLuong()) + " " + order.get(i).getDonViTinh(), JLabel.RIGHT)).setForeground(Color.decode("#008000"));
                Icon ic = new ImageIcon("C:\\DuAn\\DuAn1\\src\\main\\java\\Images\\unistall.png");
                JLabel lbl = new JLabel("", ic, JLabel.CENTER);
                lbl.setForeground(Color.decode("#b3ff99"));
                lbl.setName(String.valueOf(order.get(i).getMaMon()));
                pn[i].add(lbl).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int qs;

                        MonAn td = thucdondao.getIdByMa(e.getComponent().getName());
                        qs = JOptionPane.showConfirmDialog(null, "Hủy món: " + td.getTenMon() + " ?", "Hủy món", JOptionPane.YES_NO_OPTION);
                        if (qs == JOptionPane.YES_OPTION) {

                            String xoa = dhctdao.xoamon(idDH,td.getId());
                            fillDsMon(idDH);
                        }
                    }
                });
                pn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                       
                        DLCapNhatSL sl = new DLCapNhatSL(TrangChu.main, true, e.getComponent().getName(), TenBan, MaBan);
                        sl.setVisible(true);
                    }
                });
                jpDsMon.add(pn[i]);
                jpDsMon.updateUI();

            }

            fillThongTin();
        }
    }

    private void loadToCBB() {
        listKM = kmdao.getAll();
        for (KhuyenMai km : listKM) {
            cbbKhuyenMai.addItem(km.getPhanTram());
        }
    }

    private void HuyHD() {

//        JButton btnhuy = new JButton("Hủy bàn");
//        btnhuy.setPreferredSize(new Dimension(100, 40));
//        btnhuy.setBounds(100, 50, 100, 40);
//        jpDsMon.setLayout(null);
//        btngoi.setVisible(false);
//        jpThongTinThanhToan.setVisible(false);
//        btnhuy.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                Ban b = new Ban();
//                b.setTrangThai(0);
//                b.setMaBan(MaBan);
//                bandao.UpdateTrangThaiban(b);
//                TestDonHang.dh.FillBan(arrBan);
//                JpGoiMon.gm.removeAll();
//                DonHang dh = new DonHang();
//                dhdao.delete(dh);
//            }
//        });
//        jpDsMon.add(btnhuy);
//        jpDsMon.updateUI();
    }
    private void jpThongTinThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongTinThanhToanMousePressed

//        arrhd = dhdao.getDHbyMa(MaBan);
    }//GEN-LAST:event_jpThongTinThanhToanMousePressed

    private void cbbKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiItemStateChanged
        // TODO add your handling code here:
//         tinhtien();
    }//GEN-LAST:event_cbbKhuyenMaiItemStateChanged

    private void btnthugonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthugonActionPerformed
        // TODO add your handling code here:
            TestDonHang.dh.fillLb();
    }//GEN-LAST:event_btnthugonActionPerformed

    private void btngoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngoiActionPerformed
        // TODO add your handling code here:
        if (btngoi.getText().equals("Hủy bàn")) {
            jpthucdon.removeAll();
            jpthucdon.updateUI();
            jpThongTinThanhToan.setVisible(false);
            btnthugon.setVisible(true);
            lblgioden.setText("......");
            lbltrangthai.setText("Trống");
           
            String TrangThai = "Trống";
            int trangthai = 0;
            Ban b = new Ban(MaBan, trangthai);
            String Update = bandao.UpdateBan(b);
            TestDonHang.dh.FillBan(arrBan);
            btngoi.setText("Gọi món");
//            btndatban.setVisible(true);
//            btndatban.setText("Đặt bàn");
            return;
        }
        if (btngoi.getText().equals("Thanh Toán")) {

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            date = new Date();
            try {
                date = df.parse(lblgioden.getText());
            } catch (ParseException ex) {
                Logger.getLogger(JpGoiMon1.class.getName()).log(Level.SEVERE, null, ex);
            }
            HoaDonCustom hd = new HoaDonCustom();
            hd.setTrangThai(0);
            hd.setIdDonHang(arrhd.getId());
            hd.setNgayTao(date);
            HoaDonJDialog hoadon = new HoaDonJDialog(TrangChu.main, true, idDH, tongtien, date, MaBan, MaDH, TenBan,MaNV);
            hoadon.setVisible(true);
            return;
        }
        if (btngoi.getText().equals("Gọi món")) {
            jpthucdon.setVisible(true);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lblgioden.setText(df.format(date));
            lbltrangthai.setText("Đang phục vụ");
           
            btnthugon.setVisible(false);
            btngoi.setText("Hủy bàn");
            
            NhanVien nv = nvdao.findByMa(MaNV);
            
            DonHang dh = new DonHang();
            Ban b = bandao.getIDbyMa(MaBan);
            listDH = dhdao.getLists();
            int so = listDH.size();
            int so1 = so + 1;
            String AUTOMAHD = "DH".concat(String.valueOf(so1));
            dh.setMaDH(AUTOMAHD);
            dh.setTrangThai(0);
            dh.setNgayTao(date);
            dh.setIdBan(b);
            dh.setIdNhanVien(nv);
            String insertHd = dhdao.insert(dh);
            
//             String sl = JOptionPane.showInputDialog("Số lượng khách đến: ");
//            // lblSL.setText(sl);
//            if(Integer.parseInt(sl)>ban.getSoLuongChoNgoi()){
//                JOptionPane.showMessageDialog(this, "Bàn không đủ chỗ. Vui lòng nhập lại!");
//            }else{
//                 lblSL.setText(sl);
//            }
            jpThucDon1 thucdon;
            thucdon = new jpThucDon1();
            thucdon.maban = MaBan;
            thucdon.tenban = TenBan;
            thucdon.gioden = sf.format(date);
            jpthucdon.removeAll();
            jpthucdon.add(thucdon);
            jpthucdon.revalidate();
        }
    }//GEN-LAST:event_btngoiActionPerformed

    private void btntachbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntachbanActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Chuyenban hoadon = new Chuyenban(TrangChu.main, true, MaBan,MaDH);
        hoadon.setVisible(true);
         TestDonHang.dh.fillLb();
    }//GEN-LAST:event_btntachbanActionPerformed

    private void btnGopBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGopBanActionPerformed
        // TODO add your handling code here:
          arrhd = dhdao.getDHbyMa(MaBan);
        idDH = arrhd.getId();
        GopBan gp = new GopBan(TrangChu.main, true,MaBan,km,idDH);
        gp.setVisible(true);
         TestDonHang.dh.fillLb();
    }//GEN-LAST:event_btnGopBanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGopBan;
    private javax.swing.JButton btngoi;
    private javax.swing.JButton btntachban;
    private javax.swing.JButton btnthugon;
    private javax.swing.JComboBox<Integer> cbbKhuyenMai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpDsMon;
    private javax.swing.JPanel jpThongTinBan;
    private javax.swing.JPanel jpThongTinThanhToan;
    private javax.swing.JPanel jpthucdon;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblTenBan;
    private javax.swing.JLabel lblgiamgia;
    private javax.swing.JLabel lblgioden;
    private javax.swing.JLabel lbltienmon;
    private javax.swing.JLabel lbltongtien;
    private javax.swing.JLabel lbltrangthai;
    // End of variables declaration//GEN-END:variables
}
