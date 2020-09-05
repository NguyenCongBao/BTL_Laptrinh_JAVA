package QLHSUI;

import QLHSmodel.ConnectSQL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import object.scores;
import java.util.List;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import object.xuatdiem;
import org.apache.poi.ss.formula.functions.Choose;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class pndiem extends javax.swing.JPanel {

    JFileChooser savefile;
    String lop = "";
    String ky = "";
    List<xuatdiem> xd = new ArrayList<xuatdiem>();
    String loai = new String();

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public pndiem() {
        initComponents();
        
        try {
            Display();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pndiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pndiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getKhoi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pndiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pndiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//hiển Thị
    List<scores> list = new ArrayList<>();

    public void Display() throws ClassNotFoundException, SQLException {
        ConnectSQL conn = new ConnectSQL();
        conn.getconnect();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm thường xuyên", "Điểm một tiết", "Điểm Thi", "Điểm Trung Bình", "Học Kỳ", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
        ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemThuongXuyen,diemMotTiet,diemThi,diemTrungBinh,hocKy,xepLoai,hanhKiem,danhHieu "
                + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop order by tenLop,tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemThuongXuyen")),
                    String.valueOf(rs.getFloat("diemMotTiet")), String.valueOf(rs.getFloat("diemThi")), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("hocKy"), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
                list.add(new scores(rs.getString("maHS"), rs.getFloat("diemThuongXuyen"), rs.getFloat("diemMotTiet"), rs.getFloat("diemThi"), rs.getString("hocKy"), rs.getString("hanhKiem")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbdiem.setModel(model);
        fixtable();

    }
//get khối

    public void getKhoi() throws ClassNotFoundException, SQLException {
        cbkhoi.addItem("10");
        cbkhoi.addItem("11");
        cbkhoi.addItem("12");
    }

//get Lớp
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
//hiển thị sinh viên theo lớp  

    public void getDSSVtheoLop() {

        String x = cblop.getSelectedItem().toString();
        String y = cbhocky.getSelectedItem().toString();
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm thường xuyên", "Điểm một tiết", "Điểm Thi", "Điểm Trung Bình", "Học Kỳ", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
        ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemThuongXuyen,diemMotTiet,diemThi,diemTrungBinh,hocKy,xepLoai,hanhKiem,danhHieu "
                + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop "
                + "where lop_infor.tenLop='" + x + "' and hocKy='" + y + "' order by tenHS,hoDem_HS");
        try {

            for (int i = 0; i < xd.size(); i++) {
                xuatdiem s = xd.get(i);
                xd.remove(s);
            }

            List<xuatdiem> xd2 = new ArrayList<xuatdiem>();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemThuongXuyen")),
                    String.valueOf(rs.getFloat("diemMotTiet")), String.valueOf(rs.getFloat("diemThi")), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("hocKy"), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
                xd2.add(new xuatdiem(rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getFloat("diemTrungBinh"), rs.getString("tenLop"), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu"), rs.getString("hocKy")));
            }
            xd = xd2;
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }

        lop = x;
        ky = y;
        tbdiem.setModel(model);
        fixtable();
    }
//hiển thị sinh viên theo mã

    public void getsinhvientheoma(String x) {
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm thường xuyên", "Điểm một tiết", "Điểm Thi", "Điểm Trung Bình", "Học Kỳ", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
        ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemThuongXuyen,diemMotTiet,diemThi,diemTrungBinh,hocKy,xepLoai,hanhKiem,danhHieu "
                + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop "
                + "where hocSinh_Scores.maHS=N'" + x + "' order by tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemThuongXuyen")),
                    String.valueOf(rs.getFloat("diemMotTiet")), String.valueOf(rs.getFloat("diemThi")), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("hocKy"), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbdiem.setModel(model);
        fixtable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmahs = new javax.swing.JTextField();
        cblop = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdiem45p = new javax.swing.JTextField();
        txtdiemthuongxuyen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbhocky = new javax.swing.JComboBox<>();
        txtdiemthi = new javax.swing.JTextField();
        btthem = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdiem = new javax.swing.JTable();
        bttim = new javax.swing.JButton();
        cbkhoi = new javax.swing.JComboBox<>();
        btthoat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbhanhkiem = new javax.swing.JComboBox<>();
        bthsg = new javax.swing.JButton();
        bthstt = new javax.swing.JButton();
        bthslb = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        btxuat = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("jMenu9");

        jMenuItem1.setText("jMenuItem1");

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("Mã học sinh");

        jLabel2.setText("Khối");

        jLabel3.setText("Lớp");

        cblop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblopActionPerformed(evt);
            }
        });

        jLabel4.setText("Điểm thường xuyên");

        jLabel5.setText("Điểm thi");

        jLabel7.setText("Điểm 45 phút");

        jLabel8.setText("Học kỳ");

        cbhocky.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I", "II" }));
        cbhocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhockyActionPerformed(evt);
            }
        });

        btthem.setText("Thêm");
        btthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemActionPerformed(evt);
            }
        });

        btsua.setText("Sửa");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm theo mã");

        tbdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbdiem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbdiem.setShowHorizontalLines(true);
        tbdiem.setShowVerticalLines(true);
        tbdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdiem);

        bttim.setText("Tìm");
        bttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimActionPerformed(evt);
            }
        });

        cbkhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkhoiActionPerformed(evt);
            }
        });

        btthoat.setText("Thoát");
        btthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthoatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("THÔNG TIN ĐIỂM");

        jButton1.setText("VIEW ALL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Hạnh Kiểm");

        cbhanhkiem.setEditable(true);
        cbhanhkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T", "K", "TB", "Y" }));

        bthsg.setText("HS Giỏi");
        bthsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthsgActionPerformed(evt);
            }
        });

        bthstt.setText("HS TT");
        bthstt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthsttActionPerformed(evt);
            }
        });

        bthslb.setText("Lưu Ban");
        bthslb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthslbActionPerformed(evt);
            }
        });

        jLabel11.setText("Danh Sách :");

        jLabel12.setText("Số Lượng :");

        btxuat.setText("Xuất File");
        btxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(419, 419, 419))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel10)
                                            .addGap(11, 11, 11)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbhocky, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(btsua, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                        .addComponent(txtmahs)
                                        .addComponent(txtdiemthi)
                                        .addComponent(cbhanhkiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtdiem45p, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(txtdiemthuongxuyen))
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbkhoi, 0, 92, Short.MAX_VALUE)
                                    .addComponent(cblop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(bttim, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(txtsoluong)
                            .addComponent(btthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bthstt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bthslb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bthsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdiem45p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(cbkhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtmahs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiemthuongxuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtdiemthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttim)
                    .addComponent(jLabel10)
                    .addComponent(cbhanhkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbhocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btsua)
                    .addComponent(btthem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bthsg)
                        .addGap(4, 4, 4)
                        .addComponent(bthstt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bthslb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(12, 12, 12)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btxuat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btthoat)
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cblopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblopActionPerformed
        txtsoluong.setText("");
        getDSSVtheoLop();
    }//GEN-LAST:event_cblopActionPerformed

    private void btthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthoatActionPerformed
        txtsoluong.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_btthoatActionPerformed

//Kiểm tra dữ liêu nhập điểm
    public boolean checkdiem(String x) {
        if (Pattern.compile("[0-9]\\.[0-9]+").matcher(x).matches() || Pattern.compile("[1][0]\\[0]").matcher(x).matches()) {
            return true;
        } else {
            return false;
        }
    }
//Sửa
    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed
        txtsoluong.setText("");
        if (txtmahs.getText().isEmpty() || txtdiemthuongxuyen.getText().isEmpty() || txtdiem45p.getText().isEmpty() || txtdiemthi.getText().isEmpty()) {
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
                Logger.getLogger(pnhocsinh.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                if (checkdiem(txtdiemthuongxuyen.getText()) && checkdiem(txtdiem45p.getText()) && checkdiem(txtdiemthi.getText())) {
                    scores x = new scores();
                    x.setMahs(txtmahs.getText());
                    x.setDiemtx(Float.valueOf(txtdiemthuongxuyen.getText()));
                    x.setDiemmt(Float.valueOf(txtdiem45p.getText()));
                    x.setDiemthi(Float.valueOf(txtdiemthi.getText()));
                    x.setHocKy(cbhocky.getSelectedItem().toString());
                    x.setHanhKiem(cbhanhkiem.getSelectedItem().toString());
                    x.setDiemtb();
                    x.setXepLoai();
                    x.setDanhHieu();
                    conn.suadiem(x);
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    getsinhvientheoma(x.getMahs());
                } else {
                    JOptionPane.showMessageDialog(this, "Điểm chỉ từ 0-10");
                }
            }

        }
    }//GEN-LAST:event_btsuaActionPerformed

//Thêm
    private void btthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemActionPerformed
        txtsoluong.setText("");
        if (txtmahs.getText().isEmpty() || txtdiemthuongxuyen.getText().isEmpty() || txtdiem45p.getText().isEmpty() || txtdiemthi.getText().isEmpty()) {
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
                Logger.getLogger(pnhocsinh.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                ResultSet rs2 = conn.getdata("select maHS,hocKy from hocSinh_Scores");
                try {
                    while (rs2.next()) {
                        if (rs2.getString(1).equals(txtmahs.getText()) && rs2.getString(2).equals(cbhocky.getSelectedItem().toString())) {
                            check = check && false;
                            break;

                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pnhocsinh.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                if (check == false) {
                    JOptionPane.showMessageDialog(this, "Học sinh này đã có điểm kỳ này Vui lòng sủa điểm nếu có thay đổi");
                } else {
                    if (checkdiem(txtdiemthuongxuyen.getText()) && checkdiem(txtdiem45p.getText()) && checkdiem(txtdiemthi.getText())) {
                        scores x = new scores();
                        x.setMahs(txtmahs.getText());
                        x.setDiemtx(Float.valueOf(txtdiemthuongxuyen.getText()));
                        x.setDiemmt(Float.valueOf(txtdiem45p.getText()));
                        x.setDiemthi(Float.valueOf(txtdiemthi.getText()));
                        x.setHocKy(cbhocky.getSelectedItem().toString());
                        x.setHanhKiem(cbhanhkiem.getSelectedItem().toString());
                        x.setDiemtb();
                        x.setXepLoai();
                        x.setDanhHieu();
                        conn.themdiem(x);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");

                    } else {
                        JOptionPane.showMessageDialog(this, "Điểm chỉ từ 0-10");
                    }
                }
            }
        }
    }//GEN-LAST:event_btthemActionPerformed

    private void cbkhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkhoiActionPerformed
        txtsoluong.setText("");
        getLop();
    }//GEN-LAST:event_cbkhoiActionPerformed
//Tìm kiếm
    private void bttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimActionPerformed
        txtsoluong.setText("");
        if (!txtma.getText().isEmpty()) {
            String x = txtma.getText();
            ConnectSQL conn = new ConnectSQL();
            try {
                conn.getconnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnhocsinh.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm thường xuyên", "Điểm một tiết", "Điểm Thi", "Điểm Trung Bình", "Học Kỳ", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
            ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemThuongXuyen,diemMotTiet,diemThi,diemTrungBinh,hocKy,xepLoai,hanhKiem,danhHieu "
                    + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                    + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop "
                    + "where hocSinh_Scores.maHS=N'" + x + "' order by tenHS,hoDem_HS");
            try {
                while (rs.next()) {
                    model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemThuongXuyen")),
                        String.valueOf(rs.getFloat("diemMotTiet")), String.valueOf(rs.getFloat("diemThi")), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("hocKy"), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có học sinh này");
            } else {
                tbdiem.setModel(model);
                fixtable();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điềm mã học sinh để tìm kiếm");
        }
    }//GEN-LAST:event_bttimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtsoluong.setText("");
        try {
            Display();
            fixtable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pndiem.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pndiem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbdiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdiemMouseClicked
        getdata();
    }//GEN-LAST:event_tbdiemMouseClicked

    private void bthsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthsgActionPerformed
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm Trung Bình", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
        ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemTrungBinh,xepLoai,hanhKiem,danhHieu "
                + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop "
                + "where danhHieu='HSG' and hocKy='" + cbhocky.getSelectedItem().toString() + "' and tenLop='" + cblop.getSelectedItem().toString() + "' order by tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        txtsoluong.setText(String.valueOf(model.getRowCount()));
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không có học sinh nào");
            model.addRow(new String[]{"", "", "", "", "", "", ""});
            tbdiem.setModel(model);
            fixtable2();
        } else {
            tbdiem.setModel(model);
            fixtable2();
        }
    }//GEN-LAST:event_bthsgActionPerformed

    private void bthsttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthsttActionPerformed
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm Trung Bình", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
        ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemTrungBinh,xepLoai,hanhKiem,danhHieu "
                + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop "
                + "where danhHieu='HSTT'and hocKy='" + cbhocky.getSelectedItem().toString() + "' and tenLop='" + cblop.getSelectedItem().toString() + "' order by tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        txtsoluong.setText(String.valueOf(model.getRowCount()));
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không có học sinh nào");
            model.addRow(new String[]{"", "", "", "", "", "", ""});
            tbdiem.setModel(model);
            fixtable2();
        } else {

            tbdiem.setModel(model);
            fixtable2();
        }
    }//GEN-LAST:event_bthsttActionPerformed

    private void bthslbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthslbActionPerformed
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Học Sinh", "Tên Học Sinh", "Lớp", "Điểm Trung Bình", "Xếp Loại", "Hạnh Kiểm", "Danh Hiệu"});
        ResultSet rs = conn.getdata("select hocSinh_Scores.maHS,hoDem_HS,tenHS,tenLop,diemTrungBinh,xepLoai,hanhKiem,danhHieu "
                + "from hocSinh_Scores inner join hocSinh_infor on hocSinh_Scores.maHS=hocSinh_infor.maHS "
                + "inner join lop_infor on hocSinh_infor.maLop=lop_infor.maLop "
                + "where danhHieu='HS Kém'and hocKy='II' and tenLop='" + cblop.getSelectedItem().toString() + "' order by tenHS,hoDem_HS");
        try {
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("maHS"), rs.getString("hoDem_HS") + " " + rs.getString("tenHS"), rs.getString("tenLop"), String.valueOf(rs.getFloat("diemTrungBinh")), rs.getString("xepLoai"), rs.getString("hanhKiem"), rs.getString("danhHieu")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        txtsoluong.setText(String.valueOf(model.getRowCount()));
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không có học sinh nào");
            model.addRow(new String[]{"", "", "", "", "", "", ""});
            tbdiem.setModel(model);
            fixtable2();
        } else {
            tbdiem.setModel(model);
            fixtable2();
        }
    }//GEN-LAST:event_bthslbActionPerformed

    //Xuất file Excel
    private void btxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxuatActionPerformed
        if (xd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn lớp học và học kỳ muốn xuất file Excel");
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
            cell.setCellValue("Điểm Trung Bình");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Xếp Loại");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Hạnh Kiểm");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Danh Hiệu");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Học Kỳ");

            int s = xd.size();

            for (int i = 0; i < s; i++) {
                xuatdiem x = xd.get(i);
                row = spreadsheet.createRow(2 + i);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(x.getMaHS());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(x.getTenHS());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(x.getLop());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(x.getDiemtb().toString());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(x.getXepLoai());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(x.getHanhKiem());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(x.getDanhHieu());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(x.getHocKy());
            }

            String filename = "Kết quả học tập lớp " + lop + "Ky" + ky + ".xlsx";
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
    }//GEN-LAST:event_btxuatActionPerformed

    private void cbhockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhockyActionPerformed
        txtsoluong.setText("");
        getDSSVtheoLop();
    }//GEN-LAST:event_cbhockyActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        if (loai.equals("hs")) {
            btsua.setEnabled(false);
            btthem.setEnabled(false);
        } 
        if (loai.equals("gv")) {
            btsua.setEnabled(true);
            btthem.setEnabled(true);
        }
    }//GEN-LAST:event_formAncestorAdded
    //Finish xuất file

