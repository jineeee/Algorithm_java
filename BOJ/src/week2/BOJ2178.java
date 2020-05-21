package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2178 {
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		m = Integer.parseInt(st[1]);
		map = new int[n][m];
		System.out.print(m);
		// maze에 입력 배열 넣어줌
		for(int i=0; i<n; i++) {
			st = br.readLine().split("");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		System.out.println("출");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
	}

	static void bfs() {
		
	}
}
