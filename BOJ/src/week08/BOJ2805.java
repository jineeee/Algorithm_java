package week08;

import java.util.Scanner;

/*
 * 나무 자르기 - 이진 탐색
 * https://www.acmicpc.net/problem/2805
 */

public class BOJ2805 {
	static long N, M;
	static long[] tree;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextLong();
		M = scanner.nextLong();
		tree = new long[(int) N];
		long s=1, e=0, m=0, ans=Long.MAX_VALUE, minSum=Long.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			tree[i] = scanner.nextLong();
			e = Math.max(e, tree[i]);
		}
		
		while(s<=e) {
			m=(s+e)/2;
			long sum = 0;
			for(int i=0; i<N; i++) if(tree[i]>=m)sum += tree[i]-m;
			if(sum==M) {
				ans = m;
				break;
			} else if(sum>M) {
				if(sum<minSum) ans = m;
				minSum = Math.min(sum, minSum);
				s = m+1;
			} else e = m-1;
		}
		
		if(ans==Long.MAX_VALUE) System.out.print(0);
		else System.out.print(ans);
	}

}
