import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	static Queue<Integer> q = new LinkedList<Integer>();
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int V; // 시작 정점
	static int[][] map; // 간선의 정보를 저장할 배열 
	static boolean[] visit; // 정점 방문 여부를 저장할 배열
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		// 간선 정보를 저장할 이차원 배열에 값을 넣어줌
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
			
		}
		
		// 간선 정보가 저장된 이차원 배열을 출력
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}
		
		bfs();
	}
	
	static void bfs() {
		int now;
		q.offer(V);
		visit[V] = true;
		
		while(!q.isEmpty()) {
			now = q.poll();
			System.out.print(now + " ");
			for (int i=1; i<N+1; i++) {
				if(map[now][i]==1 && !visit[i]) { // 아직 방문하지 않은 인접 노드를 큐에 삽입
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
