package pxu.edu.vn.bai08;

import java.util.Scanner;

public class BaiTap3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("nhap a,b");
		System.out.print("a = ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		System.out.print("b = ");
		double b = sc.nextDouble();
		if(a < b) {
			System.out.println(Math.min(a,b));
		}
		System.out.println("Ket thuc chuong trinh");
	}

}
