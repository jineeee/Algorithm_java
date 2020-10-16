package week11;

import java.util.*;

/*
 * 문자열, dp
 * https://www.acmicpc.net/problem/9251
 */

public class BOJ9251 {

	static Integer[][] dp;
	static char[] string1, string2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		string1 = sc.next().toCharArray();
		string2 = sc.next().toCharArray();
		dp = new Integer[string1.length][string2.length];
		System.out.print(LCS(string1.length - 1, string2.length - 1));
	}

	static int LCS(int x, int y) {
		if (x == -1 || y == -1)
			return 0;

		if (dp[x][y] == null) {

			if (string1[x] == string2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			} else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}
		return dp[x][y];
	}

}
