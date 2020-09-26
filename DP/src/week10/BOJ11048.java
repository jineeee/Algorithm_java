package week10;

import java.io.*;
import java.util.*;

/*
 * 이동하기 - dp, 점화식
 * https://www.acmicpc.net/problem/11048
 */

public class BOJ11048 {
	
	static int N, M, ans = 0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String[] arr = bf.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		map = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			arr = bf.readLine().split(" ");
			for(int j=1; j<=M; j++) map[i][j] = Integer.parseInt(arr[j-1]);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] += Math.max(map[i-1][j], Math.max(map[i][j-1], map[i-1][j-1]));
			}
		}
		
		System.out.print(map[N][M]);
	}

}
