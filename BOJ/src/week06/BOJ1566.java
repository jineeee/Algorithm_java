package week06;

import java.util.Scanner;

/*
 * P배열 - 실패
 * https://www.acmicpc.net/problem/1566
 */

public class BOJ1566 {
	static int n, m, ans = Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		arr = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) arr[i][j] = scanner.nextInt();
		
		int sum=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sum += arr[i][j];
			}
			if(sum<0) ans = Math.min(getResult(), ans);
			System.out.println(ans);
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				sum += arr[i][j];
			}
			if(sum<0) ans = Math.min(getResult(), ans);
			System.out.println(ans);
		}
		System.out.println(ans);
	}
	
	static int getResult() {
		int cnt = 0;
		int[][] copy = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) copy[i][j] = arr[i][j];
		while(true) {
			int row=0, col=0;
			boolean rowflag=true, colflag=true;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++)
					row += copy[i][j];
				if(row<0) {
					rowflag = false;
//					changeRow(i, cnt);
					for(int k=0; k<m; k++)
						copy[i][k] = -copy[i][k];
					cnt++;
				}
			}
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++)
					col += copy[i][j];
				if(col<0) {
					colflag = false;
//					changeCol(i, cnt);
					for(int k=0; k<n; k++)
						copy[k][i] = -copy[k][i];
					cnt++;
				}
			}
			if(rowflag && colflag) break;
		}
		return cnt;
	}
	
	static void changeRow(int idx, int cnt) {
		for(int j=0; j<m; j++)
			arr[idx][j] = -arr[idx][j];
		cnt++;
	}
	
	static void changeCol(int idx, int cnt) {
		for(int i=0; i<n; i++)
			arr[i][idx] = -arr[i][idx];
		cnt++;
	}
}
