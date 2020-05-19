package Lv3;

import java.util.*;

/*
 * 가장 먼 노드 - 그래프, bfs
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */

public class Level_3_01 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean[][] map; // 연결 정보를 저장하는 배열
	static int[] dist; // 최단 거리를 저장하는 배열
	
	static public int solution(int n, int[][] edge) {
        int answer = 0;
        map = new boolean[n][n];
        dist = new int[n];
        for(int i=0; i<edge.length; i++) {
        	map[edge[i][0]-1][edge[i][1]-1] = map[edge[i][1]-1][edge[i][0]-1] = true;
        }
        queue.offer(0);
        answer = bfs(n);
        System.out.println(answer);
        return answer;
    }
	
	static int bfs(int n) {
		int maxDist = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=1; i<n; i++) {
				if(dist[i]==0 && map[now][i]) { // 최소거리가 0이고, 현재 노드와 연결되어 있으면
					dist[i] = dist[now]+1; // 거리는 1번 노드와 현재 노드 사이의 거리 +1
					queue.offer(i);
					maxDist = Math.max(maxDist, dist[i]); // 가장 먼 거리를 저장
				}
			}
		}

		int cnt = 0;
		for(int i : dist) { // 가장 먼 노드의 개수를 계산
			if (i==maxDist) cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[][] temp = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		solution(6, temp);
	}
}
