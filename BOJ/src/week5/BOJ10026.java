package week5;

import java.util.Scanner;

/*
 * 백준 적록색약 - bfs
 * https://www.acmicpc.net/problem/10026
 */

public class BOJ10026 {
	static int n, nCount, sCount;
	static boolean[][] visit1, visit2;
	static int[][] map1, map2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		visit1 = new boolean[n][n];
		visit2 = new boolean[n][n];
		map1 = new int[n][n];
		map2 = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String temp = scanner.next();
			String[] arr = temp.split("");
			for(int j=0; j<n; j++) {
				if(arr[j].equals("R")) map1[i][j] = 0;
				else if(arr[j].equals("G")) map1[i][j] = 1;
				else map1[i][j] = 2;

				if(arr[j].equals("R") || arr[j].equals("G")) map2[i][j] = 0;
				else map2[i][j] = 1;
			}
		}
		
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit1[i][j]) {
					dfs(i, j, map1[i][j]);
					nCount++;
				}
				if(!visit2[i][j]) {
					dfs2(i, j, map2[i][j]);
					sCount++;
				}
			}
		}
		System.out.println(nCount + " " + sCount);
	}
	
	static int dfs(int x, int y, int c) {
		if(x<0 || y<0 || x>=n || y>=n || visit1[x][y] || map1[x][y]!=c) return 0;
		else {
			visit1[x][y] = true;
			return 1 + dfs(x+1, y, c) + dfs(x, y+1, c) + dfs(x-1, y, c) + dfs(x, y-1, c);
		}
	}
	
	static int dfs2(int x, int y, int c) {
		if(x<0 || y<0 || x>=n || y>=n || visit2[x][y] || map2[x][y]!=c) return 0;
		else {
			visit2[x][y] = true;
			return 1 + dfs2(x+1, y, c) + dfs2(x, y+1, c) + dfs2(x-1, y, c) + dfs2(x, y-1, c);
		}
	}
	
}
