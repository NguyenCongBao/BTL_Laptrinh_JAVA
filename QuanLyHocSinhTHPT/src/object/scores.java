package object;

public class scores {

    private String mahs;
    private float diemtx;
    private float diemmt;
    private float diemthi;
    private float diemtb;
    private String hocKy;
    private String xepLoai;
    private String hanhKiem;

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public String getDanhHieu() {
        return danhHieu;
    }

    public void setDanhHieu() {
        switch (this.xepLoai) {
            case "G":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                        this.danhHieu = "HSG";
                        break;
                    case "TB":
                        this.danhHieu = "";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            case "K":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                        this.danhHieu = "HSTT";
                        break;
                    case "TB":
                        this.danhHieu = "";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            case "TB":
            case "Y":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                    case "TB":
                        this.danhHieu = "";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            default:
                this.danhHieu = "HS Kém";
                break;
        }
    }
    private String danhHieu;

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai() {
        if (this.diemtb >= 9) {
            this.xepLoai = "G";
        } else if (this.diemtb >= 6.5) {
            this.xepLoai = "K";
        } else if (this.diemtb >= 5) {
            this.xepLoai = "TB";
        } else if (this.diemtb >= 2) {
            this.xepLoai = "Y";
        } else {
            this.xepLoai = "Kém";
        }
    }

    public String getMahs() {
        return mahs;
    }

    public void setMahs(String mahs) {
        this.mahs = mahs;
    }

    public float getDiemtx() {
        return diemtx;
    }

    public void setDiemtx(float diemtx) {
        this.diemtx = diemtx;
    }

    public float getDiemmt() {
        return diemmt;
    }

    public void setDiemmt(float diemmt) {
        this.diemmt = diemmt;
    }

    public float getDiemthi() {
        return diemthi;
    }

    public void setDiemthi(float diemthi) {
        this.diemthi = diemthi;
    }

    public float getDiemtb() {
        return diemtb;
    }

    public void setDiemtb() {
        this.diemtb = (diemmt * 2 + diemthi * 3 + diemtx) / 6;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public scores() {
    }

    public scores(String mahs, float diemtx, float diemmt, float diemthi, String hocKy, String hanhKiem) {
        this.mahs = mahs;
        this.diemtx = diemtx;
        this.diemmt = diemmt;
        this.diemthi = diemthi;
        this.diemtb = (diemmt * 2 + diemthi * 3 + diemtx) / 6;
        this.hocKy = hocKy;
        this.hanhKiem = hanhKiem;
        if (this.diemtb >= 9) {
            this.xepLoai = "G";
        } else if (this.diemtb >= 6.5) {
            this.xepLoai = "K";
        } else if (this.diemtb >= 5) {
            this.xepLoai = "TB";
        } else if (this.diemtb >= 2) {
            this.xepLoai = "Y";
        } else {
            this.xepLoai = "Kém";
        }
        switch (this.xepLoai) {
            case "G":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                        this.danhHieu = "HSG";
                        break;
                    case "TB":
                        this.danhHieu = "HSTB";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            case "K":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                        this.danhHieu = "HSTT";
                        break;
                    case "TB":
                        this.danhHieu = "HSTB";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            case "TB":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                    case "TB":
                        this.danhHieu = "HSTB";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            case "Y":
                switch (this.hanhKiem) {
                    case "T":
                    case "K":
                    case "TB":
                        this.danhHieu = "HS Yếu";
                        break;
                    default:
                        this.danhHieu = "HS Kém";
                        break;
                }
                break;
            default:
                this.danhHieu = "HS Kém";
                break;
        }
    }

}
