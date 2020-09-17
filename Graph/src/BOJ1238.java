import java.io.*;
import java.util.*;

/* 파티 - 다익스트라, 역방향 그래프
 * https://www.acmicpc.net/problem/1238
 */

public class BOJ1238 {
	
	static class Town implements Comparable<Town>{
		int idx, weight;
		public Town(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Town o) {
			return weight - o.weight;
		}
	}
	
	static int N, M, X, INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		X = Integer.parseInt(arr[2]);
		LinkedList<Town>[] map = new LinkedList[N+1], revMap = new LinkedList[N+1];
		int[] dist = new int[N+1];
		int[] revDist = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			dist[i] = revDist[i] = INF;
			map[i] = new LinkedList<Town>();
			revMap[i] = new LinkedList<Town>();
		}
		
		for(int i=0; i<M; i++) {
			arr = br.readLine().split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			int weight = Integer.parseInt(arr[2]);
			map[start].add(new Town(end, weight)); 
			revMap[end].add(new Town(start, weight)); // 간선을 역방향으로 저장
		}
		getResult(map, dist); // 파티가 열리는 마을에서 각 마을까지의 거리를 구함
		getResult(revMap, revDist); // 각 마을에서 파티가 열리는 마을까지의 거리를 역방향 그래프로 구함
		
		int answer = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			int temp = dist[i] + revDist[i];
			answer = Math.max(answer, temp);
		}
		System.out.print(answer);
	}

	static void getResult(LinkedList<Town>[] map, int[] distance) {
		PriorityQueue<Town> queue = new PriorityQueue<Town>();
		queue.offer(new Town(X, 0));
		distance[X] = 0;
		while(!queue.isEmpty()) {
			Town town = queue.poll();
			
			for(Town linkedTown : map[town.idx]) {
				if(distance[linkedTown.idx] > distance[town.idx] + linkedTown.weight) {
					distance[linkedTown.idx] = distance[town.idx] + linkedTown.weight;
					queue.offer(new Town(linkedTown.idx, distance[linkedTown.idx]));
				}
			}
		}
	}
}
