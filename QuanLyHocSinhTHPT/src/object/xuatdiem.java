package object;

public class xuatdiem {

    private String maHS;
    private String tenHS;
    private Float diemtb;
    private String lop;
    private String xepLoai;
    private String hanhKiem;
    private String danhHieu;
    private String hocKy;

    public xuatdiem() {
    }

    public xuatdiem(String maHS, String tenHS, Float diemtb, String lop, String xepLoai, String hanhKiem, String danhHieu, String hocky) {
        this.maHS = maHS;
        this.tenHS = tenHS;
        this.diemtb = diemtb;
        this.lop = lop;
        this.xepLoai = xepLoai;
        this.hanhKiem = hanhKiem;
        this.danhHieu = danhHieu;
        this.hocKy=hocky;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public Float getDiemtb() {
        return diemtb;
    }

    public void setDiemtb(Float diemtb) {
        this.diemtb = diemtb;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public String getDanhHieu() {
        return danhHieu;
    }

    public void setDanhHieu(String danhHieu) {
        this.danhHieu = danhHieu;
    }
}
