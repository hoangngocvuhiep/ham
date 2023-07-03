package pxu.edu.vn.bai11;

import java.util.Scanner;

public class vd2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(" a = ");
		double a = sc.nextDouble();
		System.out.println(" b = ");
		double b = sc.nextDouble();
		System.out.println(" c = ");
		double c = sc.nextDouble();
		System.out.println(" x = ");
		double x = sc.nextDouble();
		
		System.out.println(" BIEU THUC F1 = " +tinhbieuthucf1(a, b, c, x));
		System.out.println(" BIEU THUC F2 = " +tinhbieuthucf2(x));
		System.out.println(" BIEU THUC F3 = " +tinhbieuthucf3(a, b, c, x));
		
	}
	public static double tinhbieuthucf1(double a, double b, double c, double x) {
		double result;
		result = a*x*x + b*c + c;
		return(result);
	}
	public static double tinhbieuthucf2(double x) {
		double result = 0;
		result = Math.log10(x) + 1/(Math.sqrt(Math.abs(Math.pow(x, 3) - 8)));
		return(result);
	}
	public static double tinhbieuthucf3(double a, double b, double c, double x) {
		return tinhbieuthucf1(a, b, c, x) / tinhbieuthucf2(x);
	}
}
