package week4;

import java.util.*;

/* 
 * 백준 내려가기 - DP
 * https://www.acmicpc.net/problem/2096
 */

public class BOJ2096 {
	static int n;
	static int[][] max, min;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		max = new int[n][3];
		min = new int[n][3];
		for(int i=0; i<n; i++) {
			int temp1 = scanner.nextInt();
			int temp2 = scanner.nextInt();
			int temp3 = scanner.nextInt();
			max[i][0] = min[i][0] = temp1;
			max[i][1] = min[i][1] = temp2;
			max[i][2] = min[i][2] = temp3;
		}
		
		for(int i=1; i<n; i++) {
			max[i][0] += Math.max(max[i-1][0], max[i-1][1]);
			max[i][1] += Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
			max[i][2] += Math.max(max[i-1][1], max[i-1][2]);
			
			min[i][0] += Math.min(min[i-1][0], min[i-1][1]);
			min[i][1] += Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
			min[i][2] += Math.min(min[i-1][1], min[i-1][2]);
		}
		
		System.out.print(Math.max(Math.max(max[n-1][0],max[n-1][1]), max[n-1][2]) + " ");
		System.out.print(Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]));
	}
}
