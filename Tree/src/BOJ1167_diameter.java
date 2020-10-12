import java.io.*;
import java.util.*;

/*
 * 트리의 지름
 * https://www.acmicpc.net/problem/1167
 */

public class BOJ1167_diameter {

	static class Node{
		int idx, dist;
		
		public Node(int idx, int dist) {
			this.idx = idx; 
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Node>[] list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
		
		
		for(int i=0; i<n; i++) {
			String[] arr = br.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			for(int j=1; j<arr.length-2; j+=2) {
				int y = Integer.parseInt(arr[j]);
				int d = Integer.parseInt(arr[j+1]);
				list[x].add(new Node(y, d));
			}
		}
		
		// 임의의 점 1에서 가장 먼 노드를 찾음 (start)
		int[] dist = bfs(list, 1, n);
		int start = 1;
		for(int i=2; i<=n; i++) 
			if(dist[i]>dist[start]) start = i;
		
		// 가장 테두리에 있는 노드에서 가장 먼 노드와의 거리를 구하면 그것이 트리의 지름
		dist = bfs(list, start, n);
		Arrays.sort(dist);
		System.out.print(dist[n]);
	}
	
	// start로 부터 각 정점의 길이를 구하는 함수
	static int[] bfs(List<Node>[] list, int start, int n) {
		int[] dist = new int[n+1];
		boolean[] visit = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visit[start] = true;
		
		while (!queue.isEmpty()) {
			int k = queue.poll();
			for(Node node : list[k]) {
				if(!visit[node.idx]) {
					visit[node.idx] = true;
					queue.add(node.idx);
					dist[node.idx] = dist[k] + node.dist;
				}
			}
		}
		return dist;
	}
}
