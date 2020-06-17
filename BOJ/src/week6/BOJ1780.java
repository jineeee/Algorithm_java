package week6;

import java.util.*;

/*
 * 백준 종이의 개수 - 분할 정복
 * https://www.acmicpc.net/problem/1780
 */

public class BOJ1780 {
	static int n, size;
	static int[][] map;
	static int[] count = new int[3];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++) map[i][j] = scanner.nextInt();
		divide(0, 0, n);
		System.out.print(count[0] + "\n" + count[1] + "\n" + count[2]);
	}
	
	static void divide(int x, int y, int size) {
		if(check(x, y, size)) count[map[x][y]+1]++;
		else {
			int s = size/3;
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					divide(x+s*i, y+s*j, s); // 분할 정복 재귀 호출
		}
	}
	
	static boolean check(int x, int y, int size) {
		int num = map[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(map[i][j]!=num) return false;
			}
		}
		return true;
	}
}
