package week9;

import java.util.*;

/*
 * N-queens - dfs
 * https://www.acmicpc.net/problem/9663
 */

public class BOJ1932 {
	static int N, ans=0;
	static int[] col;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		for(int i=1; i<=N; i++) {
			col = new int[N+1]; // col 배열의 인덱스는 행, 배열의 값은 열
			col[1] = i; // 1행 i열에 퀸을 놓은 상태
			dfs(1);
		}
		System.out.print(ans);
	}
	
	static void dfs(int row) {
		if(row==N) ans++;
		else {
			for(int i=1; i<=N; i++) {
				col[row+1] = i; // 다음 행, i번째 열에 퀸을 놓음
				if(isPossible(row+1)) { // 검증이 필요한 행을 매개변수로 보냄
					dfs(row+1); // 다음 행을 매개변수로 재귀 호출
				}
			}
		}
	}

	static boolean isPossible(int row) {
		for(int i=1; i<row; i++) {
			if(col[i] == col[row]) return false; // 같은 열에 있으면 false
			if(Math.abs(i-row)==Math.abs(col[i]-col[row])) return false; // 대각선에 위치하면 false
		}
		return true;
	}
}
