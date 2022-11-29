/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

import entity.DanhMuc;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hieu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThucDonCustom {
    private int id;
    
    
    private String maMon;
    
    
    private String tenMon;
    
   
    private String donViTinh;
    
    
    private String hinhAnh;
    
    
    private BigDecimal donGia;
    
    
    private String ghiChu;
    
    
    private int trangThai;
    
    
    private DanhMucCustom danhMuc;

    public ThucDonCustom(String text, String text0, String text1, String text2, BigDecimal valueOf, String text3, int i, DanhMucCustom get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
