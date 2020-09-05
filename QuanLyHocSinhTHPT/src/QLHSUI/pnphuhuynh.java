/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLHSUI;

import QLHSmodel.ConnectSQL;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import object.phuHuynh;
import object.scores;

public class pnphuhuynh extends javax.swing.JPanel {

    String loai = new String();

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public pnphuhuynh() {
        initComponents();

        try {
            Display();
            fixtable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Chuyển Thành Chữ Viết Hoa Chữ Cái Đầu

    public String chuyenUpkey(String x) {

        if (x.length() == 0) {
            return "";
        }
        if (x.length() == 1) {
            return x.toUpperCase();
        }
        return x.substring(0, 1).toUpperCase()
                + x.substring(1).toLowerCase();
    }
//Xử lý Họ đệm và tên đúng định dạng

    public String xulyten(String x) {
        String s = "";
        String[] words = x.split("\\s+");
        for (String w : words) {
            s += chuyenUpkey(w.trim()) + " ";
        }
        return s;
    }
//Hiển Thi

    public void Display() throws ClassNotFoundException, SQLException {
        ConnectSQL conn = new ConnectSQL();
        conn.getconnect();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Tên Bố", "Năm Sinh Bố", "Nghề Nghiệp Bố", "Tên Mẹ", "Năm Sinh Mẹ", "Nghề Nghiệp Mẹ", "SĐT Phụ Huynh"});

        ResultSet rs = conn.getdata("select hocSinh_infor.maHS,hoDem_HS,tenHS,lop_infor.tenLop,tenBo,namSinh_Bo,ngheNghiep_Bo,tenMe,namSinh_Me,ngheNghiep_Me,SDT_PhuHuynh"
                + " from hocSinh_infor inner join phuHuynh_infor on phuHuynh_infor.maHS=hocSinh_infor.maHS inner join lop_infor on lop_infor.maLop=hocSinh_infor.maLop order by lop_infor.tenLop,tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), rs.getString("tenBo"),
                    rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Bo"), rs.getString("tenMe"), rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Me"),
                    rs.getString("SDT_PhuHuynh")});
                list.add(new phuHuynh(rs.getString("maHS"), rs.getString("tenBo"), rs.getString("tenMe"), rs.getString("namSinh_Bo"), rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Bo"), rs.getString("ngheNghiep_Me"), rs.getString("SDT_PhuHuynh")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbphuhuynh.setModel(model);
        fixtable();
    }

//Hiển Thị Theo Mã   
    public void Displayma() throws ClassNotFoundException, SQLException {
        ConnectSQL conn = new ConnectSQL();
        conn.getconnect();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Tên Bố", "Năm Sinh Bố", "Nghề Nghiệp Bố", "Tên Mẹ", "Năm Sinh Mẹ", "Nghề Nghiệp Mẹ", "SĐT Phụ Huynh"});

        ResultSet rs = conn.getdata("select hocSinh_infor.maHS,hoDem_HS,tenHS,lop_infor.tenLop,tenBo,namSinh_Bo,ngheNghiep_Bo,tenMe,namSinh_Me,ngheNghiep_Me,SDT_PhuHuynh"
                + " from hocSinh_infor inner join phuHuynh_infor on phuHuynh_infor.maHS=hocSinh_infor.maHS inner join lop_infor on lop_infor.maLop=hocSinh_infor.maLop where hocSinh_infor.maHS=N'" + txtmahs.getText() + "' order by tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), rs.getString("tenBo"),
                    rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Bo"), rs.getString("tenMe"), rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Me"),
                    rs.getString("SDT_PhuHuynh")});
                list.add(new phuHuynh(rs.getString("maHS"), rs.getString("tenBo"), rs.getString("tenMe"), rs.getString("namSinh_Bo"), rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Bo"), rs.getString("ngheNghiep_Me"), rs.getString("SDT_PhuHuynh")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbphuhuynh.setModel(model);
        fixtable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btthoat = new javax.swing.JButton();
        bttim = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        txtsdtph = new javax.swing.JTextField();
        txttenbo = new javax.swing.JTextField();
        txtnamsinhbo = new javax.swing.JTextField();
        txtnghenghiepbo = new javax.swing.JTextField();
        txtmahs = new javax.swing.JTextField();
        txttenme = new javax.swing.JTextField();
        txtnamsinhme = new javax.swing.JTextField();
        txtnghenghiepme = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbphuhuynh = new javax.swing.JTable();
        btview = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btthem = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("SĐT phụ huynh");

        jLabel2.setText("Tên Bố");

        jLabel3.setText("Năm sinh");

        jLabel4.setText("Nghề nghiệp");

        jLabel5.setText("Mã học sinh");

        jLabel6.setText("Tên Mẹ");

        jLabel7.setText("Năm sinh ");

        jLabel8.setText("Nghề nghiệp");

        btthoat.setText("Thoát");
        btthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthoatActionPerformed(evt);
            }
        });

