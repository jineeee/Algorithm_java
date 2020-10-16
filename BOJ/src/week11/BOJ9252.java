package week11;

import java.util.Scanner;

/*
 * 문자열
 * https://www.acmicpc.net/problem/9252
 */

public class BOJ9252 {

	static Seq[][] dp;
	static char[] string1, string2;
	static boolean[][] visit;

	static class Seq {
		int cnt;
		String s = "";

		public Seq(int cnt, String s) {
			this.cnt = cnt;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		string1 = sc.next().toCharArray();
		string2 = sc.next().toCharArray();
		dp = new Seq[string1.length][string2.length];
		visit = new boolean[string1.length][string2.length];
		for (int i = 0; i < string1.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = new Seq(0, "");
			}
		}
		Seq result = LCS(string1.length - 1, string2.length - 1);
		System.out.print(result.cnt + "\n" + result.s);
	}

	static Seq LCS(int x, int y) {
		if (x == -1 || y == -1)
			return new Seq(0, "");

		if (!visit[x][y]) {

			visit[x][y] = true;
			if (string1[x] == string2[y]) {
				dp[x][y].cnt = LCS(x - 1, y - 1).cnt + 1;
				dp[x][y].s = LCS(x - 1, y - 1).s + String.valueOf(string1[x]);
			} else {
				if (LCS(x - 1, y).cnt >= LCS(x, y - 1).cnt) {
					dp[x][y].cnt = LCS(x - 1, y).cnt;
					dp[x][y].s = LCS(x - 1, y).s;
				} else {
					dp[x][y].cnt = LCS(x, y - 1).cnt;
					dp[x][y].s = LCS(x, y - 1).s;
				}
			}
		}
		return dp[x][y];
	}
}
