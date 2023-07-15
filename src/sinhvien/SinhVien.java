package sinhvien;

import java.util.Scanner;

public class SinhVien {
    private String hoTen;
    private String maSV;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String maSV, double diemToan, double diemLy, double diemHoa) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap ma sinh vien: ");
        maSV = sc.nextLine();
        do {
            System.out.print("Nhap diem toan: ");
            diemToan = sc.nextDouble();
        } while (diemToan < 0 || diemToan > 10);
        do {
            System.out.print("Nhap diem ly: ");
            diemLy = sc.nextDouble();
        } while (diemLy < 0 || diemLy > 10);
        do {
            System.out.print("Nhap diem hoa: ");
            diemHoa = sc.nextDouble();
        } while (diemHoa < 0 || diemHoa > 10);

        sc.close();
    }

    public void xuat() {
        System.out.printf("Sinh vien %s co diem trung binh %f va xep loai %s.%n", hoTen, tinhDTB(),
                xepLoai());
    }

    public double tinhDTB() {
        return (diemToan + diemLy + diemHoa) / 3;
    }

    public String xepLoai() {
        double dtb = tinhDTB();

        if (dtb >= 9 && dtb <= 10) {
            return "Xuat sac";
        } else if (dtb >= 8 && dtb < 9) {
            return "Gioi";
        } else if (dtb >= 7 && dtb < 8) {
            return "Kha";
        } else if (dtb >= 6 && dtb < 7) {
            return "Trung binh kha";
        } else if (dtb >= 5 && dtb < 6) {
            return "Trung binh";
        } else if (dtb >= 0 && dtb < 5) {
            return "Yeu";
        }

        return "";
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

}
