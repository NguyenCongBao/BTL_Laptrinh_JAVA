package QLHSUI;

import QLHSmodel.ConnectSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pnlop extends javax.swing.JPanel {

    public pnlop() {
        initComponents();
        Display();
    }

    public void Display() {
        ConnectSQL conn = new ConnectSQL();
        try {
            conn.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã lớp", "Tên lớp", "Mã giáo viên", "Số học sinh", "Năm học", "Khối"});
        ResultSet rs1 = conn.getdata("select * from lop_infor where khoi='10' order by tenLop");
        try {
            while (rs1.next()) {
                model.addRow(new String[]{rs1.getString("maLop"), rs1.getString("tenLop"), rs1.getString("maGV"), rs1.getString("soHS"),
                    rs1.getString("namHoc"), rs1.getString("khoi")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs2 = conn.getdata("select * from lop_infor where khoi='11' order by tenLop");
        try {
            while (rs2.next()) {
                model.addRow(new String[]{rs2.getString("maLop"), rs2.getString("tenLop"), rs2.getString("maGV"), rs2.getString("soHS"),
                    rs2.getString("namHoc"), rs2.getString("khoi")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs3 = conn.getdata("select * from lop_infor where khoi='12' order by tenLop");
        try {
            while (rs3.next()) {
                model.addRow(new String[]{rs3.getString("maLop"), rs3.getString("tenLop"), rs3.getString("maGV"), rs3.getString("soHS"),
                    rs3.getString("namHoc"), rs3.getString("khoi")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblop.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmaLop = new javax.swing.JTextField();
        bttim = new javax.swing.JButton();
        btview = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblop = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN LỚP");

        jLabel2.setText("Mã lớp");

        bttim.setText("Tìm");
        bttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimActionPerformed(evt);
            }
        });

        btview.setText("VIEW ALL");
        btview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btviewActionPerformed(evt);
            }
        });

        tblop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 250, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(305, 305, 305))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtmaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btview, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttim)
                    .addComponent(btview))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimActionPerformed
        if (!txtmaLop.getText().isEmpty()) {
            String x = txtmaLop.getText();
            ConnectSQL conn = new ConnectSQL();
            try {
                conn.getconnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"Mã lớp", "Tên lớp", "Mã giáo viên", "Số học sinh", "Năm học", "Khối"});
            ResultSet rs = conn.getdata("select * from lop_infor where maLop=N'" + x + "'");
            try {
                while (rs.next()) {
                    model.addRow(new String[]{rs.getString("maLop"), rs.getString("tenLop"), rs.getString("maGV"), rs.getString("soHS"),
                        rs.getString("namHoc"), rs.getString("khoi")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnhocsinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không có lớp này");
            } else {
                tblop.setModel(model);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điềm mã lớp để tìm kiếm");
        }
    }//GEN-LAST:event_bttimActionPerformed

    private void btviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btviewActionPerformed
        Display();
    }//GEN-LAST:event_btviewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttim;
    private javax.swing.JButton btview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblop;
    private javax.swing.JTextField txtmaLop;
    // End of variables declaration//GEN-END:variables

}
