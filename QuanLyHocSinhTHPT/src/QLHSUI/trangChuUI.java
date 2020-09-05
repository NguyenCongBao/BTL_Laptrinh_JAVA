package QLHSUI;

import static QLHSUI.dangNhapUI.matkhau;
import static QLHSUI.dangNhapUI.tendn;
import object.taiKhoan;
import static quanlyhocsinhthpt.QuanLyHocSinhTHPT.tk;
import quanlyhocsinhthpt.myThread;

public class trangChuUI extends javax.swing.JFrame {
    
    public static String loaitk="";
    String x = "";//Tên tài khoản
    public void setLoaitk(String l) {
        this.loaitk = l;
    }
    pnhocsinh hs = new pnhocsinh();
    pndiem d = new pndiem();
    pnphuhuynh ph = new pnphuhuynh();
    pngiaovien gv = new pngiaovien();
    pnlop l = new pnlop();
    about a = new about();
    public void setX(String x) {
        this.x = x;
    }
    public trangChuUI() {
        initComponents();
        lbthoigian.setText(java.time.Clock.systemUTC().instant().toString());
        pn.add(l);
        pn.add(hs);
        pn.add(d);
        pn.add(ph);
        pn.add(gv);
        pn.add(qlmk);
        pn.add(a);
        qlmk.setVisible(false);
        ph.setVisible(false);
        hs.setVisible(false);
        d.setVisible(false);
        gv.setVisible(false);
        l.setVisible(false);
        a.setVisible(false);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pn = new javax.swing.JPanel();
        btgiaovien = new javax.swing.JButton();
        btlop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbtennd = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbthoigian = new javax.swing.JLabel();
        btabout = new javax.swing.JButton();
        btdangxuat = new javax.swing.JButton();
        btthemtk = new javax.swing.JButton();
        btdoimk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbloaitk = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnhocsinh = new javax.swing.JMenu();
        mnidanhsachhocsinh = new javax.swing.JMenuItem();
        mnidiem = new javax.swing.JMenuItem();
        mniPhuhuynh = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý học sinh THPT");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 0, 51));
        setName("jframeTrangchu"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pn, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 30, 1180, 590));

