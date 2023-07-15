package quanlynhansu;

public class NhanVienThuong extends NhanSu {
    private final int luong1Ngay = 100;
    private TruongPhong truongPhongQuanLy;

    @Override
    public int tinhLuongThang() {
        return luong1Ngay * getSoNgayLam();
    }

    @Override
    public void xuat() {
        System.out.printf("Nhan vien thuong: %s - %s - SDT %s - %d ngay lam%n", maSo, hoTen,
                soDienThoai, soNgayLam);
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public TruongPhong getTruongPhongQuanLy() {
        return truongPhongQuanLy;
    }

    public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
        this.truongPhongQuanLy = truongPhongQuanLy;
        if (truongPhongQuanLy != null) {
            truongPhongQuanLy.getDanhSachNhanVienThuongDuoiQuyen().add(this);
        }
    }

}
