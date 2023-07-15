package quanlynhansu;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CongTy {
    private String ten;
    private String maSoThue;
    private double doanhThuThang;
    private HashSet<GiamDoc> danhSachGiamDoc;
    private HashSet<TruongPhong> danhSachTruongPhong;
    private HashSet<NhanVienThuong> danhSachNhanVienThuong;

    public CongTy() {
        danhSachGiamDoc = new HashSet<>();
        danhSachTruongPhong = new HashSet<>();
        danhSachNhanVienThuong = new HashSet<>();
    }

    public CongTy(String ten, String maSoThue, double doanhThuThang) {
        this.ten = ten;
        this.maSoThue = maSoThue;
        this.doanhThuThang = doanhThuThang;
    }

    public HashSet<NhanSu> tongHopDanhSachNhanSu() {
        HashSet<NhanSu> danhSachToanNhanVien = new HashSet<>();
        danhSachToanNhanVien.addAll(danhSachGiamDoc);
        danhSachToanNhanVien.addAll(danhSachTruongPhong);
        danhSachToanNhanVien.addAll(danhSachNhanVienThuong);
        return danhSachToanNhanVien;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ten cong ty: ");
        ten = sc.nextLine();
        System.out.print("Nhap ma so thue: ");
        maSoThue = sc.nextLine();
        System.out.print("Nhap doanh thu thang: ");
        doanhThuThang = sc.nextDouble();
    }

    public void phanBoNhanVienThuongChoTruongPhong(Scanner sc) {
        System.out.print("Nhap ma so truong phong: ");
        String maSoTP = sc.nextLine();

        for (TruongPhong truongPhong : danhSachTruongPhong) {
            if (maSoTP.equals(truongPhong.getMaSo())) {
                System.out.print("Nhap ma so nhan vien thuong: ");
                String maSoNV = sc.nextLine();
                for (NhanVienThuong nhanVienThuong : danhSachNhanVienThuong) {
                    if (maSoNV.equals(nhanVienThuong.getMaSo())) {
                        truongPhong.themNhanVienThuong(nhanVienThuong);
                        return;
                    }
                }

                System.out.println("Khong co nhan vien thuong voi ma " + maSoNV);
                return;
            }
        }

        System.out.println("Khong co truong phong voi ma " + maSoTP);
        return;
    }

    public void themNhanSu(Scanner sc, CongTy congTy) {
        int so;
        do {
            System.out.print("Nhap so 1/2/3 de them mot nhan vien thuong/truong phong/giam doc: ");
            so = sc.nextInt();
        } while (so < 1 || so > 3);
        sc.nextLine();

        NhanSu nhanSuMoi;
        switch (so) {
        case 1:
            nhanSuMoi = new NhanVienThuong();
            nhanSuMoi.nhap(sc, congTy);
            danhSachNhanVienThuong.add((NhanVienThuong) nhanSuMoi);
            break;
        case 2:
            nhanSuMoi = new TruongPhong();
            nhanSuMoi.nhap(sc, congTy);
            danhSachTruongPhong.add((TruongPhong) nhanSuMoi);
            break;
        case 3:
            nhanSuMoi = new GiamDoc();
            nhanSuMoi.nhap(sc, congTy);
            danhSachGiamDoc.add((GiamDoc) nhanSuMoi);
            break;
        default:
            break;
        }
    }

    public void xoaNhanSu(Scanner sc) {
        int so;
        do {
            System.out.print("Nhap so 1/2/3 de xoa mot nhan vien thuong/truong phong/giam doc: ");
            so = sc.nextInt();
        } while (so < 1 || so > 3);
        sc.nextLine();

        System.out.print("Nhap ma so can xoa: ");
        String maSo = sc.nextLine();

        switch (so) {
        case 1:
            for (NhanVienThuong nhanVienThuong : danhSachNhanVienThuong) {
                if (maSo.equals(nhanVienThuong.getMaSo())) {
                    nhanVienThuong.getTruongPhongQuanLy().xoaNhanVienThuong(nhanVienThuong);
                    danhSachNhanVienThuong.remove(nhanVienThuong);
                    System.out.println("Da xoa nhan vien thuong voi ma " + maSo);
                    return;
                }
            }
            System.out.println("Khong co nhan vien thuong voi ma " + maSo);
            break;
        case 2:
            for (TruongPhong truongPhong : danhSachTruongPhong) {
                if (maSo.equals(truongPhong.getMaSo())) {
                    for (Iterator<NhanVienThuong> iterator = truongPhong
                            .getDanhSachNhanVienThuongDuoiQuyen().iterator(); iterator.hasNext();) {
                        iterator.next();
                        iterator.remove();
                    }
                    danhSachTruongPhong.remove(truongPhong);
                    System.out.println("Da xoa truong phong voi ma " + maSo);
                    return;
                }
            }
            System.out.println("Khong co truong phong voi ma " + maSo);
            break;
        case 3:
            for (GiamDoc giamDoc : danhSachGiamDoc) {
                if (maSo.equals(giamDoc.getMaSo())) {
                    danhSachGiamDoc.remove(giamDoc);
                    System.out.println("Da xoa giam doc voi ma " + maSo);
                    return;
                }
            }
            System.out.println("Khong co giam doc voi ma " + maSo);
            break;
        default:
            break;
        }
    }

    public void xuatThongTinMoiNguoi() {
        for (GiamDoc giamDoc : danhSachGiamDoc) {
            giamDoc.xuat();
        }
        for (TruongPhong truongPhong : danhSachTruongPhong) {
            truongPhong.xuat();
        }
        for (NhanVienThuong nhanVienThuong : danhSachNhanVienThuong) {
            nhanVienThuong.xuat();
        }
    }

    public double tinhTongLuong() {
        int tongLuong = 0;
        for (GiamDoc giamDoc : danhSachGiamDoc) {
            tongLuong += giamDoc.tinhLuongThang();
        }
        for (TruongPhong truongPhong : danhSachTruongPhong) {
            tongLuong += truongPhong.tinhLuongThang();
        }
        for (NhanVienThuong nhanVienThuong : danhSachNhanVienThuong) {
            tongLuong += nhanVienThuong.tinhLuongThang();
        }
        return tongLuong;
    }

    public void timNhanVienThuongCoLuongCaoNhat() {
        if (danhSachNhanVienThuong.size() != 0) {
            int luongCaoNhat = 0;
            NhanVienThuong nvtLuongCaoNhat = null;
            for (NhanVienThuong nhanVienThuong : danhSachNhanVienThuong) {
                luongCaoNhat = nhanVienThuong.tinhLuongThang();
                nvtLuongCaoNhat = nhanVienThuong;
                break;
            }
            for (NhanVienThuong nhanVienThuong : danhSachNhanVienThuong) {
                luongCaoNhat = Math.max(luongCaoNhat, nhanVienThuong.tinhLuongThang());
                nvtLuongCaoNhat = nhanVienThuong;
                break;
            }
            System.out.printf("Nhan vien thuong co luong cao nhat: %s - %s - Luong %d%n",
                    nvtLuongCaoNhat.getMaSo(), nvtLuongCaoNhat.getHoTen(), luongCaoNhat);
        }
    }

    public void timTruongPhongCoNhieuNVTNhat() {
        if (danhSachTruongPhong.size() != 0) {
            int soLuongNVTNhieuNhat = 0;
            TruongPhong truongPhongNhieuNVTNhat = null;
            for (TruongPhong truongPhong : danhSachTruongPhong) {
                soLuongNVTNhieuNhat = truongPhong.getDanhSachNhanVienThuongDuoiQuyen().size();
                truongPhongNhieuNVTNhat = truongPhong;
                break;
            }
            for (TruongPhong truongPhong : danhSachTruongPhong) {
                soLuongNVTNhieuNhat = Math.max(soLuongNVTNhieuNhat,
                        truongPhong.getDanhSachNhanVienThuongDuoiQuyen().size());
                truongPhongNhieuNVTNhat = truongPhong;
                break;
            }
            System.out.printf(
                    "Truong phong co so luong nhan vien thuong nhieu nhat: %s - %s - %d nhan vien%n",
                    truongPhongNhieuNVTNhat.getMaSo(), truongPhongNhieuNVTNhat.getHoTen(),
                    soLuongNVTNhieuNhat);
        }
    }

    public void sapXepToanNhanVienTheoTenABC() {
        List<NhanSu> danhSachToanNhanVienDaSapXep = tongHopDanhSachNhanSu().stream()
                .sorted(Comparator.comparing(NhanSu::getHoTen)).collect(Collectors.toList());
        String loaiNhanVien = "";
        for (NhanSu nhanSu : danhSachToanNhanVienDaSapXep) {
            if (nhanSu instanceof GiamDoc) {
                loaiNhanVien = "Giam doc";
            } else if (nhanSu instanceof TruongPhong) {
                loaiNhanVien = "Truong phong";

            } else if (nhanSu instanceof NhanVienThuong) {
                loaiNhanVien = "Nhan vien thuong";
            }
            System.out.printf("%s: %s - %s%n", loaiNhanVien, nhanSu.maSo, nhanSu.hoTen);
        }
    }

    public void sapXepToanNhanVienTheoLuongGiamDan() {
        List<NhanSu> danhSachToanNhanVienDaSapXep = tongHopDanhSachNhanSu().stream()
                .sorted(Comparator.comparing(NhanSu::tinhLuongThang).reversed())
                .collect(Collectors.toList());
        String loaiNhanVien = "";
        for (NhanSu nhanSu : danhSachToanNhanVienDaSapXep) {
            if (nhanSu instanceof GiamDoc) {
                loaiNhanVien = "Giam doc";
            } else if (nhanSu instanceof TruongPhong) {
                loaiNhanVien = "Truong phong";

            } else if (nhanSu instanceof NhanVienThuong) {
                loaiNhanVien = "Nhan vien thuong";
            }
            System.out.printf("%s: %s - %s - Luong %d%n", loaiNhanVien, nhanSu.maSo, nhanSu.hoTen,
                    nhanSu.tinhLuongThang());
        }
    }

    public void timGiamDocCoCoPhanNhieuNhat() {
        if (danhSachGiamDoc.size() != 0) {
            double coPhanNhieuNhat = 0;
            GiamDoc giamDocCoPhanNhieuNhat = null;
            for (GiamDoc giamDoc : danhSachGiamDoc) {
                coPhanNhieuNhat = giamDoc.getCoPhan();
                giamDocCoPhanNhieuNhat = giamDoc;
                break;
            }
            for (GiamDoc giamDoc : danhSachGiamDoc) {
                coPhanNhieuNhat = Math.max(coPhanNhieuNhat, giamDoc.getCoPhan());
                giamDocCoPhanNhieuNhat = giamDoc;
                break;
            }
            System.out.printf("Giam doc co co phan nhieu nhat: %s - %s - %f%% co phan%n",
                    giamDocCoPhanNhieuNhat.getMaSo(), giamDocCoPhanNhieuNhat.getHoTen(),
                    coPhanNhieuNhat);
        }
    }

    public void xuatTongThuNhapTungGiamDoc() {
        double loiNhuan = doanhThuThang - tinhTongLuong();
        for (GiamDoc giamDoc : danhSachGiamDoc) {
            double thuNhap = giamDoc.tinhLuongThang() + giamDoc.getCoPhan() * loiNhuan;
            System.out.printf("Giam doc: %s - %s - %f%% co phan - Thu nhap %f%n", giamDoc.getMaSo(),
                    giamDoc.getHoTen(), giamDoc.getCoPhan(), thuNhap);
        }
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    public HashSet<GiamDoc> getDanhSachGiamDoc() {
        return danhSachGiamDoc;
    }

    public void setDanhSachGiamDoc(HashSet<GiamDoc> danhSachGiamDoc) {
        this.danhSachGiamDoc = danhSachGiamDoc;
    }

    public HashSet<TruongPhong> getDanhSachTruongPhong() {
        return danhSachTruongPhong;
    }

    public void setDanhSachTruongPhong(HashSet<TruongPhong> danhSachTruongPhong) {
        this.danhSachTruongPhong = danhSachTruongPhong;
    }

    public HashSet<NhanVienThuong> getDanhSachnNhanVienThuong() {
        return danhSachNhanVienThuong;
    }

    public void setDanhSachNhanVienThuong(HashSet<NhanVienThuong> danhSachNhanVienThuong) {
        this.danhSachNhanVienThuong = danhSachNhanVienThuong;
    }

}
