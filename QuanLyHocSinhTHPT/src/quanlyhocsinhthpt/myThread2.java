
package quanlyhocsinhthpt;

import QLHSUI.dangNhapUI;
import QLHSUI.pndiem;
import QLHSUI.trangChuUI;
import QLHSmodel.ConnectSQL;


public class myThread2 extends Thread{
    ConnectSQL conn=new ConnectSQL();
    private String x;

    public String getX() {
        return x;
    }
    public myThread2(String x) {
        this.x = x;
    }
    public void setX(String x) {
        this.x = x;
    }
    @Override
    public void run()
    {
        conn. updatedata("delete from hocSinh_Scores where maHS='" + x + "'");
    }
}
