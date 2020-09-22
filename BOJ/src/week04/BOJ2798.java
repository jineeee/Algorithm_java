package week04;

import java.util.*;

/*
 * 백준 블랙잭 - 조합
 * https://www.acmicpc.net/problem/2798
 */

public class BOJ2798 {
	static int n, m, max = -1;
	static int[] card;
	static int[] result = new int[3];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		card = new int[n];
		for(int i=0; i<n; i++) {
			card[i] = scanner.nextInt();
		}
		combi(0, 0);
		System.out.println(max);
	}
	
	static void combi(int current, int start) {
		if(current==3) {
			int temp = 0;
			for(int i:result) temp+=i;
			if(temp>m) return;
			max = Math.max(temp,max);
 		}else {
			for(int i=start; i<card.length; i++) {
				result[current] = card[i];
				combi(current+1, i+1);
			}
		}
	}
}
