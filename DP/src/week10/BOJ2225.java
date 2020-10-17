package week10;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * dp
 * https://www.acmicpc.net/problem/2225
 */

public class BOJ2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);

		solution(n, k);
	}

	static public void solution(int n, int k) {
		int[][] dp = new int[201][201];
		for (int i = 1; i <= k; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
			}
		}
		System.out.println(dp[k][n]);
	}
}
