package pxu.edu.vn.bai08;

import java.util.Scanner;

public class LapTrinhMenu {

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
		if((ch == 'W')||(ch =='W')) {
			System.out.println("WELLCOME TO PXU");
		}
		if((ch == 'O')||(ch =='o')) {
			System.out.println("Bạn lựa chọn đặt hàng");
		}
		if((ch == 'P')||(ch =='p')) {
			System.out.println("Bạn lựa chọn thanh toán");
		}
		System.out.println("KẾT THÚC CHƯƠNG TRÌNH");
	}

}
