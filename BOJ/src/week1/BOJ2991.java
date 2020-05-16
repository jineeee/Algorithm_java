package week1;

import java.util.Scanner;

public class BOJ2991 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int p = scanner.nextInt();
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int pAns=0, mAns=0, nAns=0;
		
		int temp = p%(a+b);
//		System.out.println(temp);
		if(temp<=a && temp!=0) pAns++;
		temp = p%(c+d);
//		System.out.println(temp);
		if(temp<=c && temp!=0) pAns++;
		
		temp = m%(a+b);
		if(temp<=a && temp!=0) mAns++;
		temp = m%(c+d);
		if(temp<=c && temp!=0) mAns++;
		
		temp = n%(a+b);
		if(temp<=a && temp!=0) {
			nAns++;
//			System.out.println(1);
		}
		temp = n%(c+d);
		if(temp<=c && temp!=0) {
			nAns++;
//			System.out.println(3);
		}
		
		System.out.println(pAns);
		System.out.println(mAns);
		System.out.println(nAns);
	}
}
