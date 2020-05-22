package week2;

import java.util.*;

/*
 * 백준 안전영역 - dfs
 * https://www.acmicpc.net/problem/2468
 */

public class BOJ2468 {
	static int n, max = 0, count=0, answer=-1;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = scanner.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}

		for(int i=0; i<=max; i++) {
			count=0;
			visit = new boolean[n][n];
			for(int x = 0; x<n; x++) {
				for(int y = 0; y<n; y++) {
					if(map[x][y]>i && !visit[x][y]) {
						countBlob(i, x, y);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.print(answer);
	}
	
	static void countBlob(int rain, int x, int y) {

		if(x<0 || y<0 || x>=n || y>=n) return;
		else if(visit[x][y] || map[x][y]<=rain) return;
		else {
			visit[x][y] = true;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				countBlob(rain, nx, ny);
			}
		}
	}
}
