package week06;

import java.util.*;

/*
 * 백준 순열의 순서 - 팩토리얼, DP
 * https://www.acmicpc.net/problem/1722
 */

public class BOJ1722 {
	static int n, flag, cnt=0;
	static long k;
	static long[] fac = new long[21];
	static boolean[] visit = new boolean[21];
 	static int[] arr, result, input;
	static boolean print;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		arr = new int[n];
		result = new int[n];
		flag = scanner.nextInt();
		
		fac[0] = 1;
		for(int i=1; i<=20; i++) //팩토리얼 구하기
            fac[i] = fac[i-1]*i;
		
		if(flag==1) {
			k = scanner.nextLong();
			for(int i=0; i<n; i++) { // i는 지금까지 확정된 숫자의 개수
				for(int j=1; j<=n; j++) { // j는 배열의 요소가 될 숫자들
					if(visit[j]) continue;
					if(fac[n-i-1]<k) k-= fac[n-i-1];
					else {
						arr[i] = j;
						visit[j] = true;
						break;
					}
				}
			}
			for(int i:arr) System.out.print(i + " ");
		}
		else {
			for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
			
			long ans = 1;
			for(int i=0; i<n; i++) { // 입력 배열의 길이만큼 탐색
				for(int j=1; j<arr[i]; j++) {
					if(!visit[j]) ans += fac[n-i-1];
				}
				visit[arr[i]] = true;
			}
			System.out.print(ans);
		}
	}
}
