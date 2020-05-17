package week1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 N과 M - 순열
 * https://www.acmicpc.net/problem/15649
 */

public class BOJ15649 {
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
				if(!visit[i]) {
					result[current] = i;
					visit[i] = true;
					permu(n, m, current+1);
					visit[i] = false;
				}
				
			}
		}
	}
}
