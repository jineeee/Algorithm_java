import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1520 {

	static int M, N, ans;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strings = br.readLine().split(" ");
		M = Integer.parseInt(strings[0]);
		N = Integer.parseInt(strings[1]);
		map = new int[M][N];
		
		for(int i=0; i<M; i++) {
			strings = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(strings[j]);
			}
		}
		
		bfs();
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
//			System.out.println(Arrays.toString(now));
			if(now[0]==M-1 && now[1]==N-1) ans++;
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
				if(map[nx][ny]>=map[now[0]][now[1]]) continue;
				
				queue.offer(new int[] {nx, ny});
			}
		}
	}
}
