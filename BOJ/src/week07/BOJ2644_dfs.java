package week07;

import java.util.*;

/*
 * 촌수계산 - dfs
 * https://www.acmicpc.net/problem/2644
 */

public class BOJ2644_dfs {
	static int n, m, t1, t2;
	static int[][] map;
	static int[] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		t1 = scanner.nextInt();
		t2 = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n+1][n+1];
		visit = new int[n+1];
		
		for(int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(t1, t2, 0);
		
		if (t1==t2) System.out.print(0);
		else if(visit[t2]==0) System.out.print(-1);
		else System.out.print(visit[t2]);
	}
	
	static void dfs(int t1, int t2, int cnt) {
		if(t1==t2) return;
		for(int i=1; i<=n; i++) {
			if(map[t1][i]==0 || visit[i]!=0) continue;
			visit[i]=visit[t1]+1;
			dfs(i, t2, cnt+1);
		}
	}
}
