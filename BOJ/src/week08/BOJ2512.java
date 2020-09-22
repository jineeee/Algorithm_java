package week08;

import java.util.Scanner;

/*
 * 예산 - 이진탐색
 * https://www.acmicpc.net/problem/2512
 */

public class BOJ2512 {
	static int N;
	static long M;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long s=1, e=0, m=0, ans=0;
		N = scanner.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
			e = Math.max(e, arr[i]);
		}
		M = scanner.nextLong();
		
		while(s<=e) {
			m = (s+e)/2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]>=m) sum+=m;
				else sum+=arr[i];
			}
			
			if(sum==M) {
				ans=m;
				break;
			} else if(sum<M) {
				ans=Math.max(ans, m);
				s=m+1;
			} else e=m-1;
		}
		System.out.print(ans);
	}
}
