import java.io.*;
import java.util.*;

public class BOJ1753_2 {
	
	static class Node implements Comparable<Node>{
		int idx, weight;
		public Node(int idx, int weight){
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	
	static int v, e, k, INF=987654321;
	static int[] dist;
	static LinkedList<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stArr = br.readLine().split(" ");
		
		v = Integer.parseInt(stArr[0]);
		e = Integer.parseInt(stArr[1]);
		k = Integer.parseInt(br.readLine());
		dist = new int[v+1];
		list = new LinkedList[v+1];
		for(int i=0; i<v+1; i++) {
			dist[i] = 987654321;
			list[i] = new LinkedList<Node>();
		}
		for(int i=0; i<e; i++) {
			 stArr = br.readLine().split(" ");
			 int start = Integer.parseInt(stArr[0]);
			 int end = Integer.parseInt(stArr[1]);
			 int weight = Integer.parseInt(stArr[2]);
			 list[start].add(new Node(end, weight));
		}
		getResult();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<dist.length; i++)
			if(dist[i]==INF) sb.append("INF \n");
			else sb.append(dist[i] + "\n");
		System.out.print(sb.toString());
		
	}

	static void getResult() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(k, 0));
		dist[k] = 0;
		
		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();
		
			for(Node node : list[nowNode.idx]) {
				if(dist[node.idx] > dist[nowNode.idx] + node.weight) {
					dist[node.idx] = dist[nowNode.idx] + node.weight;
					queue.offer(new Node(node.idx, dist[node.idx]));
				}
			}
		}
	}
}
