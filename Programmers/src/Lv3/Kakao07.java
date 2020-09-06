package Lv3;

import java.util.*;

/*
 * 카카오 기둥과 보 설치 - 로직 짜기
 * https://programmers.co.kr/learn/courses/30/lessons/60061
 */

public class Kakao07 {

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 },
				{ 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		int[][] arr2 = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 2, 1, 1, 1 },
				{ 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };

		solution(5, arr1);
	}

	static boolean[][] cols;
	static boolean[][] rows;

	public static int[][] solution(int n, int[][] build_frame) {
		int cnt = 0;
		cols = new boolean[n + 3][n + 3]; // 기둥
		rows = new boolean[n + 3][n + 3]; // 보

		for (int[] order : build_frame) {
			int x = order[0] + 1, y = order[1] + 1, a = order[2], b = order[3];

			if (b == 0) { // 삭제
				if (a == 0)
					cols[x][y] = false;
				else if (a == 1)
					rows[x][y] = false;

				if (checkDelete(x, y, n)) {
					cnt--;
					continue;
				}

				if (a == 0)
					cols[x][y] = true;
				else if (a == 1)
					rows[x][y] = true;

			} else if (b == 1) { // 설치
				if (a == 0 && checkCols(x, y)) { // 기둥 설치
					cols[x][y] = true;
					cnt++;
				} else if (a == 1 && checkRows(x, y)) { // 보 설치
					rows[x][y] = true;
					cnt++;
				}
			}
		}

		int[][] answer = new int[cnt][3];
		int temp = 0;
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (cols[i][j])
					answer[temp++] = new int[] { i - 1, j - 1, 0 };
				if (rows[i][j])
					answer[temp++] = new int[] { i - 1, j - 1, 1 };
			}
		}

		return answer;
	}

	static boolean checkCols(int x, int y) {
		return y == 1 || rows[x - 1][y] || rows[x][y] || cols[x][y - 1];
	}

	static boolean checkRows(int x, int y) {
		return cols[x][y - 1] || cols[x + 1][y - 1] || (rows[x + 1][y] && rows[x - 1][y]);
	}

	static boolean checkDelete(int x, int y, int n) {
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (cols[i][j] && !checkCols(i, j))
					return false;
				if (rows[i][j] && !checkRows(i, j))
					return false;
			}
		}
		return true;
	}

}