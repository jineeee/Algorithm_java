import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 백준 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */

public class BJ1697 {
	static int N;
	static int K;
	static int MAX = 100001;
	static int[] visit = new int[MAX];
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈이 위치
		K = sc.nextInt(); // 동생 위치
		
		System.out.println(bfs(N, K));
	}
	
	static int bfs(int n, int k) {
		q.offer(n); // 수빈이의 위치를 큐에 넣어줌
		visit[n] = 1; // 현재 위치를 방문 표시 
		
		while(!q.isEmpty()) { // 큐에 값이 있는동안 반복 
			int loc = q.poll(); // 큐에서 꺼낸 값이 현재 위치
			
			for(int i=0; i<3; i++) { // 수빈이의 다음 위치를 결정하는 경우는 3가지
				int next; // 수빈이의 다음 위치를 담을 변수
				
				if(i==0) // 현재위치-1 지점으로 이동 
					next = loc-1;
				else if (i==1) //현재위치 +1 지점으로 이동 
					next = loc+1;
				else // 현재위치*2 지점으로 이동
					next = 2*loc;
				
				if(next==k) // 위에서 계산된 다음 위치가 동생이 있는 곳이라면
					return visit[loc]; // 현재 위치를 리턴 (1에서 시작했기 때문)
				
				if(0<=next && next<MAX) { // 다음 위치가 범위 내에 있고 
					if(visit[next] == 0) { // 방문하지 않은 위치라면
						q.offer(next); // 큐에 위치 삽입
						visit[next] = visit[loc]+1; // 다음에 방문할 위치의 값에 이동 횟수 표시
					}
				}
			}
		}
		return 0;
	}
}
