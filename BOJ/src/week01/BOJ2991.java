package week01;

import java.util.Scanner;

/*
 * 백준 사나운 개 - 경우의 수를 나눠 계산
 * https://www.acmicpc.net/problem/2991
 */

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
		if(temp<=a && temp!=0) pAns++;
		temp = p%(c+d);
		if(temp<=c && temp!=0) pAns++;
		
		temp = m%(a+b);
		if(temp<=a && temp!=0) mAns++;
		temp = m%(c+d);
		if(temp<=c && temp!=0) mAns++;
		
		temp = n%(a+b);
		if(temp<=a && temp!=0) nAns++;
		temp = n%(c+d);
		if(temp<=c && temp!=0) nAns++;
		
		System.out.println(pAns);
		System.out.println(mAns);
		System.out.println(nAns);
	}
}
