package week6;

import java.util.Scanner;

/*
 * 백준 경로찾기 - 플로이드 알고리즘
 * https://www.acmicpc.net/problem/11403
 */

public class BOJ11403_bfs {
	static int n;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) map[i][j] = scanner.nextInt();
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][k]==1 && map[k][j]==1 && map[i][j]==0) 
						map[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==0) System.out.print(0+" ");
				else System.out.print(1+" ");
			}
			System.out.print("\n");
		}
	}
}
