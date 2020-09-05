/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLHSUI;

import QLHSmodel.ConnectSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import object.hocSinh_if;

public class hocSinh_them extends javax.swing.JInternalFrame {

    public hocSinh_them() {
        initComponents();
    }
//Tách họ tên để lấy mã

    public String tachhoten(String ht) {
        String s = "";
        String[] words = ht.trim().split("\\s+");
        for (String w : words) {
            s += String.valueOf(w.trim().charAt(0)).toUpperCase();
        }
        return s;
    }
//Tách ngày sinh để lấy mã

    public String tachngaysinh() {
        String s = "";
        s += cbngay.getSelectedItem().toString() + cbthang.getSelectedItem().toString() + cbnam.getSelectedItem().toString();
        return s;
    }

//Lấy mã
    public String makema() {
        String ma = "";
        ConnectSQL conn = new ConnectSQL();
        ResultSet rs = conn.getdata("select count(*) from hocSinh_infor");
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(hocSinh_them.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ma += tachhoten(txthodem.getText()) + tachhoten(txttenhs.getText()) + tachngaysinh() + txtmalop.getText() + (rs.getInt(1) + 1);
        } catch (SQLException ex) {
            Logger.getLogger(hocSinh_them.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ma;
    }

//Kiểm tra đúng định dạng liên khóa 
    public boolean checklk(String x) {
        if (Pattern.compile("[K][0-9]{2}").matcher(x).matches()) {
            return true;
        } else {
            return false;
        }
    }
//Chuyển Thành Chữ Viết Hoa Chữ Cái Đầu

    public String chuyenUpkey(String x) {

        if (x.trim().length() == 0) {
            return "";
        }
        if (x.trim().length() == 1) {
            return x.trim().toUpperCase();
        }
        return x.trim().substring(0, 1).toUpperCase()
                + x.trim().substring(1).toLowerCase();
    }
//Xử lý Họ đệm và tên đúng định dạng

    public String xulyten(String x) {
        String s = "";
        String[] words = x.trim().split("\\s+");
        for (String w : words) {
            s += chuyenUpkey(w.trim()) + " ";
        }
        return s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttenhs = new javax.swing.JTextField();
        txtmalop = new javax.swing.JTextField();
        cbngay = new javax.swing.JComboBox<>();
        cbthang = new javax.swing.JComboBox<>();
        cbnam = new javax.swing.JComboBox<>();
        rbnam = new javax.swing.JRadioButton();
        rbnu = new javax.swing.JRadioButton();
        txtdiachi = new javax.swing.JTextField();
        txtdantoc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtkhoa = new javax.swing.JTextField();
        btluu = new javax.swing.JButton();
        bthuy = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txthodem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btchonhs = new javax.swing.JButton();

        setTitle("Thêm Học Sinh");

        jLabel2.setText("Tên học sinh");

        jLabel3.setText("Mã lớp");

        jLabel4.setText("Ngày sinh");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Dân tộc");

        cbngay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbthang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbnam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015" }));

        buttonGroup1.add(rbnam);
        rbnam.setText("Nam");

        buttonGroup1.add(rbnu);
        rbnu.setText("Nữ");

        jLabel8.setText("Khóa");

        btluu.setText("Lưu");
        btluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btluuActionPerformed(evt);
            }
        });

        bthuy.setText("Hủy");
        bthuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthuyActionPerformed(evt);
            }
        });

        jLabel9.setText("Họ & đệm");

        jButton1.setText("reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btchonhs.setText("Chọn HS");
        btchonhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchonhsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btluu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbnam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbnu))
                    .addComponent(txttenhs)
                    .addComponent(txtmalop)
                    .addComponent(txtdiachi)
                    .addComponent(txtdantoc)
                    .addComponent(txtkhoa)
                    .addComponent(txthodem)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bthuy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btchonhs)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btchonhs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txthodem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttenhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmalop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbnam)
                    .addComponent(rbnu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdantoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btluu)
                    .addComponent(bthuy)
                    .addComponent(jButton1))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btluuActionPerformed
        if (!txtdantoc.getText().isEmpty() && !txtdiachi.getText().isEmpty()
                && (rbnam.isSelected() || rbnu.isSelected())) {

            boolean check = true;
            ConnectSQL conn = new ConnectSQL();
            ResultSet rs2 = conn.getdata("select maLop from lop_infor");
            try {
                while (rs2.next()) {
                    if (!rs2.getString(1).equals(txtmalop.getText())) {

                        check = check && false;
                    } else {
                        check = check || true;
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Điền đúng mã lớp");
            } else {
                if (checklk(txtkhoa.getText())) {
                    hocSinh_if x = new hocSinh_if();
                    x.setMahs(makema());
                    x.setHoDem(xulyten(txthodem.getText()));
                    x.setTenhs(xulyten(txttenhs.getText()));
                    x.setMaLop(txtmalop.getText());
                    x.setNgaySinh(cbngay.getSelectedItem().toString() + "/" + cbthang.getSelectedItem().toString()
                            + "/" + cbnam.getSelectedItem().toString());
                    if (rbnam.isSelected()) {
                        x.setGioitinh(rbnam.getText());
                    } else {
                        x.setGioitinh(rbnu.getText());
                    }
                    x.setDiachi(txtdiachi.getText());
                    x.setDantoc(txtdantoc.getText());
                    x.setLienkhoa(txtkhoa.getText());
                    conn.themHocSinh(x);
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng điền đúng liên khóa");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đủ thông tin");
        }
    }//GEN-LAST:event_btluuActionPerformed

    private void bthuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthuyActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bthuyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtdantoc.setText("");
        txtdiachi.setText("");
        txthodem.setText("");
        txtkhoa.setText("");
        txtmalop.setText("");
        txttenhs.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btchonhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btchonhsActionPerformed
        if (pnhocsinh.hsif.getMahs().equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một học sinh trong bảng bên cạnh");
        } else {
            txttenhs.setText(pnhocsinh.hsif.getTenhs());
            txthodem.setText(pnhocsinh.hsif.getHoDem());
            txtmalop.setText(pnhocsinh.hsif.getMaLop());
            txtdiachi.setText(pnhocsinh.hsif.getDiachi());
            txtdantoc.setText(pnhocsinh.hsif.getDantoc());
            txtkhoa.setText(pnhocsinh.hsif.getLienkhoa());
            if (pnhocsinh.hsif.getGioitinh().equals("Nam")) {
                rbnam.setSelected(true);
            } else {
                rbnu.setSelected(true);
            }
            cbngay.setSelectedItem(String.copyValueOf(pnhocsinh.hsif.getNgaySinh().toCharArray(), 0, 2));
            cbthang.setSelectedItem(String.copyValueOf(pnhocsinh.hsif.getNgaySinh().toCharArray(), 3, 2));
            cbnam.setSelectedItem(String.copyValueOf(pnhocsinh.hsif.getNgaySinh().toCharArray(), 6, 4));
        }
    }//GEN-LAST:event_btchonhsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btchonhs;
    private javax.swing.JButton bthuy;
    private javax.swing.JButton btluu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbnam;
    private javax.swing.JComboBox<String> cbngay;
    private javax.swing.JComboBox<String> cbthang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbnam;
    private javax.swing.JRadioButton rbnu;
    private javax.swing.JTextField txtdantoc;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txthodem;
    private javax.swing.JTextField txtkhoa;
    private javax.swing.JTextField txtmalop;
    private javax.swing.JTextField txttenhs;
    // End of variables declaration//GEN-END:variables

}
