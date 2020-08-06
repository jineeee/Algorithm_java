package week8;

import java.io.*;
import java.util.*;

/*
 * 랜선 자르기 - 이분 탐색
 * https://www.acmicpc.net/problem/1654
 */

public class BOJ1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		
		// s를 0으로 하면 m이 0이 되어서 by zero 에러가 나므로 조심!
		// 범위 확인하고 int / long 구분해서 쓰기!
		long s=1, e=0, m=0, ans=0;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			e = Math.max(e, arr[i]);
		}
		
		while (s<=e) {
			m = (s+e)/2;
			int sum = 0;
			for(int i : arr) sum += i/m;
			if(sum<n) e = m-1;
			else {
				ans = Math.max(ans, m);
				s = m+1;
			}
		}
		System.out.print(ans);
	}
}