//set size cho Jtable 
    public void fixtable() {

        tbdiem.setRowHeight(20);
        TableColumnModel columnModel = tbdiem.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);

    }

    public void fixtable2() {
        tbdiem.setRowHeight(20);
        TableColumnModel columnModel = tbdiem.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
    }

    public void getdata() {
        int row = tbdiem.getSelectedRow();
        for (scores i : list) {
            if (i.getMahs().equals(tbdiem.getValueAt(row, 0).toString()) && i.getHocKy().equals(tbdiem.getValueAt(row, 7))) {
                txtmahs.setText(i.getMahs());
                txtdiemthuongxuyen.setText(String.valueOf(i.getDiemtx()));
                txtdiem45p.setText(String.valueOf(i.getDiemmt()));
                txtdiemthi.setText(String.valueOf(i.getDiemthi()));
                cbhocky.setSelectedItem(i.getHocKy());
                break;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthsg;
    private javax.swing.JButton bthslb;
    private javax.swing.JButton bthstt;
    private javax.swing.JButton btsua;
    private javax.swing.JButton btthem;
    private javax.swing.JButton btthoat;
    private javax.swing.JButton bttim;
    private javax.swing.JButton btxuat;
    private javax.swing.JComboBox<String> cbhanhkiem;
    private javax.swing.JComboBox<String> cbhocky;
    private javax.swing.JComboBox<String> cbkhoi;
    private javax.swing.JComboBox<String> cblop;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbdiem;
    private javax.swing.JTextField txtdiem45p;
    private javax.swing.JTextField txtdiemthi;
    private javax.swing.JTextField txtdiemthuongxuyen;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtmahs;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
