
package quanlyhocsinhthpt;

import QLHSUI.dangNhapUI;


public class myThread extends Thread{
    
    @Override
    public void run()
    {
       dangNhapUI dn=new dangNhapUI();
       dn.show();
    }

}
