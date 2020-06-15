package week6;

import java.util.*;

/*
 * 백준 안녕 - 완전탐색, 브루스포스
 * https://www.acmicpc.net/problem/1535
 */

public class BOJ1535 {
	static int n, sPhys, sJoy, ans=Integer.MIN_VALUE;
	static int[] phys, joy, people;
	static int[] result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		people = new int[n];
		for(int i=0; i<n; i++) people[i] = i;
		phys = new int[n];
		joy = new int[n];
		for(int i=0; i<n; i++) phys[i] = scanner.nextInt();
		for(int i=0; i<n; i++) joy[i] = scanner.nextInt();
		for(int i=0; i<=n; i++) {
			result = new int[i];
			combi(i, 0, 0);
		}
		System.out.println(ans);
	}
	
	static void combi(int len, int current, int start) {
		if(current==len) {
			sPhys=100; sJoy=0;
			for(int i=0; i<result.length; i++) {
				sPhys -= phys[result[i]];
				sJoy += joy[result[i]];
			}
			if(sPhys<=0) return;
			ans = Math.max(ans, sJoy);
		}else {
			for(int i=start; i<n; i++) {
				result[current] = people[i];
				combi(len, current+1, i+1);
			}
		}
	}
}
