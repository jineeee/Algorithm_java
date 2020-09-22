package week02;

import java.io.*;
import java.util.*;

/* 
 * 백준 단지번호 붙히기 - DFS
 * https://www.acmicpc.net/problem/2667
 */
public class BOJ2667 {
	static int n,count;
	static int[][] map;
	static boolean[][] visit;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String st[] = br.readLine().split("");
			for(int j=0; j<n; j++) {
				map[i][j] =  Integer.parseInt(st[j]);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					count = countCell(i,j);
					list.add(count);
				}
			}
		}
		System.out.println(list.size());
		list.sort(null);
		for(int i: list) System.out.println(i);
	}
	static int countCell(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n) return 0;
		else if(map[x][y]==0 || visit[x][y]) return 0;
		else {
			visit[x][y] = true;
			return 1 + countCell(x+1, y) + countCell(x-1, y) + countCell(x, y+1) + countCell(x, y-1);
		}
	}
}

