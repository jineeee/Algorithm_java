import java.util.*;

/*
 * 백준 바이러스 - 그래프 (bfs)
 * https://www.acmicpc.net/problem/2606
 */

public class BOJ2606 {
	static int V, E, ans;
	static boolean[] virus;
	static LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		V = scanner.nextInt();
		virus = new boolean[V+1];
		for(int i=0; i<=V; i++) list.add(new LinkedList<Integer>());
		E = scanner.nextInt();
		for(int i=0; i<E; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		getResult();
		for(boolean flag : virus) 
			if(flag) ans++;
		System.out.println(ans-1);
	}
	
	static void getResult() {
		queue.offer(1);
		virus[1] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0; i<list.get(now).size(); i++) {
				int dot = list.get(now).get(i);
				if(virus[dot]) continue;
				virus[dot] = true;
				queue.offer(dot);
			}
		}
	}
}
