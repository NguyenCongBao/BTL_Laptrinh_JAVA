package quanlyhocsinhthpt;

import QLHSUI.dangNhapUI;
import QLHSUI.trangChuUI;
import java.util.ArrayList;
import object.taiKhoan;

public class QuanLyHocSinhTHPT {
 public static ArrayList<taiKhoan> tk = new ArrayList<taiKhoan>();
    public static void main(String[] args) {
       // dangNhapUI dn=new dangNhapUI();
       // dn.show();
        /*trangChuUI tc = new trangChuUI();
        tc.pack();
        tc.setLocationRelativeTo(null);
        tc.setVisible(true);
        tc.show();*/
        myThread t1 = new myThread();
        t1.start();
    }
}
