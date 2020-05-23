import java.util.*;

public class BOJ17144 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int[] ccw = { 2, 0, 3, 1 }; // 반시계(counter-clockwise)
	static int[] cw = { 2, 1, 3, 0 }; // 시계(clockwise)
	static int r,c,t;
	static int[][] map, copyMap;
	static Queue<Point> queue = new LinkedList<Point>();
	static List<Point> list = new ArrayList<Point>();

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
				if(map[i][j]==-1) list.add(new Point(j,i));
			}
		}
//		System.out.println("------------------");
		bfs();
//		System.out.println("------------------");
//		for(int i=0; i<r; i++) {
//			for(int j=0; j<c; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
	}
	
	static void bfs() {
		for(int k=0; k<t; k++) {
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(map[i][j]>4) queue.offer(new Point(i, j));
				}
			}

			while(!queue.isEmpty()) {
				Point now = queue.poll();
//				System.out.println(now.x + " " + now.y);
				int dust = map[now.x][now.y]/5;
//				System.out.println(dust);
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
			System.out.println("---------------------");
				for(int i=0; i<r; i++) {
					for(int j=0; j<c; j++) {
						System.out.print(map[i][j] + " ");
					}System.out.println();
				}
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			cleanAir(list.get(0).y, list.get(0).x, ccw);
			cleanAir(list.get(1).y, list.get(1).x, cw);
//			System.out.println("------------------");
//			for(int i=0; i<r; i++) {
//				for(int j=0; j<c; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}
		}
	}
	
	static void cleanAir(int cleanerX, int cleanerY, int[] direction) {
		int x = cleanerX+1; //2
		int y = cleanerY; //0+1
		map[y][x] = 0;
		for (int k = 0; k < 4; k++) {
			while (true) {
		        int nx = x + dx[direction[k]];
		        int ny = y + dy[direction[k]];

		        if (0>ny || ny>=r || 0>nx || nx>=c) break;
		        if (cleanerY == ny && cleanerX == nx) break;
		        map[ny][nx] = copyMap[y][x];
		        y = ny;
		        x = nx;
		     }
		}
	}
}
