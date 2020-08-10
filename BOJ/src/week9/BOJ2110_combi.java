package week9;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 공유기 - 조합(시간초과)
 * https://www.acmicpc.net/problem/2110
 */

public class BOJ2110_combi {
	static int n, c, ans=Integer.MIN_VALUE;
	static int[] home, result;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		c = scanner.nextInt();
		home = new int[n];
		result = new int[c];
		for(int i=0; i<n; i++) home[i] = scanner.nextInt();
		combi(c, 0, 0);
		System.out.print(ans);
	}

	static void combi(int r, int current, int start) {
		if(r==current) {
			int min = Integer.MAX_VALUE;
			Arrays.sort(result);
			for(int i=r-1; i>0; i--) min = Math.min(result[i]-result[i-1], min);
			ans = Math.max(ans, min);
		}else {
			for(int i=start; i<home.length; i++) {
				result[current] = home[i];
				combi(r, current+1, i+1);
			}
		}
	}
}
