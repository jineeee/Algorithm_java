

import java.io.*;
import java.util.*;

/*
 * 벡준 영역 구하기 - 재귀, dfs
 * https://www.acmicpc.net/problem/2583
 */

public class BOJ2583 {
	static int m,n,k,minX, minY, maxX, maxY, result;
	static int[][] map, square;
	static boolean[][] visit;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		m = Integer.parseInt(st[0]);
		n = Integer.parseInt(st[1]);
		k = Integer.parseInt(st[2]);
		map = new int[n][m];
		visit = new boolean[n][m];
		square = new int[k][4];
		for(int i=0; i<k; i++) {
			st = br.readLine().split(" ");
			square[i][0] = Integer.parseInt(st[0]);
			square[i][1] = Integer.parseInt(st[1]);
			square[i][2] = Integer.parseInt(st[2]);
			square[i][3] = Integer.parseInt(st[3]);
		}
		for(int i=0; i<k; i++) {
			int minX = Math.min(square[i][1], square[i][3]);
			int maxX = Math.max(square[i][1], square[i][3]);
			int minY = Math.min(square[i][0], square[i][2]);
			int maxY = Math.max(square[i][0], square[i][2]);
			for(int p= minY; p<maxY; p++) {
				for(int q=minX; q<maxX; q++) {
					map[p][q] = 1;
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0 && !visit[i][j]) {
					result = countCell(i,j);
					list.add(result);
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for(int i:list) System.out.print(i + " ");
	}
	
	static int countCell(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=m) return 0;
		else if(visit[x][y] || map[x][y]==1) return 0;
		else {
			visit[x][y] = true;
			return 1 + countCell(x+1, y) + countCell(x-1, y) + countCell(x, y+1) + countCell(x, y-1);
		}
	}
}
