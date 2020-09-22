package week05;

import java.util.*;

/*
 * 백준 부분수열의 합 - 조합
 * https://www.acmicpc.net/problem/1182
 */

public class BOJ1182 {
	static int n, s, cnt=0;
	static int[] num, result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		s = scanner.nextInt();
		num = new int[n];
		for(int i=0; i<n; i++) num[i] = scanner.nextInt();
		for(int i=1; i<=n; i++) {
			result = new int[i];
			combi(0, 0, i);
		}
		System.out.print(cnt);
	}
	
	static void combi(Integer start, int current, int len) {
		if(current==len) {
			int temp = 0;
			for(int i:result) temp+=i;
			if(temp==s) cnt++;
		}else {
			for(int i=start; i<num.length; i++) {
				result[current] = num[i];
				combi(i+1, current+1, len);
			}
		}
	}
}
