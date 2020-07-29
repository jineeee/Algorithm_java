package week7;

import java.util.*;

public class BOJ2644 {
	static int n, m, t1, t2;
	static int[][] map;
	static int[] res;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		t1 = scanner.nextInt();
		t2 = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n+1][n+1];
		res = new int[n+1];
		
		for(int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			map[a][b] = map[b][a] = 1;
		}
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
		bfs();
		if(res[t2]==0) System.out.print(-1);
		else System.out.print(res[t2]);
		
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(t1);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
//			System.out.println(now);
			for(int i=1; i<=n; i++) {
//				System.out.println(Arrays.toString(res));
				if(map[now][i]==0 || res[i]!=0) continue;
				res[i] = res[now]+1;
				queue.add(i);
			}
		}
	}
}
