import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606 {
	static int com; // 컴퓨터의 개수
	static int pair; // 연결되어 있는 컴퓨터 쌍의 수
	static int[][] map; // 컴퓨터 쌍의 정보를 저장할 배열
	static boolean[] visit; // 방문 여부를 저장하는 배열
	static int virusCount = 0; // 감염 컴퓨터 수를 저장하는 배열
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		com = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		pair = Integer.parseInt(st.nextToken());
		
		map = new int[com+1][com+1];
		visit = new boolean[com+1];
		
		while (pair --> 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		System.out.print(bfs());
	}
	
	static int bfs() {
		int now = 1;
		visit[now] = true;
		q.offer(now);
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i=1; i<=com; i++) {
				if(map[now][i]==1 && !visit[i]) {
					visit[i] = true;
					q.offer(i);
					virusCount++;
				}
			}
		}
		return virusCount;
	}
}
