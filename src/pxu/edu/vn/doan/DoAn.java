package pxu.edu.vn.doan;

import java.util.Scanner;

public class DoAn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = nhapSoLuongSanpham();
//		System.out.println("n = " + n);
//		// Tao cac mang 1 chieu chua tensp, donvi, sluong, gban va ttien
		String[] tensp = null;
		String[] donvi = null;
		double[] sluong = null;
		double[] gban = null;
		double[] ttien = null;
//		// Goi ham nhap du lieu
//		nhapThongTinSanPham(tensp, donvi, sluong, gban);
//		// Xuat danh sach vua nhap
//		inDSSP(tensp, donvi, sluong, gban, ttien);
//		// Goi ham tinh diem trung binh
//		ttien = tinhttien(sluong, gban);
//		// Xuat danh sach vua nhap
//		inDSSV(tensp, donvi, sluong, gban, ttien);
//		// Sap xep DSSV theo DTB
//		sapxepDSSV(tensp, donvi, sluong, gban, ttien);
//		inDSSV(tensp, donvi, sluong, gban, ttien);
//		//tim kiem diem
//		timkiemDiem(tensp, donvi, sluong, gban, ttien);
		char key;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("Ban chon chuc nang nao: ");
			key = sc.next().charAt(0);
			switch(key) {
			case '1': 
				int n = nhapSoLoaiSanPham();
				tensp = new String[n];
				donvi = new String[n];
				sluong = new double[n];
				gban = new double[n];
				ttien = new double[n];
				break;
			case '2':
				ttien = tinhttien(sluong, gban);
				inDSSP(tensp, donvi, sluong, gban, ttien);
				break;
			case '3':
				inDSSP(tensp, donvi, sluong, gban, ttien);
				break;
			case '4':
				sapxepDSSP(tensp, donvi, sluong, gban, ttien);
				inDSSP(tensp, donvi, sluong, gban, ttien);
				break;
			case '5':
				timkiem(tensp, donvi, sluong, gban, ttien);
				break;
			case 'X':
				break;
			case 'x':
				break;
			}
		}while(key != 'X' || key != 'x');
	}
	
	//Ham tao menu
	public static void inMenu() {
		System.out.println("*******************************");
		System.out.println("(1): Nhap du lieu");
		System.out.println("(2): Tinh Thanh tien");
		System.out.println("(3): In danh sach San pham");
		System.out.println("(4): Sap xep theo Tien");
		System.out.println("(5): Tim kiem theo diem Toan");
		System.out.println("(X/x): Thoa khoi chuong trinh");
		System.out.println("*******************************");
	}

	// Ham nhap so luong sinh vien N nguyen duong
	public static int nhapSoLoaiSanPham() {
		try {
			int n;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Nhap so loai san pham n = ");
				n = sc.nextInt();
			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
			return -1;
		}
	}

	// Ham nhap ho ten, diem Toan, Van Anh
	public static void nhapThongTinSanPham(String[] tensp, String[] donvi, double[] sluong, double[] gban) {
		System.out.println("*************************************************************");
		try {
			for (int i = 0; i < tensp.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhap du lieu cho san pham thu " + (i + 1));
				System.out.print("Ten san pham: ");
				tensp[i] = sc.nextLine();
				System.out.print("Don vi: ");
				donvi[i] = sc.nextLine();
				System.out.print("So luong: ");
				sluong[i] = sc.nextDouble();
				System.out.print("Gia ban: ");
				gban[i] = sc.nextDouble();
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
		System.out.println("*************************************************************");
	}

	// Ham tinh diem trung binh
	public static double[] tinhttien(double[] sluong, double[] gban) {
		double[] ttien = new double[sluong.length];
		for (int i = 0; i < ttien.length; i++) {
			ttien[i] = Math.round(sluong[i] * gban[i]);
		}
		return ttien;
	}

	// Ham sap xep sinh vien theo chieu giam dan cua diem trung binh
	public static void sapxepDSSP(String[] tensp, String[] donvi, double[] sluong, double[] gban, double[] ttien) {
		for (int i = 0; i < ttien.length - 1; i++) {
			for (int j = i + 1; j < ttien.length; j++) {
				if (ttien[i] < ttien[j]) {
					// hoan vi ttien
					double tam = ttien[i];
					ttien[i] = ttien[j];
					ttien[j] = tam;
					// hoan vi sluong
					tam = sluong[i];
					sluong[i] = sluong[j];
					sluong[j] = tam;
					// hoan vi gban
					tam = gban[i];
					gban[i] = gban[j];
					gban[j] = tam;
					// hoan vi tensp
					String tam2 = tensp[i];
					tensp[i] = tensp[j];
					tensp[j] = tam2;
					// hoan vi donvi
					String tam3 = donvi[i];
					donvi[i] = donvi[j];
					donvi[j] = tam3;
				}
			}
		}
	}

	// Ham in danh sach sinh vien ra man hinh
	public static void inDSSP(String[] tensp, String[] donvi, double[] sluong, double[] gban, double[] ttien) {
		System.out.println("*************************************************************");
		System.out.println("\t\t\t DANH SACH SAN PHAM");
		for (int i = 0; i < tensp.length; i++) {
			System.out.println(tensp[i] + "; DonVi: " + donvi[i] + "; SoLuong: " + sluong[i] + "; GiaBan: " + gban[i] + "; ThanhTien: " + ttien[i]);
		}
		System.out.println("*************************************************************");
	}

	// Ham tim kiem sinh vien theo diem mon Toan
	public static void timkiem(String[] tensp, String[] donvi, double[] sluong, double[] gban, double[] ttien) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		double diemcantim;
		try {
			do {
				System.out.print("Diem Toan can tim: ");
				diemcantim = sc.nextDouble();
			}while(diemcantim < 0.0 || diemcantim > 10.0);
			
			for (int i = 0; i < gban.length; i++) {
				if (gban[i] == diemcantim) {
					System.out.println(tensp[i] + "; DonVi: " + donvi[i] + "; SoLuong: " + sluong[i] + "; GiaBan: " + gban[i] + "; ThanhTien: " + ttien[i]);
					count = count + 1;
				}
			}
			if(count == 0) {
				System.out.println("KHONG TIM THAY");
			}
		}catch(Exception e){
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}	
	}

	// Ham tim kiem sinh vien theo ho ten
	public static void timHoTen(String[] tensp, String[] donvi, double[] sluong, double[] gban, double[] ttien) {

	}
}