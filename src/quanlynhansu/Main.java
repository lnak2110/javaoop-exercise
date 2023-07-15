package quanlynhansu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CongTy ct = new CongTy();
        hienThiChucNang(sc, ct);

        sc.close();
    }

    private static void hienThiChucNang(Scanner sc, CongTy congTy) {
        while (true) {
            final String[][] bangChucNang = new String[13][];
            bangChucNang[0] = new String[] { "Thoat chuong trinh" };
            bangChucNang[1] = new String[] { "Nhap thong tin cong ty" };
            bangChucNang[2] = new String[] { "Phan bo nhan vien thuong cho truong phong" };
            bangChucNang[3] = new String[] { "Them thong tin mot nhan su" };
            bangChucNang[4] = new String[] { "Xoa thong tin mot nhan su" };
            bangChucNang[5] = new String[] { "Xuat thong tin toan bo nguoi trong cong ty" };
            bangChucNang[6] = new String[] { "Tinh va xuat tong luong cho toan cong ty" };
            bangChucNang[7] = new String[] { "Tim nhan vien thuong co luong cao nhat" };
            bangChucNang[8] = new String[] {
                    "Tim truong phong co so luong nhan vien thuong duoi quyen nhieu nhat" };
            bangChucNang[9] = new String[] { "Sap xep nhan vien toan cong ty theo thu tu abc" };
            bangChucNang[10] = new String[] {
                    "Sap xep nhan vien toan cong ty theo thu tu luong giam dan" };
            bangChucNang[11] = new String[] { "Tim giam doc co so co phan nhieu nhat" };
            bangChucNang[12] = new String[] { "Tinh va xuat tong thu nhap cua tung giam doc" };

            System.out.printf("%-15s%-15s%n", "SO", "CHUC NANG");
            for (int i = 0; i < bangChucNang.length; i++) {
                System.out.printf("%-15d%-15s%n", i, bangChucNang[i][0]);
            }

            int so = 0;
            do {
                System.out.print("Nhap so tuong ung voi chuc nang o bang tren: ");
                so = sc.nextInt();
            } while (so < 0 || so > 12);
            sc.nextLine();

            switch (so) {
            case 0:
                return;
            case 1:
                congTy.nhap(sc);
                break;
            case 2:
                congTy.phanBoNhanVienThuongChoTruongPhong(sc);
                break;
            case 3:
                congTy.themNhanSu(sc, congTy);
                break;
            case 4:
                congTy.xoaNhanSu(sc);
                break;
            case 5:
                congTy.xuatThongTinMoiNguoi();
                break;
            case 6:
                System.out.println("Tong luong toan cong ty: " + congTy.tinhTongLuong());
                break;
            case 7:
                congTy.timNhanVienThuongCoLuongCaoNhat();
                break;
            case 8:
                congTy.timTruongPhongCoNhieuNVTNhat();
                break;
            case 9:
                congTy.sapXepToanNhanVienTheoTenABC();
                break;
            case 10:
                congTy.sapXepToanNhanVienTheoLuongGiamDan();
                break;
            case 11:
                congTy.timGiamDocCoCoPhanNhieuNhat();
                break;
            case 12:
                congTy.xuatTongThuNhapTungGiamDoc();
                break;

            default:
                break;
            }
        }
    }
}
