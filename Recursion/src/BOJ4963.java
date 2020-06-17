

import java.util.Scanner;

/*
 * 백준 섬의 개수 - dfs
 * https://www.acmicpc.net/problem/4963
 */

public class BOJ4963 {
	static int w, h;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int cnt=0;
			w = scanner.nextInt();
			h = scanner.nextInt();
			if(w==0 && h==0) break;
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i=0; i<h; i++) 
				for(int j=0; j<w; j++)
					map[i][j] = scanner.nextInt();
			
			for(int i=0; i<h; i++) 
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && !visit[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			System.out.print(cnt + "\n");
		}
	}
	
	static int dfs(int x, int y) {
		if(x<0 || y<0 || x>=h || y>=w || map[x][y]==0 || visit[x][y]) return 0;
		else {
			visit[x][y] = true;
			return 1 + dfs(x+1, y) + dfs(x-1, y) + dfs(x, y+1) + dfs(x, y-1) +
					dfs(x-1, y-1) + dfs(x+1, y-1) + dfs(x-1, y+1) + dfs(x+1, y+1); 
		}
	}
}
