package week3;

import java.util.*;

/*
 * 백준 인구이동 - bfs
 * https://www.acmicpc.net/problem/16234
 */

public class BOJ16234 {
	static int N, L, R;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		L = scanner.nextInt();
		R = scanner.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				map[i][j] = scanner.nextInt();	
	}
	
	static void bfs() {
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) {
				
			}
		while (!queue.isEmpty()) {
			
		}
	}
}
