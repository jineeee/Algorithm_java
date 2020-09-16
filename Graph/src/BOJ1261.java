import java.io.*;
import java.util.*;

/*
 * 알고스팟 - 벽뿌시고 가는 bfs, 우선순위큐 사용
 * https://www.acmicpc.net/problem/1261
 */

public class BOJ1261 {
	static class Wall implements Comparable<Wall>{
		int x, y, wall;
		public Wall(int x, int y, int wall){
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
		@Override
		public int compareTo(Wall o) {
			return wall - o.wall;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		M = Integer.parseInt(arr[0]);
		N = Integer.parseInt(arr[1]);
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			arr = br.readLine().split("");
			for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(arr[j]);
		}
		System.out.print(bfs());
		
	}

	static int bfs() {
		PriorityQueue<Wall> queue = new PriorityQueue<Wall>();
		queue.offer(new Wall(0, 0, 0));
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			Wall wall = queue.poll();
			
			if(wall.x==N-1 && wall.y==M-1) return wall.wall;
			
			for (int i = 0; i < 4; i++) {
				int nx = wall.x + dx[i];
				int ny = wall.y + dy[i];
				
				if (!isValid(nx, ny) || visit[nx][ny]) continue;
				
				if(map[nx][ny]==1) {
					queue.offer(new Wall(nx, ny, wall.wall+1));
					visit[nx][ny] = true;
				}else {
					queue.offer(new Wall(nx, ny, wall.wall));
					visit[nx][ny] = true;
				}
			}
		}
		return 0;
	}
	
	static boolean isValid(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}
