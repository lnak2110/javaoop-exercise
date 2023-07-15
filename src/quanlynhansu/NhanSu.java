package quanlynhansu;

import java.util.Scanner;

public abstract class NhanSu {
    protected String maSo;
    protected String hoTen;
    protected String soDienThoai;
    protected int soNgayLam;

    public NhanSu() {
    }

    public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLam) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLam = soNgayLam;
    }

    public abstract int tinhLuongThang();

    public abstract void xuat();

    public void nhap(Scanner sc, CongTy congTy) {
        checkexist: while (true) {
            System.out.print("Nhap ma so: ");
            maSo = sc.nextLine();

            for (NhanSu nhanSu : congTy.tongHopDanhSachNhanSu()) {
                if (nhanSu.maSo.equals(maSo)) {
                    System.out.println("Ma so da ton tai");
                    continue checkexist;
                }
            }

            break;
        }
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.nextLine();
        do {
            System.out.print("Nhap so ngay lam: ");
            soNgayLam = sc.nextInt();
        } while (soNgayLam < 0 || soNgayLam > 31);
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }
}
