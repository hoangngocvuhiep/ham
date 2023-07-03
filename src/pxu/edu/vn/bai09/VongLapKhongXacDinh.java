package pxu.edu.vn.bai09;

public class VongLapKhongXacDinh {

	public static void main(String[] args) {
		// Sinh ngay nhien 1 so thuc day chan dong trong [0,1]
		double snn = Math.random();
		int n = (int)(100*snn +1);
		System.out.println("n = " + n);
		while(n % 15 != 0) {
			snn = Math.random();
			n = (int)(100*snn + 1);
			System.out.println("n = " + n);
		}
	System.out.println("KET THUC CHUONG TRINH");
	}

}
