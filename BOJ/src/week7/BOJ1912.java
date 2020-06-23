package week7;

import java.util.*;

/*
 * 백준 연속합 - DP
 * https://www.acmicpc.net/problem/1912
 */

public class BOJ1912 {
	static int n, max;
	static int[] arr, sum;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		arr = new int[n];
		sum = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
		
		max = sum[0] = arr[0];
		for(int i=1; i<n; i++) {
			sum[i] = Math.max(arr[i], sum[i-1]+arr[i]);
			max = Math.max(max, sum[i]);
		}
		System.out.print(max);
	}
}
