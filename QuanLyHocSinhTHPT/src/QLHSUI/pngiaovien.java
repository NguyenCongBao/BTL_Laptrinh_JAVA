package QLHSUI;

import QLHSmodel.ConnectSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pngiaovien extends javax.swing.JPanel {

    public pngiaovien() {

        initComponents();
        try {
            Display();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pngiaovien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pngiaovien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Hiển thị
    public void Display() throws ClassNotFoundException, SQLException {
        ConnectSQL conn = new ConnectSQL();
        conn.getconnect();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Giáo Viên", "Tên Giáo Viên", "Tổ Công Tác", "Ngày Sinh", "Giới Tính", "Địa Chỉ"});

        ResultSet toct = conn.getdata("select * from giaoVien_infor order by toCongTac");

        while (toct.next()) {

            model.addRow(new String[]{toct.getString("maGV"), toct.getString("tenGV"), toct.getString("toCongTac"), toct.getString("ngaySinh_GV"),
                toct.getString("gioiTinh_GV"), toct.getString("diaChi_GV")});
        }
        tbgiaovien.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbgiaovien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtmagv = new javax.swing.JTextField();
        bttim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btvew = new javax.swing.JButton();

        tbgiaovien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbgiaovien.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(tbgiaovien);

        jLabel1.setText("Mã giáo viên");

        bttim.setText("Tìm ");
        bttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("GIÁO VIÊN TRONG TRƯỜNG");

        btvew.setText("VIEW ALL");
        btvew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmagv, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttim, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btvew, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(251, 251, 251))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmagv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bttim)
                    .addComponent(btvew))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btvewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvewActionPerformed
        try {
            Display();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pngiaovien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pngiaovien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btvewActionPerformed

    private void bttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimActionPerformed
        if (!txtmagv.getText().isEmpty()) {
            String x = txtmagv.getText();
            ConnectSQL conn = new ConnectSQL();
            try {
                conn.getconnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Mã Giáo Viên", "Tên Giáo Viên", "Tổ Công Tác", "Ngày Sinh", "Giới Tính", "Địa Chỉ"});
            ResultSet rs = conn.getdata("select * from giaoVien_infor where maGV='" + x + "'");
            try {
                while (rs.next()) {
                    model.addRow(new String[]{rs.getString("maGV"), rs.getString("tenGV"), rs.getString("toCongTac"), rs.getString("ngaySinh_GV"),
                        rs.getString("gioiTinh_GV"), rs.getString("diaChi_GV")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có giáo viên này");
            } else {
                tbgiaovien.setModel(model);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điềm mã giáo viên để tìm kiếm");
        }
    }//GEN-LAST:event_bttimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttim;
    private javax.swing.JButton btvew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbgiaovien;
    private javax.swing.JTextField txtmagv;
    // End of variables declaration//GEN-END:variables
}
