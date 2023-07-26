package pxu.edu.vn.doan;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
public class Mau {
	static int[] ma;
	static String[] ten;
	static int[] nam;
	static String[] tacgia;
	static int[] sluong;
	static int[] gia;
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
					ma = new int[x];
					ten = new String[x];
					nam = new int[x];
					tacgia = new String[x];
					sluong = new int[x];
					gia = new int[x];
					create(x);
					xuat();
					break;
				case "2":
					if (x > 0) {
						xuat();
						nhap();
					} else {
						System.out.println("Nhập bổ sung");
					}
					break;
				case "3":
					xuat();
					xoa();
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
				case "q":
					System.out.println("Good bye!");
					System.exit(0);
				default:
					break;
			}
		} while (key != "q");

		sc.close();

	}

	public static void displayMenu() {
		System.out.println("----------MENU----------");
		System.out.println("(1) Nhập book");
		System.out.println("(2) Nhập chỉnh sửa book");
		System.out.println("(3) Xóa book");
		System.out.println("(4) Tìm book");
		System.out.println("(5) Sắp xếp book");
		System.out.println("(q) Quit");
		System.out.println("------------------------");
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

	public static void create(int x) {
		try {
			for (int i = 0; i < x; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Sách #" + (i + 1));
				ma[i] = getCode();
				System.out.print("Tên : ");
				ten[i] = sc.nextLine();
				nam(i);
				System.out.print("Tác giả : ");
				tacgia[i] = sc.nextLine();
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
		System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s\n",
				"Mã | ", "Tên | ", "Năm | ", "Tác giả |", "Số lượng | ", "Giá");
		}

	public static void xuat() {
		in();
		for (int i = 0; i < x; i++) {
			System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s\n", ma[i], ten[i], nam[i], tacgia[i], sluong[i], gia[i]+"VNĐ");
		}
	}

	public static void showOne(int j) {
		in();
		for (int i = 0; i < n; i++) {
			if (i == j) {
				System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s\n", ma[i], ten[i], nam[i], tacgia[i], sluong[i], gia[i]+"VNĐ");
			}
		}
	}

	public static void nhap() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập mã muốn chỉnh sửa : ");
			String c = sc.nextLine();
			for (int i = 0; i < x; i++) {
				if (c.equals("" + ma[i])) {
					System.out.print("Tên : ");
					ten[i] = sc.nextLine();
					nam(i);
					System.out.print("Tác giả : ");
					tacgia[i] = sc.nextLine();
					System.out.print("Số lượng : ");
					sluong[i] = Math.abs(sc.nextInt());
					System.out.print("Giá : ");
					gia[i] = Math.abs(sc.nextInt());
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
				ma[i] = ma[i + 1];
				ten[i] = ten[i + 1];
				tacgia[i] = tacgia[i + 1];
				sluong[i] = sluong[i + 1];
				gia[i] = gia[i + 1];
			}
		}
	}

	public static void timkiem() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Nhập Tên Tìm Kiếm : ");
			String n = sc.nextLine();
			for (int i = 0; i < x; i++) {
				if (n.equals(ten[i])) {
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
				if (gia[j] > gia[j + 1]) {
					String tempTên = ten[j];
					ten[j] = ten[j + 1];
					ten[j + 1] = tempTên;

					int tempMã = ma[j];
					ma[j] = ma[j + 1];
					ma[j + 1] = tempMã;

					int tempNăm = nam[j];
					nam[j] = nam[j + 1];
					nam[j + 1] = tempNăm;

					String tempTácGiả = tacgia[j];
					tacgia[j] = tacgia[j + 1];
					tacgia[j + 1] = tempTácGiả;

					int tempSoLuong = sluong[j];
					sluong[j] = sluong[j + 1];
					sluong[j + 1] = tempSoLuong;

					int tempGiá = gia[j];
					gia[j] = gia[j + 1];
					gia[j + 1] = tempGiá;
				}
			}
		}
		System.out.println("Library after arranger");
		xuat();
	}

	public static int getCode() {
		return (int) Math.floor(Math.random() * 100000);
	}

	public static void saveFile() throws IOException {
		try {
			FileOutputStream file = new FileOutputStream("/Users/lctiendat/Documents/books.txt");
			String data = "";
			for (int i = 0; i < x; i++) {
				data += ma[i] + "," + ten[i] + "," + nam[i] + "," + tacgia[i] + "," + sluong[i] + "," + gia[i] + "\n";
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
			System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s\n" , data[0], data[1], data[2], data[3], data[4], data[5]);
		}
		scanner.close();
	}
 // nhap loi năm
	public static void nam(int i) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Năm : ");
			nam[i] = sc.nextInt();
		} while (nam[i] < 1900 || nam[i] > Year.now().getValue());
	}
}