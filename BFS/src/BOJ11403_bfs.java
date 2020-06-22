

import java.util.*;

/*
 * 백준 경로찾기 - 플로이드 알고리즘, bfs
 * https://www.acmicpc.net/problem/11403
 */

public class BOJ11403_bfs {
	static int n;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) map[i][j] = scanner.nextInt();
		
		for(int i=0; i<n; i++) {
			visit = new boolean[n];
			for(int j=0; j<n; j++) {
				if(!visit[j] && map[i][j]==1) // 직접 연결된 노드인 경우 bfs 실행
					bfs(i, j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
	
	static void bfs(int x, int y) {
		queue.add(y);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=0; i<n; i++) {
				if(!visit[i] && map[now][i]==1) { // x와 간접연결된 노드라면
					queue.add(i);
					map[x][i] = 1;
					visit[i] = true;
				}
			}
		}
	}
}
