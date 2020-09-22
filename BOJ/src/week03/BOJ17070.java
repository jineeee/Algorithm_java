package week03;

import java.util.Scanner;

/*
 * 백준 파이프 옮기기 - dfs
 * https://www.acmicpc.net/problem/17070
 */

public class BOJ17070 {
	static int n;
	static int[][] map;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++) map[i][j] = scanner.nextInt();
		dfs(0, 1, 1);
		System.out.println(answer);
	}
	
	static boolean isRange(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n) return false;
		return true;
	}
	
	static void dfs(int x, int y, int d) {
		if(x==n-1 && y==n-1) {
			answer++;
			return;
		}
	
		// 1:가로 / 2:세로 / 3: 대각선 으로 놓여져 있는 경우
		// 다음 위치가 유효한 범위인지 확인 && map상에서 빈 공간인지 확인 && 이동 가능한 방향인지 확인
		if(isRange(x, y+1) && map[x][y+1]==0 && d!=2) dfs(x, y+1, 1);
		if(isRange(x+1, y) && map[x+1][y]==0 && d!=1) dfs(x+1, y, 2);
		if(isRange(x+1, y+1) && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) 
			dfs(x+1, y+1, 3);
	}
}
