package week2;

import java.io.*;
import java.util.*;

/*
 * 백준 미로찾기 - bfs
 * https://www.acmicpc.net/problem/2178
 */

public class BOJ2178 {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		m = Integer.parseInt(st[1]);
		map = new int[n][m];
		visit = new boolean[n][m];

		for(int i=0; i<n; i++) {
			st = br.readLine().split("");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		queue.offer(new int[] {0,0});	
		System.out.println(bfs());
	}

	static int bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0]==n-1 && now[1]==m-1) return map[n-1][m-1];
				
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || ny<0 || nx >=n || ny>=m || map[nx][ny]==0 || visit[nx][ny]) continue;
				
				queue.offer(new int[] {nx,ny});
				visit[nx][ny] = true;
				map[nx][ny] = map[now[0]][now[1]] +1;
			}
		}
		return 0;
	}
}
