package baikiemtragiuaki;

import java.util.Scanner;

public class bai4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			int n;
			do {
				System.out.println("nhập n: ");
				n = sc.nextInt();
			} while (n <= 0);
			int i = n;
			while (i < 0) {
				System.out.println("Lập Trình Java");
			}
		}
	}
}
