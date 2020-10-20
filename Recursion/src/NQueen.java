
/*
 * 프로그래머스 N-Queen
 * https://programmers.co.kr/learn/courses/30/lessons/12952
 */

public class NQueen {

	static int answer = 0;

	public int solution(int n) {
		int[] queen = new int[n];
		dfs(n, 0, queen);
		return answer;
	}

	static void dfs(int n, int row, int[] queen) {
		if (row == n) {
			answer++;
		} else {
			for (int i = 0; i < n; i++) {
				queen[row] = i;
				if (!check(row, queen))
					continue;
				dfs(n, row + 1, queen);
			}
		}
	}

	// 현재 위치에 놓아도 되는지 검사
	static boolean check(int row, int[] queen) {
		for (int i = 0; i < row; i++) {
			if (queen[i] == queen[row])
				return false;
			if (Math.abs(queen[i] - queen[row]) == row - i)
				return false;
		}
		return true;
	}
}
