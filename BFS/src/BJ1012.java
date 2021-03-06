import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012 {
	static int T; // 테스트 케이스 개수
	static int M; // 밭의 가로 길이 
	static int N; // 밭의 세로 길이
	static int K; // 배추의 개수
	static int warm;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String[] st = br.readLine().split(" ");
			M = Integer.parseInt(st[0]);
			N = Integer.parseInt(st[1]);
			K = Integer.parseInt(st[2]);
			warm = 0;
			map = new int[N][M];
			visit = new boolean[N][M];
			
			// 배추들의 위치를 이차원 배열에 저장
			while(K-->0) {
				st = br.readLine().split(" ");
				map[Integer.parseInt(st[1])][Integer.parseInt(st[0])] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if (map[i][j]==1 && !visit[i][j]) { // 배추가 있는 곳을 찾았을 때
						visit[i][j] = true;
						queue.offer(new int[] {i,j});
						bfs();
						warm++;
					}
				}
			}
			System.out.println(warm);
		}
	}
	
	static void bfs() {
		int[] now;

		while(!queue.isEmpty()) {
			now = queue.poll();
						
			for(int k=0; k<4; k++) {
				int nx = now[0] + dx[k]; // 상하좌우가 변경할 때 x 좌표 
				int ny = now[1] + dy[k]; // 상하좌우가 변경할 때 y 좌표 
							
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(map[nx][ny] == 1) {
						queue.offer(new int[] {nx,ny});
						map[nx][ny] = 0;
					}		
				}
			}
		}
	}
}
