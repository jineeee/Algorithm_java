import java.io.*;
import java.util.*;

/*
 * 크루스칼, union-find
 * https://www.acmicpc.net/problem/1922
 */

public class BOJ1922 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, dist;
		
		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(dist, e.dist);
		}
	}

	static int N, M, ans;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		String[] st;
		for(int i=0; i<M; i++) {
			st = br.readLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(st[0]), Integer.parseInt(st[1]), Integer.parseInt(st[2]));
			queue.offer(edge);
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		for(int i=0; i<M; i++) {
			Edge edge = queue.poll();
			
			int s = find(edge.from);
			int e = find(edge.to);
			
			if(s==e) continue;
			
			union(s, e);
			ans += edge.dist;
		}
		System.out.print(ans);
	}
	
	static int find(int a) {
		if(a==parent[a]) return a;
		
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA!=rootB) parent[rootA] = b;
		else return;
	}
}
