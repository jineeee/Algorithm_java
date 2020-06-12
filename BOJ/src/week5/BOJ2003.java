package week5;

import java.util.Scanner;

/*
 * 백준 수들의 합2 - 배열 탐색
 * https://www.acmicpc.net/problem/2003
 */

public class BOJ2003 {
	static int n, m, ans;
	static int[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = scanner.nextInt();
		for(int i=0; i<n; i++) {
			int temp = 0;
			for(int j=i; j<n; j++) {
				temp += arr[j];
				if(temp==m) ans++;
			}
		}
		System.out.println(ans);
	}
}
