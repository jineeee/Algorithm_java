package week2;

import java.io.*;
import java.util.*;

/*
 * 백준 벽 부수고 이동하기 - bfs
 * https://www.acmicpc.net/problem/2206
 */

class Wall{
	int x, y, wall;
	public Wall(int x, int y, int wall){
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}

public class BOJ2206 {
	static int n,m;
	static int[][] map;
	static int[][][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static Queue<Wall> queue = new LinkedList<Wall>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		m = Integer.parseInt(st[1]);
		map = new int[n][m];
		visit = new int[n][m][2];
		for(int i=0; i<n; i++) {
			st = br.readLine().split("");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		queue.offer(new Wall(0, 0, 0));
		visit[0][0][0] = 1;
		System.out.print(bfs());
	}
	
	static int bfs() {
		while(!queue.isEmpty()) {
			Wall now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nw = now.wall;
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				
				if(map[nx][ny]==0 && visit[nx][ny][nw]==0) {
					queue.offer(new Wall(nx, ny, nw));
					visit[nx][ny][nw] = visit[now.x][now.y][now.wall]+1;
				} else if(now.wall==0) {
					queue.offer(new Wall(nx, ny, 1));
					visit[nx][ny][1] = visit[now.x][now.y][now.wall]+1;
				}
			}
		}	
		if(visit[n-1][m-1][0]==0 && visit[n-1][m-1][1]==0) return -1;
		else if(visit[n-1][m-1][0]==0 && visit[n-1][m-1][1]!=0) return visit[n-1][m-1][1];
		else if(visit[n-1][m-1][0]!=0 && visit[n-1][m-1][1]==0) return visit[n-1][m-1][0];
		else return Math.min(visit[n-1][m-1][0], visit[n-1][m-1][1]);
	}
	
}
