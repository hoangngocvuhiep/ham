package pxu.edu.vn.doan;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
public class DoAn1 {
	static int[] masp;
	static String[] tensp;
	static int[] nsx;
	static String[] donvi;
	static int[] sluong;
	static int[] gia;
	static int[] ttien;
	static int x = 0;
	public static int n;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String key = null;
		do {
			displayMenu();
			System.out.print("Nhập lựa chọn: ");
			key = sc.next();
			switch (key) {
				case "1":
					x = nhapsoluongsach();
					masp = new int[x];
					tensp = new String[x];
					nsx = new int[x];
					donvi = new String[x];
					sluong = new int[x];
					gia = new int[x];
					ttien = new int[x];
					nhap(x);
					xuat();
					break;
				case "2":
					if (x > 0) {
						xuat();
						nhapchinhsua();
					} else {
						System.out.println("Nhập bổ sung");
					}
					break;
				case "3":
					tinhttien();
					xuat();
					break;
				case "4":
					if (x > 0) {
						timkiem();
					} else {
						System.out.println("Nhập thông tin");
					}
					break;
				case "5":
					if (x > 0) {
						sapxep();
					} else {
						System.out.println("Nhập ");
					}
					break;
				case "6":
					xuat();
					xoa();
					break;
				case "t":
					System.out.println("Good bye!");
					System.exit(0);
				default:
					break;
			}
		} while (key != "t");

