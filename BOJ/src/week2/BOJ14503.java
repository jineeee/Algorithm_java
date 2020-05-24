package week2;

import java.util.*;

/* 백준 로봇청소기 - bfs
 * https://www.acmicpc.net/problem/14503
 */

class Cleaner{
	int x, y, z;
	public Cleaner(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class BOJ14503 {
	static int n, m, clDir;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] dir = {1,2,0,3};
	static Cleaner cleaner;
	static Queue<Cleaner> queue = new LinkedList<Cleaner>();
	static Set<Cleaner> result = new HashSet<Cleaner>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][m];
		cleaner = new Cleaner(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		queue.offer(cleaner);
		map[cleaner.x][cleaner.y] = 2;
		bfs();
		System.out.print(getAns());
	}
	
	static void bfs() {
		while (!queue.isEmpty()) {
			boolean flag = false;
			Cleaner now = queue.poll();
			result.add(new Cleaner(now.x, now.y, 0));
			System.out.println("now ->" + now.x + " " + now.y + " " + now.z);
			int nx, ny, nz;
			
			for(int i=0; i<4; i++) {
				nx = now.x+dx[dir[now.z]];
				ny = now.y+dy[dir[now.z]];
				nz = (now.z+3)%4;
				System.out.println("next -> " + nx + " " + ny + " " + nz);
				Cleaner next = new Cleaner(nx, ny, nz);
				
				if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny]==1 || map[nx][ny]==2) {
					now.z = nz;
					continue;
				}
				else {
					map[nx][ny] = 2; // 청소한 칸은 2
					queue.offer(next);
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int temp = (now.z+3)%4;
//				System.out.println(temp);
				nx = now.x+dx[dir[temp]];
				ny = now.y+dy[dir[temp]];
				nz = now.z;
				System.out.println("back -> " + nx + " " + ny + " " + nz);
				if(map[nx][ny]!=1) {
					map[nx][nz] = 2;
					
					queue.offer(new Cleaner(nx, ny, nz));
				}
				
			}
		}
	}
	
	static int getAns() {
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==2) ans++;
			}
		}
		return ans;
	}
}
