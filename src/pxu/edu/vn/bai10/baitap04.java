package pxu.edu.vn.bai10;

import java.util.Scanner;

public class baitap04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("n = ");
		Scanner sc = new Scanner(System.in);
		try {
			int n = sc.nextInt();
			n = Math.abs(n);
			while(n > 0) {
				System.out.println("HELLO");
				n = n - 1;
			}
		}catch(Excaption e) {
			System.out.println("LỖI NHẬP DỮ LIỄU");
		}
	System.out.println("KẾT THÚC");
	}

}
