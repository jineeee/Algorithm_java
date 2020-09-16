

import java.io.*;
import java.util.*;

/*
 * 백준 최단경로 - 다익스트라 알고리즘, 그래프
 * https://www.acmicpc.net/problem/1753
 */

public class BOJ1753 {
	static class Node{
		int idx, weight;
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
	
	static int v, e, start, INF=987654321;
	static int[] dist;
	static ArrayList<Node>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		v = Integer.parseInt(st[0]);
		e = Integer.parseInt(st[1]);
		list = new ArrayList[v+1];
		dist = new int[v+1];
		start = Integer.parseInt(br.readLine());
		for (int i = 0; i <= v; i++) {
			dist[i] = INF;
			list[i] = new ArrayList<Node>();
		}
		for(int i=0; i<e; i++) {
			st = br.readLine().split(" ");
			int v1 = Integer.parseInt(st[0]);
			int e1 = Integer.parseInt(st[1]);
			int w = Integer.parseInt(st[2]);
			list[v1].add(new Node(e1, w));
		}
		
		getResult();
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i]==INF) sb.append("INF" + "\n");
			else sb.append(dist[i] + "\n");
		} System.out.print(sb.toString());
	}
	
	static void getResult() {
		// 가중치가 작은 순서로 정렬하기 위해 우선순위 큐 사용
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>( new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) { // 정렬 기준 정의
				return o1.weight-o2.weight;
			}
		});
		dist[start] = 0;
		pQueue.add(new Node(start, 0)); // 시작 노드를 큐에 넣어줌
		
		while (!pQueue.isEmpty()) {
			Node nowNode = pQueue.poll();
			
			for(Node node : list[nowNode.idx]) { // 현재 노드와 인접한 노드 탐색
				if(dist[node.idx] > dist[nowNode.idx]+node.weight) { // 인접 노드까지의 경로가 현재 노드+인접노드 가중치보다 크다면
					dist[node.idx] = dist[nowNode.idx]+node.weight; // 가중치 재정의
					pQueue.offer(new Node(node.idx, dist[node.idx])); // 인접 노드를 큐에 넣어줌
				}
			}
		}
	}
}
