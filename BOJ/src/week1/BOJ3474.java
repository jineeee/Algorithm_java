package week1;

import java.util.Scanner;

/*
 * 백준 현우 - 소인수분해
 * https://www.acmicpc.net/problem/3474
 */

public class BOJ3474 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T-->0) {
			int n = scanner.nextInt();
			long count = 0;
			for(int i=5; i<=n; i*=5) {
				count += n/i;
			}
			System.out.println(count);
		}	
	}
	
	static long factorial(int n) {
		if(n<=1) return n;
		else return factorial(n-1)*n;
	}
}
