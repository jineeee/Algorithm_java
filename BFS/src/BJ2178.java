import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2178 {
	static int N; // 미로의 세로길이
	static int M; // 미로의 가로길이
	static int[][] maze;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		maze = new int[N][M];
		
		// maze에 입력 배열 넣어줌
		for(int i=0; i<N; i++) {
			st = br.readLine().split("");
			for(int j=0; j<M; j++) {
				maze[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		// 시작 위치는 항상 [0,0]
		queue.offer(new int[] {0,0});

	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					
				}
			}
		}
	}
	
	

}
