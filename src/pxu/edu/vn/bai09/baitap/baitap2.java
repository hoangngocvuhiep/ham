package pxu.edu.vn.bai09.baitap;

public class baitap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean flag = false;
		while(!flag) {
			int n = (int)(Math.random()*100 + 1);
			count = count + 1;
			System.out.println("n="+n );
			if(n%20==0) {
				flag = true;
			}
		}
		System.out.println("Chương trình kt sau " + count + "bước lặp");
		System.out.println("KET THUC CHUONG TRINH");
	}

}
