

import java.util.*;

/*
 * 백준 말이 되고픈 원숭이 - bfs
 * https://www.acmicpc.net/problem/1600
 */

class Horse{
	int x, y, cnt, k;
	public Horse(int x, int y, int cnt, int k) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.k = k;
	}
}

public class BOJ1600 {
	static int k, w, h;
	static int[][] map;
	static int[] hx = {-2,-1,1,2,2,1,-1,-2};
	static int[] hy = {-1,-2,-2,-1,1,2,2,1};
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Horse> queue = new LinkedList<Horse>(); 
	static boolean[][][] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		k = scanner.nextInt();
		w = scanner.nextInt();
		h = scanner.nextInt();
		map = new int[h][w];
		visit = new boolean[h][w][k+1];
		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++) map[i][j] = scanner.nextInt();
		queue.offer(new Horse(0, 0, 0, 0));
		visit[0][0][0] = true;
		bfs();
	}
	
	static void bfs() {
		while (!queue.isEmpty()) {
			Horse now = queue.poll();
			
			if(now.x==h-1 && now.y==w-1) {
				System.out.print(now.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny]==1 || visit[nx][ny][now.k]) continue;
				queue.offer(new Horse(nx, ny, now.cnt+1, now.k));
				visit[nx][ny][now.k] = true;
			}
			
			if(now.k==k) continue;
			
			for(int i=0; i<8; i++) {
				int nx = now.x + hx[i];
				int ny = now.y + hy[i];
				if(nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny]==1 || visit[nx][ny][now.k+1]) continue;
				queue.offer(new Horse(nx, ny, now.cnt+1, now.k+1));
				visit[nx][ny][now.k+1] = true;
			}
		}
		System.out.print(-1);
	}
}
