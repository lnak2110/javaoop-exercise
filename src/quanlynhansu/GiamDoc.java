package quanlynhansu;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
    private final int luong1Ngay = 300;
    private double coPhan;

    @Override
    public void nhap(Scanner sc, CongTy congTy) {
        super.nhap(sc, congTy);

        do {
            System.out.print("Nhap co phan: ");
            coPhan = sc.nextDouble();
        } while (coPhan < 0 || coPhan > 100);
    }

    @Override
    public int tinhLuongThang() {
        return luong1Ngay * getSoNgayLam();
    }

    @Override
    public void xuat() {
        System.out.printf("Giam doc: %s - %s - SDT %s - %d ngay lam - %f%% co phan%n", maSo, hoTen,
                soDienThoai, soNgayLam, coPhan);
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    }

}
