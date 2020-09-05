package QLHSmodel;

import object.hocSinh_if;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.phuHuynh;
import object.scores;
import quanlyhocsinhthpt.myThread;
import quanlyhocsinhthpt.myThread2;

public class ConnectSQL {

    public Connection conn = null;
    public String sql;
    public Statement st = null;
    public PreparedStatement pst = null;
//Khởi tạo

    public ConnectSQL() {
    }
//getConnect

    public Connection getconnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Quan_Ly_Hoc_Sinh;user=sa;password=222666");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Không kết nối được");
        }
        return null;
    }

//GetData
    public ResultSet getdata(String sql) {
        ResultSet rs = null;
        try {
            conn = getconnect();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn = null;
            st = null;
        }
        return rs;
    }

//Cập nhật CSDL
    public void updatedata(String sql) {
        try {
            conn = getconnect();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn = null;
            pst = null;
        }
    }
//Thêm học sinh

    public void themHocSinh(hocSinh_if x) {
        updatedata("insert into hocSinh_infor values(N'" + x.getMahs() + "',N'" + x.getHoDem() + "',N'" + x.getTenhs() + "',N'" + x.getMaLop() + "',N'"
                + x.getNgaySinh() + "',N'" + x.getGioitinh() + "',N'" + x.getDiachi() + "',N'" + x.getDantoc() + "',N'" + x.getLienkhoa() + "')");
        updatedata("update lop_infor set soHS+=1 where maLop= N'" + x.getMaLop() + "'");
    }
//Sủa học sinh

    public void suaHocSinh(hocSinh_if x) {
        updatedata("update hocSinh_infor set hoDem_HS=N'" + x.getHoDem() + "',tenHS= N'" + x.getTenhs() + "',maLop= N'" + x.getMaLop() + "',ngaySinh_HS= N'" + x.getNgaySinh()
                + "',gioiTinh_HS= N'" + x.getGioitinh() + "',diaChi_HS= N'" + x.getDiachi() + "',danToc_HS= N'" + x.getDantoc() + "',lienKhoa= N'"
                + x.getLienkhoa() + "' where maHS=N'" + x.getMahs() + "'");
    }

//Xóa học sinh
    public void xoaHocSinh(hocSinh_if x) {
        updatedata("delete from phuHuynh_infor where maHS=N'" + x.getMahs() + "'");
        updatedata("delete from hocSinh_Scores where maHS=N'" + x.getMahs() + "'");
        updatedata("delete from hocSinh_infor where maHS=N'" + x.getMahs() + "'");
        updatedata("update lop_infor set soHS-=1 where maLop= N'" + x.getMaLop() + "'");
    }

//Thêm điểm
    public void themdiem(scores x) {
        updatedata("insert into hocSinh_Scores values(N'" + x.getMahs() + "','" + x.getDiemtx() + "','" + x.getDiemmt() + "','"
                + x.getDiemthi() + "','" + x.getDiemtb() + "','" + x.getHocKy() + "','" + x.getXepLoai() + "','" + x.getHanhKiem() + "','" + x.getDanhHieu() + "')");
    }

//Sửa điểm
    public void suadiem(scores x) {
        updatedata("update hocSinh_Scores set diemThuongXuyen='" + x.getDiemtx() + "',diemMotTiet='" + x.getDiemmt()
                + "',diemThi='" + x.getDiemthi() + "',diemTrungBinh='" + x.getDiemtb() + "',xepLoai='" + x.getXepLoai() + "',hanhKiem='" + x.getHanhKiem() +"',danhHieu='" + x.getDanhHieu()+ "' where maHS=N'" + x.getMahs() + "' and hocKy='" + x.getHocKy() + "'");
    }
//Sửa phụ huynh học sinh

    public void suaphuhuynh(phuHuynh x) {
        updatedata("update phuHuynh_infor set tenBo=N'" + x.getTenBo() + "', namSinh_Bo=N'" + x.getNamSinhBo() + "', ngheNghiep_Bo=N'" + x.getNgheNghiepBo()
                + "', tenMe=N'" + x.getTenMe() + "', namSinh_Me=N'" + x.getNamSinhMe() + "', ngheNghiep_Me=N'" + x.getNgheNghiepMe() + "',SDT_PhuHuynh=N'" + x.getSDTphuhuynh() + "' where"
                + " maHS=N'" + x.getMaHS() + "'");
    }

//Thêm phụ huynh
    public void themphuhuynh(phuHuynh x) {
        updatedata("insert into phuHuynh_infor values(N'" + x.getMaHS() + "',N'" + x.getTenBo() + "',N'" + x.getNamSinhBo() + "',N'" + x.getNgheNghiepBo()
                + "',N'" + x.getTenMe() + "',N'" + x.getNamSinhMe() + "',N'" + x.getNgheNghiepMe() + "',N'" + x.getSDTphuhuynh() + "')");
    }
}
