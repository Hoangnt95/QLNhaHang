/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import entity.Ban;
import entity.DonHang;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.BanService;
import service.impl.DonHangChiTietService;
import service.impl.DonHangService;
import service.impl.HoaDonChiTietService;
import service.impl.HoaDonService;
import service.impl.NhanVienService;

/**
 *
 * @author admin
 */
public class test extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    private DefaultTableModel model;
    private BanService banService;
    private HoaDonService hoaDonService;
    private DonHangService donHangService;
    private NhanVienService nhanVienService;
    private DonHangChiTietService donHangChiTietService;
    private HoaDonChiTietService hoaDonChiTietService;
    private List<Ban> list;

    public test() {
        initComponents();
        banService = new BanService();
        this.setLocale(null);
        donHangChiTietService = new DonHangChiTietService();
        donHangService = new DonHangService();
        this.addCbb(cbb1);
    }

    private void addCbb(JComboBox cbb) {
        list = banService.getLists();
        cbb.removeAllItems();
        for (Ban ban : list) {
            cbb.addItem(ban.getMaBan());
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

        cbb1 = new javax.swing.JComboBox<>();
        btnTach = new javax.swing.JButton();
        btnGop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTach.setText("TachBan");
        btnTach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTachActionPerformed(evt);
            }
        });

        btnGop.setText("GopBan");
        btnGop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(btnGop))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbb1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(cbb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTach)
                    .addComponent(btnGop))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTachActionPerformed
        // TODO add your handling code here:
        String maban1 = cbb1.getSelectedItem().toString();
        Ban ban1 = banService.getOne(maban1);
        Integer id = ban1.getId();
        DonHang donHang1 = donHangService.getByBan(id);
        System.out.println(ban1);
//        System.out.println(donHang1);
        String maBan2 = JOptionPane.showInputDialog(this,"Moi nhap ma ban");
        DonHang donHang2 = new DonHang();

    }//GEN-LAST:event_btnTachActionPerformed

    private void btnGopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGopActionPerformed
        // TODO add your handling code here:
        String maban1 = cbb1.getSelectedItem().toString();
        Ban ban1 = banService.getOne(maban1);
        System.out.println(ban1.toString());
        String maBan2 = JOptionPane.showInputDialog(this,"Moi nhap ma ban");
        System.out.println(maBan2);
    }//GEN-LAST:event_btnGopActionPerformed

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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGop;
    private javax.swing.JButton btnTach;
    private javax.swing.JComboBox<String> cbb1;
    // End of variables declaration//GEN-END:variables
}
