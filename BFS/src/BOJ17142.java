

import java.util.*;

/*
 * 백준 연구소 3 - bfs, 조합
 * https://www.acmicpc.net/problem/17142
 */

class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ17142 {
	static int n, m, cnt=0, empty=0;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int answer = 9999;
    static List<Point> point= new ArrayList<Point>();
    static Point[] virusPoint;
    static boolean[] virusVisit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int num = scanner.nextInt();
				if(num==1) map[i][j] = -1;
				else if(num==2) {
					point.add(new Point(i, j));
					map[i][j] = -2;
				}
				else if(num==0) {
					map[i][j] = -3;
					empty++;
				}
			}
		}
		if(empty==0) { // 처음부터 빈 칸이 없다면 0초 
			System.out.print(0);
			return;
		}
		
		virusPoint = new Point[m]; // 활성 바이러스를 담을 배열
		virusVisit = new boolean[point.size()]; // 중복 방지를 위한 배열
		
		activeVirus(0,0);
		if(cnt==0) System.out.print(-1); // 바이러스를 모두 퍼트린 경우가 없었다면 -1 출력
		else System.out.println(answer);
	}
	
	static void activeVirus(int start, int current) {
		if(current==m) {
			bfs();
			return;
		}else {
			for (int i = start; i < point.size(); i++) {
				if(!virusVisit[i]) {
					virusVisit[i] = true;
					virusPoint[current] = point.get(i);
					activeVirus(i+1, current+1);
					virusVisit[i] = false;
				}
			}
		}
	}
	
	static void bfs() {
		int wallCnt=0;
		Queue<Point> queue = new LinkedList<Point>();
		int[][] virus = new int[n][n]; // 바이러스를 퍼트릴 배열
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				virus[i][j] = map[i][j];
				if(virus[i][j] == -3) wallCnt++; // 빈 칸의 개수를 셈
			}
		}
		for(int i=0; i<m; i++) { // 활성 바이러스는 0으로 변경
			queue.offer(virusPoint[i]);
			virus[virusPoint[i].x][virusPoint[i].y] = 0;
		}

		while (!queue.isEmpty()) {
			
			Point now = queue.poll();
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n || virus[nx][ny]==-1) continue;
				if(virus[nx][ny]==-3) { // 빈 칸일 경우 바이러스 감염
					wallCnt--;
					queue.offer(new Point(nx, ny));
					virus[nx][ny] = virus[now.x][now.y] + 1;
				}
				else if(virus[nx][ny]==-2) { // 비활성 바이러스일 경우 활성 바이러스로 변경
					queue.offer(new Point(nx, ny));
					virus[nx][ny] = virus[now.x][now.y] + 1;
				}
			}
			
			if(wallCnt==0) break; // 빈 칸에 바이러스가 모두 퍼지면 종료
		}
		if(wallCnt!=0) return; // 빈 칸이 남아있다면 bfs 종료
		getAns(virus);
	}

	static void getAns(int[][] virus) {
		cnt++; // 빈 칸 없이 바이러스를 모두 퍼트린 경우를 count
		int max = -9999;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) 
				max = Math.max(max, virus[i][j]);
		answer = Math.min(answer, max);
	}
}
