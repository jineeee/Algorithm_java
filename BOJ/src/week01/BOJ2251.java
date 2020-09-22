package week01;

import java.util.*;

/*
 * 백준 2251 - BFS
 * https://www.acmicpc.net/problem/2251
 */

class Water{
	int a, b, c;
	public Water(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class BOJ2251 {
	static int A, B, C;
	static Set<Integer> set = new HashSet<Integer>();
	static Queue<Water> queue = new LinkedList<Water>();
	static boolean[][][] visit = new boolean[201][201][201];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		A = scanner.nextInt();
		B = scanner.nextInt();
		C = scanner.nextInt();
		
		queue.offer(new Water(0, 0, C));
		bfs();
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		for(int i : list)
			System.out.print(i + " ");
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int nowA = queue.peek().a;
			int nowB = queue.peek().b;
			int nowC = queue.peek().c;
			queue.poll();
			
			if(visit[nowA][nowB][nowC]) continue;
			visit[nowA][nowB][nowC] = true;
			
			
			if(nowA==0) set.add(nowC);
			
			if(nowB + nowA > B) // a -> b
				queue.offer(new Water(nowA+nowB-B, B, nowC));
			else 
				queue.offer(new Water(0, nowA+nowB, nowC));
				
			if(nowC + nowA > C) // a -> c
				queue.offer(new Water(nowA+nowC-C, nowB, C));
			else
				queue.offer(new Water(0, nowB, nowA+nowC));
			
			if(nowA + nowB > A) // b -> a
				queue.offer(new Water(A, nowB+nowA-A, nowC));
			else
				queue.offer(new Water(nowA+nowB, 0, nowC));
			
			if(nowC + nowB > C) // b -> c
				queue.offer(new Water(nowA, nowB+nowC-C, C));
			else
				queue.offer(new Water(nowA, 0, nowB+nowC));
			
			if(nowA + nowC > A) // c -> a
				queue.offer(new Water(A, nowB, nowC+nowA-A));
			else 
				queue.offer(new Water(nowA+nowC, nowB, 0));
				
			if(nowB + nowC > B) // c -> b
				queue.offer(new Water(nowA, B, nowC+nowB-B));
			else
				queue.offer(new Water(nowA, nowB+nowC, 0));
			
		}
	}
}
