package week5;

import java.util.*;

/*
 * 백준 bfs와 dfs
 * https://www.acmicpc.net/problem/1260
 */

public class BOJ1260 {
	static int N, M, V;
	static boolean[] visit;
	static LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		for(int i=0; i<=N; i++) list.add(new LinkedList<Integer>());
		visit = new boolean[N+1];
		M = scanner.nextInt();
		V = scanner.nextInt();
		for(int i=0; i<M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i=1; i<=N; i++) Collections.sort(list.get(i));
		bfs();
	}
	
	static void bfs() {
		queue.add(V);
		visit[V] = true;
		System.out.print(V + " ");
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0; i<list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				if(visit[next]) continue;
				System.out.print(next + " ");
				queue.offer(next);
				visit[next] = true;
			}
		}
	}
}
