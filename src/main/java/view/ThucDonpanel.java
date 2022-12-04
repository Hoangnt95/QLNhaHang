package view;

import Custom.DanhMucCustom;
import Custom.ThucDonCustom;
import entity.DanhMuc;
import entity.MonAn;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ICommonService;
import service.impl.DanhMucService;
import service.impl.ThucDonService;
import util.XImage;

public class ThucDonpanel extends javax.swing.JPanel {
    ICommonService<ThucDonCustom> monanservice;
       ThucDonService donService;
    DanhMucService danhmucservice;
    DefaultTableModel defaultTableModel;
    public ThucDonpanel() {
        initComponents();
        monanservice = new ThucDonService();
        danhmucservice = new DanhMucService();
        donService = new ThucDonService();
        cbxdanhmuc();
        cbxTrangThai();
        Loadtable(monanservice.getLists());
    }
    
    public void cbxdanhmuc() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (DanhMucCustom x : danhmucservice.getLists()) {
            cbx.addElement(x.getTenLoai());
        }
        cbxdanhmuc.setModel(cbx);
    }
    
    void cbxTrangThai() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement("Đang Bán");
        cbx.addElement("Ngưng Bán");
        cbxtrangthai.setModel(cbx);
    }
    ThucDonCustom getdata(){
        return new ThucDonCustom( Integer.parseInt(lbl1.getText()),
                txtmamon.getText(), txttenmon.getText(), 
                txtdonvitinh.getText()
                , lbl_hinhanh.getText(), 
                BigDecimal.valueOf(Double.parseDouble(txtdongia.getText())),
                txtghichu.getText(),  
                cbxtrangthai.getSelectedItem().equals("Đang Bán")?1:0, 
                danhmucservice.getLists().get(cbxdanhmuc.getSelectedIndex()));
//        ThucDonCustom monAn = null;
//
//        String maMon = txtmamon.getText().trim();
//        monAn.setMaMon(maMon);
//
//        String tenMon = txttenmon.getText().trim();
//        monAn.setTenMon(tenMon);
//
//        String donViTinh = txtdonvitinh.getText().trim();
//        monAn.setDonViTinh(donViTinh);
//
//        String hinhAnh = lbl_hinhanh.getText().trim();
//        monAn.setHinhAnh(hinhAnh);
//
//        BigDecimal donGia = new BigDecimal(txtdongia.getText().trim());
//        monAn.setDonGia(donGia);
//
//        String ghiChu = txtghichu.getText().trim();
//        monAn.setGhiChu(ghiChu);
//
//        int trangThai = cbxtrangthai.getSelectedIndex();
//        monAn.setTrangThai(trangThai);
//
//        int idDanhMuc = cbxdanhmuc.getSelectedIndex();
//        monAn.setDanhMuc();
//
//        return monAn;

                
    }
    
    void getImg() {
        JFileChooser _filechooser = new JFileChooser ("C:\\Users\\hieu\\Documents\\GitHub\\QLNhaHang\\image\\iconApp");
        if (_filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = _filechooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lbl_hinhanh.setIcon(icon);
            lbl_hinhanh.setText(file.getName());
            lbl_hinhanh.setToolTipText(file.getName());
        }
    }
    
    public void Loadtable(List<ThucDonCustom> lstthucdoncus){
        defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tblthucdon.getModel();
        defaultTableModel.setRowCount(0);
        for (ThucDonCustom x : lstthucdoncus) {
            defaultTableModel.addRow(new Object[]{x.getId(),x.getMaMon(),x.getTenMon(),x.getDonViTinh(),x.getDonGia(),x.getTrangThai(),x.getGhiChu(),x.getDanhMuc().getTenLoai(),x.getHinhAnh()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmamon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttenmon = new javax.swing.JTextField();
        cbxdanhmuc = new javax.swing.JComboBox<>();
        txtdonvitinh = new javax.swing.JTextField();
        cbxtrangthai = new javax.swing.JComboBox<>();
        txtghichu = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtdongia = new javax.swing.JTextField();
        btnchonanh = new javax.swing.JButton();
        lbl_hinhanh = new javax.swing.JLabel();
        btnsua1 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblthucdon = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin món ăn"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Món:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên Món:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh mục:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Đơn vị tính:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Trạng Thái:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ghi chú:");

        cbxdanhmuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Đơn giá:");

        btnchonanh.setText("Chọn ảnh");
        btnchonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonanhActionPerformed(evt);
            }
        });

        lbl_hinhanh.setText("jLabel10");

        btnsua1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua1.setText("Clear");
        btnsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsua1ActionPerformed(evt);
            }
        });

        lbl1.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsua1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtghichu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdongia)
                            .addComponent(cbxtrangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdonvitinh)
                            .addComponent(txttenmon)
                            .addComponent(txtmamon)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxdanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbl_hinhanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnchonanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(20, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmamon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxdanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdonvitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(lbl_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnchonanh)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnsua1))
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QL Thực Đơn");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Danh mục");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tblthucdon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "stt", "Mã món", "Tên món", "Đơn vị tính", "đơn giá", "trạng thái", "ghi chú", "danh mục", "hình ảnh"
            }
        ));
        tblthucdon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthucdonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblthucdon);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(40, 40, 40)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 452, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(667, 667, 667))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new DanhMucJdialog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnchonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonanhActionPerformed
        getImg();
    }//GEN-LAST:event_btnchonanhActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
         JOptionPane.showMessageDialog(this,  monanservice.addOrUpdate(getdata()));  
         Loadtable(monanservice.getLists());
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
      ThucDonCustom thucdoncs = getdata();
      thucdoncs.setId(Integer.parseInt(lbl1.getText()));
      JOptionPane.showMessageDialog(this, monanservice.addOrUpdate(thucdoncs));
      Loadtable(monanservice.getLists());
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tblthucdonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthucdonMouseClicked
        int row = tblthucdon.getSelectedRow();
        txtmamon.setText(tblthucdon.getValueAt(row, 1).toString());
        txttenmon.setText(tblthucdon.getValueAt(row, 2).toString());
        txtdongia.setText(tblthucdon.getValueAt(row, 4).toString());
        txtdonvitinh.setText(tblthucdon.getValueAt(row, 3).toString());
        txtghichu.setText(tblthucdon.getValueAt(row, 6).toString());
        lbl_hinhanh.setText(tblthucdon.getValueAt(row, 8).toString());
        lbl1.setText(tblthucdon.getValueAt(row, 0).toString());
        cbxdanhmuc.setSelectedItem(tblthucdon.getValueAt(row, 7).toString());
        cbxtrangthai.setSelectedItem(tblthucdon.getValueAt(row, 5).toString());
        
    }//GEN-LAST:event_tblthucdonMouseClicked

    private void btnsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsua1ActionPerformed
        lbl1.setText("0");
        
    }//GEN-LAST:event_btnsua1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchonanh;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnsua1;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbxdanhmuc;
    private javax.swing.JComboBox<String> cbxtrangthai;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl_hinhanh;
    private javax.swing.JTable tblthucdon;
    private javax.swing.JTextField txtdongia;
    private javax.swing.JTextField txtdonvitinh;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtmamon;
    private javax.swing.JTextField txttenmon;
    // End of variables declaration//GEN-END:variables
}
