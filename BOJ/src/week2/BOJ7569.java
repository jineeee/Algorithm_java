package week2;

import java.util.*;

/*
 * 백준 토마토 - 3차원 배열, bfs
 * https://www.acmicpc.net/problem/7569
 */

public class BOJ7569 {
	static int m, n, h;
	static int[][][] box;
	static Queue<int[]> queue = new LinkedList<int[]>(); 
	static int[] dx = {0,0,0,0,-1,1};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {1,-1,0,0,0,0};
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		n = scanner.nextInt();
		h = scanner.nextInt();
		box = new int[h][n][m];
		int count = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					box[i][j][k] = scanner.nextInt();
					if(box[i][j][k]==1) queue.offer(new int[] {i,j,k});
					if(box[i][j][k]==0) count++;
				}
			}
		}
		
		if(count==0) {
			System.out.print(0);
			return;
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<6; i++) {
				int nz = now[0] + dz[i];
				int nx = now[1] + dx[i]; // 상하좌우가 변경할 때 x 좌표 
				int ny = now[2] + dy[i]; // 상하좌우가 변경할 때 y 좌표 
				
				if(nx<0 || ny<0 || nz<0 || nx>=n || ny>=m || nz>=h) continue;
				if(box[nz][nx][ny]==0) {
					queue.offer(new int[] {nz,nx,ny});
					box[nz][nx][ny] = box[now[0]][now[1]][now[2]] + 1;
				}			
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(box[i][j][k]==0) return -1;
					else max = Math.max(box[i][j][k], max);
				}
			}
		}
		return max-1;
	}

}