		sc.close();

	}

	public static void displayMenu() {
		System.out.println("|------------MENU------------|");
		System.out.println("|(1) Nhập sản phẩm           |");
		System.out.println("|(2) Nhập chỉnh sửa sản phẩm |");
		System.out.println("|(3) Tính thành tiền         |");
		System.out.println("|(4) Tìm sản phẩm            |");
		System.out.println("|(5) Sắp xếp sản phẩm        |");
		System.out.println("|(6) Xóa sản phẩm            |");
		System.out.println("|(t) Thoát                   |");
		System.out.println("|----------------------------|");
	}

	public static int nhapsoluongsach() {
		Scanner sc = new Scanner(System.in);
		try {
			int x;
			do {
				System.out.print("Nhập số lượng sách : ");
				x = sc.nextInt();
			} while (x <= 0);
			return x;
		} catch (Exception e) {
			return -1;
		}
	}

	public static void nhap(int x) {
		try {
			for (int i = 0; i < x; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("STT #" + (i + 1));
				masp[i] = getCode();
				System.out.print("Tên sản phảm : ");
				tensp[i] = sc.nextLine();
				nam(i);
				System.out.print("Đơn vi : ");
				donvi[i] = sc.nextLine();
				System.out.print("Số lượng : ");
				sluong[i] = Math.abs(sc.nextInt());
				System.out.print("Giá : ");
				gia[i] = Math.abs(sc.nextInt());
			}
			saveFile();
			readFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Enter input incorrect");
		}
	}

	public static void in() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-20s %-20s\n",
				"Mã S.Phẩm |", "Tên S.Phẩm |", "Năm S.Xuất |", "Đơn Vị |", "Số lượng |", "Giá sản phẩm |","Thành Tiền |");
		}

	public static void xuat() {
		in();
		for (int i = 0; i < x; i++) {
			System.out.printf("%-15s %-15s %-15s %-15s %-15s %-20s %-20s\n",
					masp[i], tensp[i], nsx[i], donvi[i], sluong[i], gia[i]+".000 VNĐ", ttien[i]+".000 VNĐ");
		}
	}

	public static void showOne(int j) {
		in();
		for (int i = 0; i < n; i++) {
			if (i == j) {
				System.out.printf("%-15s %-15s %-15s %-15s %-15s %-20s %-20s\n",
						masp[i], tensp[i], nsx[i], donvi[i], sluong[i], gia[i]+".000 VNĐ", ttien[i]+".000 VNĐ");
			}
		}
	}

	public static void nhapchinhsua() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập mã muốn chỉnh sửa : ");
			String c = sc.nextLine();
			for (int i = 0; i < x; i++) {
				if (c.equals("" + masp[i])) {
					System.out.print("Tên sản phảm : ");
					tensp[i] = sc.nextLine();
					nam(i);
					System.out.print("Đơn vi : ");
					donvi[i] = sc.nextLine();
					System.out.print("Số lượng : ");
					sluong[i] = Math.abs(sc.nextInt());
					System.out.print("Giá bán : ");
					gia[i] = Math.abs(sc.nextInt());
					tinhttien();
					System.out.println("Chỉnh sửa thành công");
					n = sc.nextInt();
					xuat();
					return;
				}
			}
			System.out.println("Không thể tìm thấy dữ liệu");
			sc.close();
		} catch (Exception e) {
			System.out.println("Nhập dữ liệu không chính xác");
		}
	}

	public static void xoa() {
		int i = n;
		System.out.print("Nhập mã muốn xóa : ");
		for (int n = 0; i < x; i++) {
			if (0 < n) {
				masp[i] = masp[i + 1];
				tensp[i] = tensp[i + 1];
				nsx[i] = nsx[i + 1];
				donvi[i] = donvi[i + 1];
				sluong[i] = sluong[i + 1];
				gia[i] = gia[i + 1];
				ttien[i] = ttien[i + 1];
			}
		}
	}

	public static void timkiem() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập Tên Tìm Kiếm : ");
			String n = sc.nextLine();
			for (int i = 0; i < x; i++) {
				if (n.equals(tensp[i])) {
					showOne(i);
					return;
				}
			}
			System.out.println("Không thể tìm thấy dữ liệu");
		} catch (Exception e) {
			System.out.println("Nhập dữ liệu không chính xác");
		}
	}

	public static void sapxep() {
		for (int i = 0; i < x - 1; i++) {
			for (int j = 0; j < x - i - 1; j++) {
				if (masp[j] > masp[j + 1]) {
					String tempTên = tensp[j];
					tensp[j] = tensp[j + 1];
					tensp[j + 1] = tempTên;

					int tempMã = masp[j];
					masp[j] = masp[j + 1];
					masp[j + 1] = tempMã;

					int tempNăm = nsx[j];
					nsx[j] = nsx[j + 1];
					nsx[j + 1] = tempNăm;

					String tempĐơnvi = donvi[j];
					donvi[j] = donvi[j + 1];
					donvi[j + 1] = tempĐơnvi;

					int tempSoLuong = sluong[j];
					sluong[j] = sluong[j + 1];
					sluong[j + 1] = tempSoLuong;

					int tempGiá = gia[j];
					gia[j] = gia[j + 1];
					gia[j + 1] = tempGiá;
					
					int tempThànhTien = ttien[j];
					ttien[j] = ttien[j + 1];
					ttien[j + 1] = tempThànhTien;
				}
			}
		}
		System.out.println("Cửa hàng sau khi sắp xếp");
		xuat();
	}

	public static int getCode() {
		return (int) Math.floor(Math.random() * 999);
	}

	public static void saveFile() throws IOException {
		try {
			FileOutputStream file = new FileOutputStream("/Users/lctiendat/Documents/books.txt");
			String data = "";
			for (int i = 0; i < x; i++) {
				data += masp[i] + "," + tensp[i] + "," + nsx[i] + "," + donvi[i] + "," + sluong[i] + "," + gia[i] + "," + ttien[i] +"\n";
			}
			file.write(data.getBytes());
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readFile() throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("/Users/lctiendat/Documents/books.txt");

		// Read the data from the file
		Scanner scanner = new Scanner(fileInputStream);
		in();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(",");
			System.out.printf("%-15s %-15s %-15s %-15s %-15s %-20s %-20s\n" , data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
		}
		scanner.close();
	}
	
	public static void tinhttien() {
		for (int i = 0; i < x; i++) {
			ttien[i] = Math.round(sluong[i] * gia[i]);
		}
	}
 // nhap loi năm
	public static void nam(int i) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Năm Sản Xuất : ");
			nsx[i] = sc.nextInt();
		} while (nsx[i] < 2000 || nsx[i] > Year.now().getValue());
	}
}