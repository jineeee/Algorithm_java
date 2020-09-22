package week07;

import java.io.*;
import java.util.*;

/*
 * 케빈 베이컨의 6단계 법칙 - bfs
 * https://www.acmicpc.net/problem/1389
 */

class kevin {
	int v, dist;
	public kevin(int v, int dist) {
		this.v = v;
		this.dist = dist;
	}
}

public class BOJ1389 {
	static int n, m;
	static int[][] map;
	static boolean[] visit;
	static int[] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		res = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		for(int i=1; i<=n; i++) {
			visit = new boolean[n+1];
			bfs(i);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			min = Math.min(min, res[i]);
		}
		for(int i=1; i<=n; i++) {
			if(res[i]==min) {
				System.out.print(i);
				break;
			}
		}
	}
	
	static void bfs(int v) {
		Queue<kevin> q = new LinkedList<kevin>();
		visit[v] = true;
		q.add(new kevin(v, 0));
		
		while (!q.isEmpty()) {
			kevin now = q.poll();
			for(int i=1; i<=n; i++) {
				if(map[now.v][i]==1 && !visit[i]) {
					q.add(new kevin(i, now.dist+1));
					visit[i] = true;
					res[i] += now.dist+1;
				}
			}
		}
	}
}
