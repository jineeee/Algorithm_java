package week1;

import java.util.*;

public class BOJ14502 {
	static int N, M;
	static int[][] map, copy;
	static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = copy =  new int[N][M];
		for(int i=0; i< N; i++){
			for(int j=0; j<M; j++) {
				copy[i][j] = map[i][j] = scanner.nextInt();
			}
		}
		
		makeWall(0);	
		System.out.print(answer);
	}
	
	static void makeWall(int cnt) { // 3개의 벽을 세우는 재귀 함수
		if(cnt==3) { // 벽 3개를 모두 세우는 것이 base case
			bfs(); // 바이러스를 퍼트리는 함수 실행
			return;
		}
		for(int i=0; i< N; i++){
			for(int j=0; j<M; j++) {
				if(copy[i][j]==0) { // 벽이 아니라면
					copy[i][j] = 1; // 벽을 세움
					makeWall(cnt+1); // 다음 벽을 세우기 위해 재귀 호출
					copy[i][j] = 0;  // 재귀 함수 종료 후 배열 복구를 위해 벽을 없앰
				}
			}
		}
	}
	
	static void bfs() { // bfs로 바이러스를 감염시키는 함수
		Queue<Loc> queue = new LinkedList<Loc>();
		int[][] virus = new int[N][M];
		for(int i=0; i< N; i++){
			for(int j=0; j<M; j++) {
				virus[i][j] = copy[i][j]; // 바이러스가 감염된 지도를 만들기 위해 벽이 세워진 배열을 복사
				if(virus[i][j]==2) queue.offer(new Loc(i, j));
			}
		}
		
		while (!queue.isEmpty()) {
			Loc now = queue.poll();
			for(int k=0; k<4; k++) {
				int nx = now.x + dx[k]; // 상하좌우가 변경할 때 x 좌표 
				int ny = now.y + dy[k]; // 상하좌우가 변경할 때 y 좌표 
							
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(virus[nx][ny] == 0) { // 벽이 아니고, 바이러스가 아니라면
						virus[nx][ny] = 2; // 바이러스 감염
						queue.offer(new Loc(nx, ny)); // 새로 감염된 위치를 queue에 넣어줌
					}		
				}
			}
		}
		getAnswer(virus);
	}
	
	static void getAnswer(int[][] virus) { // 바이러스에 감염되지 않은 부분(0)을 카운트하는 함수
		int safe=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus[i][j]==0) safe++;
			}
		}
		answer = Math.max(safe, answer);
	}
	
}

class Loc{ // 배열의 위치를 표현하는 클래스
	int x, y;
	Loc(int x, int y){
		this.x = x;
		this.y = y;
	}
}