        bttim.setText("Tìm");
        bttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimActionPerformed(evt);
            }
        });

        btsua.setText("Sửa");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });

        tbphuhuynh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbphuhuynh.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbphuhuynh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbphuhuynhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbphuhuynh);

        btview.setText("View");
        btview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btviewActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("THÔNG TIN PHỤ HUYNH");

        btthem.setText("Thêm");
        btthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnamsinhbo)
                    .addComponent(txtnghenghiepbo)
                    .addComponent(txttenbo)
                    .addComponent(txtsdtph, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmahs, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(txttenme, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnamsinhme, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnghenghiepme, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtsdtph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmahs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btthem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txttenbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttenme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btsua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtnamsinhbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnamsinhme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(btview)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtnghenghiepbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnghenghiepme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(btthoat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

//Kiểm tra dữ liệu nhập vào
    //check năm sinh
    public boolean checknamsinh(String x) {
        if (Pattern.compile("[1][9][0-9]{2}").matcher(x).matches()) {
            return true;
        } else {
            return false;
        }
    }

    //check SĐT
    public boolean checkSDT(String x) {
        if (Pattern.compile("[0][1-9][0-9]{8}+").matcher(x).matches() || Pattern.compile("[0][1-9][0-9]{9}+").matcher(x).matches()) {
            return true;
        } else {
            return false;
        }
    }
    private void btthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthoatActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btthoatActionPerformed

    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed
        if (txtmahs.getText().isEmpty() && txttenbo.getText().isEmpty() && txtnamsinhbo.getText().isEmpty() && txtnghenghiepbo.getText().isEmpty()
                && txttenme.getText().isEmpty() && txtnamsinhme.getText().isEmpty() && txtnghenghiepme.getText().isEmpty() && txtsdtph.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điền đầy đủ thông tin");
        } else {
            boolean check = true;
            ConnectSQL conn = new ConnectSQL();
            ResultSet rs1 = conn.getdata("select maHS from hocSinh_infor");
            try {
                while (rs1.next()) {
                    if (!rs1.getString(1).equals(txtmahs.getText())) {
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
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                if (checknamsinh(txtnamsinhbo.getText()) && checknamsinh(txtnamsinhme.getText())) {
                    if (checkSDT(txtsdtph.getText())) {
                        phuHuynh x = new phuHuynh();
                        x.setMaHS(txtmahs.getText());
                        x.setTenBo(xulyten(txttenbo.getText()));
                        x.setNamSinhBo(txtnamsinhbo.getText());
                        x.setNgheNghiepBo(txtnghenghiepbo.getText());
                        x.setTenMe(xulyten(txttenme.getText()));
                        x.setNamSinhMe(txtnamsinhme.getText());
                        x.setNgheNghiepMe(txtnghenghiepme.getText());
                        x.setSDTphuhuynh(txtsdtph.getText());
                        conn.suaphuhuynh(x);
                        JOptionPane.showMessageDialog(this, "Sửa Thành công");
                        try {
                            Displayma();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Sai định dạng SĐT");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Sai định dạng năm sinh VD: 19XX");
                }
            }
        }
    }//GEN-LAST:event_btsuaActionPerformed
//Tìm kiếm
    private void bttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimActionPerformed
        if (!txtmahs.getText().isEmpty()) {
            String x = txtmahs.getText();
            ConnectSQL conn = new ConnectSQL();
            try {
                conn.getconnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Tên Bố", "Năm Sinh Bố", "Nghề Nghiệp Bố", "Tên Mẹ", "Năm Sinh Mẹ", "Nghề Nghiệp Mẹ", "SĐT Phụ Huynh"});

            ResultSet rs = conn.getdata("select hocSinh_infor.maHS,tenHS,lop_infor.tenLop,tenBo,namSinh_Bo,ngheNghiep_Bo,tenMe,namSinh_Me,ngheNghiep_Me,SDT_PhuHuynh"
                    + " from hocSinh_infor inner join phuHuynh_infor on phuHuynh_infor.maHS=hocSinh_infor.maHS inner join lop_infor on lop_infor.maLop=hocSinh_infor.maLop where hocSinh_infor.maHS=N'"
                    + x + "'");
            try {
                while (rs.next()) {
                    model.addRow(new String[]{rs.getString("maHS"), rs.getString("tenHS"), rs.getString("tenLop"), rs.getString("tenBo"),
                        rs.getString("namSinh_Bo"), rs.getString("ngheNghiep_Bo"), rs.getString("tenMe"), rs.getString("namSinh_Me"), rs.getString("ngheNghiep_Me"),
                        rs.getString("SDT_PhuHuynh")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                tbphuhuynh.setModel(model);
                fixtable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điềm mã học sinh để tìm kiếm");
        }
    }//GEN-LAST:event_bttimActionPerformed

    private void btviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btviewActionPerformed
        try {
            Display();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btviewActionPerformed

    private void tbphuhuynhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbphuhuynhMouseClicked
        getdata();
    }//GEN-LAST:event_tbphuhuynhMouseClicked

    private void btthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemActionPerformed
        if (txtmahs.getText().isEmpty() && txttenbo.getText().isEmpty() && txtnamsinhbo.getText().isEmpty() && txtnghenghiepbo.getText().isEmpty()
                && txttenme.getText().isEmpty() && txtnamsinhme.getText().isEmpty() && txtnghenghiepme.getText().isEmpty() && txtsdtph.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điền đầy đủ thông tin");
        } else {
            boolean check = true;
            boolean check2 = true;
            ConnectSQL conn = new ConnectSQL();
            ResultSet rs1 = conn.getdata("select maHS from hocSinh_infor");
            ResultSet rs2 = conn.getdata("select maHS from phuHuynh_infor");
            try {
                while (rs1.next()) {
                    if (!rs1.getString(1).equals(txtmahs.getText())) {
                        check = check && false;
                    } else {
                        check = check || true;
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (rs2.next()) {
                    if (rs2.getString(1).equals(txtmahs.getText())) {
                        check2 = check2 && false;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (check == false) {
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                if (check2 == true) {
                    if (checknamsinh(txtnamsinhbo.getText()) && checknamsinh(txtnamsinhme.getText())) {
                        if (checkSDT(txtsdtph.getText())) {
                            phuHuynh x = new phuHuynh();
                            x.setMaHS(txtmahs.getText());
                            x.setTenBo(xulyten(txttenbo.getText()));
                            x.setNamSinhBo(txtnamsinhbo.getText());
                            x.setNgheNghiepBo(txtnghenghiepbo.getText());
                            x.setTenMe(xulyten(txttenme.getText()));
                            x.setNamSinhMe(txtnamsinhme.getText());
                            x.setNgheNghiepMe(txtnghenghiepme.getText());
                            x.setSDTphuhuynh(txtsdtph.getText());
                            conn.themphuhuynh(x);
                            JOptionPane.showMessageDialog(this, "Thêm thành công");

                            try {
                                Displayma();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(pnphuhuynh.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Sai định dạng SĐT");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Sai định dạng năm sinh VD: 19XX");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã có thông tin phụ huynh của học sinh này");
                }
            }
        }
    }//GEN-LAST:event_btthemActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        if (loai.equals("hs")) {
            btsua.setEnabled(false);
            btthem.setEnabled(false);
        }
        if (loai.equals("gv")){
        btsua.setEnabled(true);
        btthem.setEnabled(true);}
    }//GEN-LAST:event_formAncestorAdded

    List<phuHuynh> list = new ArrayList<>();

    public void getdata() {
        int row = tbphuhuynh.getSelectedRow();
        txttenbo.setText(list.get(row).getTenBo());
        txttenme.setText(list.get(row).getTenMe());
        txtnamsinhbo.setText(list.get(row).getNamSinhBo());
        txtnamsinhme.setText(list.get(row).getNamSinhMe());
        txtnghenghiepbo.setText(list.get(row).getNgheNghiepBo());
        txtnghenghiepme.setText(list.get(row).getNgheNghiepMe());
        txtsdtph.setText(list.get(row).getSDTphuhuynh());
        txtmahs.setText(list.get(row).getMaHS());
    }
    //set size cho Jtable 

    public void fixtable() {
        tbphuhuynh.setRowHeight(20);
        TableColumnModel columnModel = tbphuhuynh.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);
        columnModel.getColumn(9).setPreferredWidth(150);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsua;
    private javax.swing.JButton btthem;
    private javax.swing.JButton btthoat;
    private javax.swing.JButton bttim;
    private javax.swing.JButton btview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbphuhuynh;
    private javax.swing.JTextField txtmahs;
    private javax.swing.JTextField txtnamsinhbo;
    private javax.swing.JTextField txtnamsinhme;
    private javax.swing.JTextField txtnghenghiepbo;
    private javax.swing.JTextField txtnghenghiepme;
    private javax.swing.JTextField txtsdtph;
    private javax.swing.JTextField txttenbo;
    private javax.swing.JTextField txttenme;
    // End of variables declaration//GEN-END:variables
}
