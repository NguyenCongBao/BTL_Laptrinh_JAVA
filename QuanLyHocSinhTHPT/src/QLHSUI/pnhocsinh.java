package QLHSUI;

import QLHSmodel.ConnectSQL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import object.hocSinh_if;
import object.xuatdiem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class pnhocsinh extends javax.swing.JPanel {

    public static hocSinh_if hsif = new hocSinh_if("0", "0", "0", "0", "0", "0", "0", "0", "0");
    
    String loai=new String();
    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    JFileChooser savefile;
    String lop = "";
    List<hocSinh_if> list = new ArrayList<>();

    List<hocSinh_if> list2 = new ArrayList<>();

    hocSinh_update hsud = new hocSinh_update();

    hocSinh_them hst = new hocSinh_them();

    hocSinh_xoa hsx = new hocSinh_xoa();

    public pnhocsinh() {
        initComponents();
        //
        
        //
        
        
        try {
            Display();
            fixtable();
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        dkp.add(hsud);
        dkp.add(hst);
        dkp.add(hsx);
        try {
            getKhoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//set size cho Jtable 

    public void fixtable() {
        tbthongtinhocsinh.setRowHeight(20);
        TableColumnModel columnModel = tbthongtinhocsinh.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(200);
    }

//Hiển Thị Dữ Liệu Thông Tin Học Sinh
    public void Display() throws SQLException, ClassNotFoundException {
        ConnectSQL conn = new ConnectSQL();
        conn.getconnect();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Dân Tộc", "Khóa"});
//Lấy ra học sinh khối 10
        ResultSet rshslop10 = conn.getdata("select maLop,tenLop from lop_infor where khoi = '10' order by maLop");
        while (rshslop10.next()) {
            ResultSet rshs10 = conn.getdata("select * from hocSinh_infor where maLop = '" + rshslop10.getString("maLop") + "' order by tenHS,hoDem_HS");
            try {
                while (rshs10.next()) {
                    model.addRow(new String[]{rshs10.getString("maHS"), rshs10.getString("hoDem_HS") + " " + rshs10.getString("tenHS"), rshslop10.getString("tenLop"), rshs10.getString("ngaySinh_HS"),
                        rshs10.getString("gioiTinh_HS"), rshs10.getString("diaChi_HS"), rshs10.getString("danToc_HS"), rshs10.getString("lienKhoa")});
                    list.add(new hocSinh_if(rshs10.getString("maHS"), rshs10.getString("tenHS"),
                            rshslop10.getString("maLop"), rshs10.getString("ngaySinh_HS"), rshs10.getString("gioiTinh_HS"), rshs10.getString("diaChi_HS"),
                            rshs10.getString("danToc_HS"), rshs10.getString("lienKhoa"), rshs10.getString("hoDem_HS")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

//Lấy ra học sinh khối 11
        ResultSet rshslop11 = conn.getdata("select maLop,tenLop from lop_infor where khoi = '11' order by maLop");
        while (rshslop11.next()) {
            ResultSet rshs11 = conn.getdata("select * from hocSinh_infor where maLop = '" + rshslop11.getString("maLop") + "' order by tenHS,hoDem_HS");

            try {
                while (rshs11.next()) {

                    model.addRow(new String[]{rshs11.getString("maHS"), rshs11.getString("hoDem_HS") + " " + rshs11.getString("tenHS"), rshslop11.getString("tenLop"), rshs11.getString("ngaySinh_HS"),
                        rshs11.getString("gioiTinh_HS"), rshs11.getString("diaChi_HS"), rshs11.getString("danToc_HS"), rshs11.getString("lienKhoa")});
                    list.add(new hocSinh_if(rshs11.getString("maHS"), rshs11.getString("tenHS"),
                            rshslop11.getString("maLop"), rshs11.getString("ngaySinh_HS"), rshs11.getString("gioiTinh_HS"), rshs11.getString("diaChi_HS"),
                            rshs11.getString("danToc_HS"), rshs11.getString("lienKhoa"), rshs11.getString("hoDem_HS")));
                }

            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//Lấy ra học sinh khối 12
        ResultSet rshslop12 = conn.getdata("select maLop,tenLop from lop_infor where khoi = '12' order by maLop");
        while (rshslop12.next()) {
            ResultSet rshs12 = conn.getdata("select * from hocSinh_infor where maLop = '" + rshslop12.getString("maLop") + "' order by tenHS,hoDem_HS");
            try {
                while (rshs12.next()) {

                    model.addRow(new String[]{rshs12.getString("maHS"), rshs12.getString("hoDem_HS") + " " + rshs12.getString("tenHS"), rshslop12.getString("tenLop"), rshs12.getString("ngaySinh_HS"),
                        rshs12.getString("gioiTinh_HS"), rshs12.getString("diaChi_HS"), rshs12.getString("danToc_HS"), rshs12.getString("lienKhoa")});
                    list.add(new hocSinh_if(rshs12.getString("maHS"), rshs12.getString("tenHS"),
                            rshslop12.getString("maLop"), rshs12.getString("ngaySinh_HS"), rshs12.getString("gioiTinh_HS"), rshs12.getString("diaChi_HS"),
                            rshs12.getString("danToc_HS"), rshs12.getString("lienKhoa"), rshs12.getString("hoDem_HS")));
                }

            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtsoluong.setText(String.valueOf(model.getRowCount()));
        tbthongtinhocsinh.setModel(model);
    }
//Hiển Thị Thông Tin Học Sinh Xong

//Get Khối
    public void getKhoi() throws ClassNotFoundException, SQLException {
        cbkhoi.addItem("10");
        cbkhoi.addItem("11");
        cbkhoi.addItem("12");
    }
//Get Khối xong

//Lấy Danh Sách Lớp Theo Khối
    public void getLop() {

        String x = cbkhoi.getSelectedItem().toString();
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultComboBoxModel md = new DefaultComboBoxModel();
        ResultSet rs = conn.getdata("select tenLop from lop_infor where khoi='" + x + "'");
        try {
            while (rs.next()) {
                md.addElement(rs.getString("tenLop"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        cblop.setModel(md);
    }
//Lấy Danh Sách Lớp Theo Khối Xong

//Lấy danh sách sinh viên theo lớp 
    public void getDSSVtheoLop() {
        List<hocSinh_if> l = new ArrayList<>();
        String x = cblop.getSelectedItem().toString();
        lop = x;
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Dân Tộc", "Khóa"});
        ResultSet rs = conn.getdata("select maHS,hoDem_HS,tenHS,lop_infor.tenLop,ngaySinh_HS,gioiTinh_HS,diaChi_HS,danToc_HS,"
                + "lienKhoa from hocSinh_infor inner join lop_infor on "
                + "hocSinh_infor.maLop = lop_infor.maLop where lop_infor.tenLop='" + x + "' order by tenHS,hoDem_HS");
        try {
            for (int i = 0; i < l.size(); i++) {
                hocSinh_if s = l.get(i);
                l.remove(s);
            }
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), rs.getString("ngaySinh_HS"),
                    rs.getString("gioiTinh_HS"), rs.getString("diaChi_HS"), rs.getString("danToc_HS"), rs.getString("lienKhoa")});
                l.add(new hocSinh_if(rs.getString("maHS"), rs.getString("tenHS"),
                        rs.getString("tenLop"), rs.getString("ngaySinh_HS"), rs.getString("gioiTinh_HS"), rs.getString("diaChi_HS"),
                        rs.getString("danToc_HS"), rs.getString("lienKhoa"), rs.getString("hoDem_HS")));
            }
            list2 = l;
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtsoluong.setText(String.valueOf(model.getRowCount()));
        tbthongtinhocsinh.setModel(model);
    }
//Lấy danh sách sinh viên theo lớp xong

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmahs = new javax.swing.JTextField();
        cblop = new javax.swing.JComboBox<>();
        bttim = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbkhoi = new javax.swing.JComboBox<>();
        btview = new javax.swing.JButton();
        pn = new javax.swing.JPanel();
        dkp = new javax.swing.JDesktopPane();
        scrollpain = new javax.swing.JScrollPane();
        tbthongtinhocsinh = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        btthem = new javax.swing.JButton();
        btxoa = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        btthoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btxuatfile = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mã học sinh");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setText("Lớp");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        add(txtmahs, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 423, -1));

        cblop.setSelectedItem(getAncestorListeners());
        cblop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblopActionPerformed(evt);
            }
        });
        add(cblop, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 129, -1));

        bttim.setText("Tìm");
        bttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimActionPerformed(evt);
            }
        });
        add(bttim, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 78, -1));

        jLabel4.setText("Khối");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        cbkhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkhoiActionPerformed(evt);
            }
        });
        add(cbkhoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 129, -1));

        btview.setText("Danh sách học sinh toàn trường");
        btview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btviewActionPerformed(evt);
            }
        });
        add(btview, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 330, 30));

        pn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout dkpLayout = new javax.swing.GroupLayout(dkp);
        dkp.setLayout(dkpLayout);
        dkpLayout.setHorizontalGroup(
            dkpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        dkpLayout.setVerticalGroup(
            dkpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        pn.add(dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 350, 390));

        scrollpain.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollpain.setWheelScrollingEnabled(false);

        tbthongtinhocsinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbthongtinhocsinh.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbthongtinhocsinh.setShowHorizontalLines(true);
        tbthongtinhocsinh.setShowVerticalLines(true);
        tbthongtinhocsinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbthongtinhocsinhMouseClicked(evt);
            }
        });
        scrollpain.setViewportView(tbthongtinhocsinh);

        pn.add(scrollpain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 390));

        add(pn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1130, 400));

        jLabel2.setText("Số lượng");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));
        add(txtsoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 210, -1));

        btthem.setText("Thêm");
        btthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemActionPerformed(evt);
            }
        });
        add(btthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 90, 40));

        btxoa.setText("Xóa");
        btxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoaActionPerformed(evt);
            }
        });
        add(btxoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, 90, 40));

        btsua.setText("Sửa");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });
        add(btsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 90, 40));

        btthoat.setText("Thoát");
        btthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthoatActionPerformed(evt);
            }
        });
        add(btthoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 100, -1, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("HỌC SINH TRONG TRƯỜNG");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, 20));

        btxuatfile.setText("Xuất DS học sinh");
        btxuatfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxuatfileActionPerformed(evt);
            }
        });
        add(btxuatfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 190, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btviewActionPerformed
        try {
            Display();
            fixtable();
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btviewActionPerformed

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
            model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Mã Lớp", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Dân Tộc", "Khóa"});
            ResultSet rs = conn.getdata("select * from hocSinh_infor where maHS=N'" + x + "'");
            try {
                while (rs.next()) {
                    model.addRow(new String[]{rs.getString("maHS"), rs.getString("tenHS"), rs.getString("maLop"), rs.getString("ngaySinh_HS"),
                        rs.getString("gioiTinh_HS"), rs.getString("diaChi_HS"), rs.getString("danToc_HS"), rs.getString("lienKhoa")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                txtsoluong.setText(String.valueOf(model.getRowCount()));
                tbthongtinhocsinh.setModel(model);
                fixtable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui long điềm mã học sinh để tìm kiếm");
        }

    }//GEN-LAST:event_bttimActionPerformed

    private void cblopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblopActionPerformed
        getDSSVtheoLop();
        fixtable();
    }//GEN-LAST:event_cblopActionPerformed

    private void cbkhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkhoiActionPerformed
        getLop();
    }//GEN-LAST:event_cbkhoiActionPerformed

    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed

        DesktopManager dtm = new DefaultDesktopManager();
        dkp.setDesktopManager(dtm);
        hst.setVisible(false);
        hsud.setVisible(true);
        hsud.setLocation(10, 25);
        hsx.setVisible(false);

    }//GEN-LAST:event_btsuaActionPerformed

    private void btthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemActionPerformed

        DesktopManager dtm = new DefaultDesktopManager();
        dkp.setDesktopManager(dtm);
        hsud.setVisible(false);
        hst.setVisible(true);
        hst.setLocation(25, 25);
        hsx.setVisible(false);

    }//GEN-LAST:event_btthemActionPerformed

    private void btxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoaActionPerformed

        DesktopManager dtm = new DefaultDesktopManager();
        dkp.setDesktopManager(dtm);
        hsud.setVisible(false);
        hst.setVisible(false);
        hsx.setVisible(true);
        hsx.setLocation(5, 25);

    }//GEN-LAST:event_btxoaActionPerformed

    private void btthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthoatActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btthoatActionPerformed

    private void tbthongtinhocsinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbthongtinhocsinhMouseClicked

        int row = tbthongtinhocsinh.getSelectedRow();
        for (hocSinh_if i : list) {
            if (i.getMahs().equals(tbthongtinhocsinh.getValueAt(row, 0))) {
                hsif = i;
                break;
            }
        }

    }//GEN-LAST:event_tbthongtinhocsinhMouseClicked

    private void btxuatfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxuatfileActionPerformed
        //"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Dân Tộc", "Khóa"}
        if (list2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn lớp học muốn xuất danh sách học sinh");
        } else {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Kết Quả Học Tập" + lop);
            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow(1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã Học Sinh");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên Học Sinh");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Lớp");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày Sinh");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Giới Tính");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa Chỉ");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Dân Tộc");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Khóa");

            int s = list2.size();

            for (int i = 0; i < s; i++) {
                hocSinh_if x = list2.get(i);
                row = spreadsheet.createRow(2 + i);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(x.getMahs());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(x.getHoDem() + x.getTenhs());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(x.getMaLop());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(x.getNgaySinh());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(x.getGioitinh());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(x.getDiachi());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(x.getDantoc());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(x.getLienkhoa());
            }

            String filename = "Danh sach lop " + lop + ".xlsx";
            savefile = new JFileChooser();
            savefile.setSelectedFile(new File(filename));
            //savefile.showSaveDialog(savefile);
            BufferedWriter writer;
            int sf = savefile.showSaveDialog(savefile);
            if (sf == JFileChooser.APPROVE_OPTION) {
                try {
                    //System.out.println(savefile.getSelectedFile().getAbsolutePath());
                    writer = new BufferedWriter(new FileWriter(savefile.getSelectedFile()));
                    File f = new File(savefile.getSelectedFile().getAbsolutePath());
                    FileOutputStream fis = new FileOutputStream(f);
                    workbook.write(fis);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "File đã lưu", "File Saved", JOptionPane.INFORMATION_MESSAGE);
                    // true for rewrite, false for override

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (sf == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Cancel thành công");
            }

        }
    }//GEN-LAST:event_btxuatfileActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        if (loai.equals("hs")) {
            
            btsua.setEnabled(false);
            btthem.setEnabled(false);
            btxoa.setEnabled(false);
        }
        if (loai.equals("gv")) {
           
            btsua.setEnabled(true);
            btthem.setEnabled(true);
            btxoa.setEnabled(true);
        }
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsua;
    private javax.swing.JButton btthem;
    private javax.swing.JButton btthoat;
    private javax.swing.JButton bttim;
    private javax.swing.JButton btview;
    private javax.swing.JButton btxoa;
    private javax.swing.JButton btxuatfile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbkhoi;
    private javax.swing.JComboBox<String> cblop;
    private javax.swing.JDesktopPane dkp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pn;
    private javax.swing.JScrollPane scrollpain;
    private javax.swing.JTable tbthongtinhocsinh;
    private javax.swing.JTextField txtmahs;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
