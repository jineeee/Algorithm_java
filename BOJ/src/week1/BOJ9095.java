package week1;

import java.util.*;

/*
 * 백준 1,2,3 더하기 - 재귀, 중복 조합
 * https://www.acmicpc.net/problem/9095
 */
public class BOJ9095 {
	static int count;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] result;
		while(T-->0) {
			int n = scanner.nextInt();
			result = new int[n];
			count = 0;
			for(int i=1; i<=n; i++) {
				combi(n, i, 0, result);
			}
			System.out.println(count);
		}
	}

	static public void combi(int t, int len, int current, int[] result) {
		if(current == len) {
			int sum=0;
			for(int i=0; i<len; i++) sum +=result[i];
			if(sum==t) count++;
		}else {
			for(int i=1; i<=3; i++) {
				result[current] = i;
				combi(t, len, current+1, result);
			}
		}
	}
}
