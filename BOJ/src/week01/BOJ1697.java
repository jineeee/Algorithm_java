package week01;

import java.util.*;

public class BOJ1697 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] visit = new int[100001];

	public static void main(String[] aargs) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		System.out.print(bfs(n,k));
		return;
	}
	
	static int bfs(int n, int k) {
		queue.offer(n);
		visit[n] = 1;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			int next;
			
			if(now==k)
				return visit[now]-1;
			
			for(int i=0; i<3; i++) {
				
				if(i==0)
					next = now+1;
				else if(i==1)
					next = now-1;
				else 
					next = now*2;
				
				if(next>=0 && next<=100000 && visit[next]==0) {
					queue.offer(next);
					visit[next] = visit[now]+1;
				}
			}
		}
		return 0;
	}
}
