package week04;

import java.util.Scanner;

/*
 * 백준 그림 - dfs
 * https://www.acmicpc.net/problem/1926
 */

public class BOJ1926 {
	static int N, M, cnt=0, max=0;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					int num = dfs(i, j);
					max = Math.max(num, max);
					cnt++;
				}
			}
		}
		System.out.println(cnt + "\n" + max);
	}
	
	static int dfs(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=M || map[x][y]==0 || visit[x][y]) return 0;
		else {
			visit[x][y] = true;
			return 1 + dfs(x-1, y) + dfs(x, y+1) + dfs(x+1, y) + dfs(x, y-1);
		}
	}
}
