

import java.util.*;

/*
 * 백준 연결 요소의 개수 - 그래프
 * https://www.acmicpc.net/problem/11724
 */

public class BOJ11724 {
	static int n, m, cnt=0;
	static boolean[] visit;
	static LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		visit = new boolean[n+1];
		for (int i=0; i<=n; i++) list.add(new LinkedList<Integer>());
		for(int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i=1; i<=n; i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
	
	static void dfs(int v) {
		visit[v] = true;
		for(int i:list.get(v)) {
			if(!visit[i]) dfs(i);
		}
	}
}
