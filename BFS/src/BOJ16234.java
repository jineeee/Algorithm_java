

import java.util.*;

/*
 * 백준 인구이동 - bfs
 * https://www.acmicpc.net/problem/16234
 */

public class BOJ16234 {
	static int N, L, R, ans=0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		L = scanner.nextInt();
		R = scanner.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				map[i][j] = scanner.nextInt();	
		bfs();
		System.out.print(ans);
	}
	
	static void bfs() {
		boolean flag = true;
		while (flag) {
			int sum=0;
			ArrayList<int[]> list = new ArrayList<int[]>(); // 연합 국가의 좌표를 담을 리스트
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					queue.add(new int[] {i,j});
					
					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						if(!visit[now[0]][now[1]]) {
							visit[now[0]][now[1]] = true;
							sum += map[now[0]][now[1]];
							list.add(new int[] {now[0],now[1]}); // 연합이 된 국가들의 좌표를 담음
							
							for(int p=0; p<4; p++) { // 주변 국가 탐색과 인구 차이 확인
								int nx = now[0] + dx[p];
								int ny = now[1] + dy[p];
								if(nx<0 || ny<0 || nx>=N || ny>=N || visit[nx][ny]) continue;
								if(check(map[now[0]][now[1]], map[nx][ny])) queue.add(new int[] {nx,ny});
							}
						}
					}
					
					if(list.size()>1) { // 인구 이동할 국가가 있을 때
						int people = sum/list.size();
						for(int k=0; k<list.size(); k++)
							map[list.get(k)[0]][list.get(k)[1]] = people;
						flag = false;
					}
					sum=0;
					list = new ArrayList<int[]>();
				}
			}
			
			if(!flag) {
				ans++;
				flag = true;
				visit = new boolean[N][N];
			}else break;
		}
	}
	
	static boolean check(int a ,int b) {
		if(Math.abs(a-b)>=L && Math.abs(a-b)<=R)
			return true;
		return false;
	}
}
