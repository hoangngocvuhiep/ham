package pxu.edu.vn.bai08;

import java.util.Scanner;

public class LapTrinhMenu2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------");
		System.out.println("Hiển thi lời chào (nhấn W hoặc w)");
		System.out.println("Đặt hàng (nhấn O hoặc o)");
		System.out.println("Thanh toán (nhấn P hoặc p)");
		System.out.println("-------------------------------------------");
		System.out.println("Lựa chọn: ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		switch(Character.toLowerCase(ch)) {
		case 'W':
			System.out.println("WELLCOME TO PXU");
			break;
		case 'O':
			System.out.println("Bạn đã chọn đặt hàng");
			break;
		case 'P':
			System.out.println("Bạn đã chọn thanh toán");
			break;
		default:
			System.out.println("Bạn đã không chọn menu");
		}
		System.out.println("KẾT THÚC CHƯƠNG TRÌNH");
	}

}
