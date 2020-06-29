import java.util.*;

/*
 * 백준 미세먼지 안녕! - bfs, 시계/반시계 방향으로 배열 이동
 * https://www.acmicpc.net/problem/17144
 */

public class BOJ17144 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] ccw = { 2, 0, 3, 1 }; // 반시계(counter-clockwise)
	static int[] cw = { 2, 1, 3, 0 }; // 시계(clockwise)
	static int r,c,t;
	static int[][] map, copyMap;
	static Queue<Night> queue = new LinkedList<Night>();
	static List<Night> list = new ArrayList<Night>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		r = scanner.nextInt();
		c = scanner.nextInt();
		t = scanner.nextInt();
		map = new int[r][c];
		copyMap = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] = scanner.nextInt();
				if(map[i][j]==-1) list.add(new Night(i,j));
			}
		}
		bfs();
		System.out.print(getAns());
	}
	
	static void bfs() {
		for(int k=0; k<t; k++) {
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++)  {
					copyMap[i][j] = map[i][j];
					if(map[i][j]>4) queue.offer(new Night(i, j));
				}
			}

			while(!queue.isEmpty()) {
				Night now = queue.poll();
				int dust = copyMap[now.x][now.y]/5;
				int sum = 0;
				for(int i=0; i<4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
				
					if(nx<0 || ny<0 || nx>=r || ny >=c || map[nx][ny]==-1) continue;
					map[nx][ny] += dust;
					sum += dust;
				}
				map[now.x][now.y] -= sum;
			}
			copyMap();
			cleanAir(list.get(0).x, list.get(0).y, ccw);
			cleanAir(list.get(1).x, list.get(1).y, cw);

		}
	}
	
	static void cleanAir(int cleanerX, int cleanerY, int[] direction) {
		int x = cleanerX; //2
		int y = cleanerY+1; //0+1
		map[x][y] = 0;
		for (int k = 0; k < 4; k++) {
			while (true) {
		        int nx = x + dx[direction[k]];
		        int ny = y + dy[direction[k]];

		        if (0>ny || ny>=c || 0>nx || nx>=r) break;
		        if (cleanerY == ny && cleanerX == nx) break;
		        map[nx][ny] = copyMap[x][y];
		        y = ny;
		        x = nx;
		     }
		}
	}
	static void copyMap() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	static int getAns() {
		int ans = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]>0) ans += map[i][j];
			}
		}
		return ans;
	}
}
