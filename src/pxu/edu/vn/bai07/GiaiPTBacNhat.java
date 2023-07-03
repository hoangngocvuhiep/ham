package pxu.edu.vn.bai07;

import java.util.Scanner;

public class GiaiPTBacNhat {

	public static void main(String[] args) {
		System.out.println("GIAI PHUONG TRINH BAC NHAT");
		System.out.println("Nhap he so a, b là cac so thuc");
		System.out.print("a = ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		System.out.print("b = ");
		double b = sc.nextDouble();
		double x;
		if(a != 0) {
			x = -b/a;
			System.out.println("Pt co nghiem x = " + x);
		}
		else {
			if(b != 0) {
				System.out.println("Pt vo nghiem");
			}
			else {
				System.out.println("Pt vo so nghiem");
			}
		}
		System.out.println("Ket thuc chuong trinh");
	}

}
