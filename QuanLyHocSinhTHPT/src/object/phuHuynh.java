
package object;

public class phuHuynh {
    private String maHS;
    private String tenBo;
    private String tenMe;
    private String namSinhBo;

    public phuHuynh(String maHS, String tenBo, String tenMe, String namSinhBo, String namSinhMe, String ngheNghiepBo, String ngheNghiepMe, String SDTphuhuynh) {
        this.maHS = maHS;
        this.tenBo = tenBo;
        this.tenMe = tenMe;
        this.namSinhBo = namSinhBo;
        this.namSinhMe = namSinhMe;
        this.ngheNghiepBo = ngheNghiepBo;
        this.ngheNghiepMe = ngheNghiepMe;
        this.SDTphuhuynh = SDTphuhuynh;
    }
    private String namSinhMe;
    private String ngheNghiepBo;
    private String ngheNghiepMe;
    private String SDTphuhuynh;
    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getTenBo() {
        return tenBo;
    }

    public void setTenBo(String tenBo) {
        this.tenBo = tenBo;
    }

    public String getTenMe() {
        return tenMe;
    }

    public void setTenMe(String tenMe) {
        this.tenMe = tenMe;
    }

    public String getNamSinhBo() {
        return namSinhBo;
    }

    public void setNamSinhBo(String namSinhBo) {
        this.namSinhBo = namSinhBo;
    }

    public String getNamSinhMe() {
        return namSinhMe;
    }

    public void setNamSinhMe(String namSinhMe) {
        this.namSinhMe = namSinhMe;
    }

    public String getNgheNghiepBo() {
        return ngheNghiepBo;
    }

    public void setNgheNghiepBo(String ngheNghiepBo) {
        this.ngheNghiepBo = ngheNghiepBo;
    }

    public String getNgheNghiepMe() {
        return ngheNghiepMe;
    }

    public void setNgheNghiepMe(String ngheNghiepMe) {
        this.ngheNghiepMe = ngheNghiepMe;
    }

    public String getSDTphuhuynh() {
        return SDTphuhuynh;
    }

    public void setSDTphuhuynh(String SDTphuhuynh) {
        this.SDTphuhuynh = SDTphuhuynh;
    }

    public phuHuynh() {
    }
}
