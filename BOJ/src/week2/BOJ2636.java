package week2;

import java.util.*;

/*
 * 백준 치즈 - bfs 중첩 실행
 * https://www.acmicpc.net/problem/2636
 */

public class BOJ2636 {
	static int n, m, initCheese, time=0, cheese;
	static int[][] map, copyMap;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visit;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static Queue<int[]> airQueue = new LinkedList<int[]>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][m];
		copyMap = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = scanner.nextInt();
				if(map[i][j]==1) initCheese++;
			}
		}
		bfs();
		System.out.println(time);
		System.out.println(cheese);
	}
	
	static void bfs() {
		while (initCheese>0) {
			cheese = initCheese;
			copy();
			outAir();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(copyMap[i][j]==1 && outCheese(i, j)) queue.offer(new int[] {i,j});
				}
			}
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				for(int i=0; i<4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					if(nx<0 || ny<0 || nx>=n || ny>=m || copyMap[nx][ny]==1) continue;
					if (copyMap[nx][ny]==2 && map[now[0]][now[1]]==1) {
						map[now[0]][now[1]] = 0;
						initCheese--;
						break;
					}
				}
			}
			time++;
		}
	}
	
	static void copy() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	
	static void outAir() {
		visit = new boolean[n][m];
		airQueue.offer(new int[] {0,0});
		visit[0][0] = true;
		while (!airQueue.isEmpty()) {
			int[] now = airQueue.poll();
			copyMap[now[0]][now[1]] = 2;
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny]==1 || visit[nx][ny]) continue;
				
				if (copyMap[nx][ny]==0 && map[now[0]][now[1]]==0) {
					airQueue.offer(new int[] {nx,ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	static boolean outCheese(int x, int y) {
		for(int i=0;i<4;i++)
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m && copyMap[x+dx[i]][y+dy[i]] == 2) 
				return true; 
		return false;
	}
}
