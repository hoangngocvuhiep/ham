package pxu.edu.vn.bai09.baitap;

public class BaiTap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int n = (int) (Math.random() * 100 + 1);
		count = count + 1;
		System.out.println("n = " + n);
		while (n % 20 != 0) {
			n = (int) (Math.random() * 100 + 1);
			count = count + 1;
			System.out.println("n = " + n);
		}
		System.out.println("Chương trình ket thuc sau " + count );
		System.out.println("Kết Thúc");
	}

}
