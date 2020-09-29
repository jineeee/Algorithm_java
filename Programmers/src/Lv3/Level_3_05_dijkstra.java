package Lv3;

import java.util.*;

/*
 * 배달 - 다익스트라
 * https://programmers.co.kr/learn/courses/30/lessons/12978
 */

public class Level_3_05_dijkstra {
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] arr2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		solution(6, arr2, 4);
	}

	static int n, max = 100000;
	static int[][] map;
	static int[] dist;
	static boolean[] visit;
	
	static public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = N;
        map = new int[N][N];
        dist = new int[N];
        visit = new boolean[N];
        Arrays.fill(dist,max);
        for(int i=0; i<N; i++) Arrays.fill(map[i], max);
        
        for(int i=0; i<road.length; i++) {
        	if(map[road[i][0]-1][road[i][1]-1]>road[i][2])
        		map[road[i][0]-1][road[i][1]-1] = map[road[i][1]-1][road[i][0]-1] = road[i][2];
        }
        bfs();
        
        System.out.println(Arrays.toString(dist));
        for(int i=0; i<N; i++) {
        	if(dist[i]<=K) answer++;
        }
        System.out.print(answer);
        return answer;
    }
	
	static void bfs() {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(dist[o1], dist[o2]);
			}
		});
		queue.offer(0);
		dist[0] = 0;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			if(visit[now]) continue;
			
			visit[now] = true;
			for(int i=0; i<n; i++) {
				if(map[now][i]==max) continue;
				
				if(dist[i] > map[now][i] + dist[now]) {
					dist[i] = dist[now] + map[now][i];
					queue.offer(i);
				}
			}
			
		}
	}
}
