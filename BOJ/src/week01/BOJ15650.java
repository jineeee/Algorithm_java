package week01;

import java.util.*;

/*
 * 백준 N과 M 2 - 순열
 * https://www.acmicpc.net/problem/15650
 */

public class BOJ15650 {
	static int[] result;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		result = new int[m];
		visit = new boolean[n+1];
		permu(n, m, 0);
	}
	
	static void permu(int n, int m, int current) {
		if(current==m) {
			for(int i : result) System.out.print(i + " ");
			System.out.println();
		} else {
			for(int i=1; i<=n; i++) {
				if(visit[i]) continue;
				result[current] = i;
				if(current-1>=0 && result[current]<=result[current-1]) continue;
				visit[i] = true;
				permu(n, m, current+1);
				visit[i] = false;	
			}
		}
	}
}
