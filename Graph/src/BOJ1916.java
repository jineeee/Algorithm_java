import java.io.*;
import java.util.*;

/*
 * 백준 1916 - 다익스트라, 플루이드와샬
 * https://www.acmicpc.net/problem/1916
 */

public class BOJ1916 {
	
	static class Node implements Comparable<Node>{
		int idx, weight;
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	
	static int N, M, S, E;
	static LinkedList<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new LinkedList[N+1];
		dist = new int[N+1];
		for(int i=0; i<N+1; i++) {
			dist[i] = Integer.MAX_VALUE;
			list[i] = new LinkedList<Node>();
		}
		for(int i=0; i<M; i++) {
			String[] arr = br.readLine().split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			int bus = Integer.parseInt(arr[2]);
			list[start].add(new Node(end, bus));
		}
		String[] arr = br.readLine().split(" ");
		S = Integer.parseInt(arr[0]);
		E = Integer.parseInt(arr[1]);
		
		getResult();
		
		System.out.print(dist[E]);
	}
	
	static void getResult() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(S, 0));
		dist[S] = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (Node linkedNode : list[node.idx]) {
				if(dist[linkedNode.idx] > dist[node.idx] + linkedNode.weight) {
					dist[linkedNode.idx] = dist[node.idx] + linkedNode.weight;
					queue.offer(new Node(linkedNode.idx, dist[linkedNode.idx]));
				}
			}
		}
	}
}
