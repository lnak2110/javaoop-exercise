package quanlynhansu;

import java.util.HashSet;

public class TruongPhong extends NhanSu {
    private final int luong1Ngay = 200;
    private HashSet<NhanVienThuong> danhSachNhanVienThuongDuoiQuyen;

    public TruongPhong() {
        danhSachNhanVienThuongDuoiQuyen = new HashSet<>();
    }

    @Override
    public int tinhLuongThang() {
        return luong1Ngay * getSoNgayLam() + 100 * danhSachNhanVienThuongDuoiQuyen.size();
    }

    @Override
    public void xuat() {
        System.out.printf("Truong phong: %s - %s - SDT %s - %d ngay lam%n", maSo, hoTen,
                soDienThoai, soNgayLam);
    }

    public void themNhanVienThuong(NhanVienThuong nhanVienThuong) {
        danhSachNhanVienThuongDuoiQuyen.add(nhanVienThuong);
        nhanVienThuong.setTruongPhongQuanLy(this);
    }

    public void xoaNhanVienThuong(NhanVienThuong nhanVienThuong) {
        danhSachNhanVienThuongDuoiQuyen.remove(nhanVienThuong);
        nhanVienThuong.setTruongPhongQuanLy(null);
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public HashSet<NhanVienThuong> getDanhSachNhanVienThuongDuoiQuyen() {
        return danhSachNhanVienThuongDuoiQuyen;
    }

    public void setDanhSachNhanVienThuongDuoiQuyen(
            HashSet<NhanVienThuong> danhSachNhanVienThuongDuoiQuyen) {
        this.danhSachNhanVienThuongDuoiQuyen = danhSachNhanVienThuongDuoiQuyen;
    }

}
