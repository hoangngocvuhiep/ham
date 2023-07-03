package pxu.edu.vn.bai08;

import java.util.Scanner;

public class BaiTap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap n");
		int n = sc.nextInt();
		if(n % 2 == 0) {
			System.out.println(n + " Là số chẵn");
		}else
			System.out.println(n + " Là số lẻ");
		
	}

}
