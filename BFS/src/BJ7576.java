import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	// (dx,dy) : 우(0,1), 하(1,0), 좌(0,-1), 상(-1,0)
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] box; // 토마토가 담겨있는 2차원 배열
	static int max = 0; // 배열의 가장 큰 값을 담을 변수 
	static int N; // 상자의 세로 칸 수 
	static int M; // 상자의 가로 칸 수 
	static Queue<int[]> q = new LinkedList<int[]>(); // 익은 토마토를 담을 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 가로 세로 크기 초기화 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// box 배열 크기 초기화
		box = new int[M][N];
		
		// 사용자 입력 값을 이차원 배열에 저장하는 반복문
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				// 익은 토마토의 좌표들을 큐에 삽입
				if(box[i][j]==1) {
					q.offer(new int[]{i,j});
				}
			}
		}
		System.out.print(bfs(q));	
	}
	
	public static int bfs(Queue<int[]> q) {
		while(!q.isEmpty()) { // 큐에 노드가 있는동안 반복문 실행 
			int[] loc = q.poll(); // 큐에서 꺼낸 첫번째 첫번째 익은 토마토의 좌표
			
			for(int k=0; k<4; k++) { // 오른쪽 아래 왼쪽 위 돌아가며 탐색
				int nx = loc[0] + dx[k]; // 상하좌우가 변경할 때 x 좌표 
				int ny = loc[1] + dy[k]; // 상하좌우가 변경할 때 y 좌표 
				
				if (0 <= nx && nx < M && 0 <= ny && ny < N) { // 상자의 범위 내에 있을 때 
                    if (box[nx][ny] == 0) { // 좌표에 있는 토마토가 익지 않은 토마토(0)라면
                        box[nx][ny] = box[loc[0]][loc[1]] + 1; // 인접해 있던 익은 토마토의 값+1 로 변경
                        q.offer(new int[]{nx, ny}); // 새로 익은 토마토의 좌표를 큐에 넣어줌
                    }
                }
			}
		}

		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if(box[i][j] == 0) { // 안 익은 토마토가 있다면 
					return -1;
				} else { // 안 익은 토마토가 없다면 
					if(box[i][j] > max) { // 배열에서 가장 큰 값을 찾아줌
						max = box[i][j];
					}
				}
			}
		}
		return max-1; // 1부터 시작했으므로 -1하여 return
	}
}
