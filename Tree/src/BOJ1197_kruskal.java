

import java.io.*;
import java.util.PriorityQueue;

/*
 * 백준 1197 - 최소스패닝트리(mst), union-find
 * https://www.acmicpc.net/problem/1197
 */

public class BOJ1197_kruskal {
	
	// 간선 클래스, 우선순위큐를 사용하기 위한 정렬 기준을 가진다.
	static class Edge implements Comparable<Edge>{
		int from, to, dist;
		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge n1) {
			return Integer.compare(dist, n1.dist);
		}
	}

	static int V, E, ans=0;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		V = Integer.parseInt(arr[0]);
		E = Integer.parseInt(arr[1]);
		parent = new int[V+1];
		
		// 부모노드 초기화
		for(int i=1; i<=V; i++) parent[i] = i;
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		for(int i=0; i<E; i++) {
			arr = br.readLine().split(" ");
			Edge node = new Edge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 
					Integer.parseInt(arr[2]));
			queue.offer(node);
		}
		
		for(int i=0; i<E; i++) {
			Edge edge = queue.poll();
			
			int s = find(edge.from);
			int e = find(edge.to);
			// 시작 노드와 종료 노드의 루트가 겹치면 사이클이 생기는 것이므로 continue를 한다.
			if(s==e) continue;
			
			union(s, e);
			ans += edge.dist;
		}
		System.out.print(ans);
		
	}
	
	static int find(int a) {
		// 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
		if(a==parent[a]) return a;
		// 각 노드의 부모를 찾아 올라간다.
		else parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		// 각 원소가 속한 트리의 루트노드를 찾는다.
		int rootA = find(a);
		int rootB = find(b);
		// 루트가 동일하지 않다면 a의 루트노드를 b로 지정하여 두 트리를 합친다.
		if(rootA!=rootB) parent[rootA] = b;
		// 같은 트리에 속할 경우 함수를 종료한다.
		else return;
	}
}