        btgiaovien.setText("Giáo viên");
        btgiaovien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgiaovienActionPerformed(evt);
            }
        });
        getContentPane().add(btgiaovien, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 90, -1));

        btlop.setText("Lớp học");
        btlop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlopActionPerformed(evt);
            }
        });
        getContentPane().add(btlop, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 90, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel1.setText("Người dùng đang đăng nhập: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        lbtennd.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbtennd.setText("           ");
        getContentPane().add(lbtennd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 160, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setText("Thời gian:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, -1, -1));

        lbthoigian.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbthoigian.setText("            ");
        getContentPane().add(lbthoigian, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 620, 370, -1));

        btabout.setText("About");
        btabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaboutActionPerformed(evt);
            }
        });
        getContentPane().add(btabout, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 80, -1));

        btdangxuat.setText("Đăng xuất");
        btdangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdangxuatActionPerformed(evt);
            }
        });
        getContentPane().add(btdangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, -1, -1));

        btthemtk.setText("Đăng nhập tài khoản khác");
        btthemtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemtkActionPerformed(evt);
            }
        });
        getContentPane().add(btthemtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        btdoimk.setText("Đổi MK");
        btdoimk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdoimkActionPerformed(evt);
            }
        });
        getContentPane().add(btdoimk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Loại TK:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, -1, -1));

        lbloaitk.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbloaitk.setText("                                    ");
        getContentPane().add(lbloaitk, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, 160, -1));

        mnhocsinh.setText("Học Sinh");

        mnidanhsachhocsinh.setText("Danh Sách Học Sinh");
        mnidanhsachhocsinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnidanhsachhocsinhActionPerformed(evt);
            }
        });
        mnhocsinh.add(mnidanhsachhocsinh);

        mnidiem.setText("Điểm");
        mnidiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnidiemActionPerformed(evt);
            }
        });
        mnhocsinh.add(mnidiem);

        mniPhuhuynh.setText("Phụ Huynh Học Sinh");
        mniPhuhuynh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPhuhuynhActionPerformed(evt);
            }
        });
        mnhocsinh.add(mniPhuhuynh);

        jMenuBar1.add(mnhocsinh);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnidanhsachhocsinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnidanhsachhocsinhActionPerformed
        pn.remove(hs);
        hs = new pnhocsinh();
        hs.setLoai(lbloaitk.getText().trim());
        pn.add(hs);
        hs.setVisible(true);
        ph.setVisible(false);
        qlmk.setVisible(false);
        d.setVisible(false);
        gv.setVisible(false);
        l.setVisible(false);
        a.setVisible(false);
        pn.validate();
    }//GEN-LAST:event_mnidanhsachhocsinhActionPerformed

    private void mnidiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnidiemActionPerformed
        pn.remove(d);
        d = new pndiem();
        d.setLoai(lbloaitk.getText().trim());
        pn.add(d);
        ph.setVisible(false);
        hs.setVisible(false);
        qlmk.setVisible(false);
        d.setVisible(true);
        gv.setVisible(false);
        l.setVisible(false);
        a.setVisible(false);
        pn.validate();
    }//GEN-LAST:event_mnidiemActionPerformed

    private void mniPhuhuynhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPhuhuynhActionPerformed
        pn.remove(ph);
        ph = new pnphuhuynh();
        ph.setLoai(lbloaitk.getText().trim());
        pn.add(ph);
        ph.setVisible(true);
        hs.setVisible(false);
        qlmk.setVisible(false);
        d.setVisible(false);
        gv.setVisible(false);
        l.setVisible(false);
        a.setVisible(false);
        pn.validate();
    }//GEN-LAST:event_mniPhuhuynhActionPerformed

    private void btgiaovienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgiaovienActionPerformed
        pn.remove(gv);
        gv = new pngiaovien();
        pn.add(gv);
        gv.setVisible(true);
        ph.setVisible(false);
        qlmk.setVisible(false);
        hs.setVisible(false);
        d.setVisible(false);
        l.setVisible(false);
        a.setVisible(false);
        pn.validate();
    }//GEN-LAST:event_btgiaovienActionPerformed

    private void btlopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlopActionPerformed
        pn.remove(l);
        l = new pnlop();
        pn.add(l);
        gv.setVisible(false);
        ph.setVisible(false);
        qlmk.setVisible(false);
        hs.setVisible(false);
        d.setVisible(false);
        l.setVisible(true);
        a.setVisible(false);
        pn.validate();
    }//GEN-LAST:event_btlopActionPerformed
    quanLyMatKhau qlmk = new quanLyMatKhau();
    private void btdoimkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdoimkActionPerformed
        pn.remove(qlmk);
        qlmk = new quanLyMatKhau();
        qlmk.setTentk(lbtennd.getText().trim());
        pn.add(qlmk);
        gv.setVisible(false);
        ph.setVisible(false);
        hs.setVisible(false);
        d.setVisible(false);
        l.setVisible(false);
        qlmk.setVisible(true);
        a.setVisible(false);
        pn.validate();
    }//GEN-LAST:event_btdoimkActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        lbtennd.setText(x);
        lbloaitk.setText(loaitk);
    }//GEN-LAST:event_formComponentShown

    private void btaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaboutActionPerformed
        pn.remove(a);
        a = new about();
        pn.add(a);
        gv.setVisible(false);
        ph.setVisible(false);
        hs.setVisible(false);
        d.setVisible(false);
        l.setVisible(false);
        qlmk.setVisible(false);
        a.setVisible(true);
        pn.validate();
    }//GEN-LAST:event_btaboutActionPerformed

    private void btdangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdangxuatActionPerformed
        for(taiKhoan i:tk)
        {
            if(i.getTenTK().equals(lbtennd.getText()))
            {
                tk.remove(i);
                break;
            }
        }
        this.setVisible(false);
        dangNhapUI dn=new dangNhapUI();
        dn.setTxttendn(lbtennd.getText());
        //dn.setTxtmk(dangNhapUI.matkhau);
        dn.show();
    }//GEN-LAST:event_btdangxuatActionPerformed

    private void btthemtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemtkActionPerformed
       myThread t1 = new myThread();
       t1.start();
     //  System.out.println(tk.toString());
    }//GEN-LAST:event_btthemtkActionPerformed

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
            java.util.logging.Logger.getLogger(trangChuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trangChuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trangChuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trangChuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trangChuUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btabout;
    private javax.swing.JButton btdangxuat;
    private javax.swing.JButton btdoimk;
    private javax.swing.JButton btgiaovien;
    private javax.swing.JButton btlop;
    private javax.swing.JButton btthemtk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lbloaitk;
    private javax.swing.JLabel lbtennd;
    private javax.swing.JLabel lbthoigian;
    private javax.swing.JMenu mnhocsinh;
    private javax.swing.JMenuItem mniPhuhuynh;
    private javax.swing.JMenuItem mnidanhsachhocsinh;
    private javax.swing.JMenuItem mnidiem;
    private javax.swing.JPanel pn;
    // End of variables declaration//GEN-END:variables

}
